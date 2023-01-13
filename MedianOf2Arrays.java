/** Owen Willer
 *  1/12/2023
 *  LeetCode - Median Of Two Sorted Arrays
 *
 *  This is my solution to the LeetCode problem Median Of Two Sorted Arrays (Hard).
 *  All comments above the main method are my intial thoughts and ideas to solve the project.
 *  The main method was used for testing.
 */

import java.util.Arrays;

/**Take each array, and add it to a new larger array(size of two orignal arrays added). 
*  Next, sort the array. 
*  Finally, find median of the array 
*  (divide lenght if odd, if even +1 and -1 of answer, then save)
*
*  Or use while loop (while -> notSorted) counters for both arrays.
*  Compare each index of array, and update the counters. 
*  Once both counters = length of respective arrays, we have a new fully sorted array.
*  Calculate median of n + m. ([n+m/]2).
*/

public class MedianOf2Arrays {
    public static void main(String[] args) throws Exception {

        int[] nums1 = new int[2];
        int[] nums2 = new int[2];

        nums1[0] = 1;
        nums1[1] = 2;

        nums2[0] = 3;
        nums2[1] = 4;

        double answer = findMedianSortedArrays(nums1, nums2);
        System.out.print(answer);

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int counter1 = 0;
        int counter2 = 0;
        int sortIndex = 0;
        int[] sortArr = new int[nums1.length + nums2.length];
        int medianIndex = (nums1.length + nums2.length) / 2;

        while(counter1 + counter2 != sortArr.length){
            if(counter1 >= nums1.length){
                sortArr[sortIndex] = nums2[counter2];
                ++counter2;
                ++sortIndex;
            }
            else if(counter2 >= nums2.length){
                sortArr[sortIndex] = nums1[counter1];
                ++counter1;
                ++sortIndex;
            }
            else if(nums1[counter1] < nums2[counter2]){
                sortArr[sortIndex] = nums1[counter1];
                ++counter1;
                ++sortIndex;
            }
            else{
                sortArr[sortIndex] = nums2[counter2];
                ++counter2;
                ++sortIndex;
            }
            
        }
        System.out.println(Arrays.toString(sortArr));

        if(sortArr.length % 2 == 0){
            double answer = ((sortArr[medianIndex - 1] + sortArr[medianIndex]) / 2.0);
            return answer;
        }
        
        return sortArr[medianIndex] + 0.0;
    }

}
