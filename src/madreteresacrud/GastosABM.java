/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud;

import java.awt.EventQueue;
import java.beans.Beans;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jdesktop.beansbinding.Converter;
import utilidades.Calendario;

/**
 *
 * @author francis
 */
public class GastosABM extends JPanel {
   
    public GastosABM() {
        initComponents();
        masterTable.getColumnModel().getColumn(3).setMaxWidth(0);
        masterTable.getColumnModel().getColumn(3).setMinWidth(0);
        masterTable.getColumnModel().getColumn(3).setPreferredWidth(0);
        
        masterTable.getColumnModel().getColumn(4).setMaxWidth(0);
        masterTable.getColumnModel().getColumn(4).setMinWidth(0);
        masterTable.getColumnModel().getColumn(4).setPreferredWidth(0);
        jComboBoxElemento.setEnabled(false);
        jComboBoxTipoGasto.setEnabled(false);  
        
//        String item;            
//        for(int i=0;i<masterTable.getRowCount();i++){
//            item=getTipoGasto(Integer.valueOf(masterTable.getValueAt(i, 4).toString())).getElemento();
//            masterTable.setValueAt(item, i, 5);
//           // columnaNueva1[i]=item;
//            System.out.println("string-> "+item);
//            System.out.println("colum-> "+masterTable.getValueAt(i, 5));
//            
//        }
       
//        refreshButton.setVisible(false);
        jLabelId.setVisible(false);
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     ORDER BY g.fechaGasto DESC
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT g FROM Gastos g");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        entityManager0 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("sistcalcuta?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        gastosQuery = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT g FROM Gastos g");
        gastosList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : gastosQuery.getResultList();
        jPanelTabla = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jPanelForm = new javax.swing.JPanel();
        idgastosLabel = new javax.swing.JLabel();
        montoLabel = new javax.swing.JLabel();
        fechaGastoLabel = new javax.swing.JLabel();
        descripcionLabel = new javax.swing.JLabel();
        tipoGastoIdtipoGastoLabel = new javax.swing.JLabel();
        montoField = new javax.swing.JTextField();
        fechaGastoField = new javax.swing.JTextField();
        descripcionField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jComboBoxTipoGasto = new javax.swing.JComboBox();
        jComboBoxElemento = new javax.swing.JComboBox();
        jLabelId = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        jPanelTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaGasto}"));
        columnBinding.setColumnName("Fecha del Gasto");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monto}"));
        columnBinding.setColumnName("Monto ($)");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idgastos}"));
        columnBinding.setColumnName("Idgastos");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoGastoIdtipoGasto}"));
        columnBinding.setColumnName("Tipo Gasto Idtipo Gasto");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        deleteButton.setText("Eliminar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        newButton.setText("Nuevo Gasto");
        newButton.addActionListener(formListener);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(newButton)
                .addGap(29, 29, 29)
                .addComponent(deleteButton)
                .addContainerGap(298, Short.MAX_VALUE))
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanelTablaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton});

        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaLayout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap())
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        jPanelForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        idgastosLabel.setText("Item:");

        montoLabel.setText("Monto($):");

        fechaGastoLabel.setText("Fecha del Gasto:");

        descripcionLabel.setText("Descripcion:");

        tipoGastoIdtipoGastoLabel.setText("Tipo de Gasto:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.monto}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), montoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaGasto}"), fechaGastoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        binding.setConverter(dateConverter);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaGastoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.descripcion}"), descripcionField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), descripcionField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText("Guardar");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Cancelar");
        refreshButton.addActionListener(formListener);

        jComboBoxTipoGasto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hogar", "Comisión" }));
        jComboBoxTipoGasto.addActionListener(formListener);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tipoGastoIdtipoGasto}"), jLabelId, org.jdesktop.beansbinding.BeanProperty.create("text"), "");
        bindingGroup.addBinding(binding);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.GIF"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(refreshButton)
                .addGap(31, 31, 31)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFormLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idgastosLabel)
                        .addComponent(montoLabel)
                        .addComponent(fechaGastoLabel)
                        .addComponent(descripcionLabel)
                        .addComponent(tipoGastoIdtipoGastoLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(descripcionField, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                        .addGroup(jPanelFormLayout.createSequentialGroup()
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fechaGastoField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(montoField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxTipoGasto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxElemento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelFormLayout.createSequentialGroup()
                                    .addGap(81, 81, 81)
                                    .addComponent(jLabelId))
                                .addGroup(jPanelFormLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                .addGap(0, 187, Short.MAX_VALUE)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(saveButton)))
            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFormLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormLayout.createSequentialGroup()
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tipoGastoIdtipoGastoLabel)
                                .addComponent(jComboBoxTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idgastosLabel)
                                .addComponent(jComboBoxElemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                            .addComponent(jLabelId)
                            .addGap(20, 20, 20)))
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormLayout.createSequentialGroup()
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(montoLabel)
                                .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fechaGastoLabel)
                                .addComponent(fechaGastoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(descripcionLabel)
                        .addComponent(descripcionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(45, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == deleteButton) {
                GastosABM.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                GastosABM.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                GastosABM.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                GastosABM.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jComboBoxTipoGasto) {
                GastosABM.this.jComboBoxTipoGastoActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                GastosABM.this.jButton1ActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                GastosABM.this.masterTableMouseClicked(evt);
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
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_refreshButtonActionPerformed
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?", "Eliminacion de Registro", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            int[] selected = masterTable.getSelectedRows();
            List<madreteresacrud.Gastos> toRemove = new ArrayList<madreteresacrud.Gastos>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                madreteresacrud.Gastos g = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                toRemove.add(g);
                entityManager.remove(g);
            }
            list.removeAll(toRemove);

            jComboBoxElemento.setEnabled(false);
            jComboBoxTipoGasto.setEnabled(false);  
            
        }
      
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        jComboBoxTipoGasto.setSelectedIndex(0);
        setComboItem(jComboBoxTipoGasto.getSelectedItem().toString().trim());
        jComboBoxElemento.setSelectedIndex(0);
        int id = getIdTipoGasto(jComboBoxTipoGasto.getSelectedItem().toString().trim(), jComboBoxElemento.getSelectedItem().toString().trim());
//        jLabelId.setText(Integer.toString(id));
        
        madreteresacrud.Gastos g = new madreteresacrud.Gastos();
        g.setTipoGastoIdtipoGasto(id);
        entityManager.persist(g);
        list.add(g);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));         

        jComboBoxElemento.setEnabled(true);
        jComboBoxTipoGasto.setEnabled(true);
        
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int id = getIdTipoGasto(jComboBoxTipoGasto.getSelectedItem().toString().trim(), jComboBoxElemento.getSelectedItem().toString().trim());
        jLabelId.setText(Integer.toString(id));
        
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<madreteresacrud.Gastos> merged = new ArrayList<madreteresacrud.Gastos>(list.size());
            for (madreteresacrud.Gastos g : list) {
                merged.add(entityManager.merge(g));
            }
            list.clear();
            list.addAll(merged);
        }
                
        jComboBoxElemento.setEnabled(false);
        jComboBoxTipoGasto.setEnabled(false);
        
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jComboBoxTipoGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoGastoActionPerformed
        
        String tipo= jComboBoxTipoGasto.getSelectedItem().toString().trim();
        setComboItem(tipo);
