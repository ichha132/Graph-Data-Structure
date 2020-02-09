
public class Shape implements ShapeInterface {
	boolean count_connected_check=false;
	boolean isFirst=true;
	boolean triangle_added=false;
	int count_points=0;
	int count_edges=0;
	int count_triangles=0;
	 LinkedList<Point>[] points=new LinkedList[257];
	 BST edges=new BST();				// check if it works correctly
	 LinkedList<Triangle> triangles=new LinkedList<Triangle>();
	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	 public boolean ADD_TRIANGLE(float [] triangle_coord){		
		
		 boolean isTriangle=false;
		 float x1=triangle_coord[0];
		 float y1=triangle_coord[1];
		 float z1=triangle_coord[2];
		 float x2=triangle_coord[3];
		 float y2=triangle_coord[4];
		 float z2=triangle_coord[5];
		 float x3=triangle_coord[6];
		 float y3=triangle_coord[7];
		 float z3=triangle_coord[8];
		 // create new points
		 //count_points=count_points+1;
		 Point p1= new Point(x1,y1,z1);
		// count_points=count_points+1;
		 Point p2=new Point(x2,y2,z2);
	//	 count_points=count_points+1;
		 Point p3=new Point(x3,y3,z3);

		 // does && come or || come in the if condition?
		 if(((x3-x1)/(x2-x1))==((y3-y1)/(y2-y1)) && ((x3-x1)/(x2-x1))==(z3-z1)/(z2-z1)&& ((y3-y1)/(y2-y1))==((z3-z1)/(z2-z1)))
		 {
			 //System.out.println("False");
			 return false;
		 }
			 isTriangle=true;
			 int e1_exists=-1;
			 int e2_exists=-1;
			 int e3_exists=-1;
			 int p1_exists=-1;
			 int p2_exists=-1;
			 int p3_exists=-1;
			 int t1_exists=-1;
			 Edge e1=new Edge(p1,p2);
			 Edge e2=new Edge(p2,p3);
			 Edge e3=new Edge(p3,p1);
			 //create new triangle
			 //System.out.println("53 line");
//			 Triangle t1=new Triangle(p1,p2,p3,e1,e2,e3);
//			 count_triangles=count_triangles+1;
//			 t1.name=count_triangles;
			 //checking if things already exist
//			 String ps1=removezeros(p1.toString());
//			 String ps2=removezeros(p2.toString());
//			 String ps3=removezeros(p3.toString());
			 int hashvalue1=(int) djb2(Float.toString(p1.sum));
			 int hashvalue2=(int) djb2(Float.toString(p2.sum));
			 int hashvalue3=(int) djb2(Float.toString(p3.sum));
			 //System.out.println(hashvalue1+" "+hashvalue2+" "+hashvalue3);
			 //System.out.println(" line 62");
			 if(points[hashvalue1]==null)
			 {
				 points[hashvalue1]=new LinkedList<Point>();
			 }
				 Point p1_temp=points[hashvalue1].extract(p1);
				 //System.out.println("p1_temp="+p1_temp);
				 //System.out.println(points[hashvalue1].contains(p1));
				 if(p1_temp!=null)									//check if this update happens!!!!!!!!!!
				 {
					 p1=p1_temp;
					 p1.name=p1_temp.name;
					 p1_exists=1;
				 }
				 else
				 {
					 //System.out.println("new point!");
					 //System.out.println(p1.x+" "+p1.y+" "+p1.z);
					 count_points=count_points+1;
					 p1.name=count_points;
					 
					 points[hashvalue1].add(p1);
					 p1_exists=0;
				 }
				// System.out.println("line 87="+points[hashvalue1].extract(p1));
				 if(points[hashvalue2]==null)
				 {
					 points[hashvalue2]=new LinkedList<Point>();
				 }
			 Point p2_temp=points[hashvalue2].extract(p2);
			 //System.out.println("p2_temp="+p2_temp);
			 if(p2_temp!=null)
			 {
				 p2=p2_temp;
				 p2.name=p2_temp.name;

				 p2_exists=1;
			 }
			 else
			 {
				// System.out.println("new point!");
				// System.out.println(p2.x+" "+p2.y+" "+p2.z);
				 count_points=count_points+1;
				 p2.name=count_points;
				 points[hashvalue2].add(p2);
				 p2_exists= 0;
			 }
			 if(points[hashvalue3]==null)
			 {
				 points[hashvalue3]=new LinkedList<Point>();
			 }
			 Point p3_temp=points[hashvalue3].extract(p3);
			// System.out.println("p3_temp="+p3_temp);
			 if(p3_temp!=null)
			 {
				 p3=p3_temp;
				 p3.name=p3_temp.name;
				 p3_exists=1;
			 }
			 else
			 {
				 count_points=count_points+1;
				 p3.name=count_points;
				 points[hashvalue3].add(p3);
				 p3_exists=0;
			 }
			
			 
			 if(p1_exists==0 || p2_exists==0)
			 {
				 e1_exists=0;
				 count_edges=count_edges+1;
				 e1.name=count_edges;
				 

				 edges.insert(e1);
			 }
			 else 
			 {
				 Edge e1_temp;
				 Node e1_node;
				 if(edges==null)
				 {
					 e1_temp=null;
				 }
				 else
				 {
					  e1_node = edges.search(e1);
					  if(e1_node==null)
					  {
						 e1_temp=null;
					  }
					  else
						  e1_temp=e1_node.obj;
				 }
				 if(e1_temp!=null)
				 {
					 e1=e1_temp;
					 e1_exists=1;
				 }
				 else
				 {
					 e1_exists=0;
					 count_edges=count_edges+1;
					 e1.name=count_edges;
					 //System.out.println("entered insert");

					 edges.insert(e1);
				 }
				// System.out.println("hi 156 a");
			 }
			 if(p2_exists==0 || p3_exists==0)
			 {
				 e2_exists=0;
				 count_edges=count_edges+1;
				 e2.name=count_edges;
				 //System.out.println("entered insert");

				 edges.insert(e2);
				 //System.out.println("hi 164 b");
			 }
			 else 
			 {
				 Edge e2_temp;
				 Node e2_node;
				 if(edges==null)
				 {
					 e2_temp=null;
				 }
				 else
				 {
					  e2_node = edges.search(e2);
					  if(e2_node==null)
					  {
						 e2_temp=null;
					  }
					  else
						  e2_temp=e2_node.obj;
				 }
				 if(e2_temp!=null)
				 {
					 e2=e2_temp;
					 e2_exists=1;
				 }
				 else
				 {
					 e2_exists=0;
					 count_edges=count_edges+1;
					 e2.name=count_edges;
					 //System.out.println("entered insert");

					 edges.insert(e2);
				 }
				// System.out.println("hi 156 b");
			 }
			 
			 
			 if(p1_exists==0 || p3_exists==0)
			 {
				 e3_exists=0;
				 count_edges=count_edges+1;
				 e3.name=count_edges;
				 //System.out.println("entered insert");

				 edges.insert(e3);
				 //System.out.println("hi 192 c");
			 }
			 else 
			 {
				 Edge e3_temp;
				 Node e3_node;
				 if(edges==null)
				 {
					 e3_temp=null;
				 }
				 else
				 {
					  e3_node = edges.search(e3);
					  if(e3_node==null)
					  {
						 e3_temp=null;
					  }
					  else
						  e3_temp=e3_node.obj;
				 }
				 if(e3_temp!=null)
				 {
					 e3=e3_temp;
					 e3_exists=1;
				 }
				 else
				 {
					 e3_exists=0;
					 count_edges=count_edges+1;
					 e3.name=count_edges;
					 //System.out.println("entered insert");
					 edges.insert(e3);
				 }
				// System.out.println("hi 156 c");
			 }
			 //System.out.println("edges done in line 205");
			 
			 // add points to its data structure
			 
			 // fill connected_points data structure for each point
			 if(e1_exists==0 && e2_exists==0 && e3_exists==0)
			 {
				 p1.points_connected.add(p2);
				 p1.points_connected.add(p3);
				 p2.points_connected.add(p1);
				 p2.points_connected.add(p3);
				 p3.points_connected.add(p1);
				 p3.points_connected.add(p2);
			 }
			 else if(e1_exists==1 && e2_exists==0 && e3_exists==0)
			 {
				 p1.points_connected.add(p3);
				 p2.points_connected.add(p3);
				 p3.points_connected.add(p1);
				 p3.points_connected.add(p2);
			 }
			 else if(e1_exists==0 && e2_exists==1 && e3_exists==0)
			 {
				 p1.points_connected.add(p2);
				 p1.points_connected.add(p3);
				 p2.points_connected.add(p1);
				 p3.points_connected.add(p1);
			 }
			 else if(e1_exists==0 && e2_exists==0 && e3_exists==1)
			 {
				 p1.points_connected.add(p2);
				 p2.points_connected.add(p1);
				 p2.points_connected.add(p3);
				 p3.points_connected.add(p2);
			 }
			 else if(e1_exists==1 && e2_exists==1 && e3_exists==0)
			 {
				 p1.points_connected.add(p3);
				 p3.points_connected.add(p1);
			 }
			 else if(e1_exists==0 && e2_exists==1 && e3_exists==1)
			 {
				 p1.points_connected.add(p1);
				 p2.points_connected.add(p1);
			 }
			 else if(e1_exists==1 && e2_exists==0 && e3_exists==1)
				 
			 {
				 p2.points_connected.add(p3);
				 p3.points_connected.add(p2);
			 }
//			 e1.edges_connected.add(e2);
//			 e1.edges_connected.add(e3);
//			 e2.edges_connected.add(e3);
//			 e2.edges_connected.add(e1);
//			 e3.edges_connected.add(e2);
//			 e3.edges_connected.add(e1);
			 // fill triangles connected data structure for each point
			 Triangle t1=new Triangle(p1,p2,p3,e1,e2,e3);
			 count_triangles=count_triangles+1;
			 t1.name=count_triangles;
			 p1.triangles_connected.add(t1);
			 p1.connected_triangles=p1.connected_triangles+1;
			 p2.triangles_connected.add(t1);
			 p2.connected_triangles=p2.connected_triangles+1;
			 p3.triangles_connected.add(t1);
			 p3.connected_triangles=p3.connected_triangles+1;
			 //add edges to its data structure
			 //fill triangles_connected for each edge
			 e1.triangles_connected.add(t1);
			 e1.connected_triangles=e1.connected_triangles+1;
			 e2.triangles_connected.add(t1);
			 e2.connected_triangles=e2.connected_triangles+1;
			 e3.triangles_connected.add(t1);
			 e3.connected_triangles=e3.connected_triangles+1;
			 //add triangle to its data structure			 
			 Iterator2<Triangle> iterator=triangles.positions();
			 while(iterator.hasNext())
			 {
				 Triangle t=iterator.next().value();
				 if(t.isEdgeConnected(t1))
				 {
					 t.triangles_connected.add(t1);
					 t.connected_triangles=t.connected_triangles+1;
					 t1.triangles_connected.add(t);
					 t1.connected_triangles=t1.connected_triangles+1;
				 }
			 }
			 triangles.add(t1);
			 //update triangles_connected list
			 // check if triangle/edge/point already exists
			 // try optimizing the stored things
			 //System.out.println("size of edges bst="+edges.size);
			// System.out.println("True");
			 triangle_added=true;
			 this.count_connected_check=false;
			 this.max_dia=false;
			 return true;
			 
	 }
	 public static long djb2(String str) { 
		    long hash = 5381; 
		    int hashtableSize=37;
		    for (int i = 0; i < str.length(); i++) { 
		        hash = ((hash << 5) + hash) + str.charAt(i); 
		    } 
		    return Math.abs(hash) % hashtableSize; 
		}

