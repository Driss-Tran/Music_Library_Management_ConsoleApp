package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCConnection;
import entities.Playlist;
import entities.Track;

public class PlaylistDAO implements PlaylistDAOInterface<Playlist>{
	
	public static PlaylistDAO getPlaylistMethod() {
		return new PlaylistDAO();
	}
	
	@Override
	public int addMusicToPlaylist(Playlist playlist) {
		// TODO Auto-generated method stub
		int rs = 0;
		try {
			Connection conn = JDBCConnection.getConnection();
			String sql = "INSERT INTO PLAYLISTS(userpl_id,user_id,track_id) VALUES (?,?,?)";
			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setInt(1, playlist.getUserpl_id());
			prepare.setInt(2, playlist.getUser_id());
			prepare.setInt(3, playlist.getTrack_id());
			rs = prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ArrayList<Track> searchInPlaylist(int index,String value,int user_playlist_id, int user_id) {
		// TODO Auto-generated method stub
		ArrayList<Track> tracks = new ArrayList<>();
		try {
			Connection conn = JDBCConnection.getConnection();
			String sql = "select tracks.* from tracks,userplaylists,playlists,user where playlists.userpl_id = ?  "
							+"and playlists.track_id = tracks.idTracks and user.id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,user_playlist_id);
			pre.setInt(2, user_id);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				if(index==1   && rs.getString("title").toLowerCase().indexOf(value.toLowerCase())!=-1) {
					Track track = new Track(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					tracks.add(track);
				}else if(index==2 && rs.getString("artist").toLowerCase().indexOf(value.toLowerCase())!=-1) {
					Track track = new Track(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					tracks.add(track);
				}else if(index==3 && rs.getString("album").toLowerCase().indexOf(value.toLowerCase())!=-1) {
					Track track = new Track(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					tracks.add(track);
				}else if(index==4 && rs.getString("genre").toLowerCase().indexOf(value.toLowerCase())!=-1) {
					Track track = new Track(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					tracks.add(track);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tracks;
	}

	@Override
	public ArrayList<Track> showMusicInPlaylist(int user_playlist_id, int user_id) {
		// TODO Auto-generated method stub
		ArrayList<Track> tracks = new ArrayList<>();
		try {
			Connection conn = JDBCConnection.getConnection();
			String sql = "select tracks.* from tracks,userplaylists,playlists,user where playlists.userpl_id = ?  "
							+"and playlists.track_id = tracks.idTracks and user.id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,user_playlist_id);
			pre.setInt(2, user_id);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				
				Track track = new Track(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				tracks.add(track);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tracks;
	}
	
}
