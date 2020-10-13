import { RmgService } from './../../services/rmg.service';
// Murali A

import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl, AbstractControl } from '@angular/forms';
import { throwMatDialogContentAlreadyAttachedError } from '@angular/material';
import { HrmsService } from '../../services/hrms.service';
import { BehaviorSubject, Observable, Subscription, Subject } from 'rxjs';
import swal from 'src/assets/sweetalert';
import { inputs } from '@syncfusion/ej2-angular-navigations/src/accordion/accordion.component';
import { takeUntil, filter } from 'rxjs/operators';
import { PsaService } from '../../services/psa.service';
import { NotificationService } from 'src/app/services/toastr-notification/toastr-notification.service';
import { AuthService } from 'src/app/services/auth.service';



@Component({
  selector: 'app-project-psa',
  templateUrl: './project-psa.component.html',
  styleUrls: ['./project-psa.component.scss']
})
export class ProjectPSAComponent implements OnInit {

  private projectAll: Subject<any> = new Subject();


  projectData;
  dataProject;
  getId: any;
  getIdData: any;
  hideToEdit = true;
  tblupdate = true;
  editTo = true;
  updateResponse: any;
  customer: any;
  customerData: any;
  customerId: any;
  contract: any;
  contractData: any;


  contractFilter: any;
  locTypes: any;
  loc;
  delivery: any;
  deliveryLoc: any;
  serviceCat: any;
  serviceCategoryList: any;
  serv: any;
  serviceTypes: any;
  billingTypeList: any;
  billingTypes;
  rateTypes: any;
  rateTypeList: any;
  techStackResp: any;
  techStacks: any;
  task: any;
  taskList: any;
  saveSuccess: any;
  contractDisable = true;
  contractDisableToTable = true;
  cus: any;
  contractIdGet: any;
  contractId: any;

  contractTableID: any;
  minStartDate: Date;
  maxStartDate: Date;
  minEndDate: Date;
  maxEndDate: Date;
  contr: any;
  contractDataTo: any;
  disableDate = true;
  procon: any;
  contractPro: any;
  countValue: any;
  contractValue: any;
  valueToShow;
  showBalance = false;
  greenShow = false;
  redShow = false;
  valueContract: any;
  show = true;
  onShow = false;
  business: any;
  businessUnit: any;
  subBusiness: any;
  subBusinessUnit: any;
  empbasic: any;
  empbasicin: any;
  loggedUserName;
  msgApprove: any;
  msg: any;
  msgdelete: any;
  manager: any[];
  employee: any[];
  managerdata = [];
  empDesignationDetails: any;
  empDesignationlist: any;
  ipppd = 5;
  empObjTech;
  errorContract = false;
  reason: any;
  reasonForBU = false;
  custId: any;
  contId: any;
  role: boolean;

  roleEdit: boolean;
  roleStatus: boolean;
  roleFinance: boolean;
  cusconeditHide = false;
  dataTo: any;
  customerDataToShow: any;
  customerserviceName: any;
  encryptedUsername: string;
  encryptedRole: string;
  role1: any;
  errorToEnter: boolean = false;
  editprojectvalue: any;
  empsorteddata: any;
  mapresourceData: any = [];
  internalNgModel: any;
  isCustomer: boolean = false;
  isNotCustomer: boolean = false;
  editIsNotCustomer: boolean;
  editIsCustomer: boolean;
  projectTypedata: any;
  techlead: any;
  managers: any[];
  buHead: any;
  sbuHead: any;
  contractbuHead: any;
  contractsbuHead: any;
  originalData: any[];
  rmgdata: any[];
  mappedMessage: boolean;
  rmgresource: any = [];


  constructor(private authService: AuthService, private formBuild: FormBuilder, private psaService: PsaService, private hrms: HrmsService, private toast: NotificationService, private rmgService: RmgService) {
    //this.getIdcontract();
  }

  ngOnInit() {
    this.encryptedRole = sessionStorage.getItem('Role');
    this.role1 = this.authService.decryptData(this.encryptedRole);
    this.getAllCustomer();
    this.getAllContract();

    this.getHide();
    this.user();

    this.getresources();
    // this.loggedUserName = sessionStorage.getItem('UserName');

    this.encryptedUsername = sessionStorage.getItem('UserName');
    this.loggedUserName = this.authService.decryptData(this.encryptedUsername);

    // this.getIdData = JSON.parse(sessionStorage.getItem('moreInfo'));
    if (this.getIdData != null) {
      this.disableDate = true;
      //  this.getContractId(this.getIdData.contractId);
    }
  }

  ngOnDestroy(): any {
    this.projectAll.next();
    this.projectAll.complete();
  }

