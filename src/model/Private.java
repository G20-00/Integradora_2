package model;
public class Private extends PlayList{
	private User user;
	/**
	 * Constructor
	 * @param name is a String
	 * @param duration is a int
	 * @param genre is a String
	 * @param user is a object
	 */
	public Private(String name,int duration,String genre,User user){
		super(name,duration,genre);
		this.user = user;
		super.updateDuration(duration);
		super.time();  
		
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
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" + time()+"\n**Generos :"+getGenre()
		+"\n**Nombre de editor :"+user.getName()+"\n********************"	);
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
	*checkUser: check the existence of the user
	*<b> pre: </b>
	*<b> pos: </b>
	*@param users is a String 
	*@return boolean out 
	*/	
	@Override
	public boolean checkUser(String users){
		boolean out= false ;
		if(user.getName().equals(users)){
			out= true;
		}
		return out;
	}
	
}