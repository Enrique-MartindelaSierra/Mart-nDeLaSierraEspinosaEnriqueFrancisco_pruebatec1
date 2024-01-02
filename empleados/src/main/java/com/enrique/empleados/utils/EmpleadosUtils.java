package com.enrique.empleados.utils;

import com.enrique.empleados.entities.Empleado;
import com.enrique.empleados.entities.LogicController;
import com.enrique.empleados.exceptions.WrongValueException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EmpleadosUtils {

    private static Scanner sc = new Scanner(System.in);
    private static LogicController logicController = new LogicController();

    /**
     * Maneja un menu interactivo por consola utilizando las funciones de la 
     * clase EmpleadosUtils
     */
    public static void menu() {
        int opcion;
        do {
            printMenu();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 ->
                    addEmpleado();
                case 2 ->
                    listarEmpleado();
                case 3 ->
                    actualizarEmpleado();
                case 4 ->
                    eliminarEmpleado();
                case 5 ->
                    findByCargo();
                case 6 ->
                    System.out.println("Gracias por usar nuestro programa");
                default ->
                    System.out.println("Error");
            }
        } while (opcion != 6);
    }

    /**
     * Imprime un menu por consola     
     */
    private static void printMenu() {
        System.out.println("---------------------------");
        System.out.println("|  1 añadir empleado      |");
        System.out.println("|  2 listar empleado      |");
        System.out.println("|  3 actualizar empleado  |");
        System.out.println("|  4 eliminar empleado    |");
        System.out.println("|  5 buscar empleado      |");
        System.out.println("|  6 cerrar programa      |");
        System.out.println("---------------------------");
    }

    /**
     * Este Metodo nos permite crear y rellenar un objeto de tipo Empleado por
     * consola
     *
     * @return Empleado
     */
    public static Empleado fillEmpleado() throws WrongValueException {
        Empleado empleado = new Empleado();

        System.out.println("Introduzca el NOMBRE del empleado ");
        empleado.setNombre(sc.nextLine());
        if (empleado.getNombre().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("Introduzca el APELLIDO del empleado");
        empleado.setApellido(sc.nextLine());
        if (empleado.getApellido().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("Introduzca el CARGO del empleado");
        empleado.setCargo(sc.nextLine());
        if (empleado.getCargo().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("Introduzca el SALARIO del empleado en formato: 0.0");
        empleado.setSalario(Double.parseDouble(sc.nextLine()));
        System.out.println("Introduzca la FECHA DE INICIO del empleado en formato: yyyy-mm-dd");
        empleado.setFechaInicio(LocalDate.parse(sc.nextLine()));

        return empleado;
    }

    /**
     * Este Metodo recibe un objeto de tipo Empleado y nos permite rellenar sus
     * datos por consola
     *
     * @return Empleado
     */
    public static Empleado fillEmpleado(Empleado empleado) throws WrongValueException {

        System.out.println("Introduzca el NOMBRE del empleado ");
        empleado.setNombre(sc.nextLine());
        if (empleado.getNombre().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("Introduzca el APELLIDO del empleado");
        empleado.setApellido(sc.nextLine());
        if (empleado.getApellido().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("Introduzca el CARGO del empleado");
        empleado.setCargo(sc.nextLine());
        if (empleado.getCargo().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("Introduzca el SALARIO del empleado en formato: 0.0");
        empleado.setSalario(Double.parseDouble(sc.nextLine()));
        System.out.println("Introduzca la FECHA DE INICIO del empleado en formato: yyyy-mm-dd");
        empleado.setFechaInicio(LocalDate.parse(sc.nextLine()));

        return empleado;
    }

    /**
     * Este Metodo recibe un objeto de tipo Empleado y nos ayuda a verificar que
     * es el que necesitamos
     *
     * @return boolean verified
     */
    public static boolean verifyEmpleado(Empleado verEmpleado) {
        boolean verified = false;
        boolean wrongValue;

        do {
            System.out.println("Es este el empleado correcto? y/n");
            System.out.println(verEmpleado);
            String yesOrNo = sc.nextLine();

            if (yesOrNo.equalsIgnoreCase("y")) {
                verified = true;
                wrongValue = false;

            } else if (yesOrNo.equalsIgnoreCase("n")) {
                System.out.println("");
                wrongValue = false;

            } else {
                System.out.println("Error: valor incorrecto, introduzca 'y' o 'n' ");
                wrongValue = true;
            }
        } while (wrongValue);

        return verified;
    }

    /**
     * Este Metodo utiliza los metodos fillEmpleado() y verifyEmpleado() para
     * pedir un usuario por consola, validarlo, y añadirlo a la base de datos
     *
     */
    public static void addEmpleado() {
        boolean done = false;
        while (!done) {
            try {
                Empleado empleado = fillEmpleado();
                if (verifyEmpleado(empleado)) {
                    logicController.addEmpleado(empleado);
                    System.out.println("Empleado añadido");
                    done = goBack(done);
                }
            } catch (Exception e) {
                System.out.println("----!Wrong value or format!----");
                e.printStackTrace();
                done = goBack(done);
            }
        }
    }

    /**
     * Metodo que muestra los Empleados de la base de datos por consola
     */
    private static void listarEmpleado() {
        boolean done = false;
        while (!done) {
            listaEmpleados().forEach(System.out::println);
            done = goBack(done);
        }
    }

    /**
     * Metodo que recoge los Empleados de la base de datos y los devuelve como
     * Lista
     *
     * @return List<Empleado>
     */
    public static List<Empleado> listaEmpleados() {
        return logicController.bringEmpleados();
    }

    /**
     * Metodo que nos permite buscar a un Empleado por consola y editar todos
     * sus parametros
     */
    private static void actualizarEmpleado() {
        boolean done = false;
        while (!done) {
            System.out.println("id empleado a editar");
            int idEditar = Integer.parseInt(sc.nextLine());

            Empleado empleadoEdit = logicController.findEmpleado(idEditar);

            try {
                if (existeEnDB(empleadoEdit.getId())) {
                    System.out.println("datos empleado: " + empleadoEdit);

                    boolean ver = false;
                    while (!ver) {
                        try {
                            empleadoEdit = fillEmpleado(empleadoEdit);
                            if (verifyEmpleado(empleadoEdit)) {
                                logicController.editEmpleado(empleadoEdit);
                                System.out.println("Empleado editado");
                                ver = true;
                                done = goBack(done);
                            } else {
                                ver = goBack(ver);
                                done = ver;
                            }
                        } catch (Exception e) {
                            System.out.println("----!Wrong value or format!----");
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println("No se encuentran  Empleados con el id: " + idEditar);
                done = goBack(done);

            }
        }
    }

    /**
     * Metodo que nos permite buscar a un Empleado por consola y eliminarlo de
     * la base de datos
     */
    private static void eliminarEmpleado() {
        boolean done = false;
        while (!done) {
            System.out.println("id empleado eliminar");
            int idEliminar = Integer.parseInt(sc.nextLine());
            Empleado empleado = logicController.findEmpleado(idEliminar);
            try {
                if (existeEnDB(empleado.getId())) {

                    if (verifyEmpleado(empleado)) {
                        logicController.destroyEmpleado(idEliminar);
                        System.out.println("Se ha eliminado el empleado");
                        done = goBack(done);
                    } else {
                        System.out.println("No se ha eliminado el empleado");
                    }
                    done = goBack(done);
                }
            } catch (Exception ex) {
                System.out.println("No se encuentran  Empleados con el id: " + idEliminar);
                done = goBack(done);
            }
        }
    }

    /**
     * Metodo que nos permite buscar una lista de Empleados filtrando por el
     * cargo que escribamos y lo imprime por consola
     */
    public static void findByCargo() {
        boolean done = false;
        while (!done) {
            List<Empleado> empleados = listaEmpleados();
            System.out.println("Cargo a buscar:");
            String cargo = sc.nextLine();
            List<Empleado> empleadosPorCargo = empleados.stream()
                    .filter(e -> e.getCargo().equalsIgnoreCase(cargo))
                    .collect(Collectors.toList());

            if (empleadosPorCargo.size() == 0) {
                System.out.println("No se encuentran empleados con el cargo: " + cargo);
            }

            empleadosPorCargo.forEach(System.out::println);
        }
        done = goBack(done);
    }

    /**
     * Funcion para comprobar que el Empleado en la base de datos no sea null
     *
     * @return boolean
     */
    public static boolean existeEnDB(Integer id) throws WrongValueException {

        if (id == null) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Esta funcion recibe un booleano que condiciona a un bucle, si el usuario
     * desea salir, devolverá true y cortará el bucle
     *
     * @return done
     */
    public static boolean goBack(boolean done) {

        boolean volver = false;
        boolean wrongValue;

        do {
            System.out.println("Quieres volver al menú y/n");
            String yesOrNo = sc.nextLine();

            if (yesOrNo.equalsIgnoreCase("y")) {
                volver = true;
                wrongValue = false;
            } else if (yesOrNo.equalsIgnoreCase("n")) {
                System.out.println("");
                wrongValue = false;
            } else {
                System.out.println("Error: valor incorrecto, introduzca 'y' o 'n' ");
                wrongValue = true;
            }
        } while (wrongValue);

        if (volver) {
            done = true;
        }
        return done;
    }

}
