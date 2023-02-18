package com.example.checkersaigame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class mergeSort {
    public static ArrayList<Integer> ScoresOrdered = new ArrayList<>();
    /**
     * @param input
     *          , integer array to be sorted
     * @param start
     *          index of first element in array
     * @param end
     *          index of last element in array
     */

    public static void merge (int[] input){
        mergesort(input,0,input.length-1);
        System.out.println("the scores are:");
        for (int i = 0; i < input.length-1; i++) {
            System.out.println(i+1+": "+input[i+1]);
        }
    }

    public static void mergesort(int[] input, int start, int end) {

        // break problem into smaller structurally identical problems
        int mid = (start + end) / 2;
        if (start < end) {
            mergesort(input, start, mid);
            mergesort(input, mid + 1, end);
        }

        // merge solved pieces to get solution to original problem
        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];

        while (first <= mid && last <= end) {
            tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
        }
        while (first <= mid) {
            tmp[i++] = input[first++];
        }
        while (last <= end) {
            tmp[i++] = input[last++];
        }
        i = 0;
        while (start <= end) {
            input[start++] = tmp[i++];
        }
    }
}
