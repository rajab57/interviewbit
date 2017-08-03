/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
**/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int hasPathSum(TreeNode a, int b) {
	    boolean result = hasPathSumInternal(a, b);
	    return ( result ? 1 : 0);
	    
	}
	
	public boolean hasPathSumInternal(TreeNode a, int sum) {
	    if (a == null) 
	        return false;
	    boolean result = false;
	    int subsum = sum - a.val;
	    if (subsum == 0 && a.left == null && a.right == null)
	        return true;
	    result = result || hasPathSumInternal(a.left, subsum);
	    result = result || hasPathSumInternal(a.right, subsum);
	    return result;
	}
}
