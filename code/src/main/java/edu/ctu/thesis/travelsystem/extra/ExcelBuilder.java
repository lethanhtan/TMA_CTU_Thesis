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

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;
 
@SuppressWarnings("deprecation")
public class ExcelBuilder extends AbstractExcelView {
 
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	if (model.get("exportList").equals("Danh sách tour")) {
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
             
            header.createCell(0).setCellValue("Mã tour");
            header.getCell(0).setCellStyle(style);
             
            header.createCell(1).setCellValue("Tên tour");
            header.getCell(1).setCellStyle(style);
             
            header.createCell(2).setCellValue("Ngày đi");
            header.getCell(2).setCellStyle(style);
             
            header.createCell(3).setCellValue("Giờ đi");
            header.getCell(3).setCellStyle(style);
            
            header.createCell(4).setCellValue("Ngày về");
            header.getCell(4).setCellStyle(style);
             
            header.createCell(5).setCellValue("Giờ về");
            header.getCell(5).setCellStyle(style);
            /*
            header.createCell(6).setCellValue("");
            header.getCell(6).setCellStyle(style);
            
            header.createCell(7).setCellValue("Cancel or not");
            header.getCell(7).setCellStyle(style);
            
            header.createCell(8).setCellValue("Reg or not");
            header.getCell(8).setCellStyle(style);
            
            header.createCell(9).setCellValue("Date allow reg");
            header.getCell(9).setCellStyle(style);
            
            header.createCell(10).setCellValue("Date allow canel");
            header.getCell(10).setCellStyle(style);
            
            header.createCell(11).setCellValue("Ful or not");
            header.getCell(11).setCellStyle(style);
            
            header.createCell(12).setCellValue("Ticket avaiable");
            header.getCell(12).setCellStyle(style);
            
            header.createCell(13).setCellValue("Quantum");
            header.getCell(13).setCellStyle(style);
            */
             
            // create data rows
            int rowCount = 1;
             
            for (Tour tour : listTours) {
                HSSFRow aRow = sheet.createRow(rowCount++);
                aRow.createCell(0).setCellValue(tour.getIdTour());
                aRow.createCell(1).setCellValue(tour.getName());
                aRow.createCell(2).setCellValue(tour.getDepartureDate());
                aRow.createCell(3).setCellValue(tour.getDepartureTime());
                aRow.createCell(4).setCellValue(tour.getReturnDate());
                aRow.createCell(5).setCellValue(tour.getReturnTime());
                /*
                //aRow.createCell(6).setCellValue(tour.getDetail());
                aRow.createCell(7).setCellValue(tour.getCancelOrNot());
                aRow.createCell(8).setCellValue(tour.getRegOrNot());
                aRow.createCell(9).setCellValue(tour.getDateAllowReg());
                aRow.createCell(10).setCellValue(tour.getDateAllowCancel());
                aRow.createCell(11).setCellValue(tour.getFullOrNot());
                aRow.createCell(12).setCellValue(tour.getTicketAvailability());
                aRow.createCell(13).setCellValue(tour.getQuantum());
                */
            }
        }
    	if (model.get("exportList").equals("Danh sách đăng ký")) {
    		// get data model which is passed by the Spring container
            @SuppressWarnings("unchecked")
    		List<BookTour> listBookTours = (List<BookTour>) model.get("listBookTours");
            // create a new Excel sheet
            HSSFSheet sheet = workbook.createSheet("List Book Tour");
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
             
            header.createCell(0).setCellValue("Stt");
            header.getCell(0).setCellStyle(style);
             
            header.createCell(1).setCellValue("Tên người dùng");
            header.getCell(1).setCellStyle(style);
             
            header.createCell(2).setCellValue("Email");
            header.getCell(2).setCellStyle(style);
             
            header.createCell(3).setCellValue("Địa chỉ");
            header.getCell(3).setCellStyle(style);
            
            header.createCell(4).setCellValue("Số điện thoại");
            header.getCell(4).setCellStyle(style);
             
            header.createCell(5).setCellValue("Giới tính");
            header.getCell(5).setCellStyle(style);
            /* 
            header.createCell(6).setCellValue("Id tour");
            header.getCell(6).setCellStyle(style);
            */
            
         // create data rows
            int rowCount = 1;
             
            for (BookTour btour : listBookTours) {
                HSSFRow aRow = sheet.createRow(rowCount++);
                aRow.createCell(0).setCellValue(btour.getIdBT());
                aRow.createCell(1).setCellValue(btour.getCusName());
                /*
                aRow.createCell(2).setCellValue(btour.getCusEmail());
                aRow.createCell(3).setCellValue(btour.getCusAddress());
                aRow.createCell(4).setCellValue(btour.getCusPhone());
                aRow.createCell(5).setCellValue(btour.getCusSex());
                */
                //aRow.createCell(6).setCellValue(btour.getTour().getIdTour());
            }
    	}
    }
}
