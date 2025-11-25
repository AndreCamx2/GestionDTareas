package Vistas;

import DAO.ListaUsuarios;
import Modelos.Usuario;
import Vistas.VentanaGestionarUsuarios;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class OpcionesTareas extends javax.swing.JFrame {

    private String usuario;

    public OpcionesTareas(String usuario) {
        this.usuario = usuario;
        initComponents();

        setLocationRelativeTo(null);
        setResizable(false);
        setSize(500, 450);
        
    btnTrabajoIndividual.setFocusable(true);
    btnTrabajoCoop.setFocusable(true);

    activarNavegacionConTeclado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTareaCoop = new javax.swing.JLabel();
        txtTareaIndividual = new javax.swing.JLabel();
        btnTrabajoCoop = new javax.swing.JButton();
        btnTrabajoIndividual = new javax.swing.JButton();
        btnAdmistrarUsuarios = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        txtFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTareaCoop.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        txtTareaCoop.setForeground(new java.awt.Color(255, 255, 255));
        txtTareaCoop.setText("Tareas Cooperativas");
        jPanel1.add(txtTareaCoop, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 180, 30));

        txtTareaIndividual.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        txtTareaIndividual.setForeground(new java.awt.Color(255, 255, 255));
        txtTareaIndividual.setText("Tareas Individuales");
        jPanel1.add(txtTareaIndividual, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 180, 30));

        btnTrabajoCoop.setBackground(new java.awt.Color(102, 102, 102));
        btnTrabajoCoop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/trabajo-en-equipo.png"))); // NOI18N
        btnTrabajoCoop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajoCoopActionPerformed(evt);
            }
        });
        jPanel1.add(btnTrabajoCoop, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 180, 160));

        btnTrabajoIndividual.setBackground(new java.awt.Color(102, 102, 102));
        btnTrabajoIndividual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/trabajo individual.png"))); // NOI18N
        btnTrabajoIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajoIndividualActionPerformed(evt);
            }
        });
        jPanel1.add(btnTrabajoIndividual, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 180, 160));

        btnAdmistrarUsuarios.setBackground(new java.awt.Color(102, 102, 102));
        btnAdmistrarUsuarios.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        btnAdmistrarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnAdmistrarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/adminDeUsuarios.png"))); // NOI18N
        btnAdmistrarUsuarios.setText("Admistrar Usuarios");
        btnAdmistrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmistrarUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdmistrarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 230, 50));

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
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 100, 40));

        txtFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo 2.png"))); // NOI18N
        jPanel1.add(txtFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activarNavegacionConTeclado() {

    btnTrabajoIndividual.requestFocus();

    btnTrabajoIndividual.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "irDerecha");
    btnTrabajoIndividual.getActionMap().put("irDerecha", new AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnTrabajoCoop.requestFocus();
        }
    });

    btnTrabajoCoop.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "irIzquierda");
    btnTrabajoCoop.getActionMap().put("irIzquierda", new AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnTrabajoIndividual.requestFocus();
        }
    });

    btnTrabajoIndividual.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enter");
    btnTrabajoIndividual.getActionMap().put("enter", new AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnTrabajoIndividual.doClick();
        }
    });

    btnTrabajoCoop.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enter");
    btnTrabajoCoop.getActionMap().put("enter", new AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnTrabajoCoop.doClick();
        }
    });
    
btnTrabajoIndividual.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "irAbajo1");
btnTrabajoIndividual.getActionMap().put("irAbajo1", new AbstractAction() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        btnAdmistrarUsuarios.requestFocus();
    }
});

btnTrabajoCoop.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "irAbajo2");
btnTrabajoCoop.getActionMap().put("irAbajo2", new AbstractAction() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        btnAdmistrarUsuarios.requestFocus();
    }
});

btnAdmistrarUsuarios.getInputMap().put(KeyStroke.getKeyStroke("UP"), "irArriba1");
btnAdmistrarUsuarios.getActionMap().put("irArriba1", new AbstractAction() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        btnTrabajoIndividual.requestFocus();
    }
});

btnAdmistrarUsuarios.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "irAbajo3");
btnAdmistrarUsuarios.getActionMap().put("irAbajo3", new AbstractAction() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        btnAtras.requestFocus();
    }
});

btnAtras.getInputMap().put(KeyStroke.getKeyStroke("UP"), "irArriba2");
btnAtras.getActionMap().put("irArriba2", new AbstractAction() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        btnAdmistrarUsuarios.requestFocus();
    }
});

btnAdmistrarUsuarios.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAdm");
btnAdmistrarUsuarios.getActionMap().put("enterAdm", new AbstractAction() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        btnAdmistrarUsuarios.doClick();
    }
});

btnAtras.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAtras");
btnAtras.getActionMap().put("enterAtras", new AbstractAction() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        btnAtras.doClick();
    }
});

}
    
    private void btnTrabajoCoopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajoCoopActionPerformed
    JOptionPane.showMessageDialog(
        this,
        "🚧 Esta sección está en mantenimiento.\n\nEstará disponible muy pronto :)",
        "En mantenimiento:)",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_btnTrabajoCoopActionPerformed

    private void btnTrabajoIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajoIndividualActionPerformed
        VentanaPrincipal ventana = new VentanaPrincipal(usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTrabajoIndividualActionPerformed

    private void btnAdmistrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmistrarUsuariosActionPerformed

        String usuarioIngresado = JOptionPane.showInputDialog(this, "Ingrese el usuario administrador:");
        if (usuarioIngresado == null) {
            return; 
        }
        String contrasenaIngresada = JOptionPane.showInputDialog(this, "Ingrese la contraseña:");
        if (contrasenaIngresada == null) {
            return; 
        }
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        listaUsuarios.cargar();

        boolean accesoPermitido = false;

        for (Usuario u : listaUsuarios.getLista()) {

            if (u.getNombreUsuario().equals(usuarioIngresado)
                    && u.getContrasena().equals(contrasenaIngresada)) {

                if (u.getNombreUsuario().equalsIgnoreCase("admin")) {
                    accesoPermitido = true;
                }

                break; 
            }
        }

        if (accesoPermitido) {
            JOptionPane.showMessageDialog(this, "Acceso permitido. Bienvenido, Administrador.");

            ListaUsuarios lista = new ListaUsuarios();
            lista.cargar();

            VentanaGestionarUsuarios admin = new VentanaGestionarUsuarios("Admin", lista );
            admin.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Usuario o contraseña incorrectos.\nAcceso denegado.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_btnAdmistrarUsuariosActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmistrarUsuarios;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnTrabajoCoop;
    private javax.swing.JButton btnTrabajoIndividual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtFondo;
    private javax.swing.JLabel txtTareaCoop;
    private javax.swing.JLabel txtTareaIndividual;
    // End of variables declaration//GEN-END:variables
}
