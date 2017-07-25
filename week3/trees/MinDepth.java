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
	public int minDepth(TreeNode a) {
	    if ( a == null ) return 0;
	    // leaf node
	    if ( a.left == null && a.right == null ) return 1;
	    if (a.left == null) return (minDepth(a.right))+1;
	    if (a.right == null) return (minDepth(a.left))+1;
	    return Math.min(minDepth(a.left), minDepth(a.right)) +1;
	}
}

