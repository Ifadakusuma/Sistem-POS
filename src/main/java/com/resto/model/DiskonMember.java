package com.resto.model;

/**
 * Strategi diskon berbasis persentase untuk pelanggan member.
 */
public class DiskonMember implements Diskon {
    private double persen;

    /**
     * Konstruktor default DiskonMember.
     */
    public DiskonMember() {
    }

    /**
     * Konstruktor berparameter untuk DiskonMember.
     *
     * @param persen Persentase diskon (0 sampai 100)
     */
    public DiskonMember(double persen) {
        setPersen(persen);
    }

    public double getPersen() {
        return persen;
    }

    /**
     * Mengatur persentase diskon member.
     *
     * @param persen Nilai persentase (0 sampai 100)
     */
    public void setPersen(double persen) {
        if (Double.isNaN(persen) || persen < 0 || persen > 100) {
            throw new IllegalArgumentException("Persentase diskon member harus berada di antara 0 hingga 100.");
        }
        this.persen = persen;
    }

    /**
     * Menghitung nominal diskon member berdasarkan persentase dari total tagihan.
     *
     * @param total Total tagihan sebelum diskon
     * @return Nominal potongan diskon
     */
    @Override
    public double hitungDiskon(double total) {
        if (Double.isNaN(total) || total < 0) {
            throw new IllegalArgumentException("Total tagihan tidak boleh bernilai negatif.");
        }
        return total * (persen / 100.0);
    }

    @Override
    public String toString() {
        return "DiskonMember{" +
                "persen=" + persen +
                '}';
    }
}

