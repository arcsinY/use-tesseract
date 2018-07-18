package ReadInfo;

import java.io.File;
import java.util.ArrayList;
//��ȡָ���ļ����µ�����ͼƬ������һ��������
public class InputImage {
	private  String srcPath;   //�ļ���·��
	private File srcFile;      //�ļ���
	private ArrayList<File> allImage;     //�������ͼƬ������
	public InputImage(String path)
	{
		srcPath = path;
		srcFile = new File(srcPath);
		allImage = new ArrayList<>();
	}
	public void readImage()
	{
		File[] files = srcFile.listFiles();           //listFiles���������õ��ļ����������ļ��ľ���·��������һ��File����
		if(files == null)
		{
			System.out.println("�����ļ���·������");
			return;
		}
		for(File file:files)
		{
			String fileName = file.getName();
			if(fileName.endsWith(".jpg") || fileName.endsWith(".png"))      //���ݺ�׺���ҵ�ͼƬ����ӽ�����
				allImage.add(file);
		}
	}
	public ArrayList<File> getAllImage()
	{
		return allImage;
	}
}
