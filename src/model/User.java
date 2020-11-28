package model;
public class User{
private String name;
private String key;
private int age;
private	int countainSong;
//Relationships
private EnumCategory category;
/**
	 * Constructor
	 * @param name is a String
	 * @param age is a int
	 * @param key is a String
	 * @param category is a String
	 */
public User(String name, String key, int age,String category){
	this.name = name;
	this.key	= key;
	this.age 	= age ;
	this.category = EnumCategory.valueOf(category);
	countainSong = 0;
	}
		//getters
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public EnumCategory getCategory(){
		return category;
	}

public String showDat(){
	String out = "";
	out = ("*****User*****"+"\n **Nombre :"+ getName()+ "\n **Edad :"+ getAge()+"\n **Categoria :"+category()+"\n***************\n");
	return out;
	
}
/**
	*showUser:return the name of a user
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String out 
	*/
public String showUser(){
	String out= "";
	out = getName();
	return out;
}
/**
*countainSong:adds when a song is added
*<b> pre: </b>
*<b> pos: </b>
*/
public void countainSong(){
countainSong=countainSong+1;
}
/**
	*category:
change user category
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String text 
	*/
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