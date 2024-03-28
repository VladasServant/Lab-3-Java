
public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        int [] count = {3, 3};
        main.starter(count, 3, 10);
    }

    private void starter(int[] count, int storageSize, int itemNumbers) {
        Manager manager = new Manager(storageSize);

        for (int i = 0; i < count[0]; i++) {
            new Thread(new Consumer(itemNumbers, manager, i)).start();
        }

        for (int i = 0; i < count[1]; i++) {
            new Thread(new Producer(itemNumbers, manager, i)).start();
        }
    }
}