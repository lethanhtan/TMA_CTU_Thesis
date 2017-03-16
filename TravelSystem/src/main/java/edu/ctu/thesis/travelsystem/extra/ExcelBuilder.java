package edu.ctu.thesis.travelsystem.extra;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import edu.ctu.thesis.travelsystem.model.Tour;
 
@SuppressWarnings("deprecation")
public class ExcelBuilder extends AbstractExcelView {
 
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        @SuppressWarnings("unchecked")
		List<Tour> listTours = (List<Tour>) model.get("listTours");
         
        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("List Tour");
        sheet.setDefaultColumnWidth(30);
         
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
         
        // create header row
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue("Id");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("Name");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("Date");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("Time");
        header.getCell(3).setCellStyle(style);
         
        header.createCell(4).setCellValue("Detail");
        header.getCell(4).setCellStyle(style);
         
        // create data rows
        int rowCount = 1;
         
        for (Tour tour : listTours) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(tour.getIdTour());
            aRow.createCell(1).setCellValue(tour.getName());
            aRow.createCell(2).setCellValue(tour.getDepartureDate());
            aRow.createCell(3).setCellValue(tour.getDepartureTime());
            aRow.createCell(4).setCellValue(tour.getDetail());
        }
    }
 
}
