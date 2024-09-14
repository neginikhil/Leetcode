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
    public void helper(TreeNode root, List<String> list, StringBuilder s){
        if(root == null){
            return;
        }
        s.append(root.val);
        if(root.left == null && root.right == null){
            list.add(s.toString());
        }
        helper(root.left, list, new StringBuilder(s));
        helper(root.right, list, new StringBuilder(s));
    }
    public int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        helper(root,list,s);
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum += Integer.parseInt(list.get(i));
        }
        return sum;
    }
}