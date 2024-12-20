import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rearrange {
    
   
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public static int[] rearrange(int[] arr) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> nonPrimes = new ArrayList<>();
        
      
        for (int num : arr) {
            if (isPrime(num)) {
                primes.add(num);
            } else {
                nonPrimes.add(num);
            }
        }
        
      
        Collections.sort(primes, Collections.reverseOrder());
        
       
        Collections.sort(nonPrimes, Collections.reverseOrder());
        
     
        List<Integer> result = new ArrayList<>();
        
     
        result.add(primes.get(0));
        
     
        result.addAll(nonPrimes);
        
       
        result.add(primes.get(primes.size() - 1));
        

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
      
        int[] arr1 = {5, 1, 8, 11, 2};
        int[] result1 = rearrange(arr1);
        System.out.println(java.util.Arrays.toString(result1));
      
        int[] arr2 = {1, 6, 4, 13, 9, 3};
        int[] result2 = rearrange(arr2);
        System.out.println(java.util.Arrays.toString(result2)); 
    }
}