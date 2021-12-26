public class Main {
    public static void main(String[] args) {
        final Object lock = new Object();
        CarDealerShip carList = new CarDealerShip();

        System.out.println("Car dealership has opened and start working.");

        new Producer(lock, carList).start();
        new Buyer(lock, carList).start();
    }
}