  user() {
    if (this.role1 == "ROLE_DM" || this.role1 == "ROLE_BDM" || this.role1 == "ROLE_BDMHEAD" || this.role1 == "ROLE_ADMIN" || this.role1 == "ROLE_STAFFAUGHEAD" || this.role1 == "ROLE_SALES" || this.role1 == "ROLE_SBUHEAD") {
      this.role = true;
      this.roleEdit = true;
      this.getLocationType();
      this.getDelivaryLoc();
      this.getServiceCategory();
      this.getServiceType();
      this.getBillingType();
      this.getRateType();
      this.getTechStack();
      this.getTasks();
      this.getBusinessUnit();
      this.getSubBusinessUnit();
      this.getEmpDesignation();
      this.getProjectTypes();

      this.getAllContract();
      this.getAllCustomer();

      this.getAllProject();
      this.getAllEmployees();
    }
    if (this.role1 == "ROLE_BUHEAD") {
      this.roleStatus = true;
      this.getAllContract();
      this.getAllCustomer();
      this.getAllProject();
      this.getAllEmployees();

    }
    if (this.role1 == "ROLE_FINANCE") {
      this.roleFinance = true;
      this.getAllContract();
      this.getAllCustomer();
      this.getAllProject();
      this.getAllEmployees();

    }
    else {
      this.getAllContract();
      this.getAllCustomer();
      this.getAllProject();
      this.getAllEmployees();

    }
  }


  project = this.formBuild.group({
    customerChange: [null, Validators.required],
    contractChange: [null, Validators.required],
    projectName: [null, Validators.required],
    projectDescription: [null, Validators.required],
    projectStartDate: [null, Validators.required],
    projectEndDate: [null, Validators.required],
    projectManager: [null, Validators.required],
    projectTechnicalLead: [null, Validators.required],
    projectValue: ['', [Validators.required, (control: AbstractControl) => Validators.max(this.valueToShow)(control), Validators.min(0)]],
    serviceType: [null, Validators.required],
    billingType: [null, Validators.required],
    rateType: [null, Validators.required],
    projectTechStack: [null, Validators.required],
    serviceCategory: [null, Validators.required],
    projectType: [null, Validators.required],
    projectDelivaryLocation: [null, Validators.required],
    locationType: [null, Validators.required],
    // numberOfResources: [null, [Validators.required, (control: AbstractControl) => Validators.min(0)(control)]],
    tasks: [null, Validators.required],
    // resources: [null, Validators.required]

  })

  getHide() {
    // if (sessionStorage.getItem('hideToEdit') == "false") {
    //   this.hideToEdit = false;
    // }
    // else {
    //   this.hideToEdit = true;
    // }
  }
  dataManager: any = [];
  getAllProject() {

    var getProject = {
      "projectInfo": {
      },
      "transactionType": "getall"
    }


    this.psaService.getAllProject(getProject).pipe(takeUntil(this.projectAll)).subscribe(response => {
      // if(response){
      //   this.getAllCustomer();
      //   this.getAllContract();
      // }
      this.projectData = response;
      this.dataTo = this.projectData.projectList;
      // console.log("contract data in project", this.dataTo);


      // for (let i = 0; i < this.dataTo.length; i++) {

      //   this.dataTo[i].customerId = this.getCustomerName(this.dataTo[i].customerId)
      //   this.dataTo[i].contractId = this.getContractName(this.dataTo[i].contractId)

      // }
      if (this.role1 == "ROLE_MANAGER") {

        this.getAllEmployees();

        this.dataProject = this.dataTo.filter(info => info.projectResourceMapping.projectManager == this.loggedUserName);
        // console.log("projectDATA Manager", this.dataProject);

      }

      else {

        this.dataProject = this.dataTo;
        // console.log("projectDATA", this.dataProject);

      }

      for (let i = 0; i < this.dataTo.length; i++) {
        this.dataTo[i].contractId = this.getContractName(this.dataTo[i].contractId)

        this.dataTo[i].customerId = this.getCustomerName(this.dataTo[i].customerId)
      }


    })
  }

  getCustomerName(idCustomer) {

    let custName = this.customerData.find(data => data.customerId == idCustomer)
    return custName.customerName
  }

  getContractName(idContract) {

    let contractName = this.contractData.find(data => data.contractid == idContract)
    return contractName.contractname
  }


