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
	//verificacion tipo de lista de Reproduccion
	public int verificadorPlayList(int posicion){
		int num = 0;
		for(int i = 0;i< playLists.length; i++){
			if(playLists[posicion] != null){
				//if(playLists[i] instanceof Public ){
				//	num = 1;
				//}
				if(playLists[posicion] instanceof Private){
					num = 2;
				}
				else if(playLists[posicion] instanceof Restringed){
					num = 3;
				}
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
				text += (i +users[i].showUser());
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
				text += (i+ " -" +playLists[i].getName());
			}
		}
		return text;
	}
	
	public boolean validar(int numList , String usuario){
		boolean out = false;
		Private nueva =(Private)playLists[numList];
		if(nueva.getName1().equals(usuario)){
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
	public void addPlaylist(String name,int duraccion,String name1,String name2, String name3,String name4,String name5){
		String genre = "";
		PlayList list = new Restringed(name,duraccion,genre,name1,name2,name3,name4,name5);
			boolean run = false ;
			for(int i = 0 ; (i < playLists.length) && !run; i++){
				if(playLists[i] == null){
					playLists[i] = list;
					run = true ;
				}
			else{
				System.out.println("No puede registrar mas listas de reproduccion");
			}
				
			}
	}
	// private
	public void addPlaylist(String name,int duraccion,String name1){
		String genre = "";
		PlayList list = new Private(name,duraccion,genre,name1);
			boolean run = false ;
			for(int i = 0 ; (i < playLists.length) && !run; i++){
				if(playLists[i] == null){
					playLists[i] = list;
					run = true;
				}
			else{
				System.out.println("No puede registrar listas de reproduccion");
			}
				
			}
	}
	public void addSong(String titulo,String artista,String fechaLanzamiento ,int duraccion,String genero,int posicion){
				
				Song list = new Song(titulo,artista,fechaLanzamiento,duraccion,genero,users[posicion]);
				boolean run = false;
				for(int i = 0; (i< poolSongs.length) && !run; i++ ){
					if(poolSongs[i] == null){
					poolSongs[i] = list;
					run = true;
					}
					
					}
			
				
	}
	
}