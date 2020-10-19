import java.util.ArrayList;
import java.util.Arrays;


public class Factorization implements Runnable {

    Long numberToFactor;
    int bit;
    boolean[] isPrimeArray;

    public Factorization(Long numberToFactor, int bit) {
        this.numberToFactor = numberToFactor;
        this.bit = bit;
        isPrimeArray = new boolean[Math.toIntExact(numberToFactor / 2)];
        Arrays.fill(isPrimeArray, true);
    }

    public void combine() {


        if (!isPrimeWithoutArray(numberToFactor)) {

            long startPrimeNumbers = System.nanoTime();
            long[] potentialFactors = getPrimeListSieve();

            long endPrimeNumbers = System.nanoTime();
//            System.out.println("Potential factors are " + Arrays.toString(potentialFactors.toArray()));
            long timeElapsedPrimeNumbers = (endPrimeNumbers - startPrimeNumbers) / 1000000;


            long start = System.nanoTime();
            ArrayList<Long> factors = factorize(numberToFactor, potentialFactors);
            long end = System.nanoTime();

            System.out.println("##############################################");
            System.out.println("Number to factor: " + numberToFactor + ", " + bit + " bits");
            System.out.println("The calculation of prime numbers took " + timeElapsedPrimeNumbers + " ms");
            System.out.println("The prime factors are " + Arrays.toString(factors.toArray()));
            long timeElapsed = (end - start) / 1000000;
            System.out.println("The calculation of the factors took " + timeElapsed + " ms");

        } else {
            System.out.println("The prime factor is " + numberToFactor);
        }


        System.out.println("##############################################");

    }

    public boolean isPrime(Long input) {

        long boundary = (long) Math.ceil(Math.sqrt(input));

        for (int i = 2; i < isPrimeArray.length && i <= boundary; i++) {
            if (isPrimeArray[i]) {
                if (input % i == 0 && input != i) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPrimeWithoutArray(Long input) {

        long boundary = (long) Math.ceil(Math.sqrt(input));
        for (long i = 2; i != input && i <= boundary; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }


    public long[] getPrimeListSieve() {

        for (long i = 2; i < isPrimeArray.length && isPrimeArray[(int) i]; i++) {
            if (isPrime(i)) {
                for (int j = 2; j * i < isPrimeArray.length; j++) {
                    isPrimeArray[(int) (j * i)] = false;
                }
            }
        }

        int arraySize = 0;
        for (int i = 2; i < isPrimeArray.length; i++) {
            if (isPrimeArray[i]) {
                arraySize++;
            }
        }

        long[] potentialFactors = new long[arraySize];

        for (int i = 2, j = 0; i < isPrimeArray.length; i++) {
            if (isPrimeArray[i]) {
                potentialFactors[j] = i;
                j++;
            }
        }

        return potentialFactors;


    }

    public ArrayList<Long> factorize(Long input, long[] potentialFactors) {

        ArrayList<Long> factors = new ArrayList<>();
        Long toBeFactored = input;
        int i = 0;
        while (i < potentialFactors.length) {
            while (toBeFactored % potentialFactors[i] == 0) {
                factors.add(potentialFactors[i]);
                toBeFactored = toBeFactored / potentialFactors[i];

                if (factors.size() > 0) {
                    long readyCheck = 1;
                    for (Long factor : factors) {
                        readyCheck *= factor;
                    }
                    if (readyCheck == input) {
                        return factors;
                    }
                }
            }
            i++;
        }

        return factors;
    }


    @Override
    public void run() {
        combine();
    }
}
