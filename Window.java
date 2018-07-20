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
		super("��ȡ��ҵ��Ϣ");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(700, 150);
		this.setLocation(600, 300);
		panel = new JPanel();
		this.add(panel);
		field1 = new JTextField(15);
		field2 = new JTextField(15);
		button1 = new JButton("��");
		button2 = new JButton("����");
		button3 = new JButton("��ʼ");
		text1 = new JTextPane();
		text2 = new JTextPane();
		choose1 = new JFileChooser();
		choose1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		choose2 = new JFileChooser();
		text1.setText("ͼƬ�ļ���·��:");
		panel.add(text1);
		text2.setText("����·��:");
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
		if(e.getActionCommand().equals("��"))
		{
			choose1.showOpenDialog(null);
			field1.setText(choose1.getSelectedFile().getPath());
		}
		if(e.getActionCommand().equals("����"))
		{
			choose2.showOpenDialog(null);
			field2.setText(choose2.getSelectedFile().getPath());
		}
		if(e.getActionCommand().equals("��ʼ"))
		{
			if(choose1.getSelectedFile() == null || choose2.getSelectedFile() == null)
				JOptionPane.showMessageDialog(null, "û��ѡ���ļ�·��");
			else
			{
				JOptionPane.showMessageDialog(null, "��ʼ��ȡ��Ԥ��ʱ��������");
				CenterUnit cUnit = new CenterUnit();
				try {
					cUnit.centerUnit(choose1.getSelectedFile().getAbsolutePath(), choose2.getSelectedFile().getAbsolutePath());
				} catch (RowsExceededException e1) {
					e1.printStackTrace();
				} catch (WriteException e1) {
					JOptionPane.showMessageDialog(null, "д���ļ�ʧ��!");
					e1.printStackTrace();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "��ȡͼƬʧ��!����ͼƬ��ʽ");
					e1.printStackTrace();
				} catch (TesseractException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "���!");
			}
		}
	}
}

