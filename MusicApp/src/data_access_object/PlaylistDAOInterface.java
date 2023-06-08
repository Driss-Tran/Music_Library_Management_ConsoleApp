package data_access_object;

import java.util.ArrayList;

import entities.Track;

public interface PlaylistDAOInterface<T> {
	public int addMusicToPlaylist(T value);
	
	public ArrayList<Track> searchInPlaylist(int index, String value,int user_playlist_id, int user_id); 
	
	public ArrayList<Track> showMusicInPlaylist(int user_playlist_id, int user_id);
}
