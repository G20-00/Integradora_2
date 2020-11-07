package model;
public class Mcs {
	private User [] users;
	private PlayList [] playLists;
	private Song [] poolSongs;
	public static final int MAX_USERS = 10;
	public static final int MAX_PLAYLIST = 20 ;
	public static final int MAX_SONGS = 30 ;
	private String[] countain ;
	
	public Mcs(){
		users = new User[MAX_USERS];
		playLists = new PlayList[MAX_PLAYLIST];
		poolSongs = new Song[MAX_SONGS];
		countain = new String[MAX_USERS];
		
	}
	// añadir usuario 
	public void addUser(String nombre, String clave,int edad ){
		String category= "NEWBIE";
		boolean run = false;
		User user = new User(nombre,clave,edad,category);
		for(int i= 0;(i<users.length)&& !run;i++){
			if(users[i] == null){
				users[i] = user;
				run = true;
			}
		}
	}
	// existencia del public 
	public boolean validacionExistenciaPublic(){
		boolean out = false;
		for(int i = 0;i< playLists.length; i++){
			if(playLists[i] != null){
				if(playLists[i] instanceof Public ){
					out = true;
				}
			}		
		}
		return out;	
	}
	// calificacion del public
	public String calificacion(){
		String out = "";
		for(int i = 0;i< playLists.length; i++){
			if(playLists[i] != null){
				if(playLists[i] instanceof Public ){
					out += i+"-"+playLists[i].getName()+"\n";
				}	
			}		
		}
		return out;	
	}
	// Cambio de calificacion
	public String changeRating(int choice, int qualification){
		String out = "ESCOJA UNA OPCION VALIDA";
		if(playLists[choice] instanceof Public ){
			
			playLists[choice].changeRaiting(qualification);
			out = "Calificacion Exitosa";
		}
		return out;
		
	}
	//verificacion tipo de lista de Reproduccion
	public int verificadorPlayList(int posicion){
		int num = 0;
			if(playLists[posicion] != null){
				if(playLists[posicion] instanceof Public ){
					num = 1;
				}
				if(playLists[posicion] instanceof Private){
					num = 2;
				}
				else if(playLists[posicion] instanceof Restringed){
					num = 3;
				}
			}
		
		return num;
	}
	
	
	public String showUser(){ // users completos datos 
		String text = "";
		for(int i = 0; (i<users.length);i++){
			if(users[i] != null){
				text += users[i].showDat();
			}
		}
		return text;
	}
	
	public String showSongs(){ //songs 
		String text = "";
		for(int i = 0; (i < poolSongs.length);i++){
			if(poolSongs[i] != null ){
				text += poolSongs[i].showData();
			}
		}
		return text;
	}
	public String showList(){ //Playlist
	String text = "";
		for(int i = 0; (i < playLists.length);i++){
			if(playLists[i] != null ){
				text += playLists[i].showList();
			}
		}
		return text;
	}
	public String nameUser(){ // solo nombre usuarios 
		String text = "";
		for(int i = 0; (i<users.length);i++){
			if(users[i] != null){
				text += (i+ "-"+users[i].showUser()+"\n");
			}
		}
		return text;
	}
	public String showSong(){ //Solo nombre cancion 
	String text = "";
		for(int i = 0; (i < poolSongs.length);i++){
			if(poolSongs[i] != null ){
			text +=(i+"- "+ poolSongs[i].showSongs()+"\n");
			}
		}
		return text;
	}
	public String showLists(){ //solo nombre Playlist
	String text = "";
		for(int i = 0; (i < playLists.length);i++){
			if(playLists[i]!= null ){
				text += (i+ " -" +playLists[i].getName()+"\n");
			}
		}
		return text;
	}
	
	public boolean validar(int numList , String usuario){
		boolean out = false;
		
		if(playLists[numList].revisarUsuario(usuario)== true){
			out= true;	
		}
		return out;
	}

	//Cambio del tiempo playLists
	public void addSongPlay(int numList,int numSong){
		int time =poolSongs[numSong].getDuraccion();
		playLists[numList].updateDuration(time);
	}
	//cambio genero Playlist
	public void addGenrePay(int numList,int numSong){
		String genre =poolSongs[numSong].getGenero().toString();
		playLists[numList].updateGenre(genre);
	}
	// restringida
	public void addPlayList(String name,int duraccion,int[] userIndex){
		String genre = "";
		User[] user = new User[userIndex.length];
		for(int i =0;i< userIndex.length;i++){
			user[i]=users[userIndex[i]];
		}
		PlayList list = new Restringed(name,duraccion,genre,user);
			boolean run = false ;
			for(int i = 0 ; (i < playLists.length) && !run; i++){
				if(playLists[i] == null){
					playLists[i] = list;
					run = true ;
				}	
			}
	}
	//public
	public void addPlayList(String name,int duraccion){
		String genre = "";
		double calificacion = 0;
		PlayList list = new Public(name,duraccion,genre,calificacion);
		boolean run = false ;
			for(int i = 0 ; (i < playLists.length) && !run; i++){
				if(playLists[i] == null){
					playLists[i] = list;
					run = true;
				}
		
				
			}
	}
	// private
	public void addPlayList(String name,int duraccion,int name1){
		String genre = "";
		User user ;
		user = users[name1];
		PlayList list = new Private(name,duraccion,genre,user);
			boolean run = false ;
			for(int i = 0 ; (i < playLists.length) && !run; i++){
				if(playLists[i] == null){
					playLists[i] = list;
					run = true;
				}
		
				
			}
	}
	public String addSong(String titulo,String artista,String fechaLanzamiento ,int duraccion,String genero,int posicion){
		String text ="";		
				if(users[posicion]!= null){
				users[posicion].countainSong();
				Song list = new Song(titulo,artista,fechaLanzamiento,duraccion,genero,users[posicion]);
				boolean run = false;
				for(int i = 0; (i< poolSongs.length) && !run; i++ ){
					if(poolSongs[i] == null){
					poolSongs[i] = list;
					
					run = true;
					}
					
					}
					text= "Cancion creada con exito";
				}
				return text;
	}
	public boolean existenceUser(){
		boolean out = false;
		for(int i = 0; i< users.length; i++){
			if(users[i] != null){
				out = true;
			}
		}
		return out;
	}
	public boolean existenceSongs(){
		boolean out = false;
		for(int i= 0;i< poolSongs.length;i++){
			if(poolSongs[i] != null){
				out = true;
			}
		}
		return out;
	}
	public boolean positionValidSong(int posicion){
		boolean out = false;
		if(poolSongs[posicion] != null){
			out = true;
		}
		return out;
	}
	public boolean positionValidPlayList(int posicion){
		boolean out = false;
		if(playLists[posicion] != null){
			out = true;
		}
		return out;
	}
	public boolean positionValidUser(int posicion){
		boolean out = false;
		if(users[posicion] != null){
			out = true;
		}
		return out;
	}
	
}