  moreinfo(id) {

    var getID = {
      "projectInfo": {
        "projectId": id
      },
      "transactionType": "getByProId"
    }

    this.psaService.getIdProject(getID).pipe(takeUntil(this.projectAll)).subscribe(response => {
      this.getId = response;

      // sessionStorage.setItem('hideToEdit', "false");
      // this.getHide();
      this.hideToEdit = false;
      this.getIdData = this.getId.projectList[0];

      this.getNameBUSBU(this.getIdData.projectResourceMapping.projectManager, this.getIdData.projectResourceMapping.techLead, this.getIdData.buHead, this.getIdData.sbuHead)

      this.editprojectvalue = this.getIdData.projectRatecard.projectValue;

      // sessionStorage.setItem('moreInfo', JSON.stringify(this.getIdData));
      console.log("selected data of project", this.getIdData);
      console.log("Location types : ", this.locTypes);

      this.getContractId(this.getIdData.contractId);

      this.disableDate = false;

      this.getProjectContractID(this.getIdData.contractId);

      this.show = true;
      this.onShow = false;

      if (this.getIdData.projectType == "Customer" || this.getIdData.projectType == "customer") {
        this.editIsCustomer = true;
      }
      else {
        this.editIsNotCustomer = true;
      }

      if (this.getIdData.buStatus == "Approved" || this.getIdData.buStatus == "Pending") {
        this.reasonForBU = false;
      }
      if (this.getIdData.buStatus == "Approved" || this.getIdData.buStatus == "Rejected" && this.role1 == "ROLE_BUHEAD") {
        this.roleStatus = false;
      }
      if (this.getIdData.buStatus == "Pending" && this.role1 == "ROLE_BUHEAD") {
        this.roleStatus = true;
      }
      if (this.getIdData.buStatus == "Rejected" || this.getIdData.financeStatus == "Rejected") {

        this.reason = this.getIdData.comment;
        this.reasonForBU = true;
        console.log("Reason", this.reason);
      }
      if (this.getIdData.buStatus == "Rejected" || this.getIdData.buStatus == "Pending" && this.role1 == "ROLE_FINANCE") {
        this.roleFinance = false;
      }
      if (this.getIdData.buStatus == "Approved" && this.getIdData.financeStatus == "Pending" && this.role1 == "ROLE_FINANCE") {
        this.roleFinance = true;
      }

      if (this.getIdData.finaceStatus == "Approved" || this.getIdData.financeStatus == "Pending") {
        this.reasonForBU = false;
      }
      if (this.getIdData.financeStatus == "Approved" || this.getIdData.financeStatus == "Rejected" && this.role1 == "ROLE_FINANCE") {
        this.roleFinance = false;
      }
      this.rmgdata = this.originalData.filter(d => d.projectId == id)



      for (let k = 0; k < this.rmgdata.length; k++) {
        if (this.rmgdata[k].resourceType.toLowerCase() == "specific") {
          let resourseSpecific = this.empbasicin.filter(data => data.employeeId == this.rmgdata[k].resource.employeeId)
          if (resourseSpecific.length != 0) {
            this.rmgresource.push(resourseSpecific);

          }
        }
        else {
          let resourseGeneric = this.empbasicin.filter(data => data.employeeId == this.rmgdata[k].resource.empId)
          if (resourseGeneric.length != 0) {
            this.rmgresource.push(resourseGeneric);

          }
        }




      }
      if (this.rmgdata.length == 0) {
        console.log("nulllll");
        this.mappedMessage = true

      } else {
        this.mappedMessage = false
      }

      console.log("resources of this project", this.rmgresource);



      for (var i = 0; i < this.customerData.length; i++) {
        if (this.getIdData.customerId == this.customerData[i].customerId) {
          this.custId = this.customerData[i].customerName;
        }
      }
      for (var i = 0; i < this.contractIdGet.length; i++) {
        if (this.getIdData.contractId == this.contractIdGet[i].contractid) {
          this.contId = this.contractIdGet[i].contractname;
        }
      }







    })


  }

  getNameBUSBU(managerGet, techLead, bu, sbu) {
    // this.managerdata=[]
    this.getAllEmployees();

    this.techlead = this.empObjTech.filter(lead => lead.employeeId == techLead);
    console.log("techlead", this.techlead);

    this.managers = this.managerdata.filter(manager => manager.employeeId == managerGet);

    console.log("managers of get", this.managers);

    this.buHead = this.empbasicin.filter(emp => emp.employeeId == bu);
    console.log("bu name", this.buHead);
    this.sbuHead = this.empbasicin.filter(emp => emp.employeeId == sbu);
    console.log("sbu name", this.sbuHead);
  }
  getNames(name) {
    // console.log('ids of resources',name);


    let empinfodata = this.empbasicin.filter(names => names.employeeId == name);

    // console.log("resourse daataa", empinfodata);
    let empData = empinfodata[0].firstname + empinfodata[0].lastname
    return empData
  }
  back() {
    this.rmgresource = [];
    this.hideToEdit = true;
    this.tblupdate = true;
    this.editTo = true;
    this.getAllProject();
    // sessionStorage.removeItem('hideToEdit');
    // sessionStorage.removeItem('moreInfo');
    if (this.getIdData.status == "Approved" && this.role1 == "ROLE_BUHEAD") {
      this.roleStatus = true;
    }
    if (this.getIdData.status == "Rejected" && this.role1 == "ROLE_BUHEAD") {
      this.roleStatus = true;
    }
    this.mapresourceData = [];
  }

  formatDate(date) {
    var year = date.getFullYear().toString();
    var month = (date.getMonth() + 101).toString().substring(1);
    var day = (date.getDate() + 100).toString().substring(1);
    return year + "-" + month + "-" + day;
  }

