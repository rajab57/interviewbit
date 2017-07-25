public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    ArrayList<Integer> result = new ArrayList<>();
	    Stack<TreeNode> nodes = new Stack<>();
	    TreeNode node = a;
	    while ( node != null ) {
	       result.add(node.val);
	       nodes.push(node);
	       node = node.left;
	    }
	    while(nodes.size() > 0) {
	        node = nodes.pop();
	        node = node.right;
	        while (node != null) {
	            result.add(node.val);
	            nodes.push(node);
	            node = node.left;
	        }
	    }
	    return result;
	}
}

