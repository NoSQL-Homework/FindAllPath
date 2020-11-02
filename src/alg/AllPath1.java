//给定一个二叉树，返回所有从根节点到叶子节点的路径
/*特殊情况：当根节点为null的时候，直接返回空数组。
  正常情况：深度遍历，从根节点开始，依次从左节点开始，一直往左节点遍历，直到遇到叶子节点，此时就构成一条完整的路径，
          而其相邻的右叶子结点，以及从根节点开始的右节点，这些都是一条完整的路径。*/
package alg;

import java.util.ArrayList;
import java.util.List;

public class AllPath1 {

    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root,String.valueOf(root.val),result);
        return result;
    }

    private void helper(TreeNode root,String path,List<String> result){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            result.add(path);
            return;
        }

        if(root.left != null){
            helper(root.left,path + "->" +String.valueOf(root.left.val), result);
        }

        if(root.right != null){
            helper(root.right, path + "->" +String.valueOf(root.right.val), result);
        }
    }

}
