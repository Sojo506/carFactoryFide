package view.panel;

import controller.GameController;
import java.awt.Color;
import javax.swing.JButton;
import model.Material;
import model.structures.LinkedList;

public class ConveyorBeltPanel extends javax.swing.JPanel {

    private GameController controller;
    private AssemblyPanel assemblyPanel;
    private JButton[] materialBtns;
    private JButton trashCanBtn;
    private int selectedMaterial = -1;

    public ConveyorBeltPanel(GameController controller, AssemblyPanel assemblyPanel, JButton trashCanBtn) {
        //this.mainView = mainView;
        this.controller = controller;
        this.assemblyPanel = assemblyPanel;
        this.trashCanBtn = trashCanBtn;
        initComponents();
        materialBtns = new JButton[]{materialBtn0, materialBtn1, materialBtn2, materialBtn3, materialBtn4};
        updateBelt();
    }

    public void updateBelt() {
        LinkedList<Material> belt = controller.getConveyorBelt();
        int beltCapacity = controller.getFactory().getBeltCapacity();

        for (int i = 0; i < materialBtns.length; i++) {
            if (i < beltCapacity && i < belt.size()) {
                model.Material mat = belt.getElement(i);
                materialBtns[i].setVisible(true);
                materialBtns[i].setText(mat.toString());
                materialBtns[i].setEnabled(true);
                materialBtns[i].setBackground(new Color(47, 47, 47)); // default
            } else {
                materialBtns[i].setVisible(false);
            }
        }
        selectedMaterial = -1; // Nada seleccionado por defecto
        controller.setSelectedMaterial(selectedMaterial);
    }

    // ConveyorBeltPanel.java
    public void removeMaterialFromBelt(Material material) {
        LinkedList<Material> belt = controller.getConveyorBelt();

        for (int i = 0; i < belt.size(); i++) {
            if (belt.getElement(i) == material) {
                // Quita el material del slot
                belt.remove(i);

                // Busca material único
                Material nuevo = controller.getFactory().getMaterialGenerator().getUniqueRandomMaterial(belt);

                // Inserta en la misma posición
                belt.add(i, nuevo);

                updateMaterialButton(i); // refresca solo ese botón
                break;
            }
        }
    }

    private void updateMaterialButton(int idx) {
        LinkedList<Material> belt = controller.getConveyorBelt();

        if (idx < belt.size()) {
            materialBtns[idx].setVisible(true);
            materialBtns[idx].setText(belt.getElement(idx).toString());
            materialBtns[idx].setEnabled(true);
            materialBtns[idx].setBackground(new Color(47, 47, 47));
        } else {
            materialBtns[idx].setVisible(false);
        }
    }

    private void onMaterialBtnSelected(int idx) {
        // Marca botón seleccionado visualmente
        for (int i = 0; i < materialBtns.length; i++) {
            materialBtns[i].setBackground(i == idx ? new Color(70, 130, 180) : new Color(47, 47, 47));
        }
        selectedMaterial = idx;
        controller.setSelectedMaterial(selectedMaterial);

        // Notifica al AssemblyPanel el material seleccionado
        Material mat = controller.getConveyorBelt().getElement(idx);
        assemblyPanel.onMaterialSelected(mat);

        trashCanBtn.setEnabled(true);
    }

    public void discardSelectedMaterial() {
        if (selectedMaterial != -1) {
            controller.discardMaterial(selectedMaterial);
            updateMaterialButton(selectedMaterial); // solo refresca el botón afectado
            assemblyPanel.disableAllAddButtons();
            selectedMaterial = -1;
            controller.setSelectedMaterial(selectedMaterial);
            trashCanBtn.setEnabled(false);
        }
    }

