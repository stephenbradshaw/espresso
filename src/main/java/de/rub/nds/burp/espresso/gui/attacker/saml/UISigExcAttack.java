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
package de.rub.nds.burp.espresso.gui.attacker.saml;

import de.rub.nds.burp.espresso.gui.attacker.IAttack;
import de.rub.nds.burp.utilities.Logging;
import de.rub.nds.burp.utilities.XMLHelper;
import de.rub.nds.burp.utilities.listeners.AbstractCodeEvent;
import de.rub.nds.burp.utilities.listeners.CodeListenerController;
import de.rub.nds.burp.utilities.listeners.CodeListenerControllerType;
import de.rub.nds.burp.utilities.listeners.events.SamlCodeEvent;
import de.rub.nds.burp.utilities.listeners.events.SigAlgoCodeEvent;
import de.rub.nds.burp.utilities.listeners.events.SignatureCodeEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import wsattacker.library.xmlutilities.dom.DomUtilities;

/**
 * The Signature Exlusion Attack
 * @author Nurullah Erinola
 * @version 1.0
 */
public class UISigExcAttack extends javax.swing.JPanel implements IAttack {

    private String getParamSignature = null;
    private String getParamSigAlgo = null;
    private String saml = null;
    private Document doc = null;
    private CodeListenerController listeners = null;
    private CodeListenerController listenersSig = null;
    private DefaultListModel signaturePaths;
    private ArrayList<Element> signatures;
    private boolean sigInGetParam = false;
    private String sigPathGetPost = "Signature as GET/POST parameter";

    /**
     * Creates new form UISigExcAttack
     */
    public UISigExcAttack() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPaneSignatures = new javax.swing.JScrollPane();
        jListSignatures = new javax.swing.JList<>();
        jButtonDeleteSelected = new javax.swing.JButton();
        jButtonDeleteAll = new javax.swing.JButton();

        jLabel1.setText("Select signature to be faked:");

        jScrollPaneSignatures.setViewportView(jListSignatures);

        jButtonDeleteSelected.setText("Delete");
        jButtonDeleteSelected.setToolTipText("Delete selected signatures.");
        jButtonDeleteSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteSelectedActionPerformed(evt);
            }
        });

        jButtonDeleteAll.setText("Delete all");
        jButtonDeleteAll.setToolTipText("Delete all signatures.");
        jButtonDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSignatures, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonDeleteSelected)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDeleteAll)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSignatures, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDeleteAll)
                    .addComponent(jButtonDeleteSelected))
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAllActionPerformed
        if(!signatures.isEmpty()) {
            Logging.getInstance().log(getClass(), "Start signature exclusion.", Logging.INFO);
            for(Element element: signatures) {
                removeElement(element);
            }
            saml = XMLHelper.docToString(doc);
            notifyAllTabs(new SamlCodeEvent(this, saml.getBytes()));
            Logging.getInstance().log(getClass(), "Signature exclusion successfull.", Logging.INFO);
        }
        if(sigInGetParam == true) {
            notifyAllTabs(new SigAlgoCodeEvent(this, null));
            notifyAllTabs(new SignatureCodeEvent(this, null));
        }
    }//GEN-LAST:event_jButtonDeleteAllActionPerformed

    private void jButtonDeleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteSelectedActionPerformed
        if(!jListSignatures.isSelectionEmpty()) {
            Logging.getInstance().log(getClass(), "Start signature exclusion.", Logging.INFO);
            for(int i : jListSignatures.getSelectedIndices()) {
                if(signaturePaths.get(i).equals(sigPathGetPost)) {
                    notifyAllTabs(new SigAlgoCodeEvent(this, null));
                    notifyAllTabs(new SignatureCodeEvent(this, null));
                } else {
                    removeElement(signatures.get(i));
                }
            }
            saml = XMLHelper.docToString(doc);
            notifyAllTabs(new SamlCodeEvent(this, saml.getBytes()));
            Logging.getInstance().log(getClass(), "Signature exclusion successfull.", Logging.INFO);
        }
    }//GEN-LAST:event_jButtonDeleteSelectedActionPerformed

    /**
     * Remove given node
     */
    private void removeElement(Element element) {
        if (element.getParentNode() != null)
        {
            element.getParentNode().removeChild( element );
        }
    }

    /**
     * Update JList with signature paths
     */
    private void update() {
        signatures = new ArrayList<>();
        signaturePaths = new DefaultListModel();
        doc = XMLHelper.stringToDom(saml);
        // Search signatures in SAML message
        NodeList list = doc.getElementsByTagNameNS("*", "Signature");
        for(int i = 0; i < list.getLength(); i++) {
            signatures.add((Element) list.item(i));
            signaturePaths.addElement(DomUtilities.getFastXPath(list.item(i)));
        }
        // Seach signature in GET parameters
        if (sigInGetParam == true) {
            signaturePaths.addElement(sigPathGetPost);
        }
        jListSignatures.setModel(signaturePaths);
    }

    /**
     * Is called every time new Code is available.
     * @param evt {@link de.rub.nds.burp.utilities.listeners.AbstractCodeEvent} The new source code.
     */
    @Override
    public void setCode(AbstractCodeEvent evt) {
        if(evt instanceof SamlCodeEvent) {
            this.saml = new String(evt.getCode());
        } else if(evt instanceof SignatureCodeEvent) {
            this.getParamSignature = new String(evt.getCode());
            sigInGetParam = getParamSigAlgo != null && getParamSignature != null;
        } else if(evt instanceof SigAlgoCodeEvent) {
            this.getParamSigAlgo = new String(evt.getCode());
            sigInGetParam = getParamSigAlgo != null && getParamSignature != null;
        }
        update();
    }

    /**
     * Notify all registered listeners with the new code.
     * @param evt The event with the new code.
     */
    @Override
    public void notifyAllTabs(AbstractCodeEvent evt) {
        if(evt instanceof SamlCodeEvent) {
            if(listeners != null) {
                listeners.notifyAll(evt);
                Logging.getInstance().log(getClass(), "Notify all Listeners (SamlCodeEvent).", Logging.DEBUG);
            }
        } else if(evt instanceof SigAlgoCodeEvent || evt instanceof SignatureCodeEvent) {
            if(listenersSig != null) {
                listenersSig.notifyAll(evt);
                Logging.getInstance().log(getClass(), "Notify all Listeners (SigAlgoCodeEvent/SignatureCodeEvent).", Logging.DEBUG);
            }
        }
    }

    /**
     * Set the listener for the editor.
     * @param listeners {@link de.rub.nds.burp.utilities.listeners.CodeListenerController}
     */
    @Override
    public void setListener(CodeListenerController listeners) {
        if(listeners.getType() == CodeListenerControllerType.SAML) {
            this.listeners = listeners;
            this.listeners.addCodeListener(this);
        } else if(listeners.getType() == CodeListenerControllerType.SIGNATURE) {
            this.listenersSig = listeners;
            this.listenersSig.addCodeListener(this);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteAll;
    private javax.swing.JButton jButtonDeleteSelected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListSignatures;
    private javax.swing.JScrollPane jScrollPaneSignatures;
    // End of variables declaration//GEN-END:variables
}
