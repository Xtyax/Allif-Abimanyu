package perpus.app;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Transaksi implements Serializable {
    protected String id_transaksi;
    protected LocalDate tgl_pinjam;
    protected LocalDate tgl_kembali;
    protected float denda = 0;
    public ArrayList<Koleksi> arkoleksi = new ArrayList<Koleksi>();;
    public Peminjam peminjam;
    protected static float priceDenda = 2000; 
    
    public Transaksi() {
        this.id_transaksi = "0000000";
        this.tgl_pinjam=LocalDate.of(2020, 2, 20);
        this.tgl_kembali=LocalDate.of(2020, 2, 20);
        this.denda=0;
        this.arkoleksi.add(new Koleksi());
        this.peminjam = new Peminjam();
    }

    public Transaksi(String id_transaksi, LocalDate tgl_pinjam, LocalDate tgl_kembali, float denda, ArrayList<Koleksi> arkoleksi, Peminjam peminjam) {
        this.id_transaksi = id_transaksi;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
        this.denda = denda;
        this.arkoleksi = arkoleksi;
        this.peminjam = peminjam;
    }

    public void pinjam(String id_transaksi, ArrayList<Koleksi> arkoleksi, Peminjam peminjam){
        this.id_transaksi = id_transaksi;
        tgl_pinjam = LocalDate.now();
        tgl_kembali = tgl_pinjam.plusDays(30);
        this.denda = 0;
        this.setArkoleksi(arkoleksi);
        this.peminjam = peminjam;
    }
    public void kembali(){
        LocalDate harini = LocalDate.now();
        this.tgl_kembali = harini;
        long telat =  ChronoUnit.DAYS.between(tgl_pinjam, harini);
        if (telat > 30) {
            denda = (telat - 30)* getPriceDenda();
        }
    }

    /**
     * @return the id_transaksi
     */
    public String getId_transaksi() {
        return id_transaksi;
    }

    /**
     * @param id_transaksi the id_transaksi to set
     */
    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    /**
     * @return the tgl_pinjam
     */
    public LocalDate getTgl_pinjam() {
        return tgl_pinjam;
    }

    /**
     * @param tgl_pinjam the tgl_pinjam to set
     */
    public void setTgl_pinjam(LocalDate tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    /**
     * @return the tgl_kembali
     */
    public LocalDate getTgl_kembali() {
        return tgl_kembali;
    }

    /**
     * @param tgl_kembali the tgl_kembali to set
     */
    public void setTgl_kembali(LocalDate tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    /**
     * @return the denda
     */
    public float getDenda() {
        return denda;
    }

    /**
     * @param denda the denda to set
     */
    public void setDenda(float denda) {
        this.denda = denda;
    }

    /**
     * @return the peminjam
     */
    public Peminjam getPeminjam() {
        return peminjam;
    }

    /**
     * @param peminjam the peminjam to set
     */
    public void setPeminjam(Peminjam peminjam) {
        this.peminjam = peminjam;
    }

    /**
     * @return the arkoleksi
     */
    public ArrayList<Koleksi> getArkoleksi() {
        return arkoleksi;
    }

    /**
     * @param arkoleksi the arkoleksi to set
     */
    public void setArkoleksi(ArrayList<Koleksi> arkoleksi) {
        this.arkoleksi = arkoleksi;
    }

    /**
     * @return the priceDenda
     */
    public static float getPriceDenda() {
        return priceDenda;
    }

    /**
     * @param aPriceDenda the priceDenda to set
     */
    public static void setPriceDenda(float aPriceDenda) {
        priceDenda = aPriceDenda;
    }
    
}
