package model.data_structures;

public class ListaEncadenada <T extends Comparable<T>> implements ILista<T>
{
	private Nodo <T> first;
	public int tamanio;
	private Nodo <T> last;
	
	/**
	 * Agrega un elemento al inicio de la lista
	 * @param element que se va a agregar
	 */
	@Override
	public void addFirst(T element)
	{
		Nodo <T> nuevo = new Nodo <T> (element);
		if(isEmpty())
		{
			first = nuevo;
			last = nuevo;
		}
		else
		{
			nuevo.cambiarSiguiente(first);
			first = nuevo;
		}
		tamanio ++;
	}

	/**
	 * Agraga un elemento al final de la lista
	 * @param element
	 */
	@Override
	public void addLast(T element)
	{
		Nodo<T> nuevo = new Nodo<T>(element);
		
		if (isEmpty()) 
		{
			first = nuevo;
			last = nuevo;
		}
		else
		{
			last.cambiarSiguiente(nuevo);
			last = nuevo;
		}
		tamanio ++;
		
	}

	/**
	 * Agrega un elemento en la posici�n pos si la posici�n es una posici�n v�lida. 
	 * Los elementos que est�n a partir de la 
	 * posici�n dada deben correrse una posici�n a la derecha.
	 * Las posiciones v�lidas son posiciones donde ya hay un
	 * elemento en la lista. La posici�n del primer elemento es 1, 
	 * la del segundo es 2 y as� sucesivamente
	 * @param element
	 * @param pos
	 */
	@Override
	public void insertElement(T element, int pos) 
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Elimina el primer elemento. Se retorna el elemento eliminado.
	 * @return el elemento eliminado
	 */
	@Override
	public T removeFirst() 
	{
		return null;
	}

	/**
	 * Elimina el �ltimo elemento. Se retorna el elemento eliminado.
	 * @return el elemento eliminado
	 */
	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Elimina el elemento de una posici�n v�lida (mayor que -1). Se retorna el elemento eliminado.
	 * @param la posici�n del elemento a eliminar
	 * @return elemento eliminado
	 */
	@Override
	public T deleteElement(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retorna el primer elemento
	 * @return el primer elemento
	 */
	@Override
	public T firstElement() 
	{
		return primero;
	}

	/**
	 * Retorna el �ltimo elemento
	 * @return el �ltimo elemento
	 */
	@Override
	public T lastElement()
	{
		return ultimo;
	}

	/**
	 * Retorna el elemento en una posici�n v�lida. La posici�n del
	 * primer elemento es 1, la del segundo es 2 y as� sucesivamente
	 * @param la posici�n del elemento que se busca
	 * @return el elemento en la posici�n especificada
	 */
	@Override
	public T getElement(int pos) 
	{
		return null;
	}

	/**
	 * Retorna el n�mero de datos en el arreglo
	 * @return el tamanio del arreglo
	 */
	@Override
	public int size() 
	{
		return tamanio;
	}

	
	/**
	 * Retorna true si el arreglo No tiene datos. false en caso contrario.
	 * @return si el arreglo tiene datos o no
	 */
	@Override
	public boolean isEmpty() 
	{
		return tamanio == 0? true: false;
	}

	/**
	 * Retorna la posici�n v�lida de un elemento. Si no se 
	 * encuentra el elemento, el valor retornado es -1
	 * @param element para consultar
	 * @return la posicion del elemento
	 */
	@Override
	public int isPresent(T element)
	{
		return 0;
	}

	/**
	 * Intercambia la informaci�n de los elementos en dos posiciones v�lidas.
	 * @param la posici�n primera posici�n
	 * @param la posici�n segunta posici�n
	 */
	@Override
	public void exchange(int pos1, int pos2) 
	{
		
	}

	/**
	 * Cambia la informaci�n del elemento especificado por par�metro
	 * @param pos
	 * @param elem
	 */
	@Override
	public void changeInfo(int pos, T elem) 
	{
		
	}
	
}
