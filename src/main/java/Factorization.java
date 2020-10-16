import java.util.ArrayList;
import java.util.Arrays;


public class Factorization implements Runnable {

    Long numberToFactor;
    int bit;
    long[] allNumbers;
    boolean[] isPrimeArray;

    public Factorization(Long numberToFactor, int bit) {
        this.numberToFactor = numberToFactor;
        this.bit = bit;

        allNumbers = new long[(int) Math.ceil(Math.sqrt(numberToFactor))];
        for (int i = 0; i < allNumbers.length; i++) {
            allNumbers[i] = i;
        }
        isPrimeArray = new boolean[(int) Math.ceil(Math.sqrt(numberToFactor))];
        Arrays.fill(isPrimeArray, true);

    }

    public void combine() {


        if (!isPrime(numberToFactor)) {

            long startPrimeNumbers = System.nanoTime();
            ArrayList<Long> potentialFactors = getPrimeListSieve();

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

        for (int i = 2; i < allNumbers.length && i <= boundary; i++) {
            if (isPrimeArray[i]) {
                if (input % allNumbers[i] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<Long> getPrimeListSieve() {

        for (int i = 2; i < allNumbers.length && isPrimeArray[i]; i++) {
            if (isPrime(allNumbers[i])) {
                for (int j = 2; j * allNumbers[i] < allNumbers.length; j++) {
                    isPrimeArray[(int) (j * allNumbers[i])] = false;
                }
            }
        }

        ArrayList<Long> potentialFactors = new ArrayList<>();
        for (int i = 2; i < allNumbers.length; i++) {
            if (isPrimeArray[i]) {
                potentialFactors.add(allNumbers[i]);
            }
        }

        return potentialFactors;

    }

    public ArrayList<Long> factorize(Long input, ArrayList<Long> potentialFactors) {

        ArrayList<Long> factors = new ArrayList<>();
        Long toBeFactored = input;
        int i = 0;
        while (i < potentialFactors.size()) {
            while (toBeFactored % potentialFactors.get(i) == 0) {
                factors.add(potentialFactors.get(i));
                toBeFactored = toBeFactored / potentialFactors.get(i);

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
