import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;


public class MakeRoot {
	Node root;
	int k=0;
	
	MakeRoot(int startx, int starty, int width, int height, String str, int i){
		root=new Node(startx, starty, width, height, str, 1);
		makeRoot();
	}
	
	MakeRoot(){
		root=new Node(200,150,50,30,"ROOT");
		makeRoot();
	}

	void makeRoot(){
		MakeMindMapPane.nodeList.add(root);
		MakeMindMapPane.labelList.add(root.node);
		MakeWindow.mindMapPane.all_panel.add(MakeMindMapPane.labelList.get(MakeMindMapPane.i));
		MakeMindMapPane.i++;	
		
		root.node.addMouseListener(new MouseAdapter(){	
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
		
		root.node.addMouseMotionListener(new MouseMotionListener(){
			Node j=(Node)MakeMindMapPane.nodeList.get(k);
			
			public void mouseDragged(MouseEvent e){	
				for(k=0; k<=MakeMindMapPane.i; k++){
					if(((JLabel) e.getSource()).getText()==MakeMindMapPane.nodeList.get(k).str){				
						j=(Node)MakeMindMapPane.nodeList.get(k);
						break;
					}
				}
				
				for(int l=0 ; l<MakeMindMapPane.i ; l++){
					if(l==k)
						MakeMindMapPane.labelList.get(0).setBackground(Color.yellow);
					else
						MakeMindMapPane.labelList.get(l).setBackground(Color.green);
				}
				
				if(MakeMindMapPane.i>1){
					for(int p=1 ; p<=MakeMindMapPane.i-1 ; p++){
						if(MakeMindMapPane.nodeList.get(p).parent==0){
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


