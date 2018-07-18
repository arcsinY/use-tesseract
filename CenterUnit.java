package ReadInfo;

import java.io.File;
import java.io.IOException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sourceforge.tess4j.TesseractException;

public class CenterUnit {
	private ReadWords rWords;
	private ExtractInfo info;
	private OutputToExcel output;
	private InputImage input;
	public void centerUnit(String inputPath, String outputPath) throws RowsExceededException, WriteException, IOException, TesseractException
	{
		//初始化所有类
		rWords = new ReadWords();
		info = new ExtractInfo();
		output = new OutputToExcel(outputPath);
		input = new InputImage(inputPath);
		input.readImage();
		for(File file:input.getAllImage())
		{
			rWords.setImage(file);
			rWords.read();
			info.setWords(rWords.getWords());             //ReadWords的识别结果传给ExtractInfo
			info.extractID();
			info.extractName();
			output.setInfo(info.getID(), info.getName());
			output.CreateCell();
		}	        	
		output.finalWrite();
	}
}
