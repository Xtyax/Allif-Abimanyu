package perpus.app;

import java.io.Serializable;

public class Majalah extends Koleksi implements Serializable {
    private String issn;
    private int volume;
    private int seri;

    public Majalah (){
        super();
        this.volume = 0;
        this.seri = 0;
        this.issn = "noISSN";
    }

    public Majalah (String id_koleksi, String judul, String penerbit, boolean status_pinjam, int volume, int seri, String issn) {
        super(id_koleksi, judul, penerbit, status_pinjam);
        this.volume = volume;
        this.seri = seri;
        this.issn = issn;
    }
    /**
     * @return the issn
     */
    public String getIssn() {
        return issn;
    }

    /**
     * @param issn the issn to set
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }

    /**
     * @return the vol
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param vol the vol to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * @return the series
     */
    public int getSeri() {
        return seri;
    }

    /**
     * @param series the series to set
     */
    public void setSeri(int seri) {
        this.seri = seri;
    }
    
}
