package RentalMobil;

public class Pelanggan {

    private int idPeminjam, jumlahMobil, ktp;
    private String nama;
    private LinkedListObject list;
    private Mobil mobil;
    private double harga;

    public Pelanggan() {
        this.list = new LinkedListObject();
    }

    public int getIdPeminjam() {
        return idPeminjam;
    }

    public void setIdPeminjam(int idPeminjam) {
        this.idPeminjam = idPeminjam;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LinkedListObject getList() {
        return list;
    }

    public void addList(Mobil mobil) {
        this.list.addFirst(mobil);
    }

    public int getJumlahMobil() {
        return jumlahMobil;
    }

    public void setJumlahMobil(int jumlahMobil) {
        this.jumlahMobil = jumlahMobil;
    }

    public int getKtp() {
        return ktp;
    }

    public void setKtp(int ktp) {
        this.ktp = ktp;
    }

  public void cetak(){
      System.out.println("ID Peminjam\t: "+getIdPeminjam());
      System.out.println("Jumlah Mobil\t: "+getJumlahMobil());
      System.out.println("Mobil yang dipesan beserta detailnya: ");
      System.out.println("");
      System.out.println("Mobil\tJenis Kendali");
  }

}
