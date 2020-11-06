package ui;
import model.*;
import java.util.Scanner;
public class Main{
	private Mcs mcs;
	private Scanner scan  = new Scanner(System.in);
	private	Scanner numScan = new Scanner(System.in);
	public Main(){
	mcs = new Mcs();
	scan= new Scanner(System.in);
	numScan = new Scanner(System.in);
	
	}
	
	public static void main (String[] args){
		Main m=new Main();
		m.menu();
	}			
	

	public void menu(){
		boolean run = true;
		while (run){
			System.out.println("1. Crear un nuevo usuario 						\n"+"2. Crear una lista de reproduccion\n"+
							"3. Crear una cancion		 						\n" + "4. Anadir Cancion a una lista de reproduccion\n"+
							"5. Imprimir usuarios \n"+
							"6. Imprimir canciones compartidas \n"+ "7. Imprimir Listas de Reproduccion \n"+
							"8. Salir\n");
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
					run = false; 
			break;
			}
		}
	}
	public void addUsuario(){
		System.out.println("Nombre");
		String name = scan.nextLine();
		System.out.println("Edad");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Clave");
		String clave = scan.nextLine();
		
		mcs.addUser(name,clave,age);
	}
	public void crearCancion() {
		System.out.println("Elige el usuario con el cual agregaras la cancion");
		System.out.println(mcs.nameUser());
		int posicion = numScan.nextInt();
		System.out.println("Nombre de la cancion");
		String name = scan.nextLine();
		System.out.println("Artista");
		String artista = scan.nextLine();
		System.out.println("Fecha de lanzamiento");
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
			mcs.addSong(name,artista,fechaLanzamiento,duraccion,genero,posicion);
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
				run= false;
			break;
			case 2:
				System.out.println("Nombre de editor 1:" );
				String name1 = scan.nextLine();
				System.out.println("Nombre de editor 2:" );
				String name2 = scan.nextLine();
				System.out.println("Nombre de editor 3:" );
				String name3 = scan.nextLine();
				System.out.println("Nombre de editor 4:" );
				String name4 = scan.nextLine();
				System.out.println("Nombre de editor 5:" );
				String name5 = scan.nextLine();
				run= false;
				mcs.addPlaylist(nameList,duraccion,name1,name2,name3,name4,name5);
			break;
			case 3:
				System.out.println("Nombre de usuario editor");
				String name = scan.nextLine();
				run= false;
				mcs.addPlaylist(nameList,duraccion,name);
			break;
			}
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
		System.out.println("Escoja el numero de la Lista de Reproduccion");
		System.out.println(mcs.showLists());
		int numList= numScan.nextInt();
		boolean run = true;
		while(run){
		System.out.println("Escriba el usuario editor");
		String usuario= scan.nextLine();
		if(mcs.validar(numList,usuario)== true){
			System.out.println("Escoja el numero de la cancion");
			System.out.println(mcs.showSong());
			int numSong = numScan.nextInt();
			mcs.addSongPlay(numList,numSong);
			mcs.addGenrePay(numList,numSong);
			run = false ;
		}
		else{
			System.out.println("Error en el usuario");
		}
		}
		
	}
	}

