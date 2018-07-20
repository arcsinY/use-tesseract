package ReadInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sourceforge.tess4j.TesseractException;

public class Window extends JFrame implements ActionListener{
	private JTextPane text1;
	private JTextPane text2;
	private JPanel panel;
	private JTextField field1;
	private JTextField field2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JFileChooser choose1;
	private JFileChooser choose2;
	public Window()
	{
		super("读取企业信息");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(700, 150);
		this.setLocation(600, 300);
		panel = new JPanel();
		this.add(panel);
		field1 = new JTextField(15);
		field2 = new JTextField(15);
		button1 = new JButton("打开");
		button2 = new JButton("保存");
		button3 = new JButton("开始");
		text1 = new JTextPane();
		text2 = new JTextPane();
		choose1 = new JFileChooser();
		choose1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		choose2 = new JFileChooser();
		text1.setText("图片文件夹路径:");
		panel.add(text1);
		text2.setText("生成路径:");
		panel.add(field1);
		panel.add(button1);
		panel.add(text2);
		panel.add(field2);
		panel.add(button2);
		panel.add(button3);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("打开"))
		{
			choose1.showOpenDialog(null);
			field1.setText(choose1.getSelectedFile().getPath());
		}
		if(e.getActionCommand().equals("保存"))
		{
			choose2.showOpenDialog(null);
			field2.setText(choose2.getSelectedFile().getPath());
		}
		if(e.getActionCommand().equals("开始"))
		{
			if(choose1.getSelectedFile() == null || choose2.getSelectedFile() == null)
				JOptionPane.showMessageDialog(null, "没有选择文件路径");
			else
			{
				JOptionPane.showMessageDialog(null, "开始读取，预计时间三分钟");
				CenterUnit cUnit = new CenterUnit();
				try {
					cUnit.centerUnit(choose1.getSelectedFile().getAbsolutePath(), choose2.getSelectedFile().getAbsolutePath());
				} catch (RowsExceededException e1) {
					e1.printStackTrace();
				} catch (WriteException e1) {
					JOptionPane.showMessageDialog(null, "写入文件失败!");
					e1.printStackTrace();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "读取图片失败!请检查图片格式");
					e1.printStackTrace();
				} catch (TesseractException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "完成!");
			}
		}
	}
}

