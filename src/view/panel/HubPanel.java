package view.panel;

import model.Player;

public class HubPanel extends javax.swing.JPanel {

    Player player;

    public HubPanel(Player player) {
        this.player = player;
        initComponents();
        
        updateHUD();
    }

    public void updateHUD() {
        positionLabel.setText("Puesto: " + player.getPosition());
        factoryLabel.setText("Fábrica: " + player.getCurrentFactory());
        moneyLabel.setText("Capital: $" + player.getMoney());
        goalLabel.setText("Meta: $" + player.getFactory().getProfitGoal());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        factoryLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        goalLabel = new javax.swing.JLabel();
        orderPanel3 = new javax.swing.JPanel();
        rejectBtn3 = new javax.swing.JButton();
        acceptBtn3 = new javax.swing.JButton();
        orderTitle3 = new javax.swing.JLabel();
        orderProgress3 = new javax.swing.JLabel();
        orderPanel4 = new javax.swing.JPanel();
        rejectBtn4 = new javax.swing.JButton();
        acceptBtn4 = new javax.swing.JButton();
        orderTitle4 = new javax.swing.JLabel();
        orderProgress4 = new javax.swing.JLabel();
        orderPanel5 = new javax.swing.JPanel();
        rejectBtn5 = new javax.swing.JButton();
        acceptBtn5 = new javax.swing.JButton();
        orderTitle5 = new javax.swing.JLabel();
        orderProgress5 = new javax.swing.JLabel();
        orderPanel2 = new javax.swing.JPanel();
        rejectBtn2 = new javax.swing.JButton();
        acceptBtn2 = new javax.swing.JButton();
        orderTitle2 = new javax.swing.JLabel();
        orderProgress2 = new javax.swing.JLabel();
        orderPanel1 = new javax.swing.JPanel();
        rejectBtn1 = new javax.swing.JButton();
        acceptBtn1 = new javax.swing.JButton();
        orderTitle1 = new javax.swing.JLabel();
        orderProgress1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(28, 40, 51));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        factoryLabel.setForeground(new java.awt.Color(255, 255, 255));

        positionLabel.setForeground(new java.awt.Color(255, 255, 255));

        moneyLabel.setForeground(new java.awt.Color(255, 255, 255));

        goalLabel.setForeground(new java.awt.Color(255, 255, 255));
        goalLabel.setText(" ");

        orderPanel3.setBackground(new java.awt.Color(224, 224, 224));

        rejectBtn3.setBackground(new java.awt.Color(235, 87, 87));
        rejectBtn3.setForeground(new java.awt.Color(0, 0, 0));
        rejectBtn3.setText("Rechazar");
        rejectBtn3.setBorderPainted(false);
        rejectBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rejectBtn3.setFocusPainted(false);
        rejectBtn3.setFocusable(false);

        acceptBtn3.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn3.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn3.setText("Aceptar");
        acceptBtn3.setBorderPainted(false);
        acceptBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn3.setFocusPainted(false);
        acceptBtn3.setFocusable(false);

        orderTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderTitle3.setText("Sedan de lujo");
        orderTitle3.setFocusable(false);
        orderTitle3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        orderProgress3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderProgress3.setText("En progreso");
        orderProgress3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout orderPanel3Layout = new javax.swing.GroupLayout(orderPanel3);
        orderPanel3.setLayout(orderPanel3Layout);
        orderPanel3Layout.setHorizontalGroup(
            orderPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rejectBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(orderTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderProgress3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        orderPanel3Layout.setVerticalGroup(
            orderPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rejectBtn3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn3)
                .addContainerGap())
        );

        orderPanel4.setBackground(new java.awt.Color(224, 224, 224));

        rejectBtn4.setBackground(new java.awt.Color(235, 87, 87));
        rejectBtn4.setForeground(new java.awt.Color(0, 0, 0));
        rejectBtn4.setText("Rechazar");
        rejectBtn4.setBorderPainted(false);
        rejectBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rejectBtn4.setFocusPainted(false);
        rejectBtn4.setFocusable(false);

        acceptBtn4.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn4.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn4.setText("Aceptar");
        acceptBtn4.setBorderPainted(false);
        acceptBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn4.setFocusPainted(false);
        acceptBtn4.setFocusable(false);

        orderTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderTitle4.setText("Sedan de lujo");
        orderTitle4.setFocusable(false);
        orderTitle4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        orderProgress4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderProgress4.setText("En progreso");
        orderProgress4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout orderPanel4Layout = new javax.swing.GroupLayout(orderPanel4);
        orderPanel4.setLayout(orderPanel4Layout);
        orderPanel4Layout.setHorizontalGroup(
            orderPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptBtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rejectBtn4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(orderTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderProgress4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        orderPanel4Layout.setVerticalGroup(
            orderPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rejectBtn4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn4)
                .addContainerGap())
        );

        orderPanel5.setBackground(new java.awt.Color(224, 224, 224));

