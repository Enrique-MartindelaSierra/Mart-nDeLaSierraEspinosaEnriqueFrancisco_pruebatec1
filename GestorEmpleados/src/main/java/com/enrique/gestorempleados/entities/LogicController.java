
package com.enrique.gestorempleados.entities;

import com.enrique.gestorempleados.persistence.PersistenceController;
import java.util.List;


public class LogicController {

    PersistenceController persisControl = new PersistenceController();

    public void crearEmpleado(Empleado empleado) {
        persisControl.crearEmpleado(empleado);
    }

    public void eliminarEmpleado(int idEliminar) {
                persisControl.eliminarEmpleado(idEliminar);
    }

    public Empleado buscarEmpleado(int idEditar) {
    return persisControl.buscarEmpleado(idEditar);   
     
    }

    public void editarEmpleado(Empleado empleadoEdit) {
persisControl.editarEmpleado(empleadoEdit);
        }

    public List<Empleado> traerEmpleados() {
      return persisControl.traerEmpleados();
        
    }
}
