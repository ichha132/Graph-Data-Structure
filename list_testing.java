
public class list_testing {
	public static void main(String[] args)
	{
		LinkedList<Edge> list=new LinkedList<Edge>();
//		Point p1=new Point(-1, 0, 0);
//				Point p2=new Point(0,-1, 0);
//		Point p3=new Point(1,0,-1);
////		list.add(p1);
////		list.add(p3);
////		list.add(p2);
//		Edge e1=new Edge(p1,p2);
//		Edge e2=new Edge (p3,p1);
//		Edge e3=new Edge (p3,p2);
//		Edge e=new Edge(p2,p1);
//		list.add(e1);
//		list.add(e3);
//		list.add(e2);
//		System.out.println(e2.equals(e3));
//		System.out.println(list.contains(e1));
//		System.out.println(list.contains(e2));
//		System.out.println(list.contains(e3));
//		System.out.println(list.extract(e).points[0].x+ " "+ list.extract(e).points[1].x);
////		System.out.println(list.head.data.x);
//		Iterator2<Point> iterator=list.positions();
//		while(iterator.hasNext())
//		{
//			Position_<Point> p=iterator.next();
//			System.out.println(p.value().x);
//		}
//	}
//		Position<Point> head_temp=list.head;
//		while(list.head!=null)
//		{
//			System.out.println(list.head.data.x);
//			
//			list.head=list.head.n;
//		}
//		list.head=head_temp;
		Point p1=new Point(-1,0,0);
		Point p2=new Point(0,-1,0);
		Point p3=new Point(0,0,-1);
		Point p4=new Point(0,1,0);
//		Point p1=new Point(1, 0, 0);
//		Point p2=new Point(0, 1, 0);
//		Point p3=new Point(0,0,1);
//		Point p4=new Point(1,1,1);
		Edge e1=new Edge(p2,p1);
		Edge e2=new Edge (p1,p3);
		Edge e3=new Edge (p3,p2);
		Edge e4=new Edge(p1,p2);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		Edge e5=new Edge(p4,p2);
		Edge e6=new Edge(p1,p4);
		list.add(e6);
		list.add(e5);
		System.out.println(list.size);
		Edge e7=new Edge(p1,p3);
		Edge e8=new Edge(p2,p4);
		Edge e9=new Edge(p4,p1);
		//list.iterate(list.root);
		System.out.println("e1 length="+e1.edge_length+" "+"e2 length="+e2.edge_length+"e3 length="+e3.edge_length+" "+"e5 length="+e5.edge_length+"E6 lemght="+e6.edge_length);
		System.out.println("e4 length="+e4.edge_length+" "+"e7 length="+e7.edge_length+"e8 length="+e8.edge_length+" "+"e9 length="+e9.edge_length+"E6 lemght="+e6.edge_length);
		System.out.println(e9.edge_length==e6.edge_length);
		System.out.println("e4 exists="+ list.contains(e4));
		System.out.println("e7 exists="+ list.contains(e7));
		System.out.println("e8 exists="+ list.contains(e8));
		System.out.println("e9 exists="+ list.contains(e9));
		System.out.println("e6 exists="+ list.contains(e6));

	}
}
