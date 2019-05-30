<b>Binary Search:</b> As the name says "Binary" Search. It is a searching algorithm which divides its search into half of the originial problem.

<b style="color: blue">Note*:</b> Binary Search can be used ONLY with sorted numbers/values.

Lets make it simple. Suppose you have an array of 14 numbers and you want to search the index containing the valie '6' :
Initially we have these values: <br> 
int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14}; <br>
left:   0   [ Starting index of array ] <br>
right:  14 [ Ending index of array, ie: Size of array. Its okay to pass 14. Because it will never check for value at array[14] which would result in ArrayOutOfBound Exception] <br>
target: 6 <br>

Our function will look like: <b style="color: orange">binarySearch(int[] nums, int target (6), int left(0), int right(14))</b>

Binary Search starts to compare the target value 6 with the value at <b>middle</b> index of the array <br>
ie: ( left index + right index ) / 2   - That is how we get the index at the middle of OUR* array <br>
middle = (0+14)/2 = 7 <br>
is 6 == nums[7]     ? <b style="color: red">NO</b><br>
is 6 > nums[middle] ? <b style="color: red">NO</b>   ( as nums[7] = 8) <br>
is 6 < nums[middle] ? <b style="color: green"> YES</b>, that means the target value has to be between nums[0] & nums[7] <br>

Now we call the same function and pass our new parameters, <b>left</b> & <b>right</b>, left's value will remain same and right's will change to the value of 'mid' <br>
ie:  binarySearch(nums,      6,      0,      7) <br>
Now, though the array is same, our Algorithm is SURE that the target value is between nums[0] & nums[7] so it does not waste time in searching the other half of the array. In fact for our Algoritmh the other half of the array does not EXIST AT ALL.<br>
For him its just int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8,<strike>9,10,11,12,13,14};</strike>

Now again it checks the value at index  (0+7)/2 : 3

IS 6 > nums[3] YES,  now pass 3 as left index & right's index will remain unchanged.

Now nums = <strike>{1,2,3,</strike> 4,  5,  6,  7,  8, <strike>9,10,11,12,13,14}</strike>

check the value at index (3+7)/2 : 5

IS 6 == nums[5]  YES. Value found at index: 5;


This way BinarySearch can be very effective & fast to search for values in a <b>Sorted</b> Array 