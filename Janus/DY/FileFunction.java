import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;


class FileFunction {
	FileFunction(){
	
	}
	void newfile() throws FileNotFoundException, IOException, ClassNotFoundException{
		new NewFile();		
	}
	void open() throws FileNotFoundException, IOException, ClassNotFoundException{
		new Open();
	}
	void save() throws FileNotFoundException, IOException, ParserConfigurationException{
		new Save();
	}
	void saveas() throws FileNotFoundException, IOException{
		new SaveAs();
	}
	void exit(){
		System.exit(0);
	}
	void newnode(){
		new MakeNode();
		MakeWindow.mindMapPane.i++;
	}
}
