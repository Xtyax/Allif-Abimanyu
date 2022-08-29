package perpus.app;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DafKoleksi {
    ArrayList<Koleksi> koleksiList = new ArrayList<>();
        
    public DafKoleksi(){

    }
    
    public void dafKoleksi(Koleksi data) {
            try {
                koleksiList.add(data);
            } catch (Exception ex) {
                Logger.getLogger(DafKoleksi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
