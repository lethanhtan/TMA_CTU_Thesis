package edu.ctu.thesis.travelsystem.extra;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
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

	public static final String FONT = "/fonts/unicode/arial.ttf";
	public static final String FONT1 = "/fonts/unicode/times.ttf";
	public static final String FONT2 = "/fonts/unicode/tahoma.ttf";
	private static final int SIZE1 = 8;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (model.get("exportList").equals("Danh sách tour")) {
			// get data model which is passed by the Spring container
			@SuppressWarnings("unchecked")
			List<Tour> listTours = (List<Tour>) model.get("listTours");
			doc.add(new Paragraph("List Tour"));
			doc.addTitle("NYTravel List Tour");
			doc.addSubject("List tour");

			PdfPTable table = new PdfPTable(13);
			table.setWidthPercentage(100.0f);
			table.setWidths(
					new float[] { 0.5f, 2.0f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 1.0f });
			table.setSpacingBefore(10);
			// define font for table header row
			FontFactory.register(FONT2);
			Font font = FontFactory.getFont(FONT2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			// write table header
			table.addCell(getNormalCell("Id", SIZE1, font));

			table.addCell(getNormalCell("Name", SIZE1, font));

			table.addCell(getNormalCell("Departure Date", SIZE1, font));

			table.addCell(getNormalCell("Departure Time", SIZE1, font));

			table.addCell(getNormalCell("Return Date", SIZE1, font));

			table.addCell(getNormalCell("Return Time", SIZE1, font));

			table.addCell(getNormalCell("Quantum", SIZE1, font));

			table.addCell(getNormalCell("Price", SIZE1, font));

			table.addCell(getNormalCell("Cancel or not", SIZE1, font));

			table.addCell(getNormalCell("Date allow cancel", SIZE1, font));

			table.addCell(getNormalCell("Date allow reg", SIZE1, font));

			table.addCell(getNormalCell("Full or not", SIZE1, font));

			table.addCell(getNormalCell("Ticket available", SIZE1, font));

			// write table row data
			for (Tour tour : listTours) {
				table.addCell(getNormalCell(String.valueOf(tour.getIdTour()), SIZE1, font));
				table.addCell(getNormalCell(tour.getName(), SIZE1, font));
				table.addCell(getNormalCell(tour.getDepartureDate().toString(), SIZE1, font));
				table.addCell(getNormalCell(tour.getDepartureTime(), SIZE1, font));
				table.addCell(getNormalCell(tour.getReturnDate().toString(), SIZE1, font));
				table.addCell(getNormalCell(tour.getReturnTime(), SIZE1, font));
				table.addCell(getNormalCell(String.valueOf(tour.getQuantum()), SIZE1, font));
				table.addCell(getNormalCell(String.valueOf(tour.getPrice()), SIZE1, font));
				table.addCell(getNormalCell(String.valueOf(tour.getCancelOrNot()), SIZE1, font));
				table.addCell(getNormalCell(tour.getDateAllowCancel().toString(), SIZE1, font));
				table.addCell(getNormalCell(tour.getDateAllowReg().toString(), SIZE1, font));
				table.addCell(getNormalCell(String.valueOf(tour.getFullOrNot()), SIZE1, font));
				table.addCell(getNormalCell(String.valueOf(tour.getTicketAvailability()), SIZE1, font));

			}

			doc.add(table);

		}
		if (model.get("exportList").equals("Danh sách đăng ký")) {
			// get data model which is passed by the Spring container
			@SuppressWarnings("unchecked")
			List<BookTour> listBookTours = (List<BookTour>) model.get("listBookTours");
			doc.add(new Paragraph("List BookTour"));
			doc.addTitle("NYTravel List BookTour");
			doc.addSubject("List booktour");

			PdfPTable table = new PdfPTable(7);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 1.0f, 2.0f, 2.0f, 2.0f, 1.0f, 1.0f, 1.0f });
			table.setSpacingBefore(10);

			// define font for table header row
			FontFactory.register(FONT2);
			Font font = FontFactory.getFont(FONT2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			// write table header
			table.addCell(getNormalCell("Id", SIZE1, font));

			table.addCell(getNormalCell("Name", SIZE1, font));

			table.addCell(getNormalCell("Email", SIZE1, font));

			table.addCell(getNormalCell("Address", SIZE1, font));

			table.addCell(getNormalCell("Phone", SIZE1, font));

			table.addCell(getNormalCell("Sex", SIZE1, font));

			table.addCell(getNormalCell("Id Tour", SIZE1, font));

			// write table row data
			for (BookTour bookTour : listBookTours) {
				table.addCell(getNormalCell(String.valueOf(bookTour.getIdBT()), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusName(), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusEmail().toString(), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusAddress(), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusPhone().toString(), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusSex(), SIZE1, font));
				table.addCell(getNormalCell(String.valueOf(bookTour.getTour().getIdTour()), SIZE1, font));
			}

			doc.add(table);

		}
		if (model.get("exportList").equals("Tour")) {
			// get data model which is passed by the Spring container
			@SuppressWarnings("unchecked")
			List<BookTour> listBookTours = (List<BookTour>) model.get("listBookTours");

			// define font for table header row
			FontFactory.register(FONT2);
			Font font = FontFactory.getFont(FONT2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Paragraph title = new Paragraph("Danh sách người đăng ký", font);
			title.setIndentationLeft(180.0f);
			doc.add(title);
			if (!listBookTours.isEmpty()) {
				Paragraph nameTour = new Paragraph(listBookTours.get(0).getTour().getName(), font);
				nameTour.setIndentationLeft(200.0f);
				doc.add(nameTour);
			}
			doc.addTitle("NYTravel List BookTour");
			doc.addSubject("Danh sách người đăng ký");

			PdfPTable table = new PdfPTable(7);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 0.5f, 1.5f, 1.5f, 2.0f, 1.0f, 0.5f, 3.0f });
			table.setSpacingBefore(10);

			// write table header
			table.addCell(getNormalCell("STT", SIZE1, font));

			table.addCell(getNormalCell("Người đăng ký", SIZE1, font));

			table.addCell(getNormalCell("Email", SIZE1, font));

			table.addCell(getNormalCell("Địa chỉ", SIZE1, font));

			table.addCell(getNormalCell("Điện thoại", SIZE1, font));

			table.addCell(getNormalCell("Giới tính", SIZE1, font));

			table.addCell(getNormalCell("Người đi cùng", SIZE1, font));

			// write table row data
			for (BookTour bookTour : listBookTours) {
				table.addCell(getNormalCell(String.valueOf(bookTour.getIdBT()), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusName(), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusEmail().toString(), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusAddress(), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusPhone().toString(), SIZE1, font));
				table.addCell(getNormalCell(bookTour.getCusSex(), SIZE1, font));
				table.addCell(getNormalCell(
						bookTour.getCusName1() + ", " + bookTour.getCusName2() + ", " + bookTour.getCusName3(), SIZE1,
						font));
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
