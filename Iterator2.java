//import java.util.Iterator;

public class Iterator2<T>  {
	public Position_<T> current; // = new Position<T>(null,null); //= new Node1<T>(null, null);
	public Iterator2(Position_<T> head)
	{
		current = head;
	}
	public boolean hasNext()
	{
		 
			   return (current != null );
			
	}
	public Position_<T> next()
	{
		Position_<T> d = current;
		current = current.after();
		return d;
	}

}
