/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.createradix;

import java.util.Arrays;

/**
 *
 * @author School
 */
public class RadixSort {
    
    
    
    public static void main(String[] args){
        
        int[] testArray = new int[20];
        
        int arrayLength = testArray.length;
        
        
        for(int i = 0; i < testArray.length; i++)
            testArray[i] = (int) (Math.random() * 900) + 100;
//testArray[i] = (int) (Math.random() * 10);
            
        
        
        
        
        System.out.println("Unsorted: ");
        for(int i = 0; i < testArray.length; i++)
            System.out.print(testArray[i] + " ");
        
        radixSort(testArray, arrayLength);
        
        /*
        
        
        
        System.out.println("\nCountArray Pre: ");
        for(int i = 0; i < count.length; i++)
            System.out.println(i + " " + count[i] + " ");
        
        
        
        System.out.println("\nCountArray Post: ");
        for(int i = 0; i < count.length; i++)
            System.out.println(i + " " + count[i] + " ");
        
        */
        System.out.println("\nSorted: ");
        for(int i = 0; i < testArray.length; i++)
            System.out.print(testArray[i] + " ");
        
    }
    
    static void radixSort(int[] inputArray, int arrayLength){
        int max = getMax(inputArray);
        
        for(int exp = 1; max / exp > 0; exp *= 10){
            countSort(inputArray, arrayLength, exp);
        }
    }
    
    static int getMax(int[] inputArray){
        int max = inputArray[0];
        for(int i = 0; i < inputArray.length; i++){
            if(max < inputArray[i]){
                max = inputArray[i];
            }
        }
        return max;
    }
    
    static void countSort(int[] inputArray, int arrayLength, int exp){
        
        
      /* This code is contributed by Devesh Agrawal */  
      
        int output[] = new int[arrayLength]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < arrayLength; i++)
            count[(inputArray[i] / exp) % 10]++;
            
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = arrayLength - 1; i >= 0; i--) {
            output[count[(inputArray[i] / exp) % 10] - 1] = inputArray[i];
            count[(inputArray[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < arrayLength; i++)
            inputArray[i] = output[i];
        
        /* This code is contributed by Devesh Agrawal */
        
        
        
        /* This was my attempt, successful in single units (counting sort) 
       int[] count = new int[10];
        
        int[] output = new int[inputArray.length];
        
        for(int i = 0; i < inputArray.length; i++){
            count[inputArray[i]]++;
        }
        
        
        //build output
        int outputIndex = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                output[outputIndex] = i;
                count[i]--;
                outputIndex++;
            }
        }
        
        //replace original array
        for(int i = 0; i < arrayLength; i++){
            inputArray[i] = output[i];
        }
        */
    }
    
}
