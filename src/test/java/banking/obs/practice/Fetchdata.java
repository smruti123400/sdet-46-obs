package banking.obs.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetchdata {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
DataFormatter df =new DataFormatter();
		
	
FileInputStream fis= new FileInputStream("src/test/resources/Copy of Online Banking System(1)   acharya.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("System Test Case");

int rowcount = sheet.getLastRowNum();

short cellcount = sheet.getRow(1).getLastCellNum();
                      for(int i=1;i<=rowcount;i++) {
	                       for (int j=0;j<cellcount;j++) {
		                         System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
	}
}


wb.close();
fis.close();


	}

}
