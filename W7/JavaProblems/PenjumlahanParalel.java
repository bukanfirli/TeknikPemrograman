package JavaProblems;

import java.util.Scanner;

public class PenjumlahanParalel {
    
    private static long totalAkhir = 0;

    public static void main(String[] args) throws InterruptedException {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = scanner.nextInt();
        
        System.out.print("Masukkan angka akhir: ");
        long angkaAkhir = scanner.nextLong();
        
        scanner.close();

        // Membagi range angka secara merata ke setiap thread
        // Contoh: angkaAkhir=1000, jumlahThread=4, setiap thread dapat 250 angka
        long bagianPerThread = angkaAkhir / jumlahThread;

        // Array untuk menyimpan semua thread
        Thread[] threads = new Thread[jumlahThread];

        for (int i = 0; i < jumlahThread; i++) {
            
            // Menentukan batas awal dan akhir untuk setiap thread
            long start = (i * bagianPerThread) + 1;
            long end = (i == jumlahThread - 1) ? angkaAkhir : (i + 1) * bagianPerThread;
            // Thread terakhir mengambil sisa angka jika tidak habis dibagi
            
            // Menyimpan index i ke variabel final agar bisa dipakai di lambda
            final int threadIndex = i + 1;

            threads[i] = new Thread(() -> {
                
                // Setiap thread menghitung hasil parsialnya sendiri secara lokal
                // Variabel lokal ini aman dari race condition karena tidak dibagi
                long hasilParsial = 0;
                for (long j = start; j <= end; j++) {
                    hasilParsial += j;
                }

                System.out.println("Thread-" + threadIndex + 
                    ": Menjumlahkan " + start + " - " + end + 
                    " | Hasil Parsial: " + hasilParsial);

                // Bagian ini perlu synchronized karena totalAkhir adalah
                // variabel bersama yang diakses oleh semua thread
                synchronized (PenjumlahanParalel.class) {
                    totalAkhir += hasilParsial;
                }
            });

            threads[i].start();
        }

        // Main thread menunggu semua thread selesai sebelum mencetak hasil akhir
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\n--- HASIL AKHIR ---");
        System.out.println("Total penjumlahan 1 sampai " + angkaAkhir + ": " + totalAkhir);
        
        // Verifikasi menggunakan rumus matematika n*(n+1)/2
        long totalBenar = angkaAkhir * (angkaAkhir + 1) / 2;
        System.out.println("Verifikasi (rumus n*(n+1)/2): " + totalBenar);
        System.out.println("Hasil " + (totalAkhir == totalBenar ? "BENAR ✓" : "SALAH ✗"));
    }
}