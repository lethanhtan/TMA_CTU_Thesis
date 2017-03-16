package edu.ctu.thesis.travelsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class ImportDaoImpl implements ImportDataDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void importExcel(MultipartFile excelfile) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			DataFormatter formatter = new DataFormatter();
			
			List<Tour> listTours = new ArrayList<>();
			int i = 0;
			// Creates a workbook object from the uploaded excelfile
			HSSFWorkbook workbook = new HSSFWorkbook(excelfile.getInputStream());
			// Creates a worksheet object representing the first sheet
			HSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			System.out.println(worksheet.getLastRowNum());
			while (i <= worksheet.getLastRowNum()) {
				// Creates an object for the UserInfo Model
				Tour tour = new Tour();
				// Creates an object representing a single row in excel
				HSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				tour.setIdTour(formatter.formatCellValue(row.getCell(0)));
				tour.setName(formatter.formatCellValue(row.getCell(1)));
				tour.setDepartureDate(formatter.formatCellValue(row.getCell(2)));
				tour.setDepartureTime(formatter.formatCellValue(row.getCell(3)));
				tour.setReturnDate(formatter.formatCellValue(row.getCell(2)));
				tour.setReturnTime(formatter.formatCellValue(row.getCell(3)));
				tour.setQuantum(formatter.formatCellValue(row.getCell(4)));
				tour.setPrice(formatter.formatCellValue(row.getCell(5)));
				tour.setDetail(formatter.formatCellValue(row.getCell(6)));
				// persist data into database in here
				listTours.add(tour);
				session.save(tour);
				session.flush();
			}			
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
