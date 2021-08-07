package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	XSSFSheet book;

	public ExcelReader() throws IOException {
		String currentDir = System.getProperty("user.dir");
		
		FileInputStream input = new FileInputStream(currentDir+"\\src\\test\\resources\\TestExcel.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(input);
		book = w.getSheet("Sheet1");

	}

	public String readExcelSheet(int i, int j) {
		Row rowObj = book.getRow(i); // get row number in excel sheet
		Cell cellObj = rowObj.getCell(j); // get Column in ith Row

		int cellType = cellObj.getCellType();
		switch (cellType) {
		case Cell.CELL_TYPE_NUMERIC: {
			double dat = cellObj.getNumericCellValue();
			return String.valueOf(dat); // converts numeric to String
		}
		case Cell.CELL_TYPE_STRING: {
			return cellObj.getStringCellValue();
		}

		}
		return null;
	}
}