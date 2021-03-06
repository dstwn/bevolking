/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bevolkings;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author macbookpro
 */
public class MainView extends javax.swing.JFrame {
    /**
     * Creates new form MainView
     */
    public Statement statement;
    public ResultSet resultSet;
    public DefaultTableModel tableModel;
    Connection connection = (Connection)Koneksi.configDB();
    
    public void heading(){
        Object[] judul = {
           "NIK","Nama", "Jenis Kelamin", "Distrik", "Tahun"
        };
        tableModel = new DefaultTableModel(null, judul);
        tb_penduduk.setModel(tableModel);
    }
    
    public void clearForm() {
        et_nik.setText("");
        et_name.setText("");
        cb_district.setSelectedIndex(0);
        cb_gender.setSelectedIndex(0);
        cb_year.setSelectedIndex(0);
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_add.setEnabled(true);
    }
    public void fillData(String where) {
        try{
            statement = connection.createStatement();
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
            resultSet = statement.executeQuery("SELECT * FROM data_penduduk " + where);
            
            while(resultSet.next()){
                Object[] data = {
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("gender"),
                    resultSet.getString("district"),
                    resultSet.getString("year"),
                    
                };
                    tableModel.addRow(data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getDataFilter(String data) throws SQLException{
         try{
            statement = connection.createStatement();
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
            resultSet = statement.executeQuery("SELECT COUNT(*) AS district FROM data_penduduk WHERE district='"+data+"'");
            resultSet.next();
        }catch(Exception e){
            e.printStackTrace();
        }
          return resultSet.getString("district");
    }
    
    public MainView() throws SQLException {
        initComponents();
        heading();
        fillData("");
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_gender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        et_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_district = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cb_year = new javax.swing.JComboBox<>();
        btn_add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_penduduk = new javax.swing.JTable();
        et_nik = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_pie = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Pencatatan Migrasi Penduduk");

        jLabel2.setText("Daerah Istimewa Yogyakarta");

        jLabel3.setText("Nama");

        cb_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Laki- Laki", "Perempuan" }));

        jLabel4.setText("Jenis Kelamin");

        et_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_nameActionPerformed(evt);
            }
        });

        jLabel5.setText("Distrik");

        cb_district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Sleman", "Bantul", "Kulon Progo", "Gunung Kidul", "Kota Yogya" }));

        jLabel6.setText("Tahun");

        cb_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "2018", "2019", "2020" }));

        btn_add.setText("Create");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        tb_penduduk.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_penduduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pendudukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_penduduk);

        jLabel7.setText("NIK");

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_pie.setText("Statistik Penduduk ");
        btn_pie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pieActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(70, 70, 70)
                        .addComponent(btn_pie))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel3))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(et_name)
                                        .addComponent(et_nik, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cb_gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cb_district, 0, 260, Short.MAX_VALUE)
                                        .addComponent(cb_year, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(et_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_district, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cb_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(et_nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_delete)
                            .addComponent(btn_reset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_pie)
                    .addComponent(jButton1))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void et_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_nameActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
       if(et_nik.getText().isEmpty() || et_name.getText().isEmpty()|| cb_gender.getSelectedIndex() == 0 || cb_district.getSelectedIndex() == 0 || cb_year.getSelectedIndex() == 0){
           JOptionPane.showMessageDialog(rootPane, "Ada data yang ksosong", "Gagal Input", JOptionPane.ERROR_MESSAGE);
       }else {
           try{
               statement = connection.createStatement();
               statement.executeUpdate("INSERT INTO data_penduduk VALUES('"+et_nik.getText()+"','"+et_name.getText()+"','"+cb_district.getSelectedItem()+"','"+cb_gender.getSelectedItem()+"','"+cb_year.getSelectedItem()+"')");
               JOptionPane.showMessageDialog(rootPane, "Berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
               fillData("");
               clearForm();
           }catch(Exception e){
               e.printStackTrace();
           }
       }
    }//GEN-LAST:event_btn_addActionPerformed

    private void tb_pendudukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pendudukMouseClicked
        et_nik.setText(tb_penduduk.getValueAt(tb_penduduk.getSelectedRow(), 0).toString());
        et_name.setText(tb_penduduk.getValueAt(tb_penduduk.getSelectedRow(), 1).toString());
        cb_gender.setSelectedItem(tb_penduduk.getValueAt(tb_penduduk.getSelectedRow(), 2).toString());
        cb_district.setSelectedItem(tb_penduduk.getValueAt(tb_penduduk.getSelectedRow(), 3).toString());
        cb_year.setSelectedItem(tb_penduduk.getValueAt(tb_penduduk.getSelectedRow(), 4).toString());
        btn_update.setEnabled(true);
        btn_delete.setEnabled(true);
        btn_add.setEnabled(false);
        et_nik.setEditable(false);
    }//GEN-LAST:event_tb_pendudukMouseClicked

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try{
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE data_penduduk set "
//                    +"id='"     + et_nik.getText() +"',"
                    +"name='"     + et_name.getText() +"',"
                    +"gender='"     + cb_gender.getSelectedItem() +"',"
                    +"district='"     + cb_district.getSelectedItem() +"',"
                    +"year='"     + cb_year.getSelectedItem() +
                    "' WHERE "+"id='"     + et_nik.getText() +"'" 
            );
            fillData("");
            JOptionPane.showMessageDialog(rootPane, "Update data berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try{
            int answer;
            if((answer = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
                statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM data_penduduk WHERE id='"
                        +tb_penduduk.getValueAt(tb_penduduk.getSelectedRow(), 0)+
                        "'");
                fillData("");
                clearForm();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_pieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pieActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset dataSet = new DefaultPieDataset();
        try {
            dataSet.setValue("Bantul", Integer.parseInt(getDataFilter("Bantul")));
            dataSet.setValue("Sleman", Integer.parseInt(getDataFilter("Sleman")));
            dataSet.setValue("Kulon Progo", Integer.parseInt(getDataFilter("Kulon Progo")));
            dataSet.setValue("Gunung Kidul", Integer.parseInt(getDataFilter("Gunung Kidul")));
            dataSet.setValue("Kota Yogya", Integer.parseInt(getDataFilter("Kota Yogya")));
            JFreeChart chart = ChartFactory.createPieChart("Statistik Penduduk", dataSet);
            ChartFrame cFrame = new ChartFrame("Data Statistik ", chart );
            cFrame.setSize(400,400);
            cFrame.setVisible(true);
            fillData("");
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_pieActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_pie;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_district;
    private javax.swing.JComboBox<String> cb_gender;
    private javax.swing.JComboBox<String> cb_year;
    private javax.swing.JTextField et_name;
    private javax.swing.JTextField et_nik;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_penduduk;
    // End of variables declaration//GEN-END:variables
}
