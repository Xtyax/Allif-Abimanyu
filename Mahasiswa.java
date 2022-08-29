package perpus.app;

import java.io.Serializable;

public class Mahasiswa extends Peminjam implements Serializable {
    private String nim;

    public Mahasiswa() {
        super();
        this.nim="0";
    }

    public Mahasiswa(String id_peminjam, String nama, String alamat, int mak_pinjam, String nim) {
        super(id_peminjam, nama, alamat, mak_pinjam);
        this.nim = nim;
    }

    
    
    /**
     * @return the nim
     */
    public String getNim() {
        return nim;
    }

    /**
     * @param nim the nim to set
     */
    public void setNim(String nim) {
        this.nim = nim;
    }

 
}