  createProject(proDataSave) {
    this.isNotCustomer = false;
    this.isCustomer = false;

    var data = {
      "projectInfo": {
        "projectName": proDataSave.projectName,
        "projectDescription": proDataSave.projectDescription,
        "startDate": this.formatDate(new Date(proDataSave.projectStartDate)),
        "endDate": this.formatDate(new Date(proDataSave.projectEndDate)),
        "customerId": proDataSave.customerChange,
        "contractId": proDataSave.contractChange,
        "servicecategory": proDataSave.serviceCategory,
        "projectType": proDataSave.projectType,
        "deliveryLocation": proDataSave.projectDelivaryLocation,
        "locationType": proDataSave.locationType,
        "tasks": proDataSave.tasks,
        "createdBy": this.loggedUserName,
        "buHead": this.contractDataTo.buHead,
        "sbuHead": this.contractDataTo.sbuHead,
        "buStatus": "Pending",
        "financeStatus": "Pending"

      },
      "resourceMap":
      {

        // "resourceCount": proDataSave.numberOfResources,
        "projectManager": proDataSave.projectManager,
        "techLead": proDataSave.projectTechnicalLead,
        "techStack": proDataSave.projectTechStack,
        //  "resources": proDataSave.resources
      },
      "rateCard": {

        "projectValue": proDataSave.projectValue,
        "serviceType": proDataSave.serviceType,
        "billingType": proDataSave.billingType,
        "rateType": proDataSave.rateType
      },
      "transactionType": "save"
    }

    console.log("data", data);

    this.contractDisable = true;
    this.show = true;
    this.onShow = false;
    this.psaService.saveProject(data).pipe(takeUntil(this.projectAll)).subscribe(Response => {
      console.log("save data", Response);

      this.getAllProject();
      this.saveSuccess = Response;
      this.toast.success(this.saveSuccess.message, 'Success')
      this.project.reset();
    },
      err => {
        console.log(err);

        if (err) {
          this.toast.info(err.error.message, 'Info')
        }
      }
    )

  }


  //edit

  edit() {
    this.tblupdate = false;
    this.editTo = false;
    this.isCustomer = false;
    this.isNotCustomer = false;
  }

  cancel() {
    this.editTo = true;
    this.tblupdate = true;
    this.mapresourceData = [];
    this.moreinfo(this.getIdData.projectId);
    this.contractDisable = true;
    this.disableDate = true;
    this.showBalance = false;
    this.show = true;
    this.onShow = false;
    this.isCustomer = false;
    this.isNotCustomer = false;
  }

  updateproject(dataValue) {
    this.mapresourceData = [];

    var data = {
      "projectInfo": {
        "projectId": this.getIdData.projectId,
        "projectName": dataValue.projectname,
        "projectDescription": dataValue.description,
        "startDate": this.formatDate(new Date(dataValue.startdate)),
        "endDate": this.formatDate(new Date(dataValue.enddate)),
        "customerId": this.getIdData.customerId,
        "contractId": this.getIdData.contractId,
        "servicecategory": dataValue.servicecategory,
        "projectType": this.getIdData.projectType,
        "deliveryLocation": dataValue.deliverylocation,
        "locationType": dataValue.locationtype,
        "tasks": dataValue.tasks,
        "buHead": this.getIdData.buHead,
        "sbuHead": this.getIdData.sbuHead,
        "buStatus": "Pending",
        "financeStatus": "Pending",
        "createdBy": this.loggedUserName,
        "updatedBy": this.loggedUserName
      },
      "resourceMap":
      {
        "resourceMappingId": this.getIdData.projectResourceMapping.resourceMappingId,
        // "resourceCount": dataValue.resourcecount,
        "projectManager": dataValue.manager,
        "techLead": dataValue.techlead,
        "techStack": dataValue.projecttechstack,
        // "resources": dataValue.resources
      },
      "rateCard": {
        "ratecardId": this.getIdData.projectRatecard.ratecardId,
        "projectValue": dataValue.value,
        "serviceType": dataValue.servicetype,
        "billingType": dataValue.billingtype,
        "rateType": dataValue.ratetype
      },


      "transactionType": "update"
    }

    console.log("update", data);
    this.editTo = true;
    this.tblupdate = true;

    this.psaService.saveProject(data).pipe(takeUntil(this.projectAll)).subscribe(response => {
      console.log(response)
      this.updateResponse = response;
      this.getAllProject();
      this.moreinfo(this.getIdData.projectId);
      if (this.updateResponse.message == "Project updated successfully!") {
        // this.toastr.successToastr('Project updated successfully!', 'Success', {
        //   animate: 'slideFromRight',
        //   showCloseButton: true,
        // });
        this.toast.success('Project updated successfully!', 'Success')
      }
      else {
        // this.toastr.infoToastr('Not Updated Please select all fields', 'Error', {
        //   animate: 'slideFromRight',
        //   showCloseButton: true,
        // });
        this.toast.info('Not Updated Please select all fields', 'Error')
      }
    }, err => {
      if (err) {
        // this.toastr.infoToastr('Not Updated', 'Error', {
        //   animate: 'slideFromRight',
        //   showCloseButton: true,
        // });
        this.toast.info('Not Updated', 'Error')
      }
    });
  }

  //get Customer

  getAllCustomer() {
    var data = {
      "customerList":
      {


      },
      "transactionType": "getall"
    }
    this.psaService.getAllCustomer(data).pipe(takeUntil(this.projectAll)).subscribe(response => {
      // console.log("all customer", response)
      this.customer = response;
      this.customerData = this.customer.customerList;

    });

  }

  getIDCustomer(id) {
    var resCustomer;
    var data = {
      "customerList":
      {
        "customerId": id

      },

      "transactionType": "getbyid"
    }
    this.psaService.getByIDListofCustomer(data).pipe(takeUntil(this.projectAll)).subscribe(res => {
      resCustomer = res;
      this.customerDataToShow = resCustomer.customerList[0];
      console.log("getByidcustomer", this.customerDataToShow);
      // for (var i = 0; i < this.serviceTypes.length; i++) {
      //   if (this.customerDataToShow.servicetype[0].servicetypeid == this.serviceTypes[i].id) {
      //     this.customerserviceName = this.serviceTypes[i].serviceTypeName
      //   }
      // }
    })
  }

