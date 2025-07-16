package view;

public class InfoDialog extends javax.swing.JDialog {

    public InfoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(parent);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        subTitle0 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        subTitle1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(43, 45, 66));

        jPanel1.setBackground(new java.awt.Color(43, 45, 66));

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Cómo jugar?");

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info32.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Adwaita Sans", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Tu objetivo es cumplir las órdenes de autos y alcanzar la meta de capital para avanzar de fábrica.");

        subTitle0.setFont(new java.awt.Font("Adwaita Sans", 1, 22)); // NOI18N
        subTitle0.setForeground(new java.awt.Color(255, 0, 255));
        subTitle0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/answer.png"))); // NOI18N
        subTitle0.setText("Controles");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("- Tienes 15 órdenes (¡no las elimines!).");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("- Solo puedes avanzar a la siguiente fábrica si alcanzas la meta y superas al rival.");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("- No puedes agregar materiales incorrectos a un auto.");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("- Haz clic en una orden para aceptarla.");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("- Selecciona materiales desde la cinta y agrégalos a la línea de ensamblaje.");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("- Si el material no te sirve, elimínalo con el basurero (¡pero esto penaliza tu capital!).");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("- Completa todas las partes de un auto para entregar la orden y ganar dinero.");

        subTitle1.setFont(new java.awt.Font("Adwaita Sans", 1, 22)); // NOI18N
        subTitle1.setForeground(new java.awt.Color(255, 0, 255));
        subTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/answer.png"))); // NOI18N
        subTitle1.setText("Tips");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("- Evita eliminar materiales repetidamente.");

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/approve.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subTitle0)
                .addGap(320, 320, 320))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(icon2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(subTitle1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(326, 326, 326)
                    .addComponent(jLabel1)
                    .addContainerGap(275, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(subTitle0)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(40, 40, 40)
                        .addComponent(subTitle1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addContainerGap(9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icon2)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(406, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel subTitle0;
    private javax.swing.JLabel subTitle1;
    // End of variables declaration//GEN-END:variables
}
