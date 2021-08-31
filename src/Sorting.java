public class Sorting {

    public static void main(String[] args){
        int[] a = {4,5,6,0,0,0};
        int[] b = {1,2,3};
        mergeSorted(a,b,3,3);
    }

    //bubble sort code implementation
    public static void bubbleSort(int[] arr){
        //time complexity of bubbble sort is O(n^2)
        int[] nums = {3,5,1,2,5,6};
        boolean isSorted;
        for(int i = 0; i < nums.length; i++){
            isSorted = true;
            for(int j = 1; j < nums.length - i; j++){
                int right = nums[j];
                int left = nums[j-1];
                if(right < left){
                    var temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                return;
            }
        }
    }


    //Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted
    // arrays. The overall run time complexity should be O(log (m+n))
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size = nums1.length + nums2.length;
        int m = nums1.length;
        int n = nums2.length;
        int median = size/2;
        boolean isEven = false;
        if (size%2 == 0) isEven = true;

        int[] set = new int[median + 1];

        int count = 0;
        int index1 = 0;
        int index2 = 0;
        while(median >= count && index1 < m && index2 < n){
            if(nums1[index1] < nums2[index2]){
                set[count] = nums1[index1];
                index1++;
                count++;
                continue;
            }
            else if(nums1[index1] > nums2[index2]){
                set[count] = nums2[index2];
                index2++;
                count++;
                continue;
            }
            set[count] = nums1[index1];
            index1++;
            count++;
            if(set.length > count){
                set[count] = nums2[index2];
                index2++;
                count++;
            }
        }

        while(index1 < m && median >= count){
            set[count] = nums1[index1];
            index1++;
            count++;
        }
        while(index2 < n && median >= count){
            set[count] = nums2[index2];
            index2++;
            count++;
        }
        if(isEven)
            return ((double)set[median] + (double)set[median - 1])/2;
        else
            return (double)set[median];
    }

    //you are given two sorted arrays A and B where A has a large enough buffer at the end to hold B. Write a method
    //to merge B into A in sorted order.
    private static void mergeSorted(int[] a, int[] b, int countA, int countB){
        int indexMerged = countB + countA - 1;
        int indexA = countA - 1;
        int indexB = countB - 1;

        while(indexB >= 0){
            if(indexA >= 0 && a[indexA] > b[indexB]){
                a[indexMerged] = a[indexA];
                indexA--;
            }
            else{
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }
}
