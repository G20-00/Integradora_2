package model;
public class Song{
private String title;
private String artist;
private String releaseDate;
private int duration;

//Relationships
private EnumGenre genre;
private User user;
	/**
	 * Constructor
	 * @param title is a String 
	 * @param artist is a int
	 * @param releaseDate is a String
	 * @param duration is a int
	 * @param genre is a String
	 * @param user is a object 
	 */
	public Song(String title,String artist,String releaseDate,int duration,String genre,User user){
		this.title= title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.genre= EnumGenre.valueOf(genre.toUpperCase().replace(' ','_'));
		this.user =user;
		 
		
	}
	//getters
	public String getTitle() {
		return title; 
	}
	public String getArtist() {
		return artist ;
	}
	public String getreleaseDate(){
		return releaseDate;
	}
	public int getDuration(){
		return duration;
	}
	public EnumGenre getGenero(){
		return genre;
	}
	public User getUser(){
		return user;
	}
	/**
	*showData:Print the data of each song
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String out 
	*/
	public String showData(){
		String out = "";
		out= ("\n******Song******"+"\n Titulo :"+ getTitle() + "\n Artista :"+ getArtist() + "\n Duraccion :"+time()+"\n Genero :"+ getGenero()+"\n Usuario:"+user.getName()+"\n****************\n");
		return out;
	}
	/**
	*showSongs:Print the titles of each song
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String out 
	*/
	public String showSongs(){
		String out = "";
		out += (" Titulo :"+ getTitle());
		return out;
	}
	/**
	*showData:convert seconds to minutes
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