package perpus.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoPerpus {
    ArrayList<Peminjam> peminjamList = new ArrayList<>();
    ArrayList<Koleksi> koleksiList = new ArrayList<>();
    ArrayList<Transaksi> transaksiList = new ArrayList<>();
    dbPerpus dataPerpus;
        
    public DaoPerpus(){
        dataPerpus = new dbPerpus();
        try {
            peminjamList = dataPerpus.getPeminjam();
            koleksiList = dataPerpus.getKoleksi();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshPeminjam() {
        peminjamList.clear();
        try {
            peminjamList = dataPerpus.getPeminjam();
        } catch (Exception ex) {
            Logger.getLogger(DaoPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshKoleksi() {
        koleksiList.clear();
        try {
            koleksiList = dataPerpus.getKoleksi();
        } catch (Exception ex) {
            Logger.getLogger(DaoPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshTransaksi() {
        transaksiList.clear();
        try {
            transaksiList = dataPerpus.getTransaksi();
        } catch (Exception ex) {
            Logger.getLogger(DaoPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
