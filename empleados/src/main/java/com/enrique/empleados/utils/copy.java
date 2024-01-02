package com.enrique.empleados.utils;

import com.enrique.empleados.entities.Empleado;
import com.enrique.empleados.entities.LogicController;
import com.enrique.empleados.exceptions.WrongValueException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class copy {
//public class EmpleadosUtils {

    
    static Scanner sc = new Scanner(System.in);

    public static void menu() {

        int opcion = 0;
        do {
            printMenu();

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    addEmpleado();
                }
                case 2 -> {
                    listarEmpleado();
                }
                case 3 -> {
                    actualizarEmpleado();
                }
                case 4 -> {
                    eliminarEmpleado();
                }
                case 5 -> {
                    findByCargo();
                }
                case 6 ->
                    System.out.println("Gracias por usar nuestro programa");
                default ->
                    System.out.println("Error");
            }
        } while (opcion != 6);

    }

    private static void printMenu() {
        System.out.println("---------------------------");
        System.out.println("|                         |");
        System.out.println("|  1 añadir empleado      |");
        System.out.println("|                         |");
        System.out.println("|  2 listar empleado      |");
        System.out.println("|                         |");
        System.out.println("|  3 actualizar empleado  |");
        System.out.println("|                         |");
        System.out.println("|  4 eliminar empleado    |");
        System.out.println("|                         |");
        System.out.println("|  5 buscar empleado      |");
        System.out.println("|                         |");
        System.out.println("|  6 cerrar programa      |");
        System.out.println("|                         |");
        System.out.println("---------------------------");

    }

    public static Empleado fillEmpleado() throws WrongValueException {

        Empleado empleadoFull = new Empleado();

        System.out.println("nombre");
        empleadoFull.setNombre(sc.nextLine());
        System.out.println("apellido");
        empleadoFull.setApellido(sc.nextLine());
        System.out.println("cargo");
        empleadoFull.setCargo(sc.nextLine());
        System.out.println("salario 0.0");
        empleadoFull.setSalario(Double.parseDouble(sc.nextLine()));
        System.out.println("fecha yyyy-mm-dd");
        empleadoFull.setFechaInicio(LocalDate.parse(sc.nextLine()));

        return empleadoFull;
    }

    public static Empleado fillEmpleado(Empleado empleadoFull) throws WrongValueException {

        System.out.println("nombre");
        empleadoFull.setNombre(sc.nextLine());
        System.out.println("apellido");
        empleadoFull.setApellido(sc.nextLine());
        System.out.println("cargo");
        empleadoFull.setCargo(sc.nextLine());
        System.out.println("salario 0.0");
        empleadoFull.setSalario(Double.parseDouble(sc.nextLine()));
        System.out.println("fecha yyyy-mm-dd");
        empleadoFull.setFechaInicio(LocalDate.parse(sc.nextLine()));

        return empleadoFull;
    }

    public static boolean verifyEmpleado(Empleado verEmpleado) {
        boolean verified = false;
        boolean wrongValue = false;
        do {
            System.out.println("is this correct? y/n");
            System.out.println(verEmpleado);
            String yesOrNo = sc.nextLine();
            System.out.println(yesOrNo);

            if (yesOrNo.equalsIgnoreCase("y")) {
                verified = true;
                wrongValue = false;
            } else if (yesOrNo.equalsIgnoreCase("n")) {
                System.out.println("");
                wrongValue = false;
            } else {
                System.out.println("error valor incorrecto");
                wrongValue = true;
            }
        } while (wrongValue);
        return verified;
    }

    public static void addEmpleado() {
        boolean done = false;
        while (!done) {
            LogicController lControl = new LogicController();
            Empleado empleado;
            try {
                do {
                    empleado = fillEmpleado();
                } while (!verifyEmpleado(empleado));
                lControl.addEmpleado(empleado);
                System.out.println("Empleado añadido");
                done = true;
            } catch (Exception e) {
                System.out.println("----!Wrong value or format!----");
                e.printStackTrace();
            }
        }
    }

    private static void listarEmpleado() {

        List<Empleado> listaEmpleados = listaEmpleados();
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.toString());
        }
    }

    public static List<Empleado> listaEmpleados() {
        LogicController lControl = new LogicController();

        List<Empleado> listaEmpleados = lControl.bringEmpleados();

        return listaEmpleados;
    }

    private static void actualizarEmpleado() {
        LogicController lControl = new LogicController();

        System.out.println("id empleado a editar");
        int idEditar = Integer.parseInt(sc.nextLine());

        Empleado empleadoEdit = lControl.findEmpleado(idEditar);
        System.out.println("datos empleado: " + empleadoEdit);

        boolean done = false;
        while (!done) {
            try {
                do {
                    empleadoEdit = fillEmpleado(empleadoEdit);
                } while (!verifyEmpleado(empleadoEdit));
                lControl.editEmpleado(empleadoEdit);
                System.out.println("Empleado editado");
                done = true;
            } catch (Exception e) {
                System.out.println("----!Wrong value or format!----");
                e.printStackTrace();
            }

        }
    }

    private static void eliminarEmpleado() {
        LogicController lControl = new LogicController();
        System.out.println("id empleado eliminar");
        int idEliminar = Integer.parseInt(sc.nextLine());
        Empleado empleado = lControl.findEmpleado(idEliminar);

        if (verifyEmpleado(empleado)) {
            lControl.destroyEmpleado(idEliminar);
            System.out.println("se ha eliminado el empleado");
        } else {
            System.out.println("No se ha eliminado el empleado");
        }
    }

    public static void findByCargo() {

        List<Empleado> empleados = listaEmpleados();
        System.out.println("Cargo a busca:");
        String cargo = sc.nextLine();
        List<Empleado> empleadosPorCargos = empleados.stream()
                .filter(e -> e.getCargo().equals(cargo))
                .collect(Collectors.toList());
        for (Empleado empleado : empleadosPorCargos) {
            System.out.println(empleado);
        }
    }
}
