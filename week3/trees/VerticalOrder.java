/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // Preorder prints in a different order
 // Go for BFS
public class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        
        HashMap<Integer, ArrayList<Integer>> locationMap = new HashMap<>();
        levelOrderVerticalTraversal(A, locationMap);
        return getVerticalOrder(locationMap);
        
    }
    
    private class TreeLevelNode{
        public TreeNode treeNode;
        public int level;
        public TreeLevelNode(TreeNode node, int level) {
            this.treeNode = node;
            this.level = level;
        }
    }
    
    public void levelOrderVerticalTraversal(TreeNode a, HashMap<Integer, ArrayList<Integer>> locationMap) {
        // Create a queue for BFS
        Queue<TreeLevelNode> queue = new LinkedList<>();
        if (a == null ) return;
        queue.offer(new TreeLevelNode(a, 0));
        while (!queue.isEmpty()) {
            TreeLevelNode node = queue.poll();
            if(locationMap.containsKey(node.level)) {
                locationMap.get(node.level).add(node.treeNode.val);
            } else {
                locationMap.put(node.level, new ArrayList<Integer>(Arrays.asList(node.treeNode.val)));
            }
        
            if(node.treeNode.left != null) {
                queue.offer(new TreeLevelNode(node.treeNode.left, node.level - 1));
            }
            if(node.treeNode.right != null) {
                queue.offer(new TreeLevelNode(node.treeNode.right, node.level + 1));
            }
        }
    }
    
    public void verticalOrder(TreeNode a, int currentLocation, 
                        HashMap<Integer, ArrayList<Integer>> locMap) {
        if ( a == null) {
            return ;
        } 
        ArrayList<Integer> locs = locMap.get(currentLocation);
        if (locs == null) {
            locs = new ArrayList<>();
        } 
        locs.add(a.val);
        locMap.put(currentLocation, locs);
        verticalOrder(a.left, currentLocation-1, locMap);
        verticalOrder(a.right, currentLocation+1, locMap);
    }
    
    public ArrayList<ArrayList<Integer>> getVerticalOrder(HashMap<Integer, ArrayList<Integer>> locMap) {
        ArrayList<ArrayList<Integer>> orderedLocs = new ArrayList<>();
        int currentLoc = 0;
        int currentIndex = 0;
        ArrayList<Integer> locs = locMap.get(currentLoc);
        if (locs == null ) return orderedLocs;
        while (locs != null) {
            orderedLocs.add(currentIndex, locs);
            currentLoc -= 1;
            locs = locMap.get(currentLoc);
        }
        currentLoc = 1;
        locs = locMap.get(currentLoc);
        while ( locs  != null) {
            orderedLocs.add(locs);
            currentLoc += 1;
            locs = locMap.get(currentLoc);
        }
        return orderedLocs;
    }
}

