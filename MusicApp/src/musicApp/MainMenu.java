package musicApp;

import java.util.ArrayList;
import java.util.Scanner;

import data_access_object.PlaylistDAO;
import data_access_object.TrackDAO;
import data_access_object.UserDAO;
import data_access_object.UserPlaylistDAO;
import entities.Playlist;
import entities.Track;
import entities.User;
import entities.UserPlaylist;

// Defining UI of App

public class MainMenu {
	static Scanner sc = new Scanner(System.in);
	public static void addTrackUI() {
		System.out.println("||====================================================================||");
		System.out.println("||\t\t   	Add a new music track!\t      		      ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Add a new music track.                                          ||");
        System.out.println("|| 2. Back to Main Menu.                 			      ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
        
		String n = "";
		do {
			System.out.print("Your number : ");
			n = sc.nextLine();
			if(n.trim().equals("9")) {
				System.out.println("Thanks for using our app.	");
				return;
			}
			else if(n.trim().equals("1")) {
				break;
			}else if(n.trim().equals("2")) {
				adminMenuUI();
				return;
			}else {
				System.out.println("Invalid value !! Please try again!");
			}
		}while(!n.trim().equals("1") || !n.trim().equals("2") || !n.trim().equals("9"));
		
		System.out.print("Enter title of music : ");
		String title = sc.nextLine();
		System.out.print("Enter artist of music : ");
		String artist = sc.nextLine();
		System.out.print("Enter album of music : ");
		String album = sc.nextLine();
		System.out.print("Enter genre of music : ");
		String genre = sc.nextLine();
		System.out.print("Enter release year of music : ");
		String release_year = sc.nextLine();
		System.out.print("Enter duration of music : ");
		String duration = sc.nextLine();
		
		
		Track newTrack = new Track(title.trim(),artist.trim(),album.trim(),genre.trim(),release_year.trim(),duration.trim());
		int check = TrackDAO.getTrackMethod().addTrack(newTrack);
		if(check>0) {
			System.out.println("Add music track successfully");
		}else {
			System.out.println("Add music track fail! Try again");
		}
		addTrackUI();
	}
	
	
	
	
	public static void viewDetailsUI() {
		String s = "Enter title of music : ";
		System.out.println("||====================================================================||");
		System.out.println("||\t\t    View details of specific music!\t      	      ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Find music by title.                                            ||");
        System.out.println("|| 2. Find music by artist.                                           ||");
        System.out.println("|| 3. Back to Main Menu.                 			      ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
		String n = "";
		int formatNum = 0;
		
		do {
			System.out.print("Your number : ");
			n = sc.nextLine();
			try {
        		formatNum = Integer.parseInt(n.trim());
        	} catch (NumberFormatException e) {
        		System.out.println("");
        	}
			if(n.trim().equals("9")) {
				System.out.println("Exit");
				return;
			}else if(n.trim().equals("1")) {
				break;
			}else if(n.trim().equals("2")) {
				s = "Enter artist of music : ";
				break;
			}
			else if(n.trim().equals("3")) {
				adminMenuUI();
				return;
			}else {
				System.out.println("Invalid value !! Please try again!");
			}
		}while(!n.trim().equals("1") || !n.trim().equals("2") ||!n.trim().equals("3") ||!n.trim().equals("9"));
		
		System.out.print(s);
		String findMusicString = sc.nextLine();
		Track detailTrack = TrackDAO.getTrackMethod().viewDetails(formatNum, findMusicString);
		if(detailTrack.getIdTracks()!=0) {
			System.out.println("The result of : "+"\""+findMusicString+"\""+"\n"+detailTrack);
		}else {
			System.out.println("Cannot find music !! Please try again");
		}
		viewDetailsUI();
	}
	
	public static void updateMusicUI() {
		
		System.out.println("||====================================================================||");
		System.out.println("||\t\t    Update details of specific music!\t      	      ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Find music by title to update.                                  ||");
        System.out.println("|| 2. Back to Main Menu.                 			      ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
		String n = "";
		int formatNum = 0;
		
		do {
			System.out.print("Your number : ");
			n = sc.nextLine();
			try {
        		formatNum = Integer.parseInt(n);
        	} catch (NumberFormatException e) {
        		System.out.println("");
        	}
			if(n.equals("9")) {
				System.out.println("Exit");
				return;
			}else if(n.trim().equals("1")) {
				break;
			}else if(n.trim().equals("2")) {
				adminMenuUI();
				return;
			}else {
				System.out.println("Invalid value !! Please try again!");
			}
		}while(!n.trim().equals("1") || !n.trim().equals("2")||!n.trim().equals("9"));
		
		System.out.print("Enter title of music : ");
		String findMusicString = sc.nextLine();
		Track detailTrack = TrackDAO.getTrackMethod().viewDetails(Integer.parseInt(n), findMusicString);
		int id = 0;
		if(detailTrack.getIdTracks()!=0) {
			System.out.println("The result of : "+"\""+findMusicString+"\""+"\n"+detailTrack);
			id = detailTrack.getIdTracks();
			System.out.println("---------------------------------||---------------------------------");
			System.out.println("Please press Enter if you do not want to change any field");
			System.out.print("Enter new title : ");
			String title = sc.nextLine();
			System.out.print("Enter new artist : ");
			String artist = sc.nextLine();
			System.out.print("Enter new album : ");
			String album = sc.nextLine();
			System.out.print("Enter new genre : ");
			String genre = sc.nextLine();
			System.out.print("Enter new release year : ");
			String release_year = sc.nextLine();
			System.out.print("Enter new duration : ");
			String duration = sc.nextLine();
			
			if(title.trim().isEmpty()) {
				title = detailTrack.getTitle();
			}
			if(artist.trim().isEmpty()) {
				artist = detailTrack.getArtist();
			}
			if(album.trim().isEmpty()) {
				album = detailTrack.getAlbum();
			}
			if(genre.trim().isEmpty()) {
				genre = detailTrack.getGenre();
			}
			if(release_year.trim().isEmpty()) {
				release_year = detailTrack.getRelease_year();
			}
			if(duration.trim().isEmpty()) {
				duration = detailTrack.getDuration();
			}
			
			Track newTrack = new Track(title.trim(),artist.trim(),album.trim(),genre.trim(),release_year.trim(),duration.trim());
			TrackDAO.getTrackMethod().updateTrack(id,newTrack);
			System.out.println("Update Music successful");
			System.out.println("---------------------------------||---------------------------------");
			System.out.println("The result of : "+"\""+findMusicString+"\""+"\n"+TrackDAO.getTrackMethod().viewDetails(formatNum, newTrack.getTitle().trim()));
			System.out.println("---------------------------------||---------------------------------");
		}else {
			System.out.println("Cannot find music !! Please try again.");
		}
		updateMusicUI();
	}
	
	
	public static void deleteMusicUI() {
		System.out.println("||====================================================================||");
		System.out.println("||\t\t    Delete a music from library!\t      	      ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Find music by title to delete.                                  ||");
        System.out.println("|| 2. Back to Main Menu.                 			      ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
		String n = "";
		int formatNum = 0;
				
		do {
			System.out.print("Your number : ");
			n = sc.nextLine();
			try {
        		formatNum = Integer.parseInt(n);
        	} catch (NumberFormatException e) {
        		System.out.println("");
        	}
			if(n.trim().equals("9")) {
				System.out.println("Exit");
				return;
			}
			else if(n.trim().equals("1")) {
				break;
			}
			else if(n.trim().equals("2")) {
				adminMenuUI();
				return;
			}else {
				System.out.println("Invalid value !! Please try again!");
			}
		}while(!n.trim().equals("1") || !n.trim().equals("2") || !n.trim().equals("9"));
		
		
		System.out.print("Enter title of music : ");
		String findMusicString = sc.nextLine();
		Track detailTrack = TrackDAO.getTrackMethod().viewDetails(formatNum, findMusicString);
		int id = 0;
		
		if(detailTrack.getIdTracks()!=0) {
			id = detailTrack.getIdTracks();
			System.out.println("The result of : "+findMusicString+"\n"+detailTrack);
			System.out.println("||====================================================================||");
	        System.out.println("|| Do you want to delete this music ?                                 ||");
	        System.out.println("|| 1. Yes                                                             ||");
	        System.out.println("|| 2. No                                                              ||");
	        System.out.println("||---------------------------------||---------------------------------||");
	        System.out.print("Your number : ");
	        String choice = sc.nextLine();
	        switch(choice.trim()) {
	        	case "1":
	        		TrackDAO.getTrackMethod().deleteTrack(id, detailTrack);
	        		System.out.println("Delete this music successfully !");
	        		break;
	        	case "2":
	        		break;
	        	default :
	        		System.out.println("Invalid value !! Please try again");
	        		break;
	        }
		}else {
			System.out.println("Cannot find music !! Please try again.");
			
		}
		deleteMusicUI();
	}
	
	public static void viewAllUI(String type) {
		ArrayList<Track> trackList= TrackDAO.getTrackMethod().viewAll();
		System.out.println("||====================================================================||");
		System.out.println("||                     All music tracks in library                    ||");
		System.out.println("||====================================================================||");
		for(Track track : trackList) {
			System.out.println(track);
		}
		if(type.equals("admin")) {
			adminMenuUI();
		}else if(type.equals("user")) {
			userMenuUI(-1);
		}else {
			mainUI();
		}
		
	}
	
	
	public static void loginUI() {
		System.out.println("||====================================================================||");
		System.out.println("||                            Login Form                              ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Login                                                           ||");
        System.out.println("|| 2. Back to menu                                                    ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
        String n="";
        do {
        	System.out.print("Your number : ");
        	n = sc.nextLine();
        	if(n.equals("1")) {
        		break;
        	}else if(n.equals("2")) {
        		mainUI();
        		return ;
        	}else if(n.equals("9")) {
        		System.out.print("Exit successfully");
        		return;
        	}else {
        		System.out.println("Invalid value !! Please try again.");
        	}
        }while(!n.equals("1") || !n.equals("2") || !n.equals("9"));
        
        int check = 1;
        do {
	        System.out.print("Enter your username : ");
	        String username = sc.nextLine();
	        
	        System.out.print("Enter your password : ");
	        String password = sc.nextLine();
	        
	        User user = new User(username,password);
	        int userLogin = UserDAO.getUserMethod().login(user);
	        boolean adminLogin = UserDAO.getUserMethod().adminLogin(user);
	        if(userLogin !=0) {
	        	userMenuUI(userLogin);
	        	return;
	        }else if(adminLogin) {
	        	adminMenuUI();
	        	return;
	        }else {
	        	check = 0;
	        	System.out.println("Your username or password is not correct!! Please try again !!");
	        }
        }while(check!=1);
        
	}
	
	public static void registerUI() {
		System.out.println("||====================================================================||");
		System.out.println("||                           Registration Form                        ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Register                                                        ||");
        System.out.println("|| 2. Back to menu                                                    ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
        String n="";
        do {
        	System.out.print("Your number : ");
        	n = sc.nextLine();
        	if(n.equals("1")) {
        		break;
        	}else if(n.equals("2")) {
        		mainUI();
        		return ;
        	}else if(n.equals("9")) {
        		System.out.print("Exit successfully");
        		return;
        	}else {
        		System.out.println("Invalid value !! Please try again.");
        	}
        }while(!n.equals("1") || !n.equals("2") || !n.equals("9"));
        
        int check = 1;
        do {
	        System.out.print("Enter your username : ");
	        String username = sc.nextLine();
	        
	        System.out.print("Enter your password : ");
	        String password = sc.nextLine();
	        
	        System.out.print("Enter your confirm password : ");
	        String confirmpassword = sc.nextLine();
	        
	        User user = new User(username,password,confirmpassword);
	        int register = UserDAO.getUserMethod().register(user);
	        if(register==1) {
	        	loginUI();
	        	return;
	        }
	        else if(register==0) {
	        	System.out.println("Your username has been used ! Please try again");
	        	check = 0;
	        }else if(register==2) {
	        	System.out.println("Your confirm password is not equal your password !! Please try again");
	        	check = 0;
	        }else {
	        	check = 0;
	        	System.out.println("Your username or password is not correct!! Please try again !!");
	        }
        }while(check!=1);
        
	}
	
	public static void createPlaylistUI(int id) {
		System.out.println("||====================================================================||");
		System.out.println("||                      Create a new play list!                       ||");
		System.out.println("||--------------------------------------------------------------------||");
		System.out.println("|| Press name of playlist to create new one.                          ||");
		System.out.println("||====================================================================||");
		
		System.out.print("Enter playlist's name : ");
		String name = sc.nextLine();
		
		UserPlaylist playlist = new UserPlaylist(name, id);
		int result = UserPlaylistDAO.getUserPlaylistMethod().createPlaylists(playlist);
		if(result==-1) {
			System.out.println("PLaylist's name has been used !!");
			createPlaylistUI(id);
			return;
		}else {
			System.out.println("Create a new playlist successfully !!");
			userMenuUI(id);
			return;
		}
	}
	
	public static void showAllPlaylistUI(int id) {
		System.out.println("||====================================================================||");
		System.out.println("||                      Show all playlists                            ||");
		System.out.println("||--------------------------------------------------------------------||");
		System.out.println("|| This is a list of playlists in your account                        ||");
		System.out.println("||====================================================================||");
		ArrayList<UserPlaylist> playlists =  UserPlaylistDAO.getUserPlaylistMethod().showAll(id);
		for(UserPlaylist playlist : playlists) {
			System.out.print(playlist);
		}
		userMenuUI(id);
	}
	
	public static void deletePlaylistUI(int id) {
		System.out.println("||====================================================================||");
		System.out.println("||                      Delete your playlists !                       ||");
		System.out.println("||--------------------------------------------------------------------||");
		System.out.println("|| Press name of playlist to delete .                                 ||");
		System.out.println("||====================================================================||");
		
		System.out.print("Enter playlist's name : ");
		String name = sc.nextLine();
		
		UserPlaylist playlist = new UserPlaylist(name, id);
		int result = UserPlaylistDAO.getUserPlaylistMethod().deletePlaylist(playlist);
		if(result==-1) {
			System.out.println("Your playlist's name is not existing !!");
			deletePlaylistUI(id);
			return;
		}else {
			System.out.println("Delete your playlist successfully !!");
			userMenuUI(id);
			return;
		}
	}
	
	public static void userSearchTracks(int id) {
		String s = "Find music by title : ";
		System.out.println("||====================================================================||");
		System.out.println("||                   Search in Library!                               ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Find music by title.                                            ||");
        System.out.println("|| 2. Find music by artist.                                           ||");
        System.out.println("|| 3. Find music by album.                                            ||");
        System.out.println("|| 4. Find music by genre.                                            ||");
        System.out.println("|| 5. Back to Main Menu.                                              ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
		String n = "";
		int formatNum = 0;
		
		do {
			System.out.print("Your number : ");
			n = sc.nextLine();
			try {
        		formatNum = Integer.parseInt(n.trim());
        	} catch (NumberFormatException e) {
        		System.out.println("");
        	}
			if(n.trim().equals("9")) {
				System.out.println("Exit");
				return;
			}else if(n.trim().equals("1")) {
				break;
			}else if(n.trim().equals("2")) {
				s = "Enter artist of music : ";
				break;
			}else if(n.trim().equals("3")) {
				s = "Enter album of music : ";
				break;
			}else if(n.trim().equals("4")) {
				s = "Enter genre of music : ";
				break;
			}
			else if(n.trim().equals("5")) {
				userMenuUI(id);
				return;
			}else {
				System.out.println("Invalid value !! Please try again!");
			}
		}while(formatNum<1 && formatNum >5 ||!n.trim().equals("9"));
		System.out.print(s);
		String findString = sc.nextLine();
		System.out.println("Result of "+"\""+findString+"\" : ");
		ArrayList<Track> tracks = TrackDAO.getTrackMethod().searchByUser(formatNum, findString);
		for(Track track : tracks) {
			System.out.println(track);
		}
		userMenuUI(id);
		return;
		
	}
	
	public static void addMusicToPlaylist(int id) {
		ArrayList<Track> trackList= TrackDAO.getTrackMethod().viewAll();
		System.out.println("||====================================================================||");
		System.out.println("||                    Add music to playlist !                         ||");
		System.out.println("||--------------------------------------------------------------------||");
		System.out.println("||This is a list of musics in library                                 ||");
		System.out.println("||Please choose and enter music name to add into your playlists       ||");
		System.out.println("||--------------------------------------------------------------------||");
		System.out.println("||====================================================================||");
		for(Track track : trackList) {
			System.out.println(track);
		}
		System.out.print("Enter your playlist's name : ");
		String playlist_name = sc.nextLine();
		UserPlaylist user_playlist =UserPlaylistDAO.getUserPlaylistMethod().checkExistPlaylist(playlist_name);
		if(user_playlist==null) {
			System.out.println("Your playlist is not existing");
			addMusicToPlaylist(id);
			return;
		}
		System.out.print("Enter your favourite music's name : ");
		String music_name = sc.nextLine();
		int getMusicID = TrackDAO.getTrackMethod().viewDetails(1, music_name).getIdTracks();
		if(getMusicID<=0) {
			System.out.println("Invalid music's name ! Please try again!");
			addMusicToPlaylist(id);
			return;
		}
		int getUserPlaylistID = user_playlist.getId();
		Playlist music = new Playlist(getUserPlaylistID,getMusicID,id);
		int rs  = PlaylistDAO.getPlaylistMethod().addMusicToPlaylist(music);
		if(rs!=0) {
			System.out.println("Add music to playlist successfully");
		}else {
			System.out.println("Add music to playlist unsuccessfully");
		}
		userMenuUI(id);
	}
	
	public static void userSearchPlaylists(int id) {
		System.out.println("-----------------------------------------------------------------------");
		System.out.print("Enter your playlist's name : ");
		String playlist_name = sc.nextLine();
		UserPlaylist user_playlist =UserPlaylistDAO.getUserPlaylistMethod().checkExistPlaylist(playlist_name);
		if(user_playlist==null) {
			System.out.println("Your playlist is not existing");
			userSearchPlaylists(id);
			return;
		}
		
		System.out.println("");
		System.out.println("||====================================================================||");
		System.out.println("||                   Search in your playlist!                         ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Find music by title.                                            ||");
        System.out.println("|| 2. Find music by artist.                                           ||");
        System.out.println("|| 3. Find music by album.                                            ||");
        System.out.println("|| 4. Find music by genre.                                            ||");
        System.out.println("|| 5. Show all musics in your playlist.                               ||");
        System.out.println("|| 6. Back to Main Menu.                                              ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
        String n = "";
        int getUserPlaylistID = user_playlist.getId();
        String s = "Enter title of music : ";
		int formatNum = 0;
		do {
			System.out.print("Your number : ");
			n = sc.nextLine();
			try {
        		formatNum = Integer.parseInt(n.trim());
        	} catch (NumberFormatException e) {
        		System.out.println("");
        	}
			if(n.trim().equals("9")) {
				System.out.println("Exit");
				return;
			}else if(n.trim().equals("1")) {
				break;
			}else if(n.trim().equals("2")) {
				s = "Enter artist of music : ";
				break;
			}else if(n.trim().equals("3")) {
				s = "Enter album of music : ";
				break;
			}else if(n.trim().equals("4")) {
				s = "Enter genre of music : ";
				break;
			}else if(n.trim().equals("5")) {
				ArrayList<Track> musics = PlaylistDAO.getPlaylistMethod().showMusicInPlaylist(getUserPlaylistID,id);
				for(Track music : musics) {
					System.out.println(music);
				}
				userMenuUI(id);
				return;
			}else if(n.trim().equals("6")) {
				userMenuUI(id);
				return;
			}else {
				System.out.println("Invalid value !! Please try again!");
			}
		}while(formatNum<1 && formatNum >6 ||!n.trim().equals("9"));
		System.out.print(s);
		String findString = sc.nextLine();
		System.out.println("Result of "+"\""+findString+"\" : ");
		ArrayList<Track> tracks = PlaylistDAO.getPlaylistMethod().searchInPlaylist(formatNum, findString,getUserPlaylistID,id);
		for(Track track : tracks) {
			System.out.println(track);
		}
		userMenuUI(id);
	}
	
	
	public static void userMenuUI(int id) {
		System.out.println("||====================================================================||");
		System.out.println("||             Welcome to Music Library System!                       ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Create a new playlist                                           ||");
        System.out.println("|| 2. Show all playlists                                              ||");
        System.out.println("|| 3. Remove a playlist                                               ||");
        System.out.println("|| 4. Add music to playlist                                           ||");
        System.out.println("|| 5. Display all music tracks in the library.                        ||");
        System.out.println("|| 6. Search music tracks.                                            ||");
        System.out.println("|| 7. Search playlists.                                               ||");
        System.out.println("|| 8. Log out.                                                        ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
        
        String n="";
        int formatNum = 0;
        do {
        	System.out.print("Your number : ");
        	n = sc.nextLine();
        	try {
        		formatNum = Integer.parseInt(n);
        	} catch (NumberFormatException e) {
        		System.out.println("");
        	}
        	switch(n.trim()){
            case "1":
            	createPlaylistUI(id);
                return;
            case "2":
            	showAllPlaylistUI(id);
            	return;
            case "3":
            	deletePlaylistUI(id);
            	return;
            case "4":
            	addMusicToPlaylist(id);
            	return;
            case "5":
            	viewAllUI("user");
            	return;
            case "6":
            	userSearchTracks(id);
            	return;
            case "7":
                userSearchPlaylists(id);
            	return;
            case "8":
            	mainUI();
            	return;
            case "9":
            	System.out.println("Thanks for using our app.");
                break;
            default:
            	System.out.println("Invalid value !! Please try again");
                break;
        	}
        }while(formatNum>=8 && formatNum<=0 || formatNum!=9);
	}
	
	
	
	
	
	public static void adminMenuUI() {
		System.out.println("||====================================================================||");
		System.out.println("||             Welcome to Music Library Management System!            ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Add a new music track.                                          ||");
        System.out.println("|| 2. View details of specific music track.                           ||");
        System.out.println("|| 3. Update details of existing music track.                         ||");
        System.out.println("|| 4. Delete a music track from library.                              ||");
        System.out.println("|| 5. Display all a list of all music tracks in the library.          ||");
        System.out.println("|| 6. Log out.                                                        ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
       
        String n="";
        int formatNum = 0;
        do {
        	System.out.print("Your number : ");
        	n = sc.nextLine();
        	try {
        		formatNum = Integer.parseInt(n);
        	} catch (NumberFormatException e) {
        		System.out.println("");
        	}
        	switch(n.trim()){
            case "1":
            	addTrackUI();
                return;
            case "2":
            	viewDetailsUI();
            	return;
            case "3":
            	updateMusicUI();
            	return;
            case "4":
            	deleteMusicUI();
            	return;
            case "5":
            	viewAllUI("admin");
            	return;
            case "6":
            	loginUI();
            	return;
            case "9" : 
                System.out.println("Thanks for using our app.");
                break;
            default:
            	System.out.println("Invalid value !! Please try again");
                break;
        	}
        }while(formatNum>=7 && formatNum<=0 || formatNum!=9);
        
	}
	
	
	public static void mainUI() {
		System.out.println("||====================================================================||");
		System.out.println("||            Welcome to Music Library Management System!             ||");
		System.out.println("||====================================================================||");
        System.out.println("|| Please press any number to use our app                             ||");
        System.out.println("|| 1. Login                                                           ||");
        System.out.println("|| 2. Register                                                        ||");
        System.out.println("|| 3. Display all a list of all music tracks in the library.          ||");
        System.out.println("|| 9. Exit application.                                               ||");
        System.out.println("||---------------------------------||---------------------------------||");
        
        String n="";
        int formatNum = 0;
        do {
        	System.out.print("Your number : ");
        	n = sc.nextLine();
        	try {
        		formatNum = Integer.parseInt(n);
        	} catch (NumberFormatException e) {
        		System.out.println("");
        	}
        	switch(n.trim()){
            case "1":
            	loginUI();
                return;
            case "2":
            	registerUI();
            	return;
            case "3":
            	viewAllUI("guest");
            	return;
            case "9" : 
                System.out.println("Thanks for using our app.");
                break;
            default:
            	System.out.println("Invalid value !! Please try again");
                break;
        	}
        }while(formatNum>=4 && formatNum<=0 || formatNum!=9);
        
	}
}


