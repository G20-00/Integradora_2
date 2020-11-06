package model;
public class User{
private String nombre;
private String clave;
private int edad;
private EnumCategory category;

public User(String nombre, String clave, int edad,String category){
	this.nombre = nombre;
	this.clave	= clave;
	this.edad 	= edad ;
	this.category = EnumCategory.valueOf(category);
	}
	public String getName(){
		return nombre;
	}
	public String getClave(){
		return clave;
	}
	public int getEdad(){
		return edad;
	}
	public EnumCategory getCategory(){
		return category;
	}

public String showDat(){
	String out = "";
	out = ("*****User*****"+"\n **Nombre :"+ getName()+ "\n **Edad :"+ getEdad()+"\n **Categoria :"+getCategory()+"\n***************\n");
	return out;
	
}
public String showUser(){
	String out= "";
	out = getName();
	return out;
}
}