package controller;

import java.util.Iterator;
import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;
import model.logic.Modelo;
import model.logic.Video;
import model.logic.Video.ComparadorXLikes;
import model.utils.Ordenamientos;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo<Video> modelo;

	/* Instancia de la Vista*/
	private View view;

	private Ordenamientos<Video> ordenamientos;
	
	//private ListaEncadenada<Video> lista; //NO VA ACA
	
	private ArregloDinamico<Video> mArreglo;  //NO VA ACA
	
	private ComparadorXLikes comparar;
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo<Video>();
		ordenamientos = new Ordenamientos<Video>();
		mArreglo = new ArregloDinamico<Video>(2000);
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		boolean esArreglo = false;
		boolean esLista = false;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){

			case 1:
				view.printMessage("Inicio de lectura de los archivos."); 
				modelo.leerDatosVideosArregloDinamico();
				view.printMessage("Lectura completa y Arreglo Dinamico creado."); 
				esArreglo = true;
				break;
				
			case 2:
				view.printMessage("Inicio de lectura de los archivos."); 
				modelo.leerDatosVideosListaEncadenada();
				view.printMessage("Lectura completa y Lista Encadenada creada.");
				esLista = true;
				break;
			
			case 3:
				view.printMessage("Inserte el tama�o deseado de la muestra."); 
				while(dato.equals(""))
				{
					dato = lector.nextLine();
				}
				if(esArreglo)
				{
					mArreglo = modelo.muestraArreglo(Integer.valueOf(dato));
					for(int i = 1; i < modelo.muestraArreglo(Integer.valueOf(dato)).size(); i++)
					{
						try
						{
						System.out.println("El titulo del video " + i + " es: " + ((Video) modelo.muestraArreglo(Integer.valueOf(dato)).getElement(i-1)).getTitle());
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				else 
				{
						for(int i = 1; i < modelo.muestraLista(Integer.valueOf(dato)).size(); i++)
						{
							try
							{
							System.out.println("El titulo del video " + i + " es: " + ((Video) modelo.muestraLista(Integer.valueOf(dato)).getElement(i)).getTitle());
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
				}
				
				view.printMessage("");
				break;
				
			case 4:
				if(esArreglo)
				{
					view.printMessage("Lista ordenada por insercion"); 
					Video.ComparadorXLikes compardorXLikes = new Video.ComparadorXLikes();
					ordenamientos.ordenarInsercion(mArreglo, compardorXLikes, true);
					view.printMessage("");
				}
				else 
				{
					view.printMessage("Lista ordenada por insercion"); 
					Video.ComparadorXLikes compardorXLikes = new Video.ComparadorXLikes();
					ordenamientos.ordenarInsercion(modelo.darLista(), compardorXLikes, true);
					view.printMessage("");
				}
				break;
			case 5:
				if(esArreglo)
				{
					view.printMessage("Lista ordenada por ShellSort"); 
					Video.ComparadorXLikes compardorXLikes = new Video.ComparadorXLikes();
					ordenamientos.ordenarShell(mArreglo, compardorXLikes, true);
					view.printMessage("");
				}
				else 
				{
					view.printMessage("Lista ordenada por Shellsort"); 
					Video.ComparadorXLikes compardorXLikes = new Video.ComparadorXLikes();
					ordenamientos.ordenarShell(modelo.darLista(), compardorXLikes, true);
					view.printMessage("");
				}
				break;
				
			case 6:
				if(esArreglo)
				{
					view.printMessage("Lista ordenada por MergeSort"); 
					Video.ComparadorXLikes compardorXLikes = new Video.ComparadorXLikes();
					ordenamientos.ordenarMerge(mArreglo, compardorXLikes, true);
					view.printMessage("");
				}
				else 
				{
					view.printMessage("Lista ordenada por MergeSort"); 
					Video.ComparadorXLikes compardorXLikes = new Video.ComparadorXLikes();
					ordenamientos.ordenarMerge(modelo.darLista(), compardorXLikes, true);
					view.printMessage("");
				}
				break;
			case 7:
				if(esArreglo)
				{
					view.printMessage("Lista ordenada por QuickSort"); 
					Video.ComparadorXLikes compardorXLikes = new Video.ComparadorXLikes();
					ordenamientos.ordenarQuickSort(mArreglo, compardorXLikes, true);
					view.printMessage("");
				}
				else 
				{
					view.printMessage("Lista ordenada por QuickSort"); 
					Video.ComparadorXLikes compardorXLikes = new Video.ComparadorXLikes();
					ordenamientos.ordenarQuickSort(modelo.darLista(), compardorXLikes, true);
					view.printMessage("");
				}
				break;

			case 8: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	
				
			
				
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
