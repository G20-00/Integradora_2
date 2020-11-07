package ui;
import model.*;
import java.util.Scanner;
public class Main{
	private Mcs mcs;
	private Scanner scan  = new Scanner(System.in);
	private	Scanner numScan = new Scanner(System.in);
	private int countainUsers ;
	public Main(){
	mcs = new Mcs();
	scan= new Scanner(System.in);
	numScan = new Scanner(System.in);
	countainUsers = 0;
	}
	
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
			case 1: addUsuario();
			break; 
				
			case 2:
					addPlayList();
			break ;
			case 3: crearCancion();
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
					 calificarPublic();
			break;
			case 9:
				run = false;
			break ;
			}
		}
	}
	public void addUsuario(){
		countainUsers++;
		if(countainUsers<11){
		System.out.println("Nombre");
		String name = scan.nextLine();
		System.out.println("Edad");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Clave");
		String clave = scan.nextLine();
		
		mcs.addUser(name,clave,age);
		}else {
			System.out.println("Supero el numero maximo de usuarios");
		}
	}
	public void crearCancion() {
		if(mcs.existenceUser()== true){
		System.out.println("Elige el usuario con el cual agregaras la cancion");
		System.out.println(mcs.nameUser());
		int posicion = numScan.nextInt();
		if(mcs.positionvalidUser(posicion) == true){
		System.out.println("Nombre de la cancion");
		String name = scan.nextLine();
		System.out.println("Artista");
		String artista = scan.nextLine();
		System.out.println("Fecha de lanzamiento Dia/mes/anio");
		String fechaLanzamiento = scan.nextLine();
		System.out.println("Duraccion de la cancion");
		int duraccion = numScan.nextInt();
		String genero = "";
		boolean run=true;
		while (run){
			System.out.println("Seleccione el genero\n"+"1- ROCK \n"+ "2- HIP_HOP\n"+"3- MUSICA_CLASICA\n"+"4- REGGAE\n"+ "5 SALSA\n");
			int eleccion = numScan.nextInt();
			
			
		switch(eleccion){
			case 1: 
					genero = "ROCK";
					run = false;
			break; 
				
			case 2:
					genero = "HIP_HOP";
					run = false;
			break ;
			case 3: 
					genero = "MUSICA_CLASICA";
					run = false;
			break; 
			case 4:
					genero = "REGGAE";
					run = false;
			break;
			case 5: 
					genero = "SALSA";
					run = false;
			break;
		
			
			}
			System.out.println(mcs.addSong(name,artista,fechaLanzamiento,duraccion,genero,posicion));
		
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
	public void addPlayList(){
		boolean run = true ;
		int duraccion = 0;
		while(run){
		System.out.println("Nombre de la lista de reproduccion");
		String nameList = scan.nextLine();
		System.out.println("Seleccione la prinvacidad :"+
		"\n 1. Publica"+"\n 2. Restringida"+"\n 3. Privada");
		int eleccion = numScan.nextInt();
		switch(eleccion){
			case 1:
				mcs.addPlayList(nameList,duraccion);
				run= false;
			break;
			case 2:
				
				System.out.println("Cuantos editores Tendra entre 1 y 5" );
				int users = numScan.nextInt();
				if(users>= 1 && users <= 5){
				int user[] = new int[users];
				System.out.println(mcs.nameUser());
				for(int i= 0;i< users;i++){
					
					System.out.println("Escoja el numero del editor :" );
					int name = numScan.nextInt();
					user[i]=name;
				
				}
				run= false;
				mcs.addPlayList(nameList,duraccion,user);
				}
				else {
					System.out.println("Error numero de usuarios invalido ");
				}
			break;
			case 3:
				System.out.println("Escoja el usuario");
				System.out.println(mcs.nameUser());
				int name = numScan.nextInt();
				run= false;
				mcs.addPlayList(nameList,duraccion,name);
			break;
			}
		}
		
	}
	public void calificarPublic(){
		if(mcs.validacionExistenciaPublic()== true){
				System.out.println("Listas de reproduccion que puede calificar");
				System.out.println("Elija una opcion");
				System.out.println(mcs.calificacion());
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
	public void showUser(){
		System.out.println(mcs.showUser());
	}
	public void showSongs(){
		System.out.println(mcs.showSongs());
	}
	public void showList(){
		System.out.println(mcs.showList());
	}
	public void addSongPlay(){
		int contador = 1;
		int attempts= 3;
		System.out.println("Escoja el numero de la Lista de Reproduccion");
		System.out.println(mcs.showLists());
		int numList= numScan.nextInt();
		if(mcs.verificadorPlayList(numList)==1){
			System.out.println("Escoja el numero de la cancion");
			System.out.println(mcs.showSong());
			int numSong = numScan.nextInt();
			mcs.addSongPlay(numList,numSong);
			mcs.addGenrePay(numList,numSong);
			
		}else if(mcs.verificadorPlayList(numList)== 2){
		boolean run = true;
		while(run){
		System.out.println("Escriba el usuario editor");
		String usuario= scan.nextLine();
		if(mcs.validar(numList,usuario)== true && contador != 3 ){
			System.out.println("Escoja el numero de la cancion");
			System.out.println(mcs.showSong());
			int numSong = numScan.nextInt();
			mcs.addSongPlay(numList,numSong);
			mcs.addGenrePay(numList,numSong);
			run = false ;
		}
		else{
			System.out.println("Error en el usuario");
			contador++;
			attempts= attempts-1;
			System.out.println("Le que dan "+attempts+" intentos");
			if(attempts == 0){
				System.out.println("¡ No eres el editor !");
				run = false;
				
			}
		}
		}
		}
		else if(mcs.verificadorPlayList(numList)== 3){
		boolean run = true;
		while(run){
		System.out.println("Escriba el usuario editor");
		String usuario= scan.nextLine();
		if(mcs.validar(numList,usuario)== true ){
			System.out.println("Escoja el numero de la cancion");
			System.out.println(mcs.showSong());
			int numSong = numScan.nextInt();
			mcs.addSongPlay(numList,numSong);
			mcs.addGenrePay(numList,numSong);
			run = false ;
		}
		else{
			System.out.println("Error en el usuario");
			contador++;
			attempts= attempts-1;
			System.out.println("Le que dan "+attempts+" intentos");
			if(attempts == 0){
				System.out.println("¡ No eres el editor !");
				run = false;
				
			}
		}
		}
		}
	}
	}

