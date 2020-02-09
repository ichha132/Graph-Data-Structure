1) BST implementation:- 
Takes O(logn) time to insert and search. 
Traversing takes O(n) time
n= number of nodes in a tree
2) LinkedList Implementation:-
Takes O(1) insertion time. O(n ) searching and traversing time. 
3) Hashtable :- O(1) insetion time, O(1) search time
Points are stored in a hashtable using the sum of x,y,z coordinates as a key.
Edges are stored in a BST using square of the length of edge as key.
Triangles are stored in a LinkedList

Methods :-
1) ADD_TRIANGLE:- O(p+e+t) [worst case]
p= number of points added till now
e= number of edges added till now
t= number of triangles added till now
2)type_mesh:-
O(e)
e= number of edges 
3) Boundary_Edges:-
O(e+n)
e= number of edges
n= number of bondary edges 
4)neighbors of a triangle :-
O(t) ; t= number of triangles 
5)edge neighbor of triangle :-
O(t) ; t= number of triangles
6) vertex neighbor of triangle 
O(t); t= number of triangles
7) extended neighbor of triangle :- 
O(t) ; t= number of triangles 
8) incident triangles :-
O(t) ; t= number of triangles connected to that point 
9) neighbors of points:- O(p)
p= number of points connected to this point 
10) face neighbors of triangle :- 
O(t); t= number of trinamgles connected to that point 
11) triangle neighbors of an edge :-O(t)
12) count_connected_comp:- O(t^2)... DFS; (worst case) t=number of triangles
13) is_ connected :- O(n)
n is the number of triangles touched while traversing from t1 to t2.
14) centroid :- O(t+n); t= number of trinangles (DFS)
15) centroid of component:- O(t) ; t=number of triangles in that component
16) maximum_diameter :- O(n^2)
n is the number of triangles in the component which contains maximum number of triangles.
17)closest components:- O(t^4) worst case complexity; t is the number of triangles.
All complexities are worst case