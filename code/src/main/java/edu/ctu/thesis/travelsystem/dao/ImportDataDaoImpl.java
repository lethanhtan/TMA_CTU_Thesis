package edu.ctu.thesis.travelsystem.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.controller.ImportController;
import edu.ctu.thesis.travelsystem.extra.EncoderPassword;
import edu.ctu.thesis.travelsystem.model.Import;
import edu.ctu.thesis.travelsystem.model.Promotion;
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.Schedule;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.model.User;

@Service
public class ImportDataDaoImpl extends AbstractDao implements ImportDataDao {
	
	private static final Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);
	
	EncoderPassword ep = new EncoderPassword();
	
	@Override
	public void importExcel(MultipartFile excelfile, String listType){
		Session session = getCurrentSession();
		DataFormatter formatter = new DataFormatter();
		if (listType.equals("Danh sách tour"))
		{
			ImportController.status = 0;
			try {
				logger.info("Import list type: " + listType);
				
				List<Tour> listTours = new ArrayList<>();
				int i = 0;
				// Creates a workbook object from the uploaded excelfile
				HSSFWorkbook workbook = new HSSFWorkbook(excelfile.getInputStream());
				// Creates a worksheet object representing the first sheet
				HSSFSheet worksheet = workbook.getSheetAt(0);
				// Reads the data in excel file until last row is encountered
				while (i <= worksheet.getLastRowNum()) {
					// Creates an object for the UserInfo Model
					Tour tour = new Tour();
					Schedule schedule = new Schedule();
					Promotion promotion = new Promotion();
					// Creates an object representing a single row in excel
					HSSFRow row = worksheet.getRow(i++);
					// Sets the Read data to the model class
					tour.setName(formatter.formatCellValue(row.getCell(0)));
					tour.setDepartureDate(row.getCell(1).getDateCellValue());
					tour.setDepartureTime(formatter.formatCellValue(row.getCell(2)));
					tour.setReturnDate(row.getCell(3).getDateCellValue());
					tour.setReturnTime(formatter.formatCellValue(row.getCell(4)));
					tour.setQuantum((int) row.getCell(5).getNumericCellValue());
					tour.setDetail(formatter.formatCellValue(row.getCell(6)));
					tour.setPrice(formatter.formatCellValue(row.getCell(7)));
					tour.setCancelOrNot(row.getCell(8).getBooleanCellValue());
					tour.setRegOrNot(row.getCell(9).getBooleanCellValue());
					tour.setDateAllowCancel(row.getCell(10).getDateCellValue());
					tour.setDateAllowReg(row.getCell(11).getDateCellValue());
					tour.setFullOrNot(row.getCell(12).getBooleanCellValue());
					tour.setTicketAvailability((int) row.getCell(13).getNumericCellValue());
					
					schedule.setTour(tour);
					promotion.setTour(tour);
					// persist data into database in here
					
					listTours.add(tour);
					
					session.save(tour);
					session.save(promotion);
					session.save(schedule);
					session.flush();
				}			
				workbook.close();
			} catch (Exception e) {
				logger.info("Format file error!");
				ImportController.status = 1;
			}
		}
		else if (listType.equals("Danh sách người dùng")) {
			ImportController.status = 0;
			try {
				logger.info("Import list type: " + listType);
				
				List<User> listUser = new ArrayList<>();
				
				Role role = new Role();
				role.setId(1);
				role.setDescription("role_user");
				
				int i = 0;
				// Creates a workbook object from the uploaded excelfile
				HSSFWorkbook workbook = new HSSFWorkbook(excelfile.getInputStream());
				// Creates a worksheet object representing the first sheet
				HSSFSheet worksheet = workbook.getSheetAt(0);
				// Reads the data in excel file until last row is encountered
				while (i <= worksheet.getLastRowNum()) {
					// Creates an object for the UserInfo Model
					User user = new User();
					// Creates an object representing a single row in excel
					HSSFRow row = worksheet.getRow(i++);
					// Sets the Read data to the model class
					user.setFullName(formatter.formatCellValue(row.getCell(0)));
					user.setUserName(formatter.formatCellValue(row.getCell(1)));
					user.setEmail(formatter.formatCellValue(row.getCell(2)));
					user.setBirthday(row.getCell(3).getDateCellValue());
					user.setPassword(ep.enCoded(formatter.formatCellValue(row.getCell(4))));
					user.setAddress(formatter.formatCellValue(row.getCell(5)));
					user.setPhone(formatter.formatCellValue(row.getCell(6)));
					user.setSex(formatter.formatCellValue(row.getCell(7)));
					user.setRole(role);
					// persist data into database in here
					
					listUser.add(user);
					
					session.save(user);
					session.flush();
				}			
				workbook.close();
			} catch (Exception e) {
				logger.info("Format file error!");
				e.printStackTrace();
				ImportController.status = 1;
			}
		}
	}

	@Override
	public void saveImport(Import object) {
		Session session = getCurrentSession();
		Date now = new Date();
		object.setDate(now);
		object.setTime(now);
		session.save(object);
		session.flush();
	}
}
