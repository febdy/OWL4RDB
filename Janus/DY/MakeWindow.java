import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.*;
import javax.xml.parsers.ParserConfigurationException;

class MakeWindow extends JFrame{
	static MakeAttributePane attributePane;
	static MakeMindMapPane mindMapPane;
	MakeWindow() {
		setTitle("Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//JToolBar toolBar = new MakeToolBar();
		
		setJMenuBar(new MakeMenuBar()); // Menubar 추가
		add(new MakeToolBar(),BorderLayout.NORTH); // Toolbar 추가
		
		attributePane=new MakeAttributePane();
		mindMapPane=new MakeMindMapPane();
		new MakeRoot();
		
		add(attributePane.all_panel, BorderLayout.WEST);
		add(mindMapPane.all_panel, BorderLayout.CENTER);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		//Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		attributePane.all_panel.setBorder(BorderFactory.createTitledBorder(border,"Attribute")); // 테두리
		
		setSize(800,500);
		setVisible(true);
		
	}	
}

class MakeMenuBar extends JMenuBar{
	JMenu file;
	FileFunction function = new FileFunction();
	
	MakeMenuBar(){	
		file=new JMenu("File(F)");
		file.setMnemonic('F'); // 단축키설정 ALT + F
		
		JMenuItem newFile=new JMenuItem("New(N)");
		file.add(newFile);
		newFile.setMnemonic('N');
		
		JMenuItem open=new JMenuItem("Open(O)");
		file.add(open);
		open.setMnemonic('O');
		
		JMenuItem save=new JMenuItem("Save(S)");
		file.add(save);
		save.setMnemonic('S');
		
		JMenuItem saveAs=new JMenuItem("Save as..");
		file.add(saveAs);
		
		JMenuItem exit=new JMenuItem("Exit(E)");
		file.add(exit);
		exit.setMnemonic('E');
		
		add(file);		
		
		newFile.addActionListener(new MyActionListener());
		open.addActionListener(new MyActionListener());
		save.addActionListener(new MyActionListener());
		saveAs.addActionListener(new MyActionListener());
		exit.addActionListener(new MyActionListener());
	}
	
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if(str.equals("New(N)"))
				try {
					function.newfile();
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (ClassNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			else if(str.equals("Open(O)"))
				try {
					function.open();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			else if(str.equals("Save(S)"))
				try {
					function.save();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else if(str.equals("Save as.."))
				try {
					function.saveas();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else if(str.equals("Exit(E)"))
				function.exit();		
		}
	}
}

class MakeToolBar extends JToolBar{
	FileFunction function = new FileFunction();
	MakeToolBar(){
		JButton newfile = new JButton("new");
		JButton open = new JButton("open");
		JButton save = new JButton("save");
		JButton saveAs = new JButton("save as..");
		JButton exit = new JButton("exit");
		JButton newNode = new JButton("node");
		
		newfile.addActionListener(new MyActionListener());
		open.addActionListener(new MyActionListener());
		save.addActionListener(new MyActionListener());
		saveAs.addActionListener(new MyActionListener());
		exit.addActionListener(new MyActionListener());
		newNode.addActionListener(new MyActionListener());
		
		add(newfile);
		add(open);
		add(save);
		add(saveAs);
		add(exit);
		add(newNode);

		setFloatable(false); // 툴바고정
	}
	
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("new"))
				try {
					function.newfile();
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (ClassNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			else if(b.getText().equals("open"))
				try {
					function.open();
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			else if(b.getText().equals("save"))
				try {
					function.save();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else if(b.getText().equals("save as.."))
				try {
					function.saveas();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else if(b.getText().equals("exit"))
				function.exit();		
			else if(b.getText().equals("node"))
				function.newnode();
		}
	}
}