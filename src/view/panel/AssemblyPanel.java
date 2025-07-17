package view.panel;

import controller.GameController;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.AssemblyLine;
import model.Material;
import model.structures.LinkedList;
import util.Colors;
import view.MainView;

/**
 * Panel que representa las líneas de ensamblaje y sus controles de interacción.
 * Permite agregar materiales, actualizar el estado visual de las líneas y
 * mostrar el avance de las órdenes.
 */
public class AssemblyPanel extends javax.swing.JPanel {

    // Referencia a la ventana principal (para actualizar acciones globales, como el trashcan)
    private MainView mainView;
    // Controlador del juego (toda la lógica del modelo)
    private GameController controller;
    // Panel de la cinta de materiales (para refrescar cuando se agrega/quita material)
    private ConveyorBeltPanel conveyorBeltPanel;
    // Panel del HUD (para actualizar info como dinero/meta/órdenes)
    private HubPanel hubPanel;
    // Material actualmente seleccionado para agregar
    private Material selectedMaterial = null;

    public AssemblyPanel(MainView mainView, GameController controller, ConveyorBeltPanel conveyorBeltPanel, HubPanel hubPanel) {
        this.mainView = mainView;
        this.controller = controller;
        this.conveyorBeltPanel = conveyorBeltPanel;
        this.hubPanel = hubPanel;
        initComponents();
        disableAllAddButtons();
        clearAllLists();
        updateAllTitles();
    }

    /**
     * Actualiza el título de cada línea de ensamblaje, mostrando el tipo de
     * auto o "Vacío" si la línea no tiene orden activa.
     */
    public void updateAllTitles() {
        for (int i = 0; i < 3; i++) {
            model.AssemblyLine line = controller.getAssemblyLines().getElement(i);
            String title = "Vacío";

            if (line != null && line.isOccupied() && line.getOrder() != null) {
                title = line.getOrder().getCar().getType().getCarName();
            }

            switch (i) {
                case 0 ->
                    assemblyTitle0.setText(title);
                case 1 ->
                    assemblyTitle1.setText(title);
                case 2 ->
                    assemblyTitle2.setText(title);
            }
        }
    }

    /**
     * Limpia las listas de materiales mostradas en las 3 líneas (útil al
     * resetear panel).
     */
    private void clearAllLists() {
        assemblyList0.setListData(new String[0]);
        assemblyList1.setListData(new String[0]);
        assemblyList2.setListData(new String[0]);
    }

    /**
     * Desactiva los botones de agregar material en todas las líneas. Solo se
     * activa cuando hay un material seleccionado y la línea está ocupada.
     */
    public void disableAllAddButtons() {
        assemblyBtn0.setEnabled(false);
        assemblyBtn1.setEnabled(false);
        assemblyBtn2.setEnabled(false);
    }

    /**
     * Refresca la lista de materiales agregados a una línea específica (por
     * índice). Muestra el progreso de construcción del auto.
     */
    private void updateAssemblyLineMaterials(int lineIndex) {
        AssemblyLine line = controller.getAssemblyLines().getElement(lineIndex);

        if (line != null && line.isOccupied() && line.getOrder() != null) {
            // Se obtiene la lista de materiales usando la estructura personalizada LinkedList
            LinkedList<Material> materials = line.getOrder().getCar().getMaterialsAdded();

            // Se crea una LinkedList de String para nombres de los materiales
            LinkedList<String> matNamesList = new LinkedList<>();

            // Llenar matNamesList con los nombres de cada material
            for (int i = 0; i < materials.size(); i++) {
                matNamesList.add(materials.getElement(i).toString());
            }

            // 
            // Conversión obligatoria de LinkedList a String[] porque JList SOLO acepta arrays nativos
            // 
            String[] matNames = new String[matNamesList.size()];
            for (int i = 0; i < matNamesList.size(); i++) {
                matNames[i] = matNamesList.getElement(i);
            }

            // Mostrar en el componente visual correspondiente
            switch (lineIndex) {
                case 0 ->
                    assemblyList0.setListData(matNames);
                case 1 ->
                    assemblyList1.setListData(matNames);
                case 2 ->
                    assemblyList2.setListData(matNames);
            }
        } else {
            // Limpia la lista visual si no hay materiales
            switch (lineIndex) {
                case 0 ->
                    assemblyList0.setListData(new String[0]);
                case 1 ->
                    assemblyList1.setListData(new String[0]);
                case 2 ->
                    assemblyList2.setListData(new String[0]);
            }
        }
    }

