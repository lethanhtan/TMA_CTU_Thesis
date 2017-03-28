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
import edu.ctu.thesis.travelsystem.model.Import;
import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class ImportDataDaoImpl extends AbstractDao implements ImportDataDao {
	
	private static final Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);

	@Override
	public void importExcel(MultipartFile excelfile) {
		Session session = getCurrentSession();
		try {
			ImportController.status = 0;
			DataFormatter formatter = new DataFormatter();
			
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
				// persist data into database in here
				listTours.add(tour);
				session.save(tour);
				session.flush();
			}			
			workbook.close();
		} catch (Exception e) {
			logger.info("Happen error!");
			ImportController.status = 1;
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

	@Override
	public Integer getNumImport() {
		// TODO Auto-generated method stub
		return null;
	}

}
