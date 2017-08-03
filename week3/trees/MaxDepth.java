/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
**/
public class Solution {
	public int maxDepth(TreeNode a) {
	    if ( a == null ) return 0;
	    if (a.left == null ) return maxDepth(a.right)+1;
	    else if (a.right == null) return maxDepth(a.left)+1;
	    else return (Math.max(maxDepth(a.left), maxDepth(a.right)) +1);
	}
	
}
