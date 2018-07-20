package ReadInfo;
import java.awt.Rectangle;
import java.io.File;
import net.sourceforge.tess4j.*;
//读取一张图片上的所有字符
public class ReadWords {
	private File image;      //要读取的文件
	private String words;    //得到的文字
	public ReadWords()
	{
		image = null;
		words = new String();
	}
	public ReadWords(File image) 
	{
		this.image = image;
		words = new String();
	}
	public void read() throws TesseractException
	{
		ITesseract instance = new Tesseract();
		instance.setLanguage("chi_sim");
		Rectangle rectangle = new Rectangle(0, 0, 600, 200);   //设定只读取图片的一部分
		try {
			
			words = instance.doOCR(image,rectangle);
		}
		catch (Exception e) {
			System.out.printf("图片%s无法读取!\n", image.getName());
		}
	}	
	public String getWords()
	{
		return words;
	}
	public File getImage()
	{
		return image;
	}
	public void setImage(File image)
	{
		this.image = image;
	}
}