  // get contract
  getAllContract() {
    var data = {
      "customercontractdetailslist": [
        {

        }],
      "transactiontype": "getAll"
    }

    this.psaService.getAllContractdDetails(data).pipe(takeUntil(this.projectAll)).subscribe(response => {


      this.contract = response;
      this.contractData = this.contract.customercontractdetailslist;
      this.getAllProject();
      // console.log("contract DATA", this.contractData)

    })
  }

  getIdcontract(id) {
    var data = {
      "customercontractdetailslist": [
        {
          "customerid": id
        }],
      "transactiontype": "getbycustid"
    }
    console.log("data customer select to contract", data);


    this.psaService.getIdContract(data).pipe(takeUntil(this.projectAll)).subscribe(response => {
      console.log("get id contract", response)
      this.cus = response;

      this.contractIdGet = this.cus.customercontractdetailslist.filter(res => res.financeStatus == "Approved");


    })
  }


  getContractId(id) {
    var data = {
      "customercontractdetailslist": [
        {

          "contractid": id



        }],
      "transactiontype": "getbyid"
    }

    this.onShow = true;

    this.cusconeditHide = true;

    this.show = false;

    this.psaService.getIdContract(data).pipe(takeUntil(this.projectAll)).subscribe(response => {
      console.log("contract selected", response)
      this.contr = response;
      this.contractDataTo = this.contr.customercontractdetailslist[0];
      this.contractbuHead = this.empbasicin.filter(data => data.employeeId == this.contractDataTo.buHead)
      this.contractsbuHead = this.empbasicin.filter(data => data.employeeId == this.contractDataTo.sbuHead)

      this.contractValue = this.contractDataTo.contractvalue;

      this.minStartDate = new Date(this.contractDataTo.startdate);
      this.maxStartDate = new Date(this.contractDataTo.enddate);
      console.log("dates ", this.minStartDate, this.maxStartDate);
      this.disableDate = false;
      this.getProjectContractID(id);
      this.valueContract = this.contractValue - this.valueToShow;
      console.log("contract value", this.valueContract);
      if (this.contractDataTo.contractType == "Customer") {
        this.isCustomer = true;
        this.project.get('projectType').setValue(this.contractDataTo.contractType);

      }
      else if (this.contractDataTo.contractType == "Internal") {
        this.isNotCustomer = true;
      }

    });
  }



  getProjectContractID(id) {
    var data = {
      "projectInfo": {
        "contractId": id
      },
      "transactionType": "getByContId"
    }
    this.contractDisable = true;
    this.psaService.getProjectContractId(data).pipe(takeUntil(this.projectAll)).subscribe(response => {
      console.log("con pro ID", response);

      this.procon = response;
      this.contractPro = this.procon.projectList;
      this.countValue = 0;

      if (this.procon.message == "No projects found!") {
        this.valueToShow = this.contractValue;
        this.showBalance = true;
        this.greenShow = true;
      }
      else {
        for (var i = 0; i < this.contractPro.length; i++) {
          this.countValue = this.countValue + this.contractPro[i].projectRatecard.projectValue;
        }
        this.valueToShow = this.contractValue - this.countValue;
        if (this.valueToShow >= 0) {

          this.greenShow = true;
          this.redShow = false;

        }
        else {
          this.redShow = true;
          this.greenShow = false;
        }
        this.showBalance = true;

      }




    })

  }

  //edit customer and contract
  editHere() {
    if (this.cusconeditHide == true) {
      this.cusconeditHide = false;
    }
  }

  cusConEdit() {

    this.contractDisable = true;
    this.onShow = false;
    this.showBalance = false;
    this.greenShow = false;
    this.redShow = false;
    this.show = true;
    this.cusconeditHide = false;
    this.isNotCustomer = false;
    this.isCustomer = false;

  }


  //get ALL Masters
  getLocationType() {
    var request = {
      "locationTypeList": [
        {

        }
      ],
      "transactionType": "getall"
    }
    this.psaService.getlocationType(request).pipe(takeUntil(this.projectAll)).subscribe(response => {
      this.loc = response;
      this.locTypes = this.loc.locationTypeList;
      console.log("location Type", this.locTypes)
    }
    );
  }

  getDelivaryLoc() {
    var data = {
      "deliverylocationList": [{

      }], "transactionType": "getall"
    }
    this.psaService.getdeliverylocation(data).pipe(takeUntil(this.projectAll)).subscribe(response => {

      this.delivery = response;
      this.deliveryLoc = this.delivery.deliverylocationList;
      console.log("delivary loc", this.deliveryLoc)
    });
  }

