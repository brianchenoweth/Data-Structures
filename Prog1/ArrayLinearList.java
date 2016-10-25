//Brian Chenoweth

package data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayLinearList<E> implements LinearListADT<E> {

private int front, rear;
private int currentSize,maxSize;
private E[] storage;

public ArrayLinearList(int size) {
	maxSize = size;
	currentSize = front = rear = 0;
	storage = (E[])new Object[maxSize];
	}

public ArrayLinearList() {
	this (DEFAULT_MAX_CAPACITY); 
	currentSize = front = rear = 0;
	storage = (E[])new Object[maxSize];}

public boolean addFirst(E obj) {
	if (currentSize == maxSize) 
		return false;
	else if (currentSize == 0) 
	{
		storage[front] = obj;
		currentSize++;
		//rear=front;
		//currentSize++;
	}
	
	else 
	{ 
		front--;
		if (front ==-1) front = maxSize-1;
		storage[front] = obj;
		currentSize++;
	}
	return true;
	}

public boolean addLast(E obj)
{
	if (currentSize==maxSize) 
		return false;
	rear++;
	if (rear==maxSize) 
	{
		rear=0;
		storage[rear]=obj;
		return true;
	}
	else{ 
		if (currentSize==0)
		front=rear;
		storage[rear]=obj;
		currentSize++;
		return true;
	}
}

public E removeFirst() {
	if (currentSize==0) 
		return null;
	E Removef = storage[front];
	if(currentSize==1)front=rear=0;
	else if(front == maxSize-1) front=0;
	else front++;
	currentSize--;
	return Removef;

		
}

public E removeLast() {
	if (currentSize==0)
		return null;
	E Removel = storage[rear];
		rear--;
		currentSize--;
	if (rear < 0)
		rear = maxSize - 1;
		return Removel;
}

private int findObj(E obj) {
	int index=front;
	int count = 0;
	for (int j=0; j < currentSize; j++){
		if (((Comparable<E>) obj).compareTo((E) storage[index])==0) 
			return index ;
		if (index==maxSize - 1)
			index = 0;
		else 
			index++;
		}
		return -1;
}

public E remove(E obj) {
	int index = findObj(obj);
	if (index==-1) 
		return null;
	E temp = storage[index];
		while (index != rear) {
			if (index==maxSize - 1) {
				storage[index]=storage[0];
				index=0;
				}
			else 
				storage[index]=storage[++index];
			}
		rear--;
		if (rear== - 1) {
			rear=maxSize -1;
		}
		currentSize--;
		return temp;
		}
		
public E peekFirst() {
	if (currentSize==0)
		return null; 
	return storage[front];
}

public E peekLast() {
	if (currentSize==0)
		return null;
		return storage[rear];
	}

public boolean contains(E obj) {
	int index=front;
	int count=0;
	while (count != currentSize) {
		if (((Comparable<E>) obj).compareTo(storage[index])==0)
			return true;
		index++;
		if (index==maxSize)index=0;
		
		count++;
	}
			return false;
	}

public E find(E obj) {
		int index=front;
		int count=0;
		while (count != currentSize) {
			if (((Comparable<E>) obj).compareTo(storage[index])==0)
			return storage[index];
				index++;
			if (index==maxSize) index=0;
			count++;
		}
		return null;
}
	
public void clear() {
	currentSize = rear = front = 0;
		}

public boolean isEmpty() {
		return currentSize==0;
	}

public boolean isFull() {
		return currentSize==maxSize;
	}

public int size() {
		return currentSize;

	}

public Iterator<E> iterator() {
		return new IteratorHelper();
}

private class IteratorHelper implements Iterator<E> {
	private int itIndex, count;
	public IteratorHelper() {
			itIndex=front;
			count = 1;
		}
	
public boolean hasNext() {
			return count<=currentSize;
		}
		
public void remove() {
	throw new UnsupportedOperationException ();
}

public E next() {
	E temp = storage[itIndex];
	if (!hasNext ()) 
		throw new NoSuchElementException();
	else{
		itIndex++;
		if (itIndex==storage.length) itIndex=0;
		count++;
	}
	
	return temp;
		}
}

}
