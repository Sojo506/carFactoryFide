package view.panel;

import controller.GameController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.AssemblyLine;
import model.Order;
import model.Player;
import model.enums.OrderStatus;
import model.structure.linkedlist.LinkedList;

public class HubPanel extends javax.swing.JPanel {

    private Player player;
    private GameController controller;
    private AssemblyPanel assemblyPanel;
    private ConveyorBeltPanel conveyorBeltPanel;

    // Constructor: inicializa todo el HUB, refresca info inicial y bloquea avanzar de fábrica
    public HubPanel(Player player, GameController controller, AssemblyPanel assemblyPanel, ConveyorBeltPanel conveyorBeltPanel) {
        this.player = player;
        this.controller = controller;
        this.assemblyPanel = assemblyPanel;
        this.conveyorBeltPanel = conveyorBeltPanel;
        initComponents();
        updateHUB();
        updateOrdersDisplay();
        nextfactoryBtn.setEnabled(false);
    }

    // Actualiza la información visible del HUB (posición, fábrica, dinero, meta, etc)
    public void updateHUB() {
        positionLabel.setText("Puesto: " + player.getPosition());
        factoryLabel.setText("Fábrica: " + player.getCurrentFactory());
        moneyLabel.setText("Capital: $" + player.getCapital());
        goalLabel.setText("Meta: $" + player.getFactory().getProfitGoal());

        if (player.getCapital() >= player.getFactory().getProfitGoal()) {
            nextfactoryBtn.setEnabled(true);
            nextfactoryBtn.setBackground(new Color(111, 207, 151)); // verde
        } else {
            nextfactoryBtn.setEnabled(false);
            nextfactoryBtn.setBackground(new Color(180, 180, 180)); // gris
        }
    }

