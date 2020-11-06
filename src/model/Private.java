package model;
public class Private extends PlayList{
	private String name1;
	private String clave;
	
	public Private(String nombre,int duraccion,String genre,String name1){
		super(nombre,duraccion,genre);
		this.name1 = name1;
		super.updateDuration(duraccion);
		
		
	}
	public String getName1(){
	return name1;
	}
	@Override
	public boolean  addSongPlaylist(String name){
		boolean out = false ;
		System.out.println("Funciona private");
		if(getName1().equalsIgnoreCase(name)){
			out = false;
		}
		return out;
	}
	
}