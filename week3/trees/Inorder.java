public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
	    ArrayList<Integer> result  = new ArrayList<>();
	    Stack<TreeNode> nodes = new Stack<>();
	    TreeNode node = a;
	    while (node != null)  {
	        nodes.push(node);
	        node = node.left;
	    }
	    while ( nodes.size() > 0 ) {
	        node = nodes.pop();
	        result.add(node.val);
	        if (node != null)  {
	            node = node.right;
	            while (node != null) {
	                nodes.push(node);
	                node = node.left;
	            }
	        }
	    }
	    return result;
	}
}

