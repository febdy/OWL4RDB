import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class MakeMindMapPane{
	JPanel all_panel;
	//JLabel node;
	static int i=0;
	static int select=0;
//	static int click=0;
	static ArrayList<Node> nodeList=new ArrayList<Node>();
	static ArrayList<JLabel> labelList=new ArrayList<JLabel>();
	static ArrayList<LineInfo> lineList=new ArrayList<LineInfo>();
	
	static int[] xPoint = new int[8];
	static int[] parentPoint = new int[8];
	JLabel la;
	static int k=0;
	
	MakeMindMapPane(){
		all_panel=new MyPanel();
		all_panel.setLayout(null);
	}
	
	static class MyPanel extends JPanel{
		int x=0,y=0; // 좌표
		
		public MyPanel(){
			setLayout(null); // 레이아웃 설정
			
			this.addMouseListener(new M());
			this.addMouseMotionListener(new M1()); // 마우스 이벤트 적응
		}	
		
		class M extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				labelList.get(select).setBackground(Color.green);
				select=0;
			}
		}
		
		class M1 extends MouseMotionAdapter{ // 마우스 이벤트
			public void mouseDragged(MouseEvent e){		
				x = e.getX(); // 좌표얻음
				y = e.getY();
				
				repaint(); // 페인트 다시 그리기
			}
		}
		
		public void paintComponent(Graphics g){	
			if(i>0){
				super.paintComponent(g);
			
				for(int m=0 ; m<lineList.size(); m++){
					g.drawLine(lineList.get(m).x1,lineList.get(m).y1,lineList.get(m).x2,lineList.get(m).y2);				
				}
			}
			else
				super.paintComponent(g); // 상위 부모꺼를 먼저 그린다.
			}
	}	
	
	static int getDistance(int x1, int y1, int x2, int y2){
		int distance=(x1*x2)+(y1*y2);
		distance=(int)Math.sqrt(distance);
		return distance;	
	}
}