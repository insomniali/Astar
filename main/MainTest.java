package main;

public class MainTest {
	  public static void main(String[] args) { 
		    Map map = new Map(); 
		    AStar aStar = new AStar(); 
		    map.ShowMap(); 
		    aStar.search(map); 
		    System.out.println("����A*�㷨Ѱ·:"); 
		    map.ShowMap();  
		  } 
}
