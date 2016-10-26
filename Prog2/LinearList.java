/*  Brian Chenoweth
    masc0329
*/

package data_structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinearList<E> implements LinearListADT<E> {

	private Node<E> head;
	private Node<E> tail;
	private int currentSize;
	private long modcount;

	private class Node<E> {
		E data;
		Node<E> next;
		Node<E> previous;

		public Node(E data) {
			this.data = data;
			previous = next = null;
		}
	}

	public LinearList() {
		head = tail = null;
		currentSize = 0;
	}

	public boolean addFirst(E obj) {
		Node<E> newNode = new Node<E>(obj);
		if (head == null)
			head = tail = newNode;
		else {
			head.previous=newNode;
			newNode.next = head;
			head = newNode;
		}
		currentSize++;
		return true;
	}

	public boolean addLast(E obj) {
		Node<E> newNode = new Node<E>(obj);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.next=newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		currentSize++;
		return true;
	}


	public E removeFirst() {
		if (head == null)
			return null;
		E temp = head.data;
		if(currentSize==1) head=tail=null;
		else{
			
			head=head.next;
			head.previous=null;
		}
		currentSize--;
		return temp;
	}


	public E removeLast() {
		if (tail == null)
			return null;
		E temp = tail.data;
		if(currentSize==1)
			head=tail=null;
		else{
			tail.previous.next=null;
			tail=tail.previous;
		}
		currentSize--;
		return temp;

	}


	public E remove(E obj) {
		Node<E> current = head;
		while (current != null && ((Comparable<E>) obj).compareTo(current.data) != 0) {
			current = current.next;
			if (current == null)
				return null;
		}
		if (current == head)
			return removeFirst();
		else if (current == tail)
			return removeLast();
		else {
			current.previous.next = current.next;
			current.next.previous = current.previous;
			currentSize--;
		}
		return current.data;
	}

	public E peekFirst() {
		if (head == null)
			return null;
		else {
			return head.data;
		}
	}

	public E peekLast() {
		if (tail == null)
			return null;
		else {
			return tail.data;
		}
	}

	public boolean contains(E obj) {
		Node<E> current = head;
		while (current != null && ((Comparable<E>) obj).compareTo(current.data) != 0)
			current = current.next;
		if (current == null)
			return false;
		return true;
	}

	public E find(E obj) {
		Node<E> current = head;
		while (current != null && ((Comparable<E>) obj).compareTo(current.data) != 0)
			current = current.next;
		if (current == null)
			return null;
		return current.data;
	}

	public void clear() {
		currentSize = 0;
		head = tail = null;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean isFull() {
		return false;
	}

	public int size() {
		return currentSize;
	}

	class IteratorHelper implements Iterator<E> {
		long modCheck;
		Node<E> IteratorP;

		public IteratorHelper() {
			modCheck = modcount;
			IteratorP = head;
		}

		public boolean hasNext() {
			if (IteratorP == null)
				return false;
			if (modCheck != modcount)
				throw new ConcurrentModificationException();
			return true;
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E temp = IteratorP.data;
			IteratorP = IteratorP.next;
			return temp;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

}
