
public class Position<T> implements Position_<T> {

	public T data;
    public Position<T> n;
    public Position(T val, Position<T> n1)
    {
    	data=val; 
    	n=n1;
    }
    public T value()
    {
    	return data;
    }
    public Position_<T> after()
    {
    	return n;
    }
     public Position<T> after1()
     {
    	 return n;
     }
    
}
