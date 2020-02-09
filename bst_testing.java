
public class bst_testing {
	public static void main(String[] args)
	{
		BST edges=new BST();
		Point p1=new Point(-1,0,0);
		Point p2=new Point(0,-1,0);
		Point p3=new Point(0,0,-1);
		Point p4=new Point(0,1,0);
//		Point p1=new Point(1, 0, 0);
//		Point p2=new Point(0, 1, 0);
//		Point p3=new Point(0,0,1);
//		Point p4=new Point(1,1,1);
		Edge e1=new Edge(p1,p2);
		Edge e2=new Edge (p3,p1);
		Edge e3=new Edge (p3,p2);
		Edge e4=new Edge(p2,p1);
		edges.insert(e1);
		edges.insert(e2);
		edges.insert(e3);
		Edge e5=new Edge(p4,p2);
		Edge e6=new Edge(p4,p1);
		edges.insert(e6);
		edges.insert(e5);
		System.out.println(edges.size);
		Edge e7=new Edge(p3,p1);
		Edge e8=new Edge(p2,p4);
		Edge e9=new Edge(p4,p1);
		System.out.println(edges.root.obj.points[0].x);
		edges.iterate(edges.root);
		System.out.println("e1 length="+e1.edge_length+" "+"e2 length="+e2.edge_length+"e3 length="+e3.edge_length+" "+"e5 length="+e5.edge_length+"E6 lemght="+e6.edge_length);
		System.out.println("e4 length="+e4.edge_length+" "+"e7 length="+e7.edge_length+"e8 length="+e8.edge_length+" "+"e9 length="+e9.edge_length+"E6 lemght="+e6.edge_length);
		System.out.println(e9.edge_length==e6.edge_length);
		edges.search(e4);
		System.out.println("e4 exists="+ edges.search(e4));
		System.out.println("e7 exists="+ edges.search(e7));
		System.out.println("e8 exists="+ edges.search(e8));
		System.out.println("e9 exists="+ edges.search(e9));
		System.out.println("e6 exists="+ edges.search(e6));
		
		System.out.println(e2.compareTo(e1));
		


	}

}
