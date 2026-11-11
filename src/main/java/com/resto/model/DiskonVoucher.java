package com.resto.model;

/**
 * Strategi diskon berbasis nominal potongan tetap (voucher).
 */
public class DiskonVoucher implements Diskon {
    private double nominalPotongan;

    /**
     * Konstruktor default DiskonVoucher.
     */
    public DiskonVoucher() {
    }

    /**
     * Konstruktor berparameter untuk DiskonVoucher.
     *
     * @param nominalPotongan Nominal potongan harga tetap
     */
    public DiskonVoucher(double nominalPotongan) {
        setNominalPotongan(nominalPotongan);
    }

    public double getNominalPotongan() {
        return nominalPotongan;
    }

    /**
     * Mengatur nominal potongan voucher.
     *
     * @param nominalPotongan Nominal potongan (tidak boleh negatif)
     */
    public void setNominalPotongan(double nominalPotongan) {
        if (Double.isNaN(nominalPotongan) || nominalPotongan < 0) {
            throw new IllegalArgumentException("Nominal potongan voucher tidak boleh bernilai negatif.");
        }
        this.nominalPotongan = nominalPotongan;
    }

    /**
     * Menghitung nominal diskon voucher dengan pembatasan agar tidak melebihi total tagihan.
     *
     * @param total Total tagihan sebelum diskon
     * @return Nominal potongan yang diterapkan (maksimal sebesar total tagihan)
     */
    @Override
    public double hitungDiskon(double total) {
        if (Double.isNaN(total) || total < 0) {
            throw new IllegalArgumentException("Total tagihan tidak boleh bernilai negatif.");
        }
        return Math.min(nominalPotongan, total);
    }

    @Override
    public String toString() {
        return "DiskonVoucher{" +
                "nominalPotongan=" + nominalPotongan +
                '}';
    }
}

