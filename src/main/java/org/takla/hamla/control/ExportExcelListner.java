package org.takla.hamla.control;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelListner implements ActionListener {
	private JTable table;
	private JFileChooser fileChooser;
	private JPanel parent;
	private String fileName;

	public ExportExcelListner(JTable table, JPanel parent, String fileName) {
		this.table = table;
		this.fileChooser = new JFileChooser();
		this.parent = parent;
		this.fileName = fileName;
	}

	public void actionPerformed(ActionEvent e) {

		// Handle open button action.
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showSaveDialog(parent);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Date date = new Date();
			Format formatter = new SimpleDateFormat("YYYY-MM-dd_hh-mm-ss");
			String filePath = fileChooser.getSelectedFile().getAbsolutePath() + "\\" + fileName + " "
					+ formatter.format(date);
			// saveXls(filePath);
			File file = saveXLSX(filePath);

			if (file != null) {
				Object[] options = new Object[] { "فتح المجلد", "فتح الملف", "خروج" };
				int i = JOptionPane.showOptionDialog(null, "تم حفظ الملف الجديد", "عملية ناجحة",
						JOptionPane.INFORMATION_MESSAGE, 2, null, options, options[0]);
				try {
					if (i == 0) {

						Runtime.getRuntime().exec("explorer.exe /select," + file.getAbsolutePath());
					} else if (i == 1) {
						Desktop dt = Desktop.getDesktop();
						dt.open(file);

					}
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "خطأ اثناء استخراج الملف الجديد", "تحذير",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			// the user cancel or exit export
		} else {
			JOptionPane.showMessageDialog(null, "برجاء اختار المكان المفضل لحفظ الملف الجديد", "تحذير",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private File saveXLSX(String filePath) {
		try {
			File file = new File(filePath + ".xlsx");
			TableModel model = table.getModel();
			//
			@SuppressWarnings("resource")
			XSSFWorkbook myWorkBook = new XSSFWorkbook();
			XSSFSheet mySheet = myWorkBook.createSheet("sheet1");

			XSSFCellStyle centerStyle = myWorkBook.createCellStyle();
			centerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// write header to file (columns)
			XSSFRow row = mySheet.createRow(0);
			for (int i = 0; i < model.getColumnCount(); i++) {
				XSSFCell cell = row.createCell(model.getColumnCount() - 1 - i);
				cell.setCellStyle(centerStyle);
				cell.setCellValue(model.getColumnName(i));
			}

			int j = 0;
			for (int i = 0; i < model.getRowCount(); i++) {
				XSSFRow row1 = mySheet.createRow(i + 1);
				for (j = 0; j < model.getColumnCount(); j++) {
					XSSFCell cell = row1.createCell(model.getColumnCount() - 1 - j);
					Object obj = model.getValueAt(i, j);
					if (obj == null) {
						cell.setCellValue("");
					} else if (obj instanceof String) {
						cell.setCellValue((String) obj);
					} else if (obj instanceof Double) {
						cell.setCellStyle(centerStyle);
						cell.setCellValue((Double) obj);
					} else if (obj instanceof Integer) {
						cell.setCellStyle(centerStyle);
						cell.setCellValue(((Integer) obj).doubleValue());
					} else {
						cell.setCellValue(obj.toString());
					}
				}
			}

			// open an OutputStream to save written data into XLSX file
			FileOutputStream fileOut = new FileOutputStream(file);
			myWorkBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			System.out.println("Writing on XLSX file Finished ...");

			return file;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
