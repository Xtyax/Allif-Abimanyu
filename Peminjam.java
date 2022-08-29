package perpus.app;

import java.io.Serializable;

public class Peminjam implements Serializable{
    protected String id_peminjam;
    protected String nama;
    protected String alamat;
    protected int mak_pinjam;

    public Peminjam() {
        this.id_peminjam = "0000000";
        this.nama="noname";
        this.alamat="none";
        this.mak_pinjam = 0;
    }

    public Peminjam(String id_peminjam, String nama, String alamat, int mak_pinjam) {
        this.id_peminjam = id_peminjam;
        this.nama = nama;
        this.alamat = alamat;
        this.mak_pinjam = mak_pinjam;
    }
      
    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the id_peminjam
     */
    public String getId_peminjam() {
        return id_peminjam;
    }

    /**
     * @param id_peminjam the id_peminjam to set
     */
    public void setId_peminjam(String id_peminjam) {
        this.id_peminjam = id_peminjam;
    }

    /**
     * @return the mak_pinjam
     */
    public int getMak_pinjam() {
        return mak_pinjam;
    }

    /**
     * @param mak_pinjam the mak_pinjam to set
     */
    public void setMak_pinjam(int mak_pinjam) {
        this.mak_pinjam = mak_pinjam;
    }
    }

   
