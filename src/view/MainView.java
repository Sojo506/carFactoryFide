package view;

import controller.GameController;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import model.Player;
import view.panel.AssemblyPanel;
import view.panel.ConveyorBeltPanel;
import view.panel.HubPanel;

public class MainView extends javax.swing.JFrame {

    private HubPanel hubPanel;
    private ConveyorBeltPanel conveyorBeltPanel;
    private AssemblyPanel assemblyPanel;
    private GameController controller;
    private StartGameView start;
    private Player player;
    private int xMouse;
    private int yMouse;

    // Constructor principal de la ventana del juego
    public MainView(StartGameView start, Player player) {
        // Referencia a la pantalla de inicio y al jugador actual
        this.start = start;
        this.player = player;

        // Remueve el borde de la ventana principal para custom look & feel
        setUndecorated(true);

        // Inicializa los componentes de Swing (paneles, botones, etc.)
        initComponents(); // trashCanBtn debe ser inicializado aquí si es parte del diseño

        // Instancia el controlador del juego (gestiona lógica y estado)
        controller = new GameController(player);

        // Panel de líneas de ensamblaje, aún no enlazado a conveyor ni hub
        assemblyPanel = new AssemblyPanel(this, controller, null, null);

        // Panel de la cinta transportadora, enlazado al assemblyPanel y al botón de basura
        conveyorBeltPanel = new ConveyorBeltPanel(controller, assemblyPanel, trashCanBtn);

        // Ahora sí, conecta el assemblyPanel con la conveyorBeltPanel
        assemblyPanel.setConveyorBeltPanel(conveyorBeltPanel);

        // Panel de la HUD (órdenes, dinero, meta, etc.)
        hubPanel = new HubPanel(player, controller, assemblyPanel, conveyorBeltPanel);

        // Termina de enlazar el assemblyPanel con el hubPanel
        assemblyPanel.setHubPanel(hubPanel);

        setResizable(false); // No se puede redimensionar
        setLocationRelativeTo(null); // Centra la ventana al abrir
        trashCanBtn.setEnabled(false); // El basurero está deshabilitado por defecto

        initPanels();
    }

    private void initPanels() {
        hubPanelMain.setLayout(new BorderLayout());
        hubPanelMain.add(hubPanel, BorderLayout.CENTER);
        hubPanelMain.revalidate();
        hubPanelMain.repaint();

        assemblyPanelMain.setLayout(new BorderLayout());
        assemblyPanelMain.add(assemblyPanel, BorderLayout.CENTER);
        assemblyPanelMain.revalidate();
        assemblyPanelMain.repaint();

        conveyorBeltPanelMain.setLayout(new BorderLayout());
        conveyorBeltPanelMain.add(conveyorBeltPanel, BorderLayout.CENTER);
        conveyorBeltPanelMain.revalidate();
        conveyorBeltPanelMain.repaint();
    }

