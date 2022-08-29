package RentalMobil;

public class Mobil {

    protected String merk;
    protected int jumlah;
    protected double harga;
    protected double hari;
    protected String jenisKendali;

    public Mobil() {

    }

    public Mobil(String merk, int jumlah, double harga) {
        this.merk = merk;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        if (jenisKendali.equalsIgnoreCase("Matic")) {
            harga = 50000 + (harga * hari);
        } else {
            harga = 0 + (harga * hari);
        }

        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return merk + " | " + jenisKendali;
    }

}
