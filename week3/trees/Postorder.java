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
	public ArrayList<Integer> postorderTraversal(TreeNode a) {
	    ArrayList<Integer> result = new ArrayList<>();
	    Stack<TreeNode> nodes = new Stack<>();
	    TreeNode node = a;
	    if (node != null) nodes.push(node);
	    while ( nodes.size() > 0 ) {
	        node = nodes.pop();
	        result.add(node.val);
	        if (node.left != null) {
	            nodes.push(node.left);
	        }
	        if ( node.right != null) {
	            nodes.push(node.right);
	        }
	    }
	    Collections.reverse(result);
	    return result;
	}
}
