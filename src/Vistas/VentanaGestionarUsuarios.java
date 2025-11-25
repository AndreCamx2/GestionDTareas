package Vistas;

import DAO.ListaTareas;
import DAO.ListaUsuarios;
import Modelos.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaGestionarUsuarios extends javax.swing.JFrame {

    private String usuarioLogueado;
    private ListaUsuarios listaUsuarios;

    public VentanaGestionarUsuarios(String usuarioLogueado, ListaUsuarios listaUsuarios) {

        initComponents();

        setLocationRelativeTo(null);
        setResizable(false);

        txtUsuario.setEditable(false);
        txtUsuario.setFocusable(false);
        txtUsuario.setBackground(new java.awt.Color(230, 230, 230));

        setLocationRelativeTo(null);
        this.usuarioLogueado = usuarioLogueado;
        this.listaUsuarios = listaUsuarios;

        setLocationRelativeTo(null);
        setResizable(false);
        tblUsuarios.setDefaultEditor(Object.class, null);

        cargarUsuariosEnTabla();

        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tblUsuarios.getSelectedRow();
                if (fila != -1) {
                    txtNombreUsuario.setText(tblUsuarios.getValueAt(fila, 0).toString());
                    txtApellido.setText(tblUsuarios.getValueAt(fila, 1).toString());
                    txtUsuario.setText(tblUsuarios.getValueAt(fila, 2).toString());
                    txtContraseña.setText(tblUsuarios.getValueAt(fila, 3).toString());
                }
            }
        });

        tblUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    int fila = tblUsuarios.getSelectedRow();
                    if (fila != -1) {

                        evt.consume();

                        txtNombreUsuario.setText(tblUsuarios.getValueAt(fila, 0).toString());
                        txtApellido.setText(tblUsuarios.getValueAt(fila, 1).toString());
                        txtUsuario.setText(tblUsuarios.getValueAt(fila, 2).toString());
                        txtContraseña.setText(tblUsuarios.getValueAt(fila, 3).toString());

                        txtNombreUsuario.requestFocusInWindow();
                    }
                }
            }
        });

    }

    public VentanaGestionarUsuarios() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(985, 500);

        listaUsuarios = new ListaUsuarios();
        cargarUsuariosEnTabla();

    }

    public void cargarUsuariosEnTabla() {
        try {

            DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
            modelo.setRowCount(0);

            for (Usuario u : listaUsuarios.getLista()) {
                modelo.addRow(new Object[]{
                    u.getNombre(),
                    u.getApellido(),
                    u.getNombreUsuario(),
                    u.getContrasena()
                });
            }

        } catch (Exception e) {
            System.out.println("Error cargando usuarios: " + e.getMessage());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnEliminarTarea = new javax.swing.JButton();
        btnActualizarUsuarios = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        txtAdmistracion = new javax.swing.JLabel();
        txtFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "Usuario", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblUsuarios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 680, 220));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarTarea.setBackground(new java.awt.Color(170, 90, 90));
        btnEliminarTarea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnEliminarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar Usuario.png"))); // NOI18N
        btnEliminarTarea.setText("Eliminar Usuarios");
        btnEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 160, 40));

        btnActualizarUsuarios.setBackground(new java.awt.Color(100, 160, 100));
        btnActualizarUsuarios.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnActualizarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/actualizar usuario.png"))); // NOI18N
        btnActualizarUsuarios.setText("Actualizar Usuario");
        btnActualizarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btnActualizarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 180, 150));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyPressed(evt);
            }
        });
        jPanel2.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, 30));

        lblApellido.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido:");
        jPanel2.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 30));

        lblNombre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoKeyPressed(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 140, 30));

        lblNombre1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre1.setText("Usuario:");
        jPanel2.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 170, 30));

        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });
        jPanel2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 180, 30));

        lblContraseña.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setText("Contraseña:");
        jPanel2.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 690, 130));

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
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 440, 110, 40));

        txtAdmistracion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        txtAdmistracion.setForeground(new java.awt.Color(255, 255, 255));
        txtAdmistracion.setText("Admistrar Usuarios");
        getContentPane().add(txtAdmistracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        txtFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo.png"))); // NOI18N
        getContentPane().add(txtFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTareaActionPerformed

        int fila = tblUsuarios.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario para eliminar.");
            return;
        }

        String usuario = tblUsuarios.getValueAt(fila, 2).toString();

        // PROHIBIR ELIMINAR ADMIN
        if (usuario.equalsIgnoreCase("admin")) {
            JOptionPane.showMessageDialog(this, "No puedes eliminar al usuario administrador.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Eliminar usuario " + usuario + "?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            Usuario u = listaUsuarios.buscarUsuario(usuario);

            if (u != null) {

                // ELIMINAR USUARIO
                listaUsuarios.getLista().remove(u);
                listaUsuarios.guardar();

                // ELIMINAR SUS TAREAS
                ListaTareas listaTareas = new ListaTareas();
                listaTareas.cargar();
                listaTareas.eliminarTodasLasTareasDelUsuario(usuario);
                listaTareas.guardar();

                // ELIMINAR FILA DE TABLA
                ((DefaultTableModel) tblUsuarios.getModel()).removeRow(fila);

                // SI EL USUARIO ELIMINADO ES EL LOGUEADO → VOLVER AL LOGIN
                if (usuario.equalsIgnoreCase(usuarioLogueado)) {
                    JOptionPane.showMessageDialog(this, "Tu usuario ha sido eliminado. La sesión se cerrará.");
                    new Login().setVisible(true);
                    this.dispose();
                    return;
                }

                // SI SE ELIMINÓ OTRO USUARIO NORMAL
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");

            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario.");
            }
        }
    }//GEN-LAST:event_btnEliminarTareaActionPerformed

    private void btnActualizarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuariosActionPerformed
        int filaSeleccionada = tblUsuarios.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario para actualizar.");
            return;
        }

        String usuarioActual = tblUsuarios.getValueAt(filaSeleccionada, 2).toString();

        // PROHIBIR actualizar al administrador
        if (usuarioActual.equalsIgnoreCase("admin")) {
            JOptionPane.showMessageDialog(this, "No puedes actualizar al usuario administrador.");
            return;
        }

        // DATOS NUEVOS
        String nuevoNombre = txtNombreUsuario.getText().trim();
        String nuevoApellido = txtApellido.getText().trim();
        String nuevoUsuario = txtUsuario.getText().trim();
        String nuevaContrasena = txtContraseña.getText().trim();

        // VALIDACIÓN: ¿Cambió el nombre de usuario?
        if (!nuevoUsuario.equalsIgnoreCase(usuarioActual)) {

            // Si intenta usar un usuario que ya existe, impedirlo
            if (listaUsuarios.buscarUsuario(nuevoUsuario) != null) {
                JOptionPane.showMessageDialog(this,
                        "Ya existe un usuario con el nombre: " + nuevoUsuario,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // ACTUALIZAR DATOS
        Usuario usuario = listaUsuarios.buscarUsuario(usuarioActual);

        if (usuario != null) {
            usuario.setNombre(nuevoNombre);
            usuario.setApellido(nuevoApellido);
            usuario.setNombreUsuario(nuevoUsuario);
            usuario.setContrasena(nuevaContrasena);

            listaUsuarios.guardar();
            cargarUsuariosEnTabla();
            JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");

            // Si actualiza su propio usuario, actualizar el valor en memoria
            if (usuarioActual.equals(usuarioLogueado)) {
                usuarioLogueado = nuevoUsuario;
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el usuario a actualizar.");
        }
    }//GEN-LAST:event_btnActualizarUsuariosActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        OpcionesTareas opcionesTareas = new OpcionesTareas(usuarioLogueado);
        opcionesTareas.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtNombreUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtApellido.requestFocus();
        }

    }//GEN-LAST:event_txtNombreUsuarioKeyPressed

    private void txtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtContraseña.requestFocus();
        }

    }//GEN-LAST:event_txtApellidoKeyPressed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtContraseña.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnActualizarUsuarios.doClick();
        }
    }//GEN-LAST:event_txtContraseñaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarUsuarios;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminarTarea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JLabel txtAdmistracion;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JLabel txtFondo;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
