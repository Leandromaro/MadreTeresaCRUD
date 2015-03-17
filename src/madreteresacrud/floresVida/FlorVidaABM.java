/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud.floresVida;

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
public class FlorVidaABM extends JPanel {
    private FlorVidaABM1 fv=null;
    public FlorVidaABM() {
        initComponents();
        masterTable.getColumnModel().getColumn(6).setMaxWidth(0);
        masterTable.getColumnModel().getColumn(6).setMinWidth(0);
        masterTable.getColumnModel().getColumn(6).setPreferredWidth(0);
//         refreshButton.setVisible(false);
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }
    
     public FlorVidaABM(FlorVidaABM1 fv) {
        initComponents();
        masterTable.getColumnModel().getColumn(6).setMaxWidth(0);
        masterTable.getColumnModel().getColumn(6).setMinWidth(0);
        masterTable.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.fv=fv;
//        refreshButton.setVisible(false);
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     ORDER BY f.apellido
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT f FROM FlorVida f");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        jPanelForm = new javax.swing.JPanel();
        apellidoLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        localidadLabel = new javax.swing.JLabel();
        direccionLabel = new javax.swing.JLabel();
        fechaDefuncionLabel = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        apellidoField = new javax.swing.JTextField();
        nombreField = new javax.swing.JTextField();
        localidadField = new javax.swing.JTextField();
        direccionField = new javax.swing.JTextField();
        fechaDefuncionField = new javax.swing.JTextField();
        telefonoField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanelTabla = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setEnabled(false);

        jPanelForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        apellidoLabel.setText("Apellido:");

        nombreLabel.setText("Nombre:");

        localidadLabel.setText("Localidad:");

        direccionLabel.setText("Direccion:");

        fechaDefuncionLabel.setText("Fecha de Defuncion:");

        telefonoLabel.setText("Telefono de contacto:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.apellido}"), apellidoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), apellidoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nombre}"), nombreField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), nombreField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.localidad}"), localidadField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), localidadField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.direccion}"), direccionField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), direccionField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        fechaDefuncionField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaDefuncion}"), fechaDefuncionField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        binding.setConverter(dateConverter);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaDefuncionField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        fechaDefuncionField.addMouseListener(formListener);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefono}"), telefonoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), telefonoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText("Guardar");
        saveButton.setEnabled(false);
        saveButton.addActionListener(formListener);

        refreshButton.setText("Cancelar");
        refreshButton.setEnabled(false);
        refreshButton.addActionListener(formListener);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.GIF"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(refreshButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFormLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(apellidoLabel)
                        .addComponent(nombreLabel)
                        .addComponent(localidadLabel)
                        .addComponent(direccionLabel)
                        .addComponent(fechaDefuncionLabel)
                        .addComponent(telefonoLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(apellidoField)
                        .addComponent(nombreField)
                        .addComponent(localidadField)
                        .addComponent(direccionField)
                        .addGroup(jPanelFormLayout.createSequentialGroup()
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(telefonoField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaDefuncionField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 469, Short.MAX_VALUE)))
                    .addContainerGap()))
        );

        jPanelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {refreshButton, saveButton});

        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(saveButton))
                .addContainerGap())
            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFormLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(apellidoLabel)
                        .addComponent(apellidoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombreLabel)
                        .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(localidadLabel)
                        .addComponent(localidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(direccionLabel)
                        .addComponent(direccionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaDefuncionLabel)
                        .addComponent(fechaDefuncionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telefonoLabel)
                        .addComponent(telefonoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );

        jPanelTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apellido}"));
        columnBinding.setColumnName("Apellido");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${localidad}"));
        columnBinding.setColumnName("Localidad");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${direccion}"));
        columnBinding.setColumnName("Direccion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaDefuncion}"));
        columnBinding.setColumnName("Fecha de Defuncion");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefono}"));
        columnBinding.setColumnName("Telefono");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idFV}"));
        columnBinding.setColumnName("Id FV");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        newButton.setText("Nueva Flor de Vida");
        newButton.addActionListener(formListener);

        deleteButton.setText("Eliminar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap(445, Short.MAX_VALUE))
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaLayout.createSequentialGroup()
                .addContainerGap(271, Short.MAX_VALUE)
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap())
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addGap(45, 45, 45)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                FlorVidaABM.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                FlorVidaABM.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                FlorVidaABM.this.jButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                FlorVidaABM.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                FlorVidaABM.this.deleteButtonActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == fechaDefuncionField) {
                FlorVidaABM.this.fechaDefuncionFieldMouseClicked(evt);
            }
            else if (evt.getSource() == masterTable) {
                FlorVidaABM.this.masterTableMouseClicked(evt);
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
        this.refrescarForm();

    }//GEN-LAST:event_refreshButtonActionPerformed
    
    private void refrescarForm(){
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        this.setEnabledBotones(false);
        this.activarTextos(false);
    }
    
    private void activarTextos (boolean estado){
        direccionField.setEnabled(estado);                
        nombreField.setEnabled(estado);
        apellidoField.setEnabled(estado);
        telefonoField.setEnabled(estado);
        fechaDefuncionField.setEnabled(estado);
        localidadField.setEnabled(estado);
    }
    
    private Boolean blancos (){
        if((localidadField.getText().trim().isEmpty())||
                (nombreField.getText().trim().isEmpty())||
                (apellidoField.getText().trim().isEmpty())||
                (direccionField.getText().trim().isEmpty())||
                (telefonoField.getText().trim().isEmpty())||
                (fechaDefuncionField.getText().trim().isEmpty())){
            return true;
        }else{
            return false;
        }
      }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?", "Eliminacion de Registro", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    int[] selected = masterTable.getSelectedRows();
                    List<madreteresacrud.floresVida.FlorVida> toRemove = new ArrayList<madreteresacrud.floresVida.FlorVida>(selected.length);            
                    for (int idx = 0; idx < selected.length; idx++) {
                        madreteresacrud.floresVida.FlorVida f = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                        toRemove.add(f);
                        entityManager.remove(f);
                    }
                    try {
                            entityManager.getTransaction().commit();
                            entityManager.getTransaction().begin();
                        } catch (Exception e) {
                        }
                    list.removeAll(toRemove);
                    this.refrescarForm();
                }
        
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    private void setEnabledBotones (boolean estado){
        refreshButton.setEnabled(estado);
        deleteButton.setEnabled(estado);
        saveButton.setEnabled(estado);
        newButton.setEnabled(!estado);
        jButton1.setEnabled(estado);
    }
    
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        setEnabledBotones(true);
        masterTable.setEnabled(false);
        madreteresacrud.floresVida.FlorVida f = new madreteresacrud.floresVida.FlorVida();
        entityManager.persist(f);
        list.add(f);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
                if(this.blancos()){
            JOptionPane.showMessageDialog(null, "No se puede generar flores de usuarios con valores en blanco");
        }else{
                try {
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                } catch (RollbackException rex) {
                    rex.printStackTrace();
                    entityManager.getTransaction().begin();
                    List<madreteresacrud.floresVida.FlorVida> merged = new ArrayList<madreteresacrud.floresVida.FlorVida>(list.size());
                    for (madreteresacrud.floresVida.FlorVida f : list) {
                        merged.add(entityManager.merge(f));
                    }
                    list.clear();
                    list.addAll(merged);
                }
                if(fv!=null){            
                fv.setTabla();
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                topFrame.hide(); 
                }

                entityManager.getTransaction().rollback();
                entityManager.getTransaction().begin();
                java.util.Collection data = query.getResultList();
                for (Object entity : data) {
                    entityManager.refresh(entity);
                }
                list.clear();
                list.addAll(data);
                }
        this.refrescarForm();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Calendario((JFrame) SwingUtilities.getWindowAncestor(this),true,fechaDefuncionField).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fechaDefuncionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaDefuncionFieldMouseClicked
       new Calendario((JFrame) SwingUtilities.getWindowAncestor(this),true,fechaDefuncionField).setVisible(true);
    }//GEN-LAST:event_fechaDefuncionFieldMouseClicked

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        setEnabledBotones(true);
        newButton.setEnabled(false);
    }//GEN-LAST:event_masterTableMouseClicked

    
    public int getIdFV(String ape, String nom, int idSoc){
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT f FROM FlorVida f,RelacSocDifuntos r "+
                "WHERE f.idFV=r.idFV AND r.idSocioFV="+idSoc+" AND f.apellido LIKE '%"+ape.trim()+"%' AND f.nombre LIKE '%"+nom.trim()+"%'");
        FlorVida fv = new FlorVida();
        java.util.Collection listafv = query.getResultList();
        for(Object fv1:listafv){
            fv = (FlorVida)fv1;
        }
        return fv.getIdFV();
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
    private javax.swing.JTextField apellidoField;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField direccionField;
    private javax.swing.JLabel direccionLabel;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField fechaDefuncionField;
    private javax.swing.JLabel fechaDefuncionLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelTabla;
    private java.util.List<madreteresacrud.floresVida.FlorVida> list;
    private javax.swing.JTextField localidadField;
    private javax.swing.JLabel localidadLabel;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreLabel;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JLabel telefonoLabel;
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
//            java.util.logging.Logger.getLogger(FlorVidaABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FlorVidaABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FlorVidaABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FlorVidaABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JFrame frame = new JFrame();
//                frame.setContentPane(new FlorVidaABM());
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//    }
}
