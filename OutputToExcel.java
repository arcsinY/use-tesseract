package ReadInfo;
import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

public class OutputToExcel {
	private String desPath;     //excel文件路径
	private File desFile;      
	private WritableWorkbook writeBook;   //excel文件
	private WritableSheet sheet;     //工作簿
	private int raw_name = 1;        //输出名称的行号
	private int col_name = 0;        //输出名称的列号
	private int raw_ID = 1;          //ID的行号
	private int col_ID = 1;          //ID的列号
	private String ID;   //要输出的企业注册号
	private String name;   //企业名称
	public OutputToExcel(String s) throws IOException, RowsExceededException, WriteException
	{
		desPath = s;
		desFile = new File(desPath);
		writeBook = Workbook.createWorkbook(desFile);    //根据路径打开excel文件，没有则创建
		sheet = writeBook.createSheet("企业信息", 0);     //新建一个工作簿
		sheet.setColumnView(0, 32);                      //设置第1，2列宽度
		sheet.setColumnView(1, 21);
		Label title1 = new Label(0,0,"企业名称");         //新建两个表头单元格
		Label title2 = new Label(1,0,"企业注册号");
		sheet.addCell(title1);
		sheet.addCell(title2);
	}
	public void setInfo(String ID, String name)
	{
		this.ID = ID;
		this.name = name;
	}
	public void CreateCell() throws RowsExceededException, WriteException
	{
		Label nameLabel = new Label(col_name, raw_name++, name);      //新建单元格，写入工作簿
		Label IDLabel = new Label(col_ID, raw_ID++, ID); 
		sheet.addCell(nameLabel);
		sheet.addCell(IDLabel);
	}
	public void finalWrite() throws WriteException, IOException
	{
		writeBook.write();
		writeBook.close();
	}
	public WritableWorkbook getWriteBook()
	{
		return writeBook;
	}
}
