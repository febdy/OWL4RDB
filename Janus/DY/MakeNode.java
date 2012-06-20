import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

public class MakeNode {
	int k=0;
	
	MakeNode(int startx , int starty, int width, int height, String str){
		MakeMindMapPane.nodeList.add(new Node(startx, starty, width, height, str, 1));
		MakeMindMapPane.labelList.add(new Node(startx, starty, width, height, str, 1).node);
		makeNode();
	}
	
	MakeNode(){
		MakeMindMapPane.nodeList.add(new Node());
		MakeMindMapPane.labelList.add(new Node().node);
		makeNode();		
	}
	
	void makeNode(){
		MakeWindow.mindMapPane.all_panel.add(MakeMindMapPane.labelList.get(MakeMindMapPane.i));
		
		Node j=(Node)MakeMindMapPane.nodeList.get(MakeMindMapPane.i);
		j.parent=MakeMindMapPane.select;
		MakeMindMapPane.nodeList.remove(MakeMindMapPane.i);
		MakeMindMapPane.nodeList.add(MakeMindMapPane.i,j);

		if(MakeMindMapPane.i>0){
			new GetShortLine(MakeMindMapPane.i, 0);
		}

		MakeWindow.mindMapPane.all_panel.repaint();

		Node.node.addMouseListener(new MouseAdapter(){	
			Node j= (Node)MakeMindMapPane.nodeList.get(k);
			public void mouseClicked(MouseEvent e) {		
				for(k=0; k<=MakeMindMapPane.i; k++){
					if(((JLabel) e.getSource()).getText()==MakeMindMapPane.nodeList.get(k).str){				
						j=(Node)MakeMindMapPane.nodeList.get(k);
						break;
					}
				}
				
				if(MakeMindMapPane.select!=k)
					MakeMindMapPane.labelList.get(MakeMindMapPane.select).setBackground(Color.green);
				
				MakeMindMapPane.select=j.num;
				MakeMindMapPane.labelList.get(k).setBackground(Color.yellow);
				Status s=new Status(j.startx, j.starty, j.width, j.height, j.str);
				s.setAttribute();
			}		
		});
		
		Node.node.addMouseMotionListener(new MouseMotionListener(){
			Node j=(Node)MakeMindMapPane.nodeList.get(k);
			
			public void mouseDragged(MouseEvent e){
				for(k=0; k<=MakeMindMapPane.i; k++){  
					if(((JLabel) e.getSource()).getText()==MakeMindMapPane.nodeList.get(k).str){				
						j=(Node)MakeMindMapPane.nodeList.get(k);
						MakeMindMapPane.select=k;

						break;
					}
				}
				
				for(int l=0 ; l<MakeMindMapPane.i ; l++){
					if(l==k)
						MakeMindMapPane.labelList.get(k).setBackground(Color.yellow);
					else
						MakeMindMapPane.labelList.get(l).setBackground(Color.green);
				}

				if(MakeMindMapPane.i>0){
					MakeMindMapPane.lineList.remove(k-1);
					new GetShortLine(k);
						
					for(int p=1 ; p<=MakeMindMapPane.i-1 ; p++){
						if(MakeMindMapPane.nodeList.get(p).parent==j.num){
							MakeMindMapPane.lineList.remove(p-1);
							new GetShortLine(p);
						}
					}
				}
				
				MakeWindow.mindMapPane.all_panel.repaint();
				
				JLabel la=(JLabel)e.getSource();

				MakeMindMapPane.labelList.get(k).setLocation(la.getX()+e.getX(),la.getY()+e.getY());
				Status s=new Status(la.getX()+e.getX(), la.getY()+e.getY(), j.width, j.height, j.str);
				s.setAttribute();
				
				j.startx=la.getX()+e.getX();
				j.starty=la.getY()+e.getY();
				MakeMindMapPane.nodeList.remove(k);
				MakeMindMapPane.nodeList.add(k,j);
				
			}

			public void mouseMoved(MouseEvent e) {}		
		});
	}
}
