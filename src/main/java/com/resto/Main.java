package com.resto;

import com.resto.model.ItemPesanan;
import com.resto.model.Makanan;
import com.resto.model.Menu;

/**
 * Titik masuk utama (Entry Point) untuk pengujian alur logika kelas model restoran.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("   SIMULASI SISTEM PEMESANAN RESTORAN (TEST RUN)   ");
        System.out.println("====================================================\n");

        // 1. Instansiasi objek Makanan (Polimorfisme: referensi Menu, objek Makanan)
        Menu menu1 = new Makanan("M01", "Nasi Goreng Spesial", 25000.0, 10, false);
        Menu menu2 = new Makanan("M02", "Ayam Bakar Madu", 30000.0, 5, true);

        // 2. Menampilkan rincian katalog menu
        System.out.println("--- DAFTAR MENU AWAL ---");
        tampilkanDetailMenu(menu1);
        tampilkanDetailMenu(menu2);

        // 3. Simulasi pemesanan & pengurangan stok
        System.out.println("\n--- SIMULASI PEMESANAN ---");
        int jumlahPesan = 3;
        System.out.println("Pelanggan memesan " + jumlahPesan + " porsi " + menu1.getNama() + "...");
        
        boolean berhasil = menu1.kurangiStok(jumlahPesan);
        if (berhasil) {
            double subtotal = jumlahPesan * menu1.hitungHarga();
            System.out.printf("Pesanan berhasil! Subtotal: Rp %,.2f\n", subtotal);
            System.out.println("Sisa stok " + menu1.getNama() + ": " + menu1.getStok());
        } else {
            System.out.println("Pesanan gagal! Stok tidak mencukupi.");
        }

        // 4. Simulasi kustomisasi (mengaktifkan pemanasan pada menu1)
        System.out.println("\n--- SIMULASI KUSTOMISASI LAYANAN ---");
        System.out.println("Mengubah preferensi " + menu1.getNama() + " menjadi dipanaskan (Takeaway)...");
        ((Makanan) menu1).setDipanaskan(true);
        tampilkanDetailMenu(menu1);

        // 5. Simulasi ItemPesanan (relasi aggregation ke Menu)
        System.out.println("\n--- SIMULASI ITEM PESANAN ---");
        ItemPesanan item1 = new ItemPesanan(menu1, jumlahPesan, "Pedas sedang");
        ItemPesanan item2 = new ItemPesanan(menu2, 1, "Bumbu pisah");
        tampilkanDetailItem(item1);
        tampilkanDetailItem(item2);

        double totalKotor = item1.hitungSubtotal() + item2.hitungSubtotal();
        System.out.printf("Total Kotor Pesanan: Rp %,.2f\n", totalKotor);

        System.out.println("\n====================================================");
        System.out.println("             PENGUJIAN KELAS SELESAI                ");
        System.out.println("====================================================");
    }

    private static void tampilkanDetailMenu(Menu menu) {
        System.out.printf("[%s] %-20s | Harga Dasar: Rp %,.2f | Harga Akhir: Rp %,.2f | Stok: %d\n",
                menu.getIdMenu(),
                menu.getNama(),
                menu.getHarga(),
                menu.hitungHarga(),
                menu.getStok()
        );
    }

    private static void tampilkanDetailItem(ItemPesanan item) {
        String catatan = item.getCatatan().isEmpty() ? "-" : item.getCatatan();
        System.out.printf("%dx %-20s | Catatan: %-14s | Subtotal: Rp %,.2f\n",
                item.getJumlah(),
                item.getMenu().getNama(),
                catatan,
                item.hitungSubtotal()
        );
    }
}

