import java.util.ArrayList;

import java.util.Arrays; 

import java.io.*;
class Driver {


  public static void main(String[] args) {
	try{
       	    BufferedReader br = null;
           // br = new BufferedReader(new FileReader(args[0]));
            br = new BufferedReader(new FileReader("C:\\Users\\Ichha Rathod\\eclipse-workspace\\assignment6\\inp4.txt"));

	    ShapeInterface shape_intr = new Shape();
            String st;
            while ((st = br.readLine()) != null) {
                String[] cmd = st.split(" ");
		//System.out.println("cmd is "+ Arrays.toString(cmd));	

                if (cmd.length == 0) {
                    System.err.println("Error parsing:1 ");
                    return;
                }
                String project_name, user_name;
                Integer start_time, end_time;

                long qstart_time, qend_time;

		ArrayList<Float> inp = new ArrayList<>();
		 int firstskip=0;
		for (String val:cmd) {

			if(0==firstskip){
			firstskip++;
			continue;
			}

			inp.add(Float.parseFloat(val.trim()));
			System.out.print(val + " ");
		}
		
		//System.out.println("arguments " +Arrays.toString(input.toArray()));


		float[] input = new float[inp.size()]; 
		int k = 0;

		for (Float f : inp) {
		    input[k++] = f; 
		}
                switch (cmd[0]) {
			

		

                    case "ADD_TRIANGLE":
			//System.out.println("Add TriangleInterface ");

			shape_intr.ADD_TRIANGLE(input);
                        break;

                    case "TYPE_MESH":
			System.out.println("Checking mesh type");
			int mesh_type = shape_intr.TYPE_MESH();
			System.out.println("Mesh type " + mesh_type);
                        break;
                    case "COUNT_CONNECTED_COMPONENTS":
			System.out.println("Finding number of connected components");
			int count_connected = shape_intr.COUNT_CONNECTED_COMPONENTS();
			System.out.println("Number of connected components = "+ count_connected);
                        break;
                    case "BOUNDARY_EDGES":		
			System.out.println("Getting boundary edges");	

			 EdgeInterface [] boundary_edges= shape_intr.BOUNDARY_EDGES();
//			 if(boundary_edges==null)
//				 System.out.println("null");
//			 else {
//			 for(int i=0;i<boundary_edges.length;i++)
//				 System.out.println(boundary_edges[i]);
//			 }
                        break;
                    case "IS_CONNECTED":
			System.out.println("CHECKING IS_CONNECTED");	
			float [] triangle1 = new float[9]; 
			float [] triangle2 = new float[9]; 
			for (int i =0;i<9;i++)
			{
				triangle1[i]=input[i];
			}
			for (int i =9;i<18;i++)
			{
				triangle2[i-9]=input[i];
			}
				


			boolean is_con = shape_intr.IS_CONNECTED(triangle1, triangle2);		
			System.out.println("Is connected = " + is_con);
                        break;

                    case "NEIGHBORS_OF_POINT":
			System.out.println("FINDING NEIGHBORS_OF_POINT" );
			 PointInterface [] nbrs_of_point = shape_intr.NEIGHBORS_OF_POINT(input);
//			 for(int i=0;i<nbrs_of_point.length;i++)
//				 System.out.println(nbrs_of_point[i]);
			break;

                    case "NEIGHBORS_OF_TRIANGLE":
			System.out.println("FINDING NEIGHBORS_OF_TRIANGLE" );
			TriangleInterface[] true_triangles=shape_intr.NEIGHBORS_OF_TRIANGLE(input);
//			for(int i=0;i<true_triangles.length;i++)
//				System.out.println(true_triangles[i]);
			break;

                    case "INCIDENT_TRIANGLES":
			System.out.println("FINDING INCIDENT_TRIANGLES " );
			TriangleInterface[] incident_triangles=shape_intr.INCIDENT_TRIANGLES(input);
//			for(int i=0;i<incident_triangles.length;i++)
//				System.out.println(incident_triangles[i]);
			break;

                    case "VERTEX_NEIGHBOR_TRIANGLE":
			System.out.println("FINDING VERTEX_NEIGHBOR_TRIANGLE " );
			PointInterface[] vertex_neighbors=shape_intr.VERTEX_NEIGHBOR_TRIANGLE(input);
//			for(int i=0;i<vertex_neighbors.length;i++)
//				System.out.println(vertex_neighbors[i]);
                       	 break;

                    case "EXTENDED_NEIGHBOR_TRIANGLE":
			System.out.println(" FINDING EXTENDED_NEIGHBOR_TRIANGLE " );

			TriangleInterface [] extended_neighbor_triangle = shape_intr.EXTENDED_NEIGHBOR_TRIANGLE(input);
//			for(int i=0;i<extended_neighbor_triangle.length;i++)
//				System.out.println(extended_neighbor_triangle[i]);
			break;

	          case "MAXIMUM_DIAMETER":
			System.out.println(" Finding diameter " );
			int diameter = shape_intr.MAXIMUM_DIAMETER();
			System.out.println(diameter);

                        break;
                    case "EDGE_NEIGHBOR_TRIANGLE":
			System.out.println(" Finding   EDGE_NEIGHBOR_TRIANGLE ");
			 EdgeInterface [] edge_neighbors_of_triangle = shape_intr.EDGE_NEIGHBOR_TRIANGLE(input);
//			 for(int i=0;i<edge_neighbors_of_triangle.length;i++)
//				 System.out.println(edge_neighbors_of_triangle[i]);
                        break;

                   case "FACE_NEIGHBORS_OF_POINT":
			System.out.println(" Finding   FACE_NEIGHBORS_OF_POINT ");
			 TriangleInterface [] face_nbrs = shape_intr.FACE_NEIGHBORS_OF_POINT(input);
//			 for(int i=0;i<face_nbrs.length;i++)
//				 System.out.println(face_nbrs[i]);
                        break;



                   case "EDGE_NEIGHBORS_OF_POINT":
			System.out.println(" Finding   EDGE_NEIGHBORS_OF_POINT ");
			 EdgeInterface [] edge_nbrs = shape_intr.EDGE_NEIGHBORS_OF_POINT(input);
//			 for(int i=0;i<edge_nbrs.length;i++)
//				 System.out.println(edge_nbrs[i]);
                        break;

                    case "TRIANGLE_NEIGHBOR_OF_EDGE":
			System.out.println(" Finding TRIANGLE_NEIGHBOR_OF_EDGE ");
			 TriangleInterface [] triangle_neighbors = shape_intr.TRIANGLE_NEIGHBOR_OF_EDGE(input);
//			 for(int i=0;i<triangle_neighbors.length;i++)
//				 System.out.println(triangle_neighbors[i]);
			break;
		

	          case "CENTROID":
			System.out.println(" Finding Centroid " );
			PointInterface [] centroid_array = shape_intr.CENTROID();
			for(int i=0;i<centroid_array.length;i++)
				System.out.println(centroid_array[i]);

                        break;
                    case "CENTROID_OF_COMPONENT":
			System.out.println(" Finding CENTROID_OF_COMPONENT ");
			 PointInterface centroid_of_component = shape_intr.CENTROID_OF_COMPONENT(input);
			 System.out.println(centroid_of_component);
                        break;

                    case "CLOSEST_COMPONENTS":
			System.out.println(" Finding CLOSEST_COMPONENTS ");
			  PointInterface [] closest_vertices = shape_intr.CLOSEST_COMPONENTS();
			  System.out.println(closest_vertices[0]+" "+closest_vertices[1]);
			break;
		


	//	default :System.out.println(cmd[0] +" not found");	
	//		break;
			
                }

            }
	}
	catch(Exception e)
	{
		System.err.println("Error parsing: 2	 " +e);
	}
	

}

}
