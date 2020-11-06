package model;
public class Restringed  extends PlayList{
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	
	public Restringed(String nombre,int duraccion,String genre ,String name1, String name2,String name3,String name4,String name5) {
		super(nombre,duraccion,genre);
		this.name1= name1;
		this.name2= name2;
		this.name3= name3;
		this.name4= name4;
		this.name5= name5;
		super.updateDuration(duraccion);
	} 
	public String getName1(){
		return name1;
	}
	public String getName2(){
		return name2;
	}
	public String getName3(){
		return name3;
	}
	public String getName4(){
		return name4;
	}
	public String getName5(){
		return name5;
	}
	
	@Override
	public String showList(){
		String out = "";
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" + getDuraccion()+"\n**Generos :"+getGenre()
		+"\n**Nombre de editores :"+"\n*"+getName1()+"\n*"+getName2()+"\n*"+getName3()+"\n*"+ getName4()+"\n*" +getName5()+"\n********************"	);
		return out;
	}
	@Override
	public String showLists(){
		String out = "";
		out =("******PlayList******"+"\n**Nombre de la playList :"+ getName());
		return out;
	}
	
}