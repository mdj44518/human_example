package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlbumMgr {
	private List<Album> albums;
	
	public AlbumMgr() {
		albums = new ArrayList<> ();
	}
	
	public void addAlbum(Album album) {
		albums.add(album);
	}
	
	public Album removeAlbum(String title, String artist) {
		Iterator<Album> iter = albums.iterator();
		while (iter.hasNext()) {
			Album current = iter.next();
			if (current.getTitle().equalsIgnoreCase(title) &&
					current.getArtist().equalsIgnoreCase(artist)) {
				iter.remove();
				return current;
			}
		}
		return null;
	}
	
	public Album findAlbum(String title, String artist) {
		Iterator<Album> iter = albums.iterator();
		while (iter.hasNext()) {
			Album current = iter.next();
			if (current.getTitle().equalsIgnoreCase(title) &&
					current.getArtist().equalsIgnoreCase(artist)) {
				return current;
			}
		}
		return null;
	}
	
	public int getTotalTrackLength(String title) {
		for (Album current : albums) {
			if (current.getTitle().equalsIgnoreCase(title)) {
				return current.getTotalTrackLength();
			}
		}
		return 0;
	}
	
	public void printAlbums() {
		int index = 0;
		for (Album current : albums) {
			System.out.println("[" + index + "] " + current);
			index++;
		}
	}
}
