package model;

public class Song {
	String name;
	int min;
	int sec;
	
	public Song(String name) {
		this.name = name;
	}
	
	public void setTrackTime(int min, int sec) {
		this.min = min;
		this.sec = sec;
	}
	
	// format "3:50"
	public void setTrackTime(String time) {
		String[] tokens = time.split(":");
		this.min = Integer.parseInt(tokens[0]);
		this.sec = Integer.parseInt(tokens[1]);
	}
	
	public String getName() {
		return name;
	}
	
	public int getTrackTime() {
		return min * 60 + sec;
	}
	
	public String getTrackTimetoString() {
		return min + ":" + sec;
	}

	@Override
	public String toString() {
		return "Song [name=" + name + ", min=" + min + ", sec=" + sec + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + min;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sec;
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
		Song other = (Song) obj;
		if (min != other.min)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sec != other.sec)
			return false;
		return true;
	}

}
