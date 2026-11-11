package com.resto.model;

/**
 * Kelas abstrak dasar yang merepresentasikan entitas Menu dalam katalog restoran.
 * Mengimplementasikan template dasar untuk perhitungan harga varian produk
 * dan pengelolaan stok inventori.
 */
public abstract class Menu {
    private String idMenu;
    private String nama;
    private double harga;
    private int stok;

    /**
     * Konstruktor default Menu.
     */
    public Menu() {
    }

    /**
     * Konstruktor berparameter untuk inisialisasi Menu.
     *
     * @param idMenu ID unik menu (misal: "M01", "D01")
     * @param nama   Nama item menu
     * @param harga  Harga dasar menu
     * @param stok   Kuantitas stok yang tersedia
     */
    public Menu(String idMenu, String nama, double harga, int stok) {
        this.idMenu = idMenu;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // --- Getter dan Setter ---

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    /**
     * Memperbarui kuantitas stok menu.
     *
     * @param jumlah Jumlah stok baru
     */
    public void setStok(int jumlah) {
        if (jumlah < 0) {
            throw new IllegalArgumentException("Stok tidak boleh bernilai negatif.");
        }
        this.stok = jumlah;
    }

    /**
     * Mengurangi stok menu sejumlah kuantitas pesanan.
     *
     * @param jumlah Jumlah yang dikurangi
     * @return true jika pengurangan berhasil, false jika stok tidak mencukupi
     */
    public boolean kurangiStok(int jumlah) {
        if (jumlah > 0 && this.stok >= jumlah) {
            this.stok -= jumlah;
            return true;
        }
        return false;
    }

    /**
     * Menambah stok menu (misal saat restock atau pembatalan item).
     *
     * @param jumlah Jumlah yang ditambahkan
     */
    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            this.stok += jumlah;
        }
    }

    /**
     * Metode abstrak untuk menghitung harga spesifik per porsi menu.
     * Di-override oleh subclass (Makanan dan Minuman) untuk memperhitungkan
     * kustomisasi varian (ukuran, suhu, biaya pemanasan).
     *
     * @return Harga akhir per unit menu setelah varian diperhitungkan
     */
    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu='" + idMenu + '\'' +
                ", nama='" + nama + '\'' +
                ", harga=" + harga +
                ", stok=" + stok +
                '}';
    }
}

