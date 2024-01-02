package com.enrique.empleados.persistence;

import com.enrique.empleados.entities.Empleado;
import com.enrique.empleados.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public void addEmpleado(Empleado empleado) {
        empleadoJpa.create(empleado);
    }

    public void destroyEmpleado(int idEliminar) {
        try {
            empleadoJpa.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado findEmpleadoById(int idEditar) {
        return empleadoJpa.findEmpleadoById(idEditar);
    }

    public void editEmpleado(Empleado empleadoEdit) {
        try {
            empleadoJpa.edit(empleadoEdit);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> bringEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }

}
