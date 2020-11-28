package model;
public class Mcs {
	private User [] users;
	private PlayList [] playLists;
	private Song [] poolSongs;
	public static final int MAX_USERS = 10;
	public static final int MAX_PLAYLIST = 20 ;
	public static final int MAX_SONGS = 30 ;
	private String[] countain ;
	/**
	 * Constructor
	 *initialize variables
	 */
	public Mcs(){
		users = new User[MAX_USERS];
		playLists = new PlayList[MAX_PLAYLIST];
		poolSongs = new Song[MAX_SONGS];
		countain = new String[MAX_USERS];
		
	}
	/**
	*addUser: add user a arrays
	*<b> pre: </b>
	*<b> pos: </b> add user
	*@param  name is a String
	*@param key is a String
	*@param age is a int
	*/
	
	public void addUser(String name, String key,int age ){// añadir usuario 
		String category= "NEWBIE";
		boolean run = false;
		User user = new User(name,key,age,category);
		for(int i= 0;(i<users.length)&& !run;i++){
			if(users[i] == null){
				users[i] = user;
				run = true;
			}
		}
	}
	/**
	*publicExistenceValidation : validate that there is a public playlist
	*<b> pre: </b>
	*<b> pos: </b> 
	*@return out is a boolean
	*/
	
	public boolean publicExistenceValidation(){
		boolean out = false;
		for(int i = 0;i< playLists.length; i++){
			if(playLists[i] != null){
				if(playLists[i] instanceof Public ){
					out = true;
				}
			}		
		}
		return out;	
	}
	/**
	*qualification: validate that there is a public playlist
	*<b> pre: </b>
	*<b> pos: </b> 
	*@return String text
	*/
	public String qualification(){
		String out = "";
		for(int i = 0;i< playLists.length; i++){
			if(playLists[i] != null){
				if(playLists[i] instanceof Public ){
					out += i+"-"+playLists[i].getName()+"\n";
				}	
			}		
		}
		return out;	
	}
	/**
	*changeRating: 
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  choice is a int
	*@param qualification is a int
	*@return String text
	*/
	public String changeRating(int choice, int qualification){
		String out = "ESCOJA UNA OPCION VALIDA";
		if(playLists[choice] instanceof Public ){
			
			playLists[choice].changeRaiting(qualification);
			out = "Calificacion Exitosa";
		}
		return out;
		
	}
	/**
	*changeRating: to change the public playlist rating
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  position is a int
	*@return int position
	*/
	public int playListChecker(int position){
		int num = 0;
			if(playLists[position] != null){
				if(playLists[position] instanceof Public ){
					num = 1;
				}
				if(playLists[position] instanceof Private){
					num = 2;
				}
				else if(playLists[position] instanceof Restringed){
					num = 3;
				}
			}
		
		return num;
	}
	/**
	*showUser: print registered users
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String text
	*/
	