	//
	 
	 
	 int doubly_connected;
	 int singly_connected;
	 boolean is_improper;
	
	 public int TYPE_MESH(){
		  doubly_connected=0;
		  singly_connected=0;
		  is_improper=false;
		 if(edges.root==null)
			 return 0;
		 iterate(edges.root);
		 if(is_improper==true)
			 return 3;
		 if(doubly_connected==edges.size)
			 return 1;
		 return 2;
		}

	//
	 
		public void iterate(Node r)
		{
			if(r==null)
				return;
			iterate(r.right);
			operate(r);
			iterate(r.left);
		}
		public void operate(Node r)
		{
			if(is_improper==true)
				return;
			
			if(r.obj.connected_triangles>2)
				 is_improper=true;
			 if(r.obj.connected_triangles==2)
			 {
				 doubly_connected=doubly_connected+1;
			 }
			 if(r.obj.connected_triangles==1)
			 {
				 singly_connected=singly_connected+1;
			 }
		}
		
		
		int boundary_edges_length;
		EdgeInterface[] true_boundary_edges;
	
	public EdgeInterface [] BOUNDARY_EDGES(){							
		
		 true_boundary_edges=new EdgeInterface[count_edges];
		 boundary_edges_length=0;
		 if(edges.root==null)
			 return null;
		 iterate1(edges.root);
		 EdgeInterface[] final_answer=new EdgeInterface[boundary_edges_length];
		 for(int i=0;i<boundary_edges_length && true_boundary_edges[i]!=null;i++)
		 {
			 final_answer[i]=true_boundary_edges[i];
		 }
		 if(boundary_edges_length==0)
			 return null;
		 return final_answer;
		  }
	 public void iterate1(Node r)
		{
			if(r==null)
				return;
			iterate1(r.left);
			operate1(r);
			iterate1(r.right);
		}
	 public void operate1(Node r)
	 {
		 if(r==null)
			 return;
		 //r.obj.connected_edges=r.obj.edges_connected.size;
		 if(r.obj.connected_triangles==1)
		 {
			 true_boundary_edges[boundary_edges_length]=r.obj;
			 boundary_edges_length=boundary_edges_length+1;
		 }
		 
	 }

