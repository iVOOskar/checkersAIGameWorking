package com.example.checkersaigame;

import java.util.Arrays;

public class mergeSort {
    public static void merge(int merge[], int beg, int mid, int end) {
        int i, j, k;
        int temp1 = mid - beg + 1;
        int temp2 = end - mid;

        int LeftArray[] = new int[temp1];
        int RightArray[] = new int[temp2]; //temporary arrays

        //copy data to temp arrays
        for (i = 0; i < temp1; i++)
            LeftArray[i] = merge[beg + i];
        for (j = 0; j < temp2; j++)
            RightArray[j] = merge[mid + 1 + j];

        i = 0;
        // initial index of first sub-array
        j = 0;
        // initial index of second sub-array
        k = beg;
        // initial index of merged sub-array

        while (i < temp1 && j < temp2) {
            if (LeftArray[i] <= RightArray[j]) {
                merge[k] = LeftArray[i];
                i++;
            } else {
                merge[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < temp1) {
            merge[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < temp2) {
            merge[k] = RightArray[j];
            j++;
            k++;
        }
        System.out.println("The scores are:");
        int pos = merge.length;
        for (int l = 0; l < merge.length; l++) {
            System.out.println(pos+": userID-"+starterMenuController.UserId.get(l)+" with "+ merge[l]);
            pos--;
        }
    }
}
