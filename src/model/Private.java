package model;
public class Private extends PlayList{
	private User user;
	
	public Private(String nombre,int duraccion,String genre,User user){
		super(nombre,duraccion,genre);
		this.user = user;
		super.updateDuration(duraccion);
		super.time();  
		
	}
	
	@Override
	public String showList(){
		String out = "";
		out =("\n******PlayList******"+"\n**Nombre de la playList :"+ getName() + "\n**Duraccion :" + time()+"\n**Generos :"+getGenre()
		+"\n**Nombre de editor :"+user.getName()+"\n********************"	);
		return out;
	}
	@Override
	public String showLists(){
		String out = "";
		out =("******PlayList******"+"\n**Nombre de la playList :"+ getName());
		return out;
	}
	@Override
	public boolean revisarUsuario(String usuario){
		boolean out= false ;
		if(user.getName().equals(usuario)){
			out= true;
		}
		return out;
	}
	
}