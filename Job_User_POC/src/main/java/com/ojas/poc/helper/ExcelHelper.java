package com.ojas.poc.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.poc.model.Job;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "id", "availability", "country", "experience", "job_description", "job_title",
			"job_type", "language", "pay_rate", "reply_rate", "skills", "state", "user_data_id" };
	static String SHEET = "Job_info";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Job> excelToTutorials(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Job> jobsInfo = new ArrayList<Job>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Job job = new Job();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						job.setAvailability(currentCell.getStringCellValue());
						break;
					case 1:
						job.setCountry(currentCell.getStringCellValue());
						break;
					case 2:
						job.setExperience(currentCell.getStringCellValue());
						break;
					case 3:
						job.setJobDescription(currentCell.getStringCellValue());
						break;
					case 4:
						job.setJobTitle(currentCell.getStringCellValue());
						break;
					case 5:
						job.setJobType(currentCell.getStringCellValue());
						break;
					case 6:
						job.setLanguage(currentCell.getStringCellValue());

					case 7:
						job.setPayRate(currentCell.getStringCellValue());

					case 8:
						job.setReplyRate(currentCell.getStringCellValue());
					case 9:
						job.setSkills(currentCell.getStringCellValue());
					case 10:
						job.setState(currentCell.getStringCellValue());

					default:
						break;
					}

					cellIdx++;
				}

				jobsInfo.add(job);
			}

			workbook.close();

			return jobsInfo;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
