package Java_Day_03.ex01;

class EggHenMonitor {
    private boolean eggTurn = true;

    public synchronized void printEgg() {
        while (!eggTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Egg");
        eggTurn = false;
        notify();
    }

    public synchronized void printHen() {

        while (eggTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hen");
        eggTurn = true;

        notify();
    }
}
