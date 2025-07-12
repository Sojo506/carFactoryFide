package view.panel;

public class AssemblyPanel extends javax.swing.JPanel {

    public AssemblyPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setBackground(new java.awt.Color(59, 59, 59));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        assemblyList2.setBackground(new java.awt.Color(85, 85, 85));
        assemblyList2.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(assemblyLinePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(assemblyLinePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(assemblySubTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(assemblyLinePanel2Layout.createSequentialGroup()
                        .addComponent(assemblyTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
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

        assemblyList3.setBackground(new java.awt.Color(85, 85, 85));
        assemblyList3.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(assemblyLinePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(assemblyLinePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(assemblySubTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(assemblyLinePanel3Layout.createSequentialGroup()
                        .addComponent(assemblyTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
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

        assemblyList1.setBackground(new java.awt.Color(85, 85, 85));
        assemblyList1.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(assemblyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(assemblyLinePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(assemblyLinePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, assemblyLinePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(assemblySubTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(assemblyLinePanel1Layout.createSequentialGroup()
                        .addComponent(assemblyTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assemblyLinePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(assemblyLinePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(assemblyLinePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(assemblyLinePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assemblyLinePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assemblyLinePanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assemblyBtn1;
    private javax.swing.JButton assemblyBtn2;
    private javax.swing.JButton assemblyBtn3;
    private javax.swing.JPanel assemblyLinePanel1;
    private javax.swing.JPanel assemblyLinePanel2;
    private javax.swing.JPanel assemblyLinePanel3;
    private javax.swing.JList<String> assemblyList1;
    private javax.swing.JList<String> assemblyList2;
    private javax.swing.JList<String> assemblyList3;
    private javax.swing.JLabel assemblySubTitle1;
    private javax.swing.JLabel assemblySubTitle2;
    private javax.swing.JLabel assemblySubTitle3;
    private javax.swing.JLabel assemblyTitle1;
    private javax.swing.JLabel assemblyTitle2;
    private javax.swing.JLabel assemblyTitle3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