	//
	 
	 boolean[] visited_marks;
	 int count_connected;
	 int size_of_component;
	 LinkedList<Triangle> component;
	 LinkedList<connectedComponentNode> connected_components;
	
	 public int COUNT_CONNECTED_COMPONENTS(){
		  if(max_dia==true && triangle_added==false)
		  {
			  return connected_components.size;
		  }
		  count_connected_check=true;				//it counts again only if a new triangle was added.. else returns the earlier calc value
		  connected_components=new LinkedList<connectedComponentNode>();
		  //int max=0;
		  component=new LinkedList<Triangle>();
		  //connected_components.head=new LinkedList();
		  size_of_component=0;
		  max=0;
		  if(triangle_added==true)
		  {
			  count_connected=0;
			  
			  visited_marks=new boolean[this.count_triangles];
			  Iterator2<Triangle> iterator_main=triangles.positions();
			  while(iterator_main.hasNext())
			  {
				  component=new LinkedList<Triangle>();
				  Triangle t_outer=iterator_main.next().value();
				  if(visited_marks[t_outer.name-1]==false)
				  {
					  
					  component.add(t_outer);
					  count_connected=count_connected+1;
					  visited_marks[t_outer.name-1]=true;
					  size_of_component=1;
					  count_connected_rec(t_outer);
					  if(max<size_of_component)
						  max=size_of_component;
					  connectedComponentNode n= new connectedComponentNode(max,component);
					  connected_components.add(n);
				  }
				  
			  }
			  triangle_added=false;
		  }
		  
		  return connected_components.size;
	  }
	  public void count_connected_rec(Triangle t)
	  {
		  Iterator2<Triangle> iterator_inner=t.triangles_connected.positions();
		  while(iterator_inner.hasNext())
		  {
			  Triangle temp=iterator_inner.next().value();
			  if(visited_marks[temp.name-1]==false)
			  {
				  component.add(temp);
				  size_of_component=size_of_component+1;
				  visited_marks[temp.name-1]=true;
				  count_connected_rec(temp);
			  }
		  }
	  }

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	  public TriangleInterface [] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord){
		  //is it okay to return the existing triangle as well?????????
		  boolean found=false;
		  Point p1=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		  Point p2=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		  Point p3=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		  Edge e1=new Edge(p1,p2);
		  Edge e2=new Edge(p2,p3);
		  Edge e3=new Edge(p3,p1);
		  Triangle t=new Triangle(p1,p2,p3,e1,e2,e3);
		  Triangle t1=null;
		  Iterator2<Triangle> iterator=triangles.positions();
		  while(iterator.hasNext())
		  {
			  t1= iterator.next().value();
			  if(t1.equals(t))
			  {
				 found=true;
				 break;
			  }
		  }
		  if(found==false)
			  return null;
		  TriangleInterface[] true_triangles=new TriangleInterface[t1.triangles_connected.size];
		  int j=0;
		  Iterator2<Triangle> iter=t1.triangles_connected.positions();
		  while(iter.hasNext())
		  {
			  Triangle temp=iter.next().value();
			  true_triangles[j]=temp;
			  j=j+1;
		  }
		  if(j==0)
			  return null;
		  return true_triangles;
	  }


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	  public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		  EdgeInterface[] edge_neighbors=new EdgeInterface[3];
		  boolean found=false;
		  Point p1=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		  Point p2=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		  Point p3=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		  Edge e1=new Edge(p1,p2);
		  Edge e2=new Edge(p2,p3);
		  Edge e3=new Edge(p3,p1);
		  Triangle t=new Triangle(p1,p2,p3,e1,e2,e3);
		  int hashvalue=(int) djb2(Float.toString(p1.sum));
		 // Iterator2<Triangle> iterator=triangles.positions();
		  Iterator2<Triangle> iterator=points[hashvalue].extract(p1).triangles_connected.positions();
		  while(iterator.hasNext())
		  {
			  Triangle t1= iterator.next().value();
//			  if((t1.e1.equals(e1) && t1.e2.equals(e2) && t1.e3.equals(e3)) ||(t1.e1.equals(e1) && t1.e2.equals(e3)&& t1.e3.equals(e2)) || (t1.e1.equals(e2) && t1.e2.equals(e3) && t1.e3.equals(e1))|| (t1.e1.equals(e2)&& t1.e2.equals(e1)&& t1.e3.equals(e3)) ||(t1.e1.equals(e3) && t1.e2.equals(e1)&& t1.e3.equals(e2))||(t1.e1.equals(e3)&& t1.e2.equals(e2) && t1.e3.equals(e1)) )			//check
//			  {
			  if(t1.equals(t))
			  {
				  edge_neighbors[0]=t1.e1;
				  edge_neighbors[1]=t1.e2;
				  edge_neighbors[2]=t1.e3;
				  found=true;
				  break;
			  }
			  
		  }
		  if(found==false)
			  return null;
		  return edge_neighbors;
	  }

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	  public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord) {				//check connected trainglesssssss
		  PointInterface[] point_neighbors=new PointInterface[3];
		  Point p1=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		  Point p2=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		  Point p3=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		  Edge e1=new Edge(p1,p2);
		  Edge e2=new Edge(p2,p3);
		  Edge e3=new Edge(p3,p1);
		  boolean found=false;
		  Triangle t=new Triangle(p1,p2,p3,e1,e2,e3);
		  int hashvalue=(int) djb2(Float.toString(p1.sum));
		  Point p=points[hashvalue].extract(p1);
		  Iterator2<Triangle> iterator=p.triangles_connected.positions();
		  while(iterator.hasNext())
		  {
			  Triangle t1= iterator.next().value();
//			  if((t1.points[0].equals(p1) && t1.points[1].equals(p2) && t1.points[2].equals(p3)) ||(t1.points[0].equals(p1) && t1.points[1].equals(p3)&& t1.points[2].equals(p2)) || (t1.points[0].equals(p2) && t1.points[1].equals(p3) && t1.points[2].equals(p1))|| (t1.points[0].equals(p2)&& t1.points[1].equals(p1)&& t1.points[2].equals(p3)) ||(t1.points[0].equals(p3) && t1.points[1].equals(p1)&& t1.points[2].equals(p2))||(t1.points[0].equals(p3)&& t1.points[1].equals(p2) && t1.points[2].equals(p1)) )			//check
//			  {
			  if(t.equals(t1))
			  {
				  point_neighbors[0]=t1.points[0];
				  point_neighbors[1]=t1.points[1];
				  point_neighbors[2]=t1.points[2];
				  found=true;
				  break;
			  }
			  
		  }
		  if(found==false)
			  return null;
		  return point_neighbors;
	  }


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	  public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord){				// check connected trinagles yaaaaar
		  TriangleInterface[] true_triangles=new TriangleInterface[count_triangles];				
		  Iterator2<Triangle> iterator=triangles.positions();
		  boolean found=false;
		  Point e1=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		  Point e2=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		  Point e3=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		  int j=0;
		  while(iterator.hasNext())
		  {
			  Triangle t1=iterator.next().value();
			  if(t1.points[0].equals(e1) || t1.points[1].equals(e1)|| t1.points[2].equals(e1) || t1.points[0].equals(e2) || t1.points[1].equals(e2) || t1.points[2].equals(e2)|| t1.points[0].equals(e3)|| t1.points[1].equals(e3)|| t1.points[2].equals(e3))			//check
			  {
				  if((t1.points[0].equals(e1) && t1.points[1].equals(e2) && t1.points[2].equals(e3)) ||(t1.points[0].equals(e1) && t1.points[1].equals(e3)&& t1.points[2].equals(e2)) || (t1.points[0].equals(e2) && t1.points[1].equals(e3) && t1.points[2].equals(e1))|| (t1.points[0].equals(e2)&& t1.points[1].equals(e1)&& t1.points[2].equals(e3)) ||(t1.points[0].equals(e3) && t1.points[1].equals(e1)&& t1.points[2].equals(e2))||(t1.points[0].equals(e3)&& t1.points[1].equals(e2) && t1.points[2].equals(e1)) )			//check
				  {
					  found=true;
				  }
				  else
				  {
					  true_triangles[j]=t1;
					  j=j+1;
				  }
			  }
		  }
		  if(found==false)
			  return null;
		  TriangleInterface[] final_answer=new TriangleInterface[j];
		  for(int i=0;i<j && true_triangles[i]!=null;i++)
			  final_answer[i]=true_triangles[i];
		  return final_answer;
	  }


	//INPUT [x,y,z]
	  public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates){		
		  Point p=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
//		  TriangleInterface[] true_triangles=new TriangleInterface[count_triangles];
		  int hashvalue=(int) djb2(Float.toString(p.sum));
		  Iterator2<Triangle> iterator=points[hashvalue].extract(p).triangles_connected.positions();
		  TriangleInterface[] true_triangles=new TriangleInterface[points[hashvalue].extract(p).connected_triangles];
		  int j=0;
		  while(iterator.hasNext())
		  {
			  Triangle t1=iterator.next().value();
//			  if(t1.points[0].equals(p) || t1.points[1].equals(p) || t1.points[2].equals(p))
//			  {
//				  true_triangles[j]=t1;
//				  j=j+1;
//			  }
			  true_triangles[j]=t1;
		      j=j+1;
		  }
		  if(j==0)
			  return null;
		  return true_triangles;
	  }


	// INPUT [x,y,z]
	  public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates){
		  Point p=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
		  int hashvalue=(int) djb2(Float.toString(p.sum));
		  Point p1=points[hashvalue].extract(p);
		  p1.connected_points=p1.points_connected.size;
		  if(p1==null)
			  return null;
		  if(p1.connected_points==0)
		  {
			  return null;
		  }
		  PointInterface[] true_points=new PointInterface[p1.connected_points];
		  int j=0;
		  Iterator2<Point> iterator=p1.points_connected.positions();
		  while(iterator.hasNext())
		  {
			  Point p_temp=iterator.next().value();
			  true_points[j]=p_temp;
			  j=j+1;
		  }
		  
		  return true_points;
	  }


	// INPUT[x,y,z]
	  EdgeInterface[] true_neighbors_of_point_edges;									//try making edge neighbors of point in Point
	  int edge_neighbors_of_point_length;
	  public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates){		
		  true_neighbors_of_point_edges=new EdgeInterface[this.count_edges];
		  edge_neighbors_of_point_length=0;
		  Point p=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
		  iterate2(edges.root,p);
		  if(edge_neighbors_of_point_length==0)
			  return null;
		  EdgeInterface[] final_answer=new EdgeInterface[this.edge_neighbors_of_point_length];
		  for(int i=0;i<this.edge_neighbors_of_point_length && this.true_neighbors_of_point_edges[i]!=null;i++)
			  final_answer[i]=this.true_neighbors_of_point_edges[i];
		  return final_answer;
		  
	  }
	  public void iterate2(Node r,Point p)
		{
			if(r==null)
				return;
			iterate2(r.right,p);
			operate2(r,p);
			iterate2(r.left,p);
		}
	  public void operate2(Node r,Point p)				//null pointer can come
	  {
		  if(r.obj.points[0].equals(p)|| r.obj.points[1].equals(p))
		  {
			  true_neighbors_of_point_edges[this.edge_neighbors_of_point_length]=r.obj;
			  this.edge_neighbors_of_point_length=this.edge_neighbors_of_point_length+1;
		  }
	  }


	// INPUT[x,y,z]
	  public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates){ 
		  Point p=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
		  int hashvalue=(int) djb2(Float.toString(p.sum));
		  Point p1=points[hashvalue].extract(p);
		  if(p1==null)
			  return null;
		  p1.connected_points=p1.triangles_connected.size;
		  Iterator2<Triangle> iterator=p1.triangles_connected.positions();
		  TriangleInterface[] true_triangles=new TriangleInterface[p1.connected_points];
		  int j=0;
		  while(iterator.hasNext() && j<true_triangles.length)
		  {
			  true_triangles[j]=iterator.next().value();
			  j=j+1;
		  }
		  return true_triangles;
	  }



	// INPUT // [xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 , xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3]   where xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 are 3 coordinates of first triangle and xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3 are coordinates of second triangle as given in specificaition.
	  boolean[] visited_nodes;
	  public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2){		// what if same triangles are given?
		  visited_nodes=new boolean[this.count_triangles];
		  boolean found1=false;
		  boolean found2=false;
		  Point t1p1=new Point(triangle_coord_1[0],triangle_coord_1[1],triangle_coord_1[2]);
		  Point t1p2=new Point(triangle_coord_1[3],triangle_coord_1[4],triangle_coord_1[5]);
		  Point t1p3=new Point(triangle_coord_1[6],triangle_coord_1[7],triangle_coord_1[8]);
		  Edge t1e1=new Edge(t1p1,t1p2);
		  Edge t1e2=new Edge(t1p2,t1p3);
		  Edge t1e3=new Edge(t1p3,t1p1);
		  Point t2p1=new Point(triangle_coord_2[0],triangle_coord_2[1],triangle_coord_2[2]);
		  Point t2p2=new Point(triangle_coord_2[3],triangle_coord_2[4],triangle_coord_2[5]);
		  Point t2p3=new Point(triangle_coord_2[6],triangle_coord_2[7],triangle_coord_2[8]);
		  Edge t2e1=new Edge(t1p1,t1p2);
		  Edge t2e2=new Edge(t1p2,t1p3);
		  Edge t2e3=new Edge(t1p3,t1p1);
		  Triangle t1=new Triangle(t1p1,t1p2,t1p3,t1e1,t1e2,t1e3);
		  Triangle t2=new Triangle(t2p1,t2p2,t2p3,t2e1,t2e2,t2e3);
		  Triangle to_find=null;
		  boolean found=false;
		  Iterator2<Triangle> iterator_outer=triangles.positions();
		  while(iterator_outer.hasNext() && found==false)
		  {
			  Triangle t=iterator_outer.next().value();
			  if(t1.equals(t)==false && t2.equals(t)==false)
				  continue;
			  else if(t.equals(t1))
			  {
				  found1=true;
				  to_find=t2;
				  visited_nodes[t.name-1]=true;
			  }
			  else if(t.equals(t2))
			  {
				  found2=true;
				  visited_nodes[t.name-1]=true;
				  to_find=t1;
			  }
			  found=isConnected_rec(t,to_find);
			  
		  }
		  if(found1==false && found2==false)
			  return false;
		  return found;
	  }
	  public boolean isConnected_rec(Triangle known,Triangle unknown)
	  {
		  Iterator2<Triangle> iterator_inner=known.triangles_connected.positions();
		  while(iterator_inner.hasNext())
		  {
			  Triangle temp=iterator_inner.next().value();
			  if(visited_nodes[temp.name-1]==false)
			  {
				  if(temp.equals(unknown))
				  {
					  return true;
				  }
				  visited_nodes[temp.name-1]=true;
				  return isConnected_rec(temp,unknown);
			  }
		  }
		  return false;
	  }


	// INPUT [x1,y1,z1,x2,y2,z2] // where (x1,y1,z1) refers to first end point of edge and  (x2,y2,z2) refers to the second.
	  public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates){ 
		  
		  Point p1=new Point(edge_coordinates[0],edge_coordinates[1],edge_coordinates[2]);
		  Point p2=new Point(edge_coordinates[3],edge_coordinates[4],edge_coordinates[5]);
		  Edge e1=new Edge(p1,p2);
		  Edge e=edges.search(e1).obj;
		  TriangleInterface[] edge_neighbors=new TriangleInterface[e.connected_triangles];
		  int j=0;
		  Iterator2<Triangle> iterator=e.triangles_connected.positions();
		  while(iterator.hasNext() && j< edge_neighbors.length)
		  {
			edge_neighbors[j]=iterator.next().value();
			j=j+1;
		  }
		  if(j==0)
			  return null;
		  return edge_neighbors;
		  
		  
	  }


	  boolean max_dia;
	  int max_t1_temp;
	  int dist;
	  int[] t1_distances;
	  int max;
	  public int MAXIMUM_DIAMETER(){
		  
		  int max_dist=0;
		  if(this.count_connected_check==true && triangle_added==false)
		  {
			  
			  //safe
		  }
		  else
		  {
			  max=0;
			  max_dia=true;
			  max_t1_temp=0;
			  dist=0;
			  connected_components=new LinkedList<connectedComponentNode>();
//			  int max=0;
//			  int max_dist=0;
			  component=new LinkedList<Triangle>();
			  //connected_components.head=new LinkedList();
			  size_of_component=0;
		  
		 
			  count_connected=0;
			  visited_marks=new boolean[this.count_triangles];
			  Iterator2<Triangle> iterator_main=triangles.positions();
			  while(iterator_main.hasNext())
			  {
				  component=new LinkedList<Triangle>();
				  Triangle t_outer=iterator_main.next().value();
				  if(visited_marks[t_outer.name-1]==false)
				  {
					  component.add(t_outer);
					  count_connected=count_connected+1;
					  visited_marks[t_outer.name-1]=true;
					  size_of_component=1;
					  count_connected_rec(t_outer);
					  if(max<size_of_component)
						  max=size_of_component;
					  connectedComponentNode n= new connectedComponentNode(max,component);
					  connected_components.add(n);
				  }
				  
			  }
		  }
			  Iterator2<connectedComponentNode> iterate_components=connected_components.positions();
			  LinkedList<Triangle> max_component=new LinkedList<Triangle>();
			  while(iterate_components.hasNext())
			  {
				  connectedComponentNode n=iterate_components.next().value();
				  if(n.number==max)
				  {
					  max_component=n.list;
					  break;
					  
				  }
			  }
			  
			  Iterator2<Triangle> iter1=triangles.positions();
			  int[] max_shortest_distances=new int[this.count_triangles];
			  while(iter1.hasNext())
			  {
				  t1_distances=new int[this.count_triangles];
				  Triangle t1=iter1.next().value();
				  Iterator2<Triangle> iter2=t1.triangles_connected.positions();
				  int dist=1;
				  max_t1_temp=dist;
				  t1_distances[t1.name-1]=dist;
				  while(iter2.hasNext())
				  {
					  Triangle t2=iter2.next().value();
					  //dist=dist+1;
					  t1_distances[t2.name-1]=dist;
					  if(max_t1_temp<dist)
						  max_t1_temp=dist;
					 // max_t1_temp=dist;
					  find_shortest_rec(t2,dist+1,t1);
				  }
				  max_t1_temp=0;
				  for(int i=0;i<t1_distances.length;i++)
				  {
					  if(t1_distances[i]>max_t1_temp)
						  max_t1_temp=t1_distances[i];
				  }
				  max_shortest_distances[t1.name-1]=max_t1_temp;			  
			}
			  
			  Iterator2<Triangle> iter=triangles.positions();
			  for(int i=0;i<count_triangles;i++)
			  {
				  Triangle t=iter.next().value();
				 // System.out.println(iter.next().toString()+" "+i);
				  //System.out.println(max_shortest_distances[i]);
				  if(max_shortest_distances[i]>max_dist && max_component.contains(t))
				  {
					  max_dist=max_shortest_distances[i];
				  }
					  
			  }
		  //}
		  
			  triangle_added=false;
			  return max_dist;
			  

}
	  public void find_shortest_rec(Triangle t,int distance,Triangle t1)
	  {
		  Iterator2<Triangle> iterator=t.triangles_connected.positions();
		  while(iterator.hasNext())
		  {
			  Triangle temp=iterator.next().value();
			  //dist=dist+1;
			  if(temp.equals(t1)==false &&(t1_distances[temp.name-1]==0 || distance<t1_distances[temp.name-1]))
			  {
				  if(max_t1_temp<distance)
					  max_t1_temp=distance;
				  t1_distances[temp.name-1]=distance;
				  find_shortest_rec(temp,distance+1,t1);
			  }
		  }
	  }
	  boolean[] visited_node_centroid;
	  int point_number;
	  float centroid_x,centroid_y,centroid_z;
	 
	  
	  public PointInterface [] CENTROID (){
		  //System.out.println("entered");
		  CentroidNode[] centroids=new CentroidNode[this.count_triangles];
		  int j=0;
			  //count_connected=0;
			  visited_node_centroid=new boolean[count_points];
			  centroid_x=0;
			  centroid_y=0;
			  centroid_z=0;
			  point_number=0;
			  Iterator2<Triangle> iterator_main=triangles.positions();
			  while(iterator_main.hasNext())
			  {
				  
				  Triangle t_outer=iterator_main.next().value();
				  //System.out.println("ith triangle="+ t_outer.name+" "+ t_outer.points[0].name+" "+t_outer.points[1].name+" "+t_outer.points[2].name);
				  centroid_x=0;
				  centroid_y=0;
				  centroid_z=0;
				  point_number=0;
				  if(visited_node_centroid[t_outer.points[0].name-1]==true && visited_node_centroid[t_outer.points[1].name-1]==true &&visited_node_centroid[t_outer.points[2].name-1]==true)
					  continue;
				  else
				  {
					  if(visited_node_centroid[t_outer.points[0].name-1]==false)
					  {
						  //count_connected=count_connected+1;
						  centroid_x=centroid_x+t_outer.points[0].x;
						  centroid_y=centroid_y+t_outer.points[0].y;
						  centroid_z=centroid_z+t_outer.points[0].z;
						  visited_node_centroid[t_outer.points[0].name-1]=true;
						  point_number=point_number+1;
					  }
					  if(visited_node_centroid[t_outer.points[1].name-1]==false)
					  {
						  centroid_x=centroid_x+t_outer.points[1].x;
						  centroid_y=centroid_y+t_outer.points[1].y;
						  centroid_z=centroid_z+t_outer.points[1].z;
						  visited_node_centroid[t_outer.points[1].name-1]=true;
						  point_number=point_number+1;
					  }
					  if(visited_node_centroid[t_outer.points[2].name-1]==false)
					  {
						  //count_connected=count_connected+1;
						  centroid_x=centroid_x+t_outer.points[2].x;
						  centroid_y=centroid_y+t_outer.points[2].y;
						  centroid_z=centroid_z+t_outer.points[2].z;
						  visited_node_centroid[t_outer.points[2].name-1]=true;
						  point_number=point_number+1;
					  }
					  calc_centroid(t_outer);
					  centroid_x=(centroid_x/(point_number));
					  centroid_y=(centroid_y/point_number);
					  centroid_z=(centroid_z/point_number);
					  CentroidNode n=new CentroidNode(point_number,centroid_x,centroid_y,centroid_z);
					  centroids[j]=n;
					  j=j+1;
				  }
			  }
			  PointInterface[] answer=new PointInterface[j];
			  for(int i=0;i<j;i++)
			  {
				  Point p=new Point(centroids[i].x,centroids[i].y,centroids[i].z);
				  answer[i]=p;
			  }
			 return answer; 
	}
	  public void calc_centroid(Triangle t)
	  {
		  Iterator2<Triangle> iterator_inner=t.triangles_connected.positions();
		  while(iterator_inner.hasNext())
		  {
			  Triangle temp=iterator_inner.next().value();
			 // System.out.println(temp.points[0].name+" "+temp.points[0]);
			 // System.out.println(visited_node_centroid[temp.points[0].name-1]==true && visited_node_centroid[temp.points[1].name-1]==true &&visited_node_centroid[temp.points[2].name-1]==true);
			  if(visited_node_centroid[temp.points[0].name-1]==true && visited_node_centroid[temp.points[1].name-1]==true &&visited_node_centroid[temp.points[2].name-1]==true)
				  continue;
			  else
			  {
				  if(visited_node_centroid[temp.points[0].name-1]==false)
				  {
					  //count_connected=count_connected+1;
					  centroid_x=centroid_x+temp.points[0].x;
					  centroid_y=centroid_y+temp.points[0].y;
					  centroid_z=centroid_z+temp.points[0].z;
					  visited_node_centroid[temp.points[0].name-1]=true;
					  point_number=point_number+1;
				  }
				  if(visited_node_centroid[temp.points[1].name-1]==false)
				  {
					  centroid_x=centroid_x+temp.points[1].x;
					  centroid_y=centroid_y+temp.points[1].y;
					  centroid_z=centroid_z+temp.points[1].z;
					  visited_node_centroid[temp.points[1].name-1]=true;
					  point_number=point_number+1;

				  }
				  if(visited_node_centroid[temp.points[2].name-1]==false)
				  {
					  //count_connected=count_connected+1;
					  centroid_x=centroid_x+temp.points[2].x;
					  centroid_y=centroid_y+temp.points[2].y;
					  centroid_z=centroid_z+temp.points[2].z;
					  visited_node_centroid[temp.points[2].name-1]=true;
					  point_number=point_number+1;

				  }
				  
				  calc_centroid(temp);
		  }
	  }
	  }

	
	  // INPUT [x,y,z]
	  public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates){
		  Point p=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
		  int hashvalue=(int)djb2(Float.toString(p.sum));
		  Point p1=this.points[hashvalue].extract(p);
		  Iterator2<Triangle> travel=p1.triangles_connected.positions();
		  Triangle t_outer=travel.next().value();
		  visited_node_centroid=new boolean[count_points];
		  //System.out.println(points[hashvalue].head.value().name);
			  //System.out.println("ith triangle="+ t_outer.name+" "+ t_outer.points[0].name+" "+t_outer.points[1].name+" "+t_outer.points[2].name);
			  centroid_x=0;
			  centroid_y=0;
			  centroid_z=0;
			  point_number=0;
					  //count_connected=count_connected+1;
					  centroid_x=centroid_x+t_outer.points[0].x;
					  centroid_y=centroid_y+t_outer.points[0].y;
					  centroid_z=centroid_z+t_outer.points[0].z;
					  visited_node_centroid[t_outer.points[0].name-1]=true;
					  point_number=point_number+1;
				  
				  
					  centroid_x=centroid_x+t_outer.points[1].x;
					  centroid_y=centroid_y+t_outer.points[1].y;
					  centroid_z=centroid_z+t_outer.points[1].z;
					  visited_node_centroid[t_outer.points[1].name-1]=true;
					  point_number=point_number+1;
				  
					  //count_connected=count_connected+1;
					  centroid_x=centroid_x+t_outer.points[2].x;
					  centroid_y=centroid_y+t_outer.points[2].y;
					  centroid_z=centroid_z+t_outer.points[2].z;
					  visited_node_centroid[t_outer.points[2].name-1]=true;
					  point_number=point_number+1;
				  calc_centroid(t_outer);
				  centroid_x=(centroid_x/(point_number));
				  centroid_y=(centroid_y/point_number);
				  centroid_z=(centroid_z/point_number);
			  
		  PointInterface centroid=new Point(centroid_x,centroid_y,centroid_z);
		  
	return centroid;
	}

	  boolean visited_triangles[];
	  //int shortest_distance[];
	 // int component_wise_shortest_distance[];
	  float current_shortest;
	  LinkedList<Triangle> list;
	  //int shortest;
	  PointInterface[] shortest_pair1=new PointInterface[2];
	  
	  public 	PointInterface [] CLOSEST_COMPONENTS(){
		  
		  LinkedList<LinkedList<Triangle>> all_components=new LinkedList<LinkedList<Triangle>>();		//find it
		  visited_triangles=new boolean[count_triangles];
		  //int[] shortest_distance=new int[count_points];
		  //component_wise_shortest_distance=new int[all_components.size];
		  current_shortest=Integer.MAX_VALUE;
		  int j=0;
		 // count_connected_check=true;				//it counts again only if a new triangle was added.. else returns the earlier calc value
		  //connected_components=new LinkedList();
		  //int max=0;
		  list=new LinkedList<Triangle>();
		  //connected_components.head=new LinkedList();
		  //size_of_component=0;
		  //max=0;
		  
			  //count_connected=0;
			  //visited_marks=new boolean[this.count_triangles];
			  Iterator2<Triangle> iterator_main=triangles.positions();
			  while(iterator_main.hasNext())
			  {
				  Triangle t_outer=iterator_main.next().value();
				  list=new LinkedList<Triangle>();
				  if(visited_triangles[t_outer.name-1]==false)
				  {
					  list.add(t_outer);
					  //count_connected=count_connected+1;
					  visited_triangles[t_outer.name-1]=true;
					  //size_of_component=1;
					  closest_rec(t_outer);
//					  if(max<size_of_component)
//						  max=size_of_component;
					 // connectedComponentNode n= new connectedComponentNode2(component);
					  all_components.add(list);
				  }
				  
			  }
//			  Iterator2<LinkedList<Triangle>> travel=all_components.positions();
//			  while(travel.hasNext())
//			  {
//				  Iterator2<Triangle> travel_inside=travel.next().value().positions();
//				  while(travel_inside.hasNext())
//				  {
//					  System.out.print(travel_inside.next().value());
//				  }
//				  System.out.println();
//			  }
//			 
		  Iterator2<LinkedList<Triangle>> for_components=all_components.positions();
		  while(for_components.hasNext())
		  {
			  LinkedList<Triangle> component1=for_components.next().value();
			  j=j+1;
			  Iterator2<LinkedList<Triangle>> iter1=all_components.positions();
			  int k=0;
			  while(iter1.hasNext()&& k<j)
			  {
				  LinkedList<Triangle> component2=iter1.next().value();
				  k=k+1;
			  }
			  while(iter1.hasNext())
			  {
				  Iterator2<Triangle> iterator=component1.positions();
				  LinkedList<Triangle > component2=iter1.next().value();
				  while(iterator.hasNext())
				  {
					  Triangle t1=iterator.next().value();
					  Iterator2<Triangle> iter2=component2.positions();
					  while(iter2.hasNext())
					  {
						  Triangle t2=iter2.next().value();
						  if(current_shortest==0)
							  return shortest_pair1;
						  shortest_pair1=calc_shortest(t1,t2);			//actually giving shortest between t1 and component2
						  
					  }
				  }
			  }
		  }
		  return shortest_pair1;
  }
  public void closest_rec(Triangle t)
  {
	  Iterator2<Triangle> iterator_inner=t.triangles_connected.positions();
	  while(iterator_inner.hasNext())
	  {
		  Triangle temp=iterator_inner.next().value();
		  if(visited_triangles[temp.name-1]==false)
		  {
			  list.add(temp);
			  //size_of_component=size_of_component+1;
			  visited_triangles[temp.name-1]=true;
			  closest_rec(temp);
		  }
	  }
  }
	  public PointInterface[] calc_shortest(Triangle t1,Triangle t2)
	  {
		  Edge[] cross_edges=new Edge[9];
		  int k=0;
		  for(int i=0;i<3;i++)
		  {
			  for(int j=0;j<3;j++)
			  {
				  Edge e1=new Edge(t1.points[i],t2.points[j]);
				  cross_edges[k]=e1;
				  k=k+1;
			  }
		  }
		  for(int i=0;i<9;i++)
		  {
			  if(cross_edges[i].edge_length<current_shortest)
			  {
				  current_shortest=cross_edges[i].edge_length;
				  shortest_pair1=cross_edges[i].points;
			  }
		  }
		  return shortest_pair1;
	  }

}