    /**
     * Habilita los botones de agregar material solo en las líneas que estén
     * ocupadas y cuando hay un material seleccionado.
     */
    private void enableAvailableLines() {
        for (int i = 0; i < 3; i++) {
            AssemblyLine line = controller.getAssemblyLines().getElement(i);

            boolean enable = (line != null && line.isOccupied() && selectedMaterial != null);

            switch (i) {
                case 0 ->
                    assemblyBtn0.setEnabled(enable);
                case 1 ->
                    assemblyBtn1.setEnabled(enable);
                case 2 ->
                    assemblyBtn2.setEnabled(enable);
            }
        }
    }

    /**
     * Método llamado cuando se selecciona un material en la cinta. Guarda el
     * material y habilita los botones en las líneas disponibles.
     */
    public void onMaterialSelected(model.Material material) {
        this.selectedMaterial = material;
        enableAvailableLines();
    }

    /**
     * Intenta agregar el material seleccionado a la línea de ensamblaje
     * indicada. Si el material es válido y se agrega, actualiza vista y lógica.
     */
    public void onAddMaterialToLine(int lineIndex) {
        if (selectedMaterial != null) {
            boolean agregado = controller.addMaterialToLine(selectedMaterial, lineIndex);

            if (agregado) {
                // Actualiza la lista de materiales y el fondo de la línea
                updateAssemblyLineMaterials(lineIndex);
                updateAssemblyLineBackgrounds();

                // Remueve el material de la cinta y coloca uno nuevo, solo en esa posición
                conveyorBeltPanel.removeMaterialFromBelt(selectedMaterial);

                // Verifica si el auto ya está completo para cerrar la orden
                AssemblyLine line = controller.getAssemblyLines().getElement(lineIndex);

                if (line.getOrder() != null && line.getOrder().getCar().isComplete()) {
                    int visibleOrderIndex = line.getOriginSlot();
                    model.Order completedOrder = line.getOrder();

                    controller.completeOrderInLine(lineIndex, visibleOrderIndex);

                    // Limpia solo la lista de materiales de la línea completada
                    clearList(lineIndex);

                    // Refresca títulos, fondos y panel de información
                    updateAllTitles();
                    updateAssemblyLineBackgrounds();
                    if (hubPanel != null) {
                        hubPanel.updateHUB();
                        hubPanel.updateOrdersDisplay();
                    }

                    // Muestra mensaje al usuario por completar la orden
                    JOptionPane.showMessageDialog(this,
                            "¡Linda! Completaste la orden:\n"
                            + completedOrder.getCar().getType().getCarName(),
                            "Orden completada",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

                // Limpia el estado de selección de material y deshabilita botones de agregar
                selectedMaterial = null;
                disableAllAddButtons();
            } else {
                // Si el material no es válido para ese auto, muestra error
                JOptionPane.showMessageDialog(this, "Material no válido para este auto.", "Error", JOptionPane.ERROR_MESSAGE);
                disableAllAddButtons();
                selectedMaterial = null;
            }

            // Limpia selección y refresca cinta
            if (mainView != null) {
                mainView.disableTrashCan();
            }
            conveyorBeltPanel.resetColorMaterial();
            conveyorBeltPanel.updateBelt();
        }
    }

    /**
     * Cambia el color de fondo de los paneles de líneas de ensamblaje, para
     * indicar visualmente si están activas, en progreso, etc.
     */
    public void updateAssemblyLineBackgrounds() {
        for (int i = 0; i < 3; i++) {
            AssemblyLine line = controller.getAssemblyLines().getElement(i);
            Color bgColor;

            if (line != null && line.isOccupied() && line.getOrder() != null) {
                if (line.getOrder().getStatus() == model.enums.OrderStatus.IN_PROGRESS) {
                    bgColor = Colors.ACTIVE_LINE;
                } else {
                    bgColor = Colors.INACTIVE_LINE; // Por defecto si no está en progreso
                }
            } else {
                bgColor = Colors.INACTIVE_LINE; // Color gris si está vacía
            }

            switch (i) {
                case 0 ->
                    assemblyLinePanel0.setBackground(bgColor);
                case 1 ->
                    assemblyLinePanel1.setBackground(bgColor);
                case 2 ->
                    assemblyLinePanel2.setBackground(bgColor);
            }
        }
    }

    public void clearList(int index) {
        switch (index) {
            case 0 ->
                assemblyList0.setListData(new String[0]);
            case 1 ->
                assemblyList1.setListData(new String[0]);
            case 2 ->
                assemblyList2.setListData(new String[0]);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assemblyLinePanel1 = new javax.swing.JPanel();
        assemblyTitle1 = new javax.swing.JLabel();
        assemblyBtn1 = new javax.swing.JButton();
        assemblySubTitle1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        assemblyList1 = new javax.swing.JList<>();
        assemblyLinePanel2 = new javax.swing.JPanel();
        assemblyTitle2 = new javax.swing.JLabel();
        assemblyBtn2 = new javax.swing.JButton();
        assemblySubTitle2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        assemblyList2 = new javax.swing.JList<>();
        assemblyLinePanel0 = new javax.swing.JPanel();
        assemblyBtn0 = new javax.swing.JButton();
        assemblyTitle0 = new javax.swing.JLabel();
        assemblySubTitle0 = new javax.swing.JLabel();
        jScrollPane0 = new javax.swing.JScrollPane();
        assemblyList0 = new javax.swing.JList<>();

        setBackground(new java.awt.Color(59, 59, 59));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        assemblyLinePanel1.setBackground(new java.awt.Color(90, 90, 90));

        assemblyTitle1.setFont(new java.awt.Font("Adwaita Sans", 1, 16)); // NOI18N
        assemblyTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblyTitle1.setText("SEDAN");

        assemblyBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addpart.png"))); // NOI18N
        assemblyBtn1.setBorderPainted(false);
        assemblyBtn1.setContentAreaFilled(false);
        assemblyBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        assemblyBtn1.setFocusPainted(false);
        assemblyBtn1.setFocusable(false);
        assemblyBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblyBtn1ActionPerformed(evt);
            }
        });

        assemblySubTitle1.setFont(new java.awt.Font("Adwaita Sans", 1, 15)); // NOI18N
        assemblySubTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblySubTitle1.setText("Partes");

        assemblyList1.setBackground(new java.awt.Color(85, 85, 85));
        assemblyList1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(assemblyList1);

        javax.swing.GroupLayout assemblyLinePanel1Layout = new javax.swing.GroupLayout(assemblyLinePanel1);
        assemblyLinePanel1.setLayout(assemblyLinePanel1Layout);
        assemblyLinePanel1Layout.setHorizontalGroup(
            assemblyLinePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(assemblyLinePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(assemblyLinePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(assemblyLinePanel1Layout.createSequentialGroup()
                        .addComponent(assemblyTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(assemblyLinePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assemblySubTitle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        assemblyLinePanel1Layout.setVerticalGroup(
            assemblyLinePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assemblyTitle1)
                .addGap(30, 30, 30)
                .addComponent(assemblyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(assemblySubTitle1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        assemblyLinePanel2.setBackground(new java.awt.Color(90, 90, 90));

        assemblyTitle2.setFont(new java.awt.Font("Adwaita Sans", 1, 16)); // NOI18N
        assemblyTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblyTitle2.setText("SEDAN");

        assemblyBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addpart.png"))); // NOI18N
        assemblyBtn2.setBorderPainted(false);
        assemblyBtn2.setContentAreaFilled(false);
        assemblyBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        assemblyBtn2.setFocusPainted(false);
        assemblyBtn2.setFocusable(false);
        assemblyBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblyBtn2ActionPerformed(evt);
            }
        });

        assemblySubTitle2.setFont(new java.awt.Font("Adwaita Sans", 1, 15)); // NOI18N
        assemblySubTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblySubTitle2.setText("Partes");

        assemblyList2.setBackground(new java.awt.Color(85, 85, 85));
        assemblyList2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(assemblyList2);

        javax.swing.GroupLayout assemblyLinePanel2Layout = new javax.swing.GroupLayout(assemblyLinePanel2);
        assemblyLinePanel2.setLayout(assemblyLinePanel2Layout);
        assemblyLinePanel2Layout.setHorizontalGroup(
            assemblyLinePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(assemblyLinePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(assemblyLinePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(assemblyLinePanel2Layout.createSequentialGroup()
                        .addComponent(assemblyTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(assemblyLinePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assemblySubTitle2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        assemblyLinePanel2Layout.setVerticalGroup(
            assemblyLinePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assemblyTitle2)
                .addGap(30, 30, 30)
                .addComponent(assemblyBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(assemblySubTitle2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        assemblyLinePanel0.setBackground(new java.awt.Color(90, 90, 90));

        assemblyBtn0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addpart.png"))); // NOI18N
        assemblyBtn0.setBorderPainted(false);
        assemblyBtn0.setContentAreaFilled(false);
        assemblyBtn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        assemblyBtn0.setFocusPainted(false);
        assemblyBtn0.setFocusable(false);
        assemblyBtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblyBtn0ActionPerformed(evt);
            }
        });

        assemblyTitle0.setFont(new java.awt.Font("Adwaita Sans", 1, 16)); // NOI18N
        assemblyTitle0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblyTitle0.setText("SEDAN");

        assemblySubTitle0.setFont(new java.awt.Font("Adwaita Sans", 1, 15)); // NOI18N
        assemblySubTitle0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblySubTitle0.setText("Partes");

        assemblyList0.setBackground(new java.awt.Color(85, 85, 85));
        assemblyList0.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane0.setViewportView(assemblyList0);

        javax.swing.GroupLayout assemblyLinePanel0Layout = new javax.swing.GroupLayout(assemblyLinePanel0);
        assemblyLinePanel0.setLayout(assemblyLinePanel0Layout);
        assemblyLinePanel0Layout.setHorizontalGroup(
            assemblyLinePanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel0Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn0, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(assemblyLinePanel0Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(assemblyLinePanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel0Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(assemblySubTitle0, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(assemblyLinePanel0Layout.createSequentialGroup()
                        .addComponent(assemblyTitle0, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        assemblyLinePanel0Layout.setVerticalGroup(
            assemblyLinePanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assemblyTitle0)
                .addGap(30, 30, 30)
                .addComponent(assemblyBtn0, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(assemblySubTitle0)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane0, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assemblyLinePanel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(assemblyLinePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(assemblyLinePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(assemblyLinePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assemblyLinePanel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assemblyLinePanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assemblyBtn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assemblyBtn0ActionPerformed
        onAddMaterialToLine(0);
    }//GEN-LAST:event_assemblyBtn0ActionPerformed

    private void assemblyBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assemblyBtn1ActionPerformed
        onAddMaterialToLine(1);
    }//GEN-LAST:event_assemblyBtn1ActionPerformed

    private void assemblyBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assemblyBtn2ActionPerformed
        onAddMaterialToLine(2);
    }//GEN-LAST:event_assemblyBtn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assemblyBtn0;
    private javax.swing.JButton assemblyBtn1;
    private javax.swing.JButton assemblyBtn2;
    private javax.swing.JPanel assemblyLinePanel0;
    private javax.swing.JPanel assemblyLinePanel1;
    private javax.swing.JPanel assemblyLinePanel2;
    private javax.swing.JList<String> assemblyList0;
    private javax.swing.JList<String> assemblyList1;
    private javax.swing.JList<String> assemblyList2;
    private javax.swing.JLabel assemblySubTitle0;
    private javax.swing.JLabel assemblySubTitle1;
    private javax.swing.JLabel assemblySubTitle2;
    private javax.swing.JLabel assemblyTitle0;
    private javax.swing.JLabel assemblyTitle1;
    private javax.swing.JLabel assemblyTitle2;
    private javax.swing.JScrollPane jScrollPane0;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void setConveyorBeltPanel(ConveyorBeltPanel conveyorBeltPanel) {
        this.conveyorBeltPanel = conveyorBeltPanel;
    }

    public void setHubPanel(HubPanel hubPanel) {
        this.hubPanel = hubPanel;
    }

    public JList getAssemblyList0() {
        return assemblyList0;
    }

    public JList getAssemblyList1() {
        return assemblyList1;
    }

    public JList getAssemblyList2() {
        return assemblyList2;
    }

}
