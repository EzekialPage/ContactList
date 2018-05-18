/**
 * LinkedList represents a linked implementation of a list.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/13/08
 */


import java.util.*;

public class LinkedList<T> implements ListADT<T>, Iterable<T>
{
   protected int count;
   protected LinearNode<T> head, tail;

   /**
    * Creates an empty list.
    */
   public LinkedList()
   {
      count = 0;
      head = tail = null;
   }
	
	
	public void addHead(T element){
		LinearNode<T> node = new LinearNode<T>(element);
		if(isEmpty()){
			tail = node;
		}else{
			node.setNext(head);
			head.setPrev(node);
		}
		head = node;
		count++;
	}
	
	public void addTail(T element){
		LinearNode<T> node = new LinearNode<T>(element);
		if(isEmpty()){
			head = node;
		}else{
			tail.setNext(node);
			node.setPrev(tail);
		}
		
		tail = node;
		count++;
	}
	
	public void addAfter(T target, T element){
		if(isEmpty())throw new EmptyCollectionException("list");
		if(!contains(target)) throw new ElementNotFoundException("list");
		
		LinearNode insertNode = new LinearNode(element);
		LinearNode current = head;
		while(!target.equals(current.getElement())){
			current = current.getNext();
		}
		
		if(current == tail){
			insertNode.setPrev(tail);
			tail.setNext(insertNode);
			tail = tail.getNext();
		}else{
			insertNode.setPrev(current);
			insertNode.setNext(current.getNext());
			current.getNext().setPrev(insertNode);
			current.setNext(insertNode);
		}
	}
	
	private void addBefore(LinearNode current, T elem){
		LinearNode ins = new LinearNode(elem);
		
		current.getPrev().setNext(ins);
		ins.setPrev(current.getPrev());
		current.setPrev(ins);
		ins.setNext(current);
		
		count++;
	}
	
	public void addAlpha(T elem){
		if(isEmpty()){
			addHead(elem);
		}else{
			LinearNode current = head;
			boolean insertLocationFound = false;
			while((current != null) && (!insertLocationFound)){
				if(((Comparable)current.getElement()).compareTo(elem) > 0){
					insertLocationFound = true;
				}else{
					current = current.getNext();
				}
			}
			if(current == null){
				addTail(elem);
			}else if(current == head){
				addHead(elem);
			}else{
				addBefore(current, elem);
			}
		}
	}
	
   /**
    * Removes the first element in this list and returns a reference
    * to it.  Throws an EmptyListException if the list is empty.
    *
    * @return                           a reference to the first element of
    *                                   this list
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public T removeFirst() throws EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");

      LinearNode<T> result = head;
      head = head.getNext();
      if (head == null)
         tail = null;
      count--;

      return result.getElement();
   }

   /**
    * Removes the last element in this list and returns a reference
    * to it.  Throws an EmptyListException if the list is empty.
    *
    * @return                           the last element in this list
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public T removeLast() throws EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");

      LinearNode<T> previous = null;
      LinearNode<T> current = head;

      while (current.getNext() != null)
      {
         previous = current;
         current = current.getNext();
      }

      LinearNode<T> result = tail;
      tail = previous;
      if (tail == null)
         head = null;
      else
         tail.setNext(null);
      count--;

      return result.getElement();
   }
 

  public T remove (T targetElement) throws EmptyCollectionException,
         ElementNotFoundException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");

      boolean found = false;
      LinearNode<T> previous = null;
      LinearNode<T> current = head;

      while (current != null && !found)
         if (targetElement.equals (current.getElement()))
            found = true;
         else
         {
            previous = current;
            current = current.getNext();
         }

      if (!found)
         throw new ElementNotFoundException ("List");

      if (size() == 1){
         head = tail = null;
      }else if (current.equals (head)){
         head = current.getNext();
	 head.setPrev(null);
      } else if (current.equals (tail))
      {
         tail = previous;
         tail.setNext(null);
      }else{
         previous.setNext(current.getNext());
	 current.getNext().setPrev(previous);
      }
      count--;

      return current.getElement();
   }

   /**
    * Returns true if the specified element is found in this list and
    * false otherwise.  Throws an EmptyListException if the specified
    * element is not found in the list.
    *
    * @param targetElement              the element that is sought in the list
    * @return                           true if the element is found in
    *                                   this list
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public boolean search(String first, String last) throws
         EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");

      boolean found = false;
      Object result;

      LinearNode<T> current = head;

      while (current != null && !found)
         if ((first.equals (((Contact) current.getElement()).getFirst())) && (last.equals (((Contact) current.getElement()).getLast())))
            found = true;
         else
            current = current.getNext();
      if(found == true) {
    	  remove(current.getElement());
      }
      return found;
   }

   /**
    * Returns true if this list is empty and false otherwise.
    *
    * @return  true if this list is empty
    */
   public boolean isEmpty()
   {
      return (count == 0);
   }

   /**
    * Returns the number of elements in this list.
    *
    * @return  the integer representation of the number of elements in this list
    */
   public int size()
   {
      return count;
   }


   /**
    * Returns a string representation of this list.
    *
    * @return  a string representation of this list
    */
   public String toString()
   {
      LinearNode<T> current = head;
      String result = "";

      while (current != null)
      {
         result = result + (current.getElement()).toString() + "\n";
         current = current.getNext();
      }

      return result;
   }
   
   public String revString()
   {
      LinearNode<T> current = tail;
      String result = "";

      while (current != null)
      {
         result = result + (current.getElement()).toString() + "\n";
         current = current.getPrev();
      }

      return result;
   }

   /**
    * Returns an iterator for the elements currently in this list.
    *
    * @return  an iterator over the elements of this list
    */
   public Iterator<T> iterator()
   {
      return new LinkedIterator<T>(head, count);
   }

   /**
    * Returns the first element in this list.
    *
    * @return  the first element in this list
    */
   public T first()
   {
      return head.getElement();
   }

   /**
    * Returns the last element in this list.
    *
    * @return  the last element in this list
    */
   public T last()
   {
      return tail.getElement();
   }


@Override
public boolean contains(T target) {
	// TODO Auto-generated method stub
	return false;
}
}

