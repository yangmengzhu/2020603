/*
 *
 * @program: 2020530
 * @description
 * 二叉搜索树
 * @author: mrs.yang
 * @create: 2020 -05 -30 19 :08
 */

public class BSTree {
    static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node(int val){
            this.val=val;
        }
    }
    public Node root;
    public boolean insert(int val){
        Node node=new Node(val);
        if(root==null){
            root=node;
            return true;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.val==val){
                return false;
            }else if(cur.val>val){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        //此时cur为空
        if(parent.val>val){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return true;
    }
    //查找
    public Node search(int val){
        Node cur=root;
        while(cur!=null){
            if(cur.val==val){
                return cur;
            }else if(cur.val>val){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }
    //前序遍历
    public void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //中序遍历
    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
  //删除节点
    public boolean remove(int val){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.val==val){
                removeNode(cur,parent);
                return true;
            }else if(cur.val>val){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        return false;
    }
    public void removeNode(Node cur,Node parent){
        if(cur.left==null){
            if(cur==root){
               root=cur.right;
            }else if(cur==parent.left){
                parent.left=cur.right;
            }else{
               parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }else {
            Node target = cur.right;
            Node targetParent = cur;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val=target.val;
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right=target.right;
            }
        }
    }
    public static void main(String[] args) {
        BSTree bsTree=new BSTree();
        int[] arr={7,2,9,18,56,15,3};
        for (int i:arr) {
            bsTree.insert(i);
        }
        bsTree.preorder(bsTree.root);
        System.out.println();
        bsTree.inorder(bsTree.root);
        System.out.println(bsTree.search(9).val);
        System.out.println("=============");
        bsTree.remove(9);
        bsTree.preorder(bsTree.root);
        System.out.println();
        bsTree.inorder(bsTree.root);
    }
}
