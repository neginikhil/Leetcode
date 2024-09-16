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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> st = new Stack<>();
        for(int i=0;i<traversal.length();){
            int lvl = 0;
            while(i<traversal.length() && traversal.charAt(i) == '-'){
                lvl++;
                i++;
            }
            int s = i;
            while(i<traversal.length() && Character.isDigit(traversal.charAt(i))){
                i++;
            }
            int val = Integer.parseInt(traversal.substring(s,i));
            TreeNode temp = new TreeNode(val);
            if(st.empty()){
                st.push(temp);
                continue;
            }
            while(st.size() > lvl){
                st.pop();
            }
            if(st.peek().left == null){
                st.peek().left = temp;
            }
            else{
                st.peek().right = temp;
            }
            st.push(temp);
        }
        while(st.size() > 1){
            st.pop();
        }
        return st.peek();
    }
}