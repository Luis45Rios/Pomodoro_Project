/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizador;

import Controlador.TareaController;
import Modelos.Tarea;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author luisr
 */
public class Frm_Pomodoro extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Pomodoro
     */
    public Frm_Pomodoro() {
        initComponents();
        temporizador = new Timer();
        enTiempoEnfoque = true; // Comienza con tiempo de enfoque
        corriendo = false; // El temporizador no está corriendo al principio
        tiempoTotal = 0; // Inicializa el tiempo total a 0
        numeroPomodoros = this.tarea.getNumeroPomodoros();
    }

    private Tarea tarea;

    // Variables para el temporizador
    private Timer temporizador; // Objeto Timer para controlar el tiempo
    private int tiempoRestante; // Tiempo restante en segundos
    private boolean enTiempoEnfoque; // Indica si está en tiempo de enfoque o descanso
    private boolean corriendo; // Indica si el temporizador está en ejecución
    private int tiempoTotal; // Tiempo total acumulado en segundos
    private int numeroPomodoros;
    private TareaController tareaController = new TareaController();

    public Frm_Pomodoro(Tarea tarea) {
        this.tarea = tarea;
    }

    // Método para controlar el temporizador (iniciar, pausar, reanudar)
    private void controlarTemporizador() {
        if (corriendo) {
            pausarTemporizador();
        } else {
            iniciarTemporizador();
        }
    }

    // Método para iniciar o reanudar el temporizador
    private void iniciarTemporizador() {
        if (!corriendo) {
            if (tiempoRestante == 0) { // Configurar tiempo inicial si es la primera vez
                // Multiplicar por 60 para convertir minutos a segundos
                tiempoRestante = enTiempoEnfoque ? this.tarea.getTiempoEnfoque() * 60 : 5 * 60;
            }
            corriendo = true;
            botonControl.setText("Pausar");
            botonControl.setBackground(new Color(220, 20, 60)); // Cambia el botón a color rojo

            temporizador.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (tiempoRestante > 0) {
                        tiempoRestante--;
                        tiempoTotal++;
                        actualizarEtiquetaTiempo();
                    } else {
                        terminarCiclo();
                    }
                }
            }, 0, 1000);
        }
    }

    // Método para pausar el temporizador
    private void pausarTemporizador() {
        corriendo = false;
        temporizador.cancel();
        temporizador = new Timer(); // Reinicia el objeto Timer
        botonControl.setText("Reanudar");
        botonControl.setBackground(new Color(60, 179, 113)); // Cambia el botón a color verde
    }

    // Método para finalizar un ciclo (enfoque o descanso)
    private void terminarCiclo() {
        // Aumentar el número de pomodoros si es tiempo de enfoque
        if (enTiempoEnfoque) {
            numeroPomodoros++;
            tarea.setNumeroPomodoros(numeroPomodoros);
            tareaController.actualizarTarea(tarea);
        }
        temporizador.cancel();
        temporizador = new Timer(); // Reinicia el objeto Timer
        enTiempoEnfoque = !enTiempoEnfoque; // Cambia entre enfoque y descanso
        tiempoRestante = 0; // Reinicia el tiempo
        corriendo = false; // Detiene el temporizador
        botonControl.setText("Iniciar");
        botonControl.setBackground(new Color(60, 179, 113)); // Botón verde
        etiquetaTiempo.setText(enTiempoEnfoque ? "25:00" : "05:00");
        etiquetaEstado.setText(enTiempoEnfoque ? "Tiempo de enfoque" : "Tiempo de descanso");
        getContentPane().setBackground(enTiempoEnfoque ? new Color(40, 40, 40) : new Color(70, 130, 180)); // Cambia el
        // fondo
        iniciarTemporizador(); // Inicia automáticamente el siguiente ciclo
    }

    // Método para finalizar la tarea y mostrar el tiempo total
    private void finalizarTarea() {
        temporizador.cancel();
        int horas = tiempoTotal / 3600;
        int minutos = (tiempoTotal % 3600) / 60;
        int segundos = tiempoTotal % 60;
        JOptionPane.showMessageDialog(this,
                String.format("Tarea finalizada.\nTiempo total: %02d:%02d:%02d", horas, minutos, segundos),
                "Resumen de la tarea",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); // Cierra la aplicación
    }

    // Método para actualizar la etiqueta del tiempo
    private void actualizarEtiquetaTiempo() {
        int minutos = tiempoRestante / 60;
        int segundos = tiempoRestante % 60;
        etiquetaTiempo.setText(String.format("%02d:%02d", minutos, segundos));
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
        etiquetaEstado = new javax.swing.JLabel();
        etiquetaTiempo = new javax.swing.JLabel();
        botonControl = new javax.swing.JButton();
        botonFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        etiquetaEstado.setFont(new java.awt.Font("Yu Gothic Light", 1, 30)); // NOI18N
        etiquetaEstado.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaEstado.setText("Tiempo de Enfoque");

        etiquetaTiempo.setFont(new java.awt.Font("Yu Gothic Light", 0, 55)); // NOI18N
        etiquetaTiempo.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTiempo.setText("00:00");

        botonControl.setBackground(new java.awt.Color(153, 255, 153));
        botonControl.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        botonControl.setText("INICIAR");
        botonControl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonFinalizar.setBackground(new java.awt.Color(153, 255, 255));
        botonFinalizar.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        botonFinalizar.setText("FINALIZAR TAREA");
        botonFinalizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiquetaEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(etiquetaTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(botonControl, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(etiquetaEstado)
                .addGap(34, 34, 34)
                .addComponent(etiquetaTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonControl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonFinalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Pomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Pomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Pomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Pomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Pomodoro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonControl;
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaTiempo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
