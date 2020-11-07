package model;
public class Song{
private String titulo;
private String artista;
private String fechaLanzamiento;
private int duraccion;
private EnumGenre genre;
private User user;

	public Song(String titulo,String artista,String fechaLanzamiento,int duraccion,String genre,User user){
		this.titulo= titulo;
		this.artista = artista;
		this.fechaLanzamiento = fechaLanzamiento;
		this.duraccion = duraccion;
		this.genre= EnumGenre.valueOf(genre.toUpperCase().replace(' ','_'));
		this.user =user;
		
	}
	public String getTitulo() {
		return titulo; 
	}
	public String getArtista() {
		return artista ;
	}
	public String getFechaLanzamiento(){
		return fechaLanzamiento;
	}
	public int getDuraccion(){
		return duraccion;
	}
	public EnumGenre getGenero(){
		return genre;
	}
	public User getUser(){
		return user;
	}
	public String showData(){
		String out = "";
		out= ("\n******Song******"+"\n Titulo :"+ getTitulo() + "\n Artista :"+ getArtista() + "\n Duraccion :"+time()+"\n Genero :"+ getGenero()+("\n Usuario:"+user.getName()));
		return out;
	}
	public String showSongs(){
		String out = "";
		out += (" Titulo :"+ getTitulo());
		return out;
	}
	public String time(){
		String time = "";
		int min = 0;
		int sec = getDuraccion();
		while(sec >=60){
				sec -=60;
				min++;
				time = String.valueOf(min);
				time += ":"+String.valueOf(sec);
			}
		return time;	
	}
}