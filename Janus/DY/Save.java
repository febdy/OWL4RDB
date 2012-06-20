import java.awt.FileDialog;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.*;

import org.w3c.dom.*;

public class Save {
	Save() throws FileNotFoundException, IOException, ParserConfigurationException{
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Object.ser"));
		for(int i=0 ; i<MakeMindMapPane.nodeList.size() ; i++){
			out.writeObject(MakeMindMapPane.nodeList.get(i));
			}
		
	/*	  FileOutputStream fos = new FileOutputStream("Ob.ser");
		  BufferedOutputStream bos = new BufferedOutputStream(fos);
		  ObjectOutputStream oos = new ObjectOutputStream(bos);
		  oos.writeObject(MakeMindMapPane.nodeList.get(0));
		  //out.close();
		  oos.close();*/

	/*	Document doc = null;
		DocumentBuilderFactory factory = null;
		factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.newDocument();
		
		Element root = doc.createElement("root");
		doc.appendChild(root);
		
		Element node = doc.createElement("node");
		for(int j=0 ; j<MakeMindMapPane.i ; j++){
		Text[] t=new Text[MakeMindMapPane.i];
		t[j]=doc.createTextNode(MakeMindMapPane.nodeList.get(j).toString());
		node.appendChild(t[j]);
		root.appendChild(node);
		}
		
		TransformerFactory tr_factory = TransformerFactory.newInstance();
		String xmlStr = "";    
		try
		{
		 //   StringWriter sw = new FileOutputStream(new File("file.xml");
		    Properties output = new Properties();
		    output.setProperty(OutputKeys.INDENT, "yes");
		    output.setProperty(OutputKeys.ENCODING, "UTF-8");
		    Transformer transformer = tr_factory.newTransformer();
		    transformer.setOutputProperties(output);
		    transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(new File("file.xml"))));
//		    xmlStr = sw.getBuffer().toString ();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}*/	
	}
}
class SaveAs{
	JFrame f;
	private FileDialog saveDl;
	String filePath=null;
	
	SaveAs() throws FileNotFoundException, IOException{
		this.saveDl = new FileDialog(f, "다른 이름으로 저장", saveDl.SAVE);
		 saveDl.setVisible(true);
		 String filePath =saveDl.getDirectory() + saveDl.getFile();
		 if(filePath!=null){
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filePath));
			for(int i=0 ; i<MakeMindMapPane.nodeList.size() ; i++){
				out.writeObject(MakeMindMapPane.nodeList.get(i));
			}
		}
	}
}