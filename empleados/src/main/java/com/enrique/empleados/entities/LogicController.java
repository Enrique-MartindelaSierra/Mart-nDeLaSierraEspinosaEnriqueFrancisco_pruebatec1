package com.enrique.empleados.entities;

import com.enrique.empleados.persistence.PersistenceController;
import java.util.List;

public class LogicController {

    PersistenceController persisControl = new PersistenceController();

    public void addEmpleado(Empleado empleado) {
        persisControl.addEmpleado(empleado);
    }

    public void destroyEmpleado(int idEliminar) {
        persisControl.destroyEmpleado(idEliminar);
    }

    public Empleado findEmpleado(int idEditar) {
        return persisControl.findEmpleado(idEditar);

    }

    public void editEmpleado(Empleado empleadoEdit) {
        persisControl.editEmpleado(empleadoEdit);
    }

    public List<Empleado> bringEmpleados() {
        return persisControl.bringEmpleados();

    }
}
