import java.util.HashMap;
import java.util.List;

public class DynamicProgramming {

    public static void main(String[] args){
        HashMap<Integer, Boolean> memo = new HashMap<>();
        int[] arr = {5,3,4,7};
        System.out.println(canSum(7, arr, memo, 0));
    }

    //calculates the nth value of a fibonaccci with memoization
    public static long fib(int n, HashMap<Integer, Long> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n<=2) return 1;

        memo.put(n, fib(n - 1, memo) + fib(n-2,memo));
        return memo.get(n);
    }

    //say that you are a traveler on a 2D grid, you begin in the top left corner and your goal
    //is to travel to the bottom-right corner, you may only move down or right. In how many ways
    //can you travel to the goal on a grid with dimensions m * n
    //write a function gridTraveler(int m, int n)
    public static int gridTraveler(int m, int n, HashMap<String, Integer> memo){
        if(n == 0 || m == 0) return 0;
        if(n == 1 || m == 1) return 1;
        if(memo.containsKey(m + "," + n)) return memo.get(m + "," + n);
        memo.put(m + "," + n, gridTraveler(m - 1, n, memo) + gridTraveler(m, n-1, memo));
        return memo.get(m + "," + n);
    }

    public static boolean canSum(int targetSum, int[] arr, HashMap<Integer, Boolean> memo, int len){
        if(memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if(targetSum == 0){
            return true;
        }
        if(targetSum < 0) {
            return false;
        }
        for(int i =0; i<= arr.length-1; i++){
            if(canSum(targetSum - arr[i], arr,memo,len + 1) == true){
                memo.put(targetSum, true);
                return true;
            };
        }
        memo.put(targetSum, false);
        return false;
    }

    public static List<Integer> howSum(int targetSum, int[] arr, HashMap<Integer, List<Integer>> memo, List<Integer> result){
        if(memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if(targetSum == 0){
            return memo.get(targetSum);
        }
        if(targetSum < 0) {
            return null;
        }
        for(int i =0; i<= arr.length-1; i++){
            memo.put(targetSum, howSum(targetSum - arr[i], arr, memo, result));
        }
        memo.put(targetSum, memo.get(targetSum));

        //will come backto this
        return result;
    }
}
