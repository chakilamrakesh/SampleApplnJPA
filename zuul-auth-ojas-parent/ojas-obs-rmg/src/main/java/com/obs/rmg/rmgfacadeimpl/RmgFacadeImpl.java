package com.obs.rmg.rmgfacadeimpl;

import static com.obs.rmg.rmgconstants.RmgUtilConstants.ACCEPTED;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.DELETE;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.GENERIC;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.GETALL;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.GETBYID;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.GETBYPROJECTID;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.GETEMPIDBYSKILLS;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.GETEMPIDBYSTATUS;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.GETPROJECTS;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.PENDING;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.PROPOSAL;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.REJECTED;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.SAVE;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.SPECIFIC;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.UPDATE;
import static com.obs.rmg.rmgconstants.RmgUtilConstants.RELEASE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.obs.rmg.rmgdao.RmgDao;
import com.obs.rmg.rmgdao.RmgGenericRepository;
import com.obs.rmg.rmgdao.RmgGenericResourceMapRepository;
import com.obs.rmg.rmgdao.RmgSpecificRepository;
import com.obs.rmg.rmgfacade.RmgFacade;
import com.obs.rmg.rmgmodel.EmpInfo;
import com.obs.rmg.rmgmodel.RMG;
import com.obs.rmg.rmgmodel.RmgEmployeeList;
import com.obs.rmg.rmgmodel.RmgGeneric;
import com.obs.rmg.rmgmodel.RmgGenericResourceMap;
import com.obs.rmg.rmgmodel.RmgSpecific;
import com.obs.rmg.rmgrequest.RmgRequest;
import com.obs.rmg.rmgresponse.RmgResponse;

@Service
public class RmgFacadeImpl implements RmgFacade {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager manager;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private RmgDao rmgDao;

	@Autowired
	private RmgGenericRepository rmggenrepo;

	@Autowired
	private RmgSpecificRepository rmgspecificrepo;

	@Autowired
	private RmgGenericResourceMapRepository rmggenericresourcerepo;

	@Autowired
	private Environment env;

	RmgResponse response = null;
	
	@Override
	public ResponseEntity<Object> setRmg(RmgRequest rmgRequest) {

		
		int a = 0;

		if (rmgRequest.getTransactiontype().equalsIgnoreCase(SAVE)) 
		{
			response = new RmgResponse();
			RMG rmgList = rmgRequest.getRmgInfo();

			if (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(SPECIFIC)) 
			{

				Set<RmgSpecific> rmgSpecificList = rmgRequest.getRmgSpecificList();
				rmgList.setRmgspecific(rmgSpecificList);

			}

			if (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(GENERIC)) 
			{
				for (RmgGeneric gen : rmgRequest.getRmgGenericList()) {

					for (RmgGenericResourceMap rmgMap : gen.getRmggenericresourcemap()) {
						rmgMap.setRmggeneric(gen);

					}
				}
				rmgList.setRmggeneric(rmgRequest.getRmgGenericList());

			}

			   RMG save = rmgDao.save(rmgList);

				sendmail(rmgRequest);
			 

			if (save != null) 
			{
				response.setStatusCode("200");
				response.setMessage("Resources Added successfully");
				response.setRmg(rmgList);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} 
			else 
			{
				response.setStatusCode("409");
				response.setMessage("Resources not Added");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);

			}

		}

