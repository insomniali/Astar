package main;


import java.util.Scanner;

public class Map {
	private Node[] []map;
	    //节点数组 
	    public Node startNode;
	    //起点 
	    public Node endNode;
	    //目标点 
	    public Map() {
	        map = new Node[9][9];
	        for (int i = 0;i<9;i++){
	            for (int j = 0;j<9;j++){
	                map[i][j] = new Node(i,j,".",true);
	            }
	        }
	        for(int h = 0;h<9;h++) {
	        	for (int d = 0;d<9;d++){
	            map[0][d].setValue("0");
	            map[0][d].setReachable(false);
	            map[h][0].setValue("0");
	            map[h][0].setReachable(false);
	            map[h][8].setValue("0");
	            map[h][8].setReachable(false);
	            map[8][d].setValue("0");
	            map[8][d].setReachable(false);
	        	}
	        }
	       
	        for (int k = 1;k<=3;k++){
	            map[k+1][5].setValue("0");
	            map[k+1][5].setReachable(false);
	        }
	        for (int k = 4;k<=6;k++){
	            map[k+1][3].setValue("0");
	            map[k+1][3].setReachable(false);
	        }
		    int i;
		    int j;
		    Scanner scanx = new Scanner(System.in);

		    System.out.println("请输入起点坐标：(1<=x<=7),(1<=y<=7),(2,5),(3,5),(4,5),(4,3),(5,3),(6,3)不可用");		 

		    i = scanx.nextInt();
		    Scanner scany = new Scanner(System.in);
		    j=  scany.nextInt();
		    map[i][j].setValue("S");
		    startNode = map[i][j];


		    Scanner scanx1 = new Scanner(System.in);
		    Scanner scany1 = new Scanner(System.in);
		    System.out.println("请输入终点坐标：(1<=x<=7),(1<=y<=7),(2,5),(3,5),(4,5),(4,3),(5,3),(6,3)不可用");	
		    int a;
		    int b;
		    a = scanx.nextInt();
		    b=  scany.nextInt();
		    map[a][b].setValue("E");
		    endNode = map[a][b];
		    scanx1.close();
		    scany1.close();	
		    
		    scanx.close();
		    scany.close();
	    }
	    
	    public void ShowMap(){
	        for (int i = 0;i<9;i++){
	            for (int j = 0;j<9;j++){
	                System.out.print(map[i][j].getValue()+"     ");
	            }
	            System.out.println("\n");
	        }
	    }

	    public Node[][] getMap() {
	        return map;
	    }
	    
	    public void setMap(Node[][] map) {
	        this.map = map;
	    }
	    
	    public Node getStartNode() {
	        return startNode;
	    }
	    
	    public void setStartNode(Node startNode) {
	        this.startNode = startNode;
	    }
	    
	    public Node getEndNode() {
	        return endNode;
	    }
	    
	    public void setEndNode(Node endNode) {
	        this.endNode = endNode;
	    }
}
