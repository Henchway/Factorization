import java.util.ArrayList;
import java.util.Arrays;


public class Factorization implements Runnable {

    Long numberToFactor;
    int bit;
    ArrayList<Long> primeArrayList = new ArrayList<>();

    public Factorization(Long numberToFactor, int bit) {
        this.numberToFactor = numberToFactor;
        this.bit = bit;
    }

    public void combine() {

        if (!isPrimeWithoutArray(numberToFactor)) {

            long startPrimeNumbers = System.nanoTime();
            getPrimeList(numberToFactor);
            long endPrimeNumbers = System.nanoTime();
//            System.out.println("Potential factors are " + Arrays.toString(primeArrayList.toArray()));
            long timeElapsedPrimeNumbers = (endPrimeNumbers - startPrimeNumbers) / 1000000;


            long start = System.nanoTime();
            ArrayList<Long> factors = factorize(numberToFactor);
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

        for (int i = 0; i < primeArrayList.size() && primeArrayList.get(i) <= boundary; i++) {

            if (input % primeArrayList.get(i) == 0 && !input.equals(primeArrayList.get(i))) {
                return false;
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



    public void getPrimeList(long i) {
        for (long j = 2; j < i/2; j++) {
            if (isPrime(j)) {
                primeArrayList.add(j);
            }
        }
    }


    public ArrayList<Long> factorize(Long input) {

        ArrayList<Long> factors = new ArrayList<>();
        Long toBeFactored = input;
        int i = 0;
        while (i < primeArrayList.size()) {
            while (toBeFactored % primeArrayList.get(i) == 0) {
                factors.add(primeArrayList.get(i));
                toBeFactored = toBeFactored / primeArrayList.get(i) ;

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
