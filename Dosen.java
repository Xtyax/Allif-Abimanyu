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
public class Dosen extends Peminjam implements Serializable{
     private String nip;

    public Dosen() {
        super();
        this.nip="0";
    }

    public Dosen(String id_peminjam, String nama, String alamat, int mak_pinjam, String nip) {
        super(id_peminjam, nama, alamat, mak_pinjam);
        this.nip = nip;
    }

    
    /**
     * @return the nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * @param nip the nip to set
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    
 
}
