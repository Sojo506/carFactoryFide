package view;

import model.Player;

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

        contentPanel = new javax.swing.JPanel();
        hudPanel = new javax.swing.JPanel();
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
        assemblyPanel = new javax.swing.JPanel();
        assemblyLinePanel2 = new javax.swing.JPanel();
        assemblyTitle2 = new javax.swing.JLabel();
        assemblyBtn2 = new javax.swing.JButton();
        assemblySubTitle2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        assemblyList2 = new javax.swing.JList<>();
        assemblyLinePanel3 = new javax.swing.JPanel();
        assemblyTitle3 = new javax.swing.JLabel();
        assemblyBtn3 = new javax.swing.JButton();
        assemblySubTitle3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        assemblyList3 = new javax.swing.JList<>();
        assemblyLinePanel1 = new javax.swing.JPanel();
        assemblyBtn1 = new javax.swing.JButton();
        assemblyTitle1 = new javax.swing.JLabel();
        assemblySubTitle1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        assemblyList1 = new javax.swing.JList<>();
        trashCanBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        conveyorBeltPanel = new javax.swing.JPanel();
        materialLabel1 = new javax.swing.JButton();
        materialLabel2 = new javax.swing.JButton();
        materialLabel3 = new javax.swing.JButton();
        materialLabel4 = new javax.swing.JButton();
        materialLabel5 = new javax.swing.JButton();
        dragBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPanel.setBackground(new java.awt.Color(47, 47, 47));

        hudPanel.setBackground(new java.awt.Color(28, 40, 51));
        hudPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        javax.swing.GroupLayout hudPanelLayout = new javax.swing.GroupLayout(hudPanel);
        hudPanel.setLayout(hudPanelLayout);
        hudPanelLayout.setHorizontalGroup(
            hudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(moneyLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(positionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(factoryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(goalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        hudPanelLayout.setVerticalGroup(
            hudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(hudPanelLayout.createSequentialGroup()
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

        assemblyPanel.setBackground(new java.awt.Color(59, 59, 59));
        assemblyPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        assemblySubTitle2.setFont(new java.awt.Font("Adwaita Sans", 1, 15)); // NOI18N
        assemblySubTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblySubTitle2.setText("Partes");

        assemblyList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Motor", "Carrocería", "Llantas" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(assemblyList2);

        javax.swing.GroupLayout assemblyLinePanel2Layout = new javax.swing.GroupLayout(assemblyLinePanel2);
        assemblyLinePanel2.setLayout(assemblyLinePanel2Layout);
        assemblyLinePanel2Layout.setHorizontalGroup(
            assemblyLinePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel2Layout.createSequentialGroup()
                .addGroup(assemblyLinePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(assemblySubTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(assemblyLinePanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(assemblyTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        assemblyLinePanel2Layout.setVerticalGroup(
            assemblyLinePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assemblyTitle2)
                .addGap(30, 30, 30)
                .addComponent(assemblyBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(assemblySubTitle2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        assemblyLinePanel3.setBackground(new java.awt.Color(90, 90, 90));

        assemblyTitle3.setFont(new java.awt.Font("Adwaita Sans", 1, 16)); // NOI18N
        assemblyTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblyTitle3.setText("SEDAN");

        assemblyBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addpart.png"))); // NOI18N
        assemblyBtn3.setBorderPainted(false);
        assemblyBtn3.setContentAreaFilled(false);
        assemblyBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        assemblyBtn3.setFocusPainted(false);
        assemblyBtn3.setFocusable(false);

        assemblySubTitle3.setFont(new java.awt.Font("Adwaita Sans", 1, 15)); // NOI18N
        assemblySubTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblySubTitle3.setText("Partes");

        assemblyList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Motor", "Carrocería", "Llantas" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(assemblyList3);

        javax.swing.GroupLayout assemblyLinePanel3Layout = new javax.swing.GroupLayout(assemblyLinePanel3);
        assemblyLinePanel3.setLayout(assemblyLinePanel3Layout);
        assemblyLinePanel3Layout.setHorizontalGroup(
            assemblyLinePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel3Layout.createSequentialGroup()
                .addGroup(assemblyLinePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(assemblySubTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(assemblyLinePanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(assemblyTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        assemblyLinePanel3Layout.setVerticalGroup(
            assemblyLinePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assemblyTitle3)
                .addGap(30, 30, 30)
                .addComponent(assemblyBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(assemblySubTitle3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        assemblyLinePanel1.setBackground(new java.awt.Color(90, 90, 90));

        assemblyBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addpart.png"))); // NOI18N
        assemblyBtn1.setBorderPainted(false);
        assemblyBtn1.setContentAreaFilled(false);
        assemblyBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        assemblyBtn1.setFocusPainted(false);
        assemblyBtn1.setFocusable(false);

        assemblyTitle1.setFont(new java.awt.Font("Adwaita Sans", 1, 16)); // NOI18N
        assemblyTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblyTitle1.setText("SEDAN");

        assemblySubTitle1.setFont(new java.awt.Font("Adwaita Sans", 1, 15)); // NOI18N
        assemblySubTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblySubTitle1.setText("Partes");

        assemblyList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Motor", "Carrocería", "Llantas" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(assemblyList1);

        javax.swing.GroupLayout assemblyLinePanel1Layout = new javax.swing.GroupLayout(assemblyLinePanel1);
        assemblyLinePanel1.setLayout(assemblyLinePanel1Layout);
        assemblyLinePanel1Layout.setHorizontalGroup(
            assemblyLinePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel1Layout.createSequentialGroup()
                .addGroup(assemblyLinePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(assemblySubTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(assemblyLinePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(assemblyTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        assemblyLinePanel1Layout.setVerticalGroup(
            assemblyLinePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyLinePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assemblyTitle1)
                .addGap(30, 30, 30)
                .addComponent(assemblyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(assemblySubTitle1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout assemblyPanelLayout = new javax.swing.GroupLayout(assemblyPanel);
        assemblyPanel.setLayout(assemblyPanelLayout);
        assemblyPanelLayout.setHorizontalGroup(
            assemblyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assemblyPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(assemblyLinePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(assemblyLinePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(assemblyLinePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        assemblyPanelLayout.setVerticalGroup(
            assemblyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(assemblyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(assemblyLinePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assemblyLinePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assemblyLinePanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        conveyorBeltPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        materialLabel1.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel1.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel1.setText("Carrocería especial");
        materialLabel1.setBorderPainted(false);
        materialLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel1.setFocusPainted(false);
        materialLabel1.setFocusable(false);

        materialLabel2.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel2.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel2.setText("Llantas de trabajo");
        materialLabel2.setBorderPainted(false);
        materialLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel2.setFocusPainted(false);
        materialLabel2.setFocusable(false);

        materialLabel3.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel3.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel3.setText("Carrocería");
        materialLabel3.setBorderPainted(false);
        materialLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel3.setFocusPainted(false);
        materialLabel3.setFocusable(false);

        materialLabel4.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel4.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel4.setText("Llantas de trabajo");
        materialLabel4.setBorderPainted(false);
        materialLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel4.setFocusPainted(false);
        materialLabel4.setFocusable(false);

        materialLabel5.setBackground(new java.awt.Color(47, 47, 47));
        materialLabel5.setForeground(new java.awt.Color(255, 255, 255));
        materialLabel5.setText("Motor deportivo");
        materialLabel5.setBorderPainted(false);
        materialLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialLabel5.setFocusPainted(false);
        materialLabel5.setFocusable(false);

        javax.swing.GroupLayout conveyorBeltPanelLayout = new javax.swing.GroupLayout(conveyorBeltPanel);
        conveyorBeltPanel.setLayout(conveyorBeltPanelLayout);
        conveyorBeltPanelLayout.setHorizontalGroup(
            conveyorBeltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conveyorBeltPanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(materialLabel2)
                .addGap(176, 176, 176)
                .addComponent(materialLabel1)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(conveyorBeltPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(materialLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(materialLabel5)
                .addGap(138, 138, 138)
                .addComponent(materialLabel4)
                .addGap(41, 41, 41))
        );
        conveyorBeltPanelLayout.setVerticalGroup(
            conveyorBeltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conveyorBeltPanelLayout.createSequentialGroup()
                .addGroup(conveyorBeltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conveyorBeltPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(materialLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(conveyorBeltPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(materialLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(materialLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(conveyorBeltPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(materialLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(hudPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(trashCanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conveyorBeltPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JButton acceptBtn1;
    private javax.swing.JButton acceptBtn2;
    private javax.swing.JButton acceptBtn3;
    private javax.swing.JButton acceptBtn4;
    private javax.swing.JButton acceptBtn5;
    private javax.swing.JButton assemblyBtn1;
    private javax.swing.JButton assemblyBtn2;
    private javax.swing.JButton assemblyBtn3;
    private javax.swing.JPanel assemblyLinePanel1;
    private javax.swing.JPanel assemblyLinePanel2;
    private javax.swing.JPanel assemblyLinePanel3;
    private javax.swing.JList<String> assemblyList1;
    private javax.swing.JList<String> assemblyList2;
    private javax.swing.JList<String> assemblyList3;
    private javax.swing.JPanel assemblyPanel;
    private javax.swing.JLabel assemblySubTitle1;
    private javax.swing.JLabel assemblySubTitle2;
    private javax.swing.JLabel assemblySubTitle3;
    private javax.swing.JLabel assemblyTitle1;
    private javax.swing.JLabel assemblyTitle2;
    private javax.swing.JLabel assemblyTitle3;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel conveyorBeltPanel;
    private javax.swing.JButton dragBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel factoryLabel;
    private javax.swing.JLabel goalLabel;
    private javax.swing.JPanel hudPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton materialLabel1;
    private javax.swing.JButton materialLabel2;
    private javax.swing.JButton materialLabel3;
    private javax.swing.JButton materialLabel4;
    private javax.swing.JButton materialLabel5;
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
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton trashCanBtn;
    // End of variables declaration//GEN-END:variables
}
