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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
