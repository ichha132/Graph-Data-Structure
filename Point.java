
public class Point implements PointInterface {
	float x;
	float y;
	float z;
	float[] coordinate= new float[3];
	int name;
	float sum;
	int connected_points;
	int connected_triangles;
	LinkedList<Point> points_connected;
	LinkedList<Triangle>  triangles_connected;
	public Point(float x, float y,float z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
		coordinate[0]=x;
		coordinate[1]=y;
		coordinate[2]=z;
		//name=0;
		sum=(x+y+z);
		connected_points=0;
		connected_triangles=0;
		points_connected=new LinkedList<Point>();
		triangles_connected=new LinkedList<Triangle>();
	}
	
	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return coordinate[0];
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return coordinate[1];
	}

	@Override
	public float getZ() {
		// TODO Auto-generated method stub
		return coordinate[2];
	}

	@Override
	public float[] getXYZcoordinate() {
		// TODO Auto-generated method stub
		
		return coordinate;
	}
	@Override
	public boolean equals(Object obj)
	{
		Point p = (Point) obj;
		if(this.x==(p.x) && this.y==(p.y) && this.z==(p.z) )
			return true;
		else
			return false;
	}
	public String toString()
	{
		return ("("+Float.toString(this.x)+", "+Float.toString(this.y)+", "+Float.toString(this.z)+")");
	}
	public LinkedList getList()
	{
		return triangles_connected;
	}
}
