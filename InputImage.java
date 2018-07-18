package ReadInfo;

import java.io.File;
import java.util.ArrayList;
//读取指定文件夹下的所有图片，放在一个数组中
public class InputImage {
	private  String srcPath;   //文件夹路径
	private File srcFile;      //文件夹
	private ArrayList<File> allImage;     //存放所有图片的数组
	public InputImage(String path)
	{
		srcPath = path;
		srcFile = new File(srcPath);
		allImage = new ArrayList<>();
	}
	public void readImage()
	{
		File[] files = srcFile.listFiles();           //listFiles（）方法得到文件夹下所有文件的绝对路径，返回一个File数组
		if(files == null)
		{
			System.out.println("输入文件夹路径错误");
			return;
		}
		for(File file:files)
		{
			String fileName = file.getName();
			if(fileName.endsWith(".jpg") || fileName.endsWith(".png"))      //根据后缀名找到图片，添加进数组
				allImage.add(file);
		}
	}
	public ArrayList<File> getAllImage()
	{
		return allImage;
	}
}
