package JavaProblems;

class RestoAman {
    private int chickenStock = 100;

    // SOLUSI: Tambahkan keyword synchronized pada method
    // Hanya 1 thread yang boleh masuk method ini dalam satu waktu
    // jadi pengecekan dan pengurangan stok menjadi atomik
    public synchronized void serveCustomer(String cashierName) {

        if (chickenStock > 0) {

            try { Thread.sleep(10); } catch (InterruptedException e) {}

            chickenStock--;

            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {

        RestoAman ayamJuicyLuicyGallagher = new RestoAman();

        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        kasir1.start();
        kasir2.start();
        kasir3.start();

        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}