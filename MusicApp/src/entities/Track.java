package entities;

public class Track {
	// Defining Track entities.
	
	private int idTracks;
	private String title;
	private String artist;
	private String album;
	private String genre;
	private String release_year;
	private String duration;
	
	
	
	public Track(int idTracks, String title, String artist, String album, String genre, String release_year,
			String duration) {
		super();
		this.idTracks = idTracks;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.release_year = release_year;
		this.duration = duration;
	}
	public Track( String title, String artist, String album, String genre, String release_year,
			String duration) {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.release_year = release_year;
		this.duration = duration;
	}
	public Track() {
		super();
		this.title = "Unknown";
		this.artist = "Unknown";
		this.album = "Unknown";
		this.genre = "Unknown";
		this.release_year = "Unknown";
		this.duration = "Unknown";
		// TODO Auto-generated constructor stub
	}
	public int getIdTracks() {
		return idTracks;
	}
	public void setIdTracks(int idTracks) {
		this.idTracks = idTracks;
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
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String toString() {
		String infoTrack = "===========================||==========================="
				  		+"\n| ID Track : "+getIdTracks()
				  		+"\n| Title : "+getTitle()
				  		+"\n| Artist : "+getArtist()
				  		+"\n| Album : "+getAlbum()
				  		+"\n| Genre : "+getGenre()
				  		+"\n| Release year : "+getRelease_year()
				  		+"\n| Duration : "+getDuration()
				  		+"\n===========================||===========================";
		
		return infoTrack;
	}
	
}