	public String showUser(){ 
		String text = "";
		for(int i = 0; (i<users.length);i++){
			if(users[i] != null){
				text += users[i].showDat();
			}
		}
		return text;
	}
	/**
	*showSongs: print registered songs
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String text
	*/
	public String showSongs(){ 
		String text = "";
		for(int i = 0; (i < poolSongs.length);i++){
			if(poolSongs[i] != null ){
				text += poolSongs[i].showData();
			}
		}
		return text;
	}
	/**
	*showList: print registered list
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String text
	*/
	public String showList(){ 
	String text = "";
		for(int i = 0; (i < playLists.length);i++){
			if(playLists[i] != null ){
				text += playLists[i].showList();
			}
		}
		return text;
	}
	/**
	*showUser: print registered name users
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String text
	*/
	public String nameUser(){ 
		String text = "";
		for(int i = 0; (i<users.length);i++){
			if(users[i] != null){
				text += (i+ "-"+users[i].showUser()+"\n");
			}
		}
		return text;
	}
	/**
	*showUser: print registered songs
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String text
	*/
	public String showSong(){ 
	String text = "";
		for(int i = 0; (i < poolSongs.length);i++){
			if(poolSongs[i] != null ){
			text +=(i+"- "+ poolSongs[i].showSongs()+"\n");
			}
		}
		return text;
	}
	/**
	*showLits: print registered list
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String text
	*/
	public String showLists(){ 
	String text = "";
		for(int i = 0; (i < playLists.length);i++){
			if(playLists[i]!= null ){
				text += (i+ " -" +playLists[i].getName()+"\n");
			}
		}
		return text;
	}
	/**
	*validate: validates that the user is the editor
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  numList is a int
	*@param  user is a String
	*@return boolean out
	*/
	public boolean validate(int numList , String user){
		boolean out = false;
		
		if(playLists[numList].checkUser(user)== true){
			out= true;	
		}
		return out;
	}
	/**
	*addSongPlay: add a song to mcs
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  numList is a int
	*@param  numSong is a int
	*/
	public void addSongPlay(int numList,int numSong){
		int time =poolSongs[numSong].getDuration();
		playLists[numList].updateDuration(time);
	}
	/**
	*addGenrePlaylist: add the genre of the song to the playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  numList is a int
	*@param  numSong is a int
	*/
	public void addGenrePlaylist(int numList,int numSong){
		String genre =poolSongs[numSong].getGenero().toString();
		playLists[numList].updateGenre(genre);
	}
	/**
	*addPlayList: add the genre of the song to the playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  name is a String
	*@param  duration is a int
	*@param userIndex is a arrays
	*/
	public void addPlayList(String name,int duration,int[] userIndex){
		String genre = "";
		User[] user = new User[userIndex.length];
		for(int i =0;i< userIndex.length;i++){
			user[i]=users[userIndex[i]];
		}
		PlayList list = new Restringed(name,duration,genre,user);
			boolean run = false ;
			for(int i = 0 ; (i < playLists.length) && !run; i++){
				if(playLists[i] == null){
					playLists[i] = list;
					run = true ;
				}	
			}
	}
	/**
	*addPlayList: create a public playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  name is a String
	*@param  duration is a int
	*/
	public void addPlayList(String name,int duration){
		String genre = "";
		double calificacion = 0;
		PlayList list = new Public(name,duration,genre,calificacion);
		boolean run = false ;
			for(int i = 0 ; (i < playLists.length) && !run; i++){
				if(playLists[i] == null){
					playLists[i] = list;
					run = true;
				}
		
				
			}
	}
	/**
	*addPlayList: create a private playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  name is a String
	*@param  duration is a int
	*@param name1 int
	*/
	public void addPlayList(String name,int duration,int name1){
		String genre = "";
		User user ;
		user = users[name1];
		PlayList list = new Private(name,duration,genre,user);
			boolean run = false ;
			for(int i = 0 ; (i < playLists.length) && !run; i++){
				if(playLists[i] == null){
					playLists[i] = list;
					run = true;
				}
		
				
			}
	}
	/**
	*addSong: create a song in the collection
	*<b> pre: </b>
	*<b> pos: </b>
	*@param  title is a String
	*@param  artist is a String
	*@param  releaseDate is a String
	*@param  duration is a int
	*@param  genre is a String
	*@param position is a int
	*@return String text
	*/
	public String addSong(String title,String artist,String releaseDate ,int duration,String genre,int position){
		String text ="";		
				if(users[position]!= null){
				users[position].countainSong();
				Song list = new Song(title,artist,releaseDate,duration,genre,users[position]);
				boolean run = false;
				for(int i = 0; (i< poolSongs.length) && !run; i++ ){
					if(poolSongs[i] == null){
					poolSongs[i] = list;
					
					run = true;
					}
					
					}
					text= "Cancion creada con exito";
				}
				return text;
	}
	/**
	*existenceUser: validates that the user is created
	*<b> pre: </b>
	*<b> pos: </b>
	*@return boolean out
	*/
	public boolean existenceUser(){
		boolean out = false;
		for(int i = 0; i< users.length; i++){
			if(users[i] != null){
				out = true;
			}
		}
		return out;
	}
	/**	*existenceUser: validates that the song is created
	*<b> pre: </b>
	*<b> pos: </b>
	*@return boolean out
	*/
	public boolean existenceSongs(){
		boolean out = false;
		for(int i= 0;i< poolSongs.length;i++){
			if(poolSongs[i] != null){
				out = true;
			}
		}
		return out;
	}
	/**
	*positionValidSong: validate that the position of the song is correct
	*<b> pre: </b>
	*<b> pos: </b>
	*@param position is a int 
	*@return boolean out
	*/
	public boolean positionValidSong(int position){
		boolean out = false;
		if(poolSongs[position] != null){
			out = true;
		}
		return out;
	}
	/**
	*positionValidPlayList: validate that the position of the playLists is correct
	*<b> pre: </b>
	*<b> pos: </b>
	*@return boolean out
	*@param position is a int
	*/
	public boolean positionValidPlayList(int position){
		boolean out = false;
		if(playLists[position] != null){
			out = true;
		}
		return out;
	}
	/**
	*positionValidUser: validate that the position of the user is correct
	*<b> pre: </b>
	*<b> pos: </b>
	*@param position is a int
	*@return boolean out
	*/
	public boolean positionValidUser(int position){
		boolean out = false;
		if(users[position] != null){
			out = true;
		}
		return out;
	}
	
}