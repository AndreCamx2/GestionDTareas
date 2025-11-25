package Vistas;

import DAO.ListaTareas;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;


public class VentanaGestionarTareas extends javax.swing.JFrame {

    private ListaTareas listaTareas;
    private DefaultTableModel modeloTabla;
    private VentanaPrincipal ventanaPrincipal;
    private String usuarioLogueado;
 
    public VentanaGestionarTareas(VentanaPrincipal ventanaPrincipal, String usuarioLogeado) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.ventanaPrincipal = ventanaPrincipal;
        this.usuarioLogueado = usuarioLogeado;
        
            JTextField editorInicio = (JTextField) fechaInicio.getDateEditor().getUiComponent();
            editorInicio.setEditable(false);
            editorInicio.setFocusable(false);

            JTextField editorEntrega = (JTextField) fechaEntrega.getDateEditor().getUiComponent();
            editorEntrega.setEditable(false);
            editorEntrega.setFocusable(false);


        setLocationRelativeTo(null);
        setResizable(false);
        tblTareas.setDefaultEditor(Object.class, null);

        ventanaPrincipal.cargarTareasEnTabla(tblTareas);

        tblTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tblTareas.getSelectedRow();
                if (fila != -1) {
                    txtNombreTarea.setText(tblTareas.getValueAt(fila, 1).toString());

                    txtAsignatura.setText(tblTareas.getValueAt(fila, 3).toString());

                    try {
                        String fechaInicioStr = tblTareas.getValueAt(fila, 4).toString();
                        String fechaEntregaStr = tblTareas.getValueAt(fila, 5).toString();

                        java.time.LocalDate fechaIni = java.time.LocalDate.parse(fechaInicioStr);
                        java.time.LocalDate fechaEnt = java.time.LocalDate.parse(fechaEntregaStr);

                        java.util.Date fechaIniDate = java.util.Date.from(fechaIni.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
                        java.util.Date fechaEntDate = java.util.Date.from(fechaEnt.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());

                        fechaInicio.setDate(fechaIniDate);
                        fechaEntrega.setDate(fechaEntDate);

                    } catch (Exception e) {
                        System.out.println("Error al convertir fechas: " + e.getMessage());
                    }
                }
            }
        });

    }

    public VentanaGestionarTareas() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(985, 500);

        this.listaTareas = new ListaTareas();
        this.modeloTabla = (DefaultTableModel) tblTareas.getModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnEliminarTarea = new javax.swing.JButton();
        btnActualizarTarea = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNombreTarea = new javax.swing.JTextField();
        lblAsignatura = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaEntrega = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtAsignatura = new javax.swing.JTextField();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaEntrega = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        txtAdmistracion = new javax.swing.JLabel();
        txtFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 680, 220));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarTarea.setBackground(new java.awt.Color(170, 90, 90));
        btnEliminarTarea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnEliminarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/borrar-tarea.png"))); // NOI18N
        btnEliminarTarea.setText("Eliminar Tarea");
        btnEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 160, 40));

        btnActualizarTarea.setBackground(new java.awt.Color(100, 160, 100));
        btnActualizarTarea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnActualizarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/actualizar-tarea.png"))); // NOI18N
        btnActualizarTarea.setText("Actualizar Tarea");
        btnActualizarTarea.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnActualizarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 180, 150));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreTareaActionPerformed(evt);
            }
        });
        txtNombreTarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreTareaKeyPressed(evt);
            }
        });
        jPanel2.add(txtNombreTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, 30));

        lblAsignatura.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblAsignatura.setForeground(new java.awt.Color(255, 255, 255));
        lblAsignatura.setText("Asignatura: ");
        jPanel2.add(lblAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 30));

        lblFechaInicio.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicio.setText("Fecha de inicio:");
        jPanel2.add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lblFechaEntrega.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblFechaEntrega.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaEntrega.setText("Fecha de entrega:");
        jPanel2.add(lblFechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        lblNombre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtAsignatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAsignaturaKeyPressed(evt);
            }
        });
        jPanel2.add(txtAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 140, 30));
        jPanel2.add(fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 140, 30));

        fechaEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaEntregaKeyPressed(evt);
            }
        });
        jPanel2.add(fechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 130, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 690, 130));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 700, 240));

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
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 110, 40));

        txtAdmistracion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        txtAdmistracion.setForeground(new java.awt.Color(255, 255, 255));
        txtAdmistracion.setText("Admistrar Tareas");
        getContentPane().add(txtAdmistracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        txtFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo.png"))); // NOI18N
        getContentPane().add(txtFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTareaActionPerformed

        int filaSeleccionada = tblTareas.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una tarea para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idTarea = Integer.parseInt(tblTareas.getValueAt(filaSeleccionada, 2).toString());

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas eliminar esta tarea?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            ListaTareas listaTareas = new ListaTareas();
            boolean eliminada = listaTareas.eliminarTarea(idTarea);

            if (eliminada) {
                DefaultTableModel modelo = (DefaultTableModel) tblTareas.getModel();
                modelo.removeRow(filaSeleccionada);

                JOptionPane.showMessageDialog(this, "Tarea eliminada correctamente.");

            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la tarea para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnEliminarTareaActionPerformed

    private void btnActualizarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTareaActionPerformed

        int filaSeleccionada = tblTareas.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una tarea para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(tblTareas.getValueAt(filaSeleccionada, 2).toString());
            String nuevoNombre = txtNombreTarea.getText().trim();
            String nuevaAsignatura = txtAsignatura.getText().trim();

            if (fechaInicio.getDate() == null || fechaEntrega.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Por favor selecciona ambas fechas.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            java.util.Date fechaIniUtil = fechaInicio.getDate();
            java.util.Date fechaEntUtil = fechaEntrega.getDate();

            java.time.LocalDate fechaIni = fechaIniUtil.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            java.time.LocalDate fechaEnt = fechaEntUtil.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

            if (fechaEnt.isBefore(fechaIni)) {
                JOptionPane.showMessageDialog(this, "La fecha de entrega no puede ser anterior a la fecha de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ListaTareas listaTareas = new ListaTareas();
            boolean encontrada = false;

            for (Modelos.Tarea t : listaTareas.getLista()) {
                if (t.getId() == id && t.getUsuario().equals(usuarioLogueado)) {
                    t.setNombre(nuevoNombre);
                    t.setAsignatura(nuevaAsignatura);
                    t.setFechaInicio(fechaIni);
                    t.setFechaEntrega(fechaEnt);
                    t.setPrioridad(t.calcularPrioridad());
                    encontrada = true;
                    break;
                }
            }

            if (encontrada) {
                listaTareas.guardar();
                JOptionPane.showMessageDialog(this, "Tarea actualizada correctamente.");

                ventanaPrincipal.cargarTareasEnTabla(tblTareas);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la tarea a actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar tarea: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnActualizarTareaActionPerformed

    private void txtNombreTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreTareaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        ventanaPrincipal.setVisible(true);

        ventanaPrincipal.cargarTareasEnTabla(ventanaPrincipal.getTblTareas());

        this.dispose();


    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtNombreTareaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreTareaKeyPressed
       if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
    txtAsignatura.requestFocus();
}

    }//GEN-LAST:event_txtNombreTareaKeyPressed

    private void txtAsignaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAsignaturaKeyPressed
     if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
         
    fechaInicio.getCalendarButton().requestFocusInWindow();
    fechaInicio.getCalendarButton().doClick();  
}


    }//GEN-LAST:event_txtAsignaturaKeyPressed

    private void fechaEntregaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaEntregaKeyPressed
      if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
          fechaEntrega.requestFocus();
          btnActualizarTarea.doClick();
}

    }//GEN-LAST:event_fechaEntregaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarTarea;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminarTarea;
    private com.toedter.calendar.JDateChooser fechaEntrega;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblFechaEntrega;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblTareas;
    private javax.swing.JLabel txtAdmistracion;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JLabel txtFondo;
    private javax.swing.JTextField txtNombreTarea;
    // End of variables declaration//GEN-END:variables
}
