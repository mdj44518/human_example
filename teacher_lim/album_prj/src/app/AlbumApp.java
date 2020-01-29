package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Album;
import model.AlbumMgr;
import model.Song;

public class AlbumApp {

	public static void main(String[] args) {
		AlbumMgr mgr = new AlbumMgr();
		File file = new File("input.txt");
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] tokens = line.split("/");
				if (tokens.length < 2) {
					continue;
				}
				Album album = new Album(tokens[0], tokens[1]);
				int numOfSongs = (tokens.length - 2) / 2;
				int tokenIdx = 2;
				for (int i = 0; i < numOfSongs; i++) {
					Song song = new Song(tokens[tokenIdx]);
					tokenIdx++;
					song.setTrackTime(tokens[tokenIdx]);
					tokenIdx++;
					album.addTrack(song);
				}
				mgr.addAlbum(album);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mgr.printAlbums();
	}
}
