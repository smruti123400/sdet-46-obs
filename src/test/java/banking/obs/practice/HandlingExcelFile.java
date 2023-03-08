package banking.obs.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class HandlingExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataFormatter df =new DataFormatter();
		
		// convert the physical file into java
FileInputStream fis= new FileInputStream("src/test/resources/Copy of Online Banking System(1)   acharya.xlsx");
	//step-2 open excel
Workbook wb = WorkbookFactory.create(fis);
//step-3 get control on sheet
Sheet sheet = wb.getSheet("System Test Case");
//step-4 get control on row
Row row = sheet.getRow(1);
//step-5 get contrll on cell
Cell cell = row.getCell(6);
//step-6 fetch data

String data = df.formatCellValue(cell);
//utilize data
System.out.println(data);
wb.close();
fis.close();



}
}
