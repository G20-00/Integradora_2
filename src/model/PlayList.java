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
	public boolean revisarUsuario(String usuario){
		boolean out= false ;
		
		return out;
	}
	public String time(){
		String time = "";
		int min = 0;
		int sec = getDuraccion();
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