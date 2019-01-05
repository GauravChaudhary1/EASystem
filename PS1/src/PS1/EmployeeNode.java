package PS1;

public class EmployeeNode<T extends Comparable<T>> {
	T empId; 
	int attCount;	
	protected EmployeeNode<T> left, right;
	
	
	/* Constructor */
    
    public EmployeeNode(T id)
    {
        left = null;
        right = null;
        empId = id;
        attCount=1;
    }
    
    EmployeeNode<T> getRightTree(EmployeeNode<T> p){
    	return p.right;
    }
    
    EmployeeNode<T> getLeftTree(EmployeeNode<T> p){
    	return p.left;
    }
    
    EmployeeNode<T> search(EmployeeNode<T> p, T data){
    	if (p == null)
            return null;
         else
         if (data.compareTo(p.empId) == 0){        	
         	return p;
         }
         else
         if (data.compareTo(p.empId) < 0)
            return search(p.left, data);
         else
            return search(p.right, data);
    }
    
    int getCount(){
    	return this.attCount;
    }
    
    T getEmpId(){
    	return this.empId;
    }
    
    
    
    
}
