package RRMMS.TestData;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelData {
	static Workbook book;
	static Sheet sheet;
	public static Sheet GetData(String Sheetname) throws BiffException, IOException
	{
		book=Workbook.getWorkbook(new File("./RRMMS_testData.xls"));
		sheet = book.getSheet(""+Sheetname);
		return sheet;
	}

}
