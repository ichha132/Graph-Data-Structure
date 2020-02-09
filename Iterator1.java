//import java.util.Iterator;
public class Iterator1<T>  {
	public Position_<T> current= new Position<T>(null, null); //= new Node1<T>(null, null);
	public Iterator1(Position<T> head)
	{
		current = head;
	} 
	public boolean hasNext () { 
		   return (current != null && current.after() != null);
		}
	public T next()
	{
		Position_<T> d = current;
		current = current.after();
		return d.value();
	}
	
}
