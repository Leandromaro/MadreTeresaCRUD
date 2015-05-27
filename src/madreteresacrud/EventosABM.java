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
public class EventosABM extends JPanel {

    public EventosABM() {

        initComponents();
        TipoEventoABM t = new TipoEventoABM();
        TipoEvento te = new TipoEvento();
        for (int i = 0; i < t.getTipoEvento().size(); i++) {
            te = (TipoEvento) t.getTipoEvento().get(i);
            jComboBoxEvento.addItem(te.getDescripcion());
        }
//        refreshButton.setVisible(false);
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        //masterTable.setDefaultRenderer(Object.class, new RendererTablaEventos(4));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor. SELECT e FROM Eventos e ORDER BY e.fecha
     * DESC
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Eventos e ORDER BY e.fecha DESC");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        jPanelForm = new javax.swing.JPanel();
        motivoLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        montoPublicLabel = new javax.swing.JLabel();
        montoRifasLabel = new javax.swing.JLabel();
        montoTarjetasLabel = new javax.swing.JLabel();
        fechaField = new javax.swing.JTextField();
        montoPublicField = new javax.swing.JTextField();
        montoRifasField = new javax.swing.JTextField();
        montoTarjetasField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jButtonCalendar = new javax.swing.JButton();
        jComboBoxEvento = new javax.swing.JComboBox();
        jPanelTabla = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        jPanelForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        motivoLabel.setText("Motivo del evento:");

        fechaLabel.setText("Fecha del evento:");

        montoPublicLabel.setText("Publicidad ($):");

        montoRifasLabel.setText("Rifas ($):");

        montoTarjetasLabel.setText("Tarjetas ($):");

        fechaField.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fecha}"), fechaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        binding.setConverter(dateConverter);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        fechaField.addMouseListener(formListener);

