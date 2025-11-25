package Vistas;

import DAO.ListaTareas;
import Modelos.Tarea;
import Modelos.Usuario;
import Vistas.VentanaGestionarTareas;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {

    String usuarioLogeado;

    public VentanaPrincipal(String usuario) {

        initComponents();

        setLocationRelativeTo(null);
        setResizable(false);

        this.usuarioLogeado = usuario;
        DefaultTableModel modelo = (DefaultTableModel) tblTareas.getModel();
        tblTareas.setDefaultEditor(Object.class, null); // Desactiva edición de todas las celdas de la tabla
        cargarTareasEnTabla(tblTareas);
    }

    public void cargarTareasEnTabla(javax.swing.JTable tabla) {
        try {
            ListaTareas listaTareas = new ListaTareas();
            listaTareas.cargar();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);

            int pos = 1;
            for (Tarea t : listaTareas.getLista()) {
                if (t.getUsuario().equals(usuarioLogeado)) {
                    modelo.addRow(new Object[]{
                        pos++,
                        t.getNombre(),
                        t.getId(),
                        t.getAsignatura(),
                        t.getFechaInicio(),
                        t.getFechaEntrega(),
                        t.getPrioridad()
                    });
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando tareas: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        tituloTareas = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnBuscartarea1 = new javax.swing.JButton();
        btnAnadirtarea = new javax.swing.JButton();
        btnAdministrarTareas = new javax.swing.JButton();
        txtFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setEnabled(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        tblTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Posicion", "Nombre", "ID", "Asignatura", "Fecha de inicio", "Fecha de entrega", "Prioridad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTareas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 710, 220));

        tituloTareas.setBackground(new java.awt.Color(255, 255, 255));
        tituloTareas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        tituloTareas.setForeground(new java.awt.Color(255, 255, 255));
        tituloTareas.setText("TAREAS");
        jPanel1.add(tituloTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 130, -1));

        btnAtras.setBackground(new java.awt.Color(100, 100, 100));
        btnAtras.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/regresar.png"))); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 110, 40));

        btnBuscartarea1.setBackground(new java.awt.Color(120, 120, 160));
        btnBuscartarea1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnBuscartarea1.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscartarea1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar-tarea.png"))); // NOI18N
        btnBuscartarea1.setText("Buscar tarea");
        btnBuscartarea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscartarea1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscartarea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 160, 40));

        btnAnadirtarea.setBackground(new java.awt.Color(100, 160, 100));
        btnAnadirtarea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAnadirtarea.setForeground(new java.awt.Color(255, 255, 255));
        btnAnadirtarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/añadir-tarea.png"))); // NOI18N
        btnAnadirtarea.setText("Añadir tarea");
        btnAnadirtarea.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnAnadirtarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirtareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnadirtarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 160, 40));

        btnAdministrarTareas.setBackground(new java.awt.Color(170, 90, 90));
        btnAdministrarTareas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAdministrarTareas.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministrarTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/adminDeTareas.png"))); // NOI18N
        btnAdministrarTareas.setText("Admistrar Tareas");
        btnAdministrarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdministrarTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 190, 40));

        txtFondo.setBackground(new java.awt.Color(255, 255, 255));
        txtFondo.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        txtFondo.setForeground(new java.awt.Color(255, 255, 255));
        txtFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo.png"))); // NOI18N
        txtFondo.setMaximumSize(new java.awt.Dimension(1200, 824));
        txtFondo.setMinimumSize(new java.awt.Dimension(1200, 824));
        txtFondo.setName(""); // NOI18N
        jPanel1.add(txtFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -250, 890, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnadirtareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirtareaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblTareas.getModel();

        VentanaAñadirTarea ventanaAñadirTarea = new VentanaAñadirTarea(modelo, usuarioLogeado);
        ventanaAñadirTarea.setVisible(true);

        ventanaAñadirTarea.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTareasEnTabla(tblTareas);
            }
        });
    }//GEN-LAST:event_btnAnadirtareaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed

        OpcionesTareas opcionesTareas = new OpcionesTareas(usuarioLogeado);
        opcionesTareas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAdministrarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarTareasActionPerformed

        VentanaGestionarTareas ventana = new VentanaGestionarTareas(this, usuarioLogeado);
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdministrarTareasActionPerformed

    private void btnBuscartarea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscartarea1ActionPerformed
        VentanaBuscarTareas ventana = new VentanaBuscarTareas(usuarioLogeado);
        ventana.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscartarea1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarTareas;
    private javax.swing.JButton btnAnadirtarea;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscartarea1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTareas;
    private javax.swing.JLabel tituloTareas;
    private javax.swing.JLabel txtFondo;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getTblTareas() {
        return tblTareas;
    }

}
