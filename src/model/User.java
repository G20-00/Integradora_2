package model;
public class User{
private String nombre;
private String clave;
private int edad;
private EnumCategory category;
private	int countainSong;
public User(String nombre, String clave, int edad,String category){
	this.nombre = nombre;
	this.clave	= clave;
	this.edad 	= edad ;
	this.category = EnumCategory.valueOf(category);
	countainSong = 0;
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
	out = ("*****User*****"+"\n **Nombre :"+ getName()+ "\n **Edad :"+ getEdad()+"\n **Categoria :"+category()+"\n***************\n");
	return out;
	
}
public String showUser(){
	String out= "";
	out = getName();
	return out;
}
public void countainSong(){
countainSong=countainSong+1;
}
public String category(){
	String text = "NEWBIE";
	if(countainSong >= 3 && countainSong< 10 ){
		text = "LITTLE_CONTRIBUTOR";
	}
	else if(countainSong >= 10 && countainSong < 30){
		text = "MILD_CONTRIBUTOR";
	}else if(countainSong >= 30){
		text  ="STAR_CONTRIBUTOR";
	}
	return text;
	}
	
}