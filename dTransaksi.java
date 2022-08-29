package perpus.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class dTransaksi extends javax.swing.JDialog {

    DaoPerpus dtPerpus;
    Peminjam dtpeminjam;
    Koleksi dtKoleksi;
    Transaksi dtTransaksi;
    ArrayList<Koleksi> dtPesanKoleksi;
    ArrayList<Transaksi> dtTrx;
    DefaultTableModel tbModelPesanKoleksi;
    DefaultTableModel tbModelTransaksi;
    TableColumnModel clModelPesanKoleksi;
    TableColumnModel clModelTransaksi;

    static String tglSekarang, tglKembali;
 
    public dTransaksi(java.awt.Frame parent, boolean modal, DaoPerpus dtPerpus) {
        super(parent, modal);
        initComponents();
        this.dtPerpus = dtPerpus;
        dtPesanKoleksi = new ArrayList();
        try {
            dtTrx = dtPerpus.dataPerpus.getTransaksi();
        } catch (SQLException ex) {
            Logger.getLogger(dTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        tampilPesanKoleksi();
        tampilTransaksi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNo1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfIdP = new javax.swing.JTextField();
        tfNamaP = new javax.swing.JTextField();
        tfJumlah_PinjamP = new javax.swing.JTextField();
        tfNidP = new javax.swing.JTextField();
        tfAlamatP = new javax.swing.JTextField();
        bCariP = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfIdK = new javax.swing.JTextField();
        tfJudulK = new javax.swing.JTextField();
        tfPenerbitK = new javax.swing.JTextField();
        tfStatusK = new javax.swing.JTextField();
        tfIsbnK = new javax.swing.JTextField();
        bCariKoleksi = new javax.swing.JButton();
        lVolumeK = new javax.swing.JLabel();
        tfVolumeK = new javax.swing.JTextField();
        lSeriK = new javax.swing.JLabel();
        tfSeriK = new javax.swing.JTextField();
        bTambahKoleksi = new javax.swing.JButton();
        btlPesanan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btPinjam = new javax.swing.JButton();
        btBatal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTransaksi = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPesanKoleksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kelola Data Transaksi Peminjaman");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Peminjam"));

        jLabel2.setText("ID Peminjam");

        lblNo1.setText("Nama");

        jLabel6.setText("Alamat");

        jLabel7.setText("Jumlah Pinjam");

        jLabel8.setText("NIP");

        bCariP.setText("Cari");
        bCariP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfIdP, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCariP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lblNo1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfJumlah_PinjamP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfAlamatP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfNamaP)
                            .addComponent(tfNidP))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfIdP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCariP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNo1)
                    .addComponent(tfNamaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfAlamatP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfJumlah_PinjamP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfNidP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Koleksi"));

        jLabel1.setText("ID Koleksi");

        lblNo.setText("Judul");

        jLabel3.setText("Penerbit");

        jLabel4.setText("Status");

        jLabel5.setText("ISBN/ISSN");

        bCariKoleksi.setText("Cari");
        bCariKoleksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariKoleksiActionPerformed(evt);
            }
        });

        lVolumeK.setText("Volume");

        lSeriK.setText("Seri");

        bTambahKoleksi.setText("Tambah Pesanan");
        bTambahKoleksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahKoleksiActionPerformed(evt);
            }
        });

        btlPesanan.setText("Batal Pesanan");
        btlPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlPesananActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNo)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tfIdK, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bCariKoleksi, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                            .addComponent(tfJudulK)
                            .addComponent(tfPenerbitK)
                            .addComponent(tfStatusK)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lVolumeK)
                            .addComponent(lSeriK))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIsbnK)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfSeriK, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(tfVolumeK))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btlPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bTambahKoleksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfIdK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCariKoleksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNo)
                    .addComponent(tfJudulK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPenerbitK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfStatusK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfIsbnK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btlPesanan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lVolumeK)
                            .addComponent(tfVolumeK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lSeriK)
                            .addComponent(tfSeriK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bTambahKoleksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaksi Peminjaman"));

        btPinjam.setText("Proses Peminjaman");
        btPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPinjamActionPerformed(evt);
            }
        });

        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btPinjam)
                .addComponent(btBatal))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Transaksi "));

        tbTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTransaksiMouseClicked(evt);
            }
        });
        tbTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbTransaksiKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbTransaksi);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Pesanan Koleksi"));

        tbPesanKoleksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPesanKoleksi.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbPesanKoleksiAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbPesanKoleksi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCariPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariPActionPerformed

        if (cariPeminjam(tfIdP.getText()) == null) {
            JOptionPane.showMessageDialog(this, "ID Peminjam tidak terdefinisi!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        dtpeminjam = cariPeminjam(tfIdP.getText());
        tfNamaP.setText(dtpeminjam.getNama());
        tfAlamatP.setText(dtpeminjam.getAlamat());
        tfJumlah_PinjamP.setText(Integer.toString(dtpeminjam.getMak_pinjam()));
        char tipe = dtpeminjam.getIdPeminjam().charAt(0);
        switch (tipe) {
            case 'D':
                tfNidP.setText(((Dosen) dtpeminjam).getNip());
                break;
            case 'M':
                tfNidP.setText(((Mahasiswa) dtpeminjam).getNim());
                break;
            case 'U':
                tfNidP.setText(((Umum) dtpeminjam).getNik());
                break;
            default:
                JOptionPane.showMessageDialog(this, "ID Peminjam tidak terdefinisi!!", "Warning", JOptionPane.WARNING_MESSAGE);
                tfNidP.setText("No ID");
        }
    }//GEN-LAST:event_bCariPActionPerformed

    private void bCariKoleksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariKoleksiActionPerformed
        // TODO add your handling code here:
        if (cariKoleksi(tfIdK.getText()) == null) {
            JOptionPane.showMessageDialog(this, "ID Koleksi tidak terdefinisi!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        dtKoleksi = cariKoleksi(tfIdK.getText());
        tfJudulK.setText(dtKoleksi.getJudul());
        tfPenerbitK.setText(dtKoleksi.getPenerbit());
        tfStatusK.setText(dtKoleksi.isStatus_pinjam() ? "Dipinjam" : "Tersedia");
        bTambahKoleksi.setEnabled(!dtKoleksi.isStatus_pinjam());
        char tipe = dtKoleksi.getIdKoleksi().charAt(0);
        switch (tipe) {
            case 'D':
                lVolumeK.setText("Format");
                lSeriK.setText("   ");
                tfSeriK.setVisible(Boolean.FALSE);
                tfIsbnK.setText(((Disk) dtKoleksi).getIsbn());
                tfVolumeK.setText(((Disk) dtKoleksi).getFormat());
                break;
            case 'M':
                lVolumeK.setText("Volume");
                lSeriK.setText("Seri");
                tfSeriK.setVisible(Boolean.TRUE);
                tfIsbnK.setText(((Majalah) dtKoleksi).getIssn());
                tfVolumeK.setText(Integer.toString(((Majalah) dtKoleksi).getVolume()));
                tfSeriK.setText(Integer.toString(((Majalah) dtKoleksi).getSeri()));
                break;
            case 'B':
                lVolumeK.setText("Halaman");
                lSeriK.setText("   ");
                tfSeriK.setVisible(Boolean.FALSE);
                tfIsbnK.setText(((Buku) dtKoleksi).getIsbn());
                tfVolumeK.setText(Integer.toString(((Buku) dtKoleksi).getHalaman()));
                break;
            default:
                JOptionPane.showMessageDialog(this, "ID Koleksi tidak terdefinisi!!", "Warning", JOptionPane.WARNING_MESSAGE);
                tfNidP.setText("No ID");
        }
        bTambahKoleksi.setEnabled(Boolean.TRUE);
    }//GEN-LAST:event_bCariKoleksiActionPerformed

    private void bTambahKoleksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahKoleksiActionPerformed
        dtPesanKoleksi.add(dtKoleksi);
        tampilPesanKoleksi();
        clrKoleksi();
        btPinjam.setEnabled(Boolean.TRUE);
    }//GEN-LAST:event_bTambahKoleksiActionPerformed

    private void btPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPinjamActionPerformed
        dtKoleksi = cariKoleksi(tfIdK.getText());
        dtpeminjam = cariPeminjam(tfIdP.getText());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatUntukID = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDateTime timeTrx = LocalDateTime.now();
        String now = dateTimeFormatter.format(timeTrx);
        tglSekarang = now;
        
        LocalDate tglBaru = timeTrx.toLocalDate().plus(7, ChronoUnit.DAYS);
        String dateBaru = dateTimeFormatter.format(tglBaru);
        tglKembali = dateBaru;
        
        String idT = "T" + Long.toString(timeTrx.toEpochSecond(ZoneOffset.UTC));
        String tglId = formatUntukID.format(timeTrx);
        dtPerpus.dataPerpus.pinjam(idT, dtPesanKoleksi, dtpeminjam);
        try {
            dtTrx = dtPerpus.dataPerpus.getTransaksi();
        } catch (SQLException ex) {
            Logger.getLogger(dTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        tampilTransaksi();
        clrKoleksi();
        clrPeminjam();
        disTambah();
        dtPesanKoleksi.clear();
        tampilPesanKoleksi();
    }//GEN-LAST:event_btPinjamActionPerformed

    private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
        dtPesanKoleksi.clear();
        clrKoleksi();
        clrPeminjam();
    }//GEN-LAST:event_btBatalActionPerformed

    private void tbTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTransaksiMouseClicked
        int selectedRow = tbTransaksi.getSelectedRow();
        dtPesanKoleksi = dtTrx.get(selectedRow).getArkoleksi();
        tampilPesanKoleksi();
    }//GEN-LAST:event_tbTransaksiMouseClicked

    private void tbTransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTransaksiKeyPressed
        int selectedRow = tbTransaksi.getSelectedRow();
        dtPesanKoleksi = dtTrx.get(selectedRow).getArkoleksi();
        tampilPesanKoleksi();
    }//GEN-LAST:event_tbTransaksiKeyPressed

    private void btlPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlPesananActionPerformed
        clrKoleksi();
    }//GEN-LAST:event_btlPesananActionPerformed

    private void tbPesanKoleksiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbPesanKoleksiAncestorAdded
        
    }//GEN-LAST:event_tbPesanKoleksiAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    private Koleksi cariKoleksi(String idKoleksi) {
        Iterator<Koleksi> iterator = dtPerpus.koleksiList.iterator();
        while (iterator.hasNext()) {
            Koleksi koleksi = iterator.next();
            if (koleksi.getIdKoleksi().equals(idKoleksi)) {
                return koleksi;
            }
        }
        return null;
    }

    private Peminjam cariPeminjam(String idPeminjam) {
        Iterator<Peminjam> iterator = dtPerpus.peminjamList.iterator();
        while (iterator.hasNext()) {
            Peminjam peminjam = iterator.next();
            if (peminjam.getIdPeminjam().equals(idPeminjam)) {
                return peminjam;
            }
        }
        return null;
    }

    private void tampilPesanKoleksi() {
        String IsbnIssn = "";
        String[] kolom = {"Id Koleksi", "Judul", "Penerbit", "Status", "ISBN/ISSN"};
        Object[][] objData = new Object[dtPesanKoleksi.size()][5]; // 5 merupakan jumlah kolom
        int i = 0;
        for (Koleksi n : dtPesanKoleksi) {
            if (n instanceof Disk) {
                IsbnIssn = ((Disk) n).getIsbn();
            }
            if (n instanceof Majalah) {
                IsbnIssn = ((Majalah) n).getIssn();
            }
            if (n instanceof Buku) {
                IsbnIssn = ((Buku) n).getIsbn();
            }
            objData[i] = new String[]{n.getIdKoleksi(), n.getJudul(), n.getPenerbit(), n.isStatus_pinjam() ? "Dipinjam" : "Tersedia", IsbnIssn};
            i++;
        }
        tbModelPesanKoleksi = new DefaultTableModel(objData, kolom) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tbPesanKoleksi.repaint();
        tbPesanKoleksi.setModel(tbModelPesanKoleksi);
        clModelPesanKoleksi = tbPesanKoleksi.getColumnModel();
        clModelPesanKoleksi.getColumn(0).setPreferredWidth(10);
        clModelPesanKoleksi.getColumn(1).setPreferredWidth(300);
        clModelPesanKoleksi.getColumn(2).setPreferredWidth(50);
        clModelPesanKoleksi.getColumn(3).setPreferredWidth(10);
        clModelPesanKoleksi.getColumn(4).setPreferredWidth(20);
    }

    private void tampilTransaksi() {
        String[] kolom = {"ID Transaksi", "Tgl Pinjam", "Tgl Kembali", "ID Peminjam"};
        Object[][] objData = new Object[dtTrx.size()][4]; // 5 merupakan jumlah kolom
        int i = 0;
        for (Transaksi n : dtTrx) {
            objData[i] = new String[]{n.getId_transaksi(), n.getTgl_pinjam().toString(), n.getTgl_kembali().toString(), n.getPeminjam().getIdPeminjam()};
            i++;
        }
        tbModelTransaksi = new DefaultTableModel(objData, kolom) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tbTransaksi.repaint();
        tbTransaksi.setModel(tbModelTransaksi);
        clModelTransaksi = tbTransaksi.getColumnModel();
        clModelTransaksi.getColumn(0).setPreferredWidth(10);
        clModelTransaksi.getColumn(1).setPreferredWidth(300);
        clModelTransaksi.getColumn(2).setPreferredWidth(50);
        clModelTransaksi.getColumn(3).setPreferredWidth(10);
    }

    private void clrKoleksi() {
        bTambahKoleksi.setEnabled(Boolean.FALSE);
        tfIdK.setText("");
        tfJudulK.setText("");
        tfPenerbitK.setText("");
        tfStatusK.setText("");
        tfIsbnK.setText("");
        tfVolumeK.setText("");
        tfSeriK.setText("");
    }

    private void clrPeminjam() {
        tfIdP.setText("");
        tfNamaP.setText("");
        tfAlamatP.setText("");
        tfJumlah_PinjamP.setText("");
        tfNidP.setText("");
    }

    private void disTambah() {
        bCariP.setEnabled(Boolean.FALSE);
        bCariKoleksi.setEnabled(Boolean.FALSE);
        btBatal.setEnabled(Boolean.FALSE);
        btlPesanan.setEnabled(Boolean.FALSE);
        bTambahKoleksi.setEnabled(Boolean.FALSE);
        btPinjam.setEnabled(Boolean.FALSE);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCariKoleksi;
    private javax.swing.JButton bCariP;
    private javax.swing.JButton bTambahKoleksi;
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btPinjam;
    private javax.swing.JButton btlPesanan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lSeriK;
    private javax.swing.JLabel lVolumeK;
    private javax.swing.JLabel lblNo;
    private javax.swing.JLabel lblNo1;
    private javax.swing.JTable tbPesanKoleksi;
    private javax.swing.JTable tbTransaksi;
    private javax.swing.JTextField tfAlamatP;
    private javax.swing.JTextField tfIdK;
    private javax.swing.JTextField tfIdP;
    private javax.swing.JTextField tfIsbnK;
    private javax.swing.JTextField tfJudulK;
    private javax.swing.JTextField tfJumlah_PinjamP;
    private javax.swing.JTextField tfNamaP;
    private javax.swing.JTextField tfNidP;
    private javax.swing.JTextField tfPenerbitK;
    private javax.swing.JTextField tfSeriK;
    private javax.swing.JTextField tfStatusK;
    private javax.swing.JTextField tfVolumeK;
    // End of variables declaration//GEN-END:variables
}
