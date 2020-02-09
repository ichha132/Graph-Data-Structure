
public class Triangle implements TriangleInterface {
//	Point p1;
//	Point p2;
//	Point p3;
	Edge e1;
	Edge e2;
	Edge e3;
	int name;
	Point points[]=new Point[3];
	int connected_triangles;		//only through an edge
	LinkedList<Triangle> triangles_connected;
	public Triangle(Point p1,Point p2,Point p3,Edge e1,Edge e2, Edge e3)
	{
//		this.p1=p1;
//		this.p2=p2;
//		this.p3=p3;
		this.e1=e1;
		this.e2=e2;
		this.e3=e3;
		points[0]=p1;
		points[1]=p2;
		points[2]=p3;
		name=0;
		triangles_connected=new LinkedList<Triangle>();
		connected_triangles=0;
	}
	@Override
	public PointInterface[] triangle_coord() {
		// TODO Auto-generated method stub
		return points;
	}
	@Override
	public boolean equals(Object obj)
	{
		Triangle t=(Triangle) obj;
		Point p1=t.points[0];
		Point p2=t.points[1];
		Point p3=t.points[2];
		if((this.points[0].equals(p1) && this.points[1].equals(p2) && this.points[2].equals(p3)) ||(this.points[0].equals(p1) && this.points[1].equals(p3)&& this.points[2].equals(p2)) || (this.points[0].equals(p2) && this.points[1].equals(p3) && this.points[2].equals(p1))|| (this.points[0].equals(p2)&& this.points[1].equals(p1)&& this.points[2].equals(p3)) ||(this.points[0].equals(p3) && this.points[1].equals(p1)&& this.points[2].equals(p2))||(this.points[0].equals(p3)&& this.points[1].equals(p2) && this.points[2].equals(p1)) )			//check
		  {	
			return true;
		  }
		else
			return false;
	}
	public boolean isEdgeConnected(Triangle t)
	{
		Point p1=t.points[0];
		Point p2=t.points[1];
		Point p3=t.points[2];
		Edge e1=new Edge(p1,p2);
		Edge e2=new Edge(p2,p3);
		Edge e3=new Edge(p3,p1);
		if(this.e1.equals(e1) || this.e2.equals(e1)|| this.e3.equals(e1) || this.e1.equals(e2) || this.e2.equals(e2) || this.e3.equals(e2)|| this.e1.equals(e3)|| this.e2.equals(e3)|| this.e3.equals(e3))			//check
		  {
			return true;
		  }
		else
			return false;
	}
	public boolean isVertexConnected(Triangle t)
	{
		Point p1=t.points[0];
		Point p2=t.points[1];
		Point p3=t.points[2];
		if(this.points[0].equals(p1) || this.points[1].equals(p1)|| this.points[2].equals(p1) || this.points[0].equals(p2) || this.points[1].equals(p2) || this.points[2].equals(p2)|| this.points[0].equals(p3)|| this.points[1].equals(p3)|| this.points[2].equals(p3))			//check
			 return true;
		else
			return false;
	}
	public String toString()
	{
		return ("["+this.points[0].toString()+","+this.points[1].toString()+","+this.points[2].toString()+"]");
	}

}
