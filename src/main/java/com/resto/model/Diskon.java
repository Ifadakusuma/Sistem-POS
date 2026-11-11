package com.resto.model;

/**
 * Interface strategi perhitungan diskon pada transaksi pesanan restoran.
 * Menerapkan Strategy Pattern agar jenis diskon dapat ditukar secara dinamis.
 */
public interface Diskon {

    /**
     * Menghitung nominal potongan diskon berdasarkan total tagihan kotor.
     *
     * @param total Total tagihan sebelum diskon
     * @return Nominal potongan diskon yang diberikan
     */
    double hitungDiskon(double total);
}

