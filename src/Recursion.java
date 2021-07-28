package com.company;

public class Recursion {

    public static int fib(int n){
        //returns the nth value of a fibonacci sequence recursively
        if(n<=2) return 1;
        return fib(n - 1) + fib(n-2);
    }

    public static int factorial(int n){
        //calculates the factorial of a number recursively
        if(n==1) return 1;
        return n * factorial(n - 1);
    }

    public  String reverse(String word){
        //reverses a string iteratively
        StringBuffer str = new StringBuffer();
        for(int i = word.length() - 1; i >= 0; i--){
            str.append(word.charAt(i));
        }
        return str.toString();
    }

    public  String reverseRecursively(int index, char[] str){
        //reverses a string recursively
        if (str == null || index >= str.length) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        reverseRecursively(index + 1, str);
        //return str[index] + reverseRecursively(index + 1, str);
        //System.out.print(str[index]);
        var v = str[index];
        ret.append(v);
        return ret.toString();
    }

    public  int sum(int n){
        //sums numbers from n to 1
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}
