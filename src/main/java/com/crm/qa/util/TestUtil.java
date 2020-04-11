package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIME = 50;
	public static long IMPLICIT_WAIT = 50;

	String TEST_DATA_PATH = "C:/Selenium Practice/FreeCRMTest/src/main/java" + "/com/crm/qa/testdata/TestData.xls";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	@DataProvider
	public Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = null;
		file = new FileInputStream(TEST_DATA_PATH);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);

		String inputData[][] = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				inputData[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return inputData;

	}

	public void takeScreenShot() throws Throwable {
     try {
		TakesScreenshot ts = (TakesScreenshot)driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 
		 String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		 File destination = new File(path);
		 
		 FileUtils.copyFile(source, destination);
	} catch (Exception e){
     
     System.out.println("CapturedFailed"+e.getMessage());
     
	}
	}
}
