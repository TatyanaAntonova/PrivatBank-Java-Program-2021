import java.util.ArrayList;

public class CarDealerShip extends Thread {
    private static class CarList<String> extends ArrayList {
        boolean isOpen = true;

        @Override
        public void add(int index, Object o) {
            if (super.size() == 5) {
                return;
            }
            super.add(o);
        }

        public boolean isFull() {
            if (super.size() == 5) return true;
            return false;
        }

        public void setOpen() {
            isOpen = !isOpen;
        }

        public boolean isOpen() {
            return isOpen;
        }
    }

    private static final Object lock = new Object();
    private static CarList carList = new CarList<>();

    private static class Producer extends Thread {
        int carId = 0;

        @Override
        public void run() {
            while (carId < 10) {
                synchronized (lock) {
                    try {
                        int index = 0;

                        while (!carList.isFull()) {
                            System.out.println("Producer " + getName() + " is working now.");
                            carList.add(index, "a new car number " + carId);
                            System.out.println("Producer produced " + carList.get(index));
                            carId++;
                            index++;
                        }

                        lock.notify();
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            carList.setOpen();
        }
    }

    private static class Buyer extends Thread {
        @Override
        public void run() {
            while (carList.isOpen()) {
                synchronized (lock) {
                    try {
                        while (!carList.isEmpty()) {
                            System.out.println("Buyer " + getName() + " is working now.");
                            System.out.println("Buyer bought " + carList.remove(0));
                        }

                        lock.notify();
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Car dealership closed.");
        }
    }

    public static void main(String[] args){
        System.out.println("Car dealership has opened and start working.");
        new Producer().start();
        new Buyer().start();

    }
}
