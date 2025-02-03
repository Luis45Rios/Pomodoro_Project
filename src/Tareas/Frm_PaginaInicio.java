package Tareas;

import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import Controlador.TareaController;
import Modelos.Tarea;
import Modelos.TareaTableModel;
import Modelos.Usuario;

/**
 *
 * @author domenica
 */
public class Frm_PaginaInicio extends javax.swing.JFrame {

    private Usuario usuario;
    private static TareaController tareaController = new TareaController();

    public Frm_PaginaInicio(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jButtonNuevaTarea = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        jTableResumen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 255, 184));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 500));

        jLabel1.setFont(new java.awt.Font("URW Bookman", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 153, 22));
        jLabel1.setText("Inicio");

        jLabelNombreUsuario.setFont(new java.awt.Font("URW Gothic", 0, 50)); // NOI18N
        jLabelNombreUsuario.setForeground(new java.awt.Color(1, 1, 1));
        jLabelNombreUsuario.setText("Bienvenido (Usuario) ");

        jButtonNuevaTarea.setBackground(new java.awt.Color(55, 153, 22));
        jButtonNuevaTarea.setFont(new java.awt.Font("URW Gothic", 0, 18)); // NOI18N
        jButtonNuevaTarea.setForeground(new java.awt.Color(1, 1, 1));
        jButtonNuevaTarea.setText("Nueva Tarea ");
        jButtonNuevaTarea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(254, 254, 254), null, null));


        jTableResumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {

                "Nombre", "Nro. Pomodoros", "Opciones"
            }
        ));
        jScrollPane1.setViewportView(jTableResumen);
        if (jTableResumen.getColumnModel().getColumnCount() > 0) {
            jTableResumen.getColumnModel().getColumn(0).setResizable(false);
            jTableResumen.getColumnModel().getColumn(1).setResizable(false);
            jTableResumen.getColumnModel().getColumn(2).setResizable(false);

        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelNombreUsuario)
                .addGap(114, 114, 114))
            .addGroup(jPanel1Layout.createSequentialGroup()

                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonNuevaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(288, 288, 288)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNombreUsuario)
                .addGap(18, 18, 18)

                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonNuevaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevaTareaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonNuevaTareaActionPerformed
        Frm_CrearTarea frm = new Frm_CrearTarea(this, rootPaneCheckingEnabled, usuario);
        setVisible(false);
        frm.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_PaginaInicio.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Frm_PaginaInicio(null).setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JButton jButtonNuevaTarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResumen;

    // End of variables declaration//GEN-END:variables

    static class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setText("Eliminar");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            return this;
        }

    }

    static class ButtonEditor extends DefaultCellEditor {

        private final JButton button;
        private final TareaTableModel model;
        private int row;

        public ButtonEditor(TareaTableModel model) {
            super(new JTextField());
            this.model = model;
            button = new JButton("Eliminar");
            button.addActionListener(e -> {
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la tarea?",
                        "Eliminar tarea",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Tarea tarea = this.model.getTarea(row);
                    tareaController.eliminarTarea(tarea.getId());
                    this.model.removeRow(row);

                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            this.row = row;
            return button;
        }

    }
}
