package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico <T>
{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[])new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) {
		return (i < 0 || i > tamanoMax) ? null: elementos[i];
	}

	public T buscar(T dato) 
	{
		
		T resp = null;
		for (int j = 0; j < tamanoAct; j++) 
		{
			//Estudiante2
			//if( elementos[j].compareTo(dato) == 0) 
			//{
			//   resp = elementos[j];
			//}

			//Estudiante1
			if( elementos[j].equals(dato))
			{
				resp = elementos[j];
			}

			resp = elementos[j];
		}

		return resp;
	}

	//Estudiante1
//	public T eliminar(T dato) 
//	{
//	T[] copia = elementos;
//	for (int i = 0; i < tamanoAct; i++)
//	{
//		if(elementos[i].equals(dato))
//			elementos[i] = copia[i];
//	}
//	tamanoAct --;
//	return dato;
//}

	//Estudiante2
	public T eliminar(T dato) 
	{
		T elim = null;
		boolean termino = false;
		for ( int i = 0; i < tamanoAct && !termino; i++)
		{
			if(elementos[i].compareTo(dato)==0)
			{
				elim = elementos[i];
				for (int j = i; j < tamanoAct; j++) 
				{
					elementos[j] = elementos[j+1];
				}
				tamanoAct--;
				termino = true;
			}
		}
		return elim;
	}
	

	//Estudiante1
//	public void invertir() 
//	{
//		T[] nuevo = (T[]) new String[tamanoMax];
//		for (int i = 0; i < tamanoAct; i++)
//			nuevo[i] = elementos[tamanoAct -1 -i];
//
//		elementos = nuevo;
//	}

	//Estudiante2
	public void invertir()
	{
		T[] invertido = (T[])new Comparable [tamanoMax];

		for (int i=0, j = tamanoAct-1; i < tamanoAct; i++, j--)
		{
			invertido[j] = elementos[i];
		}

		elementos = invertido;
	}
}
