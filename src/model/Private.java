package model;
public class Private extends PlayList{
	private String name1;
	
	public Private(String nombre,int duraccion,String genre,String name1){
		super(nombre,duraccion,genre);
		this.name1 = name1;
		
	}
public getName1(){
	return name1;
}
}