package medium;

public class LowestCommonAncestorOfBT_236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    class Status{
        TreeNode anscestor;
        int numOfTargetNodes;
        
        public Status(TreeNode node, int numOfTargetNodes){
            this.anscestor = node;
            this.numOfTargetNodes = numOfTargetNodes;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Status res = LCAHelper(root, p, q);
        return res.anscestor;        
    }
    public Status LCAHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return new Status(null, 0);
        //Search in left subtree
        Status left = LCAHelper(root.left, p, q);
        if(left.numOfTargetNodes == 2){
            return left;
        }
        //Search in right subtree
        Status right = LCAHelper(root.right, p, q);
        if(right.numOfTargetNodes == 2){
            return right;
        }
        //For current node
       
        int curNum = left.numOfTargetNodes + right.numOfTargetNodes;
        Status cur;
        if(root == p){
            curNum++;
        }
        if(root == q){
            curNum++;
        }
        if(curNum ==0){
            return new Status(null, curNum);
        }else{
            return new Status(root, curNum);
        }        
    }

}
