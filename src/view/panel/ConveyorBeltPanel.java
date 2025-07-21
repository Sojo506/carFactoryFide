package view.panel;

import controller.GameController;
import java.awt.Color;
import javax.swing.JButton;
import model.Material;
import model.structure.linkedlist.LinkedList;

/**
 * Panel visual para mostrar y gestionar la cinta transportadora de materiales
 * (Conveyor Belt). Permite al usuario seleccionar materiales, eliminarlos
 * (descartarlos), y actualizar la vista cuando hay cambios.
 */
public class ConveyorBeltPanel extends javax.swing.JPanel {

    // Referencia al controlador del juego
    private GameController controller;
    // Referencia al panel de ensamblaje asociado
    private AssemblyPanel assemblyPanel;
    // Arreglo de botones que representan cada slot de material en la cinta
    private LinkedList<JButton> materialBtns;
    // Botón para descartar materiales (basurero)
    private JButton trashCanBtn;
    // Índice del material seleccionado actualmente (-1 ninguno)
    private int selectedMaterial = -1;

    /**
     * Constructor principal, recibe el controlador, panel de ensamblaje y el
     * botón de basurero.
     */
    public ConveyorBeltPanel(GameController controller, AssemblyPanel assemblyPanel, JButton trashCanBtn) {
        this.controller = controller;
        this.assemblyPanel = assemblyPanel;
        this.trashCanBtn = trashCanBtn;
        initComponents();
        // Inicializa la lista de botones con tu propia LinkedList
        materialBtns = new LinkedList<>();
        materialBtns.add(materialBtn0);
        materialBtns.add(materialBtn1);
        materialBtns.add(materialBtn2);
        materialBtns.add(materialBtn3);
        materialBtns.add(materialBtn4);
        updateBelt();
    }

    /**
     * Actualiza toda la cinta transportadora según los materiales actuales del
     * modelo. Habilita/deshabilita los botones y refresca su texto/color.
     */
    public void updateBelt() {
        LinkedList<Material> belt = controller.getConveyorBelt();
        int beltCapacity = controller.getFactory().getBeltCapacity();

        for (int i = 0; i < materialBtns.size(); i++) {
            JButton btn = materialBtns.getElement(i);
            if (i < beltCapacity && i < belt.size()) {
                Material mat = belt.getElement(i);
                btn.setVisible(true);
                btn.setText(mat.toString());
                btn.setEnabled(true);
                btn.setBackground(new Color(47, 47, 47)); // Color por defecto
            } else {
                btn.setVisible(false);
            }
        }
        // Por defecto, nada está seleccionado tras actualizar
        selectedMaterial = -1;
        controller.setSelectedMaterial(selectedMaterial);
    }

    /**
     * Remueve un material específico de la cinta (por objeto) y lo reemplaza
     * por uno nuevo, que no esté ya en la cinta. Solo actualiza el botón
     * afectado.
     */
    public void removeMaterialFromBelt(Material material) {
        LinkedList<Material> belt = controller.getConveyorBelt();

        for (int i = 0; i < belt.size(); i++) {
            if (belt.getElement(i) == material) {
                Material nuevo = controller.getFactory().getMaterialGenerator().getUniqueRandomMaterial(belt);
                belt.setElement(i, nuevo);
                updateMaterialButton(i);
                break;
            }
        }
    }

    /**
     * Refresca el botón de material en la posición idx con el material actual
     * en la cinta. Es útil cuando se modifica solo una posición, para
     * eficiencia y UX.
     */
    private void updateMaterialButton(int idx) {
        LinkedList<Material> belt = controller.getConveyorBelt();

        if (idx < belt.size()) {
            JButton btn = materialBtns.getElement(idx);
            btn.setVisible(true);
            btn.setText(belt.getElement(idx).toString());
            btn.setEnabled(true);
            btn.setBackground(new Color(47, 47, 47));
        } else {
            materialBtns.getElement(idx).setVisible(false);
        }
    }

    /**
     * Acción al seleccionar (clic) uno de los materiales. Cambia visualmente el
     * botón, marca la selección en el modelo y notifica al AssemblyPanel.
     */
    private void onMaterialBtnSelected(int idx) {
        // Marca el botón seleccionado con color diferente
        for (int i = 0; i < materialBtns.size(); i++) {
            materialBtns.getElement(i).setBackground(i == idx ? new Color(70, 130, 180) : new Color(47, 47, 47));
        }
        selectedMaterial = idx;
        controller.setSelectedMaterial(selectedMaterial);

        // Notifica al panel de ensamblaje cuál material se seleccionó
        Material mat = controller.getConveyorBelt().getElement(idx);
        assemblyPanel.onMaterialSelected(mat);

        trashCanBtn.setEnabled(true); // Activa basurero
    }

    /**
     * Elimina el material actualmente seleccionado en la cinta. Llama al
     * controlador para penalizar y reemplaza solo ese slot.
     */
    public void discardSelectedMaterial() {
        if (selectedMaterial != -1) {
            controller.discardMaterial(selectedMaterial); // Penaliza y cambia material en modelo 
            updateMaterialButton(selectedMaterial); // Solo refresca el botón afectado
            assemblyPanel.disableAllAddButtons(); // Desactiva agregar hasta nueva selección
            selectedMaterial = -1;
            controller.setSelectedMaterial(selectedMaterial);
            trashCanBtn.setEnabled(false); // Desactiva basurero
        }
    }

    /**
     * Restablece el color de todos los botones de material, útil cuando se
     * limpia la selección o refresca la vista.
     */
    public void resetColorMaterial() {
        for (int i = 0; i < materialBtns.size(); i++) {
            materialBtns.getElement(i).setBackground(i == selectedMaterial ? new Color(70, 130, 180) : new Color(47, 47, 47));
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
