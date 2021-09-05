
import java.util.*;
public class NextGreaterElement
{
	public static void main(String[] args) {
	    int arr[]={4,3,5,1,7};
	    NextGreaterElement obj=new NextGreaterElement();
	    obj.optimal(arr,arr.length);
	    for(int i=0;i<arr.length;i++)
	        System.out.print(arr[i]+" ");
	     
	}
	public void bruteForce(int arr[],int n)
	{
	    for(int i=0;i<n;i++)
	    {
	        boolean found=false;
	        for(int j=i+1;j<n;j++)
	        {
	            if(arr[i]<arr[j]){
	                arr[i]=arr[j];
	                found=true;
	                break;
	            }
	        }
	        if(!found)
	            arr[i]=-1;
	    }
	    	    
	        
      
	}
	public void optimal(int arr[],int n)
	{
	   Stack<Integer> stack=new Stack<>();
	   stack.push(arr[n-1]);
	   arr[n-1]=-1;
	    for(int i=n-2;i>=0;i--)
	    {
	        if(stack.peek()>arr[i]){
	            int temp=arr[i];
	            arr[i]=stack.peek();
	            stack.push(temp);
	       }
	       else
	       {
	           int temp=-1;
	           while(!stack.empty()){
	                temp=stack.peek();
	               if(temp>arr[i]) {
	                   break;
	               }
                    stack.pop();
	           }
	           stack.push(arr[i]);
	           arr[i]=temp;
	           
	       }
	           
	    }

	}
}
