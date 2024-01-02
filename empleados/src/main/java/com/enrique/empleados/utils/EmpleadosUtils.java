package com.enrique.empleados.utils;

import com.enrique.empleados.entities.Empleado;
import com.enrique.empleados.entities.LogicController;
import com.enrique.empleados.exceptions.WrongValueException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmpleadosUtils {

    private static Scanner sc = new Scanner(System.in);
    private static LogicController logicController = new LogicController();

    public static void menu() {
        int opcion;
        do {
            printMenu();
            opcion = Integer.parseInt(sc.nextLine());
            handleOption(opcion);
        } while (opcion != 6);
    }

    private static void printMenu() {
        System.out.println("---------------------------");
        System.out.println("|                         |");
        System.out.println("|  1 añadir empleado      |");
        System.out.println("|  2 listar empleado      |");
        System.out.println("|  3 actualizar empleado  |");
        System.out.println("|  4 eliminar empleado    |");
        System.out.println("|  5 buscar empleado      |");
        System.out.println("|  6 cerrar programa      |");
        System.out.println("---------------------------");
    }

    private static void handleOption(int opcion) {
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
    }

    public static Empleado fillEmpleado() throws WrongValueException {
        Empleado empleado = new Empleado();

        System.out.println("nombre");
        empleado.setNombre(sc.nextLine());
        if (empleado.getNombre().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("apellido");
        empleado.setApellido(sc.nextLine());
        if (empleado.getApellido().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("cargo");
        empleado.setCargo(sc.nextLine());
        if (empleado.getCargo().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("salario 0.0");
        empleado.setSalario(Double.parseDouble(sc.nextLine()));
        System.out.println("fecha yyyy-mm-dd");
        empleado.setFechaInicio(LocalDate.parse(sc.nextLine()));

        return empleado;
    }

    public static Empleado fillEmpleado(Empleado empleado) throws WrongValueException {

        System.out.println("nombre");
        empleado.setNombre(sc.nextLine());
        if (empleado.getNombre().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("apellido");
        empleado.setApellido(sc.nextLine());
        if (empleado.getApellido().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("cargo");
        empleado.setCargo(sc.nextLine());
        if (empleado.getCargo().equals("")) {
            throw new WrongValueException();
        }
        System.out.println("salario 0.0");
        empleado.setSalario(Double.parseDouble(sc.nextLine()));
        System.out.println("fecha yyyy-mm-dd");
        empleado.setFechaInicio(LocalDate.parse(sc.nextLine()));

        return empleado;
    }

    public static boolean verifyEmpleado(Empleado verEmpleado) {
        boolean verified = false;
        boolean wrongValue;

        do {
            System.out.println("Is this correct? y/n");
            System.out.println(verEmpleado);
            String yesOrNo = sc.nextLine();

            if (yesOrNo.equalsIgnoreCase("y")) {
                verified = true;
                wrongValue = false;
            } else if (yesOrNo.equalsIgnoreCase("n")) {
                System.out.println("");
                wrongValue = false;
            } else {
                System.out.println("Error: valor incorrecto");
                wrongValue = true;
            }
        } while (wrongValue);

        return verified;
    }

    public static void addEmpleado() {
        boolean done = false;
        while (!done) {
            try {
                Empleado empleado = fillEmpleado();
                if (verifyEmpleado(empleado)) {
                    logicController.addEmpleado(empleado);
                    System.out.println("Empleado añadido");
                    done = true;
                }
            } catch (Exception e) {
                System.out.println("----!Wrong value or format!----");
                e.printStackTrace();
            }
        }
    }

    private static void listarEmpleado() {
        listaEmpleados().forEach(System.out::println);
    }

    public static List<Empleado> listaEmpleados() {
        return logicController.bringEmpleados();
    }

    private static void actualizarEmpleado() {
        System.out.println("id empleado a editar");
        int idEditar = Integer.parseInt(sc.nextLine());

        Empleado empleadoEdit = logicController.findEmpleado(idEditar);
        System.out.println("datos empleado: " + empleadoEdit);

        boolean done = false;
        while (!done) {
            try {
                empleadoEdit = fillEmpleado(empleadoEdit);
                if (verifyEmpleado(empleadoEdit)) {
                    logicController.editEmpleado(empleadoEdit);
                    System.out.println("Empleado editado");
                    done = true;
                }
            } catch (Exception e) {
                System.out.println("----!Wrong value or format!----");
                e.printStackTrace();
            }
        }
    }

    private static void eliminarEmpleado() {
        System.out.println("id empleado eliminar");
        int idEliminar = Integer.parseInt(sc.nextLine());
        Empleado empleado = logicController.findEmpleado(idEliminar);

        if (verifyEmpleado(empleado)) {
            logicController.destroyEmpleado(idEliminar);
            System.out.println("Se ha eliminado el empleado");
        } else {
            System.out.println("No se ha eliminado el empleado");
        }
    }

    public static void findByCargo() {
        List<Empleado> empleados = listaEmpleados();
        System.out.println("Cargo a buscar:");
        String cargo = sc.nextLine();
        List<Empleado> empleadosPorCargo = empleados.stream()
                .filter(e -> e.getCargo().equalsIgnoreCase(cargo))
                .collect(Collectors.toList());
        if(empleadosPorCargo.size()==0)
            System.out.println("No se encuentran empleados con el cargo: " + cargo);

        empleadosPorCargo.forEach(System.out::println);
    }
}
