/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import madreteresacrud.Socios;
import madreteresacrud.SociosABM;
import madreteresacrud.floresVida.SociosFVABM;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author francis
 */
public class BuscarSocio extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    private SociosFVABM s;
    public BuscarSocio(java.awt.Frame parent, boolean modal,SociosFVABM s) {
        super(parent, modal);
        this.s=s;        
        initComponents();
        setBusqueda();
        this.setLocationRelativeTo(null);
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
        jCBBusqueda = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Socio:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jCBBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String  [] socios = jCBBusqueda.getSelectedItem().toString().split("=");
        Socios soc = getSocio(Integer.valueOf(socios[1].toString().trim()));
        set(soc);
        this.hide();
        //System.out.println(this.s.getDocumento());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void setBusqueda() {
        SociosABM socios = new SociosABM();
        java.util.Collection listaSocios = socios.getListaSocios();
        Socios soc;
        for (Object socio : listaSocios) {            
            soc = (Socios) socio;
            jCBBusqueda.addItem(soc.getApellido().trim()+" "+soc.getNombre().trim()+" -> N° Socio = "+soc.getNumSoc());
        }
        AutoCompleteDecorator.decorate(this.jCBBusqueda); 
    }
     
     private Socios getSocio(int nroSocio){
         SociosABM socios = new SociosABM();
         Socios soc=socios.getSocio(nroSocio);
         
         return soc;
     }
     
     private void set(Socios s){
         this.s.setApellidoField(s.getApellido());
         this.s.setNombreField(s.getNombre());
         this.s.setDniField(String.valueOf(s.getDocumento()));
         this.s.setCuilField(s.getCuil());
         this.s.setjCBSexo(s.getSexo());
         this.s.setjCBLocalididad(s.getLocalidad().getLocalidad());
         this.s.setDireccionField(s.getDireccion());
         this.s.setEmailField(s.getEmail());
         this.s.setTelefonoField(s.getTelefono());
         this.s.setCelularField(s.getCelular());
     }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCBBusqueda;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
