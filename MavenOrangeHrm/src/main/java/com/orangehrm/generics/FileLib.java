package com.orangehrm.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author BTM-FACULTY
 *
 */
public class FileLib {

	public String getPropertyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
/**
 * generic method for reading the data from excel
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 * @throws InvalidFormatException 
 */
	public String getExcelValue(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException, InvalidFormatException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
}
