package com.resto.model;

/**
 * Kelas konkret yang merepresentasikan entitas Makanan dalam katalog restoran.
 * Merupakan turunan dari kelas abstrak Menu dan menerapkan Template Method
 * untuk memperhitungkan biaya layanan pemanasan.
 */
public class Makanan extends Menu {
    private boolean dipanaskan;

    // Biaya tambahan jika makanan meminta layanan pemanasan
    private static final double BIAYA_PEMANASAN = 2000.0;

    /**
     * Konstruktor default Makanan.
     */
    public Makanan() {
        super();
    }

    /**
     * Konstruktor berparameter untuk Makanan.
     *
     * @param idMenu     ID unik menu (misal: "MAK01")
     * @param nama       Nama makanan
     * @param harga      Harga dasar makanan
     * @param stok       Kuantitas stok tersedia
     * @param dipanaskan Status apakah makanan dipanaskan sebelum disajikan
     */
    public Makanan(String idMenu, String nama, double harga, int stok, boolean dipanaskan) {
        super(idMenu, nama, harga, stok);
        this.dipanaskan = dipanaskan;
    }

    public boolean isDipanaskan() {
        return dipanaskan;
    }

    public void setDipanaskan(boolean dipanaskan) {
        this.dipanaskan = dipanaskan;
    }

    /**
     * Mengimplementasikan metode abstrak hitungHarga() dari kelas Menu.
     * Menambahkan biaya layanan jika opsi pemanasan aktif.
     *
     * @return Total harga satuan makanan setelah penyesuaian layanan
     */
    @Override
    public double hitungHarga() {
        double totalHarga = getHarga();
        if (dipanaskan) {
            totalHarga += BIAYA_PEMANASAN;
        }
        return totalHarga;
    }

    @Override
    public String toString() {
        return "Makanan{" +
                "idMenu='" + getIdMenu() + '\'' +
                ", nama='" + getNama() + '\'' +
                ", hargaDasar=" + getHarga() +
                ", dipanaskan=" + dipanaskan +
                ", hargaAkhir=" + hitungHarga() +
                ", stok=" + getStok() +
                '}';
    }
}

