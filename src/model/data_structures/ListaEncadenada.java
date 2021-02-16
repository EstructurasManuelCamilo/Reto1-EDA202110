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
	
	public ListaEncadenada()
	{
		tamanio = 0;
	}
	
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
	
	public void insertElement(T element, int pos) 
	{
		Nodo <T> nuevo = new Nodo<T>(element);
		Nodo <T> anterior = first;
		Nodo<T> actual = anterior.darSiguiente();
		int contador = 1;
		if (isEmpty()) 
		{
			first = nuevo;
			last = nuevo;
		}
		else if(pos > 0 && pos < tamanio +1)
		{
			while(contador < tamanio + 1 && pos != contador)
			{
				actual = actual.darSiguiente();
			}
			nuevo.cambiarSiguiente(actual);
			anterior.cambiarSiguiente(nuevo);	
		}
		tamanio ++;
	}

	/**
	 * Elimina el primer elemento. Se retorna el elemento eliminado.
	 * @return el elemento eliminado
	 */
	
	public T removeFirst() 
	{
		Nodo<T> viejo = first;
		if (isEmpty()) 
			return null;
		else
		{
			first = first.darSiguiente();
			tamanio --;
			return viejo.darElemento();
		}
	}

	/**
	 * Elimina el �ltimo elemento. Se retorna el elemento eliminado.
	 * @return el elemento eliminado
	 */
	
	public T removeLast() 
	{
		Nodo<T> viejo = last;
		Nodo<T> actual = first;
		if (isEmpty()) 
			return null;
		else
		{
			while(actual.darSiguiente() != last)
			{
				actual = actual.darSiguiente();
			}
			actual.cambiarSiguiente(null);
			last = actual;
			tamanio --;
			return viejo.darElemento();
		}
	}

	/**
	 * Elimina el elemento de una posici�n v�lida (mayor que -1). Se retorna el elemento eliminado.
	 * @param la posici�n del elemento a eliminar
	 * @return elemento eliminado
	 */
	
	public T deleteElement(int pos) 
	{
		if(pos > 0 || pos < tamanio +1 || !isEmpty())
			return null;
		else
		{
			Nodo<T> anterior = first;
			Nodo<T> actual = anterior.darSiguiente();
			int contador = 1;
			while(contador != pos)
			{
				anterior = actual;
				actual = actual.darSiguiente();
			}
			anterior.cambiarSiguiente(actual.darSiguiente());
			tamanio --;
			return actual.darElemento();
		}
	}

	/**
	 * Retorna el primer elemento
	 * @return el primer elemento
	 */
	
	public T firstElement() 
	{
		return first.darElemento();
	}

	/**
	 * Retorna el �ltimo elemento
	 * @return el �ltimo elemento
	 */
	@Override
	public T lastElement()
	{
		return last.darElemento();
	}

	/**
	 * Retorna el elemento en una posici�n v�lida. La posici�n del
	 * primer elemento es 1, la del segundo es 2 y as� sucesivamente
	 * @param la posici�n del elemento que se busca
	 * @return el elemento en la posici�n especificada
	 */
	
	public T getElement(int pos) 
	{
		if(pos < 0 || pos > tamanio +1 || isEmpty())
			return null;
		else
		{
			Nodo<T> actual = first;
			int contador = 1;
			while(contador < tamanio + 1 && contador != pos)
			{
				actual = actual.darSiguiente();
				contador ++;
			}
			return actual.darElemento();
		}
	}

	/**
	 * Retorna el n�mero de datos en el arreglo
	 * @return el tamanio del arreglo
	 */
	
	public int size() 
	{
		return tamanio;
	}

	
	/**
	 * Retorna true si el arreglo No tiene datos. false en caso contrario.
	 * @return si el arreglo tiene datos o no
	 */
	
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
	
	public int isPresent(T element)
	{
		return 0;
	}

	/**
	 * Intercambia la informaci�n de los elementos en dos posiciones v�lidas.
	 * @param la posici�n primera posici�n
	 * @param la posici�n segunta posici�n
	 */
	
	public void exchange(int pos1, int pos2) 
	{
		Nodo<T> elementoAnterior1 = first;
		Nodo<T> elementoAnterior2 = first;
		int posElement1 = 1;
		int posElement2 = 1;
		boolean enct1 = false;
		boolean enct2 = false;
		if (pos1 > 0 && pos2 > 0 && pos1 < tamanio +1 && pos2 < tamanio +1) 
		{
			while(!enct1 || !enct2)
			{
				if(pos1 != posElement1 -1 )
				{
					elementoAnterior1 = elementoAnterior1.darSiguiente();
					posElement1 ++;
				}
				else
					enct1 = true;
				if (pos2 != posElement2 -1) //obtengo el elemento anterior al de la posicion del parametro 
				{
					elementoAnterior2 = elementoAnterior2.darSiguiente();
					posElement2 ++;
				}
				else
					enct2 = true;
			}
			Nodo<T> copiaE1 = new Nodo<T>(elementoAnterior1.darSiguiente().darElemento());
			Nodo<T> copiaE2 = new Nodo<T>(elementoAnterior1.darSiguiente().darElemento());
			//eliminar elemento 1 y 2 de la lista
			copiaE1.cambiarSiguiente(elementoAnterior1.darSiguiente().darSiguiente());
			copiaE2.cambiarSiguiente(elementoAnterior2.darSiguiente().darSiguiente());
			elementoAnterior1.cambiarSiguiente(copiaE1);
			elementoAnterior2.cambiarSiguiente(copiaE2);
			// no funciona para el primero
		}
	}

	/**
	 * Cambia la informaci�n del elemento especificado por par�metro
	 * @param pos
	 * @param elem
	 */
	
	public void changeInfo(int pos, T elem) 
	{
		if(pos > 0  && pos < tamanio +1)
		{
			Nodo<T> actual = first;
			int contador = 1;
			while(pos != contador)
			{
				actual.darSiguiente();
				contador ++;
			}
			if(actual.darElemento() == elem)
				actual.cambiarElemento(elem);
		}
	}
	
}
