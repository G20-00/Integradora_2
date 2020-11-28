package model;
public class Public extends PlayList{
	private double qualification; 
	private int countain;
	/**
	 * Constructor
	 * @param name is a String
	 * @param duration is a int
	 * @param genre is a String
	 * @param qualification is a double
	 * @param duration is a int
	 */
	public Public(String name,int duration,String genre,double qualification){
		super(name,duration,genre);
		this.qualification = qualification;
		countain = 0;
		super.time();
	}
	//getters 
	public double getQualifictation(){
		return qualification;
	}
	/**
	*showList:print the data of a playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String out 
	*/
		@Override
	public String showList(){
		String out = "";
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" +time ()+"\n**Generos :"+getGenre()
		+"\n**Calificacion :"+qualification()+"\n********************"	);
		return out;
	}
	/**
	*showList:print the name of the playlists
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String out 
	*/
	@Override
	public String showLists(){
		String out = "";
		out =("******PlayList******"+"\n**Nombre de la playList :"+ getName());
		return out;
	}
	/**
	*changeRaiting: change the rating depending on the user
	*<b> pre: </b>
	*<b> pos: </b>
	*@param qualification is a int 
	*/	
	@Override
	public void changeRaiting(int qualification){
		qualification+= qualification;
		countain++;
		
		
	}	
	/**
	*qualification: is in charge of making the grade averages
	*<b> pre: </b>
	*<b> pos: </b>
	*@return double out  
	*/	
	public double qualification(){
		double out= qualification/countain;
		return out;
	}
	
}