  getServiceType() {
    var data = { "servicetypeList": [{}], "transactionType": "getall" }
    this.psaService.getservicetype(data).pipe(takeUntil(this.projectAll)).subscribe(res => {

      this.serv = res;
      this.serviceTypes = this.serv.servicetypeList;
      console.log("service type", this.serviceTypes)
    });
  }
  getServiceCategory() {
    var data = { "servicecategoryList": [{}], "transactionType": "getall" }
    this.psaService.getServiceCategory(data).pipe(takeUntil(this.projectAll)).subscribe(Response => {
      this.serviceCat = Response;
      this.serviceCategoryList = this.serviceCat.servicecategoryList;
      console.log("service catogory", this.serviceCategoryList);
    });
  }

  getBillingType() {
    var data = {
      "transactionType": "getall"
    }
    this.psaService.getbillingtype(data).pipe(takeUntil(this.projectAll)).subscribe(response => {


      this.billingTypeList = response;
      this.billingTypes = this.billingTypeList.billingList;
      console.log("Billing Type", this.billingTypeList);

    })
  }

  getRateType() {
    var data = {
      "rateType": [{

      }],
      "transactionType": "getAll"
    }
    this.psaService.getRatetype(data).pipe(takeUntil(this.projectAll)).subscribe(response => {

      this.rateTypeList = response;
      this.rateTypes = this.rateTypeList.rateTypeList;
      console.log("rate type", this.rateTypes);

    }
    )
  }

  getTechStack() {
    var data = {
      "projectTechStackList": [
        {
        }
      ],
      "transactionType": "getall"
    }
    this.psaService.getProjectTechStack(data).pipe(takeUntil(this.projectAll)).subscribe(response => {
      this.techStackResp = response;
      this.techStacks = this.techStackResp.projectTechStackList;
      console.log("Tech Stack", this.techStacks);

    })
  }

  getTasks() {
    let req = {
      "projecttasklist": [
        {}
      ],
      "transactionType": "getall"
    }
    this.psaService.getProjectTask(req).pipe(takeUntil(this.projectAll)).subscribe(resp => {
      this.task = resp;
      this.taskList = this.task.projecttasklist;
      console.log('Task List : ', this.taskList);

    })
  }

  getBusinessUnit() {
    var data = {
      "businessUnit": [{
      }],
      "transactionType": "GetAll"
    }
    this.psaService.getBusinessUnit(data).pipe(takeUntil(this.projectAll)).subscribe(Response => {
      this.business = Response;
      this.businessUnit = this.business.businessUnitList;

    })
  }

  getSubBusinessUnit() {
    var data = {

      "subBusinessUnitModel": [
        {
        }],
      "transactionType": "getAll"
    }

    this.psaService.getSubBusinessUnit(data).pipe(takeUntil(this.projectAll)).subscribe(Response => {
      this.subBusiness = Response;
      this.subBusinessUnit = this.subBusiness.subBusinessUnitList;

      console.log("subbusiness Unit", this.subBusinessUnit);

    })
  }
  getEmpDesignation() {
    var request = {
      "designation": [

      ],
      "sessionId": "3121",
      "transactionType": "getall"
    }
    this.hrms.getEmployeeDesignation(request).pipe(takeUntil(this.projectAll)).subscribe(res => {
      this.empDesignationDetails = res;
      this.empDesignationlist = this.empDesignationDetails.listDesignation;
      console.log("emp designatoin", this.empDesignationlist);
    })
  }


  getProjectTypes() {
    let dta;
    var data = {
      "projectTypeList": [{


      }],
      "transactionType": "getall"
    }
    this.psaService.getProjectType(data).subscribe(resp => {
      dta = resp;
      this.projectTypedata = dta.body.projectTypeList;
      console.log("projectType", this.projectTypedata);

    });

  }
  //masters end





  buListArr = new Array();
  sbuListArr = new Array();



  getAllEmployees() {

    var empinfo =
    {
      "transactionType": "getAllInfo"
    }

    this.hrms.getempinfo(empinfo).pipe(takeUntil(this.projectAll)).subscribe(res => {
      this.empbasic = res;
      this.empbasicin = this.empbasic.employeeInfo;
      console.log("All Employees", this.empbasicin);
      // console.log("Business Unit", this.businessUnit);
      // for (var i = 0; i < this.businessUnit.length; i++) {
      //   let buObj = {
      //     'buHead': "",
      //     "buHeadName": "",
      //     "buName": ""
      //   }
      //   let empObj = this.empbasicin.find(type => type.employeeId == this.businessUnit[i].buHead)
      //   //console.log("Find employee : ", empObj);
      //   buObj.buHeadName = empObj.firstname + empObj.lastname;
      //   buObj.buHead = empObj.employeeId;
      //   buObj.buName = this.businessUnit[i].businessUnitName;
      //   this.buListArr.push(buObj);
      // }
      // for (var i = 0; i < this.subBusinessUnit.length; i++) {
      //   let sbuObj = {
      //     'sbuHead': "",
      //     "sbuHeadName": "",
      //     "name": ""
      //   }
      //   let empObj = this.empbasicin.find(type => type.employeeId == this.subBusinessUnit[i].sbuHead)
      //  // console.log("Find employee : ", empObj);
      //   sbuObj.sbuHeadName = empObj.firstname + empObj.lastname;
      //   sbuObj.sbuHead = empObj.employeeId;
      //   sbuObj.name = this.subBusinessUnit[i].name;
      //   this.sbuListArr.push(sbuObj);
      // }

      this.empsorteddata = this.empbasicin.sort((a, b) => {
        if (a.employeeId > b.employeeId) {
          return 1;
        }
        else {
          return -1;
        }
        return 0;
      })



      this.empObjTech = this.empbasicin.filter(type => {

        if (type.title.includes("Lead") || type.title.includes("lead"))
          return true;
      })
      console.log("Find employee of tech lead: ", this.empObjTech);


      this.manager = Array.from(new Set(this.empbasicin.map(x => x.reportingManager)));
      this.employee = Array.from(new Set(this.empbasicin.map(x => x.employeeId)));
      console.log(this.employee, "only employessssssssss........")
      console.log(this.manager, "only managers in employee info...................");
      for (let n = 0; n <= this.manager.length; n++) {
        for (let m = 0; m < this.employee.length; m++) {

          if (this.manager[n] == this.employee[m]) {
            this.managerdata.push(this.empbasicin[m]);

          }
        }
      }
      console.log("managers", this.managerdata)




    });
    console.log("bu obj", this.buListArr);



  }



