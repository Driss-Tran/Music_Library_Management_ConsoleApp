package entities;

public class UserPlaylist {
	private int id;
	private String name_playlist;
	private int user_id;
	
	
	
	
	public UserPlaylist() {
		super();
	}

	public UserPlaylist(int id, String name_playlist, int user_id) {
		super();
		this.id = id;
		this.name_playlist = name_playlist;
		this.user_id = user_id;
	}

	public UserPlaylist(String name_playlist, int user_id) {
		super();
		this.name_playlist = name_playlist;
		this.user_id = user_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_playlist() {
		return name_playlist;
	}
	public void setName_playlist(String name_playlist) {
		this.name_playlist = name_playlist;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String toString() {
		String str = "/---------------------------------//---------------------------------/"
					+"\n ID of Playlist : "+getId()
					+"\n Name of Playlist : "+getName_playlist()
					+"\n/---------------------------------//---------------------------------/\n";
		return str;
	}
	
	
}
