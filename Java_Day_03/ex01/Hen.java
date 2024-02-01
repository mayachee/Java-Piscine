package Java_Day_03.ex01;

class Hen implements Runnable {
    private final EggHenMonitor monitor;
    private final int count;

    public Hen(EggHenMonitor monitor, int count) {
        this.monitor = monitor;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            monitor.printHen();
        }
    }
}