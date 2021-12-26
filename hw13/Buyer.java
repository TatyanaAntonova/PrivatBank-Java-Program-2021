public class Buyer extends Thread{
    private final Object lock;
    private final CarDealerShip carList;

    protected Buyer (Object lock, CarDealerShip carList){
        this.lock = lock;
        this.carList = carList;
    }

    @Override
    public void run() {
        while (carList.isOpen()) {
            synchronized (lock) {
                try {
                    while (!carList.isEmpty()) {
                        //System.out.println("Buyer " + getName() + " is working now.");
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
