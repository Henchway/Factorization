public class Main {

    public static void main(String[] args) {


        Factorization factorization = new Factorization((long) Math.pow(2,64) - 1, 64);
        factorization.run();

//        for (int i = 0; i < 4; i++) {
//            new Thread(new Factorization((long) Math.pow(2, 50 + i) - 1, 50 + i)).start();
//        }

    }

}
