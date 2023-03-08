package banking.obs.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchdatafromexcel3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException   {
		DataFormatter df =new DataFormatter();
	
	
FileInputStream fis= new FileInputStream("src/test/resources/Copy of Online Banking System(1)   acharya.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("System Test Case");

int rowcount = sheet.getLastRowNum();
String data="";
for(int i=1;i<=rowcount;i++) {
   String key = df.formatCellValue(sheet.getRow(i).getCell(0));
          System.out.println(key);
          if(key.equals("TC-04")) {
        	//  for (int j=0;j < sheet.getRow(i).getLastCellNum();j++) {
        	//	  df.formatCellValue(sheet.getRow(i).getCell(j));
        	//	  if(key.equals("Test step")) {

        	//		  data= df.formatCellValue(sheet.getRow(i+1).getCell(j));  
        			  break;
        		  
        		  }
        	 
        	  break;
          }

          System.out.println(data);

}


	
}