    public void disableTrashCan() {
        trashCanBtn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        hubPanelMain = new javax.swing.JPanel();
        assemblyPanelMain = new javax.swing.JPanel();
        trashCanBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        conveyorBeltPanelMain = new javax.swing.JPanel();
        dragBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        stopPlayBtn = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPanel.setBackground(new java.awt.Color(47, 47, 47));

        hubPanelMain.setBackground(new java.awt.Color(28, 40, 51));

        javax.swing.GroupLayout hubPanelMainLayout = new javax.swing.GroupLayout(hubPanelMain);
        hubPanelMain.setLayout(hubPanelMainLayout);
        hubPanelMainLayout.setHorizontalGroup(
            hubPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        hubPanelMainLayout.setVerticalGroup(
            hubPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );

        assemblyPanelMain.setBackground(new java.awt.Color(59, 59, 59));

        javax.swing.GroupLayout assemblyPanelMainLayout = new javax.swing.GroupLayout(assemblyPanelMain);
        assemblyPanelMain.setLayout(assemblyPanelMainLayout);
        assemblyPanelMainLayout.setHorizontalGroup(
            assemblyPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        assemblyPanelMainLayout.setVerticalGroup(
            assemblyPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        trashCanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trashcan.png"))); // NOI18N
        trashCanBtn.setBorderPainted(false);
        trashCanBtn.setContentAreaFilled(false);
        trashCanBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trashCanBtn.setFocusPainted(false);
        trashCanBtn.setFocusable(false);
        trashCanBtn.setName(""); // NOI18N
        trashCanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trashCanBtnActionPerformed(evt);
            }
        });

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.setFocusPainted(false);
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        conveyorBeltPanelMain.setBackground(new java.awt.Color(59, 59, 59));

        javax.swing.GroupLayout conveyorBeltPanelMainLayout = new javax.swing.GroupLayout(conveyorBeltPanelMain);
        conveyorBeltPanelMain.setLayout(conveyorBeltPanelMainLayout);
        conveyorBeltPanelMainLayout.setHorizontalGroup(
            conveyorBeltPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        conveyorBeltPanelMainLayout.setVerticalGroup(
            conveyorBeltPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        dragBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drag.png"))); // NOI18N
        dragBtn.setContentAreaFilled(false);
        dragBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        dragBtn.setFocusPainted(false);
        dragBtn.setFocusable(false);
        dragBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragBtnMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                dragBtnMouseMoved(evt);
            }
        });

        resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        resetBtn.setBorderPainted(false);
        resetBtn.setContentAreaFilled(false);
        resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetBtn.setFocusPainted(false);
        resetBtn.setFocusable(false);
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        stopPlayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pausestop.png"))); // NOI18N
        stopPlayBtn.setBorderPainted(false);
        stopPlayBtn.setContentAreaFilled(false);
        stopPlayBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stopPlayBtn.setFocusPainted(false);
        stopPlayBtn.setFocusable(false);
        stopPlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopPlayBtnActionPerformed(evt);
            }
        });

        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N
        infoBtn.setBorderPainted(false);
        infoBtn.setContentAreaFilled(false);
        infoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoBtn.setFocusPainted(false);
        infoBtn.setFocusable(false);
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assemblyPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hubPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(conveyorBeltPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(trashCanBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addComponent(dragBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stopPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(417, 417, 417)
                        .addComponent(infoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dragBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hubPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(assemblyPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trashCanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conveyorBeltPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void dragBtnMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBtnMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_dragBtnMouseDragged

    private void dragBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBtnMouseMoved
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragBtnMouseMoved

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "Seguro que deseas reiniciar el juego", "Bro what?", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            start.backgroundMusicClip.stop();

            java.awt.EventQueue.invokeLater(() -> {
                new StartGameView().setVisible(true);
            });
            this.dispose();
        }
    }//GEN-LAST:event_resetBtnActionPerformed

    private void stopPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopPlayBtnActionPerformed
        start.toggleMusicPlayback();
    }//GEN-LAST:event_stopPlayBtnActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        InfoDialog info = new InfoDialog(this, true);
        info.setVisible(true);
    }//GEN-LAST:event_infoBtnActionPerformed

    private void trashCanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trashCanBtnActionPerformed
        // Obtiene el índice del material actualmente seleccionado en la cinta
        int index = controller.getSelectedMaterial();

        // Si hay algún material seleccionado (índice válido)
        if (index != -1) {
            conveyorBeltPanel.discardSelectedMaterial();

            // Actualiza la información del HUD (dinero, meta, etc.)
            hubPanel.updateHUB();

            JOptionPane.showMessageDialog(
                    this,
                    "Material eliminado y penalizado",
                    "Eliminado",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }
    }//GEN-LAST:event_trashCanBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel assemblyPanelMain;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel conveyorBeltPanelMain;
    private javax.swing.JButton dragBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel hubPanelMain;
    private javax.swing.JButton infoBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton stopPlayBtn;
    private javax.swing.JButton trashCanBtn;
    // End of variables declaration//GEN-END:variables
}
