 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class MakeAttributePane extends JPanel{
	JPanel up_panel, down_panel, all_panel;
	String startxStr, startyStr, widthStr, heightStr,textStr;
	MakeAttributePane(){
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		up_panel = new JPanel(new GridLayout(5,2));
		down_panel = new JPanel();
		all_panel=new JPanel(new GridLayout(2,1));
		
		JLabel startx=new JLabel("Start x : ");
		JTextField startxField=new JTextField(4);
		startxField.setText(startxStr);
		JLabel starty=new JLabel("Start y : ");
		JTextField startyField=new JTextField(4);
		startyField.setText(startyStr);
		JLabel width=new JLabel("Width : ");
		JTextField widthField=new JTextField(4);
		widthField.setText(widthStr);
		JLabel height=new JLabel("Height : ");
		JTextField heightField=new JTextField(4);
		heightField.setText(heightStr);
		JLabel text=new JLabel("NodeText : ");
		JTextField textField=new JTextField(7);
		textField.setText(textStr);
		JButton change=new JButton("Change");
		
		panel1.add(startx);
		panel1.add(startxField);
		panel2.add(starty);
		panel2.add(startyField);
		panel3.add(width);
		panel3.add(widthField);
		panel4.add(height);
		panel4.add(heightField);		
		panel5.add(text);
		panel5.add(textField);
		
		up_panel.add(startx);
		up_panel.add(startxField);
		up_panel.add(starty);
		up_panel.add(startyField);
		up_panel.add(width);
		up_panel.add(widthField);
		up_panel.add(height);
		up_panel.add(heightField);
		up_panel.add(text);
		up_panel.add(textField);

/*		up_panel.add(panel1);
		up_panel.add(panel2);
		up_panel.add(panel3);
		up_panel.add(panel4);
		up_panel.add(panel5);
*/		down_panel.add(change);
		
		all_panel.add(up_panel);
		all_panel.add(down_panel);
	
		change.addMouseListener(new MyMouseAdapter());
	}
	private class MyMouseAdapter extends MouseAdapter{
		String startx;
		String starty;
		String width;
		String height;
		String str;
		
		public void mouseClicked(MouseEvent e) {		
			startx=((JTextField)MakeWindow.attributePane.up_panel.getComponent(1)).getText();
			starty=((JTextField)MakeWindow.attributePane.up_panel.getComponent(3)).getText();
			width=((JTextField)MakeWindow.attributePane.up_panel.getComponent(5)).getText();
			height=((JTextField)MakeWindow.attributePane.up_panel.getComponent(7)).getText();
			str=((JTextField)MakeWindow.attributePane.up_panel.getComponent(9)).getText();

			Status s=new Status(Integer.parseInt(startx),Integer.parseInt(starty),Integer.parseInt(width),Integer.parseInt(height),str);
			s.getAttribute();
			

		}
	}
}