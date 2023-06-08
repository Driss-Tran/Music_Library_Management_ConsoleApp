package data_access_object;

import java.util.ArrayList;

public interface UserPlaylistDAOInterface<T> {
	public int createPlaylists(T value);
	
	public ArrayList<T> showAll(int id);
	
	public T checkExistPlaylist(String value);
	
	public int deletePlaylist(T value);
}
