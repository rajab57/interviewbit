/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
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
    
    HashMap<Integer, Integer> inOrderLoc = new HashMap<>();
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
	   
	    if (postorder == null || inorder == null || postorder.isEmpty() || inorder.isEmpty()
	                || (postorder.size() != inorder.size())) return null;
	   for ( int i = 0; i < inorder.size(); ++i) {
	            inOrderLoc.put(inorder.get(i), i);
	    }
	    return buildTreeInternal(postorder, 0, postorder.size()-1, inorder, 0, inorder.size()-1);
	}
	
	public TreeNode buildTreeInternal(ArrayList<Integer> postorder, 
	                int postStart, int postEnd, 
	                ArrayList<Integer> inorder,
	                int inStart, int inEnd) {
	    if (postStart > postEnd || inStart > inEnd) { return null; }
	    int val = postorder.get(postEnd);
	    TreeNode node = new TreeNode(val);
	    
	    // Find the position of this val in in-order list
	    int k = inOrderLoc.get(val);
	    
	    node.left = buildTreeInternal(postorder, postStart, postStart + k - (inStart + 1), 
	                                  inorder, inStart , k-1 );
	    node.right = buildTreeInternal(postorder, postStart + k-inStart , postEnd-1,
	                                   inorder, k+1, inEnd);
	    return node; 
    }
}

