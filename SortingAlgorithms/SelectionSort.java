public class SelectionSort {

    private int[] arrayToSort;
    private int sizeOfArray;
    private int nextIndexToSort = 0;

    /*
     * @params integer sizeOfInteger : size of array to sor
     * @params integer maxRange      : Random numbers from 0 - maxRange will be inserted into array.
     *
     */
     
    SelectionSort()
    {
        
    }
    
    SelectionSort(int sizeOfArray, int maxRange)
    {
        arrayToSort = new int[sizeOfArray];
        this.sizeOfArray = sizeOfArray;
        fillArray(maxRange);
    }

    public void fillArray(int limit)
    {
        int i;
        for(i=0; i < sizeOfArray; i++)
        {
            arrayToSort[i] = (int) (Math.random() * limit);
        }
        System.out.println("Array created & filled with random numbers successfully.");
        System.out.println("Original array: ");
        displayArray();
    }

    public void displayArray()
    {
        int i;
        for(i=0; i < sizeOfArray; i++)
        {
            System.out.print(" | " + arrayToSort[i]);
        }
        System.out.println("\n-------------------------------------------------------------------------");
    }

    public void startSort()
    {
        System.out.println("Starting Sort..");
        sort(nextIndexToSort);
    }

    private void sort(int nextIndexToSort)
    {
        this.nextIndexToSort = nextIndexToSort;
        int minimum = arrayToSort[this.nextIndexToSort];
        int temp;

        if( (this.nextIndexToSort+1) == sizeOfArray) {
            System.out.println("Your array has been sorted successfully.");
        }else
        {
            for(int i = this.nextIndexToSort + 1; i < sizeOfArray; i++ )
            {
                if(arrayToSort[i] < minimum)
                {
                    temp = minimum;
                    minimum = arrayToSort[i];
                    arrayToSort[i] = temp;
                }
            }
            arrayToSort[this.nextIndexToSort] = minimum;
            nextIndexToSort++;
            displayArray();
            sort(nextIndexToSort);
        }
    }
    
    public static void main(String[] args)
    {
        SelectionSort st = new SelectionSort(10, 100);
        st.startSort();
    }
}
