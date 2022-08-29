/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus.app;

import java.io.Serializable;

/**
 *
 * @author hertada
 */
public class Umum extends Peminjam implements Serializable {
     private String nik;

    public Umum() {
        super();
        this.nik="0";
    }

    public Umum(String id_peminjam, String nama, String alamat, int mak_pinjam, String nik) {
        super(id_peminjam, nama, alamat, mak_pinjam);
        this.nik = nik;
    }

    
    /**
     * @return the nomorKTP
     */
    public String getNik() {
        return nik;
    }

    /**
     * @param nik the nik to set
     */
    public void setNik(String nik) {
        this.nik = nik;
    }

    
 
}
