public class AVLTree {

    /**********************************************************
     * AVL tree ADT.
     * Supported operations:
     * Insert
     * Delete
     * Find
     * Min
     * Max
     **********************************************************/

    public static AVLTreeNode root;   /* Pointer to the root of the tree */
    public int noOfNodes=0;       /* No of nodes in the tree */

    public AVLTree() {


        this.root = new AVLTreeNode(9);
        Delete(9);
    }

    AVLTree(int rootValue)
    {
        this.root = new AVLTreeNode(rootValue);
    }


    int height(AVLTreeNode node){

        if (node == null)
            return -1;

        return  node.height;

    }

    void updateHeight(AVLTreeNode node)
    {
        if (node == null) return;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    int getMaxValue(AVLTreeNode node) {
        // though this case should not be hit ever for the usecase this function is employed for
        if (node == null) return Integer.MAX_VALUE;

        // if this is the left-most node
        if (node.right == null) return node.key;

        return getMinValue(node.right);
    }

    int getMinValue(AVLTreeNode node)
    {
        // though this case should not be hit ever for the usecase this function is employed for
        if (node == null) return Integer.MIN_VALUE;

        // if this is the left-most node
        if (node.left == null) return node.key;

        return getMinValue(node.left);
    }

    AVLTreeNode rightRotate(AVLTreeNode node) {
        if (node == null) return node;

        AVLTreeNode beta  = node.left;

        AVLTreeNode t2  = beta.right;

        beta.right = node;
        node.left = t2;

        // we first need to update the height of node because height of beta uses height of node
        updateHeight(node);

        // now we update height of beta
        updateHeight(beta);

        return beta;
    }

    AVLTreeNode leftRotate(AVLTreeNode node) {
        if (node == null) return node;

        AVLTreeNode beta  = node.right;
        AVLTreeNode t2  = beta.left;

        beta.left = node;
        node.right = t2;

        // we first need to update the height of node because height of beta uses height of node
        updateHeight(node);

        // now we update height of beta
        updateHeight(beta);

        return beta;
    }

    int getBalance(AVLTreeNode node) {
        if (node == null)
        {
            return 0;
        }
        int balance;

        balance = height(node.left) - height(node.right);

        return balance;}
    /*******************************************************
     * Returns the number of nodes in the tree
     *******************************************************/
    int NoOfNodes() {
        return noOfNodes;
    }

    /*******************************************************
     * Inserts the key into the AVLTree. Returns a pointer
     * to the newly inserted node
     *******************************************************/
    /*AVLTreeNode Insert(int key) {
        root = insert(root, key);
        return root;
    }*/
    public void Insert(int key)
    {
        root = insert(this.root, key);
        return;
    }


    AVLTreeNode insert(AVLTreeNode node, int key)
    {
        // do usual BST insertion first
        if (node == null)
        {
            return new AVLTreeNode(key);
        }

        if (key < node.key)
        {
            node.left = insert(node.left, key);
        }
        else if (key > node.key)
        {
            node.right = insert(node.right, key);
        }
        else
        {
            return node;
        }

        // now update the height of the node
        updateHeight(node);

        // check the balance at this node and perform rotations accordingly
        int balance = getBalance(node);

        if (balance > 1) // indicates either left-left or left-right case
        {
            if (key < node.left.key) // confirms left-left case
            {
                node = rightRotate(node);
            }
            else // confirms left-right case
            {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }

        else if (balance < -1) // indicates either right-right or right-left case
        {
            if (key > node.right.key) // confirms right-right case
            {
                node = leftRotate(node);
            }
            else // confirms right-left case
            {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        return node;
    }

    /*******************************************************
     * Deletes the key from the tree (if found). Returns
     * 0 if deletion succeeds, -1 if it fails
     *******************************************************/
   /* public int Delete(int key) {

        root = delete(this.root, key);

        if (delete(this.root , key) != null){
            noOfNodes--;
            return 0;}
        else
            return -1;
    }*/

    public  int Delete(int key)
	    {
        	        root = delete(this.root, key);
        	        return 0;
            }

    private AVLTreeNode delete(AVLTreeNode node, int key)
    {
        // if empty tree
        if (node == null) return null;

        if (key < node.key)
        {
            node.left = delete(node.left, key);
        }
        else if (key > node.key)
        {
            node.right = delete(node.right, key);
        }

        else // key to be deleted is equal to node data
        {
            // one child/no child case
            if (node.left == null)
            {
                node = node.right;
            }
            else if (node.right == null)
            {
                node = node.left;
            }

            // two children case
            // copy value of inorder successor into current node and delete inorder successor
            // since right sub-tree would be modified, update node.right
            else
            {
                int inorderSuccessorValue = getMinValue(node.right);
                node.key = inorderSuccessorValue;
                node.right = delete(node.right, inorderSuccessorValue);
            }
        }

        // if there was only one node in the tree which got deleted above return null
        if (node == null)
        {
            return null;
        }

        // update the height of the node
        updateHeight(node);

        // check the balance at this node and perform rotations accordingly
        int balance = getBalance(node);

        if (balance > 1) // indicates either left-left or left-right case
        {
            if (getBalance(node.left) >= 0) // confirms left-left case
            {
                node = rightRotate(node);
            }
            else // confirms left-right case
            {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }

        else if (balance < -1) // indicates either right-right or right-left case
        {
            if (getBalance(node.right) <= 0) // confirms right-right case
            {
                node = leftRotate(node);
            }
            else // confirms right-left case
            {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        return node;
    }

    AVLTreeNode minValueNode(AVLTreeNode node)
    {
        AVLTreeNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    /*******************************************************
     * Searches the AVLTree for a key. Returns a pointer to the
     * node that contains the key (if found) or NULL if unsuccessful
     *******************************************************/
    public AVLTreeNode traverseTree(AVLTreeNode root, int key) {
        if (root == null)
            return null;
        if (root.key == key)
            return root;
        if (root.key > key)
            return traverseTree(root.left, key);
        else
            return traverseTree(root.right, key);
    }

    AVLTreeNode Find(int key) {
        // Fill this in
        if (this.root == null)
            return null;
        return traverseTree(this.root, key);
    }

    /*******************************************************
     * Returns a pointer to the node that contains the minimum key
     *******************************************************/
    AVLTreeNode Min() {

        AVLTreeNode current = root;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;


    }

    /*******************************************************
     * Returns a pointer to the node that contains the maximum key
     *******************************************************/
    AVLTreeNode Max() {

        AVLTreeNode current = root;

        /* loop down to find the leftmost leaf */
        while (current.right != null)
            current = current.right;

        return current;


    }

    /*******************************************************
     * Performs an inorder traversal of the tree and prints [key, height, bf]
     * triplets in sorted order in a nicely formatted table
     *******************************************************/
    void Print() {

        AVLTreeNode node = root;

        printInorder(node);

    }

    void printInorder(AVLTreeNode node)
    {


        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }



}

