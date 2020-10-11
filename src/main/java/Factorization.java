import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Factorization {

    public static void main(String[] args) {

        combine((long) Math.pow(2, 50) - 1);

    }

    public static void combine(Long numberToFactor) {

        System.out.println("##############################################");
        System.out.println("Number to factor: " + numberToFactor);

        if (!isPrime(numberToFactor)) {

            long startPrimeNumbers = System.nanoTime();
            ArrayList<Long> potentialFactors = getPrimeList(numberToFactor);
            long endPrimeNumbers = System.nanoTime();

//            System.out.println("Potential factors are " + Arrays.toString(potentialFactors.toArray()));
            long timeElapsedPrimeNumbers = (endPrimeNumbers - startPrimeNumbers) / 1000000;
            System.out.println("The calculation of prime numbers took " + timeElapsedPrimeNumbers + " ms");

            long start = System.nanoTime();
            ArrayList<Long> factors = factorize(numberToFactor, potentialFactors);
            long end = System.nanoTime();

            System.out.println("The prime factors are " + Arrays.toString(factors.toArray()));
            long timeElapsed = (end - start) / 1000000;
            System.out.println("The calculation of the factors took " + timeElapsed + " ms");

        } else {
            System.out.println("The prime factor is " + numberToFactor);
        }

        System.out.println("##############################################");

    }


    public static boolean isPrime(Long input) {

        long boundary = (long) Math.ceil(Math.sqrt(input));

        for (long i = 2; i != input && i <= boundary; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static ArrayList<Long> getPrimeList(Long upperLimit) {

        ArrayList<Long> sieveList = new ArrayList<>();
        for (long i = 2; i < Math.ceil(Math.sqrt(upperLimit)); i++) {
            sieveList.add(i);
        }

        for (int i = 0; i < sieveList.size(); i++) {
            long number = sieveList.get(i);
            if (isPrime(number)) {
                int j = 2;

                while(number * j < Math.ceil(Math.sqrt(upperLimit))) {
                    sieveList.remove((number *j));
                    j++;
                }

            }
        }

        return sieveList;

    }

    public static ArrayList<Long> factorize(Long input, ArrayList<Long> potentialFactors) {

        ArrayList<Long> factors = new ArrayList<>();

        potentialFactors.forEach(Long -> {

            Long toBeFactored = input;
            while (toBeFactored % Long == 0) {
                factors.add(Long);
                toBeFactored = toBeFactored / Long;
            }
        });

        return factors;
    }


}