    // Intenta aceptar la orden en el slot indicado del Hub
    private void onAcceptOrder(int index) {
        boolean accepted = controller.acceptOrder(index);

        if (!accepted) {
            // Si no hay líneas disponibles, muestra advertencia
            JOptionPane.showMessageDialog(this,
                    "No hay líneas de ensamblaje disponibles.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            // Actualiza visual de las líneas de ensamblaje
            assemblyPanel.updateAllTitles();
            assemblyPanel.updateAssemblyLineBackgrounds();
        }
        // Refresca lista de órdenes del Hub
        updateOrdersDisplay();
    }

    // Lógica para rechazar (o cancelar) una orden del Hub
    private void onRejectOrder(int idx) {
        int lineIndex = -1;

        // Verifica si la orden ya está en alguna línea de ensamblaje
        for (int i = 0; i < controller.getAssemblyLines().size(); i++) {
            AssemblyLine line = controller.getAssemblyLines().getElement(i);
            if (line.isOccupied() && line.getOriginSlot() == idx) {
                lineIndex = i;
                break;
            }
        }
        if (lineIndex != -1) {
            // Si está en ensamblaje, cancelar y refrescar todo
            controller.cancelAssemblyOrder(lineIndex, idx);
            updateOrdersDisplay();
            assemblyPanel.updateAssemblyLineBackgrounds();
            assemblyPanel.updateAllTitles();
            assemblyPanel.clearList(idx);
        } else {
            // Si solo está pendiente (no aceptada), reemplazar por otra
            controller.rejectOrder(idx);
            updateOrdersDisplay();
        }
    }

    // Refresca visualmente todos los slots de órdenes del Hub (máximo 5)
    public void updateOrdersDisplay() {
        LinkedList<Order> orders = controller.getVisibleOrders();

        // Refresca cada panel de orden individualmente (slots 0-4)
        refreshOrderPanel(orderTitle0, orderProgress0, acceptBtn0, rejectBtn0, orders, 0);
        refreshOrderPanel(orderTitle1, orderProgress1, acceptBtn1, rejectBtn1, orders, 1);
        refreshOrderPanel(orderTitle2, orderProgress2, acceptBtn2, rejectBtn2, orders, 2);
        refreshOrderPanel(orderTitle3, orderProgress3, acceptBtn3, rejectBtn3, orders, 3);
        refreshOrderPanel(orderTitle4, orderProgress4, acceptBtn4, rejectBtn4, orders, 4);
    }

    // Refresca la visualización de un slot de orden individual del Hub
    private void refreshOrderPanel(JLabel title, JLabel progress,
            JButton accept, JButton reject,
            LinkedList<Order> orders, int idx) {
        Order order = orders.getElement(idx);

        if (order == null) {
            // Si no hay orden en este slot
            title.setText("Sin órdenes");
            progress.setText("");
            accept.setEnabled(false);
            reject.setEnabled(false);
        } else {
            // Muestra el nombre del carro y el estado de la orden
            title.setText(order.getCar().getType().getCarName());
            progress.setText(order.getStatus().toString());

            accept.setEnabled(order.getStatus() == OrderStatus.NOT_ACCEPTED);
            reject.setEnabled(order.getStatus() != OrderStatus.COMPLETED);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        factoryLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        goalLabel = new javax.swing.JLabel();
        orderPanel2 = new javax.swing.JPanel();
        rejectBtn2 = new javax.swing.JButton();
        acceptBtn2 = new javax.swing.JButton();
        orderTitle2 = new javax.swing.JLabel();
        orderProgress2 = new javax.swing.JLabel();
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
        orderPanel1 = new javax.swing.JPanel();
        rejectBtn1 = new javax.swing.JButton();
        acceptBtn1 = new javax.swing.JButton();
        orderTitle1 = new javax.swing.JLabel();
        orderProgress1 = new javax.swing.JLabel();
        orderPanel0 = new javax.swing.JPanel();
        rejectBtn0 = new javax.swing.JButton();
        acceptBtn0 = new javax.swing.JButton();
        orderTitle0 = new javax.swing.JLabel();
        orderProgress0 = new javax.swing.JLabel();
        nextfactoryBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(28, 40, 51));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        factoryLabel.setForeground(new java.awt.Color(255, 255, 255));

        positionLabel.setForeground(new java.awt.Color(255, 255, 255));

        moneyLabel.setForeground(new java.awt.Color(255, 255, 255));

        goalLabel.setForeground(new java.awt.Color(255, 255, 255));
        goalLabel.setText(" ");

        orderPanel2.setBackground(new java.awt.Color(224, 224, 224));

        rejectBtn2.setBackground(new java.awt.Color(235, 87, 87));
        rejectBtn2.setForeground(new java.awt.Color(0, 0, 0));
        rejectBtn2.setText("Rechazar");
        rejectBtn2.setBorderPainted(false);
        rejectBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rejectBtn2.setFocusPainted(false);
        rejectBtn2.setFocusable(false);
        rejectBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtn2ActionPerformed(evt);
            }
        });

        acceptBtn2.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn2.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn2.setText("Aceptar");
        acceptBtn2.setBorderPainted(false);
        acceptBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn2.setFocusPainted(false);
        acceptBtn2.setFocusable(false);
        acceptBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtn2ActionPerformed(evt);
            }
        });

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
                    .addComponent(rejectBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderProgress2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        orderPanel2Layout.setVerticalGroup(
            orderPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(rejectBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn2)
                .addContainerGap())
        );

        orderPanel3.setBackground(new java.awt.Color(224, 224, 224));

        rejectBtn3.setBackground(new java.awt.Color(235, 87, 87));
        rejectBtn3.setForeground(new java.awt.Color(0, 0, 0));
        rejectBtn3.setText("Rechazar");
        rejectBtn3.setBorderPainted(false);
        rejectBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rejectBtn3.setFocusPainted(false);
        rejectBtn3.setFocusable(false);
        rejectBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtn3ActionPerformed(evt);
            }
        });

        acceptBtn3.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn3.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn3.setText("Aceptar");
        acceptBtn3.setBorderPainted(false);
        acceptBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn3.setFocusPainted(false);
        acceptBtn3.setFocusable(false);
        acceptBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtn3ActionPerformed(evt);
            }
        });

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
                    .addComponent(rejectBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderProgress3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        orderPanel3Layout.setVerticalGroup(
            orderPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
        rejectBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtn4ActionPerformed(evt);
            }
        });

        acceptBtn4.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn4.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn4.setText("Aceptar");
        acceptBtn4.setBorderPainted(false);
        acceptBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn4.setFocusPainted(false);
        acceptBtn4.setFocusable(false);
        acceptBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtn4ActionPerformed(evt);
            }
        });

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
                    .addComponent(rejectBtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderProgress4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        orderPanel4Layout.setVerticalGroup(
            orderPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(rejectBtn4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn4)
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
        rejectBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtn1ActionPerformed(evt);
            }
        });

        acceptBtn1.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn1.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn1.setText("Aceptar");
        acceptBtn1.setBorderPainted(false);
        acceptBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn1.setFocusPainted(false);
        acceptBtn1.setFocusable(false);
        acceptBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtn1ActionPerformed(evt);
            }
        });

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
                    .addComponent(rejectBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderProgress1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        orderPanel1Layout.setVerticalGroup(
            orderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(rejectBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn1)
                .addContainerGap())
        );

        orderPanel0.setBackground(new java.awt.Color(224, 224, 224));

        rejectBtn0.setBackground(new java.awt.Color(235, 87, 87));
        rejectBtn0.setForeground(new java.awt.Color(0, 0, 0));
        rejectBtn0.setText("Rechazar");
        rejectBtn0.setBorderPainted(false);
        rejectBtn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rejectBtn0.setFocusPainted(false);
        rejectBtn0.setFocusable(false);
        rejectBtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtn0ActionPerformed(evt);
            }
        });

        acceptBtn0.setBackground(new java.awt.Color(111, 207, 151));
        acceptBtn0.setForeground(new java.awt.Color(0, 0, 0));
        acceptBtn0.setText("Aceptar");
        acceptBtn0.setBorderPainted(false);
        acceptBtn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptBtn0.setFocusPainted(false);
        acceptBtn0.setFocusable(false);
        acceptBtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtn0ActionPerformed(evt);
            }
        });

        orderTitle0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderTitle0.setText("Sedan de lujo");
        orderTitle0.setFocusable(false);
        orderTitle0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        orderProgress0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderProgress0.setText("En progreso");
        orderProgress0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout orderPanel0Layout = new javax.swing.GroupLayout(orderPanel0);
        orderPanel0.setLayout(orderPanel0Layout);
        orderPanel0Layout.setHorizontalGroup(
            orderPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanel0Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptBtn0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rejectBtn0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderTitle0, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderProgress0, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        orderPanel0Layout.setVerticalGroup(
            orderPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderTitle0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderProgress0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(rejectBtn0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn0)
                .addContainerGap())
        );

        nextfactoryBtn.setText("Next Factory");
        nextfactoryBtn.setBorderPainted(false);
        nextfactoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextfactoryBtn.setFocusPainted(false);
        nextfactoryBtn.setFocusable(false);
        nextfactoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextfactoryBtnActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(orderPanel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nextfactoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orderPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPanel0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(factoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(goalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nextfactoryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rejectBtn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtn0ActionPerformed
        onRejectOrder(0);
    }//GEN-LAST:event_rejectBtn0ActionPerformed

    private void acceptBtn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtn0ActionPerformed
        onAcceptOrder(0);
    }//GEN-LAST:event_acceptBtn0ActionPerformed

    private void rejectBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtn1ActionPerformed
        onRejectOrder(1);
    }//GEN-LAST:event_rejectBtn1ActionPerformed

    private void acceptBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtn1ActionPerformed
        onAcceptOrder(1);
    }//GEN-LAST:event_acceptBtn1ActionPerformed

    private void rejectBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtn2ActionPerformed
        onRejectOrder(2);
    }//GEN-LAST:event_rejectBtn2ActionPerformed

    private void acceptBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtn2ActionPerformed
        onAcceptOrder(2);
    }//GEN-LAST:event_acceptBtn2ActionPerformed

    private void rejectBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtn3ActionPerformed
        onRejectOrder(3);
    }//GEN-LAST:event_rejectBtn3ActionPerformed

    private void acceptBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtn3ActionPerformed
        onAcceptOrder(3);
    }//GEN-LAST:event_acceptBtn3ActionPerformed

    private void rejectBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtn4ActionPerformed
        onRejectOrder(4);
    }//GEN-LAST:event_rejectBtn4ActionPerformed

    private void acceptBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtn4ActionPerformed
        onAcceptOrder(4);
    }//GEN-LAST:event_acceptBtn4ActionPerformed

    private void nextfactoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextfactoryBtnActionPerformed
        int goal = player.getFactory().getProfitGoal();

        int rivalScore = goal + (int) (Math.random() * (goal * 0.1));
        int myScore = player.getCapital();

        String mensaje = "Tu resultado: $" + myScore + "\n"
                + "Puntaje del rival: $" + rivalScore + "\n\n";

        if (myScore >= rivalScore) {
            // Si ganas, pasa a la siguiente fábrica y actualiza vistas
            mensaje += "Bieeen! Pasas a la siguiente fábrica.";
            JOptionPane.showMessageDialog(this, mensaje, "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);

            controller.startNewFactory();

            updateHUB();
            updateOrdersDisplay();

            assemblyPanel.clearAllLists();
            assemblyPanel.updateAllTitles();
            assemblyPanel.disableAllAddButtons();
            assemblyPanel.updateAssemblyLineBackgrounds();

            conveyorBeltPanel.updateBelt();

            nextfactoryBtn.setEnabled(false);
            nextfactoryBtn.setBackground(new Color(180, 180, 180));

            // Si ya ganaste la última fábrica, mensaje de victoria
            if (player.getCurrentFactory() == 3 && player.hasWon()) {
                JOptionPane.showMessageDialog(this, "Has completado todas las fábricas!\nEres el gerente general supremo!", "¡Victoria!", JOptionPane.PLAIN_MESSAGE);
                // Aquí podrías cerrar la ventana o reiniciar el juego
            }
        } else {
            // Si pierdes, mensaje y reinicio
            mensaje += "Perdiste bro, así es la vida.";
            JOptionPane.showMessageDialog(this, mensaje, "Perdiste", JOptionPane.ERROR_MESSAGE);

            // Regresa a la ventana de inicio y cierra la actual
            java.awt.EventQueue.invokeLater(() -> {
                new view.StartGameView().setVisible(true);
            });

            SwingUtilities.getWindowAncestor(this).dispose();
        }

    }//GEN-LAST:event_nextfactoryBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn0;
    private javax.swing.JButton acceptBtn1;
    private javax.swing.JButton acceptBtn2;
    private javax.swing.JButton acceptBtn3;
    private javax.swing.JButton acceptBtn4;
    private javax.swing.JLabel factoryLabel;
    private javax.swing.JLabel goalLabel;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JButton nextfactoryBtn;
    private javax.swing.JPanel orderPanel0;
    private javax.swing.JPanel orderPanel1;
    private javax.swing.JPanel orderPanel2;
    private javax.swing.JPanel orderPanel3;
    private javax.swing.JPanel orderPanel4;
    private javax.swing.JLabel orderProgress0;
    private javax.swing.JLabel orderProgress1;
    private javax.swing.JLabel orderProgress2;
    private javax.swing.JLabel orderProgress3;
    private javax.swing.JLabel orderProgress4;
    private javax.swing.JLabel orderTitle0;
    private javax.swing.JLabel orderTitle1;
    private javax.swing.JLabel orderTitle2;
    private javax.swing.JLabel orderTitle3;
    private javax.swing.JLabel orderTitle4;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JButton rejectBtn0;
    private javax.swing.JButton rejectBtn1;
    private javax.swing.JButton rejectBtn2;
    private javax.swing.JButton rejectBtn3;
    private javax.swing.JButton rejectBtn4;
    // End of variables declaration//GEN-END:variables
}
