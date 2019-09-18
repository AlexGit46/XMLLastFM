package modelo;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dom.DOMParserWeb;

public class TopArtist {
	private static final String URL = "http://ws.audioscrobbler.com/2.0/?method=user.gettopartists&user=rj&api_key=35066a49f2deb23a3c35fd48ff5c9869";
	private ArrayList<Artist> listaArtist;

	public TopArtist() {
		DOMParserWeb parser = new DOMParserWeb(URL);
		Document doc = parser.getDocumento();
		NodeList artists = doc.getElementsByTagName("artist");
		listaArtist = new ArrayList<Artist>();
		Artist artist;
		for (int i=0;i<artists.getLength();i++){
			Element eleArtist = (Element) artists.item(i);
			artist = new Artist();
			artist.setRank(eleArtist.getAttribute("rank"));
			artist.setName(eleArtist.getElementsByTagName("name").item(0).getTextContent());
			artist.setUrl(eleArtist.getElementsByTagName("url").item(0).getTextContent());
			NodeList images = eleArtist.getElementsByTagName("image");
			int imagesCount = images.getLength();
			artist.setImage(images.item(imagesCount-1).getTextContent());
			listaArtist.add(artist);
		}
	}
	public ArrayList<Artist> getListaArtist() {
		return listaArtist;
	}

}