		if (rmgRequest.getTransactiontype().equalsIgnoreCase(UPDATE)) 
		{
			
			response = new RmgResponse();

			RMG rmgList = rmgRequest.getRmgInfo();

			if (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(SPECIFIC)) 
			{

				Set<RmgSpecific> rmgSpecificList = rmgRequest.getRmgSpecificList();

				rmgList.setRmgspecific(rmgSpecificList);
				 System.out.println("rmg list" +rmgSpecificList);

				for (RmgSpecific spec : rmgSpecificList) 
				{

					int id = spec.getSpecificId();

					RmgSpecific rm = rmgspecificrepo.getOne(id);

					rm.setReason(spec.getReason());
					rm.setSpecificStatus(spec.getSpecificStatus());
					rm.setAlternateemployeeId(spec.getAlternateemployeeId());
					rm.setFlag(spec.getFlag());
					rmgspecificrepo.save(rm);

					RMG rmg = rmgDao.getOne(rmgRequest.getRmgInfo().getBookingId());
					rmg.setResourceType(rmgRequest.getRmgInfo().getResourceType());
					rmg.setStatus(rmgRequest.getRmgInfo().getStatus());

					rmgDao.save(rmg);

					response.setRmgSpecificList(rm);
					
					
					

				}

			}

			if (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(GENERIC)) {
				for (RmgGeneric gen : rmgRequest.getRmgGenericList()) {
					int gid = gen.getGenericId();

					RmgGeneric rmgeneric = rmggenrepo.getOne(gid);


					rmggenrepo.save(rmgeneric);

					response.setRmgGenericList(rmgeneric);

					for (RmgGenericResourceMap rmgMap : gen.getRmggenericresourcemap()) {

						rmgMap.setRmggeneric(gen);

						int id = gen.getGenericId();

						RmgGeneric rg = rmggenrepo.getOne(id);
						RmgGenericResourceMap rmap = new RmgGenericResourceMap();

						rmap.setEmpId(rmgMap.getEmpId());
						rmap.setStartDate(rmgMap.getStartDate());
						rmap.setEndDate(rmgMap.getEndDate());
						rmap.setFlag(rmgMap.getFlag());
						rmap.setGenericStatus(ACCEPTED);
						rmap.setRmggeneric(rg);

						rmggenericresourcerepo.save(rmap);
						response.setRmgGenericResourceList(rmgMap);

					}

				}

				rmgList.setRmggeneric(rmgRequest.getRmgGenericList());

				RMG rmg = rmgDao.getOne(rmgRequest.getRmgInfo().getBookingId());
				rmg.setResourceType(rmgRequest.getRmgInfo().getResourceType());
				rmg.setStatus(rmgRequest.getRmgInfo().getStatus());

				rmgDao.save(rmg);



			}

			sendmailupdate(rmgRequest);

			if (rmgList.getBookingId() != 0) {

				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.setStatusCode("409");
				response.setMessage("failed to update");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);

			}

		}
		

		if (rmgRequest.getTransactiontype().equalsIgnoreCase(DELETE)) {
			response = new RmgResponse();
			RMG rmgList = rmgRequest.getRmgInfo();

			RMG rmg = rmgDao.getOne(rmgList.getBookingId());

			rmg.setFlag(!rmg.getFlag());
			rmgDao.save(rmg);

			if (rmg.getBookingId() != 0) {
				response.setStatusCode("200");
				response.setMessage("Rmg details deleted successfully");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.setStatusCode("409");
				response.setMessage("failed to delete");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);

			}

		}
		
		
		if (rmgRequest.getTransactiontype().equalsIgnoreCase(RELEASE))
		{
			response = new RmgResponse();
			RMG rmgList = rmgRequest.getRmgInfo();

			
			
			if(rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(SPECIFIC))
			{
				Set<RmgSpecific> rs=rmgRequest.getRmgSpecificList();
				
				for(RmgSpecific rmgspec:rs)
				{
					setEmpIdStatus(rmgspec.getEmployeeId(),rmgspec.getSpecificEmployeeStatus());
					RmgSpecific rm = rmgspecificrepo.getOne(rmgspec.getSpecificId());
					rm.setFlag(rmgspec.getFlag());
					rmgspecificrepo.save(rm);
					
		
				}
			
			}
			if(rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(GENERIC))
			{
				
				
				for(RmgGeneric gen : rmgRequest.getRmgGenericList())
				{
					setEmpIdgenericStatus(gen.getRmggenericresourcemap());
					
					for (RmgGenericResourceMap rmgMap : gen.getRmggenericresourcemap()) 
					{
						
						RmgGenericResourceMap rg = rmggenericresourcerepo.getOne(rmgMap.getResourcegenericId());
						rg.setFlag(rmgMap.getFlag());
						rmggenericresourcerepo.save(rg);
					}
					
				}
			
			}
	
			if (rmgList.getBookingId() != 0) {
				response.setStatusCode("200");
				response.setMessage("Resource Released");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.setStatusCode("409");
				response.setMessage("Failed to Relesae Resource");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);

			}

		}


		return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	
	


	@Override
	public ResponseEntity<Object> getRmg(RmgRequest rmgRequest) {

		RmgResponse response = null;
		List<RMG> getAll = new ArrayList<>();
		RMG rmg = null;

		if (rmgRequest.getTransactiontype().equalsIgnoreCase(GETALL)) {
			getAll = rmgDao.findAll();
			if (!getAll.isEmpty()) {
				response = new RmgResponse();
				response.setRmgInfo(getAll);
				response.setMessage("success");
				response.setStatusCode("200");

				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}

		if (rmgRequest.getTransactiontype().equalsIgnoreCase(GETEMPIDBYSKILLS)) {
			List<String> getskills = getEmpIdsBySkillId(rmgRequest.getSkilllist().getResourceSkills(),
					rmgRequest.getSkilllist().getResourceExperience());
		

			if (!getskills.isEmpty()) {
				response = new RmgResponse();
				response.setEmpIdList(getskills);
				response.setMessage("success");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}
		
		if (rmgRequest.getTransactiontype().equalsIgnoreCase(GETEMPIDBYSTATUS)) 
		{
			
			List<RmgEmployeeList> getEmployees = rmgDao.getEmpIdsByStatus();

			if (!getEmployees.isEmpty()) 
			{
				response = new RmgResponse();
				response.setRmgemployeelist(getEmployees);
				response.setMessage("success");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}

		if (rmgRequest.getTransactiontype().equalsIgnoreCase(GETPROJECTS)) {
			List<String> getprojects = getProjectListByEmpId(rmgRequest.getProjectlist().getEmpId());

			if (!getprojects.isEmpty()) {
				response = new RmgResponse();
				response.setEmpIdList(getprojects);
				response.setMessage("success");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}
		
	
		if (rmgRequest.getTransactiontype().equalsIgnoreCase(GETBYID)) {

			rmg = rmgDao.getOne(rmgRequest.getRmgInfo().getBookingId());

			if (rmg.getBookingId() != 0) {
				response = new RmgResponse();
				response.setRmg(rmg);
				response.setMessage("success");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);

			}
			
			
		}
		
		if (rmgRequest.getTransactiontype().equalsIgnoreCase(GETBYPROJECTID)) {

			List<RMG> rmglist = rmgDao.getByprojectId(rmgRequest.getRmgInfo().getProjectId());

			if (rmglist != null) {
				response = new RmgResponse();
				response.setRmgInfo(rmglist);
				response.setMessage("success");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);

			}
	}
		
		
		if (getAll.isEmpty() || rmg == null) {
			response = new RmgResponse();
			response.setMessage("No records found");
			response.setStatusCode("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	

	private List<String> getEmpIdsBySkillId(List<String> list, Double exp) {

		List<String> result = new ArrayList<String>();

		String queryParams = getStringQueryParameter(list);

		String queryStrs = "select DISTINCT(e.employee_id) from  ojas_obs.obs_employeeskilldetails e join "
				+ "ojas_obs.obs_experiencedetails p on  e.employee_id=p.employee_id   join "
				+ " obs_rmg.rmg_employee_list ei on ei.employee_id=p.employee_id where ei.employment_status='Bench' or ei.employment_status='Lateral' and"
				+ " e.skill_id in(" + queryParams + ") and p.experience = " + exp + "";

		Query query = manager.createNativeQuery(queryStrs);

		result = query.getResultList();
		
		return result;

	}

	private String getStringQueryParameter(List<String> list) 
	{

		String queryParams = "\"";

		Iterator<String> iter = list.iterator();
		int i = 0;

		while (iter.hasNext()) {
			if (i != list.size()) {

				queryParams = queryParams + iter.next() + "\",\"";

			} else {

				queryParams = queryParams + "\"" + iter.next();

			}
			i++;
		}
		return queryParams = queryParams.substring(0, queryParams.length() - 2);

	}

	public DataSource getDataSource() 
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty("spring.datasource.url"));
		driverManagerDataSource.setUsername(env.getProperty("spring.datasource.username"));
		driverManagerDataSource.setPassword(env.getProperty("spring.datasource.password"));
		driverManagerDataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		return driverManagerDataSource;
	}


	
	private List<String> getProjectListByEmpId(String emp) 
	{
		List<String> result = new ArrayList<String>();

		String query = "(select distinct(project_id) from obs_rmg.rmg_specific spc  join obs_rmg.rmg_specific_map r on spc.specific_id=r.specific_id   \r\n"
				+ "join obs_rmg.rmg rm on r.booking_id=rm.booking_id where  spc.flag=1 and employee_id=" + emp + ") \r\n" + "union\r\n"
				+ "\r\n"
				+ "(select distinct(project_id) from obs_rmg.rmg_generic_resources_mapping gr join obs_rmg.rmg_generic_map  gm on gr.generic_id=gm.generic_id \r\n"
				+ " join  obs_rmg.rmg rr on  gm.booking_id=rr.booking_id where gr.flag=1 and emp_id=" + emp + ")ORDER BY project_id ASC";

		Query querys = manager.createNativeQuery(query);

		result = querys.getResultList();

		return result;

	}
	
	
	
	private int setEmpIdStatus(String emp,String employeestatus) 
	{
		

	    String query =  "update obs_rmg.rmg_employee_list set status_date=now(), employment_status= ? where employee_id= ?";
	    
	    int batchUpdate = jdbcTemplate.update(query, employeestatus, emp);
	    
		return batchUpdate;

	}
	
	private int[] setEmpIdgenericStatus(Set<RmgGenericResourceMap> rmgMap) 
	{
		List<Object[]> empObj = new ArrayList<>();
		for (RmgGenericResourceMap rmgGen : rmgMap) {
			Object[] emp = {rmgGen.getGenericEmployeeStatus(), rmgGen.getEmpId()};
			empObj.add(emp);
		}

	    String query =  "update obs_rmg.rmg_employee_list set status_date=now(), employment_status=?  where employee_id= ?"; 	    
		return jdbcTemplate.batchUpdate(query, empObj);

	}
	
	public boolean sendmail(RmgRequest rmgRequest) 
	{
		if (rmgRequest.getRmgInfo().getStatus().equalsIgnoreCase(PENDING) && rmgRequest.getRmgInfo().getStatus() != null)
			
		{

			String queryStr = "select distinct( officialEmail),(employee_id),CONCAT(e.firstname,' ',e.middlename,' ',e.lastname,' ') as empName "
					+ "from ojas_obs.obs_employeeinfo e join  obs_psa.resource_mapping resm \r\n"
					+ "on resm.project_manager = e.employee_id join obs_rmg.rmg rm on  resm.project_id = rm.project_id where\r\n"
					+ " rm.project_id =" + rmgRequest.getRmgInfo().getProjectId();

			Object[] args = { rmgRequest.getRmgInfo().getProjectId() };

			jdbcTemplate = new JdbcTemplate(getDataSource());
			List<EmpInfo> emp = jdbcTemplate.query(queryStr, new BeanPropertyRowMapper<EmpInfo>(EmpInfo.class));
			String[] to = emp.stream().map(x -> x.getOfficialEmail()).collect(Collectors.toList()).stream()
					.toArray(String[]::new);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(env.getProperty("spring.mail.username"));
			mailMessage.setTo(to);

			mailMessage.setSubject("Welcome to Ojas Family");

			if (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(SPECIFIC)) 
			{
				mailMessage.setText("Specific Resource Requested By " + emp.get(0).getEmpName() + " ("
						+ emp.get(0).getEmployeeId() + ')' + '\n' + '\n'
						+ "This is Auto Generated Mail please ignore it");
			}

			if (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(GENERIC)) 
			{
				mailMessage.setText("Generic Resource Requested By " + emp.get(0).getEmpName() + " ("
						+ emp.get(0).getEmployeeId() + ')' + '\n' + '\n'
						+ "This is Auto Generated Mail please ignore it");
			}

			javaMailSender.send(mailMessage);

		}
		
		return true;
		
	}
	
	
	public boolean sendmailupdate(RmgRequest rmgRequest)
	{
		
		if ((rmgRequest.getRmgInfo().getStatus().equalsIgnoreCase(PENDING)
				|| rmgRequest.getRmgInfo().getStatus().equalsIgnoreCase(REJECTED)
				|| rmgRequest.getRmgInfo().getStatus().equalsIgnoreCase(PROPOSAL))
				&& (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(SPECIFIC)
						&& rmgRequest.getRmgInfo().getStatus() != null
						&& rmgRequest.getRmgInfo().getBookingId() != 0))
		{

			String queryStr = "select distinct( officialEmail),(employee_id),CONCAT(e.firstname,' ',e.middlename,' ',e.lastname,' ') as empName from ojas_obs.obs_employeeinfo e join  obs_psa.resource_mapping resm \r\n"
					+ "on resm.project_manager = e.employee_id join obs_rmg.rmg rm on  resm.project_id = rm.project_id where\r\n"
					+ " rm.project_id =" + rmgRequest.getRmgInfo().getProjectId();

			Object[] args = { rmgRequest.getRmgInfo().getProjectId() };
			jdbcTemplate = new JdbcTemplate(getDataSource());
			List<EmpInfo> emp = jdbcTemplate.query(queryStr, new BeanPropertyRowMapper<EmpInfo>(EmpInfo.class));
			String[] to = emp.stream().map(x -> x.getOfficialEmail()).collect(Collectors.toList()).stream()
					.toArray(String[]::new);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(env.getProperty("spring.mail.username"));
			mailMessage.setTo(to);
			mailMessage.setSubject("Resource Management Group");

			if (rmgRequest.getRmgInfo().getStatus().equalsIgnoreCase(PENDING))
			{

				response.setMessage("Resource details updated successfully");
				mailMessage.setText(
						" Resource Requesting." + '\n' + '\n' + "This is Auto Generated Mail please ignore it");

			}

			if (rmgRequest.getRmgInfo().getStatus().equalsIgnoreCase(REJECTED)) 
			{

				response.setMessage("Resource Declined");
				mailMessage.setText(
						" Resource Declined." + '\n' + '\n' + "This is Auto Generated Mail please ignore it");

			}

			if (rmgRequest.getRmgInfo().getStatus().equalsIgnoreCase(PROPOSAL)) 
			{
				
				response.setMessage("New Resource Proposed");

				mailMessage.setText("Proposing for New Resource" + '\n' + '\n'
						+ "This is Auto Generated Mail please ignore it");

			}

			javaMailSender.send(mailMessage);
		}
		
		

		if (rmgRequest.getRmgInfo().getStatus().equalsIgnoreCase(ACCEPTED)
				&& rmgRequest.getRmgInfo().getStatus() != null && rmgRequest.getRmgInfo().getBookingId() != 0
				&& (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(SPECIFIC)
						|| rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(GENERIC))) 
		{

			String queryStr = "select distinct( officialEmail),(employee_id),CONCAT(e.firstname,' ',e.middlename,' ',e.lastname,' ') as empName from ojas_obs.obs_employeeinfo e join  obs_psa.resource_mapping resm \r\n"
					+ "on resm.project_manager = e.employee_id join obs_rmg.rmg rm on  resm.project_id = rm.project_id where\r\n"
					+ " rm.project_id =" + rmgRequest.getRmgInfo().getProjectId();

			Object[] args = { rmgRequest.getRmgInfo().getProjectId() };
			jdbcTemplate = new JdbcTemplate(getDataSource());
			List<EmpInfo> emp = jdbcTemplate.query(queryStr, new BeanPropertyRowMapper<EmpInfo>(EmpInfo.class));
			String[] to = emp.stream().map(x -> x.getOfficialEmail()).collect(Collectors.toList()).stream()
					.toArray(String[]::new);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(env.getProperty("spring.mail.username"));
			mailMessage.setTo(to);

			if (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(SPECIFIC)) 
			{
				List<String> empIds = rmgRequest.getRmgSpecificList().stream().map(RmgSpecific::getEmployeeId)
						.collect(Collectors.toList());

				String queryParams = getStringQueryParameter(empIds);

				String queryStr1 = "select DISTINCT(e.officialEmail) from  ojas_obs.obs_employeeinfo e where e.employee_id in ("
						+ queryParams + ")";

				Query query = manager.createNativeQuery(queryStr1);

				List<String> emails = query.getResultList();

				String[] emailsCC = emails.toArray(new String[0]);

				mailMessage.setCc(emailsCC);
				
				mailMessage.setText("Specific Resource Accepted." + '\n' + '\n' + "This is Auto Generated Mail please ignore it");
				
				response.setMessage("Specific Resource Accepted");
				
				Set<RmgSpecific> rmgSpecificList = rmgRequest.getRmgSpecificList();
			
				for(RmgSpecific spec: rmgSpecificList)
				{
				  setEmpIdStatus(spec.getEmployeeId(),spec.getSpecificEmployeeStatus());
				}
				
				
			}
			
			if (rmgRequest.getRmgInfo().getResourceType().equalsIgnoreCase(GENERIC))
			{

				List<String> empIds = rmgRequest.getRmgGenericList().stream()
						.flatMap(
								rrm -> rrm.getRmggenericresourcemap().stream().map(RmgGenericResourceMap::getEmpId))
						.collect(Collectors.toList());

				String queryParams = getStringQueryParameter(empIds);

				String queryStr1 = "select DISTINCT(e.officialEmail) from  ojas_obs.obs_employeeinfo e where e.employee_id in ("
						+ queryParams + ")";

				Query query = manager.createNativeQuery(queryStr1);

				List<String> emails = query.getResultList();

				String[] emailsCC = emails.toArray(new String[0]);

				mailMessage.setCc(emailsCC);
				
				mailMessage.setText("Generic Resources Allocated." + '\n' + '\n' + "This is Auto Generated Mail please ignore it");
				
				response.setMessage("Generic Resources Allocated");
				
				Set<RmgSpecific> rmgSpecificList = rmgRequest.getRmgSpecificList();
				
				for(RmgGeneric gen : rmgRequest.getRmgGenericList())
				{
					setEmpIdgenericStatus(gen.getRmggenericresourcemap());
				
				}
			
				
			}
	
			mailMessage.setSubject("Resource Managment Group");

			javaMailSender.send(mailMessage);

		}
		return true;
	}
	

}
