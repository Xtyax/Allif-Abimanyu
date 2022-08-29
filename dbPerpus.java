package perpus.app;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class dbPerpus {

    ArrayList<Peminjam> peminjamList = new ArrayList<>();
    ArrayList<Koleksi> koleksiList = new ArrayList<>();
    ArrayList<Transaksi> transaksiList = new ArrayList<>();
    ArrayList<Koleksi> pesanKoleksiList;
    Dosen dosen = null;
    Mahasiswa mahasiswa = null;
    Umum umum = null;
    Disk dvd = null;
    Buku buku = null;
    Majalah majalah = null;
    Transaksi transaksi = null;
    String jdbcURL = "jdbc:oracle:thin:@//127.0.0.1:1521/xepdb1";
    String user = "system";
    String password = "admin";
    Connection conn = null;
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    Date tgl_kembali;
    Date tgl_pinjam;
    float denda = 0;

    dbPerpus() {
        dbConnect();
    }

    dbPerpus(String usr, String pwd) {
        user = usr;
        password = pwd;
        dbConnect();
    }

    void dbConnect() {
        boolean stat = Boolean.FALSE;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("Koneksi Berhasil");
            if (conn != null) {
                stat = Boolean.TRUE;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    Connection getConnection() {
        return conn;
    }

    ArrayList<Peminjam> getPeminjam() throws SQLException {
        peminjamList.clear();
        stmt = null;
        rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM dosen");

        while (rs.next()) {
            dosen = new Dosen(
                    rs.getString("id_peminjam"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getInt("mak_pinjam"),
                    rs.getString("nip")
            );
            peminjamList.add(dosen);
        }

        rs = null;
        rs = stmt.executeQuery("SELECT * FROM mahasiswa");

        while (rs.next()) {
            mahasiswa = new Mahasiswa(
                    rs.getString("id_peminjam"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getInt("mak_pinjam"),
                    rs.getString("nim")
            );
            peminjamList.add(mahasiswa);
        }

        rs = null;
        rs = stmt.executeQuery("SELECT * FROM umum");

        while (rs.next()) {
            umum = new Umum(
                    rs.getString("id_peminjam"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getInt("mak_pinjam"),
                    rs.getString("nik")
            );
            peminjamList.add(umum);
        }

        return peminjamList;
    }

    ArrayList<Koleksi> getKoleksi() throws SQLException {
        koleksiList.clear();
        stmt = null;
        rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM dvd");
        while (rs.next()) {
            dvd = new Disk(
                    rs.getString("id_koleksi"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getBoolean("status_pinjam"),
                    rs.getString("format"),
                    rs.getString("isbn")
            );
            koleksiList.add(dvd);
        }

        rs = null;
        rs = stmt.executeQuery("SELECT * FROM buku");

        while (rs.next()) {
            buku = new Buku(
                    rs.getString("id_koleksi"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getBoolean("status_pinjam"),
                    rs.getInt("halaman"),
                    rs.getString("isbn")
            );
            koleksiList.add(buku);
        }
        rs = null;
        rs = stmt.executeQuery("SELECT * FROM majalah");

        while (rs.next()) {
            majalah = new Majalah(
                    rs.getString("id_koleksi"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getBoolean("status_pinjam"),
                    rs.getInt("volume"),
                    rs.getInt("seri"),
                    rs.getString("issn")
            );
            koleksiList.add(majalah);
        
        }

        return koleksiList;
    }

    ArrayList<Transaksi> getTransaksi() throws SQLException {
        transaksiList.clear();
        rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT DISTINCT id_transaksi,tgl_pinjam, tgl_kembali, id_peminjam,denda FROM transaksi");

        while (rs.next()) {
            String idPK = rs.getString("id_transaksi");
            pstmt = null;
            pstmt = conn.prepareStatement("SELECT id_koleksi FROM transaksi WHERE id_transaksi = ?");
            pstmt.setString(1, idPK);
            ResultSet rp = pstmt.executeQuery();

            pesanKoleksiList = new ArrayList<>();
            while (rp.next()) {
                String idK = rp.getString("id_koleksi");
                ResultSet rq;
                char tipe = idK.charAt(0);
                switch (tipe) {
                    case 'D':
                        pstmt = null;
                        pstmt = conn.prepareStatement("SELECT * FROM dvd WHERE id_koleksi = ?");
                        pstmt.setString(1, idK);
                        rq = pstmt.executeQuery();

                        while (rq.next()) {
                            dvd = new Disk(
                                    rq.getString("id_koleksi"),
                                    rq.getString("judul"),
                                    rq.getString("penerbit"),
                                    rq.getBoolean("status_pinjam"),
                                    rq.getString("format"),
                                    rq.getString("isbn")
                            );
                            pesanKoleksiList.add(dvd);
                        }

                        rq.close();
                        break;
                    case 'M':
                        pstmt = null;
                        pstmt = conn.prepareStatement("SELECT * FROM majalah WHERE id_koleksi = ?");
                        pstmt.setString(1, idK);
                        rq = pstmt.executeQuery();

                        while (rq.next()) {
                            majalah = new Majalah(
                                    rq.getString("id_koleksi"),
                                    rq.getString("judul"),
                                    rq.getString("penerbit"),
                                    rq.getBoolean("status_pinjam"),
                                    rq.getInt("volume"),
                                    rq.getInt("seri"),
                                    rq.getString("issn")
                            );
                            pesanKoleksiList.add(majalah);
                        }

                        rq.close();
                        break;
                    case 'B':
                        pstmt = null;
                        pstmt = conn.prepareStatement("SELECT * FROM buku WHERE id_koleksi = ?");
                        pstmt.setString(1, idK);
                        rq = pstmt.executeQuery();

                        while (rq.next()) {
                            buku = new Buku(
                                    rq.getString("id_koleksi"),
                                    rq.getString("judul"),
                                    rq.getString("penerbit"),
                                    rq.getBoolean("status_pinjam"),
                                    rq.getInt("halaman"),
                                    rq.getString("isbn")
                            );
                            pesanKoleksiList.add(buku);
                        }

                        rq.close();
                        break;
                    default:
                }
            }
            String idP = rs.getString("id_peminjam");
            pstmt = null;
            pstmt = conn.prepareStatement("SELECT * FROM peminjam WHERE id_peminjam = ?");
            pstmt.setString(1, idP);
            ResultSet rpp = pstmt.executeQuery();
            rpp.first();
            Dosen peminjam = new Dosen(
                    rpp.getString("id_peminjam"),
                    rpp.getString("nama"),
                    rpp.getString("alamat"),
                    rpp.getInt("mak_pinjam"),
                    rpp.getString("nip")
            );
            transaksi = new Transaksi(
                    rs.getString("id_transaksi"),
                    rs.getDate("tgl_pinjam").toLocalDate(),
                    rs.getDate("tgl_kembali").toLocalDate(),
                    rs.getFloat("denda"),
                    pesanKoleksiList,
                    peminjam
            );
            transaksiList.add(transaksi);

        }

        return transaksiList;
    }

    public int pinjam(String id_transaksi, ArrayList<Koleksi> arkoleksi, Peminjam peminjam) {
        tgl_pinjam = Date.valueOf(LocalDate.now());
        tgl_kembali = Date.valueOf(LocalDate.now().plusDays(30));
        String kueri = "INSERT INTO transaksi VALUES (?,?,?,?,?,?)";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            for (Koleksi n : arkoleksi) {
                pstmt.setString(1, id_transaksi);
                pstmt.setDate(2, tgl_pinjam);
                pstmt.setDate(3, tgl_kembali);
                pstmt.setFloat(4, 0);
                pstmt.setString(5, n.id_koleksi);
                pstmt.setString(6, peminjam.getId_peminjam());
                rq = pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rq = 1;
        }
        return rq;
    }

    public int kembali(String id_transaksi, LocalDate tgPinjam) {
        String idTx = id_transaksi;
        LocalDate haripinjam = tgPinjam;
        LocalDate hariini = LocalDate.now();
        tgl_kembali = Date.valueOf(hariini);
        long telat = ChronoUnit.DAYS.between(haripinjam, hariini);
        if (telat > 30) {
            denda = (telat - 30) * 1000; //dedan 1000 per hari.
        }
        String kueri = "UPDATE transaksi SET tgl_kembali = ?, denda = ? WHERE id_transaksi = ?";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setDate(1, tgl_kembali);
            pstmt.setFloat(2, denda);
            pstmt.setString(3, idTx);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rq = 1;
        }
        denda = 0;
        return rq;
    }

    int insertDosen(String id_peminjam, String nama, String alamat, int mak_pinjam, String nip) {
        String kueri = "INSERT INTO dosen VALUES (?,?,?,?,?)";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_peminjam);
            pstmt.setString(2, nama);
            pstmt.setString(3, alamat);
            pstmt.setInt(4, mak_pinjam);
            pstmt.setString(5, nip);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    int insertMahasiswa(String id_peminjam, String nama, String alamat, int mak_pinjam, String nim) {
        String kueri = "INSERT INTO mahasiswa VALUES (?,?,?,?,?)";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_peminjam);
            pstmt.setString(2, nama);
            pstmt.setString(3, alamat);
            pstmt.setInt(4, mak_pinjam);
            pstmt.setString(5, nim);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    int insertUmum(String id_peminjam, String nama, String alamat, int mak_pinjam, String nik) {
        String kueri = "INSERT INTO umum VALUES (?,?,?,?,?)";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_peminjam);
            pstmt.setString(2, nama);
            pstmt.setString(3, alamat);
            pstmt.setInt(4, mak_pinjam);
            pstmt.setString(5, nik);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
    
   int updateMahasiswa(String id_peminjam, String nama, String alamat, int mak_pinjam, String nim) {
        String kueri = String.format("UPDATE mahasiswa SET nama = '%s', "
                + "alamat = '%s', mak_pinjam = %d, nim = '%s' WHERE id_peminjam = '%s'",
                nama, alamat, mak_pinjam, nim, id_peminjam);
        int rq = 0;
        try {
            stmt = conn.createStatement();
            rq = stmt.executeUpdate(kueri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
    
    int updateDosen(String id_peminjam, String nama, String alamat, int mak_pinjam, String nip) {
        String kueri = String.format("UPDATE Dosen SET nama = '%s', "
                + "alamat = '%s', mak_pinjam = %d, nip = '%s' WHERE id_peminjam = '%s'",
                nama, alamat, mak_pinjam, nip, id_peminjam);
        int rq = 0;
        try {
            stmt = conn.createStatement();
            rq = stmt.executeUpdate(kueri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
    
     int updateUmum(String id_peminjam, String nama, String alamat, int mak_pinjam, String nik) {
        String kueri = String.format("UPDATE umum SET nama = '%s', "
                + "alamat = '%s', mak_pinjam = %d, nik = '%s' WHERE id_peminjam = '%s'",
                nama, alamat, mak_pinjam, nik, id_peminjam);
        int rq = 0;
        try {
            stmt = conn.createStatement();
            rq = stmt.executeUpdate(kueri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
    int deleteDosen(String id_peminjam) {
        String kueri = "DELETE FROM dosen WHERE id_peminjam = ?";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_peminjam);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    int deleteMahasiswa(String id_peminjam) {
        String kueri = "DELETE FROM mahasiswa WHERE id_peminjam = ?";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_peminjam);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    int deleteUmum(String id_peminjam) {
        String kueri = "DELETE FROM umum WHERE id_peminjam = ?";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_peminjam);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
  
    int updateBuku(String id_koleksi, String judul, String penerbit, boolean status_pinjam, int halaman, String isbn) {
        String kueri = String.format("UPDATE Buku SET judul = '%s',penerbit = '%s'," + "status_pinjam = %d, halaman = %d, isbn = '%s' WHERE id_koleksi = '%s'",
               judul, penerbit, status_pinjam ? 1 : 0,  halaman, isbn, id_koleksi);
        int rq = 0;
        try {
            stmt = conn.createStatement();
            rq = stmt.executeUpdate(kueri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
    
   int updateMajalah(String id_koleksi, String judul, String penerbit, boolean status_pinjam, int volume, int seri, String issn) {

        String kueri = String.format("UPDATE majalah SET  judul = '%s',penerbit = %s," 
                +"status_pinjam = '%d', volume='%d',seri='%d',issn='%s'"
                +"WHERE id_koleksi = '%s'",
                judul, penerbit, status_pinjam ? 1:0, volume, seri, issn, id_koleksi);         
        int rq = 0;
        try {
            rq = stmt.executeUpdate(kueri);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;

    }
         int updateDisk(String id_koleksi, String judul, String penerbit, boolean status_pinjam, String format, String isbn) {
        String kueri = String.format("UPDATE Disk SET judul = '%s',penerbit = '%s',"+ "status_pinjam = '%s', format = %d, isbn = '%d' WHERE id_koleksi = '%s'",
                judul, penerbit, status_pinjam ? 1 : 0, format, isbn, id_koleksi);
        int rq = 0;
        try {
            stmt = conn.createStatement();
            rq = stmt.executeUpdate(kueri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
int insertBuku(String id_koleksi, String judul, String penerbit, boolean status_pinjam, int halaman, String isbn){
        String kueri = "INSERT INTO buku VALUES (?,?,?,?,?,?)";
        pstmt = null;
        int rq = 0;
        try{
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_koleksi);
            pstmt.setString(2, judul);
            pstmt.setString(3, penerbit);
            pstmt.setBoolean(4, status_pinjam);
            pstmt.setInt(5, halaman);
            pstmt.setString(6, isbn);
            rq = pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return rq;
    } 
    int insertMajalah(String id_koleksi, String judul, String penerbit, boolean status_pinjam, int volume, int seri, String issn){
        String kueri = "INSERT INTO majalah VALUES (?,?,?,?,?,?,?)";
        pstmt = null;
        int rq = 0;
        try{
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_koleksi);
            pstmt.setString(2, judul);
            pstmt.setString(3, penerbit);
            pstmt.setBoolean(4, status_pinjam);
            pstmt.setInt(5, volume);
            pstmt.setInt(6, seri);
            pstmt.setString(7, issn);
            rq = pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return rq;
    }
    
    int insertDisk(String id_koleksi, String judul, String penerbit, boolean status_pinjam, String format, String isbn){
        String kueri = "INSERT INTO disk VALUES (?,?,?,?,?,?)";
        pstmt = null;
        int rq = 0;
        try{
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_koleksi);
            pstmt.setString(2, judul);
            pstmt.setString(3, penerbit);
            pstmt.setBoolean(4, status_pinjam);
            pstmt.setString(5, format);
            pstmt.setString(6, isbn);
            rq = pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return rq;
    }
       int deleteBuku(String id_koleksi) {
        String kueri = "DELETE FROM buku WHERE id_koleksi = ?";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_koleksi);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
    
    int deleteDisk(String id_koleksi) {
        String kueri = "DELETE FROM disk WHERE id_koleksi = ?";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_koleksi);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
    
    int deleteMajalah(String id_koleksi) {
        String kueri = "DELETE FROM majalah WHERE id_koleksi = ?";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_koleksi);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
    int deleteTransaksi(String id_transaksi) {
        String kueri = "DELETE FROM transaksi WHERE id_transaksi = ?";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(kueri);
            pstmt.setString(1, id_transaksi);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    int updateTransaksi(String id_Transaksi, LocalDate tgl_pinjam) {
        LocalDate haripinjam = tgl_pinjam;
        LocalDate hariini = LocalDate.now();
        tgl_kembali = Date.valueOf(hariini);
        long telat = ChronoUnit.DAYS.between(haripinjam, hariini);
        if (telat > 30) {
            denda = (telat - 30) * 1000; //dedan 1000 per hari.
        }
        String query = "UPDATE transaksi SET  tgl_pinjam = '" + tgl_pinjam + "',denda ='"
                + denda + "' where id_transaksi = '" + id_Transaksi + "'";
        pstmt = null;
        int rq = 0;
        try {
            pstmt = conn.prepareStatement(query);
            rq = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "apakah anda yakin akan mengubah data transaksi?", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex.getMessage());
        }
        return rq;
    }
    
          public static void main(String[] args) throws SQLException {
        dbPerpus test = new dbPerpus ("system", "admin");
        test.getKoleksi();
        test.getConnection();
        test.dbConnect();
    }
    }