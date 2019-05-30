public class BinarySearchTree {
    
    public void search(int[]nums, int target)
    {
        int index =startSearch(nums, target, 0, nums.length);
        if(index > -1)
        System.out.println("Value found at: " + index);
        else
        System.out.println("Not Found");
    }
    
    public int startSearch(int[]nums, int target, int l, int r)
    {
        int mid = 0;
        mid = (l+r)/2;
        int index = 0; 
        

        while( (r-l) > 1 )
        {
            if(nums[mid] == target)
            return mid;
            
            if(target < nums[mid])
            index = startSearch(nums, target, l, mid);
        
            if(target > nums[mid])
            index = startSearch(nums, target, mid, r);
            
            return index;
        }
        return -1;
    }
    
    
    public static void main(String[]args)
    {
        int[]nums = {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200};
        
        BinarySearch bs = new BinarySearch();
        bs.search(nums, 20);
    }
}
