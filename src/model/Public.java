package model;
public class Public extends PlayList{
	private double calificacion; 
	private int countain;
	public Public(String nombre,int duraccion,String genre,double calificacion){
		super(nombre,duraccion,genre);
		this.calificacion = calificacion;
		countain = 0;
	}
	public double getCalificacion(){
		return calificacion;
	}
		@Override
	public String showList(){
		String out = "";
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" + getDuraccion()+"\n**Generos :"+getGenre()
		+"\n**Calificacion :"+qualification()+"\n********************"	);
		return out;
	}
	@Override
	public String showLists(){
		String out = "";
		out =("******PlayList******"+"\n**Nombre de la playList :"+ getName());
		return out;
	}
	@Override
	public void changeRaiting(int qualification){
		calificacion+= qualification;
		countain++;
		
		
	}	
	public double qualification(){
		double out= calificacion/countain;
		return out;
	}
}