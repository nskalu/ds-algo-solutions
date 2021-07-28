import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        //root, left, right
        //[1,null,2,3]
        TreeNode current = root;
        queue.add(current);
        while(!queue.isEmpty()){
            TreeNode node = queue.pollLast();
            res.add(node.val);
            if(node.right != null){
                queue.add(node.right);
            }
            if(node.left != null){
                queue.add(node.left);
            }
        }
        return res;
    }
}
