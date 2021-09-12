/******************************************************************************

      Video explanation : http://bit.ly/Twingworld
      
*******************************************************************************/

public class BooleanMatrix
{
	public static void main(String[] args) {
	    int mat[][]={{1,0,0},{0,0,0},{0,1,0}};
	    int r=3;
	    int c=3;
		new BooleanMatrix().optimal2(mat,r,c);
		
		for(int i=0;i<r;i++){
		    for(int j=0;j<c;j++)
		        System.out.print(mat[i][j]);
	        System.out.println();
		}
	}
	
	public void bruteForce(int[][] mat,int r,int c){
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            if(mat[i][j]==1){
	                for(int row=0;row<r;row++)
	                    mat[row][j]=-1;
	                for(int col=0;col<c;col++)
	                    mat[i][col]=-1;
	            }
	        }
	    }
	    
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            if(mat[i][j]==-1)
	                mat[i][j]=1;
	        }
	    }
	}
	
	public void optimal1(int[][] mat,int r,int c){
	    int[] rows=new int[r];
	    int[] cols=new int[c];
	    
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            if(mat[i][j]==1){
	                rows[i]=1;
	                cols[j]=1;
	            }
	        }
	    }
	    
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            if(rows[i]==1 || cols[j]==1)
	                mat[i][j]=1;
	        }
	    }
	}
	
	public void optimal2(int[][] mat,int r,int c){
	    boolean row=false,col=false;
	    for(int i=0;i<r;i++)
	        if(mat[0][i]==1){
	            row=true;
	            break;
	        }
	    for(int i=0;i<c;i++)
	        if(mat[i][0]==1){
	            col=true;
	            break;
	        }
	        
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(mat[i][j]==1)
                    mat[i][0]=mat[0][j]=1;
            }
        }
        
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(mat[i][0]==1 || mat[0][j]==1)
                    mat[i][j]=1;
            }
        }
        
        if(row)
            for(int i=0;i<r;i++)
                mat[0][i]=1;    
        if(col)
            for(int i=0;i<c;i++)
                mat[i][0]=1;            
	}
}
