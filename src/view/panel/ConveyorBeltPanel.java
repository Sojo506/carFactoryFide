package view.panel;

public class ConveyorBeltPanel extends javax.swing.JPanel {

    public ConveyorBeltPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialLabel3 = new javax.swing.JButton();
        materialLabel2 = new javax.swing.JButton();
        materialLabel5 = new javax.swing.JButton();
        materialLabel1 = new javax.swing.JButton();
        materialLabel4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(59, 59, 59));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        materialLabel3.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel3.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel3.setText("Carrocería");
        materialLabel3.setBorderPainted(false);
        materialLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel3.setFocusPainted(false);
        materialLabel3.setFocusable(false);

        materialLabel2.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel2.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel2.setText("Llantas de trabajo");
        materialLabel2.setBorderPainted(false);
        materialLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel2.setFocusPainted(false);
        materialLabel2.setFocusable(false);

        materialLabel5.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel5.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel5.setText("Motor deportivo");
        materialLabel5.setBorderPainted(false);
        materialLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel5.setFocusPainted(false);
        materialLabel5.setFocusable(false);

        materialLabel1.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel1.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel1.setText("Carrocería especial");
        materialLabel1.setBorderPainted(false);
        materialLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel1.setFocusPainted(false);
        materialLabel1.setFocusable(false);

        materialLabel4.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel4.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel4.setText("Llantas de trabajo");
        materialLabel4.setBorderPainted(false);
        materialLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel4.setFocusPainted(false);
        materialLabel4.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(materialLabel2)
                .addGap(176, 176, 176)
                .addComponent(materialLabel1)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(materialLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(materialLabel5)
                .addGap(138, 138, 138)
                .addComponent(materialLabel4)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(materialLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(materialLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(materialLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(materialLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton materialLabel1;
    private javax.swing.JButton materialLabel2;
    private javax.swing.JButton materialLabel3;
    private javax.swing.JButton materialLabel4;
    private javax.swing.JButton materialLabel5;
    // End of variables declaration//GEN-END:variables
}
