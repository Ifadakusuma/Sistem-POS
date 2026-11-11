package com.resto.model;

/**
 * Merepresentasikan satu baris item pada transaksi pesanan restoran.
 * Memiliki relasi aggregation ke entitas {@link Menu} dan menghitung subtotal
 * berdasarkan harga satuan akhir menu dikalikan jumlah porsi.
 */
public class ItemPesanan {
    private Menu menu;
    private int jumlah;
    private String catatan;

    /**
     * Konstruktor default ItemPesanan.
     */
    public ItemPesanan() {
        this.catatan = "";
    }

    /**
     * Konstruktor berparameter ItemPesanan tanpa catatan khusus.
     *
     * @param menu   Objek Menu yang dipesan
     * @param jumlah Kuantitas porsi yang dipesan
     */
    public ItemPesanan(Menu menu, int jumlah) {
        this(menu, jumlah, "");
    }

    /**
     * Konstruktor berparameter lengkap untuk ItemPesanan.
     *
     * @param menu    Objek Menu yang dipesan
     * @param jumlah  Kuantitas porsi yang dipesan (harus lebih dari 0)
     * @param catatan Catatan khusus pelanggan (misal: "tidak pedas")
     */
    public ItemPesanan(Menu menu, int jumlah, String catatan) {
        setMenu(menu);
        setJumlah(jumlah);
        setCatatan(catatan);
    }

    public Menu getMenu() {
        return menu;
    }

    /**
     * Menetapkan referensi Menu pada item pesanan ini.
     *
     * @param menu Objek Menu (tidak boleh null)
     */
    public void setMenu(Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("Menu pada item pesanan tidak boleh null.");
        }
        this.menu = menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    /**
     * Memperbarui kuantitas item yang dipesan.
     *
     * @param jumlah Kuantitas pesanan (harus lebih dari 0)
     */
    public void setJumlah(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah item pesanan harus lebih dari 0.");
        }
        this.jumlah = jumlah;
    }

    public String getCatatan() {
        return catatan;
    }

    /**
     * Mengatur catatan khusus untuk item pesanan.
     *
     * @param catatan Catatan pesanan (nilai null dinormalisasi menjadi string kosong)
     */
    public void setCatatan(String catatan) {
        this.catatan = (catatan == null) ? "" : catatan;
    }

    /**
     * Menghitung subtotal biaya untuk item pesanan ini.
     * Memanggil metode polimorfik {@link Menu#hitungHarga()} dikalikan {@code jumlah}.
     *
     * @return Subtotal harga item pesanan
     */
    public double hitungSubtotal() {
        if (menu == null) {
            throw new IllegalStateException("Menu belum ditentukan untuk item pesanan ini.");
        }
        if (jumlah <= 0) {
            throw new IllegalStateException("Jumlah item pesanan harus lebih dari 0.");
        }
        return menu.hitungHarga() * jumlah;
    }

    @Override
    public String toString() {
        String namaMenu = (menu != null) ? menu.getNama() : "Belum dipilih";
        String subtotalStr = (menu != null && jumlah > 0)
                ? String.format("Rp %,.2f", hitungSubtotal())
                : "Rp 0.00";
        return "ItemPesanan{" +
                "menu='" + namaMenu + '\'' +
                ", jumlah=" + jumlah +
                ", catatan='" + catatan + '\'' +
                ", subtotal=" + subtotalStr +
                '}';
    }
}

