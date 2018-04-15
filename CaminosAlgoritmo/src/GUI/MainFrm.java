/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * @author Salvador Vera Franco 
 *  MainFrm class 1.0
 */

public class MainFrm extends javax.swing.JFrame {
    static  DefaultListModel<String> model = new DefaultListModel<>();
    static boolean ospfaction=false;
    static areaP areaP=new areaP();
    static OSPF ospf;
    public MainFrm() {
        
        initComponents();
       getContentPane().add(areaP, java.awt.BorderLayout.CENTER);
       inspector.setVisible(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        inspector = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idtx = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaA = new javax.swing.JList<>(model);
        addApuntadorBt = new javax.swing.JButton();
        removeApuntadorBt = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        inicio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fin = new javax.swing.JTextField();
        EJEMPLOBT = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grpafos Camino mas corto");

        inspector.setBackground(new java.awt.Color(204, 204, 255));
        inspector.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inspector", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel2.setText("ID:");

        idtx.setText("  ");

        listaA.setBackground(new java.awt.Color(204, 204, 255));
        listaA.setBorder(javax.swing.BorderFactory.createTitledBorder("Apuntadores"));
        listaA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(listaA);

        addApuntadorBt.setText("+");
        addApuntadorBt.setToolTipText("Agregar Apuntador");
        addApuntadorBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addApuntadorBtActionPerformed(evt);
            }
        });

        removeApuntadorBt.setText("-");
        removeApuntadorBt.setToolTipText("Eliminar apuntador seleccionado");
        removeApuntadorBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeApuntadorBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inspectorLayout = new javax.swing.GroupLayout(inspector);
        inspector.setLayout(inspectorLayout);
        inspectorLayout.setHorizontalGroup(
            inspectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
            .addGroup(inspectorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inspectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inspectorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inspectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addApuntadorBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeApuntadorBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(inspectorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idtx, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inspectorLayout.setVerticalGroup(
            inspectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inspectorLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inspectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idtx))
                .addGap(30, 30, 30)
                .addGroup(inspectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inspectorLayout.createSequentialGroup()
                        .addComponent(addApuntadorBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeApuntadorBt))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 137, Short.MAX_VALUE))
        );

        getContentPane().add(inspector, java.awt.BorderLayout.LINE_END);

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nodo Inicial");

        jLabel4.setText("Nodo Final");
        
        EJEMPLOBT.setText("EJEMPLO");
        EJEMPLOBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EJEMPLOBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inicio))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(fin, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton2)))
                .addGap(75, 75, 75)
                .addComponent(EJEMPLOBT)
                .addGap(549, 549, 549))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(EJEMPLOBT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
  
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(NodosFactory.IDexist(inicio.getText())&&NodosFactory.IDexist(fin.getText())){
            ospf=new OSPF(inicio.getText(), fin.getText());
            ospf.ospf(0, OSPF.Nodo_Inicial);
            ospf.LineasCorto();
            ospf.LineasLargo();
            ospfaction=true;
            areaP.repaint();
        }
        else JOptionPane.showMessageDialog(null, "Uno de los nodos NO existe!!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addApuntadorBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addApuntadorBtActionPerformed
        String[] s=JOptionPane.showInputDialog("Ingresa el ID del nodo a apuntar y su Costo\nEjemplo: X,5").split(",");
        NodosFactory.getNodo(idtx.getText()).addApuntadores(s[0], Integer.parseInt(s[1]));
    }//GEN-LAST:event_addApuntadorBtActionPerformed

    private void removeApuntadorBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeApuntadorBtActionPerformed
        int s=listaA.getSelectedIndex();
        if(s!=-1){
            NodosFactory.getNodo(idtx.getText()).removeApuntador(model.remove(s).split("->")[0]);
        }
    }//GEN-LAST:event_removeApuntadorBtActionPerformed

   
        private void EJEMPLOBTActionPerformed(java.awt.event.ActionEvent evt) {                                          
        inspector.setVisible(false);
        ejemplo();
    }                                         

   private void ejemplo(){
        Nodos nod;
        NodosFactory.getListaNodos().clear();
        
        nod=new Nodos("A",104,209);
         areaP.add(NodosFactory.addNodo(nod)); 
         
         nod=new Nodos("B",251,96);
         areaP.add(NodosFactory.addNodo(nod));
         nod=new Nodos("C",244,356);
         areaP.add(NodosFactory.addNodo(nod));
         nod=new Nodos("D",405,178);
         areaP.add(NodosFactory.addNodo(nod));
         nod=new Nodos("E",403,23);
         areaP.add(NodosFactory.addNodo(nod));
         nod=new Nodos("F",424,354);
         areaP.add(NodosFactory.addNodo(nod));
         nod=new Nodos("G",609,185);
         areaP.add(NodosFactory.addNodo(nod));
         NodosFactory.getNodo("A").addApuntadores("B",3);
         NodosFactory.getNodo("A").addApuntadores("C",5);
         NodosFactory.getNodo("B").addApuntadores("E",8);
         NodosFactory.getNodo("B").addApuntadores("D",7);
         NodosFactory.getNodo("E").addApuntadores("G",4);
         NodosFactory.getNodo("D").addApuntadores("G",2);
         NodosFactory.getNodo("C").addApuntadores("F",3);
         NodosFactory.getNodo("F").addApuntadores("G",10);
         inicio.setText("A");
         fin.setText("G");
        areaP.updateUI();
    
    }
    
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
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addApuntadorBt;
    public javax.swing.JTextField fin;
    public static javax.swing.JLabel idtx;
    public javax.swing.JTextField inicio;
    public static javax.swing.JPanel inspector;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JList<String> listaA;
    public javax.swing.JButton removeApuntadorBt;
    // End of variables declaration//GEN-END:variables
}
