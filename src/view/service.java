/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.Paragraph;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.query;
import models.service_mod;

/**
 *
 * @author hima1993
 */
public class service extends javax.swing.JFrame {

    /**
     * Creates new form service
     */
    public service() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        srv_cost = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        srv_patient_id = new javax.swing.JTextField();
        srv_id = new javax.swing.JTextField();
        srv_name = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        srv_clear = new javax.swing.JButton();
        srv_submit = new javax.swing.JButton();
        srv_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        srv_table = new javax.swing.JTable();
        srv_main = new javax.swing.JButton();
        srv_checkbox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        srv_result = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        srv_adm_submit = new javax.swing.JButton();
        show_srvc = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        s_adm_srch = new javax.swing.JButton();
        s_adm_update = new javax.swing.JButton();
        s_adm_delete = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("service");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Service Cost");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        srv_cost.setText("0.00");
        srv_cost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srv_costMouseClicked(evt);
            }
        });
        srv_cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                srv_costKeyPressed(evt);
            }
        });
        getContentPane().add(srv_cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 100, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Service ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Admission ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 90, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("Service Type");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Service Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        srv_patient_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                srv_patient_idKeyPressed(evt);
            }
        });
        getContentPane().add(srv_patient_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 70, 30));

        srv_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                srv_idKeyPressed(evt);
            }
        });
        getContentPane().add(srv_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 30));
        getContentPane().add(srv_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 140, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel10.setText("Rs.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 30, 30));

        srv_clear.setBackground(new java.awt.Color(204, 204, 255));
        srv_clear.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        srv_clear.setText("Clear");
        srv_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srv_clearActionPerformed(evt);
            }
        });
        getContentPane().add(srv_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 130, 40));

        srv_submit.setBackground(new java.awt.Color(102, 102, 255));
        srv_submit.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        srv_submit.setText("Submit New Service");
        srv_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srv_submitActionPerformed(evt);
            }
        });
        getContentPane().add(srv_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, 40));

        srv_update.setBackground(new java.awt.Color(102, 102, 255));
        srv_update.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        srv_update.setText("Update Services");
        srv_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srv_updateActionPerformed(evt);
            }
        });
        getContentPane().add(srv_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 140, 40));

        srv_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unique_id", "Service ID", "Service Cost", "Service Name", "Service Type", "Result"
            }
        ));
        srv_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srv_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(srv_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 520, 310));

        srv_main.setBackground(new java.awt.Color(255, 204, 255));
        srv_main.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        srv_main.setText("Main Menu");
        srv_main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srv_mainActionPerformed(evt);
            }
        });
        getContentPane().add(srv_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 140, 20));

        srv_checkbox.setBackground(new java.awt.Color(204, 204, 255));
        srv_checkbox.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        srv_checkbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Treatment", "Test" }));
        getContentPane().add(srv_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 40));

        srv_result.setColumns(20);
        srv_result.setRows(5);
        srv_result.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                srv_resultKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(srv_result);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 210, 280));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Service Result", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 40, 250, 320));

        srv_adm_submit.setBackground(new java.awt.Color(102, 102, 255));
        srv_adm_submit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        srv_adm_submit.setText("Submit ");
        srv_adm_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srv_adm_submitActionPerformed(evt);
            }
        });
        getContentPane().add(srv_adm_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 90, 30));

        show_srvc.setBackground(new java.awt.Color(0, 51, 255));
        show_srvc.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        show_srvc.setText("Search Available Services");
        show_srvc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_srvcActionPerformed(evt);
            }
        });
        getContentPane().add(show_srvc, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 200, 40));

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Services", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 370, 270));

        s_adm_srch.setBackground(new java.awt.Color(102, 102, 255));
        s_adm_srch.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        s_adm_srch.setText("Search");
        s_adm_srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_adm_srchActionPerformed(evt);
            }
        });
        getContentPane().add(s_adm_srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 90, 30));

        s_adm_update.setBackground(new java.awt.Color(102, 102, 255));
        s_adm_update.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        s_adm_update.setText("Update");
        s_adm_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_adm_updateActionPerformed(evt);
            }
        });
        getContentPane().add(s_adm_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 90, 30));

        s_adm_delete.setBackground(new java.awt.Color(102, 102, 255));
        s_adm_delete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        s_adm_delete.setText("Delete");
        s_adm_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_adm_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(s_adm_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 80, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("*");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 30, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 370, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void srv_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srv_updateActionPerformed
        service_mod srv = new service_mod();

        srv.srvc_name = srv_name.getText();
        srv.srvc_cost = Double.parseDouble(srv_cost.getText());
        srv.srvc_result = srv_result.getText();
        srv.srvc_type = srv_checkbox.getSelectedItem().toString();
        srv.sr_id = srv_id.getText();
        int index = srv_checkbox.getSelectedIndex();

        if (index == 0) {
            srv.update_srv(0, srv_table);
            JOptionPane.showMessageDialog(rootPane, "Service Updated Sucessfully.", "service update", JOptionPane.INFORMATION_MESSAGE);

        }
        if (index == 1) {
            srv.update_srv(1, srv_table);
            JOptionPane.showMessageDialog(rootPane, "Service Updated Sucessfully.", "service update", JOptionPane.INFORMATION_MESSAGE);

        }
        srv_result.setText("");
        srv_patient_id.setText("");
        srv_name.setText("");
        srv_cost.setText("");
        srv_id.setText("");
        srv_name.setText("");
        srv_cost.setText("");
        srv_checkbox.setSelectedIndex(0);
        /*try {

            int index = srv_checkbox.getSelectedIndex();

            if (index == 0) {
                query.thequery("update service set service_cost = '" + Double.parseDouble(srv_cost.getText()) + "',service_name = '" + srv_name.getText() + "',service_type='" + srv_checkbox.getSelectedItem().toString() + "' where service_id = '" + srv_id.getText() + "' ");

                DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
                JOptionPane.showMessageDialog(rootPane, "Service Updated Sucessfully.", "service update", JOptionPane.INFORMATION_MESSAGE);

                int i = srv_table.getSelectedRow();

                if (i >= 0) {

                    model.setValueAt(srv_id.getText(), i, 1);
                    model.setValueAt(srv_checkbox.getSelectedItem(), i, 4);
                    model.setValueAt(srv_name.getText(), i, 3);
                    model.setValueAt(srv_cost.getText(), i, 2);

                } else {
                    System.out.println("Update Error");
                }

            }
            if (index == 1) {
                query.thequery("update service set service_cost = '" + Double.parseDouble(srv_cost.getText()) + "',service_name = '" + srv_name.getText() + "',service_type='" + srv_checkbox.getSelectedItem().toString() + "' where service_id = '" + srv_id.getText() + "'");
                DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
                JOptionPane.showMessageDialog(rootPane, "Service Updated Sucessfully.", "service update", JOptionPane.INFORMATION_MESSAGE);

                int i = srv_table.getSelectedRow();

                if (i >= 0) {
                    model.setValueAt(srv_id.getText(), i, 0);
                    model.setValueAt(srv_checkbox.getSelectedItem(), i, 3);
                    model.setValueAt(srv_name.getText(), i, 2);
                    model.setValueAt(srv_cost.getText(), i, 1);

                } else {
                    System.out.println("Update Error");
                }

            }
            srv_result.setText("");
            srv_patient_id.setText("");
            srv_name.setText("");
            srv_cost.setText("");
            srv_id.setText("");
            srv_name.setText("");
            srv_cost.setText("");
            srv_checkbox.setSelectedIndex(0);

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

    }//GEN-LAST:event_srv_updateActionPerformed

    private void srv_mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srv_mainActionPerformed
        menu mn = new menu();
        mn.setVisible(true);
        close();
    }//GEN-LAST:event_srv_mainActionPerformed

    private void srv_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srv_clearActionPerformed
        clear();
    }//GEN-LAST:event_srv_clearActionPerformed

    private void srv_patient_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srv_patient_idKeyPressed
        // TODO add your handling code here:
        int key = evt.getExtendedKeyCode();
        if (key >= evt.VK_0 && key <= evt.VK_9 || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_DELETE || key >= evt.VK_A && key <= evt.VK_Z) {
            srv_patient_id.setEditable(true);

        } else {
            srv_patient_id.setEditable(false);

        }
    }//GEN-LAST:event_srv_patient_idKeyPressed

    private void srv_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srv_idKeyPressed
        // TODO add your handling code here:
        int key = evt.getExtendedKeyCode();
        if (key >= evt.VK_0 && key <= evt.VK_9 || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_DELETE) {
            srv_id.setEditable(true);

        } else {
            srv_id.setEditable(false);

        }
    }//GEN-LAST:event_srv_idKeyPressed

    private void srv_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srv_tableMouseClicked
        try {
            // TODO add your handling code here:
            int row = srv_table.rowAtPoint(evt.getPoint());
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
            int i = srv_table.getSelectedRow();
            String srvc_result = null;
            if (i >= 0) {
                srv_id.setText(model.getValueAt(i, 1).toString());
                srv_checkbox.setSelectedItem(model.getValueAt(i, 4));
                srv_name.setText(model.getValueAt(i, 3).toString());
                srv_cost.setText(model.getValueAt(i, 2).toString());
                //int s = Integer.parseInt(model.getValueAt(i, 0).toString());
                if (model.getValueAt(i, 5) == null) {
                    srv_result.setText("");
                } else {
                    srv_result.setText(model.getValueAt(i, 5).toString());

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_srv_tableMouseClicked

    private void srv_resultKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srv_resultKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_srv_resultKeyPressed

    private void srv_costKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srv_costKeyPressed
        // TODO add your handling code here:

        int key = evt.getExtendedKeyCode();
        if (key >= evt.VK_0 && key <= evt.VK_9 || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_DELETE || key == KeyEvent.VK_PERIOD) {
            srv_cost.setEditable(true);

        } else {
            srv_cost.setEditable(false);

        }
    }//GEN-LAST:event_srv_costKeyPressed

    private void srv_costMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srv_costMouseClicked
        // TODO add your handling code here:
        srv_cost.setText("");
    }//GEN-LAST:event_srv_costMouseClicked

    private void srv_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srv_submitActionPerformed
        service_mod srv = new service_mod();
        srv.srvc_name = srv_name.getText();
        srv.srvc_cost = Double.parseDouble(srv_cost.getText());
        srv.srvc_result = srv_result.getText();
        srv.srvc_type = srv_checkbox.getSelectedItem().toString();
        int index = srv_checkbox.getSelectedIndex();

        if (index == 0) {
            srv.add_srv(0);
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();

            model.addRow(new Object[]{srv_id.getText(), srv_cost.getText(), srv_name.getText(), srv_checkbox.getSelectedItem()});

            JOptionPane.showMessageDialog(rootPane, "Service Submitted Sucessfully.", "service submit", JOptionPane.INFORMATION_MESSAGE);

        }
        if (index == 1) {
            srv.add_srv(1);
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();

            model.addRow(new Object[]{"", srv_id.getText(), srv_cost.getText(), srv_name.getText(), srv_checkbox.getSelectedItem(), ""});
            JOptionPane.showMessageDialog(rootPane, "Service Submitted Sucessfully.", "service submit", JOptionPane.INFORMATION_MESSAGE);

        }
        srv_id.setEditable(true);
        srv_patient_id.setText("");
        srv_name.setText("");
        srv_cost.setText("");
        srv_id.setText("");
        srv_name.setText("");
        srv_cost.setText("");
        srv_result.setText("");
        srv_checkbox.setSelectedIndex(0);

        /*try {

            

            if (index == 0) {
                query.thequery("insert into service (service_cost,service_name,service_type) values('" + Double.parseDouble(srv_cost.getText()) + "','" + srv_name.getText() + "','" + srv_checkbox.getSelectedItem().toString() + "')");
                int srvc_id = 0;

                ResultSet l = query.thequery_search("select max(service_id) as service_id from service");
                if (l.next()) {
                    srvc_id = l.getInt("service_id");

                }
                query.thequery("insert into test(service_service_id) values('" + srvc_id + "')");
                DefaultTableModel model = (DefaultTableModel) srv_table.getModel();

                model.addRow(new Object[]{srv_id.getText(), srv_cost.getText(), srv_name.getText(), srv_checkbox.getSelectedItem()});
                srv_id.setEditable(true);
                srv_patient_id.setText("");
                srv_name.setText("");
                srv_cost.setText("");
                srv_id.setText("");
                srv_name.setText("");
                srv_cost.setText("");
                srv_result.setText("");
                srv_checkbox.setSelectedIndex(0);
            }
            if (index == 1) {
                query.thequery("insert into service (service_cost,service_name,service_type) values('" + Double.parseDouble(srv_cost.getText()) + "','" + srv_name.getText() + "','" + srv_checkbox.getSelectedItem().toString() + "')");
                int srvc_id = 0;

                ResultSet l = query.thequery_search("select max(service_id) as service_id from service");
                if (l.next()) {
                    srvc_id = l.getInt("service_id");

                }
                query.thequery("insert into treatment(service_service_id) values('" + srvc_id + "')");
                DefaultTableModel model = (DefaultTableModel) srv_table.getModel();

                model.addRow(new Object[]{"",srv_id.getText(), srv_cost.getText(), srv_name.getText(), srv_checkbox.getSelectedItem(),""});
                srv_id.setEditable(true);
                srv_patient_id.setText("");
                srv_name.setText("");
                srv_cost.setText("");
                srv_id.setText("");
                srv_name.setText("");
                srv_cost.setText("");
                srv_result.setText("");
                srv_checkbox.setSelectedIndex(0);
            }
            JOptionPane.showMessageDialog(rootPane, "Service Submitted Sucessfully.", "service submit", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

    }//GEN-LAST:event_srv_submitActionPerformed

    private void srv_adm_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srv_adm_submitActionPerformed

        service_mod srv = new service_mod();
        srv.srv_patient_id = srv_patient_id.getText();
        srv.sr_id = srv_id.getText();
        srv.srvc_result = srv_result.getText();
        srv.add_Srv_in_addmission();
        clear();

        /*try {
            // TODO add your handling code here:

            int srvc_id = 0;
            int adm_id = 0;
            int pt_id = 0;

            ResultSet l = query.thequery_search("select service_id from service where service_id='" + srv_id.getText() + "'");
            ResultSet m = query.thequery_search("select * from addmission where a_id='" + srv_patient_id.getText() + "'");

            if (l.next()) {
                srvc_id = l.getInt("service_id");

            }
            if (m.next()) {
                adm_id = m.getInt("a_id");
                pt_id = m.getInt("Patient_patient_id");

            }

            query.thequery("insert into service_has_addmission(service_service_id,addmission_a_id,service_result) values('" + srvc_id + "','" + adm_id + "','" + srv_result.getText() + "')");

        } catch (Exception ex) {
            Logger.getLogger(service.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }//GEN-LAST:event_srv_adm_submitActionPerformed

    private void show_srvcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_srvcActionPerformed
        // TODO add your handling code here:
        clear();
        service_mod srv = new service_mod();
        srv.search_srv(srv_table);
        /*try {
            // TODO add your handling code here:
            

            ResultSet d = query.thequery_search("select service_id as s_id,service_cost as s_cost,service_name as s_name,service_type as s_type from service");
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
            while (d.next()) {
                s_id = d.getInt("s_id");
                s_name = d.getString("s_name");
                s_cost = d.getDouble("s_cost");
                s_type = d.getString("s_type");

                model.addRow(new Object[]{"", s_id, s_cost, s_name, s_type});
            }
        } catch (Exception ex) {
            Logger.getLogger(Ward.class.getName()).log(Level.SEVERE, null, ex);
        }*/


    }//GEN-LAST:event_show_srvcActionPerformed

    private void s_adm_srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_adm_srchActionPerformed
        // TODO add your handling code here:
        
        service_mod srv = new service_mod();
        srv.srv_patient_id = srv_patient_id.getText();
        srv.search_srv_in_admission(srv_table);
        /*try {
            // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();

            int srvc_id = 0;
            double srvc_cost;
            int s_id = 0;
            String srvc_name = null;
            String srvc_type = null;
            String srvc_result = null;

            ResultSet h = query.thequery_search("select * from service_has_addmission where addmission_a_id='" + srv_patient_id.getText() + "'");
            while (h.next()) {
                srvc_id = h.getInt("service_service_id");
                srvc_result = h.getString("service_result");
                s_id = h.getInt("srcadd");
                ResultSet k = query.thequery_search("select * from service where service_id='" + srvc_id + "'");
                while (k.next()) {
                    srvc_cost = k.getDouble("service_cost");
                    srvc_name = k.getString("service_name");
                    srvc_type = k.getString("service_type");

                    model.addRow(new Object[]{s_id, srvc_id, srvc_cost, srvc_name, srvc_type, srvc_result});

                }
            }

        } catch (Exception ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_s_adm_srchActionPerformed

    private void s_adm_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_adm_updateActionPerformed

// TODO add your handling code here:
        service_mod srv = new service_mod();
        srv.srvc_result = srv_result.getText();
        srv.update_srv_in_addmission(srv_table);

        /* try {
            // TODO add your handling code  
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
            int i = srv_table.getSelectedRow();
            String srvc_result = null;
            if (i >= 0) {

                query.thequery("update service_has_addmission set service_result='" + srv_result.getText() + "' where srcadd ='" + Integer.parseInt(model.getValueAt(i, 0).toString()) + "'");
            }

        } catch (Exception ex) {
            Logger.getLogger(service.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_s_adm_updateActionPerformed

    private void s_adm_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_adm_deleteActionPerformed
        // TODO add your handling code here:
        service_mod srv = new service_mod();
        int p = JOptionPane.showConfirmDialog(rootPane, "Are You Sure You want To Delete This Service in Addmission ? ", "admission delete", JOptionPane.YES_NO_OPTION);
        if (p == JOptionPane.YES_OPTION) {
            srv.delete_Srv_in_addmission(srv_table);
            clear();
        }
        /*try {
            // TODO add your handling code  
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
            int i = srv_table.getSelectedRow();

            if (i >= 0) {

                query.thequery("delete from service_has_addmission  where srcadd ='" + Integer.parseInt(model.getValueAt(i, 0).toString()) + "'");
            }

        } catch (Exception ex) {
            Logger.getLogger(service.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }//GEN-LAST:event_s_adm_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new service().setVisible(true);
            }
        });
    }

    private void close() {
        WindowEvent winclosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclosing);

    }

    private void clear() {
        srv_patient_id.setText("");
        srv_name.setText("");
        srv_cost.setText("");
        srv_id.setText("");
        srv_name.setText("");
        srv_cost.setText("");
        srv_result.setText("");
        srv_checkbox.setSelectedIndex(0);
        DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
        model.setRowCount(0);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton s_adm_delete;
    private javax.swing.JButton s_adm_srch;
    private javax.swing.JButton s_adm_update;
    private javax.swing.JButton show_srvc;
    private javax.swing.JButton srv_adm_submit;
    private javax.swing.JComboBox<String> srv_checkbox;
    private javax.swing.JButton srv_clear;
    private javax.swing.JTextField srv_cost;
    private javax.swing.JTextField srv_id;
    private javax.swing.JButton srv_main;
    private javax.swing.JTextField srv_name;
    private javax.swing.JTextField srv_patient_id;
    private javax.swing.JTextArea srv_result;
    private javax.swing.JButton srv_submit;
    private javax.swing.JTable srv_table;
    private javax.swing.JButton srv_update;
    // End of variables declaration//GEN-END:variables
}