  selected_customer(id) {

    this.contractDisable = false;
    this.customerId = id;
    this.contractIdGet = null;
    console.log("customer selected", this.customerId);
    this.getIDCustomer(id);
    this.getIdcontract(this.customerId);
  }





  cancelSave(value) {

    this.disableDate = true;
    this.showBalance = false;
    value.reset();
    this.show = true;
    this.contractDisable = true;
    this.onShow = false;
    this.isCustomer = false;
    this.isNotCustomer = false;
  }


  selected_customerToTable(value) {
    this.contractDisable = false;
    this.contractTableID = value;
  }

  approveBU() {
    var approve = {
      "projectInfo": {
        "projectId": this.getIdData.projectId,
        "buStatus": "Approved",
        "updatedBy": this.loggedUserName
      },
      "transactionType": "statusUpdate"
    }
    // console.log("approved",approve);

    swal({
      title: "Are you sure?",
      text: "Want to approve the project",
      buttons: [
        'No, cancel it!',
        'Yes, I am sure!'
      ],
      dangerMode: true,
    })
      .then((proceed) => {
        if (proceed) {

          this.psaService.saveProject(approve).pipe(takeUntil(this.projectAll)).subscribe(response => {
            console.log("approved response", response);
            this.msgApprove = response;
            // this.toastr.successToastr(this.msgApprove.message, 'success', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.success(this.msgApprove.message, 'Success')
            this.moreinfo(this.getIdData.projectId);
            this.getAllProject();
          }, err => {
            console.log(err)
            this.msg = err
            //   this.toastr.infoToastr(this.msg.error.message, 'info', {
            //     showCloseButton: true,
            //     animate: 'slideFromRight'
            //   })
            this.toast.info(this.msg.error.message, 'Info')
          });


        }
        else {
          // this.toastr.infoToastr('You did not approve project', 'Error', {
          //   animate: 'slideFromRight',
          //   showCloseButton: true,
          // });
          this.toast.info('You did not approve project', 'Error')
        }
      });







  }

  rejectBU(comment) {
    var reject = {
      "projectInfo": {
        "projectId": this.getIdData.projectId,
        "buStatus": "Rejected",
        "comment": comment.comments,
        "updatedBy": this.loggedUserName
      },
      "transactionType": "statusUpdate"
    }
    console.log("rejected", reject);

    swal({
      title: "Are you sure?",
      text: "Want to reject the project",

      buttons: [
        'No, cancel it!',
        'Yes, I am sure!'
      ],
      dangerMode: true,
    })
      .then((proceed) => {
        if (proceed) {

          this.psaService.saveProject(reject).pipe(takeUntil(this.projectAll)).subscribe(response => {
            console.log("Reject response", response);
            this.msgApprove = response;
            // this.toastr.successToastr(this.msgApprove.message, 'success', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.success(this.msgApprove.message, 'Success')
            this.moreinfo(this.getIdData.projectId);
            this.getAllProject();

          }, err => {
            console.log(err)
            this.msg = err
            // this.toastr.infoToastr(this.msg.error.message, 'Error', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.info(this.msg.error.message, 'Error')
          });

        }
        else {
          // this.toastr.infoToastr('You did not reject project', 'info', {
          //   animate: 'slideFromRight',
          //   showCloseButton: true,
          // });
          this.toast.info('You did not reject project', 'Info')
        }
      });
  }
  approveFinance() {
    var approve = {
      "projectInfo": {
        "projectId": this.getIdData.projectId,
        "financeStatus": "Approved",
        "updatedBy": this.loggedUserName
      },
      "transactionType": "statusUpdate"
    }
    console.log("approved", approve);

    swal({
      title: "Are you sure?",
      text: "Want to approve the project",
      buttons: [
        'No, cancel it!',
        'Yes, I am sure!'
      ],
      dangerMode: true,
    })
      .then((proceed) => {
        if (proceed) {

          this.psaService.saveProject(approve).pipe(takeUntil(this.projectAll)).subscribe(response => {
            console.log("approved response", response);
            this.msgApprove = response;
            // this.toastr.successToastr(this.msgApprove.message, 'success', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.success(this.msgApprove.message, 'Success')
            this.moreinfo(this.getIdData.projectId);
            this.getAllProject();
          }, err => {
            console.log(err)
            this.msg = err
            // this.toastr.infoToastr(this.msg.error.message, 'info', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.info(this.msg.error.message, 'info')
          });

        }
        else {
          // this.toastr.infoToastr('You did not approve project', 'Error', {
          //   animate: 'slideFromRight',
          //   showCloseButton: true,
          // });
          this.toast.info('You did not approve project', 'Error')
        }
      });







  }

