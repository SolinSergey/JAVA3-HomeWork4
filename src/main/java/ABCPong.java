public class ABCPong {

    private static Object monitor;
    private static char letter = 'A';

    public static void main(String[] args) {
        monitor = new Object();
        Thread thread1 = new Thread(() ->{
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (letter != 'A') {
                            monitor.wait();
                        }
                        System.out.print("A");
                        letter = 'B';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() ->{
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (letter != 'B') {
                            monitor.wait();
                        }
                        System.out.print("B");
                        letter = 'C';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(() ->{
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (letter != 'C') {
                            monitor.wait();
                        }
                        System.out.print("C");
                        letter = 'A';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

