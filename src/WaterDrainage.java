import java.io.File;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class WaterDrainage {
private ArrayList<String> arrayList=new ArrayList<>();
	
	
	public ArrayList<String> getWaterDrainage()  {
		Workbook readwb;
		try {
			readwb=Workbook.getWorkbook(new File("water_drainage.xls"));
			
			Sheet readSheet=readwb.getSheet(0);
			int rsRows =readSheet.getRows();
			
			for(int i=0;i<rsRows;i++){
				Cell cell=readSheet.getCell(1,i);
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
