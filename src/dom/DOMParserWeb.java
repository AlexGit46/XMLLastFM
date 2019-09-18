package dom;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOMParserWeb {
	private InputSource is;
	private DocumentBuilder builder;

	public DOMParserWeb(String strUrl) {
		URL url = null;
		try {
			url = new URL(strUrl);
			InputStream is = url.openStream();
			this.is=new InputSource(is);
		} catch (MalformedURLException e) {
			System.out.println("parsermf");
			e.printStackTrace();
		} catch (IOException e) {
            System.out.println("parserio");
			e.printStackTrace();
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