  rejectFinance(comment) {
    var reject = {
      "projectInfo": {
        "projectId": this.getIdData.projectId,

        "financeStatus": "Rejected",
        "comment": comment.comments,
        "updatedBy": this.loggedUserName
      },
      "transactionType": "statusUpdate"
    }
    console.log("rejected", reject);

    swal({
      title: "Are you sure?",
      text: "Want to reject the project",

      buttons: [
        'No, cancel it!',
        'Yes, I am sure!'
      ],
      dangerMode: true,
    })
      .then((proceed) => {
        if (proceed) {

          this.psaService.saveProject(reject).pipe(takeUntil(this.projectAll)).subscribe(response => {
            console.log("Reject response", response);
            this.msgApprove = response;
            // this.toastr.successToastr(this.msgApprove.message, 'success', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.success(this.msgApprove.message, 'Success')
            this.moreinfo(this.getIdData.projectId);
            this.getAllProject();

          }, err => {
            console.log(err)
            this.msg = err
            // this.toastr.infoToastr(this.msg.error.message, 'Error', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.info(this.msg.error.message, 'Error')
          });

        }
        else {
          // this.toastr.infoToastr('You did not reject project', 'info', {
          //   animate: 'slideFromRight',
          //   showCloseButton: true,
          // });
          this.toast.info('You did not reject project', 'Info')
        }
      });
  }




  deleteProject(id) {
    var data = {
      "projectInfo": {
        "projectId": id,
        "updatedBy": this.loggedUserName
      },
      "transactionType": "delete"
    }

    swal({
      title: "Are you sure?",
      text: "Once deleted, you will not be able to recover this activity!",
      buttons: [
        'No, cancel it!',
        'Yes, I am sure!'
      ],
      dangerMode: true,
    })
      .then((proceed) => {
        if (proceed) {

          this.psaService.saveProject(data).pipe(takeUntil(this.projectAll)).subscribe(response => {
            console.log("delete response", response);
            this.msgdelete = response;
            // this.toastr.successToastr(this.msgdelete.message, 'success', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.success(this.msgdelete.message, 'Success')

            this.getAllProject();
          }, err => {
            console.log(err)
            this.msg = err
            // this.toastr.infoToastr(this.msg.error.message, 'error', {
            //   showCloseButton: true,
            //   animate: 'slideFromRight'
            // })
            this.toast.info(this.msg.error.message, 'Error')
          });

        }
        else {
          // this.toastr.infoToastr('Delete activity not completed', 'info', {
          //   animate: 'slideFromRight',
          //   showCloseButton: true,
          // });
          this.toast.info('Delete activity not completed', 'info')
        }
      });


  }


  valueChange(valUpdate) {
    console.log("value change", valUpdate.target.value, this.valueToShow);
    console.log("value of addition change", this.valueToShow + this.editprojectvalue);

    if ((Number(valUpdate.target.value)) > this.valueToShow + this.editprojectvalue) {
      this.errorToEnter = true;
    }
    else {
      this.errorToEnter = false;
    }
  }


  //get resources

  getresources() {
    var response
    var data
    var obj = []
    var resourcedata = {
      "rmgInfo": {


      },
      "transactiontype": "getall"
    }

    this.rmgService.getAllResource(resourcedata).pipe(takeUntil(this.projectAll)).subscribe(res => {
      response = res
      data = response.rmgInfo
      console.log("resorcesss data", data)
      data.map(d => {
        if (d.resourceType == "Specific") {
          for (let i in d.rmgspecific) {
            if (d.rmgspecific[i].flag == true) {
              var project = this.dataTo.find(e => e.projectId == d.projectId)
              var final = new Object({ bookingId: d.bookingId, resourceType: d.resourceType, projectId: d.projectId, projectName: project.projectName, resource: d.rmgspecific[i] })
              obj.push(final)
            }
          }
        }
        else {
          for (let i in d.rmggeneric) {
            for (let j in d.rmggeneric[i].rmggenericresourcemap) {
              if (d.rmggeneric[i].rmggenericresourcemap[j].flag == true) {
                var project = this.dataTo.find(e => e.projectId == d.projectId)
                var final = new Object({ bookingId: d.bookingId, resourceType: d.resourceType, projectId: d.projectId, projectName: project.projectName, resource: d.rmggeneric[i].rmggenericresourcemap[j], genericId: d.rmggeneric[i].genericId })
                obj.push(final)
              }
            }

          }
        }
      })

      this.originalData = obj

      this.rmgdata = obj
      console.log(this.rmgdata, "final object");

    })
  }
}
