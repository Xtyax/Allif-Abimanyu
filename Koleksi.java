package perpus.app;

import java.io.Serializable;

public class Koleksi implements Serializable {
    protected String id_koleksi;
    protected String judul;
    protected String penerbit;
    protected boolean status_pinjam;

    public Koleksi() {
        this.id_koleksi = "0000000";
        this.judul="noTitle";
        this.penerbit="none";
        this.status_pinjam = Boolean.FALSE;
    }

    public Koleksi(String id_koleksi, String judul, String penerbit, boolean status_pinjam) {
        this.id_koleksi = id_koleksi;
        this.judul = judul;
        this.penerbit = penerbit;
        this.status_pinjam = status_pinjam;
    }
    /**
     * @return the idKoleksi
     */
    public String getIdKoleksi() {
        return id_koleksi;
    }

    /**
     * @param idKoleksi the idKoleksi to set
     */
    public void setIdKoleksi(String id_koleksi) {
        this.id_koleksi = id_koleksi;
    }

    /**
     * @return the judul
     */
    public String getJudul() {
        return judul;
    }

    /**
     * @param judul the judul to set
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * @return the penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }

    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    /**
     * @return the status_Pinjam
     */
    public boolean isStatus_pinjam() {
        return status_pinjam;
    }

    /**
     * @param status_Pinjam the status_Pinjam to set
     */
    public void setStatus_Pinjam(boolean status_pinjam) {
        this.status_pinjam = status_pinjam;
    }

   
}
