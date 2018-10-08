package ReadExcelData;
import java.io.*;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcel  {

	private static XSSFWorkbook wb;
	public static void main(String[] args) throws IOException {
		InputStream fis;
		fis = new FileInputStream(new File ("D:\\Testing\\SignUpTestData.xlsx"));
	    wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet1 = wb.getSheet("Sheet1");
	    String data0 = sheet1.getRow(1).getCell(3).getStringCellValue().toString();
	    System.out.println(data0);}

}
