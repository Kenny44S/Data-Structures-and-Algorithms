public class BinarySearchTree
{
    Node root;
    
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
    
    public void searchValue(int value)
    {
         System.out.println("At Root");
         
         Node n = search(root, value);
         
         if( n == null) 
             System.out.println("NOT FOUND.");
         
         else System.out.println("FOUND.");
    }
    
    public Node search(Node root, int value)
    {
        if( root == null || root.data == value)
        {
            return root;
        }
        
        if( value < root.data )
        {
            System.out.println("Left Child");
            return search(root.leftChild, value);
        }else if(value > root.data )
        {
            System.out.println("Right Child");
            return search(root.rightChild, value);
        }
        
        return root;
    }
    
    public void inorderTraversal()
    {
        traverse(root);
    }
    
    public void traverse(Node root)
    {
        if(root == null)  return;
        
        traverse(root.leftChild);                     
        System.out.println(root.data);          // We can shift this line UP or DOWN to get Preorder & Postorder traversal respectively.
        traverse(root.rightChild);
    }
    
    public static void main(String[] args)
    {
        BinarySearchTree bstree = new BinarySearchTree();
        
        bstree.insertValue(440);   
        
        bstree.insertValue(240);
        bstree.insertValue(238);
        bstree.insertValue(242);                   
        
        bstree.insertValue(580);
        bstree.insertValue(578);
        bstree.insertValue(582);
        
        bstree.insertValue(624);
        bstree.insertValue(620);
        bstree.insertValue(628);
        // ---- 

        bstree.insertValue(626);
        
        bstree.inorderTraversal();
        
        bstree.searchValue(624);
    }
}
