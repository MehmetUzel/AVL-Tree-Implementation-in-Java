public class Test {

    /*******************************************************
     * Test1: Introduce a RR imbalance
     *******************************************************/
    static int Test1(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(10);
        avl.Insert(5);
        avl.Insert(15);
        avl.Insert(20);
        avl.Insert(12);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = AVLTree.root;
        //node = new AVLTreeNode(10);
        if (node.key != 10 || node.height != 2) return 0;
        if (node.left.key != 5 || node.left.height != 0) return 0;
        if (node.right.key != 15 || node.right.height != 1) return 0;
        if (node.right.left.key != 12 || node.right.left.height != 0) return 0;
        if (node.right.right.key != 20 || node.right.right.height != 0) return 0;

        // Now introduce a RR imbalance
        avl.Insert(30);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 15 || node.height != 2) return 0;
        if (node.left.key != 10 || node.left.height != 1) return 0;
        if (node.left.left.key != 5 || node.left.left.height != 0) return 0;
        if (node.left.right.key != 12 || node.left.right.height != 0) return 0;

        if (node.right.key != 20 || node.right.height != 1) return 0;
        if (node.right.left != null) return 0;
        if (node.right.right.key != 30 || node.right.right.height != 0) return 0;

        return 7;
    } //end-Test1

    /*******************************************************
     * Test2: Introduce a RL imbalance
     *******************************************************/
    static int Test2(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(10);
        avl.Insert(5);
        avl.Insert(15);
        avl.Insert(20);
        avl.Insert(12);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 10 || node.height != 2) return 0;
        if (node.left.key != 5 || node.left.height != 0) return 0;
        if (node.right.key != 15 || node.right.height != 1) return 0;
        if (node.right.left.key != 12 || node.right.left.height != 0) return 0;
        if (node.right.right.key != 20 || node.right.right.height != 0) return 0;

        // Now introduce a RL imbalance
        avl.Insert(13);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 12 || node.height != 2) return 0;
        if (node.left.key != 10 || node.left.height != 1) return 0;
        if (node.left.left.key != 5 || node.left.left.height != 0) return 0;
        if (node.left.right != null) return 0;

        if (node.right.key != 15 || node.right.height != 1) return 0;
        if (node.right.left.key != 13 && node.right.left.height != 0) return 0;
        if (node.right.right.key != 20 || node.right.right.height != 0) return 0;

        return 7;
    } //end-Test2

    /*******************************************************
     * Test3: Introduce a LL imbalance
     *******************************************************/
    static int Test3(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(10);
        avl.Insert(5);
        avl.Insert(20);
        avl.Insert(4);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 10 || node.height != 2) return 0;
        if (node.left.key != 5 || node.left.height != 1) return 0;
        if (node.left.left.key != 4 || node.left.left.height != 0) return 0;
        if (node.left.right != null) return 0;
        if (node.right.key != 20 || node.right.height != 0) return 0;

        // Now introduce a LL imbalance
        avl.Insert(3);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 10 || node.height != 2) return 0;
        if (node.left.key != 4 || node.left.height != 1) return 0;
        if (node.left.left.key != 3 || node.left.left.height != 0) return 0;
        if (node.left.right.key != 5 || node.left.right.height != 0) return 0;
        if (node.right.key != 20 || node.right.height != 0) return 0;

        return 7;
    } //end-Test3

    /*******************************************************
     * Test4: Introduce an LR imbalance
     *******************************************************/
    static int Test4(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(10);
        avl.Insert(4);
        avl.Insert(20);
        avl.Insert(3);
        avl.Insert(5);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 10 || node.height != 2) return 0;
        if (node.left.key != 4 || node.left.height != 1) return 0;
        if (node.left.left.key != 3 || node.left.left.height != 0) return 0;
        if (node.left.right.key != 5 || node.left.right.height != 0) return 0;
        if (node.right.key != 20 || node.right.height != 0) return 0;

        // Now introduce a LR imbalance
        avl.Insert(6);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 5 || node.height != 2) return 0;
        if (node.left.key != 4 || node.left.height != 1) return 0;
        if (node.left.left.key != 3 || node.left.left.height != 0) return 0;
        if (node.left.right != null) return 0;

        if (node.right.key != 10 || node.right.height != 1) return 0;
        if (node.right.left.key != 6 || node.right.left.height != 0) return 0;
        if (node.right.right.key != 20 || node.right.right.height != 0) return 0;

        return 7;
    } //end-Test4

    /*******************************************************
     * Test5: Several imbalances at the same time
     *******************************************************/
    static int Test5(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(10);
        avl.Insert(5);
        avl.Insert(15);
        avl.Insert(20);
        avl.Insert(12);
        avl.Insert(13);   // Introduce a RL imbalance
        avl.Insert(2);    // Introduce a LL imbalance
        avl.Insert(1);    // No imbalance
        avl.Insert(3);    // No imbalance
        avl.Insert(4);    // Introduce a LR imbalance

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 12 || node.height != 3) return 0;
        if (node.left.key != 3 || node.left.height != 2) return 0;
        if (node.left.left.key != 2 || node.left.left.height != 1) return 0;
        if (node.left.left.left.key != 1 || node.left.left.left.height != 0) return 0;
        if (node.left.left.right != null) return 0;

        if (node.left.right.key != 5 || node.left.right.height != 1) return 0;
        if (node.left.right.left.key != 4 || node.left.right.left.height != 0) return 0;
        if (node.left.right.right.key != 10 || node.left.right.right.height != 0) return 0;

        if (node.right.key != 15 || node.right.height != 1) return 0;
        if (node.right.left.key != 13 || node.right.left.height != 0) return 0;
        if (node.right.right.key != 20 || node.right.right.height != 0) return 0;

        return 15;
    } //end-Test5

    /*******************************************************
     * Test6: Delete a leaf node
     *******************************************************/
    static int Test6(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(10);
        avl.Insert(4);
        avl.Insert(20);
        avl.Insert(3);
        avl.Insert(5);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 10 || node.height != 2) return 0;
        if (node.left.key != 4 || node.left.height != 1) return 0;
        if (node.left.left.key != 3 || node.left.left.height != 0) return 0;
        if (node.left.right.key != 5 || node.left.right.height != 0) return 0;
        if (node.right.key != 20 || node.right.height != 0) return 0;

        avl.Delete(5);   /* Still AVL after this deletion */
        avl.Delete(20);  /* Now needs adjusting */

        // Check the tree
        node = avl.root;
        if (node.key != 4 || node.height != 1) return 0;
        if (node.left.key != 3 || node.left.height != 0) return 0;
        if (node.right.key != 10 || node.right.height != 0) return 0;

        // Print the AVL tree on the screen
        avl.Print();

        return 7;
    } //end-Test6

    /*******************************************************
     * Test7: Delete a leaf node
     *******************************************************/
    static int Test7(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(10);
        avl.Insert(4);
        avl.Insert(20);
        avl.Insert(3);
        avl.Insert(5);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 10 || node.height != 2) return 0;
        if (node.left.key != 4 || node.left.height != 1) return 0;
        if (node.left.left.key != 3 || node.left.left.height != 0) return 0;
        if (node.left.right.key != 5 || node.left.right.height != 0) return 0;
        if (node.right.key != 20 || node.right.height != 0) return 0;

        avl.Delete(20);  /* Now needs adjusting */

        // Check the tree
        node = avl.root;
        if (node.key != 4 || node.height != 2) return 0;
        if (node.left.key != 3 || node.left.height != 0) return 0;
        if (node.right.key != 10 || node.right.height != 1) return 0;
        if (node.right.left.key != 5 || node.right.left.height != 0) return 0;
        if (node.right.right != null) return 0;

        // Print the AVL tree on the screen
        avl.Print();

        return 7;
    } //end-Test7

    /*******************************************************
     * Test8: Delete a leaf node
     *******************************************************/
    static int Test8(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(32);
        avl.Insert(16);
        avl.Insert(48);
        avl.Insert(8);
        avl.Insert(24);
        avl.Insert(40);
        avl.Insert(56);
        avl.Insert(28);
        avl.Insert(36);
        avl.Insert(44);
        avl.Insert(52);
        avl.Insert(60);
        avl.Insert(58);
        avl.Insert(62);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 32 || node.height != 4) return 0;
        if (node.left.key != 16 || node.left.height != 2) return 0;
        if (node.left.left.key != 8 || node.left.left.height != 0) return 0;
        if (node.left.right.key != 24 || node.left.right.height != 1) return 0;
        if (node.left.right.left != null) return 0;
        if (node.left.right.right.key != 28 || node.left.right.right.height != 0) return 0;

        if (node.right.key != 48 || node.right.height != 3) return 0;
        if (node.right.left.key != 40 || node.right.left.height != 1) return 0;
        if (node.right.left.left.key != 36 || node.right.left.left.height != 0) return 0;
        if (node.right.left.right.key != 44 || node.right.left.right.height != 0) return 0;
        if (node.right.right.key != 56 || node.right.right.height != 2) return 0;
        if (node.right.right.left.key != 52 || node.right.right.left.height != 0) return 0;
        if (node.right.right.right.key != 60 || node.right.right.right.height != 1) return 0;
        if (node.right.right.right.left.key != 58 || node.right.right.right.left.height != 0) return 0;
        if (node.right.right.right.right.key != 62 || node.right.right.right.right.height != 0) return 0;

        avl.Delete(8);  /* Now needs adjusting */

        // Check the tree
        node = avl.root;
        if (node.key != 48 || node.height != 3) return 0;
        if (node.left.key != 32 || node.left.height != 2) return 0;
        if (node.left.left.key != 24 || node.left.left.height != 1) return 0;
        if (node.left.left.left.key != 16 || node.left.left.left.height != 0) return 0;
        if (node.left.left.right.key != 28 || node.left.left.right.height != 0) return 0;

        if (node.left.right.key != 40 || node.left.right.height != 1) return 0;
        if (node.left.right.left.key != 36 || node.left.right.left.height != 0) return 0;
        if (node.left.right.right.key != 44 || node.left.right.right.height != 0) return 0;

        if (node.right.key != 56 || node.right.height != 2) return 0;
        if (node.right.left.key != 52 || node.right.left.height != 0) return 0;
        if (node.right.right.key != 60 || node.right.right.height != 1) return 0;
        if (node.right.right.left.key != 58 || node.right.right.left.height != 0) return 0;
        if (node.right.right.right.key != 62 || node.right.right.right.height != 0) return 0;

        // Print the AVL tree on the screen
        avl.Print();

        return 10;
    } //end-Test8

    /*******************************************************
     * Test9: Delete an internal node with one child
     *******************************************************/
    static int Test9(){
        AVLTree avl = new AVLTree();
        AVLTreeNode node;

        // Insert keys
        avl.Insert(32);
        avl.Insert(16);
        avl.Insert(48);
        avl.Insert(8);
        avl.Insert(24);
        avl.Insert(40);
        avl.Insert(56);
        avl.Insert(4);
        avl.Insert(36);
        avl.Insert(44);
        avl.Insert(52);
        avl.Insert(60);
        avl.Insert(58);
        avl.Insert(62);

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 32 || node.height != 4) return 0;
        if (node.left.key != 16 || node.left.height != 2) return 0;
        if (node.left.left.key != 8 || node.left.left.height != 1) return 0;
        if (node.left.left.left.key != 4 || node.left.left.left.height != 0) return 0;
        if (node.left.right.key != 24 || node.left.right.height != 0) return 0;

        if (node.right.key != 48 || node.right.height != 3) return 0;
        if (node.right.left.key != 40 || node.right.left.height != 1) return 0;
        if (node.right.left.left.key != 36 || node.right.left.left.height != 0) return 0;
        if (node.right.left.right.key != 44 || node.right.left.right.height != 0) return 0;
        if (node.right.right.key != 56 || node.right.right.height != 2) return 0;
        if (node.right.right.left.key != 52 || node.right.right.left.height != 0) return 0;
        if (node.right.right.right.key != 60 || node.right.right.right.height != 1) return 0;
        if (node.right.right.right.left.key != 58 || node.right.right.right.left.height != 0) return 0;
        if (node.right.right.right.right.key != 62 || node.right.right.right.right.height != 0) return 0;

        avl.Delete(8);  /* Now needs adjusting */

        // Check the tree
        node = avl.root;
        if (node.key != 48 || node.height != 3) return 0;
        if (node.left.key != 32 || node.left.height != 2) return 0;
        if (node.left.left.key != 16 || node.left.left.height != 1) return 0;
        if (node.left.left.left.key != 4 || node.left.left.left.height != 0) return 0;
        if (node.left.left.right.key != 24 || node.left.left.right.height != 0) return 0;

        if (node.left.right.key != 40 || node.left.right.height != 1) return 0;
        if (node.left.right.left.key != 36 || node.left.right.left.height != 0) return 0;
        if (node.left.right.right.key != 44 || node.left.right.right.height != 0) return 0;

        if (node.right.key != 56 || node.right.height != 2) return 0;
        if (node.right.left.key != 52 || node.right.left.height != 0) return 0;
        if (node.right.right.key != 60 || node.right.right.height != 1) return 0;
        if (node.right.right.left.key != 58 || node.right.right.left.height != 0) return 0;
        if (node.right.right.right.key != 62 || node.right.right.right.height != 0) return 0;

        // Print the AVL tree on the screen
        avl.Print();

        avl.Delete(58);   /* Delete a leaf. No imbalance */
        avl.Delete(48);   /* Delete the root. */
        avl.Delete(60);   /* No imbalance */
        avl.Delete(52);   /* Delete root again! */

        // Print the AVL tree on the screen
        avl.Print();

        // Check the tree
        node = avl.root;
        if (node.key != 32 || node.height != 3) return 0;
        if (node.left.key != 16 || node.left.height != 1) return 0;
        if (node.left.left.key != 4 || node.left.left.height != 0) return 0;
        if (node.left.right.key != 24 || node.left.right.height != 0) return 0;

        if (node.right.key != 56 || node.right.height != 2) return 0;
        if (node.right.left.key != 40 || node.right.left.height != 1) return 0;
        if (node.right.left.left.key != 36 || node.right.left.left.height != 0) return 0;
        if (node.right.left.right.key != 44 || node.right.left.right.height != 0) return 0;
        if (node.right.right.key != 62 || node.right.right.height != 0) return 0;

        /* Test min & max */
        node = avl.Min();
        if (node.key != 4) return 20;

        node = avl.Max();
        if (node.key != 62) return 22;

        return 20;
    } //end-Test9

    /*******************************************************
     * Test10: Randomly insert & delete many nodes
     *******************************************************/
    static boolean isAVL(AVLTreeNode root){
        if (root==null) return true;
        AVLTreeNode left = root.left;
        AVLTreeNode right = root.right;

        int leftHeight = -1;
        if (left != null){
            leftHeight = left.height;
            if (left.key >= root.key) return false;
        } //end-if

        int rightHeight = -1;
        if (right != null){
            rightHeight = right.height;
            if (right.key <= root.key) return false;
        } //end-if

        if (leftHeight-rightHeight <= -2 || leftHeight-rightHeight >= 2) return false;

        if (!isAVL(root.left)) return false;
        return isAVL(root.right);
    } //end-isAVL

    static int Test10(){
        AVLTree avl = new AVLTree();
        int N = 100;
        int[] A = new int[N];
        int[] B = new int[N];
        int noKeys = 0;
        int i;

        for (i=0; i<N; i++) A[i] = 0;

        for (i=0; i<N; i++){
            int key = (int) Math.floor(Math.random()*N);
            if (A[key] == 1) continue;
            B[noKeys++] = key;
            A[key] = 1;
        } //end-for

        // Insert all of the keys into the tree
        for (i=0; i<noKeys; i++) avl.Insert(B[i]);



        // Check the tree
        if (!isAVL(avl.root)) return 0;

        // Now delete all keys
        for (i=noKeys-1; i>=0; i--){
            if (avl.Delete(B[i]) != 0) return 0;
            if (avl.Find(B[i]) != null) return 0;
        } //end-for



        // The tree must be empty now
        if (avl.root != null) return 0;

        return 20;
    } //end-Test10



    public static void main(String[] args) {
        int grade = 0;

        System.out.println("---------------------------------- TEST1 ---------------------------\n");
        grade += Test1();
        System.out.println("\n====>Your grade after Test1:" + grade);

        System.out.println("---------------------------------- TEST2 ---------------------------\n");
        grade += Test2();
        System.out.println("\n====>Your grade after Test2: " + grade);

        System.out.println("---------------------------------- TEST3 ---------------------------\n");
        grade += Test3();
        System.out.println("\n====>Your grade after Test3: " + grade);

        System.out.println("---------------------------------- TEST4 ---------------------------\n");
        grade += Test4();
        System.out.println("\n====>Your grade after Test4: " + grade);

        System.out.println("---------------------------------- TEST5 ---------------------------\n");
        grade += Test5();
        System.out.println("\n====>Your grade after Test5: " + grade);

        System.out.println("---------------------------------- TEST6 ---------------------------\n");
        grade += Test6();
        System.out.println("\n====>Your grade after Test6: " + grade);

        System.out.println("---------------------------------- TEST7 ---------------------------\n");
        grade += Test7();
        System.out.println("\n====>Your grade after Test7: " + grade);

        System.out.println("---------------------------------- TEST8 ---------------------------\n");
        grade += Test8();
        System.out.println("\n====>Your grade after Test8: " + grade);

        System.out.println("---------------------------------- TEST9 ---------------------------\n");
        grade += Test9();
        System.out.println("\n====>Your grade after Test9: " + grade);

        System.out.println("---------------------------------- TEST10 ---------------------------\n");
        grade += Test10();
        System.out.println("\n====>Your grade after Test10: " + grade);

        System.out.println("--------------------------------------------------------------------\n");
        System.out.println("============> Your project grade is: " + grade);

    }
}
