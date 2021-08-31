import java.util.HashMap;
import java.util.Map;

public class ArrayAndStrings {

    public static void main(String[] args){
        System.out.println(isAnagram("parse", "pears"));

    }

    public static void duplicateZero() {
        //[1,0,2,3,0,4,5,0]
        int[] arr = {1,0,2,3,0,4,5,0};
        for (int i = 0; i <= arr.length - 1; i++){
            if (arr[i] == 0){
                for (int x = arr.length - 1; x > i; x--){
                    arr[x] = arr[x - 1];
                }
                i++;
            }
        }
    }

    public static void duplicateZeros() {
        int[] arr = {8,4,5,0,0,0,0,7};
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                int val  = length_ - possibleDups;
                if (left == val) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }


    }

    public static void merge() {

        int[] nums1 = {2,0};
        int[] nums2 = {1};
        int m = nums1.length; int n = nums2.length;
        int count = 0;

        for (int i = 0; i <= m - 1; i++) {
            if (n > 0) {
                if (i <= m - n - 1) {
                    if (nums1[i] < nums2[count] || nums1[i] == nums2[count]) {
                        continue;
                    } else {
                        for (int x = m - n - 1; x >= i; x--) {
                            nums1[x + 1] = nums1[x];
                        }
                        nums1[i] = nums2[count];
                        n--;
                        count++;
                    }
                } else {
                    nums1[i] = nums2[count];
                    count++;
                }
            }
        }
    }

    public static int[] twoSum(int[] num, int target) {
        //Approach
        //Step 2: loop thru the array, get the value at each index
        //Step 3: subtract target from it
        //Step4 : store it in an int variable called holder
        //At each loop check if that holder is found
        int[] nums = {3,2,4};
        int[] result = new int[2];
        var index1= -1;
        var holder2 = 0;

        for(int i = 0; i <= nums.length - 1; i++)
        {
            if(index1 == -1){
                index1=i;
                var ind = i;
                var val = nums[i];
                var targ = target;
                holder2 = target - nums[i];
            }

            if(holder2 == nums[i] && i != index1){
                result[0] = index1;
                result[1] = i;
                break;
            }
            else{
                //gotten to end of array and did not see a match, we reset everything
                if(i == nums.length - 1){
                    i =index1;
                    index1 = -1;
                }
                else{
                    continue;
                }

            }

        }
        return result;
    }

    public static void rotate(int[] num, int k) {
        int[] nums = {1,2};
        int noofLoops = k % nums.length;
        int[] result = new int[nums.length];
        int x = 0;
        int remaining = nums.length - noofLoops;
        for(int i = nums.length - noofLoops; i <= nums.length - 1; i++){
            result[x] = nums[i];
            x++;
        }
        for(int j = 0; j <= remaining - 1; j++){
            result[x] = nums[j];
            x++;
        }

        System.arraycopy(result, 0, nums, 0, result.length);
    }

    public static boolean containsDuplicate(int[] num) {
        //O(n^2) Time limit exceeds on large input not a good solution
        int[] nums = {1,7,8,3,4,6,2,5,1};
        int index =0;
        for(int i= 1; i<nums.length; i++){
            if(nums[index] == nums[i]){
                return true;
            }
            else{
                if(i == nums.length - 1 && index == nums.length - 2){
                    return false;
                }
                else if(i==nums.length-1){
                    index++;
                    i = index;
                }
            }
        }
        return false;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int countHolder = 0;
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            char item = s.charAt(i);
            if(!map.containsKey(item)){
                count++;
                map.put(item, count);
                if (count > countHolder){
                    countHolder = count;
                }
            }
            else{
                count = 1;
                //check if item is the same as the last item that was entered
                if (item != s.charAt(i - 1)){
                    count++;
                }
                if(count > countHolder){
                    countHolder = count;
                }
                map.put(item, count);
            }
        }
        return countHolder;
    }

    public static int maxArea(int[] num) {
        int[] nums = {2,3,4,5,18,17,6};
        int len = nums.length-1;
        int area = 0;
        int max=0;

        for(int i = 0; i < len; i++){
            int width=Math.abs(i-len);
            int min = Math.min(nums[len], nums[i]);
            area =min *width;
            if(max<area){
                max=area;
            }
            if(nums[len] < nums[i]){
                i--;
                len--;
            }
        }

        return max;
    }

    public static int[][] rotateImage(int[][] matrixx) {
        /*
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[7,4,1],[8,5,2],[9,6,3]]
        */

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}, {1,1,1}};
        int n = 0;
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                int whatToAdd = matrix[i][j];
                result[j][n] = whatToAdd;
            }
            n++;
        }
        System.arraycopy(result, 0, matrix, 0, result.length);
        return result;
    }

    public static boolean canJump(int[] num) {
        //not passing all test cases yet
        int[] nums = {1,1,2,2,0,1,1};
        //value:3
        //pointer:0
        //reduce:0
        int pointer = 0;
        int len = nums.length - 1;
        int reduceHolder = 0;
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;

        int reduceBy =0;
        for(int i = 0; i < len; i++){

            while(pointer < len){
                int value = nums[pointer]-reduceBy;
                reduceBy=0;
                pointer += value;
                if(value < 1 && pointer < len){
                    break;
                }
                if(pointer >= len){
                    return true;
                }
            }

            reduceHolder++;
            reduceBy = reduceHolder;
            pointer = 0;
        }

        return false;
    }

    public static int[] plusOne(int[] digit) {
        //129
        int[] digits = {1,9,9,9};
        int[] nums = new int[digits.length + 1];
        int carry = 1;
        for(int i = digits.length -1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] +=carry;
                return digits;
            }
            //handle the 9 ish
            digits[i] = 0;
            nums[i] = 0;
        }
        nums[0] = carry;
        return nums;
    }

    public static String minWindow(String s, String t) {
        String result = "";
        String resultHolder = "";
        boolean complete = false;
        for(int left = 0; left <=s.length()-1; left++){
            if(t.contains(""+s.charAt(left)))
            {
                result = result + s.charAt(left);
                for(int i = left + 1; i <= s.length()-1; i++){
                    result = result + s.charAt(i);
                    //checking if all the characters in t are now in result
                    for(int j=0; j <= t.length()-1; j++){
                        if(result.contains(""+t.charAt(j))){
                            if(j == t.length()-1) complete = true; //checks if we are checking the last character in t
                            continue;
                        }
                        left++;//can't rem why i used left in this loop
                        break;
                    }
                    if(complete){
                        if(result.length() > resultHolder.length() ){
                            resultHolder = result;
                            result = ""; //reset result and start next batch
                            break;
                        }
                    }
                }
            }
        }
        return resultHolder;
    }

    //this method checks if two strings are anagram
    //approach: loop and put the characters of the first string in a hashmap with the character as key and no of times it appears as integer
    //loop thru the second string and match the characters, whenever you find the match of any character in the map, less the occurence by 1
    //in the end, all values in the map must be 0, if it's less or greater than zero, then they are not anagrams
    public static boolean isAnagram(String first, String second){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i: first.toCharArray()) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
            else
                map.put(i, map.get(i) + 1);
        }
            for(char i: second.toCharArray()) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) - 1);
                    if (map.containsValue(-1)) {
                        return false;
                    }
                }
                else return false;
            }
                for(Map.Entry c: map.entrySet()){
                    if((int)c.getValue() > 0){
                        return false;
                    }
                }
                return true;
    }
}
