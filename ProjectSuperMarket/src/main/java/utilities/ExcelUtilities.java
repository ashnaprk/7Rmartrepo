package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtilities {
	static FileInputStream f; //represent excel workbook file read
	static XSSFWorkbook w;    //excel work book entire representation
	static XSSFSheet sh;      //represent sheet in excel work book
	
	public static String getStringData(int a, int b,String sheet)throws IOException { //to read string data
	
		//f = new FileInputStream("C:\\Users\\ashna\\eclipse-workspace\\mavenproject\\src\\main\\resources\\Book1.xlsx");
	f=new FileInputStream(Constant.TESTDATAFILE);
	w = new XSSFWorkbook(f); //apache poi entirely add excel workbook file to memory(allocation)
	sh = w.getSheet(sheet);//sheet 1 reprentation in a workbook
	XSSFRow r =sh.getRow(a);  //read cell values-row
	XSSFCell c = r.getCell (b);//read cell values-col
	return c.getStringCellValue ();// getting text format
	}
	
	public static String getIntData(int a, int b, String sheet)throws IOException {  //to read integer data
	f = new FileInputStream(Constant.TESTDATAFILE);
	w = new XSSFWorkbook(f);  //apache poi entirely add excel workbook file to memory(allocation)
	sh = w.getSheet(sheet);  //sheet 1 reprentation in a workbook
	XSSFRow r =sh.getRow (a);
	XSSFCell c = r.getCell (b);//same as above
	int val = (int)c.getNumericCellValue(); 
	return String.valueOf(val);             //convertdouble to int using typecasting return String.valueOf (val);
	                                        //convert int to string using valueOf() method
	                                        //return val;

	

	}
}
