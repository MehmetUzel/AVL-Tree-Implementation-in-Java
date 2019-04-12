public class AVLTreeNode {
    public int key;           /* Key */
    public int height;            /* Height of the node */
    public AVLTreeNode left;      /* Pointer to the left child */
    public AVLTreeNode right;     /* Pointer to the right child */

    // Constructor
    public AVLTreeNode(int key){
        this.key = key;
        this.height = 0;
        this.left = this.right = null;
    }


}
