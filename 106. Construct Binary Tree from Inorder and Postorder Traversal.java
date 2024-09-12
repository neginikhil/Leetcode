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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i], i);
        }
        return helper(postorder, mp, postorder.length-1, 0, inorder.length-1);
    }
    public TreeNode helper(int[] postorder, Map<Integer, Integer> mp, int idx, int s, int e){
        if (idx < 0 || s > e) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[idx]);
        int mid = mp.get(postorder[idx]);
        root.right = helper(postorder, mp, idx-1, mid+1, e);
        root.left = helper(postorder, mp, idx-(e-mid)-1, s, mid-1);
        return root;
    }
}