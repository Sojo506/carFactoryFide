package view;

import java.awt.BorderLayout;
import model.Player;
import view.panel.AssemblyPanel;
import view.panel.ConveyorBeltPanel;
import view.panel.HudPanel;

public class MainView extends javax.swing.JFrame {

    private Player player;
    private int xMouse;
    private int yMouse;

    public MainView() {
        player = new Player("Rick Sánchez");
        setUndecorated(true);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        //setSize(1000, 700);

        initPanels();

    }

    private void initPanels() {
        hudPanel.setLayout(new BorderLayout());
        hudPanel.add(new HudPanel(player), BorderLayout.CENTER);
        hudPanel.revalidate();
        hudPanel.repaint();

        assemblyPanel.setLayout(new BorderLayout());
        assemblyPanel.add(new AssemblyPanel(), BorderLayout.CENTER);
        assemblyPanel.revalidate();
        assemblyPanel.repaint();
        
        conveyorBeltPanel.setLayout(new BorderLayout());
        conveyorBeltPanel.add(new ConveyorBeltPanel(), BorderLayout.CENTER);
        conveyorBeltPanel.revalidate();
        conveyorBeltPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        hudPanel = new javax.swing.JPanel();
        assemblyPanel = new javax.swing.JPanel();
        trashCanBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        conveyorBeltPanel = new javax.swing.JPanel();
        dragBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPanel.setBackground(new java.awt.Color(47, 47, 47));

        hudPanel.setBackground(new java.awt.Color(28, 40, 51));

        javax.swing.GroupLayout hudPanelLayout = new javax.swing.GroupLayout(hudPanel);
        hudPanel.setLayout(hudPanelLayout);
        hudPanelLayout.setHorizontalGroup(
            hudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        hudPanelLayout.setVerticalGroup(
            hudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );

        assemblyPanel.setBackground(new java.awt.Color(59, 59, 59));

        javax.swing.GroupLayout assemblyPanelLayout = new javax.swing.GroupLayout(assemblyPanel);
        assemblyPanel.setLayout(assemblyPanelLayout);
        assemblyPanelLayout.setHorizontalGroup(
            assemblyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        assemblyPanelLayout.setVerticalGroup(
            assemblyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        trashCanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trashcan.png"))); // NOI18N
        trashCanBtn.setBorderPainted(false);
        trashCanBtn.setContentAreaFilled(false);
        trashCanBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trashCanBtn.setFocusPainted(false);
        trashCanBtn.setFocusable(false);
        trashCanBtn.setName(""); // NOI18N

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

        conveyorBeltPanel.setBackground(new java.awt.Color(59, 59, 59));

        javax.swing.GroupLayout conveyorBeltPanelLayout = new javax.swing.GroupLayout(conveyorBeltPanel);
        conveyorBeltPanel.setLayout(conveyorBeltPanelLayout);
        conveyorBeltPanelLayout.setHorizontalGroup(
            conveyorBeltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        conveyorBeltPanelLayout.setVerticalGroup(
            conveyorBeltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        dragBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drag.png"))); // NOI18N
        dragBtn.setContentAreaFilled(false);
        dragBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assemblyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hudPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(conveyorBeltPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(trashCanBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addComponent(dragBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hudPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(assemblyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trashCanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conveyorBeltPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_resetBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel assemblyPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel conveyorBeltPanel;
    private javax.swing.JButton dragBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel hudPanel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton trashCanBtn;
    // End of variables declaration//GEN-END:variables
}
