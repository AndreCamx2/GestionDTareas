package Vistas;

import DAO.ListaTareas;
import Modelos.Tarea;
import java.util.LinkedList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class VentanaBuscarTareas extends javax.swing.JFrame {

    private String usuarioLogeado;

    private ListaTareas listaTareas = new ListaTareas();
    private DocumentListener docListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            filtrarTareas();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filtrarTareas();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filtrarTareas();
        }
    };

    public VentanaBuscarTareas(String usuario) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        this.usuarioLogeado = usuario;

        // LISTENERS PARA BUSCAR AUTOMÁTICO
        txtNombreTarea.getDocument().addDocumentListener(docListener);
        txtIDtarea.getDocument().addDocumentListener(docListener);
        txtAsignaturaTarea.getDocument().addDocumentListener(docListener);
        Prioridades.addActionListener(e -> filtrarTareas());

        // CARGAR AL INICIAR
        filtrarTareas();
    }

    private void filtrarTareas() {
        String nombre = txtNombreTarea.getText().trim().toLowerCase();
        String idTexto = txtIDtarea.getText().trim();
        String asignatura = txtAsignaturaTarea.getText().trim().toLowerCase();
        String prioridad = Prioridades.getSelectedItem().toString();

        String usuarioActual = usuarioLogeado;

        LinkedList<Tarea> lista = listaTareas.getLista();
        LinkedList<Tarea> filtradas = new LinkedList<>();

        for (Tarea t : lista) {

            if (!t.getUsuario().equalsIgnoreCase(usuarioActual)) {
                continue;
            }

            boolean coincide = true;

            if (!nombre.isEmpty()
                    && !t.getNombre().toLowerCase().contains(nombre)) {
                coincide = false;
            }

            if (!idTexto.isEmpty()) {
                try {
                    int id = Integer.parseInt(idTexto);
                    if (t.getId() != id) {
                        coincide = false;
                    }
                } catch (NumberFormatException e) {
                }
            }

            if (!asignatura.isEmpty()
                    && !t.getAsignatura().toLowerCase().contains(asignatura)) {
                coincide = false;
            }

            if (!prioridad.equalsIgnoreCase("Seleccione...")
                    && !t.getPrioridad().equalsIgnoreCase(prioridad)) {
                coincide = false;
            }

            if (coincide) {
                filtradas.add(t);
            }
        }

        actualizarTabla(filtradas);
    }

    private void actualizarTabla(LinkedList<Tarea> tareas) {
        DefaultTableModel modelo = (DefaultTableModel) tblTareas.getModel();
        modelo.setRowCount(0);

        int pos = 1;

        for (Tarea t : tareas) {
            modelo.addRow(new Object[]{
                pos++, // Posición
                t.getNombre(), // Nombre
                t.getId(), // ID
                t.getAsignatura(), // Asignatura
                t.getFechaInicio(), // Fecha inicio
                t.getFechaEntrega(), // Fecha entrega
                t.getPrioridad() // Prioridad
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Prioridades = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreTarea = new javax.swing.JTextField();
        txtIDtarea = new javax.swing.JTextField();
        txtAsignaturaTarea = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 690, 180));

        Prioridades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "ALTA", "MEDIA", "BAJA", "CADUCADA" }));

        jLabel6.setText("Prioridad:");

        jLabel5.setText("Asignatura:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("ID:");

        txtNombreTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreTareaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel7.setText("SELECIONE O USE CUALQUIERA DE LAS OPCIONES DE BUSQUEDA");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Opciones de busqueda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreTarea)
                            .addComponent(txtIDtarea, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAsignaturaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Prioridades, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7)
                        .addContainerGap(105, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(157, 157, 157))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAsignaturaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Prioridades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDtarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(47, 47, 47)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 500, 170));

        txtFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo 2.png"))); // NOI18N
        jPanel2.add(txtFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 828, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 574, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreTareaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Prioridades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTareas;
    private javax.swing.JTextField txtAsignaturaTarea;
    private javax.swing.JLabel txtFondo;
    private javax.swing.JTextField txtIDtarea;
    private javax.swing.JTextField txtNombreTarea;
    // End of variables declaration//GEN-END:variables
}
