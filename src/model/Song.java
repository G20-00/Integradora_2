package model;
public class Song{
private String titulo;
private String artista;
private String fechaLanzamiento;
private int duraccion;
private EnumGenre genre;

	public Song(String titulo,String artista,String fechaLanzamiento,int duraccion,String genre){
		this.titulo= titulo;
		this.artista = artista;
		this.fechaLanzamiento = fechaLanzamiento;
		this.duraccion = duraccion;
		this.genre= EnumGenre.valueOf(genre.toUpperCase().replace(' ','_'));
		
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
	public String showData(){
		String out = "";
		out= ("\n******Song******"+"\n Titulo :"+ getTitulo() + "\n Artista :"+ getArtista() + "\n Duraccion :"+getDuraccion()+"\n Genero :"+ getGenero());
		return out;
	}
	public String showSongs(){
		String out = "";
		out += (" Titulo :"+ getTitulo());
		return out;
	}
}