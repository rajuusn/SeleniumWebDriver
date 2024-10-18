import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int RowCount(String xlfile, String xlsheet) throws IOException {
		
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		int totalrows=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return totalrows;
		
		
		
	}
	public static int CellCount(String xlfile, String Xlsheet, int RowNumber) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(Xlsheet);
		row=sheet.getRow(RowNumber);
		int columns=row.getLastCellNum();
		workbook.close();
		fi.close();
		return columns;
		
		
	}
	public static String GetCellValue(String xlfile, String xlsheet, int RowNumber, int ColumnNumber) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(RowNumber);
		cell=row.getCell(ColumnNumber);
		String data;
		try {
		DataFormatter df=new DataFormatter();
		data=df.formatCellValue(cell);}
		catch(Exception e) {
			data=" ";
		}
		
		workbook.close();
		fi.close();
		return data;
	}
	public static void SetCellData(String xlfile, String xlsheet, int RowNumber, int ColNumber, String data) throws IOException {
		
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(RowNumber);
		cell=row.createCell(ColNumber);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

}
