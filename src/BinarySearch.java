public class BinarySearch {

    public int mySqrt(int x) {

        //sqrt of a number x is any number that when it multiplies itself, the answer is that number x
        // so the target value is x and what we are checking is if the current value multiplied by itself
        //would give us x. and the range can only be from 1 to x.
        int left = 2;
        int right = x/2;

        if(x < 2) return x;

        int middle = 0; // 7
        int lowerBound = 0;
        long num;

        while(left <= right){
            middle = left + (right - left)/2;
            num = (long)middle * middle;
            if(num == x){
                return middle;
            }
            else if(num < x){
                //search to the right
                left = middle + 1;
            }

            else if(num > x){
                //search to the left
                right = middle - 1;
            }
        }
        //leaving the while loop means it didn't see an integer, so it's gonna be a decimal, so we return the left - 1 or right cos at this point right is smaller than left
        return right;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int guess = 0;
        //the target value here is the pick, which can be determined by answer variable
        while(left <= right){
            guess = left + (right - left)/2;
            int answer = guess(guess);
            if(answer == -1){ //my guess is higher, I should guess a lower number
                right = guess - 1;
            }else if(answer == 1){ // my guess is lower, I should guess a higher number
                left = guess + 1;
            }else return guess; // i guessed right
        }

        //the pick is not in the list, what do we return? returning my guess jare
        return guess;

    }
    private static int guess(int num){
        //this is a representation of an external api available for the problem
        int pick = 5;
        if(pick < num) return -1;
        else if(pick > num) return 1;
        else return 0;
    }
}
