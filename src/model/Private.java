package model;
public class Private extends PlayList{
	private String name1;
	
	public Private(String nombre,int duraccion,String genre,String name1){
		super(nombre,duraccion,genre);
		this.name1 = name1;
		super.updateDuration(duraccion);
		
		
	}
	public String getName1(){
	return name1;
	}
	
	@Override
	public String showList(){
		String out = "";
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" + getDuraccion()+"\n**Generos :"+getGenre()
		+"\n**Nombre de editor :"+"\n*"+getName1()+"\n********************"	);
		return out;
	}
	@Override
	public String showLists(){
		String out = "";
		out =("******PlayList******"+"\n**Nombre de la playList :"+ getName());
		return out;
	}
}