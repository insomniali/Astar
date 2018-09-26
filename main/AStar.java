package main;


import java.util.ArrayList;

public class AStar {
	 
	    ArrayList<Node> open = new ArrayList<Node>();
	    ArrayList<Node> close = new ArrayList<Node>();
	  
	    public double getHValue(Node currentNode,Node endNode){
	        return (Math.abs(currentNode.getX() - endNode.getX()) + Math.abs(currentNode.getY() - endNode.getY()));
	    }
	  
	    public double getGValue(Node currentNode){
	        if(currentNode.getPNode()!=null){
	            if(currentNode.getX()==currentNode.getPNode().getX()||currentNode.getY()==currentNode.getPNode().getY()){
	                //判断当前节点与其父节点之间的位置关系（水平？对角线） 
	                return currentNode.getGValue()+1;
	            }
	            return currentNode.getGValue()+2;
	        }
	        return currentNode.getGValue();
	    }

	    public double getFValue(Node currentNode){
	        return currentNode.getGValue()+currentNode.getHValue();
	    }

	    public void putOpen(Node node,Map map){
	        int x = node.getX();
	        int y = node.getY();
	       
	        if(map.getMap()[x][y-1].isReachable()&&!open.contains(map.getMap()[x][y-1])) {
	        	 map.getMap()[x][y-1].setPNode(map.getMap()[x][y]);
                 //将选中节点作为父节点 
                 map.getMap()[x][y-1].setGValue(getGValue(map.getMap()[x][y-1]));
                 map.getMap()[x][y-1].setHValue(getHValue(map.getMap()[x][y-1],map.getEndNode()));
                 map.getMap()[x][y-1].setFValue(getFValue(map.getMap()[x][y-1]));
                 open.add(map.getMap()[x][y-1]);
	        }
	        if(map.getMap()[x][y+1].isReachable()&&!open.contains(map.getMap()[x][y+1])) {
	        	 map.getMap()[x][y+1].setPNode(map.getMap()[x][y]);
                //将选中节点作为父节点 
                map.getMap()[x][y+1].setGValue(getGValue(map.getMap()[x][y+1]));
                map.getMap()[x][y+1].setHValue(getHValue(map.getMap()[x][y+1],map.getEndNode()));
                map.getMap()[x][y+1].setFValue(getFValue(map.getMap()[x][y+1]));
                open.add(map.getMap()[x][y+1]);
	        }
	        if(map.getMap()[x-1][y].isReachable()&&!open.contains(map.getMap()[x-1][y])) {
	        	 map.getMap()[x-1][y].setPNode(map.getMap()[x][y]);
                //将选中节点作为父节点 
                map.getMap()[x-1][y].setGValue(getGValue(map.getMap()[x-1][y]));
                map.getMap()[x-1][y].setHValue(getHValue(map.getMap()[x-1][y],map.getEndNode()));
                map.getMap()[x-1][y].setFValue(getFValue(map.getMap()[x-1][y]));
                open.add(map.getMap()[x-1][y]);
	        }
	        if(map.getMap()[x+1][y].isReachable()&&!open.contains(map.getMap()[x+1][y])) {
	        	 map.getMap()[x+1][y].setPNode(map.getMap()[x][y]);
               //将选中节点作为父节点 
               map.getMap()[x+1][y].setGValue(getGValue(map.getMap()[x+1][y]));
               map.getMap()[x+1][y].setHValue(getHValue(map.getMap()[x+1][y],map.getEndNode()));
               map.getMap()[x+1][y].setFValue(getFValue(map.getMap()[x+1][y]));
               open.add(map.getMap()[x+1][y]);
	        }
	    }

	    public void sort(ArrayList<Node> arr){
	        for (int i = 0;i<arr.size()-1;i++){
	            for (int j = i+1;j<arr.size();j++){
	                if(arr.get(i).getFValue() > arr.get(j).getFValue()){
	                    Node tmp = new Node();
	                    tmp = arr.get(i);
	                    arr.set(i, arr.get(j));
	                    arr.set(j, tmp);
	                }
	            }
	        }
	    }

	    public void putClose(Node node,ArrayList<Node> open){
	        if(open.contains(node)){
	            node.setReachable(false);
	            //设置为不可达 
	            open.remove(node);
	            close.add(node);
	        }
	    }
	    
	    public void search(Map map){
	        //对起点及起点周围的节点进行操作 
	        putOpen(map.getMap()[map.startNode.x][map.startNode.y],map);
	        close.add(map.getMap()[map.startNode.x][map.startNode.y]);
	        map.getMap()[map.startNode.x][map.startNode.y].setReachable(false);
	        map.getMap()[map.startNode.x][map.startNode.y].setPNode(map.getMap()[map.startNode.x][map.startNode.y]);
	        sort(open); 
	        do{
	            putOpen(open.get(0), map);
	            putClose(open.get(0), open);
	            sort(open);
	        }
	        while((!open.contains(map.getMap()[map.startNode.x][map.startNode.y]))&&!(open.isEmpty()));
	        //知道open表中包含终点时或open表为空，循环退出 
	        putClose(map.getMap()[map.startNode.x][map.startNode.y], open);
	        showPath(close,map);
	    }

	    public void showPath(ArrayList<Node> arr,Map map) {
	        if(arr.size()>0){
	            Node node = new Node();
	            node = map.getMap()[map.getEndNode().getX()][map.getEndNode().getY()]; 
	            while(!(node.getX() ==map.getStartNode().getX()&&node.getY() ==map.getStartNode().getY())){ 
	        	    node.getPNode().setValue("*"); 
	        	    node = node.getPNode(); 
	        }
	            map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()].setValue("S");
	    }
}
}
