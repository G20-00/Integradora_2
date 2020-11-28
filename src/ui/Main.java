package ui;
import model.*;
import java.util.Scanner;
public class Main{
	
	private Scanner scan  = new Scanner(System.in);
	private	Scanner numScan = new Scanner(System.in);
	private int countainUsers ;
	//Relationships
	private Mcs mcs;
	
	/**
	 * Constructor
	 *initialize variables
	 */
	public Main(){
	mcs = new Mcs();
	scan= new Scanner(System.in);
	numScan = new Scanner(System.in);
	countainUsers = 0;
	}
	/**
	*main: inicialize initialize variables
	*<b> pre: </b>
	*<b> pos: </b>
	*@param args []String
	*/	
	public static void main (String[] args){
		Main m=new Main();
		m.menu();
	}			
	

	public void menu(){
		boolean run = true;
		System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((\n"+
							"((((((((((((((((/((((((((((((((((((((((((((((((((\n"+
							"(((/  .(((((((*  .((((((*        (((((/      /(((\n"+
							"(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"+
							"(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"+
							"(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"+
							"(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"+
							"(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"+
							"(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"+
							"(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"+
							"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"+
							"(((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"+
							"(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"+
							"(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"+
							"(((/  .((((((((.  *((((((.        *((   .   .((((\n"+
							"(((((((((((((((/((((((((((//(((((((/(((((((((((((\n"+
							"(((((((((((((((((((((((((((((((((((((((((((((((((\n"+

							"*************************************************\n");
		while (run){
			System.out.println("**************************************************\n"+"1. Crear un nuevo usuario\n"+"2. Crear una lista de reproduccion\n"+
							"3. Crear una cancion\n" + "4. Anadir Cancion a una lista de reproduccion\n"+
							"5. Imprimir usuarios \n"+
							"6. Imprimir canciones compartidas \n"+ "7. Imprimir Listas de Reproduccion \n"+"8. Calificar listas de reproduccion publicas\n"+
							"9. Salir\n"+"**************************************************\n");
			int eleccion = numScan.nextInt();
			
			
		switch(eleccion){
			case 1: addUser();
			break; 
				
			case 2:
					addPlayList();
			break ;
			case 3: createSong();
			break; 
			case 4:
					addSongPlay();
			break;
			case 5: 
					showUser();
			break;
			case 6:
					showSongs();	
			break;
			case 7:
					showList();
			break ;
			case 8:
					 ratePublic();
			break;
			case 9:
				run = false;
			break ;
			}
		}
	}
	/**
	*addUser: create users
	*<b> pre: </b>
	*<b> pos: </b>
	*/	
	public void addUser(){
		countainUsers++;
		if(countainUsers<11){
		System.out.println("Nombre");
		String name = scan.nextLine();
		System.out.println("Edad");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Clave");
		String key = scan.nextLine();
		
		mcs.addUser(name,key,age);
		}else {
			System.out.println("Supero el numero maximo de usuarios");
		}
	}
	/**
	*createSong: create song 
	*<b> pre: </b>
	*<b> pos: </b>
	*/	
	public void createSong() {
		if(mcs.existenceUser()== true){
		System.out.println("Elige el usuario con el cual agregaras la cancion");
		System.out.println(mcs.nameUser());
		int position = numScan.nextInt();
		if(mcs.positionValidUser(position) == true){
		System.out.println("Nombre de la cancion");
		String name = scan.nextLine();
		System.out.println("Artista");
		String artist = scan.nextLine();
		System.out.println("Fecha de lanzamiento Dia/mes/anio");
		String releaseDate = scan.nextLine();
		System.out.println("Duraccion de la cancion");
		int duration = numScan.nextInt();
		String gener = "";
		boolean run=true;
		while (run){
			System.out.println("Seleccione el genero\n"+"1- ROCK \n"+ "2- HIP_HOP\n"+"3- MUSICA_CLASICA\n"+"4- REGGAE\n"+ "5 SALSA\n");
			int eleccion = numScan.nextInt();
			
			
		switch(eleccion){
			case 1: 
					gener = "ROCK";
					run = false;
			break; 
				
			case 2:
					gener = "HIP_HOP";
					run = false;
			break ;
			case 3: 
					gener = "MUSICA_CLASICA";
					run = false;
			break; 
			case 4:
					gener = "REGGAE";
					run = false;
			break;
			case 5: 
					gener = "SALSA";
					run = false;
			break;
		
			
			}
			System.out.println(mcs.addSong(name,artist,releaseDate,duration,gener,position));
		
			}
		}
		else{
			System.out.println("Debe elegir un usuario valido");
		}
		}
		else{
			System.out.println("Debe crear un Usuario");
		}	
	}
	/**
	*addPlayList: create the playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*/	
	public void addPlayList(){
		if(mcs.existenceUser()== true){
		boolean run = true ;
		int duration = 0;
		while(run){
		System.out.println("Nombre de la lista de reproduccion");
		String nameList = scan.nextLine();
		System.out.println("Seleccione la prinvacidad :"+
		"\n 1. Publica"+"\n 2. Restringida"+"\n 3. Privada");
		int eleccion = numScan.nextInt();
		switch(eleccion){
			case 1:
				mcs.addPlayList(nameList,duration);
				run= false;
			break;
			case 2:
				
				System.out.println("Cuantos editores Tendra entre 1 y 5" );
				int users = numScan.nextInt();
				if(users>= 1 && users <= 5){
				int user[] = new int[users];
				System.out.println(mcs.nameUser());
				int countain = 0;
				for(int i= 0;i< users;i++){
					
					System.out.println("Escoja el numero del editor :" );
					int name = numScan.nextInt();
					if(mcs.positionValidUser(name)== true){
						user[i]=name;
						countain = 1;
					}else{
						System.out.println("Usuario no valido");
					}
				}
				if(countain == 1){
				mcs.addPlayList(nameList,duration,user);
				System.out.println("Se creo con exito");
				}else{
					System.out.println(" ¡ERROR! usuarios invalidos"+"\nNo se creo lista de reproduccion");
				}
				run= false;
				}
				else {
					System.out.println("Error numero de usuarios invalido ");
				}
			break;
			case 3:
				System.out.println("Escoja el usuario");
				System.out.println(mcs.nameUser());
				int name = numScan.nextInt();
				if(mcs.positionValidUser(name)== true){
					run= false;
					mcs.addPlayList(nameList,duration,name);
					System.out.println("Se creo con exito");
				}else{
					System.out.println("¡ERROR! Usuario invalido"+"\n No se creo lista de reproduccion");
				}
			break;
			}
		}
		}else{
			System.out.println("Debe crear un usuario");
		}
		
	}
	/**
	*ratePublic: rate public playlists
	*<b> pre: </b>
	*<b> pos: </b>
	*/	
	public void ratePublic(){
		if(mcs.publicExistenceValidation()== true){
				System.out.println("Listas de reproduccion que puede calificar");
				System.out.println("Elija una opcion");
				System.out.println(mcs.qualification());
				int choice = numScan.nextInt();
				boolean run = true;
				while(run){
				
				System.out.println("LA CALIFICACION DEBE ESTAR EN 1 Y 5");
				System.out.println("¿Que calificacion le daras?");
				int qualification = numScan.nextInt();
				if(qualification>= 1 && qualification<= 5){
					System.out.println(mcs.changeRating(choice,qualification));
					run = false;
				}
			}
		}
	else{
		System.out.println("No hay listas de reproduccion publicas");
	}
	}
	/**
	*showUser: print the users
	*<b> pre: </b>
	*<b> pos: </b>
	*/
	public void showUser(){
		System.out.println(mcs.showUser());
	}
	/**
	*showSong: print the song
	*<b> pre: </b>
	*<b> pos: </b>
	*/
	public void showSongs(){
		System.out.println(mcs.showSongs());
	}
	/**
	*showList: print the list song
	*<b> pre: </b>
	*<b> pos: </b>
	*/
	public void showList(){
		System.out.println(mcs.showList());
	}
	/**
	*addSongPlay: add song to playlist
	*<b> pre: </b>
	*<b> pos: </b>
	*/
	public void addSongPlay(){
		if(mcs.existenceUser()== true && mcs.existenceSongs()== true){
		int contador = 1;
		int attempts= 3;
		System.out.println("Escoja el numero de la Lista de Reproduccion");
		System.out.println(mcs.showLists());
		int numList= numScan.nextInt();
		if(mcs.positionValidPlayList(numList) == true){
		if(mcs.playListChecker(numList)==1){ // public
			System.out.println("Escoja el numero de la cancion");
			System.out.println(mcs.showSong());
			int numSong = numScan.nextInt();
			if(mcs.positionValidSong(numSong) == true){
			mcs.addSongPlay(numList,numSong);
			mcs.addGenrePlaylist(numList,numSong);
			}else{
				System.out.println("La cancion no existe");
				
			}
		}
		else if(mcs.playListChecker(numList)== 2){// private
		boolean run = true;
		while(run){
		System.out.println("Escriba el usuario editor");
		String user= scan.nextLine();
		if(mcs.validate(numList,user)== true && contador != 3 ){
			System.out.println("Escoja el numero de la cancion");
			System.out.println(mcs.showSong());
			int numSong = numScan.nextInt();
			if(mcs.positionValidSong(numSong)==true){
			mcs.addSongPlay(numList,numSong);
			mcs.addGenrePlaylist(numList,numSong);
			run = false ;
			}else{
				System.out.println("La cancion no existe");
				run = false ;
			}
		}
		else{
			System.out.println("Error en el usuario");
			contador++;
			attempts= attempts-1;
			System.out.println("Le quedan "+attempts+" intentos");
			if(attempts == 0){
				System.out.println("¡ No eres el editor !");
				run = false;
				
			}
		}
		}
		}
		else if(mcs.playListChecker(numList)== 3){// restringed 
		boolean run = true;
		while(run){
		System.out.println("Escriba el usuario editor");
		String user= scan.nextLine();
		if(mcs.validate(numList,user)== true ){
			System.out.println("Escoja el numero de la cancion");
			System.out.println(mcs.showSong());
			int numSong = numScan.nextInt();
			if(mcs.positionValidSong(numSong)==true){
			mcs.addSongPlay(numList,numSong);
			mcs.addGenrePlaylist(numList,numSong);
			run = false ;
			}
			else{
				System.out.println("La cancion no existe");
				run = false ;
			}
		}
		else{
			System.out.println("Error en el usuario");
			contador++;
			attempts= attempts-1;
			System.out.println("Le quedan "+attempts+" intentos");
			if(attempts == 0){
				System.out.println("¡ No eres el editor !");
				run = false;
				
			}
		}
		}
		}
		}else {
			System.out.println("Lista de reproduccion no existe");
		}
	}	else{
		System.out.println("Debe crear un Lista de reproduccion y una cancion");
		}
	
	}
	}

