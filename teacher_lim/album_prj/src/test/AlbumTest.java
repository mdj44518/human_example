package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import model.Album;
import model.AlbumMgr;
import model.Song;

public class AlbumTest {
	AlbumMgr mgr;
	
	@Before
	public void setUp() throws Exception {
		mgr = new AlbumMgr();
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
	}

	@Test
	public void test() {
		int expected = 2*60 + 30 + 1 * 60 + 45 + 3 * 60 + 10 + 4* 60;
		assertEquals(expected, mgr.getTotalTrackLength("김광석베스트"));
	}

	@Test
	public void testLongestSong() {
		Song song = new Song("kkk");
		song.setTrackTime(4, 0);
		
		assertEquals(song, mgr.findAlbum("김광석베스트", "김광석").getLongestTrackSong());
	}
}
