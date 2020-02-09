//import java.util.Iterator;

public class LinkedList<T> implements LinkedList_<T> {
	Position<T> pos;
	public Position<T> head;
	public int size=0;
	Iterator2 ob;
//	Iterator<T> it;
	public LinkedList()
	{
		head=null;
	}
	public LinkedList(Position<T> h)
	{
		head=h;
		ob= new Iterator2(head);
	}
	public Iterator2<T> positions()
	{
		return new Iterator2<T>(this.head);
	}
	public Iterator1<T> iterator()
	{ 
		return new Iterator1<T>(head);
	}
	public Position_<T> add(T e) {
		// TODO Auto-generated method stub
		Position<T> obj= new Position<T>(e,null);
		Position head_temp=head;
		if(head== null)
		{
			head= obj;
			head_temp=head;
		}
			
		else 
		{
			//pos= head; //= new Node1<T>(null, null);
			
		    while(head.after()!=null)
		    	{
		    		head=head.after1();
		    	}
		    //head.data=e;
		    head.n =obj;
		    
		}
		size=size+1;
		Position_ answer=head.n;
		head=head_temp;
		return answer;
		
		

	}
	public int count()
	{
		//Linked_List<T> l= new Linked_List<T>();
		//Iterator1<T> obj= l.nodes();
		//Node1<T> current= obj.current;
		//while(obj.hasNext())
		//{
			//size++;
		//}
		return size;
	}
	public boolean contains(T data)
	{
		Iterator2<T> iterator=this.positions();
		while(iterator.hasNext())
		{
			if( iterator.next().value().equals(data))
				return true;
		}
		
		return false;
	}
	public T extract(T data)
	{
		Iterator2<T> iterator=this.positions();
		while(iterator.hasNext())
		{
			Position_<T> p=iterator.next();
			if( p.value().equals(data))
				return p.value();
		}
		return null;
		
	
	}
	public LinkedList getList()
	{
		return this;
	}
}


