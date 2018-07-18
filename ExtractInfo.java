package ReadInfo;

public class ExtractInfo {
	private String words;                 //读取出的字符串
	private String name;                  //企业名称
	private String ID;                    //企业注册号（字符串）
	private char[] number;                //企业注册号（字符数组）
	private char[] originalWords;         //读出的字符数组
	public ExtractInfo()
	{
		words = new String();
		name = new String();
		ID = new String();
		number = new char[18];
	}
	public ExtractInfo(String words)
	{
		this.words = new String(words);
		name = new String();
		ID = new String();
		number = new char[18];
		originalWords = new char[words.length()];
	}
	public void extractName()        //提取企业名称
	{
		if(ID.equals("000"))
			return;
		String start="名称";
		String end="类";
		int a = words.indexOf(start);
		int b = words.indexOf(end);
		name=words.substring(a+5,b);
	}
	public void extractID()          //提取企业注册号
	{
		int index = 0;
		if(words.length() >= 2)
			originalWords = words.toCharArray();
		if(originalWords[0] != '企')
		{
			ID = "000";
			name = "该图片无法识别";
			return;
		}
		while(originalWords[index] < '\u0030' || originalWords[index] > '\u0039')  //找出第一个数字，之后读取18位
		{	
			++index;
		}
		for(int i = 0;i < 18;++i)
		{
			number[i] = originalWords[index];
			++index;
		}
		ID = String.valueOf(number);
	}
	public String getID()
	{
		return ID;
	}
	public String getName()
	{
		return name;
	}
	public void setWords(String words)
	{
		this.words = words;
		if(words.length() < 2 || words == null)
			{
				originalWords = new char[1];
				originalWords[0] = 'n';
			}
		else
			originalWords = new char[words.length()];
	}
}
