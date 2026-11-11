package com.resto;

import com.resto.model.Diskon;
import com.resto.model.DiskonMember;
import com.resto.model.DiskonVoucher;
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

        // 5. Simulasi Strategy Pattern Diskon (DiskonMember & DiskonVoucher)
        System.out.println("\n--- SIMULASI STRATEGI DISKON ---");
        double totalKotor = (jumlahPesan * menu1.hitungHarga()) + menu2.hitungHarga();
        System.out.printf("Total Kotor Pesanan: Rp %,.2f\n", totalKotor);

        Diskon diskonMember = new DiskonMember(10.0);
        Diskon diskonVoucher = new DiskonVoucher(15000.0);
        Diskon voucherMelebihiTotal = new DiskonVoucher(200000.0);

        tampilkanSimulasiDiskon("Member (10%)", diskonMember, totalKotor);
        tampilkanSimulasiDiskon("Voucher (Rp 15.000)", diskonVoucher, totalKotor);
        tampilkanSimulasiDiskon("Voucher (Rp 200.000)", voucherMelebihiTotal, totalKotor);

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

    private static void tampilkanSimulasiDiskon(String label, Diskon diskon, double totalKotor) {
        double potongan = diskon.hitungDiskon(totalKotor);
        double totalAkhir = totalKotor - potongan;
        System.out.printf("%-22s | Potongan: Rp %,.2f | Total Akhir: Rp %,.2f\n",
                label,
                potongan,
                totalAkhir
        );
    }
}

