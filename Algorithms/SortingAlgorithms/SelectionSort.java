public class SelectionSort {

    int[] unsortedArray;

    public SelectionSort(int unsortedArray[])
    {
        this.unsortedArray = unsortedArray;
    }


    public int[] sortArray()
    {
        return sort(0, unsortedArray);
    }

    public int[] sort(int indexToSort, int[] unsortedArray)
    {
        if(unsortedArray.length == 1)
            return unsortedArray;

        if( indexToSort == unsortedArray.length ) {
            return unsortedArray;
        }
//        {30,10,60,20,15,25,60,90,4};
        int lowest = unsortedArray[indexToSort]; // 30
        int newNum;

        for (int z = (indexToSort + 1); z < unsortedArray.length; z++ )
        {
            if( (newNum = unsortedArray[z])  < lowest )
            {
                unsortedArray[z] = lowest;
                unsortedArray[indexToSort] = lowest = newNum;
            }
        }

        return sort(indexToSort+1, unsortedArray);
    }


    public static void printArray(int[] array)
    {
        for(int z : array)
            System.out.print(z + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] unsortedArray = {30,10,60,20,15,25,60,90,4,35,70,90};

        SelectionSort ssort = new SelectionSort(unsortedArray);

        printArray(unsortedArray);

        int[] sortedArray = ssort.sortArray();

        printArray(sortedArray);
    }
}
