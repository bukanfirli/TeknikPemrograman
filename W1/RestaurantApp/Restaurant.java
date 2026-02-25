public class Restaurant {

    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int id = 0;

    public String getNamaMakanan(int index) {
        return namaMakanan[index];
    }

    public double getHargaMakanan(int index) {
        return hargaMakanan[index];
    }

    public int getStok(int index) {
        return stok[index];
    }

    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }

        namaMakanan[id] = nama;
        hargaMakanan[id] = harga;
        this.stok[id] = stok;
        id++;
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            if (stok[i] > 0) {
                System.out.println(
                    namaMakanan[i] + " [" + stok[i] + "] \tRp. " + hargaMakanan[i]
                );
            }
        }
    }

    public void pesanMakanan(int index, int jumlah) {
        if (index >= id) {
            System.out.println("Menu tidak ditemukan!");
            return;
        }

        if (jumlah <= 0) {
            System.out.println("Jumlah pesanan tidak valid!");
            return;
        }

        if (stok[index] >= jumlah) {
            stok[index] -= jumlah;
            System.out.println("Pesanan berhasil!");
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) {
        stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }
}
