import java.awt.FileDialog;
import java.awt.Graphics;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Open {
	JFrame f;
	private FileDialog saveDl;
	static int openCheck=0;
	public static String filePath;
	
	static int startx; static int starty; static int width; static int height; static String str;
	static int parent; static int num;
	static Node editNode;
	
	Open() throws FileNotFoundException, IOException, ClassNotFoundException{
		MakeMindMapPane.i=0;
		this.saveDl = new FileDialog(f, "¿­±â", saveDl.LOAD);
		saveDl.setVisible(true);
		
		filePath =saveDl.getDirectory() + saveDl.getFile();
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(filePath));
		try{
			MakeMindMapPane.nodeList.clear();
			for(MakeMindMapPane.i=0 ; ; MakeMindMapPane.i++){
				MakeMindMapPane.nodeList.add((Node)in.readObject());
			}
		}
		catch(EOFException e)
		{
			in.close();
		}
		finally{
			openPage();
		}
	}
	
	static void openPage(){
		openCheck=1;
		MakeWindow.mindMapPane.all_panel.removeAll();
		MakeMindMapPane.lineList.clear();
		MakeMindMapPane.labelList.clear();
		
		for(int j=0 ; j<MakeMindMapPane.i ; j++)
			MakeMindMapPane.labelList.add(new JLabel());
		
		for(int j=0 ; j<MakeMindMapPane.i ; j++){
			startx=MakeMindMapPane.nodeList.get(j).startx;
			starty=MakeMindMapPane.nodeList.get(j).starty;
			width=MakeMindMapPane.nodeList.get(j).width;
			height=MakeMindMapPane.nodeList.get(j).height;
			str=MakeMindMapPane.nodeList.get(j).str;
			parent=MakeMindMapPane.nodeList.get(j).parent;
			num=MakeMindMapPane.nodeList.get(j).num;
			
			if(j==0){
				new MakeRoot(startx, starty, width, height, str, 1);
				MakeMindMapPane.i--;
			}
			else{
				new MakeNode(startx, starty, width, height, str);	
			}
			
			editNode=MakeWindow.mindMapPane.nodeList.get(MakeMindMapPane.i);
			editNode.startx=startx;
			editNode.starty=starty;
			editNode.width=width;
			editNode.height=height;
			editNode.str=str;
			editNode.parent=parent;
			editNode.num=num;
	
			MakeWindow.mindMapPane.nodeList.remove(j);
			MakeWindow.mindMapPane.nodeList.add(j, editNode);
			MakeWindow.mindMapPane.nodeList.remove(MakeMindMapPane.i);
			
			MakeWindow.mindMapPane.labelList.remove(j);
			MakeWindow.mindMapPane.labelList.add(j,editNode.node);	
			MakeWindow.mindMapPane.labelList.remove(MakeMindMapPane.i);	
			
	//		MakeWindow.mindMapPane.all_panel.removeAll();
			MakeMindMapPane.lineList.clear();
		}
		
		for(int j=0 ; j<MakeMindMapPane.i; j++){
			MakeWindow.mindMapPane.all_panel.add(MakeWindow.mindMapPane.labelList.get(j));
			if(MakeMindMapPane.i>0){
				if(j==0)
					new GetShortLine(j,0);
				else
					new GetShortLine(j);
				}
		}
		
/*		for(int i=0 ; i < MakeMindMapPane.nodeList.size(); i++){
			MakeMindMapPane.labelList.add(MakeMindMapPane.nodeList.get(i).node);
			MakeWindow.mindMapPane.all_panel.add(MakeMindMapPane.labelList.get(i));
		}
//		MakeWindow.mindMapPane.all_panel=mind.all_panel;
*/		MakeWindow.mindMapPane.all_panel.repaint();
		MakeWindow.mindMapPane.all_panel.setVisible(true);
	}
}
