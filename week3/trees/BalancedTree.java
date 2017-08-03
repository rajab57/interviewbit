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
	public int isBalanced(TreeNode a) {
	    Height h = new Height(0);
	    return (isBalancedInternal(a, h) ? 1:0);
	}
	
	private class Height {
	    int height = 0;
	    Height(int h) {
	        this.height = h;
	    }
	}
	public boolean isBalancedInternal(TreeNode a, Height height) {
	    Height lh = new Height(0);
	    Height rh = new Height(0);
	    if ( a == null ) {
	        height.height = 0;
	        return true;
	    }
	    boolean l = isBalancedInternal(a.left, lh);
	    boolean r = isBalancedInternal(a.right, rh);
	    height.height = Math.max(lh.height, rh.height) + 1;
	    if ( Math.abs(lh.height - rh.height) >= 2 ) return false;
	    else return l && r;
	    
	}
}
