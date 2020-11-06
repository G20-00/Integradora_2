package model;
public class Public extends PlayList{
	private int calificacion; 
	public Public(String nombre,int duraccion,String genre,int calificacion){
		super(nombre,duraccion,genre);
		this.calificacion = calificacion;
	}
	public int getCalificacion(){
		return calificacion;
	}
		@Override
	public String showList(){
		String out = "";
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" + getDuraccion()+"\n**Generos :"+getGenre()
		+"\n********************"	);
		return out;
	}
	@Override
	public String showLists(){
		String out = "";
		out =("******PlayList******"+"\n**Nombre de la playList :"+ getName());
		return out;
	}
}