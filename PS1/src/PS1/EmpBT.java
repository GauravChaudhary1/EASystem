package PS1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmpBT<T extends Comparable<T>> {
	EmployeeNode<T> root, freq;
	int count = 0, max=0;	
    public EmployeeNode<T> getRoot() {
        return this.root;
    }
    
    public void add(T data) {
    	if(!(increaseCount(this.getRoot(), data))){
        EmployeeNode<T> newNode = new EmployeeNode<T>(data);
        if (root == null) {
            root = newNode;
        } else {
            EmployeeNode<T> tempNode = root;
            EmployeeNode<T> prev = null;
            while (tempNode != null) {
                prev = tempNode;
                if (data.compareTo(tempNode.empId) > 0) {
                    tempNode = tempNode.right;
                } else {
                    tempNode = tempNode.left;
                }
            }
            if (data.compareTo(prev.empId) < 0) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }

        }
    	}
    }
    public boolean increaseCount(EmployeeNode<T> p, T data){
    	if (p == null)
            return false;
         else
         if (data.compareTo(p.empId) == 0){
        	p.attCount++; 
         	return true;
         }
         else
         if (data.compareTo(p.empId) < 0)
            return increaseCount(p.left, data);
         else
            return increaseCount(p.right, data);    	
    }
    
    int getHeadCount(EmployeeNode<T> root){    	    	
    	if(root==null){
            return count;
            }
            count++;
            count=getHeadCount(root.left);
            count=getHeadCount(root.right);
            return count;
    }       
    
    boolean searchID(EmployeeNode<T> p, T data){
    	if(p.search(p, data) == null){
    		return false;
    	}else
    		return true;
    }
    
    int howOften(T data){
    	EmployeeNode<T> p = this.getRoot();     	
    	p = p.search(p, data);
    	if(p == null){
    		return 0;
    	}else
    		if(p.attCount % 2 == 0)
    			return (p.attCount / 2);
    		else
    			return (p.attCount / 2) + 1;
    }
    
    private void getMaximum(EmployeeNode<T> p){
    	
        if (p != null){
       	 if (p.attCount >= max)
       	 {        	
		         	max = p.attCount;
		         	freq = p;		     		        	
		  }
       	getMaximum(p.left);
     	getMaximum(p.right);
	   }
   }
    
   boolean inOffice(T data){
    	EmployeeNode<T> p = this.getRoot();     	
    	p = p.search(p, data);
    	if(p == null){
    		return false;
    	}else
    		if(p.attCount % 2 == 0)
    			return false;
    		else
    			return true;
    }
   
    EmployeeNode<T> frequentVisitor(EmployeeNode<T> emp){
    	this.getMaximum(emp);
    	return freq;
    }
    
    
    public void printRangePresent(EmployeeNode<T> emp, T id1, T id2) throws IOException {
    	String sPath = "C:\\Users\\i330087\\Desktop\\M.Tech\\Semester 1\\DSA\\output.txt";
    	BufferedWriter writer = new BufferedWriter(new FileWriter(sPath));
   	 
    	writeNode(emp,id1,id2,writer);
        writer.close();
        System.out.println("Data is printed in file located at : " + sPath);
    }
    
    private void writeNode( EmployeeNode<T> p, T id1, T id2, BufferedWriter writer) throws IOException{
    	 
         if (p != null){
           	 if (id1.compareTo(p.empId) == 0 || id2.compareTo(p.empId) == 0 )
           	 {        	           		           		            		
           		 writer.write((Integer) p.getEmpId() + " , " + p.attCount);
           		 writer.newLine();
    		 } else if( id1.compareTo(p.empId) < 0 && id2.compareTo(p.empId) > 0){
    			 writer.write((Integer) p.getEmpId() + " , " + p.attCount);
           		 writer.newLine();
    		 }
           	writeNode(p.left,id1,id2,writer);
         	writeNode(p.right,id1,id2,writer);
    	   }
       
    }
    
}
