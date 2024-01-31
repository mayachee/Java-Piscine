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
        Runnable eggRunnable = new Egg(count);
        Thread eggThread = new Thread(eggRunnable);
        try {
            eggThread.start();
            eggThread.join(count * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Using Thread
        Hen henThread = new Hen(count);
        try {
            henThread.start();
            henThread.join(count * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread's messages
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
