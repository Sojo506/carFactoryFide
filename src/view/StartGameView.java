package view;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JOptionPane;
import model.Player;

public class StartGameView extends javax.swing.JFrame {

    private Clip backgroundMusicClip; // Variable para controlar la reproducción

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
                // Opción 2: Si el archivo está dentro del JAR (recomendado para distribución)
                // Usamos getResource para que Java busque el archivo dentro del paquete compilado
                URL audioURL = getClass().getResource(filePath);
                if (audioURL != null) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioURL);
                    backgroundMusicClip = AudioSystem.getClip();
                    backgroundMusicClip.open(audioInput);
                    backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY); // Para que se repita infinitamente
                } else {
                    System.err.println("Error: Archivo de música no encontrado en el classpath: " + filePath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime cualquier error que ocurra
            System.err.println("Error al reproducir la música: " + e.getMessage());
        }
    }

    public void toggleMusicPlayback() {
        if (backgroundMusicClip == null) {
            // Si la música no se ha cargado aún, intenta reproducirla
            playBackgroundMusic("/resources/nombre_de_tu_archivo.wav"); // Asegúrate de usar la ruta correcta
            return;
        }

        if (backgroundMusicClip.isRunning()) {
            // Si la música está sonando, la pausamos y guardamos la posición
            clipTimePosition = backgroundMusicClip.getMicrosecondPosition();
            backgroundMusicClip.stop();
            System.out.println("Música pausada.");
        } else {
            // Si la música está pausada o detenida, la reanudamos
            backgroundMusicClip.setMicrosecondPosition(clipTimePosition); // Vuelve a la posición guardada
            backgroundMusicClip.start(); // Inicia la reproducción
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY); // Asegura que siga en bucle
            System.out.println("Música reanudada.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(43, 45, 66));

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Car Factory");

        nameLabel.setBackground(new java.awt.Color(255, 255, 255));
        nameLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Adwaita Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Start your journey by entering your name!");

        jButton1.setBackground(new java.awt.Color(255, 215, 0));
        jButton1.setFont(new java.awt.Font("Adwaita Sans", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("START");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        var name = nameLabel.getText().trim();

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
        java.awt.EventQueue.invokeLater(() -> new MainView(new Player(name)).setVisible(true));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameLabel;
    // End of variables declaration//GEN-END:variables
}
