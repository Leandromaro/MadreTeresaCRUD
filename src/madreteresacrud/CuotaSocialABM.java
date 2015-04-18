/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud;

import java.awt.Toolkit;
import java.beans.Beans;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jdesktop.beansbinding.Converter;
import utilidades.CalendarioDialog;

/**
 *
 * @author francis
 */
public class CuotaSocialABM extends JPanel {

    private Socios s;

    public CuotaSocialABM(int idSoc) {
        s = SociosABM.getSocio(idSoc);
        initComponents();

        masterTable.getColumnModel().getColumn(3).setMaxWidth(0);
        masterTable.getColumnModel().getColumn(3).setMinWidth(0);
        masterTable.getColumnModel().getColumn(3).setPreferredWidth(0);

        saveButton.setEnabled(false);
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        //Selecciona automaticamente la primer fila de la tabla si existen cuotas del socio..
        if (masterTable.getRowCount() != 0 && masterTable.getValueAt(0, 1) == null) {
            masterTable.changeSelection(0, 1, false, false);
            saveButton.setEnabled(true);
            //montoField.setEnabled(false);
        }
    }

    public CuotaSocialABM(Socios s) {        
        this.s = s;
        initComponents();
        saveButton.setEnabled(false);
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        //Selecciona automaticamente la primer fila de la tabla si existen cuotas del socio..
        if (masterTable.getRowCount() != 0 && masterTable.getValueAt(0, 1) == null) {
            masterTable.changeSelection(0, 1, false, false);
            saveButton.setEnabled(true);
            //montoField.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor. WHERE c.idSocio="+this.idSocio+" AND
     * c.fechaPago IS NULL ORDER BY c.fechaActivacion ASC WHERE
     * c.idSocio="+this.idSocio+" ORDER BY c.fechaActivacion DESC"
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaSocial c WHERE c.idSocio="+this.s.getIdSocio()+" ORDER BY c.fechaActivacion DESC");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        jPanelForm = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        fechaPagoLabel = new javax.swing.JLabel();
        montoLabel = new javax.swing.JLabel();
        fechaPagoField = new javax.swing.JTextField();
        montoField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jPanelTabla = new javax.swing.JPanel();
        genCuota = new javax.swing.JButton();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();

        FormListener formListener = new FormListener();

        jPanelForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saveButton.setText("Guardar");
        saveButton.addActionListener(formListener);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(formListener);

        fechaPagoLabel.setText("Fecha de Pago:");

        montoLabel.setText("Monto ($):");

        fechaPagoField.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaPago}"), fechaPagoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        binding.setConverter(dateConverter);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaPagoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        fechaPagoField.addMouseListener(formListener);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.monto}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        montoField.addKeyListener(formListener);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.GIF"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(formListener);

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(formListener);

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(montoLabel)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addComponent(fechaPagoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaPagoField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248))))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaPagoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fechaPagoLabel)))
                .addGap(18, 18, 18)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoLabel)
                    .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(saveButton)
                    .addComponent(jButtonSalir))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        genCuota.setText("Generar cuota adelantada");
        genCuota.addActionListener(formListener);

        masterTable.setAutoCreateRowSorter(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cuota}"));
        columnBinding.setColumnName("Cuota");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaPago}"));
        columnBinding.setColumnName("Fecha Pago");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monto}"));
        columnBinding.setColumnName("Monto");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaActivacion}"));
        columnBinding.setColumnName("Fecha Activacion");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(genCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(genCuota)
                .addContainerGap())
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 59, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                CuotaSocialABM.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == cancelar) {
                CuotaSocialABM.this.cancelarActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                CuotaSocialABM.this.jButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonSalir) {
                CuotaSocialABM.this.jButtonSalirActionPerformed(evt);
            }
            else if (evt.getSource() == genCuota) {
                CuotaSocialABM.this.genCuotaActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == montoField) {
                CuotaSocialABM.this.montoFieldKeyTyped(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == fechaPagoField) {
                CuotaSocialABM.this.fechaPagoFieldMouseClicked(evt);
            }
            else if (evt.getSource() == masterTable) {
                CuotaSocialABM.this.masterTableMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaSocial c WHERE c.idSocio=" 
                + this.s.getIdSocio() + " ORDER BY c.fechaActivacion DESC");
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        saveButton.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<madreteresacrud.CuotaSocial> merged = new ArrayList<madreteresacrud.CuotaSocial>(list.size());
            for (madreteresacrud.CuotaSocial c : list) {
                merged.add(entityManager.merge(c));
            }
            list.clear();
            list.addAll(merged);
        }

        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaSocial c WHERE c.idSocio=" 
                + this.s.getIdSocio() + " ORDER BY c.fechaActivacion DESC");
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        JOptionPane.showMessageDialog(null, "Cuota/s registrada/s exitosamente!");
        saveButton.setEnabled(false);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new CalendarioDialog((JDialog) SwingUtilities.getWindowAncestor(this), true, fechaPagoField).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void genCuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genCuotaActionPerformed
        //montoField.setEnabled(false);
        madreteresacrud.CuotaSocial cs = new madreteresacrud.CuotaSocial();
        madreteresacrud.CuotaSocial csaux = new madreteresacrud.CuotaSocial();
        cs.setIdSocio(this.s.getIdSocio());
        //Seteamos la fecha de pago
        Date f = new Date();
        Calendar f1 = GregorianCalendar.getInstance();
        cs.setFechaPago(f);

        //Setamos la fecha de activacion
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaSocial c WHERE c.idSocio=" 
                + this.s.getIdSocio() + " ORDER BY c.fechaActivacion DESC");
        java.util.Collection data = query.getResultList();

        for (Object entity : data) {
            csaux = (CuotaSocial) entity;
            break;
        }

        f = csaux.getFechaActivacion();
        f1.setTime(f);
        f1.add(Calendar.MONTH, 1);
        f1.set(Calendar.DAY_OF_MONTH, 1);
        cs.setFechaActivacion(f1.getTime());

        //Seteamos la cuota
        String formato = "yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        cs.setCuota(String.valueOf(f1.getTime().getMonth() + 1) + "/" + String.valueOf(Integer.parseInt(dateFormat.format(f))));

        //Seteamos el monto
        TipoSocioABM ts = new TipoSocioABM();
        String tipo = ts.getTipoSoc(s.getIdTipoSocio());
        cs.setMonto(ts.getMonto(tipo));

        entityManager.persist(cs);
        list.add(cs);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));

        //Guardamos automaticamente la cuota
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<madreteresacrud.CuotaSocial> merged = new ArrayList<madreteresacrud.CuotaSocial>(list.size());
            for (madreteresacrud.CuotaSocial c : list) {
                merged.add(entityManager.merge(c));
            }
            list.clear();
            list.addAll(merged);
        }

        //query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaSocial c WHERE c.idSocio="+this.idSocio+" ORDER BY c.fechaActivacion DESC");
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        JOptionPane.showMessageDialog(null, "Cuota/s registrada/s exitosamente!");
    }//GEN-LAST:event_genCuotaActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        JDialog topFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        topFrame.hide();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        saveButton.setEnabled(true);
    }//GEN-LAST:event_masterTableMouseClicked

    private void fechaPagoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaPagoFieldMouseClicked
        new CalendarioDialog((JDialog) SwingUtilities.getWindowAncestor(this), true, fechaPagoField).setVisible(true);
    }//GEN-LAST:event_fechaPagoFieldMouseClicked

    private void montoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_montoFieldKeyTyped

    public java.util.Collection getListaCuotas() {

        return query.getResultList();

    }

    public java.util.Collection getListaCuotasDeudas() {
        javax.persistence.Query query1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaSocial c WHERE c.idSocio=" 
                + this.s.getIdSocio() + " AND c.fechaPago IS NULL");
        return query1.getResultList();

    }

    public void setQuery() {
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CuotaSocial c WHERE c.idSocio=" 
                + this.s.getIdSocio() + " ORDER BY c.fechaActivacion DESC");
    }
    Converter dateConverter = new Converter<java.util.Date, String>() {
        @Override
        public String convertForward(java.util.Date value) {
            String patron = "dd/MM/yyyy";
            SimpleDateFormat formato = new SimpleDateFormat(patron);
            return formato.format(value);
        }

        @Override
        public java.util.Date convertReverse(String value) {
            try {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                return df.parse(value);
            } catch (ParseException e) {
                System.err.println("Error de dateConverter: "+e.getMessage());
                return Calendar.getInstance().getTime();
            }
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField fechaPagoField;
    private javax.swing.JLabel fechaPagoLabel;
    private javax.swing.JButton genCuota;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelTabla;
    private java.util.List<madreteresacrud.CuotaSocial> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField montoField;
    private javax.swing.JLabel montoLabel;
    private javax.persistence.Query query;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
//    public static void main(String[] args) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CuotaSocialABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CuotaSocialABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CuotaSocialABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CuotaSocialABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JFrame frame = new JFrame();
//                frame.setContentPane(new CuotaSocialABM(2));
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//    }
}
