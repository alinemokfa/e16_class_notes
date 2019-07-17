package com.codeclan.example.fibonacci;

/**
 * Created by user on 17/07/2017.
 */

class Fibonacci {
    public static int solve(int i) {
       if(i < 2){
           return 1;
       }

       return Fibonacci.solve(i - 1) + Fibonacci.solve(i - 2);
    }
}