        rejectBtn5.setBackground(new java.awt.Color(235, 87, 87));
        rejectBtn5.setForeground(new java.awt.Color(0, 0, 0));
        rejectBtn5.setText("Rechazar");
        rejectBtn5.setBorderPainted(false);
        rejectBtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rejectBtn5.setFocusPainted(false);
        rejectBtn5.setFocusable(false);

        acceptBtn5.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn5.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn5.setText("Aceptar");
        acceptBtn5.setBorderPainted(false);
        acceptBtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn5.setFocusPainted(false);
        acceptBtn5.setFocusable(false);

        orderTitle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderTitle5.setText("Sedan de lujo");
        orderTitle5.setFocusable(false);
        orderTitle5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        orderProgress5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderProgress5.setText("En progreso");
        orderProgress5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout orderPanel5Layout = new javax.swing.GroupLayout(orderPanel5);
        orderPanel5.setLayout(orderPanel5Layout);
        orderPanel5Layout.setHorizontalGroup(
            orderPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptBtn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rejectBtn5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(orderTitle5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderProgress5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        orderPanel5Layout.setVerticalGroup(
            orderPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rejectBtn5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn5)
                .addContainerGap())
        );

        orderPanel2.setBackground(new java.awt.Color(224, 224, 224));

        rejectBtn2.setBackground(new java.awt.Color(235, 87, 87));
        rejectBtn2.setForeground(new java.awt.Color(0, 0, 0));
        rejectBtn2.setText("Rechazar");
        rejectBtn2.setBorderPainted(false);
        rejectBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rejectBtn2.setFocusPainted(false);
        rejectBtn2.setFocusable(false);

        acceptBtn2.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn2.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn2.setText("Aceptar");
        acceptBtn2.setBorderPainted(false);
        acceptBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn2.setFocusPainted(false);
        acceptBtn2.setFocusable(false);

        orderTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderTitle2.setText("Sedan de lujo");
        orderTitle2.setFocusable(false);
        orderTitle2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        orderProgress2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderProgress2.setText("En progreso");
        orderProgress2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout orderPanel2Layout = new javax.swing.GroupLayout(orderPanel2);
        orderPanel2.setLayout(orderPanel2Layout);
        orderPanel2Layout.setHorizontalGroup(
            orderPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rejectBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(orderTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderProgress2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        orderPanel2Layout.setVerticalGroup(
            orderPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rejectBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn2)
                .addContainerGap())
        );

        orderPanel1.setBackground(new java.awt.Color(224, 224, 224));

        rejectBtn1.setBackground(new java.awt.Color(235, 87, 87));
        rejectBtn1.setForeground(new java.awt.Color(0, 0, 0));
        rejectBtn1.setText("Rechazar");
        rejectBtn1.setBorderPainted(false);
        rejectBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rejectBtn1.setFocusPainted(false);
        rejectBtn1.setFocusable(false);

        acceptBtn1.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn1.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn1.setText("Aceptar");
        acceptBtn1.setBorderPainted(false);
        acceptBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn1.setFocusPainted(false);
        acceptBtn1.setFocusable(false);

        orderTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderTitle1.setText("Sedan de lujo");
        orderTitle1.setFocusable(false);
        orderTitle1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        orderProgress1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderProgress1.setText("En progreso");
        orderProgress1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout orderPanel1Layout = new javax.swing.GroupLayout(orderPanel1);
        orderPanel1.setLayout(orderPanel1Layout);
        orderPanel1Layout.setHorizontalGroup(
            orderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rejectBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(orderTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderProgress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        orderPanel1Layout.setVerticalGroup(
            orderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rejectBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(moneyLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(positionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(factoryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(goalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(orderPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(orderPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(factoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(goalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(orderPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn1;
    private javax.swing.JButton acceptBtn2;
    private javax.swing.JButton acceptBtn3;
    private javax.swing.JButton acceptBtn4;
    private javax.swing.JButton acceptBtn5;
    private javax.swing.JLabel factoryLabel;
    private javax.swing.JLabel goalLabel;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JPanel orderPanel1;
    private javax.swing.JPanel orderPanel2;
    private javax.swing.JPanel orderPanel3;
    private javax.swing.JPanel orderPanel4;
    private javax.swing.JPanel orderPanel5;
    private javax.swing.JLabel orderProgress1;
    private javax.swing.JLabel orderProgress2;
    private javax.swing.JLabel orderProgress3;
    private javax.swing.JLabel orderProgress4;
    private javax.swing.JLabel orderProgress5;
    private javax.swing.JLabel orderTitle1;
    private javax.swing.JLabel orderTitle2;
    private javax.swing.JLabel orderTitle3;
    private javax.swing.JLabel orderTitle4;
    private javax.swing.JLabel orderTitle5;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JButton rejectBtn1;
    private javax.swing.JButton rejectBtn2;
    private javax.swing.JButton rejectBtn3;
    private javax.swing.JButton rejectBtn4;
    private javax.swing.JButton rejectBtn5;
    // End of variables declaration//GEN-END:variables
}
