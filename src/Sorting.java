public class Sorting {

    public static void main(String[] args){
        bubbleSort(null);
    }

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
}
