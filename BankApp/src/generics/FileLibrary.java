package generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class FileLibrary implements Constants {

	public String getCellData(String sh,int r, int c)
	{
		
		try {
			FileInputStream fis = new FileInputStream(Excel_Path);
			Workbook wb=WorkbookFactory.create(fis);
			String val=wb.getSheet(sh).getRow(r).getCell(c).toString();
			return val;
		} 
		catch (Exception e) {
			return "";
		}
	}
		public void writeCellData(String sh, int r,int c,String data)
		{
			try {
			FileInputStream fis = new FileInputStream(Excel_Path);
			Workbook wb=WorkbookFactory.create(fis);
			Cell ce = wb.getSheet(sh).getRow(r).createCell(c);
			ce.setCellValue(data);
			FileOutputStream fos=new FileOutputStream(Excel_Path);
			wb.write(fos);
			wb.close();
		}
			catch(Exception t){
				Reporter.log("Wrong column");
			}
		}
		public String getKeyValue(String k)
		{
			try {
				FileInputStream fis = new FileInputStream(Properties_Path);
				Properties prop=new Properties();
				prop.load(fis);
				String key=prop.getProperty(k);
				return key;
			} catch (Exception e) {
				
				return "";
			}
			
		}
		public String validateMsg(String actRes,String expRes)
		{
			try
			{
				SoftAssert sa=new SoftAssert();
				sa.assertEquals(actRes, expRes);
				return "pass";
			}
			catch (Exception e)
			{
				return "fail";
			}
			
		}
}
