package main;


public class Node {
	
	
	  public int x;  
	  public int y;  
	  public String value;  //��ʾ�ڵ��ֵ 
	  public double FValue = 0; //Fֵ 
	  public double GValue = 0; //Gֵ 
	  public double HValue = 0; //Hֵ 
	  public boolean Reachable; 
	  public Node PNode;   //���ڵ� 
	    
	  public Node(int x, int y, String value, boolean reachable) { 
	    super(); 
	    this.x = x; 
	    this.y = y; 
	    this.value = value; 
	    Reachable = reachable; 
	  } 
	    
	  public Node() { 
	    super(); 
	  } 
	  
	  public int getX() { 
	    return x; 
	  } 
	  
	  public void setX(int x) { 
	    this.x = x; 
	  } 
	 
	  public int getY() { 
	    return y; 
	  } 
	  
	  public void setY(int y) { 
	    this.y = y; 
	  } 
	  
	  public String getValue() { 
	    return value; 
	  } 
	  
	  public void setValue(String value) { 
	    this.value = value; 
	  } 
	  
	  public double getFValue() { 
	    return FValue; 
	  } 
	  
	  public void setFValue(double fValue) { 
	    FValue = fValue; 
	  } 
	  
	  public double getGValue() { 
	    return GValue; 
	  } 
	  
	  public void setGValue(double gValue) { 
	    GValue = gValue; 
	  } 
	  
	  public double getHValue() { 
	    return HValue; 
	  } 
	  
	  public void setHValue(double hValue) { 
	    HValue = hValue; 
	  } 
	  
	  public boolean isReachable() { 
	    return Reachable; 
	  } 
	  
	  public void setReachable(boolean reachable) { 
	    Reachable = reachable; 
	  } 
	  
	  public Node getPNode() { 
	    return PNode; 
	  } 
	  
	  public void setPNode(Node pNode) { 
	    PNode = pNode; 
	  }   
}
