package ReadInfo;
import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

public class OutputToExcel {
	private String desPath;     //excel�ļ�·��
	private File desFile;      
	private WritableWorkbook writeBook;   //excel�ļ�
	private WritableSheet sheet;     //������
	private int raw_name = 1;        //������Ƶ��к�
	private int col_name = 0;        //������Ƶ��к�
	private int raw_ID = 1;          //ID���к�
	private int col_ID = 1;          //ID���к�
	private String ID;   //Ҫ�������ҵע���
	private String name;   //��ҵ����
	public OutputToExcel(String s) throws IOException, RowsExceededException, WriteException
	{
		desPath = s;
		desFile = new File(desPath);
		writeBook = Workbook.createWorkbook(desFile);    //����·����excel�ļ���û���򴴽�
		sheet = writeBook.createSheet("��ҵ��Ϣ", 0);     //�½�һ��������
		sheet.setColumnView(0, 32);                      //���õ�1��2�п��
		sheet.setColumnView(1, 21);
		Label title1 = new Label(0,0,"��ҵ����");         //�½�������ͷ��Ԫ��
		Label title2 = new Label(1,0,"��ҵע���");
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
		Label nameLabel = new Label(col_name, raw_name++, name);      //�½���Ԫ��д�빤����
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
