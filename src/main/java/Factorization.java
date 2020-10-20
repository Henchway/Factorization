import java.util.ArrayList;
import java.util.Arrays;


public class Factorization implements Runnable {

    Long numberToFactor;
    int bit;

    public Factorization(Long numberToFactor, int bit) {
        this.numberToFactor = numberToFactor;
        this.bit = bit;
    }

    public void combine() {

        long start = System.nanoTime();
        ArrayList<Long> factors = factorize(numberToFactor);
        long end = System.nanoTime();

        System.out.println("##############################################");
        System.out.println("Number to factor: " + numberToFactor + ", " + bit + " bits");
        System.out.println("The prime factors are " + Arrays.toString(factors.toArray()));
        long timeElapsed = (end - start) / 1000000;
        System.out.println("The calculation of the factors took " + timeElapsed + " ms");


        System.out.println("##############################################");
    }

    public ArrayList<Long> factorize(Long input) {

        ArrayList<Long> factors = new ArrayList<>();

        long toBeFactored = input;
        for (long i = 2; i <= input / 2; i++) {
            while (toBeFactored % i == 0) {
                factors.add(i);
                toBeFactored = toBeFactored / i;
                System.out.println(Arrays.toString(factors.toArray()));
            }

            long numberCheck = 1;
            for (Long factor : factors) {
                numberCheck *= factor;
            }

            if (numberCheck == input) {
                return factors;
            }

        }

//
//        while (i <= input / 2) {
//
//            if (toBeFactored % i == 0) {
//                factors.add(i);
//                toBeFactored = toBeFactored / i;
//            }
//
//            if (toBeFactored % i != 0) {
//                i++;
//            }
//
//
//
//            if (i % 16777216 == 0) {
//                System.out.println(Arrays.toString(factors.toArray()) + ", i: " + i);
//            }
//        }

        return factors;
    }


    @Override
    public void run() {
        combine();
    }
}
