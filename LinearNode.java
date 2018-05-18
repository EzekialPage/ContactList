/**
 * LinearNode represents a node in a linked list.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/13/08
 */

public class LinearNode<E>
{
    private LinearNode<E> next;
    private LinearNode<E> prev;
    private E element;

    //CONSTRUCTORS
    /**
     * Creates an empty node.
     */
    public LinearNode()
    {
        next = null;
	prev = null;
        element = null;
    }

    /**
     * Creates a node storing the specified element.
     *
     * @param elem  the element to be stored within the new node
     */
    public LinearNode (E elem)
    {
        next = null;
	prev = null;
        element = elem;
    }


    //ACCESSORS
    /**
     * Returns the node that follows this one.
     *
     * @return  the node that follows the current one
     */
    public LinearNode<E> getNext()
    {
        return next;
    }

    //returns node prior to this one.
    public LinearNode<E> getPrev()
    {
	return prev;
    }

   /**
    * Returns the element stored in this node.
    *
    * @return  the element stored in this node
    */
    public E getElement()
    {
        return element;
    }

    //MUTATORS
    /**
     * Sets the node that follows this one.
     *
     * @param node  the node to be set to follow the current one
     */
    public void setNext (LinearNode<E> node)
    {
        next = node;
    }

    //sets node that is prior to this one.
    public void setPrev (LinearNode<E> node)
    {
	prev = node;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param elem  the element to be stored in this node
     */
    public void setElement (E elem)
    {
        element = elem;
    }
}
