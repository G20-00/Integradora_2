package model;
public abstract class PlayList {
private String nombre;
private int duraccion;
private String genre;



	public PlayList(String nombre,int duraccion,String genre){
		this.nombre = nombre;
		this.duraccion = duraccion;
		this.genre = genre ; 
	}
	public String getName(){
		return nombre;
	}
	public int getDuraccion(){
		return duraccion;
	}
	public String getGenre(){
		return genre;
	}
	public String showList(){
		String out = "";
		return out;
	}
	public String showLists(){
		String out = "";
		return out;
	}
	public void updateDuration(int newDuration){
		duraccion+= newDuration;
	}	
	public void updateGenre(String genre1){
		genre+= (genre1+",");
	}
	public boolean  addSongPlaylist(String name){
		boolean out= false;

			return out;
	}
	public void changeRaiting(int qualification){
		
	}	
}