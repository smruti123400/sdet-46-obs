package banking.obs.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class OutputExcel {

	public static void main(String[] args) throws IOException {
		
	DataFormatter df =new DataFormatter();
		

FileInputStream fis= new FileInputStream("src/test/resources/Copy of Online Banking System(1)   acharya.xlsx");

Workbook wb = WorkbookFactory.create(fis);

Sheet sheet = wb.getSheet("System Test Case");

Row row = sheet.getRow(1);

Cell cell = row.createCell(9);

cell.setCellValue("tc pass");

FileOutputStream fos= new FileOutputStream("src/test/resources/Copy of Online Banking System(1)   acharya.xlsx");
wb.write(fos);

wb.close();
fis.close();



}

	

}


