import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Status {
	private static int startx;
	private static int starty;
	private static int width;
	private static int height;
	private static String str;
	
	static Node editNode;
	
	Status(){
		this(0,0,0,0," ");
	}
	
	Status(int startx, int starty, int width, int height, String str){
		this.startx=startx;
		this.starty=starty;
		this.width=width;
		this.height=height;
		this.str=str;
	}
	
	static void setAttribute(){
		((JTextField)MakeWindow.attributePane.up_panel.getComponent(1)).setText(Integer.toString(startx));
		((JTextField)MakeWindow.attributePane.up_panel.getComponent(3)).setText(Integer.toString(starty));
		((JTextField)MakeWindow.attributePane.up_panel.getComponent(5)).setText(Integer.toString(width));
		((JTextField)MakeWindow.attributePane.up_panel.getComponent(7)).setText(Integer.toString(height));
		((JTextField)MakeWindow.attributePane.up_panel.getComponent(9)).setText(str);
//		MakeWindow.attributePane.repaint();

	}
	
	static void getAttribute(){
		if(MakeMindMapPane.select==0){
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
		editNode.parent=MakeWindow.mindMapPane.nodeList.get(MakeMindMapPane.select).parent;
		editNode.num=MakeWindow.mindMapPane.nodeList.get(MakeMindMapPane.select).num;

		MakeWindow.mindMapPane.nodeList.remove(MakeMindMapPane.select);
		MakeWindow.mindMapPane.nodeList.add(MakeMindMapPane.select, editNode);
		MakeWindow.mindMapPane.nodeList.remove(MakeMindMapPane.i);
		
		MakeWindow.mindMapPane.labelList.remove(MakeMindMapPane.select);
		MakeWindow.mindMapPane.labelList.add(MakeMindMapPane.select,editNode.node);	
		MakeWindow.mindMapPane.labelList.remove(MakeMindMapPane.i);	
		
		MakeWindow.mindMapPane.all_panel.removeAll();
		MakeMindMapPane.lineList.clear();
		
		for(int j=0 ; j<MakeMindMapPane.i; j++){
			MakeWindow.mindMapPane.all_panel.add(MakeWindow.mindMapPane.labelList.get(j));
			if(MakeMindMapPane.i>0){
				if(j==0)
					new GetShortLine(j,0);
				else
					new GetShortLine(j);
				}
		}
		
		MakeWindow.mindMapPane.all_panel.repaint();

	}
}
