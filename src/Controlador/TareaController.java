package Controlador;

import java.util.List;

import Modelos.Tarea;
import Servicios.TareaFileManagment;

/**
 * 
 * @author domenica
 */

public class TareaController {
    private final TareaFileManagment tareaService = new TareaFileManagment();

    public Tarea crearTarea(String nombre, Integer tiempoEnfoque, Integer numeroPomodoros, String username) {
        Integer id = tareaService.getTaskId();
        Tarea tarea = new Tarea(id, nombre, tiempoEnfoque, numeroPomodoros, username);
        tareaService.createTask(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTareas(String username) {
        return tareaService.getTasks(username);
    }

    public void eliminarTarea(Integer id) {
        tareaService.deleteTask(id);
    }

    public void actualizarTarea(Tarea tarea) {
        tareaService.updateTask(tarea);
    }
}