    public void resetColorMaterial() {
        for (int i = 0; i < materialBtns.length; i++) {
            materialBtns[i].setBackground(i == selectedMaterial ? new Color(70, 130, 180) : new Color(47, 47, 47));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialBtn2 = new javax.swing.JButton();
        materialBtn1 = new javax.swing.JButton();
        materialBtn4 = new javax.swing.JButton();
        materialBtn0 = new javax.swing.JButton();
        materialBtn3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(59, 59, 59));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        materialBtn2.setBackground(new java.awt.Color(47, 47, 47));
        materialBtn2.setForeground(new java.awt.Color(255, 255, 255));
        materialBtn2.setText("Carrocería");
        materialBtn2.setBorderPainted(false);
        materialBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialBtn2.setFocusPainted(false);
        materialBtn2.setFocusable(false);
        materialBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialBtn2ActionPerformed(evt);
            }
        });

        materialBtn1.setBackground(new java.awt.Color(47, 47, 47));
        materialBtn1.setForeground(new java.awt.Color(255, 255, 255));
        materialBtn1.setText("Llantas de trabajo");
        materialBtn1.setBorderPainted(false);
        materialBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialBtn1.setFocusPainted(false);
        materialBtn1.setFocusable(false);
        materialBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialBtn1ActionPerformed(evt);
            }
        });

        materialBtn4.setBackground(new java.awt.Color(47, 47, 47));
        materialBtn4.setForeground(new java.awt.Color(255, 255, 255));
        materialBtn4.setText("Motor deportivo");
        materialBtn4.setBorderPainted(false);
        materialBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialBtn4.setFocusPainted(false);
        materialBtn4.setFocusable(false);
        materialBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialBtn4ActionPerformed(evt);
            }
        });

        materialBtn0.setBackground(new java.awt.Color(47, 47, 47));
        materialBtn0.setForeground(new java.awt.Color(255, 255, 255));
        materialBtn0.setText("Carrocería especial");
        materialBtn0.setBorderPainted(false);
        materialBtn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialBtn0.setFocusPainted(false);
        materialBtn0.setFocusable(false);
        materialBtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialBtn0ActionPerformed(evt);
            }
        });

        materialBtn3.setBackground(new java.awt.Color(47, 47, 47));
        materialBtn3.setForeground(new java.awt.Color(255, 255, 255));
        materialBtn3.setText("Llantas de trabajo");
        materialBtn3.setBorderPainted(false);
        materialBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialBtn3.setFocusPainted(false);
        materialBtn3.setFocusable(false);
        materialBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(materialBtn1)
                .addGap(176, 176, 176)
                .addComponent(materialBtn0)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(materialBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(materialBtn4)
                .addGap(138, 138, 138)
                .addComponent(materialBtn3)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(materialBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(materialBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(materialBtn0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(materialBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void materialBtn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialBtn0ActionPerformed
        onMaterialBtnSelected(0);
    }//GEN-LAST:event_materialBtn0ActionPerformed

    private void materialBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialBtn1ActionPerformed
        onMaterialBtnSelected(1);
    }//GEN-LAST:event_materialBtn1ActionPerformed

    private void materialBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialBtn2ActionPerformed
        onMaterialBtnSelected(2);
    }//GEN-LAST:event_materialBtn2ActionPerformed

    private void materialBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialBtn3ActionPerformed
        onMaterialBtnSelected(3);
    }//GEN-LAST:event_materialBtn3ActionPerformed

    private void materialBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialBtn4ActionPerformed
        onMaterialBtnSelected(4);
    }//GEN-LAST:event_materialBtn4ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        trashCanBtn.setEnabled(false);
        selectedMaterial = -1;
        controller.setSelectedMaterial(selectedMaterial);

        resetColorMaterial();

        assemblyPanel.disableAllAddButtons();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton materialBtn0;
    private javax.swing.JButton materialBtn1;
    private javax.swing.JButton materialBtn2;
    private javax.swing.JButton materialBtn3;
    private javax.swing.JButton materialBtn4;
    // End of variables declaration//GEN-END:variables
}
