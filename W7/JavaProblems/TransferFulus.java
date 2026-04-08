package JavaProblems;

class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {

        Account acc1 = new Account();
        Account acc2 = new Account();

        // SOLUSI: Gunakan urutan penguncian yang SAMA di kedua thread
        // Kunci selalu acc1 dulu, baru acc2, tidak peduli arah transfernya
        // Dengan begitu tidak akan pernah terjadi kondisi saling menunggu

        // Thread 1: Transfer dari acc1 ke acc2
        Thread t1 = new Thread(() -> {

            // Mengunci acc1 terlebih dahulu
            synchronized (acc1) {
                System.out.println("T1: Mengunci acc1, bersiap transfer ke acc2...");

                try { Thread.sleep(100); } catch (Exception e) {}

                // Mengunci acc2 setelah acc1
                synchronized (acc2) {
                    System.out.println("T1: Transfer acc1 -> acc2 berhasil!");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Transfer dari acc2 ke acc1
        Thread t2 = new Thread(() -> {

            // SAMA seperti T1, kunci acc1 dulu, baru acc2
            // Untuk mencegah deadlock karena urutannya tidak lagi terbalik
            synchronized (acc1) {
                System.out.println("T2: Mengunci acc1, bersiap transfer ke acc1...");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) {
                    System.out.println("T2: Transfer acc2 -> acc1 berhasil!");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}