
public class Node implements Node_{
	Node left;
	Node right;
	Edge obj;
	public Node(Node left, Node right,Edge obj)
	{
		this.left=left;
		this.right=right;
		
		this.obj=obj;
	}

	@Override
	public Node_ getLeft() {
		// TODO Auto-generated method stub
		return this.left;
	}

	@Override
	public Node_ getRight() {
		// TODO Auto-generated method stub
		return this.right;
	}

//	@Override
//	public K getKey() {
//		// TODO Auto-generated method stub
//		return this.key;
//	}

	@Override
	public Edge getObj() {
		// TODO Auto-generated method stub
		return this.obj;
	}

}
