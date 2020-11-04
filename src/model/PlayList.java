package model;
public abstract class PlayList {
private String nombre;
private int duraccion;
private String genre;
private Song[] songs;


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
}