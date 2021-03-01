package model.logic;

import model.data_structures.*;
import com.opencsv.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo <T extends Comparable<T>>
{
	/**
	 * Atributos del modelo del mundo
	 */

	long TInicio, TFin, tiempo;

	private ArregloDinamico<T> datosArreglo;

	private ListaEncadenada<T> datosLista;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datosArreglo = new ArregloDinamico<>(501);
		datosLista = new ListaEncadenada<>();
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datosArreglo = new ArregloDinamico(capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoArreglo()
	{
		return datosArreglo.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(T element)
	{	
		datosArreglo.addLast(element);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public T buscar(T dato)
	{
		if(datosArreglo.isPresent(dato)!= -1)
			return datosArreglo.getElement(dato);
		else
			return null;
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public T eliminar(T dato)
	{
		return datosArreglo.deleteElement(dato);
	}

	public void invertir()
	{
		datosArreglo.invertir();
	}

	@Override 
	public String toString()
	{
		if (darTamanoArreglo() == 0)
			return "[]";
		else{
			String resp = "[";
			for (int i = 0; i < darTamanoArreglo() - 1; i++) 
			{
				resp += datosArreglo.getElement(i) + ",";
			}
			resp += datosArreglo.getElement(darTamanoArreglo() - 1) +"]";
			return resp;
		}
	}

	public void leerDatosVideosArregloDinamico()
	{
		FileReader pDatos = null;
		CSVReader reader = null;
		TInicio = System.currentTimeMillis();

		try 
		{

			pDatos = new FileReader("data/videos-small.csv");
			CSVParser separador = new CSVParserBuilder().withSeparator(',').build();
			reader = new CSVReaderBuilder(pDatos).withCSVParser(separador).build();
			String[] fila = reader.readNext();

			ArregloDinamico<String> columnas = new ArregloDinamico<String>(17);
			for(int i = 0; i < 16; i++)
			{
				columnas.insertElement(fila[i], i);
			}

			String[] primera = reader.readNext();

			Video prim = new Video(primera[0], fecha1(primera[1]) , primera[2], primera[3], Integer.valueOf(primera[4]), fecha2(primera[5]), primera[5]);
			datosArreglo.insertElement((T) prim, 0);
			System.out.println("La informaci�n del primer video es: " );
			System.out.println("Id video: " + prim.getId());
			System.out.println("Trending_Date: " + prim.getTrendingDate() );
			System.out.println("T�tulo: " + prim.getTitle());
			System.out.println("T�tulo del canal: " + prim.getChannel());
			System.out.println("Id de categor�a: " + prim.getCategoryId());
			System.out.println("Fecha de publicaci�n: " + prim.getPublishTime());

			Video ultimo = prim;
			int j = 1;

			try 
			{

				while((fila = reader.readNext()) != null)
				{

					Video nuevo = new Video(fila[0], fecha1(fila[1]), fila[2], fila[3], Integer.valueOf(fila[4]), fecha2(fila[5]),primera[5]);
					datosArreglo.insertElement((T) nuevo, j);
					j++;

					ultimo = nuevo;
				}
			}
			catch(Exception e) 
			{

			}
			System.out.println("La informaci�n del �ltimo video es: " );
			System.out.println("Id video: " + ultimo.getId());
			System.out.println("Trending_Date: " + ultimo.getTrendingDate());
			System.out.println("T�tulo: " + ultimo.getTitle());
			System.out.println("T�tulo del canal: " + ultimo.getChannel());
			System.out.println("Id de categor�a: " + ultimo.getCategoryId());
			System.out.println("Fecha de publicaci�n: " + ultimo.getPublishTime());

			System.out.println("El total de video encontrados fue de: " + j);

			TFin = System.currentTimeMillis();
			tiempo = TFin - TInicio;
			System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo);

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}


	public void leerDatosVideosListaEncadenada()
	{
		FileReader pDatos = null;
		CSVReader reader = null;
		TInicio = System.currentTimeMillis();

		try 
		{

			pDatos = new FileReader("data/videos-small.csv");
			CSVParser separador = new CSVParserBuilder().withSeparator(',').build();
			reader = new CSVReaderBuilder(pDatos).withCSVParser(separador).build();
			String[] fila = reader.readNext();

			ListaEncadenada<String> columnas = new ListaEncadenada<>();
			for(int i = 0; i < 16; i++)
			{
				columnas.insertElement(fila[i], i);
			}

			String[] primera = reader.readNext();

			Video prim = new Video(primera[0], fecha1(primera[1]) , primera[2], primera[3], Integer.valueOf(primera[4]), fecha2(primera[5]), primera[5]);
			datosLista.insertElement((T) prim, 0);
			System.out.println("La informaci�n del primer video es: " );
			System.out.println("Id video: " + prim.getId());
			System.out.println("Trending_Date: " + prim.getTrendingDate() );
			System.out.println("T�tulo: " + prim.getTitle());
			System.out.println("T�tulo del canal: " + prim.getChannel());
			System.out.println("Id de categor�a: " + prim.getCategoryId());
			System.out.println("Fecha de publicaci�n: " + prim.getPublishTime());

			Video ultimo = prim;
			int j = 1;

			try 
			{

				while((fila = reader.readNext()) != null)
				{

					Video nuevo = new Video(fila[0], fecha1(fila[1]), fila[2], fila[3], Integer.valueOf(fila[4]), fecha2(fila[5]),primera[5]);
					datosLista.insertElement((T) nuevo, j);
					j++;

					ultimo = nuevo;
				}
			}
			catch(Exception e) 
			{

			}
			System.out.println("La informaci�n del �ltimo video es: " );
			System.out.println("Id video: " + ultimo.getId());
			System.out.println("Trending_Date: " + ultimo.getTrendingDate());
			System.out.println("T�tulo: " + ultimo.getTitle());
			System.out.println("T�tulo del canal: " + ultimo.getChannel());
			System.out.println("Id de categor�a: " + ultimo.getCategoryId());
			System.out.println("Fecha de publicaci�n: " + ultimo.getPublishTime());

			System.out.println("El total de videos encontrados fue de: " + j);

			TFin = System.currentTimeMillis();
			tiempo = TFin - TInicio;
			System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo);

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}


	public Date fecha1(String pFecha) throws ParseException
	{
		String[] partes = pFecha.split("\\.");
		String anio  = partes[0];
		String dia  = partes[1];
		String mes = partes[2];

		String fecha = dia + "/" + mes + "/" + anio;
		Date date =new SimpleDateFormat("dd/MM/yyyy").parse(fecha);  

		return date;
	}
	public LocalDateTime fecha2(String pFecha) throws ParseException
	{
		String[] partes = pFecha.split("\\.");
		String fechaHora  = partes[0];
		LocalDateTime fecha = LocalDateTime.parse(fechaHora);
		return fecha;
	}

	//RETORNA LA 794
	//ERROR EN 998
}
