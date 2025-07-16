package view;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JOptionPane;
import model.Player;

public class StartGameView extends javax.swing.JFrame {

    public Clip backgroundMusicClip; // Variable para controlar la reproducción

    // Variable para guardar la posición de la canción cuando se pausa
    private long clipTimePosition = 0;

    public StartGameView() {
        initComponents();
        playBackgroundMusic("../music/gamecarmusic.Wav");

        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void playBackgroundMusic(String filePath) {
        try {
            // Opción 1: Si el archivo está en el sistema de archivos (útil para pruebas)
            File musicFile = new File(filePath);
            if (musicFile.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
                backgroundMusicClip = AudioSystem.getClip();
                backgroundMusicClip.open(audioInput);
                backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY); // Para que se repita infinitamente
            } else {
                // Usamos getResource para que Java busque el archivo dentro del paquete compilado
                URL audioURL = getClass().getResource(filePath);

                if (audioURL != null) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioURL);
                    backgroundMusicClip = AudioSystem.getClip();
                    backgroundMusicClip.open(audioInput);
                    backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY); // Para que se repita infinitamente
                } else {
                    JOptionPane.showMessageDialog(this, "Pathfile not found", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toggleMusicPlayback() {
        if (backgroundMusicClip == null) {
            // Si la música no se ha cargado, intenta reproducirla
            playBackgroundMusic("../music/gamecarmusic.Wav");
            return;
        }

        if (backgroundMusicClip.isRunning()) {
            // Si la música está sonando, la pausamos y guardamos la posición
            clipTimePosition = backgroundMusicClip.getMicrosecondPosition();
            backgroundMusicClip.stop();
        } else {
            // Si la música está pausada o detenida, la reanudamos
            backgroundMusicClip.setMicrosecondPosition(clipTimePosition); // Vuelve a la posición guardada
            backgroundMusicClip.start();
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY); // Asegura que siga en bucle
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        subTitle = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(43, 45, 66));

        icon.setFont(new java.awt.Font("Adwaita Sans", 1, 18)); // NOI18N
        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car.png"))); // NOI18N

        title.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 255, 255));
        title.setText("Car Factory");

        nameTextField.setBackground(new java.awt.Color(255, 255, 255));
        nameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        subTitle.setFont(new java.awt.Font("Adwaita Sans", 0, 18)); // NOI18N
        subTitle.setForeground(new java.awt.Color(255, 0, 255));
        subTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitle.setText("Start your journey by entering your name!");

        startBtn.setBackground(new java.awt.Color(255, 215, 0));
        startBtn.setFont(new java.awt.Font("Adwaita Sans", 1, 15)); // NOI18N
        startBtn.setForeground(new java.awt.Color(0, 0, 0));
        startBtn.setText("START");
        startBtn.setBorderPainted(false);
        startBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startBtn.setFocusPainted(false);
        startBtn.setFocusable(false);
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(title)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(title)
                .addGap(36, 36, 36)
                .addComponent(subTitle)
                .addGap(18, 18, 18)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        var name = nameTextField.getText().trim();

        if (name.length() <= 0) {
            JOptionPane.showMessageDialog(this, "Your name cannot be empty!", "bro...?", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (name.length() > 8) {
            JOptionPane.showMessageDialog(this, "Your name cannot have more than 8 characters!", "bro...?", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Have fun " + name + "!", "bro...!", JOptionPane.PLAIN_MESSAGE);
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> new MainView(this, new Player(name, 1)).setVisible(true));
    }//GEN-LAST:event_startBtnActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        startBtn.doClick();
    }//GEN-LAST:event_nameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
