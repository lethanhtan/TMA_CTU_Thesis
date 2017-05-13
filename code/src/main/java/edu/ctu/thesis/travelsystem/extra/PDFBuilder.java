package edu.ctu.thesis.travelsystem.extra;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;

public class PDFBuilder extends AbstractITextPdfView {

	private static final Logger logger = Logger.getLogger(PDFBuilder.class);

	public static final String FONT = "/fonts/unicode/arial.ttf";
	public static final String FONT1 = "/fonts/unicode/times.ttf";
	public static final String FONT2 = "/fonts/unicode/tahoma.ttf";
	private static final int SIZE1 = 8;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (model.get("exportList").equals("Danh sách tour")) {
			logger.info("Processing for build pdf file: tour list");
			// get data model which is passed by the Spring container
			@SuppressWarnings("unchecked")
			List<Tour> listTours = (List<Tour>) model.get("listTours");
			// define font for table header row
			FontFactory.register(FONT2);
			Font font = FontFactory.getFont(FONT2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			// define title paragraph
			Paragraph para = new Paragraph("Danh sách tour du lịch", font);
			para.setAlignment(Element.ALIGN_CENTER);
			// define document attribute
			doc.add(para);
			doc.addTitle("NYTravel List Tour");
			doc.addSubject("List tour");
			// set table attribute
			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 0.5f, 3.5f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f });
			table.setSpacingBefore(10);

			// write table header
			table.addCell(getNormalCell("Stt", SIZE1, font));

			table.addCell(getNormalCell("Tên tour", SIZE1, font));

			table.addCell(getNormalCell("Ngày đi", SIZE1, font));

			table.addCell(getNormalCell("Giờ đi", SIZE1, font));

			table.addCell(getNormalCell("Ngày về", SIZE1, font));

			table.addCell(getNormalCell("Giờ về", SIZE1, font));

			table.addCell(getNormalCell("Số lượng", SIZE1, font));

			table.addCell(getNormalCell("Giá vé", SIZE1, font));
			// write table row data
			
			// 
			Integer i = 1;
			for (Tour tour : listTours) {
				table.addCell(getNormalCell((i++).toString(), SIZE1, font));
				table.addCell(getNormalCell(tour.getName(), SIZE1, font));
				table.addCell(getNormalCell(sdf.format(tour.getDepartureDate()), SIZE1, font));
				table.addCell(getNormalCell(tour.getDepartureTime(), SIZE1, font));
				table.addCell(getNormalCell(sdf.format(tour.getReturnDate()), SIZE1, font));
				table.addCell(getNormalCell(tour.getReturnTime(), SIZE1, font));
				table.addCell(getNormalCell(String.valueOf(tour.getQuantum()), SIZE1, font));
				table.addCell(getNormalCell(String.valueOf(tour.getPrice()), SIZE1, font));
			}

			doc.add(table);

		}
		if (model.get("exportList").equals("Danh sách người đăng ký")) {
			logger.info("Processing for build pdf file: register tour list");
			// get data model which is passed by the Spring container
			@SuppressWarnings("unchecked")
			List<BookTour> listBookTours = (List<BookTour>) model.get("listBookTours");

			// define font for table header row
			FontFactory.register(FONT2);
			Font font = FontFactory.getFont(FONT2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			
			// define title paragraph
			Paragraph para = new Paragraph("Danh sách người đăng ký", font);
			para.setAlignment(Element.ALIGN_CENTER);
			
			//define document attribute
			doc.add(para);
			doc.addTitle("NYTravel List BookTour");
			doc.addSubject("List booktour");

			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 0.5f, 4.0f, 1.0f, 1.0f, 3.5f });
			table.setSpacingBefore(10);

			// write table header
			table.addCell(getNormalCell("Stt", SIZE1, font));
			table.addCell(getNormalCell("Họ tên", SIZE1, font));
			table.addCell(getNormalCell("Năm sinh", SIZE1, font));
			table.addCell(getNormalCell("Giới tính", SIZE1, font));
			table.addCell(getNormalCell("Đăng ký bởi", SIZE1, font));
			// write table row data
			for (BookTour bookTour : listBookTours) {
				table.addCell(getNormalCell(String.valueOf(bookTour.getIdBT()), SIZE1, font));
				 table.addCell(getNormalCell(bookTour.getCusName(), SIZE1,font));
				 table.addCell(getNormalCell(bookTour.getCusYearOfBirth(), SIZE1, font));
				 table.addCell(getNormalCell(bookTour.getCusSex(), SIZE1,font));
				 table.addCell(getNormalCell(bookTour.getWhoIsRegistered(), SIZE1, font));
				 
			}

			doc.add(table);

		}
		if (model.get("exportList").equals("Tour")) {
			logger.info("Processing for build pdf file: register tour list");
			// get data model which is passed by the Spring container
			@SuppressWarnings("unchecked")
			List<BookTour> listBookTours = (List<BookTour>) model.get("listBookTours");

			// define font for table header row
			FontFactory.register(FONT2);
			Font font = FontFactory.getFont(FONT2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			
			// define title paragraph
			Paragraph para = new Paragraph("Danh sách người đăng ký", font);
			para.setAlignment(Element.ALIGN_CENTER);
			
			//define document attribute
			doc.add(para);
			doc.addTitle("NYTravel List BookTour");
			doc.addSubject("List booktour");

			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 0.5f, 4.0f, 1.0f, 1.0f, 3.5f });
			table.setSpacingBefore(10);

			// write table header
			table.addCell(getNormalCell("Stt", SIZE1, font));
			table.addCell(getNormalCell("Họ tên", SIZE1, font));
			table.addCell(getNormalCell("Năm sinh", SIZE1, font));
			table.addCell(getNormalCell("Giới tính", SIZE1, font));
			table.addCell(getNormalCell("Đăng ký bởi", SIZE1, font));
			// write table row data
			for (BookTour bookTour : listBookTours) {
				table.addCell(getNormalCell(String.valueOf(bookTour.getIdBT()), SIZE1, font));
				 table.addCell(getNormalCell(bookTour.getCusName(), SIZE1,font));
				 table.addCell(getNormalCell(bookTour.getCusYearOfBirth(), SIZE1, font));
				 table.addCell(getNormalCell(bookTour.getCusSex(), SIZE1,font));
				 table.addCell(getNormalCell(bookTour.getWhoIsRegistered(), SIZE1, font));
				 
			}

			doc.add(table);
		}
	}

	public static PdfPCell getNormalCell(String string, float size, Font font) throws DocumentException, IOException {
		font.setColor(BaseColor.BLACK);
		font.setSize(size);
		PdfPCell cell = new PdfPCell(new Phrase(string, font));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		return cell;
	}

}
