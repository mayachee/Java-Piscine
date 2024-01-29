package Java_Day_03.ex00;

public class Program {
    public static void main(String[] args) {
        int count = 50; // Default count
        if (args.length > 0) {
            for (String arg : args) {
                if (arg.startsWith("--count=")) {
                    count = Integer.parseInt(arg.substring(8));
                }
            }
        }

        // Using Runnable
        Runnable eggRunnable = new EggRunnable(count);
        Thread eggThread = new Thread(eggRunnable);
        eggThread.start();

        // Using Thread
        HenThread henThread = new HenThread(count);
        henThread.start();

        // Main thread's messages
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}

class EggRunnable implements Runnable {
    private int count;

    public EggRunnable(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("Egg");
        }
    }
}

class HenThread extends Thread {
    private int count;

    public HenThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("Hen");
        }
    }
}
