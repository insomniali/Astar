package main;

public class MainTest {
	  public static void main(String[] args) { 
		    Map map = new Map(); 
		    AStar aStar = new AStar(); 
		    map.ShowMap(); 
		    aStar.search(map); 
		    System.out.println("经过A*算法寻路:"); 
		    map.ShowMap();  
		  } 
}
