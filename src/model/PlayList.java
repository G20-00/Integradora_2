package model;
public abstract class PlayList {
private String name;
private int duration;
private String genre;
private String[] genres;

	/**
	 * Constructor
	 * @param name is a String
	 * @param duration is a int
	 * @param genre is a String
	 */

	public PlayList(String name,int duration,String genre){
		this.name = name;
		this.duration = duration;
		this.genre = genre ;
		genres= new String[4];		
	}
	//getters 
	public String getName(){
		return name;
	}
	public int getDuration(){
		return duration;
	}
	public String getGenre(){
		return genre;
	}
	/**
	*showList:print the data of a playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String out 
	*/
	public String showList(){
		String out = "";
		return out;
	}
	/**
	*showList:print the name of the playlists
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String out 
	*/
	public String showLists(){
		String out = "";
		return out;
	}
	/**
	*updateDuration: stores the duration of each song in the playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@param newDuration is a int 
	*/
	public void updateDuration(int newDuration){
		duration+= newDuration;
	}
	/**
	*updateGenre: stores the genre of each song in the playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@param genre1 is a String  
	*/	
	public void updateGenre(String genre1){
		boolean found = false;
		boolean out = false;
		for(int i=0; i< genres.length && !out; i++){
			
			if(genres[i]==null){
				
				for(int j=0; i< genres.length && !out; j++){
					
					if(genres[j]==genre1){
						
						found = true;
					}
					else {
						genres[j]=genre1;
						out= true;
					}
				}	
			}
		}
		
		if(found == false){
			
			genre+= (genre1+",");
			}
	}
	/**
	*addSongPlaylist: stores the genre of each song in the playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@param name  is a String 
	*@return out String
	*/	
	public boolean  addSongPlaylist(String name){
		boolean out= false;

			return out;
	}/**
	*changeRaiting: change the rating depending on the user
	*<b> pre: </b>
	*<b> pos: </b>
	*@param qualification is a int 
	*/	
	public void changeRaiting(int qualification){
		
	}
	/**
	*checkUser: check the existence of the user
	*<b> pre: </b>
	*<b> pos: </b>
	*@param user is a String 
	*@return boolean out 
	*/	
	public boolean checkUser(String user){
		boolean out= false ;
		
		return out;
	}
	/**
	*time: convert seconds to minutes
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String time 
	*/	
	public String time(){
		String time = "";
		int min = 0;
		int sec = getDuration();
		if(sec >= 60){
		while(sec >=60){
				sec -=60;
				min++;
				time = String.valueOf(min);
				time += ":"+String.valueOf(sec);
			}
		}else {
			time = "00:"+String.valueOf(sec);
		}
		
		return time;	
	}
}