
public class GetShortLine {
	int p;
	int[] xPoint=new int[8];
	int[] parentPoint=new int[8];
	int bestShort=0;
	int bestx1=0, bestx2=10, besty1=0, besty2=0;
	LineInfo line;
	
	GetShortLine(int p){
		this(p, 1);
	}
	
	GetShortLine(int p, int i){
		this.p=p;
		
		//MakeMindMapPane.lineList.remove(p-1);
		xPoint[0]=((MakeMindMapPane.nodeList.get(p).startx*2)+MakeMindMapPane.nodeList.get(p).width)/2;
		xPoint[1]=MakeMindMapPane.nodeList.get(p).starty;
		xPoint[2]=MakeMindMapPane.nodeList.get(p).startx;
		xPoint[3]=((MakeMindMapPane.nodeList.get(p).starty*2)+MakeMindMapPane.nodeList.get(p).height)/2;
		xPoint[4]=xPoint[0];
		xPoint[5]=((MakeMindMapPane.nodeList.get(p).starty+MakeMindMapPane.nodeList.get(p).height)*2)/2;
		xPoint[6]=((MakeMindMapPane.nodeList.get(p).startx+MakeMindMapPane.nodeList.get(p).width)*2)/2;
		xPoint[7]=xPoint[1];
		int parent=MakeMindMapPane.nodeList.get(p).parent;
		
		parentPoint[0]=(MakeMindMapPane.nodeList.get(parent).startx+(MakeMindMapPane.nodeList.get(parent).startx+MakeMindMapPane.nodeList.get(parent).width))/2;
		parentPoint[1]=MakeMindMapPane.nodeList.get(parent).starty;
		parentPoint[2]=MakeMindMapPane.nodeList.get(parent).startx;
		parentPoint[3]=(MakeMindMapPane.nodeList.get(parent).starty+(MakeMindMapPane.nodeList.get(parent).starty+MakeMindMapPane.nodeList.get(parent).height))/2;
		parentPoint[4]=parentPoint[0];
		parentPoint[5]=((MakeMindMapPane.nodeList.get(parent).starty+MakeMindMapPane.nodeList.get(parent).height)+(MakeMindMapPane.nodeList.get(parent).starty+MakeMindMapPane.nodeList.get(parent).height))/2;
		parentPoint[6]=((MakeMindMapPane.nodeList.get(parent).startx+MakeMindMapPane.nodeList.get(parent).width)+(MakeMindMapPane.nodeList.get(parent).startx+MakeMindMapPane.nodeList.get(parent).width))/2;
		parentPoint[7]=parentPoint[1];
				
		for(int m=0 ; m<2 ; m=m+2){
			for(int n=0 ; n<2 ; n=n+2){
				if(bestShort<MakeMindMapPane.getDistance(xPoint[m], xPoint[m+1], parentPoint[n], parentPoint[n+1])){
					bestShort=MakeMindMapPane.getDistance(xPoint[m], xPoint[m+1], parentPoint[n], parentPoint[n+1]);
					bestx1=xPoint[m]; besty1=xPoint[m+1];
					bestx2=parentPoint[n]; besty2=parentPoint[n+1];
				}
			}			
		}
		line=new LineInfo(bestx1, besty1, bestx2, besty2);
		
		if(i==1)
			MakeMindMapPane.lineList.add(p-1,line);
		else if(i==0)
			MakeMindMapPane.lineList.add(line);
		
	}
}
