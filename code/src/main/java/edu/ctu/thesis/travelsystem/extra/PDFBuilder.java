package edu.ctu.thesis.travelsystem.extra;

import java.io.IOException;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import edu.ctu.thesis.travelsystem.model.Tour;

public class PDFBuilder extends AbstractITextPdfView {
	
	public static final String FONT = "/fonts/unicode/arial.ttf";
	public static final String FONT1 = "/fonts/unicode/times.ttf";
	public static final String FONT2 = "/fonts/unicode/tahoma.ttf";
	 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        @SuppressWarnings("unchecked")
		List<Tour> listTours = (List<Tour>) model.get("listTours");
        doc.add(new Paragraph("List Tour"));
        doc.addTitle("NYTravel List Tour");
        doc.addSubject("List tour");
         
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {1.0f, 2.0f, 1.0f, 1.0f, 1.0f, 1.0f, 3.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        FontFactory.register(FONT2);
        Font font = FontFactory.getFont(FONT2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        // write table header
        table.addCell(getNormalCell("Id", 11, font));
         
        table.addCell(getNormalCell("Name", 11, font));
 
        table.addCell(getNormalCell("Departure Date", 11, font));
         
        table.addCell(getNormalCell("Departure Time", 11, font));
        
        table.addCell(getNormalCell("Return Date", 11, font));
        
        table.addCell(getNormalCell("Return Time", 11, font));
         
        table.addCell(getNormalCell("Detail", 11, font));
         
        // write table row data
        for (Tour tour : listTours) {
            table.addCell(getNormalCell(tour.getIdTour().toString(), 11, font));
            table.addCell(getNormalCell(tour.getName(), 11, font));
            table.addCell(getNormalCell(tour.getDepartureDate().toString(), 11, font));
            table.addCell(getNormalCell(tour.getDepartureTime(), 11, font));
            table.addCell(getNormalCell(tour.getReturnDate().toString(), 11, font));
            table.addCell(getNormalCell(tour.getReturnTime(), 11, font));
            table.addCell(getNormalCell(tour.getDetail(), 11, font));
        }
         
        doc.add(table);
         
    }
    
    public static PdfPCell getNormalCell(String string, float size, Font font)
            throws DocumentException, IOException {
        font.setColor(BaseColor.BLACK);
        font.setSize(size);
        PdfPCell cell = new PdfPCell(new Phrase(string, font));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cell;
    }
 
}