import java.util.ArrayList;
public class PrettyPrint{

     public static void main(String []args){
        prettyPrintMatrix(3);
    
     }
     
     	public static ArrayList<ArrayList<Integer>> prettyPrintMatrix(int a) {
	if ( a< 0 )
		return null;	
	int n = 2 * a - 1;
        int[][] matrix = new int[n][n];
        int top = 0; 
        int left = 0;
        int bottom = n-1; 
        int right = n-1;
        while ( left <= right && top <= bottom) {
            for ( int i = top; i <= bottom; ++i ) {
                matrix[i][left] = a;
                matrix[i][right] = a;
            }
            for (int i = left; i <= right; ++i) {
                matrix[top][i] = a;
                matrix[bottom][i] = a;
            }
            left++;right--;
            top++; bottom--;
            a--;
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for ( int i = 0; i < n; ++i){
            ArrayList<Integer> col = new ArrayList<>();
            for ( int j = 0; j < n; ++j) {
                col.add(matrix[i][j]);
            }
            result.add(col);
        }
        return result;
	}
}

