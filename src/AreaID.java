
import java.io.File;

import java.util.ArrayList;


import jxl.Cell;

import jxl.Sheet;
import jxl.Workbook;

public class AreaID {
	private ArrayList<String> arrayList=new ArrayList<>();
	
	
	public ArrayList<String> getAreaID()  {
		Workbook readwb;
		try {
			readwb=Workbook.getWorkbook(new File("areaid.xls"));
			
			Sheet readSheet=readwb.getSheet(0);
			int rsRows =readSheet.getRows();
			
			for(int i=0;i<rsRows;i++){
				Cell cell=readSheet.getCell(0,i);
				arrayList.add(cell.getContents());
				//System.out.println(cell.getContents()+" ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return arrayList;
	}
	
	public ArrayList<String> getCityname()  {
		Workbook readwb;
		try {
			readwb=Workbook.getWorkbook(new File("areaid.xls"));
			
			Sheet readSheet=readwb.getSheet(0);
			int rsRows =readSheet.getRows();
			
			for(int i=0;i<rsRows;i++){
				Cell cell=readSheet.getCell(6,i);
				arrayList.add(cell.getContents());
				//System.out.println(cell.getContents()+" ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return arrayList;
	}
	
}
