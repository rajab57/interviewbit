/**
 *  Given preorder and inorder traversal of a tree, construct the binary tree.
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
	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
	    if (preorder == null || inorder == null || preorder.isEmpty() || inorder.isEmpty()
	                || (preorder.size() != inorder.size())) return null;
	   for ( int i = 0; i < inorder.size(); ++i) {
	            inOrderLoc.put(inorder.get(i), i);
	    }
	    return buildTreeInternal(preorder, 0, preorder.size()-1, inorder, 0, inorder.size()-1);
	}
	
	public TreeNode buildTreeInternal(ArrayList<Integer> preorder, 
	                int preStart, int preEnd, 
	                ArrayList<Integer> inorder,
	                int inStart, int inEnd) {
	    if (preStart > preEnd || inStart > inEnd) { return null; }
	    int val = preorder.get(preStart);
	    TreeNode node = new TreeNode(val);
	    
	    // Find the position of this val in in-order list
	    int k = inOrderLoc.get(val);
	    
	    node.left = buildTreeInternal(preorder, preStart+1, preStart + (k -inStart), 
	                                  inorder, inStart , k-1 );
	    node.right = buildTreeInternal(preorder, preStart + (k-inStart) +1, preEnd,
	                                   inorder, k+1, inEnd);
	    return node; 
    }

}

