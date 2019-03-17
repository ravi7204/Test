package EXcel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import TestBase.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Excel_class extends Base {

		static Sheet sh;
		static Workbook wb;
		public static String folderpath=getconfig("folderpath");
		static WritableSheet wsh;
		static WritableWorkbook wwb;
		public static void excelconnection(String filename,String sheetname)
		{
			try {
				File f=new File(folderpath+filename);
				
				wb=Workbook.getWorkbook(f);
				
					sh=wb.getSheet(sheetname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		public static int rcount()
		{
			int rows=sh.getRows();
			return rows;
		}
		public static int ccount()
		{
			int col=sh.getColumns();
			return col;
		}
		public static String readdata(int col,int row)
		{
			String x=sh.getCell(col, row).getContents();
			return x;
		}
		
		public static void outputexcelconnection(String ifilename,String ofilename,String sheetname)
		{
			try {
				FileInputStream fis=new FileInputStream(folderpath+ifilename);
				
				 wb=Workbook.getWorkbook(fis);
				
				sh=wb.getSheet(sheetname);
				FileOutputStream fos=new FileOutputStream(folderpath+ofilename);
				 wwb=Workbook.createWorkbook(fos,wb);
				
			 wsh=wwb.getSheet(sheetname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
		public static void writedata(int c,int r,String data)
		{
			try {
				Label l=new Label(c, r, data);
				wsh.addCell(l);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		public static void saveworkbook()
		{
			try {
				wwb.write();
				wwb.close();wb.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}


