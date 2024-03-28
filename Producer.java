class Producer implements Runnable {
    private final int itemNumbers;
    private final Manager manager;
    private final int producerNumber;

    public Producer(int itemNumbers, Manager manager, int producerNumber) {
        this.itemNumbers = itemNumbers;
        this.manager = manager;
        this.producerNumber = producerNumber;

    }

    @Override
    public void run() {
        for (int i = 0; i < itemNumbers; i++) {
            try {
                manager.full.acquire();
                manager.access.acquire();

                manager.storage.add("Producer " + producerNumber + ": item " + i);
                System.out.println("Producer " + producerNumber + ": Added item " + i);

                manager.access.release();
                manager.empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}