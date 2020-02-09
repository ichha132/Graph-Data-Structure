
public class Edge implements EdgeInterface, Comparable{
//	Po
//	Point p2;
	int name;
	float edge_length;
	int connected_triangles;
	//int connected_edges;
	Point points[]=new Point[2];
	LinkedList<Triangle> triangles_connected;
	//LinkedList<Edge> edges_connected;
	public Edge(Point p1,Point p2)
	{
//		this.p1=p1;
//		this.p2=p2;
		points[0]=p1;
		points[1]=p2;
		name=0;
		connected_triangles=0;
		//connected_edges=0;
		edge_length=((p1.x-p2.x)*(p1.x-p2.x))+((p1.y-p2.y)*(p1.y-p2.y))+((p1.z-p2.z)*(p1.z-p2.z));
		triangles_connected=new LinkedList<Triangle>();
		//edges_connected=new LinkedList<Edge>();
	}
	@Override
	public PointInterface[] edgeEndPoints() {
		// TODO Auto-generated method stub
		return points;
	}
	@Override
	public int compareTo(Object edge) {
		// TODO Auto-generated method stub
		Edge e=(Edge) edge;
		if(e.edge_length!=this.edge_length)
		{
			if((this.edge_length-e.edge_length)>0)
				return 1;
			else
				return -1;
		}
		else
		{
			if(e.points[0].equals(this.points[0]) && e.points[1].equals(this.points[1]))
			{
				//System.out.println("checking1");
				return 0;
			}
			else if(e.points[1].equals(this.points[0])&& e.points[0].equals(this.points[1]))
			{
				//System.out.println("checking 2");
				return 0;
			}
			else
				return 1;
		}
	}
	@Override
	public boolean equals(Object edge)
	{
		Edge e=(Edge) edge;
		if(this.compareTo(e)==0)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return ("["+this.points[0].toString()+","+this.points[1].toString()+"]");
	}

}
