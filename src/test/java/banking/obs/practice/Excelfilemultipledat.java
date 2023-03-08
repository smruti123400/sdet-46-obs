package banking.obs.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelfilemultipledat {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	String exptname = "open account" ;
DataFormatter df = new DataFormatter();
FileInputStream fis = new FileInputStream("./src/main/resources/testcases/classpractise.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("Sheet1");
int rowcount = sheet.getLastRowNum();
Map<String, String> map= new HashMap<String, String>();
for (int i= 1;i<=rowcount;i++) {
	String tsname = df.formatCellValue(sheet.getRow(i).getCell(0));
	if(tsname.equals(exptname)) {
		for(int j=1;j<sheet.getRow(i).getLastCellNum();j++) {
			 String key = df.formatCellValue(sheet.getRow(i).getCell(j));
			String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			map.put(key, value);
			
		}
		break;
	}
}
	System.out.println(map.get("name") +"     "+ map.get("gender"));
}
	}

		
	

		
	
