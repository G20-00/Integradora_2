package model;
public class Restringed  extends PlayList{
	private User[] users;
	public static final int MAX_USER = 5;
	
	public Restringed(String nombre,int duraccion,String genre ,User[]users) {
		super(nombre,duraccion,genre);
		this.users = users; 
		super.updateDuration(duraccion);
		super.time();
	} 
	
	
	@Override
	public String showList(){
		String out = "";
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" +time ()+"\n**Generos :"+getGenre()
		+"\n**Nombre de editores :"+showUsers()+"\n********************"	);
		return out;
	}
	@Override
	public String showLists(){
		String out = "";
		out =("******PlayList******"+"\n**Nombre de la playList :"+ getName());
		return out;
	}
	public String showUsers(){
		String out= "";
		int count = 1;
		for(int i = 0;i<users.length;i++){
		if(users[i] !=null){
			out += "\n"+users[i].getName();
				
			}
		}
		return out;
	}
	@Override
	public boolean revisarUsuario(String usuario){
		boolean out= false ;
		for(int i= 0; i< users.length;i++){
		if(users[i].getName().equals(usuario)){
			out= true;
		}
		}
		return out;
	}
	
	
}