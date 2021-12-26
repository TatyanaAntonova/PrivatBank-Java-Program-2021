import java.util.ArrayList;
import java.util.List;

public class CarDealerShip extends Thread {
    static class CarList<String> extends ArrayList {
        @Override
        public void add(int index, Object o) {
            if (super.size() == 5) {
                return;
            }
            super.add(o);
        }
    }

    private static final Object lock = new Object();
    private static List<String> carList = new CarList<>();

    static class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                synchronized (lock) {
                    try {
                        for (int j = 0; j < 5; j++, i++) {
                            System.out.println("Producer " + getName() + " is working now.");
                            carList.add(j, "a new car number " + i);
                            System.out.println("Producer produced " + carList.get(j));
                        }

                        lock.notify();
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Buyer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
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
        }
    }

    public static void main(String[] args) {
        new Producer().start();
        new Buyer().start();
    }
}
