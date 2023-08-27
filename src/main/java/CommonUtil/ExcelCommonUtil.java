package CommonUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCommonUtil {
	
	FileInputStream file;
	public String ReadTestData(String SheetName,int rowno, int colno)
	{
		String sretCellvalue ="";
	
    try
    {
        
    	file = new FileInputStream(new File("	//../src/test/resources/VideoIndexerTest.xlsx"));

       
        XSSFWorkbook workbook = new XSSFWorkbook(file);     
        XSSFSheet sheet = workbook.getSheet(SheetName);        
        sretCellvalue = sheet.getRow(rowno).getCell(colno).getStringCellValue();    
        
        
       
    } 
    catch (Exception e) 
    {
    
        e.printStackTrace();
    }
    return sretCellvalue;
}
	
	public int getRowCount(String SheetName) throws IOException
	{
		
   
    	file = new FileInputStream(new File("	//../src/test/resources/VideoIndexerTest.xlsx"));       
        XSSFWorkbook workbook = new XSSFWorkbook(file);     
        XSSFSheet sheet = workbook.getSheet(SheetName);        
        return sheet.getLastRowNum();  
        
       
  
}
	public void CloseExcel() throws IOException
	{
		if(file!=null)
		 file.close();
	}
}
