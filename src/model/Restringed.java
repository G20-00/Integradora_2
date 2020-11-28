package model;
public class Restringed  extends PlayList{
	private User[] users;
	public static final int MAX_USER = 5;
	/**
	 * Constructor
	 * @param name is a String
	 * @param duration is a int
	 * @param genre is a String
	 * @param users is a object
	 */
	public Restringed(String name,int duration,String genre ,User[]users) {
		super(name,duration,genre);
		this.users = users; 
		super.updateDuration(duration);
		super.time();
	} 
	/**
	*showList:print the data of a playlist
	*@return String out 
	*/
	@Override
	public String showList(){
		String out = "";
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" +time ()+"\n**Generos :"+getGenre()
		+"\n**Nombre de editores :"+showUsers()+"\n********************"	);
		return out;
	}
	/**
	*showList:print the name of the playlists
	*@return String out 
	*/
	@Override
	public String showLists(){
		String out = "";
		out =("******PlayList******"+"\n**Nombre de la playList :"+ getName());
		return out;
	}
	/**
	*showUsers:print the name of the users
	*<b> pre: </b>
	*<b> pos: </b>
	*@return String out 
	*/
	public String showUsers(){
		String out= "";
		int count = 1;
		for(int i = 0;i<users.length;i++){
		if(users[i] !=null){
			out += "\n**"+users[i].getName();
				
			}
		}
		return out;
	}
	/**
	*checkUser: check the existence of the user
	*<b> pre: </b>
	*<b> pos: </b>
	*@param user is a String 
	*@return boolean out 
	*/	
	@Override
	public boolean checkUser(String user){
		boolean out= false ;
		for(int i= 0; i< users.length;i++){
		if(users[i].getName().equals(user)){
			out= true;
		}
		}
		return out;
	}
	
	
}