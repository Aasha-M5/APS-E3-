/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        dfs(root, targetSum, path, result);
        return result;
    }
    
    private void dfs(TreeNode node, int targetSum, 
                     List<Integer> path, 
                     List<List<Integer>> result) {
        
        if (node == null) return;
        
        // Add current node
        path.add(node.val);
        
        // If leaf and sum matches
        if (node.left == null && node.right == null && 
            targetSum == node.val) {
            result.add(new ArrayList<>(path)); // copy path
        }
        
        // Recurse
        dfs(node.left, targetSum - node.val, path, result);
        dfs(node.right, targetSum - node.val, path, result);
        
        // Backtrack
        path.remove(path.size() - 1);
    }
}