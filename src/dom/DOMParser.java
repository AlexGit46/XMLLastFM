package dom;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOMParser {
	private InputSource is;
	private DocumentBuilder builder;

	public DOMParser(String strXML) {
		try {
			this.is=new InputSource(new FileInputStream(strXML));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		builder = null;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("builder");
			e.printStackTrace();
		}
	}

	public Document getDocumento() {
		Document doc = null;
		try {
			doc = builder.parse(is);
		} catch (SAXException e) {
			System.out.println("getsax");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("getio");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
}
