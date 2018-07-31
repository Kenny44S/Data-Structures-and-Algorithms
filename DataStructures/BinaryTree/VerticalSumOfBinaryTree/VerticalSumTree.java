import java.util.HashMap;


public class BinarySearchTree
{
    Node root;
    
    HashMap<Integer, Integer> hmap;
    
    
    static class Node
    {
        int data;
        Node leftChild;
        Node rightChild;
        
        public Node(int data)
        {
            this.data = data;
        }
    }
    
    public void insertValue(int value)
    {
        root = insert(root, value);
    }
    
    public Node insert(Node root, int value)
    {
        if( root == null)
        {
            root = new Node(value);
            return root;
        }
        
        if( value < root.data )
        {
            root.leftChild = insert(root.leftChild, value);
        }else if( value > root.data )
        {
            root.rightChild = insert(root.rightChild, value);
        }
        
        return root;
    }
    
    public void inorderTraversal()
    {
        hmap = new HashMap<Integer, Integer>();
        traverse(root, 0, hmap);
    }
    
    public void traverse(Node root, int hd, HashMap<Integer, Integer> hmap)
    {
        if(root == null)  return;
        
        traverse(root.leftChild, (hd-1), hmap);                     
        int previousSum = hmap.get(hd) == null ? 0 : hmap.get(hd);
        hmap.put(hd, previousSum + root.data);
        traverse(root.rightChild, (hd+1), hmap);
    }
    
    public static void main(String[] args)
    {
        BinarySearchTree bstree = new BinarySearchTree();
        
        bstree.insertValue(60);
        bstree.insertValue(40);
        bstree.insertValue(50);
        bstree.insertValue(30);
        bstree.insertValue(20);
        bstree.insertValue(80);
        bstree.insertValue(100);
        bstree.insertValue(70);
        
        bstree.inorderTraversal();
        
        System.out.println(bstree.hmap);
        
    }
}

/*
In this Example we have used Binary Search Tree. Any Binary Tree can be used.
                            
                            A(0)
                           .60.
                    (-1)B /    \E(1)
                        40      80
                       /  \    /   \F(2)
                 (-2)C/    \ 70     100
                     30     \G(0)  
              (-3)D /        50
                  20

We keep note of the horizontal distance starting from root (0). Each left node we visit we keep subtractracting -1 & for 
each right node we visit we keep  adding +1.

By this every Node coming under Node A will have horizontal distance of 0, each node comming under Node B will have 
horizontal distance -1 and so on...

Then, by using HashMap we can store addition of previous value at given horizontal distance and keep updating it until we 
finish traversing the whole tree.

OUTPUT: {0=180, -1=40, -2=30, -3=20, 1=80, 2=100}


*/