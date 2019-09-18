package vista;

import java.util.ArrayList;

import modelo.Artist;
import modelo.TopArtist;

public class Prueba {

	public static void main(String[] args) {
		TopArtist topArtist = new TopArtist();
		ArrayList<Artist> listaArtist=topArtist.getListaArtist();
		for (Artist artist:listaArtist)
			System.out.println(artist);
	}

}
