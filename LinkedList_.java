//import java.util.Iterator;

public interface LinkedList_<T> {
	public Position_<T> add(T e);              // Add element e to this list, returns it position in the list
	public Iterator2<T>  positions();// Returns an iterator for all positions in the list
	public int  count(); 
	public Iterator1<T> iterator();
}
