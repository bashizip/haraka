/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Wizard.java
 *
 * Created on 29 juin 2010, 15:16:43
 */

package com.pbash.r2o.ui;

import java.awt.FlowLayout;
import javax.swing.UIManager;


/**
 *
 * @author Bash
 */
public class Wizard extends javax.swing.JFrame {

    TablesView tv=new TablesView();
    /** Creates new form Wizard */
    public Wizard() {
        setTitle("R2O Wizard");
        initComponents();
      //setResizable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        but_next = new javax.swing.JButton();
        but_prev = new javax.swing.JButton();
        target = new javax.swing.JPanel();
        parametersView = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        but_next.setText("Next >");
        but_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_nextActionPerformed(evt);
            }
        });

        but_prev.setText("< Previous");
        but_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_prevActionPerformed(evt);
            }
        });

        parametersView.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Url :");

        jLabel2.setText("User :");

        jLabel3.setText("Password :");

        jLabel4.setText("Complet :");

        javax.swing.GroupLayout parametersViewLayout = new javax.swing.GroupLayout(parametersView);
        parametersView.setLayout(parametersViewLayout);
        parametersViewLayout.setHorizontalGroup(
            parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersViewLayout.createSequentialGroup()
                .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametersViewLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(parametersViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        parametersViewLayout.setVerticalGroup(
            parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersViewLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(parametersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout targetLayout = new javax.swing.GroupLayout(target);
        target.setLayout(targetLayout);
        targetLayout.setHorizontalGroup(
            targetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(targetLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(parametersView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        targetLayout.setVerticalGroup(
            targetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(targetLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(parametersView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(but_prev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_next, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(target, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(target, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_next)
                    .addComponent(but_prev))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_nextActionPerformed
     this.target.remove(parametersView);
     this.target.add(tv,new FlowLayout());
//     this.target.validate();
     this.target.repaint();
     but_next.setText("Finish");
   //  pack();
    }//GEN-LAST:event_but_nextActionPerformed

    private void but_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_prevActionPerformed
     this.target.remove(tv);
     this.target.add(parametersView,new FlowLayout());
//     this.target.validate();
     but_next.setText("Next");
     this.target.repaint();
    //  pack();
    }//GEN-LAST:event_but_prevActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        try {
          //  UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wizard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_next;
    private javax.swing.JButton but_prev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel parametersView;
    private javax.swing.JPanel target;
    // End of variables declaration//GEN-END:variables

}