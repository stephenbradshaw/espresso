/**
 * EsPReSSO - Extension for Processing and Recognition of Single Sign-On Protocols.
 * Copyright (C) 2015 Tim Guenther and Christian Mainka
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package de.rub.nds.burp.espresso.intruder.dtd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Nurullah Erinola
 */
public class DTDInputJDialog extends javax.swing.JDialog {

    private int dtdVectorCount;
    
    /**
     * Creates new form DTDInputJDialog
     */
    public DTDInputJDialog(int vectorCount) {
        super(new JFrame(), true);
        this.dtdVectorCount = vectorCount;
        initComponents();
        jTextFieldProtocols.getDocument().addDocumentListener(new ListenerProtocolChangedListener());
        jTextAreaListeners.getDocument().addDocumentListener(new ListenerProtocolChangedListener());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupListenerSelection = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaListeners = new javax.swing.JTextArea();
        jCheckBoxPathEnum = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxSubdomainEnum = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldProtocols = new javax.swing.JTextField();
        jLabelInfo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jCheckBoxEnflate = new javax.swing.JCheckBox();
        jCheckBoxBase64 = new javax.swing.JCheckBox();
        jCheckBoxUrl = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonOk = new javax.swing.JButton();
        jCheckboxMutlipleListener = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Listener:");

        jTextAreaListeners.setColumns(20);
        jTextAreaListeners.setRows(5);
        jTextAreaListeners.setText("example.org");
        jScrollPane1.setViewportView(jTextAreaListeners);

        jCheckBoxPathEnum.setSelected(true);
        jCheckBoxPathEnum.setText("Enable Path Enum");
        jCheckBoxPathEnum.setToolTipText("By activating this option, a unique path Identitfier is added to each attack vector, e.g. http://example.org/1, http://example.org/2. ");

        jLabel2.setText("Options:");

        jCheckBoxSubdomainEnum.setText("Enable Subdomain Enum");
        jCheckBoxSubdomainEnum.setToolTipText("By activating this option, a unique subdomain Identitfier is added to each attack vector, e.g. http://1.example.org, http://2.example.org. ");

        jLabel3.setText("Protocol Handler:");

        jTextFieldProtocols.setText("http, https, ftp, smb");

        jLabelInfo.setForeground(new java.awt.Color(255, 0, 51));
        jLabelInfo.setText("   ");

        jLabel4.setText("Encoding:");
        jLabel4.setToolTipText("To enable the usage of the Intruder for SAML services, you can activate the encoding of the attack vectors.");

        jCheckBoxEnflate.setText("Deflate");

        jCheckBoxBase64.setText("Base64");

        jCheckBoxUrl.setText("URL");

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jCheckboxMutlipleListener.setText("Multiple Input");
        jCheckboxMutlipleListener.setToolTipText("By activating this option, the Intruder uses an unique Listener URL for each attack vector.");
        jCheckboxMutlipleListener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckboxMutlipleListenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jTextFieldProtocols)
                    .addComponent(jScrollPane1)
                    .addComponent(jButtonOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckboxMutlipleListener))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxSubdomainEnum)
                                    .addComponent(jCheckBoxPathEnum)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxBase64)
                                    .addComponent(jCheckBoxEnflate)
                                    .addComponent(jCheckBoxUrl))))
                        .addGap(0, 317, Short.MAX_VALUE))
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckboxMutlipleListener))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPathEnum)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSubdomainEnum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldProtocols, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBoxEnflate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxBase64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxUrl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jCheckboxMutlipleListenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckboxMutlipleListenerActionPerformed
        if(jCheckboxMutlipleListener.isSelected()) {
            jCheckBoxPathEnum.setEnabled(false);
            jCheckBoxSubdomainEnum.setEnabled(false);
        } else {
            jCheckBoxPathEnum.setEnabled(true);
            jCheckBoxSubdomainEnum.setEnabled(true);
        }
        updateInfoLabel();
    }//GEN-LAST:event_jCheckboxMutlipleListenerActionPerformed
       
    private List<String> getUserListeners() {
        // split on comma or whitespace (incl. newline)
        List<String> listeners = Arrays.asList(jTextAreaListeners.getText().split("\\s*,?\\s+"));
        return listeners;
    }
    
    public ArrayList<String> getListeners() {
        // returns exact number of required listener URLs
        int required = getProtocols().size() * dtdVectorCount;
        List<String> list = getUserListeners();
        ArrayList<String> listeners = new ArrayList<>();
        if(!jCheckboxMutlipleListener.isSelected()) {
            String url = list.get(0);
            // without Path Enum and without Subdomain Enum
            if(!jCheckBoxPathEnum.isSelected()&& !jCheckBoxSubdomainEnum.isSelected()) {
                for(int i = 0; i < required; i++) {
                    listeners.add(url);
                }
            // with Path Enum and without Subdomain Enum
            } else if(jCheckBoxPathEnum.isSelected() && !jCheckBoxSubdomainEnum.isSelected()) {
                for(int i = 0; i < required; i++) {
                    listeners.add(url + "/" + (i+1));
                } 
            // without Path Enum and with Subdomain Enum
            } else if(!jCheckBoxPathEnum.isSelected() && jCheckBoxSubdomainEnum.isSelected()) {
                for(int i = 0; i < required; i++) {
                    listeners.add((i+1) + "." + url);
                }                
            // with Path Enum and with Subdomain Enum
            } else if(jCheckBoxPathEnum.isSelected() && jCheckBoxSubdomainEnum.isSelected()) {
                for(int i = 0; i < required; i++) {
                    listeners.add((i+1) + "." + url + "/" + (i+1));
                }                
            }
        } else {
            listeners.addAll(list);
        }
        return listeners;
    }
        
    public ArrayList<String> getProtocols() {
        // split on comma or whitespace (incl. newline)
        List<String> rawProtocols = Arrays.asList(jTextFieldProtocols.getText().split("\\s*,?\\s+"));
        ArrayList<String> protocols = new ArrayList<>();
        for(String protocol: rawProtocols) {
            protocols.add(protocol + "://");
        }
        return protocols;
    }
        
    public boolean getEnflateChoice() {
        return jCheckBoxEnflate.isSelected();
    }
    
    public boolean getBase64Choice() {
        return jCheckBoxBase64.isSelected();
    }
    
    public boolean getUrlChoice() {
        return jCheckBoxUrl.isSelected();
    }
    
    private void updateInfoLabel() {
        int required = getProtocols().size() * dtdVectorCount;
        if(jTextFieldProtocols.getText().equals("") || jTextAreaListeners.getText().equals("")) {
            jLabelInfo.setText("ERROR: One or both inputs are empty!");
            jButtonOk.setEnabled(false);
        } else if(jCheckboxMutlipleListener.isSelected() && getUserListeners().size() < required) {
            jLabelInfo.setText("ERROR: Enter >=" + required + " listeners.");
            jButtonOk.setEnabled(false);
        } else {
            jLabelInfo.setText("");
            jButtonOk.setEnabled(true);
        }
    }
    
    private class ListenerProtocolChangedListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateInfoLabel();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateInfoLabel();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateInfoLabel();
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupListenerSelection;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JCheckBox jCheckBoxBase64;
    private javax.swing.JCheckBox jCheckBoxEnflate;
    private javax.swing.JCheckBox jCheckBoxPathEnum;
    private javax.swing.JCheckBox jCheckBoxSubdomainEnum;
    private javax.swing.JCheckBox jCheckBoxUrl;
    private javax.swing.JCheckBox jCheckboxMutlipleListener;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextAreaListeners;
    private javax.swing.JTextField jTextFieldProtocols;
    // End of variables declaration//GEN-END:variables
}
