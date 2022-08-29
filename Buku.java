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
public class Buku extends Koleksi implements Serializable{
    private String isbn;
    private int halaman;

    public Buku (){
        super();
        this.halaman = 0;
        this.isbn = "noISBN";
    }
    public Buku (String id_koleksi, String judul, String penerbit, boolean status_pinjam, int halaman, String isbn) {
        super(id_koleksi, judul, penerbit, status_pinjam);
        this.halaman = halaman;
        this.isbn = isbn;
        
    }
    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the hal
     */
    public int getHalaman() {
        return halaman;
    }

    /**
     * @param hal the hal to set
     */
    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }
}
