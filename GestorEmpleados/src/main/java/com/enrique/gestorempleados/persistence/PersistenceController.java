
package com.enrique.gestorempleados.persistence;

import com.enrique.gestorempleados.entities.Empleado;
import com.enrique.gestorempleados.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersistenceController {
    
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public void crearEmpleado(Empleado empleado) {
        empleadoJpa.create(empleado);
    }

    public void eliminarEmpleado(int idEliminar) {
        try {
            empleadoJpa.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(int idEditar) {
       return empleadoJpa.findEmpleado(idEditar);
    }

    public void editarEmpleado(Empleado empleadoEdit) {
        try {
            empleadoJpa.edit(empleadoEdit);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public List<Empleado> traerEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }
    
}
