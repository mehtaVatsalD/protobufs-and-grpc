package io.simplecoder.grpc.utils;

import java.util.HashMap;
import java.util.Map;

public final class PrimeNumbersUtils {

    private PrimeNumbersUtils(){}

    private static final Map<Integer, Long> nthPrimeNumberMap = new HashMap<>();
    private static final Map<Long, Boolean> isPrimeMap = new HashMap<>();

    public static boolean isPrime(long num) {
        if (isPrimeMap.containsKey(num)) {
            return isPrimeMap.get(num);
        }
        boolean isPrime = true;
        for (long i=2; i<=Math.sqrt(num); i++) {
            if (num%i == 0) {
                isPrime = false;
                break;
            }
        }
        isPrimeMap.put(num, isPrime);
        return isPrime;
    }

    // brute force implementation
    public static long getNthPrimeNumber(int n) {
        if (nthPrimeNumberMap.containsKey(n)) {
            return nthPrimeNumberMap.get(n);
        }
        long i = 2;
        int itr = 0;
        while (true) {
            if (isPrime(i)) {
                itr++;
                nthPrimeNumberMap.put(itr,i);
                if (itr == n) {
                    return i;
                }
            }
            i++;

        }
    }



}
