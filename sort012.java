// ----------------------------------------------------
// for video explanation : http://bit.ly/Twingworld
//-----------------------------------------------------

import java.util.*;
public class sort012
{
	public static void main(String[] args) {
	        int arr[]={1,1,2,2,0,1,2,0,0,2};
	        new sort012().optimal2(arr,arr.length);
	        for(int i=0;i<arr.length;i++)
	                System.out.print(arr[i]+" ");
	}
	
	public void bruteForce(int arr[],int n)
	{
            Arrays.sort(arr);
	}
	public void optimal1(int arr[],int n)
	{
	    int zeroCount=0;
	    int oneCount=0;
	    int twoCount=0;
	    for(int i=0;i<n;i++)
	    {
	        switch(arr[i]){
	            case 0 : zeroCount++;break;
	            case 1 : oneCount++;break;
	            case 2 : twoCount++;break;
	        }
	    }
	    
	    int i=0;
	    while(i<zeroCount)
	        arr[i++]=0;
        while(i<zeroCount+oneCount)
            arr[i++]=1;
        while(i<n)
            arr[i++]=2;
	        
	}
	
	public void optimal2(int arr[],int n)
	{
	    int first=0;
	    int mid=0;
	    int last=n-1;
	    while(mid<=last)
	    {
	        if(arr[mid]==1)
	            mid++;
            else if(arr[mid]==0){
                int temp=arr[mid];
                arr[mid]=arr[first];
                arr[first]=temp;
                first++;
            }
            else{
                int temp=arr[mid];
                arr[mid]=arr[last];
                arr[last]=temp;
                last--;
            }
            
	    }
	}

	
}
