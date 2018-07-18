package ReadInfo;

public class ExtractInfo {
	private String words;                 //��ȡ�����ַ���
	private String name;                  //��ҵ����
	private String ID;                    //��ҵע��ţ��ַ�����
	private char[] number;                //��ҵע��ţ��ַ����飩
	private char[] originalWords;         //�������ַ�����
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
	public void extractName()        //��ȡ��ҵ����
	{
		if(ID.equals("000"))
			return;
		String start="����";
		String end="��";
		int a = words.indexOf(start);
		int b = words.indexOf(end);
		name=words.substring(a+5,b);
	}
	public void extractID()          //��ȡ��ҵע���
	{
		int index = 0;
		if(words.length() >= 2)
			originalWords = words.toCharArray();
		if(originalWords[0] != '��')
		{
			ID = "000";
			name = "��ͼƬ�޷�ʶ��";
			return;
		}
		while(originalWords[index] < '\u0030' || originalWords[index] > '\u0039')  //�ҳ���һ�����֣�֮���ȡ18λ
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
