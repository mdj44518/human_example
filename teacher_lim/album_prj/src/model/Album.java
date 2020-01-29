package model;

import java.util.ArrayList;
import java.util.List;


public class Album {
	private String title;
	private String artist;
	List<Song> tracks;
	
	public Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
		
		tracks = new ArrayList<> ();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void addTrack(Song song) {
		tracks.add(song);
	}
	
	public void removeTrack(int index) {
		if (index < tracks.size() && index >= 0) {
			tracks.remove(index);
		}
	}

	@Override
	public String toString() {
		return "Album [title=" + title + ", artist=" + artist + ", tracks=" + tracks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tracks == null) ? 0 : tracks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tracks == null) {
			if (other.tracks != null)
				return false;
		} else if (!tracks.equals(other.tracks))
			return false;
		return true;
	}
	
	public int getTotalTrackLength() {
		int sum = 0;
		for (Song song : tracks) {
			sum += song.getTrackTime();
		}
		return sum;
	}
	
	public int getLongestTrackLength() {
		int max = tracks.get(0).getTrackTime();
		for (int i = 1; i < tracks.size(); i++) {
			if (tracks.get(i).getTrackTime() > max) {
				max = tracks.get(i).getTrackTime();
			}
		}
		
		return max;
	}
	
	public Song getLongestTrackSong() {
		int max = tracks.get(0).getTrackTime();
		int index = 0;
		for (int i = 1; i < tracks.size(); i++) {
			if (tracks.get(i).getTrackTime() > max) {
				max = tracks.get(i).getTrackTime();
				index = i;
			}
		}
		
		return tracks.get(index);
	}
}
