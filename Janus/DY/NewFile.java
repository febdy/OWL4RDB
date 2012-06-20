import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class NewFile {
	NewFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(Open.openCheck==0){
			MakeWindow.mindMapPane.all_panel.removeAll();
			MakeMindMapPane.nodeList.clear();
			MakeMindMapPane.labelList.clear();
			MakeMindMapPane.lineList.clear();
			MakeMindMapPane.i=0;
			MakeMindMapPane.select=0;
			new MakeRoot();
			
			MakeWindow.attributePane.removeAll();	
			MakeWindow.mindMapPane.all_panel.repaint();
		}
		else{
			MakeMindMapPane.i=0;
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(Open.filePath));
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
				Open.openPage();
			}			
		}
	}
}
