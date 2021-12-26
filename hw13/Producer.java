public class Producer extends Thread{
    private final Object lock;
    private final CarDealerShip carList;

    protected Producer(Object lock, CarDealerShip carList){
        this.lock = lock;
        this.carList = carList;
    }

    @Override
    public void run() {
        int carId = 0;

        while (carId < 10) {
            synchronized (lock) {
                try {
                    int index = 0;

                    while (!carList.isFull()) {
                        //System.out.println("Producer " + getName() + " is working now.");
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