//        jComboBoxElemento.setSelectedIndex(0);
//        int id = getIdTipoGasto(jComboBoxTipoGasto.getSelectedItem().toString().trim(), jComboBoxElemento.getSelectedItem().toString().trim());
//        jLabelId.setText(Integer.toString(id));
       
        
    }//GEN-LAST:event_jComboBoxTipoGastoActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        jComboBoxElemento.setEnabled(true);
        jComboBoxTipoGasto.setEnabled(true);
        int selected= masterTable.getSelectedRow();
        int id = (int) masterTable.getValueAt(selected, 4);
        setCombos(id);
    }//GEN-LAST:event_masterTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Calendario((JFrame) SwingUtilities.getWindowAncestor(this),true,fechaGastoField).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setComboItem(String tipoGasto){
        jComboBoxElemento.removeAllItems();
        javax.persistence.Query queryGasto = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT DISTINCT t.elemento FROM TipoGasto t WHERE t.tipoGasto='"+tipoGasto+"'");
        String item;       
        java.util.Collection data = queryGasto.getResultList();        
        for(Object ite:data){            
            item = (String)ite;
            jComboBoxElemento.addItem(item);
            
        }   
        jComboBoxElemento.setSelectedIndex(0);
        
    }
    private int getIdTipoGasto(String tipo, String item){
        
        javax.persistence.Query queryGasto = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT DISTINCT t.idtipoGasto FROM TipoGasto t WHERE t.tipoGasto='"+tipo+"' AND t.elemento='"+item+"'");
        java.util.Collection data = queryGasto.getResultList();
        int id = 0;
        for(Object ite:data){            
           id=(int)ite;
            
        }  
         
        return id;
    }
    
    private TipoGasto getTipoGasto(int id){
        javax.persistence.Query queryGasto = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT DISTINCT t FROM TipoGasto t WHERE t.idtipoGasto="+id);
        java.util.Collection data = queryGasto.getResultList();
        TipoGasto tg = null;
        for(Object g:data){            
          tg = (TipoGasto) g;
            
        } 
        return tg;
    }
    private void setCombos(int id){
        TipoGasto tg = getTipoGasto(id);
        jComboBoxTipoGasto.setSelectedItem(tg.getTipoGasto());
        String tipo= jComboBoxTipoGasto.getSelectedItem().toString().trim();
        setComboItem(tipo);
        jComboBoxElemento.setSelectedItem(tg.getElemento());        
        
    }
    
    Converter dateConverter = new Converter<java.util.Date, String>() {
    @Override
    public String convertForward(java.util.Date value) {
     DateFormat df = DateFormat.getDateInstance();
        return df.format(value);
    }
    @Override
    public java.util.Date convertReverse(String value) {
        try {
            DateFormat df = DateFormat.getDateInstance();
            return df.parse(value);
        } catch (ParseException e) {
            return Calendar.getInstance().getTime();
        }
    }
    };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descripcionField;
    private javax.swing.JLabel descripcionLabel;
    private javax.persistence.EntityManager entityManager;
    private javax.persistence.EntityManager entityManager0;
    private javax.swing.JTextField fechaGastoField;
    private javax.swing.JLabel fechaGastoLabel;
    private java.util.List<madreteresacrud.Gastos> gastosList;
    private javax.persistence.Query gastosQuery;
    private javax.swing.JLabel idgastosLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxElemento;
    private javax.swing.JComboBox jComboBoxTipoGasto;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelTabla;
    private java.util.List<madreteresacrud.Gastos> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField montoField;
    private javax.swing.JLabel montoLabel;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel tipoGastoIdtipoGastoLabel;
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
//            java.util.logging.Logger.getLogger(GastosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GastosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GastosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GastosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JFrame frame = new JFrame();
//                frame.setContentPane(new GastosABM());
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//    }
}
