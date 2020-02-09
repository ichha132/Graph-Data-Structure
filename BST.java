
public class BST {
	Node root;
	int size;
	boolean found_search;
	
	public BST()
	{
		root= null;
		size=0;
	}
//	public int insert(K key, T obj) {
//		// TODO Auto-generated method stub
//		this.ci=0;
//		//Node root1=root;
//		root=insert(root ,key,obj);
//		//root=root1;
//		return (this.ci);
//	}
	public void insert( Edge obj) {
		// TODO Auto-generated method stub
		//this.ci=0;
		if(root==null)
		{
			root=insert1(root,obj);
		}
		else
		{
			Node r=root;
			root=insert1(root ,obj);
			root=r;
		}
		this.size=this.size+1;
		//return (this.ci);
	}
	@SuppressWarnings("unchecked")
	public Node insert1(Node r,  Edge obj)
	{
		
		if(r==null)
		{
			r= new Node(null, null,  obj);
			//ci=ci+1;
		}
		else
		{
			
				
				if(obj.compareTo(r.obj)<0)
				{
					//ci=ci+1;
					//System.out.println("went left");
					r.left= insert1(r.left,obj);
				}
				else
				{
					//ci=ci+1;
					//System.out.println("went right");
					r.right=insert1(r.right,obj);
				}
			}
			
		
		return r;
	}
			
	public Node search( Edge obj) {
		// TODO Auto-generated method stub
		found_search=false;
		Node root1;
		root1=search1(root,obj);
		//boolean b=search1(root,key);
		return root1;
	}
	public Node search1(Node r,Edge obj)
	{
		
		while((r!=null) && found_search == false)
		{
//			System.out.println(r.obj.edge_length);
//			System.out.println(obj.edge_length);
//			System.out.println(r.obj.compareTo(obj));
			if(obj.compareTo(r.obj)<0)
			{
				//cu=cu+1;
				r=r.left;
			}
			else if (obj.compareTo(r.obj)>0)
			{
				//cu=cu+1;
				r=r.right;
			}
			else
			{
				//System.out.println(r.obj.edge_length);
				//cu=cu+1;
				found_search=true;
				break;
			}
			return search1(r,obj);
		}
		return r;
	}
	public void iterate(Node r)
	{
		if(r==null)
			return;
		iterate(r.right);
		System.out.println(r.obj.points[0].x+" "+r.obj.points[0].y+" "+r.obj.points[0].z);
		iterate(r.left);
	}
	
}
