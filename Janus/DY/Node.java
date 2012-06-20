import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Node implements Serializable{
	int parent;
	 int startx;
	 int starty;
	 int width;
	 int height;
	 String str;
	 static JLabel node;
	 int num;
	
	Node(){
		this(300,200,60,30," ");
	}
	
	Node(int startx, int starty, int width, int height, String str){
		this(startx, starty, width, height, str, 0);
	}
	
	Node(final int startx, final int starty, final int width, final int height, final String str, int re){
		this.startx=startx;
		this.starty=starty;
		this.width=width;
		this.height=height;
		this.str=str;
		this.num=MakeWindow.mindMapPane.i;
		
		if(re==0){
			if(this.num==1)
				this.str="1";
			if(this.num==2)
				this.str="2";
			if(this.num==3)
				this.str="3";
			if(this.num==4)
				this.str="4";
		}
		
		node=new MLabel();
		//node=new JLabel(str);
		node.setBounds(startx,starty,width,height);
		node.setOpaque(true);
		node.setBackground(Color.green);
//		MakeWindow.mindMapPane.all_panel.repaint();
	}
	
	class MLabel extends JLabel{ // 레이블 재정의 클래스		
		public MLabel(){
			setBounds(startx,starty,width,height);
			setOpaque(true);
			setBackground(Color.GREEN);
			setText(str);
		}
	}
	
	public String toString(){
		return Integer.toString(parent)+" "+Integer.toString(startx)+" "+Integer.toString(starty)+" "+Integer.toString(width)+" "+Integer.toString(height)+" "+str+" "+Integer.toString(num);
		
	}
}