/*  Brian Chenoweth
    masc0329
*/

package data_structures;
import java.util.Iterator;

public class Stack<E> implements Iterable<E> {
private LinearListADT<E> storage;
		
public Stack() {
	storage = new LinearList<E>();
		}

// inserts the object obj into the stack
	public void push(E obj) {
		storage.addFirst(obj);
		    	}
		    
// pops and returns the element on the top of the stack    
	public E pop() {
		return storage.removeFirst();
		    }
		    
// returns the number of elements currently in the stack
	public int size() {
		return storage.size();
		    }
		    
// return true if the stack is empty, otherwise false
	public boolean isEmpty() {
		return storage.isEmpty();
		    }
		    
// returns but does not remove the element on the top of the stack    
	 public E peek() {
		return storage.peekFirst();
		    }
		     
// returns true if the object obj is in the stack,
// otherwise false   
	public boolean contains(E obj) {
		return storage.contains(obj);
		    }
		    
// returns the stack to an empty state    
	public void makeEmpty() {
		storage.clear();
		    }
		    
// removes the Object obj if it is in the stack and
// returns true, otherwise returns false.
	public boolean remove(E obj)  {
		return (storage.remove(obj)!=null);
		    }
		    
// returns a iterator of the elements in the stack.  The elements
// must be in the same sequence as pop() would return them.    
	public Iterator<E> iterator(){
		return storage.iterator();
		    }
	}
	
