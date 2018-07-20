package ReadInfo;
import java.awt.Rectangle;
import java.io.File;
import net.sourceforge.tess4j.*;
//��ȡһ��ͼƬ�ϵ������ַ�
public class ReadWords {
	private File image;      //Ҫ��ȡ���ļ�
	private String words;    //�õ�������
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
		Rectangle rectangle = new Rectangle(0, 0, 600, 200);   //�趨ֻ��ȡͼƬ��һ����
		try {
			
			words = instance.doOCR(image,rectangle);
		}
		catch (Exception e) {
			System.out.printf("ͼƬ%s�޷���ȡ!\n", image.getName());
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