        montoPublicField.setToolTipText("Solo números y coma.");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.montoPublic}"), montoPublicField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), montoPublicField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        montoPublicField.addKeyListener(formListener);

        montoRifasField.setToolTipText("Solo números y coma.");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.montoRifas}"), montoRifasField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), montoRifasField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        montoRifasField.addKeyListener(formListener);

        montoTarjetasField.setToolTipText("Solo números y coma.");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.montoTarjetas}"), montoTarjetasField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), montoTarjetasField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        montoTarjetasField.addKeyListener(formListener);

        saveButton.setText("Guardar");
        saveButton.setEnabled(false);
        saveButton.addActionListener(formListener);

        refreshButton.setText("Cancelar");
        refreshButton.setEnabled(false);
        refreshButton.addActionListener(formListener);

        jButtonCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.GIF"))); // NOI18N
        jButtonCalendar.setContentAreaFilled(false);
        jButtonCalendar.setEnabled(false);
        jButtonCalendar.addActionListener(formListener);

        jComboBoxEvento.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.motivo}"), jComboBoxEvento, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(refreshButton)
                        .addGap(43, 43, 43)
                        .addComponent(saveButton))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(motivoLabel)
                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaLabel)
                                    .addComponent(montoPublicLabel)
                                    .addComponent(montoRifasLabel)))
                            .addComponent(montoTarjetasLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(montoTarjetasField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(montoRifasField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(montoPublicField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(397, Short.MAX_VALUE))
        );

        jPanelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {refreshButton, saveButton});

        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(montoPublicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(montoRifasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montoRifasLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(montoTarjetasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montoTarjetasLabel)))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(fechaLabel)
                        .addGap(17, 17, 17)
                        .addComponent(montoPublicLabel)))
                .addGap(18, 18, 18)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motivoLabel)
                    .addComponent(jComboBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        jPanelTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        masterTable.setAutoCreateRowSorter(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha del Evento");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${montoPublic}"));
        columnBinding.setColumnName("Publicidad ($)");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${montoRifas}"));
        columnBinding.setColumnName("Rifas ($)");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${montoTarjetas}"));
        columnBinding.setColumnName("Tarjetas ($)");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${montoPublic+montoRifas+montoTarjetas}"));
        columnBinding.setColumnName("Recaudación Total ($)");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${motivo}"));
        columnBinding.setColumnName("Motivo del Evento");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            masterTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            masterTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            masterTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            masterTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            masterTable.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        deleteButton.setText("Eliminar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        newButton.setText("Nuevo Evento");
        newButton.addActionListener(formListener);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap(476, Short.MAX_VALUE))
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaLayout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap())
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                EventosABM.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                EventosABM.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonCalendar) {
                EventosABM.this.jButtonCalendarActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                EventosABM.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                EventosABM.this.newButtonActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == montoPublicField) {
                EventosABM.this.montoPublicFieldKeyTyped(evt);
            }
            else if (evt.getSource() == montoRifasField) {
                EventosABM.this.montoRifasFieldKeyTyped(evt);
            }
            else if (evt.getSource() == montoTarjetasField) {
                EventosABM.this.montoTarjetasFieldKeyTyped(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == fechaField) {
                EventosABM.this.fechaFieldMouseClicked(evt);
            }
            else if (evt.getSource() == masterTable) {
                EventosABM.this.masterTableMouseClicked(evt);
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
        refrescarForm();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?", "Eliminacion de Registro", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            int[] selected = masterTable.getSelectedRows();
            List<madreteresacrud.Eventos> toRemove = new ArrayList<madreteresacrud.Eventos>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                madreteresacrud.Eventos e = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                toRemove.add(e);
                entityManager.remove(e);
            }
            try {
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } catch (Exception e) {
            }
            list.removeAll(toRemove);
            refrescarForm();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        jComboBoxEvento.setEnabled(true);
        setEnabledBotones(true);
        masterTable.setEnabled(false);
        madreteresacrud.Eventos e = new madreteresacrud.Eventos();
        entityManager.persist(e);
        list.add(e);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed

    private void setEnabledBotones(boolean estado) {
        refreshButton.setEnabled(estado);
        saveButton.setEnabled(estado);
        newButton.setEnabled(!estado);
        jButtonCalendar.setEnabled(estado);
    }

    private void refrescarForm() {
        masterTable.setEnabled(true);
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        setEnabledBotones(false);
        activarTextos(false);
    }

    private void activarTextos(boolean estado) {
        fechaField.setEnabled(estado);
        montoPublicField.setEnabled(estado);
        montoRifasField.setEnabled(estado);
        montoTarjetasField.setEnabled(estado);
        jComboBoxEvento.setEnabled(estado);
    }


    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (!blancos()) {
            try {
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
            } catch (RollbackException rex) {
                rex.printStackTrace();
                entityManager.getTransaction().begin();
                List<madreteresacrud.Eventos> merged = new ArrayList<madreteresacrud.Eventos>(list.size());
                for (madreteresacrud.Eventos e : list) {
                    merged.add(entityManager.merge(e));
                }
                list.clear();
                list.addAll(merged);
            }
            refrescarForm();
        }else{
            JOptionPane.showMessageDialog(null, "No se puede almacenar registros con valores en blanco");
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private Boolean blancos() {
        if (fechaField.getText().trim().isEmpty()
                || (jComboBoxEvento.getSelectedItem() == null)
                || (montoPublicField.getText().trim().isEmpty()
                && montoRifasField.getText().trim().isEmpty()
                && montoTarjetasField.getText().trim().isEmpty())) {
            mensaje();
            return true;
        } else {
            return false;
        }
    }

    private void mensaje() {
        String respuesta = "";
        if (fechaField.getText().trim().isEmpty()) {
            respuesta = respuesta + " " + "Fecha," + " ";
        }
        if (jComboBoxEvento.getSelectedItem() == null) {
            respuesta = respuesta + " " + "Motivo," + " ";
        }
        if (montoPublicField.getText().trim().isEmpty()
                && montoRifasField.getText().trim().isEmpty()
                && montoTarjetasField.getText().trim().isEmpty()) {
            respuesta = respuesta + " " + "Montos en su totalidad," + " ";
        }

        JOptionPane.showMessageDialog(null, "Los campos " + respuesta + "no deberian estar vacios!");
    }


    private void jButtonCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarActionPerformed
        new Calendario((JFrame) SwingUtilities.getWindowAncestor(this), true, fechaField).setVisible(true);
    }//GEN-LAST:event_jButtonCalendarActionPerformed

    private void montoPublicFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoPublicFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_montoPublicFieldKeyTyped

    private void montoRifasFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoRifasFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_montoRifasFieldKeyTyped

    private void montoTarjetasFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoTarjetasFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_montoTarjetasFieldKeyTyped

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        jComboBoxEvento.setEnabled(true);
        setEnabledBotones(true);
        activarTextos(true);
    }//GEN-LAST:event_masterTableMouseClicked

    private void fechaFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaFieldMouseClicked
        new Calendario((JFrame) SwingUtilities.getWindowAncestor(this), true, fechaField).setVisible(true);
    }//GEN-LAST:event_fechaFieldMouseClicked

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
                System.err.println("Error de dateConverter: " + e.getMessage());
                return Calendar.getInstance().getTime();
            }
        }
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField fechaField;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JButton jButtonCalendar;
    private javax.swing.JComboBox jComboBoxEvento;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelTabla;
    private java.util.List<madreteresacrud.Eventos> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField montoPublicField;
    private javax.swing.JLabel montoPublicLabel;
    private javax.swing.JTextField montoRifasField;
    private javax.swing.JLabel montoRifasLabel;
    private javax.swing.JTextField montoTarjetasField;
    private javax.swing.JLabel montoTarjetasLabel;
    private javax.swing.JLabel motivoLabel;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
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
//            java.util.logging.Logger.getLogger(EventosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EventosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EventosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EventosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JFrame frame = new JFrame();
//                frame.setContentPane(new EventosABM());
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//    }
}
