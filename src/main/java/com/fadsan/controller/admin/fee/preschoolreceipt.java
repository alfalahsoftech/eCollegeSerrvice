package com.fadsan.controller.admin.fee;

import java.awt.Color;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.fadsan.models.dto.CommonDTO;
import com.fadsan.models.dto.FeesCategoriesDTO;
import com.fadsan.models.dto.StudentDTO;
import com.fadsan.models.dto.StudentFeeSubmissionDetailsDTO;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class preschoolreceipt extends AbstractPdfView {
	@Override
	protected Document newDocument() {
		return new Document(PageSize.A4.rotate());
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CommonDTO commonDTO = (CommonDTO) model.get("CommonDTO");
		String imagePath = request.getSession().getServletContext()
				.getRealPath("/");
		imagePath += "/img/prelogo.jpg";

		int i = 0;
		float total = 0f;

		document.open();
		PdfPTable tables1 = new PdfPTable(1);
		tables1.setWidthPercentage(100);
		PdfPTable tables2 = new PdfPTable(1);
		tables2.setWidthPercentage(100);
		PdfPTable tables = new PdfPTable(3);
		float[] columnWidthss = { 4.5f, 1, 4.5f  };
		tables.setWidths(columnWidthss);
		//tables.setWidthPercentage(100);

		PdfPTable tables31 = new PdfPTable(1);
		
		tables.setWidths(columnWidthss);
		tables.setWidthPercentage(100);
		PdfPTable tables3 = new PdfPTable(3);
		float[] columnWidthss3 = { 4.5f, 1, 4.5f };
		tables3.setWidths(columnWidthss3);
		tables.setWidthPercentage(100);
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(100);
		PdfPTable stable = new PdfPTable(1);
		stable.setWidthPercentage(100);
		PdfPTable table2 = new PdfPTable(3);
		PdfPTable table3 = new PdfPTable(5);
		float[] columnWidthss31 = { 3f, 3f, 1f, 3f, 3f };
		table3.setWidths(columnWidthss31);
		PdfPCell pCell;
		pCell = new PdfPCell();
		table.setHorizontalAlignment(Element.ALIGN_LEFT);
		table2.setHorizontalAlignment(Element.ALIGN_LEFT);
		table3.setHorizontalAlignment(Element.ALIGN_LEFT);
		table3.setWidthPercentage(100);

		float[] columnWidths = {4,5,3};
		table2.setWidths(columnWidths);
		table2.setWidthPercentage(100);
		Paragraph paragraph;
		paragraph = new Paragraph();

		
		paragraph
				.add(new Chunk(""));
		
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(paragraph);
		table2.addCell(pCell);
		pCell = new PdfPCell();
		Image img = Image.getInstance(imagePath);
		img.setAlignment(Element.ALIGN_RIGHT);

		pCell.addElement(new Chunk(img, 15, -5));
		pCell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(pCell);
		Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);
		font.setColor(Color.black);
		
		paragraph = new Paragraph();

		font = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);
		font.setColor(Color.black);
		paragraph
				.add(new Chunk(
						"9650084001\n Receipt.no"+commonDTO.getReceiptNo(),
						font));
		/*paragraph.setAlignment(Element.ALIGN_RIGHT);*/
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(paragraph);
		table2.addCell(pCell);
		/*tables31.addCell(new Paragraph("S No."
				+ String.valueOf(commonDTO.getReceiptNo()), font));
		for (StudentDTO studentDTO : commonDTO.getStudentDTOs()) {
			pCell = new PdfPCell();
			pCell.addElement(new Paragraph(studentDTO.getStudentId(), font));
			tables31.addCell(pCell);
		}*/
		
		paragraph = new Paragraph();

		font = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);
		font.setColor(Color.black);
		paragraph
				.add(new Chunk(
						"LITTLE BIRDS PLAY SCHOOL\n Adress:-F-267,K.C.Badkhal Road, Near Patel Chowk, Faridabad",
						font));
		paragraph.setAlignment(Element.ALIGN_CENTER);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(paragraph);
		Chunk chunk = new Chunk("Website:http://www.littlebirds.in\n",font);
		
		paragraph = new Paragraph();
		paragraph.add(chunk);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		pCell.addElement(paragraph);
		tables31.addCell(pCell);
		font = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);
		font.setColor(Color.black);
		
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(new Paragraph("Date.", font));
		table3.addCell(pCell);
		pCell = new PdfPCell();
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(new Paragraph(commonDTO.getLastDate(), font));
		table3.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(new Paragraph("", font));
		table3.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(new Paragraph("Month", font));
		table3.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(new Paragraph(commonDTO.getMonths(), font));
		table3.addCell(pCell);

		for (StudentDTO studentDTO : commonDTO.getStudentDTOs()) {
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph("Name.", font));
			table3.addCell(pCell);
			pCell = new PdfPCell();
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph(studentDTO.getFullName(), font));
			table3.addCell(pCell);
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph("", font));
			table3.addCell(pCell);
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph("Class", font));
			table3.addCell(pCell);
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph(studentDTO.getClassName(), font));
			table3.addCell(pCell);

			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph("Father's Name.", font));
			table3.addCell(pCell);
			pCell = new PdfPCell();
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph(studentDTO.getFatherName(), font));
			table3.addCell(pCell);
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph("", font));
			table3.addCell(pCell);
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph("Admission No.", font));
			table3.addCell(pCell);
			pCell = new PdfPCell();
			pCell.setBorder(Rectangle.NO_BORDER);
			pCell.addElement(new Paragraph(studentDTO.getStudentId(), font));
			table3.addCell(pCell);

		}

		/*
		 * pCell = new PdfPCell(); pCell.setBorder(Rectangle.NO_BORDER);
		 * 
		 * pCell.addElement(new Paragraph("Name of Student          "+
		 * commonDTO.getStudentDTO().getFirstName() + " " +
		 * commonDTO.getStudentDTO().getLastName() + "", font));
		 * table3.addCell(pCell); pCell = new PdfPCell();
		 * pCell.setBorder(Rectangle.NO_BORDER);
		 * 
		 * pCell = new PdfPCell(); pCell.setBorder(Rectangle.NO_BORDER);
		 * pCell.addElement(new Paragraph("Class:             " +
		 * commonDTO.getStudentDTO().getClassName() +
		 * "                         "+"for the month of"+"       " +
		 * commonDTO.getMonths(), font)); table3.addCell(pCell);
		 */

		pCell = new PdfPCell();

		pCell.setBorder(Rectangle.NO_BORDER);
		PdfPTable table1 = new PdfPTable(4);
		font = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);
		font.setColor(Color.black);
		float[] columnWidths1 = { 1, 5, 3, 1 };
		table1.setWidths(columnWidths1);
		table1.setWidthPercentage(100);
		pCell = new PdfPCell();
		pCell.setBorderWidthBottom(1);
		pCell.setBorderWidthTop(1);
		//pCell.setBorderWidthLeft(0);
		//pCell.setBorderWidthRight(0);
		pCell.addElement(new Paragraph("S No.", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorderWidthBottom(1);
		pCell.setBorderWidthTop(1);
		pCell.setBorderWidthLeft(0);
		pCell.setBorderWidthRight(0);
		pCell.addElement(new Paragraph("   PARTICULARS    ", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorderWidthRight(0);
		pCell.addElement(new Paragraph("Rs.", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();
		//pCell.setBorderWidthRight(0);
		pCell.addElement(new Paragraph("P.", font));
		table1.addCell(pCell);

		String paidBy = "";
		String chequeNo = "";
		font = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);
		font.setColor(Color.black);
		i = 1;

		for (FeesCategoriesDTO feedto : commonDTO.getFeecategoriesDTOs()) {
			pCell = new PdfPCell();

			pCell.addElement(new Paragraph("" + (i++) + "", font));
			table1.addCell(pCell);
			pCell = new PdfPCell();

			pCell.addElement(new Paragraph(feedto.getFeeCategoryName() + " ",
					font));
			table1.addCell(pCell);
			pCell = new PdfPCell();

			pCell.addElement(new Paragraph(feedto.getAmounts(), font));
			table1.addCell(pCell);
			pCell = new PdfPCell();

			pCell.addElement(new Paragraph("", font));
			table1.addCell(pCell);

		}
		StudentFeeSubmissionDetailsDTO studentFeeSubmissionDetailsDTO = commonDTO
				.getStudentFeeSubmissionDetailsDTO() ;
			paidBy = studentFeeSubmissionDetailsDTO.getPaidBy();
			if (studentFeeSubmissionDetailsDTO.getChequeNo() != null) {
				chequeNo = studentFeeSubmissionDetailsDTO.getChequeNo();
			} else
				chequeNo = "...........";
		
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("" + (i++) + "", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("Discount", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph(commonDTO.getDiscount(), font));
		total = commonDTO.getTotalFee()
				- Float.parseFloat(commonDTO.getDiscount());
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("Total Rs.", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph(String.valueOf(total),
				font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("Paid Amount Rs.", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph(String.valueOf(Float
				.parseFloat(commonDTO.getPaidAmount())), font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("Dues Rs.", font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph(commonDTO.getDue(), font));
		table1.addCell(pCell);
		pCell = new PdfPCell();

		pCell.addElement(new Paragraph("", font));
		table1.addCell(pCell);
		paragraph = new Paragraph();

		font = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);
		font.setColor(Color.black);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		paragraph = new Paragraph();
		paragraph.add(new Chunk("Received the amount by " + paidBy + ".",
				FontFactory.getFont(FontFactory.TIMES,10)));
		paragraph.setAlignment(Element.ALIGN_LEFT);
		pCell.addElement(paragraph);
		paragraph = new Paragraph(new Chunk("Cheque No-" + chequeNo,
				FontFactory.getFont(FontFactory.TIMES_BOLD, 10)));
		paragraph.setAlignment(Element.ALIGN_LEFT);
		pCell.addElement(paragraph);
		paragraph = new Paragraph(new Chunk(
				"Subject to realisation of Cheque.", FontFactory.getFont(
						FontFactory.TIMES_BOLD, 10)));
		paragraph.setAlignment(Element.ALIGN_LEFT);
		pCell.addElement(paragraph);

		paragraph = new Paragraph(new Chunk("Office Asstt.\n",
				FontFactory.getFont(FontFactory.TIMES,10)));
		paragraph.setAlignment(Element.ALIGN_RIGHT);
		pCell.addElement(paragraph);

		paragraph = new Paragraph(new Chunk(
				"*******Computer Generated Fee Receipt******\n" + new Date(),
				FontFactory.getFont(FontFactory.TIMES, 9)));

		paragraph.setAlignment(Element.ALIGN_CENTER);
		pCell.addElement(paragraph);

		/* table.completeRow(); */
		table.addCell(pCell);
		paragraph = new Paragraph();

		font = FontFactory.getFont(FontFactory.TIMES_BOLD,10);
		font.setColor(Color.black);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		paragraph = new Paragraph();
		paragraph.add(new Chunk("Received the amount by " + paidBy + ".",
				FontFactory.getFont(FontFactory.TIMES, 10)));
		paragraph.setAlignment(Element.ALIGN_LEFT);
		pCell.addElement(paragraph);
		paragraph = new Paragraph(new Chunk("Cheque No-" + chequeNo,
				FontFactory.getFont(FontFactory.TIMES_BOLD, 10)));
		paragraph.setAlignment(Element.ALIGN_LEFT);
		pCell.addElement(paragraph);
		paragraph = new Paragraph(new Chunk(
				"Subject to realisation of Cheque.", FontFactory.getFont(
						FontFactory.TIMES_BOLD, 10)));
		paragraph.setAlignment(Element.ALIGN_LEFT);
		pCell.addElement(paragraph);

		paragraph = new Paragraph(new Chunk("Office Asstt.\n",
				FontFactory.getFont(FontFactory.TIMES, 10)));
		paragraph.setAlignment(Element.ALIGN_RIGHT);
		pCell.addElement(paragraph);

		paragraph = new Paragraph(new Chunk(
				"*******Computer Generated Fee Receipt******\n" + new Date(),
				FontFactory.getFont(FontFactory.TIMES, 9)));

		paragraph.setAlignment(Element.ALIGN_CENTER);
		pCell.addElement(paragraph);

		stable.addCell(pCell);

		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(table2);
		tables1.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(tables31);
		tables1.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(table3);
		tables1.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(table1);
		tables1.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(table);
		tables1.addCell(pCell);

		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(table2);
		tables2.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(tables31);
		tables2.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(table3);
		tables2.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(table1);
		tables2.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(stable);
		tables2.addCell(pCell);

		tables3.addCell(pCell);
		pCell = new PdfPCell();
        pCell.setLeft(1);
		pCell.addElement(tables1);
		tables.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setBorder(Rectangle.NO_BORDER);
		pCell.addElement(new Paragraph(new Chunk("    ")));
		tables.addCell(pCell);
		pCell = new PdfPCell();
		pCell.setRight(1);
		pCell.addElement(tables2);
		tables.addCell(pCell);
		document.add(tables3);
		document.add(tables);
		document.close();

	}

}
