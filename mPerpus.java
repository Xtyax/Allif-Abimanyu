
package perpus.app;

import javax.swing.JOptionPane;

public class mPerpus extends javax.swing.JFrame {
    public DaoPerpus data;

    public mPerpus() {
        initComponents();
        data = new DaoPerpus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEdit = new javax.swing.JMenu();
        menuPeminjam = new javax.swing.JMenuItem();
        menuEKoleksi = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenu();
        menuPinjam = new javax.swing.JMenuItem();
        menuKembali = new javax.swing.JMenuItem();
        menuTampil = new javax.swing.JMenu();
        menuTKoleksi = new javax.swing.JMenu();
        menuBuku = new javax.swing.JMenuItem();
        menuDisk = new javax.swing.JMenuItem();
        menuMajalah = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perpustakaan Informatika USD");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpus/app/images/perpus.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuEdit.setText("Edit");

        menuPeminjam.setText("Peminjam");
        menuPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPeminjamActionPerformed(evt);
            }
        });
        menuEdit.add(menuPeminjam);

        menuEKoleksi.setText("Koleksi");
        menuEKoleksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEKoleksiActionPerformed(evt);
            }
        });
        menuEdit.add(menuEKoleksi);

        jMenuBar1.add(menuEdit);

        menuTransaksi.setText("Transaksi");

        menuPinjam.setText("Pinjam");
        menuPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPinjamActionPerformed(evt);
            }
        });
        menuTransaksi.add(menuPinjam);

        menuKembali.setText("Kembali");
        menuKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKembaliActionPerformed(evt);
            }
        });
        menuTransaksi.add(menuKembali);

        jMenuBar1.add(menuTransaksi);

        menuTampil.setText("Tampil");

        menuTKoleksi.setText("Koleksi");

        menuBuku.setText("Buku");
        menuTKoleksi.add(menuBuku);

        menuDisk.setText("Disk");
        menuTKoleksi.add(menuDisk);

        menuMajalah.setText("Majalah");
        menuTKoleksi.add(menuMajalah);

        menuTampil.add(menuTKoleksi);

        jMenuBar1.add(menuTampil);

        menuHelp.setText("Help");

        jMenuItem1.setText("Tentang Program");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuHelp.add(jMenuItem1);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPeminjamActionPerformed
        dPeminjam dialogPeminjam = new dPeminjam(this,true, data);
        dialogPeminjam.setVisible(true);

    }//GEN-LAST:event_menuPeminjamActionPerformed

    private void menuPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPinjamActionPerformed
        dTransaksi dialogTransaksi = new dTransaksi(this,true, data);
        dialogTransaksi.setVisible(true);
    }//GEN-LAST:event_menuPinjamActionPerformed

    private void menuEKoleksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEKoleksiActionPerformed
        dKoleksi dialogKoleksi = new dKoleksi(this,true, data);
        dialogKoleksi.setVisible(true);
    }//GEN-LAST:event_menuEKoleksiActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dHelp dialogHelp = new dHelp(this,true,data);
        dialogHelp.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKembaliActionPerformed
        dTransaksiKembali dialogTransaksi = new dTransaksiKembali (this,true, data);
        dialogTransaksi.setVisible(true);
    }//GEN-LAST:event_menuKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(mPerpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mPerpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mPerpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mPerpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mPerpus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuBuku;
    private javax.swing.JMenuItem menuDisk;
    private javax.swing.JMenuItem menuEKoleksi;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuKembali;
    private javax.swing.JMenuItem menuMajalah;
    private javax.swing.JMenuItem menuPeminjam;
    private javax.swing.JMenuItem menuPinjam;
    private javax.swing.JMenu menuTKoleksi;
    private javax.swing.JMenu menuTampil;
    private javax.swing.JMenu menuTransaksi;
    // End of variables declaration//GEN-END:variables
}
