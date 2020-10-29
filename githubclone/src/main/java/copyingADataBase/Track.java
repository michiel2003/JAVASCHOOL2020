package copyingADataBase;

public class Track {
	
	String name;
	int albumid;
	int mediatypeid;
	int genreid;
	String composer;
	int milliseconds;
	int bytes;
	
	public Track(String name, int albumid, int mediatypeid, int genreid, String composer, int milliseconds, int bytes) {
		this.name = name;
		this.albumid = albumid;
		this.mediatypeid = mediatypeid;
		this.genreid = genreid;
		this.composer = composer;
		this.milliseconds = milliseconds;
		this.bytes = bytes;
	}

}
