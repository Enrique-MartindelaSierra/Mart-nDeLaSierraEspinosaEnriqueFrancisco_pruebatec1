package com.enrique.gestorempleados;

import com.enrique.gestorempleados.entities.Empleado;
import com.enrique.gestorempleados.entities.LogicController;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GestorEmpleados {

    public static void main(String[] args) {

        menu();

//        LogicController lControl = new LogicController();
//
//        /*PROCESO DE ALTAS*/
//        System.out.println("--------REALIZANDO LAS ALTAS--------");
//        Empleado empleado1 = new Empleado(1, "Enrique", "Martin de la Sierra", "Programador Junior", 18000.00, LocalDate.of(2020, 1, 22));
//        lControl.crearEmpleado(empleado1);
//        Empleado empleado2 = new Empleado(1, "Enrique", "Martin de la Sierra", "Programador Junior", 18000.00, LocalDate.of(2020, 1, 22));
//        lControl.crearEmpleado(empleado2);
//
//        /*PROCESO DE ELIMINACIÓN*/
//        System.out.println("--------ELIMINANDO REGISTRO 2--------");
//        int idEliminar = 2;
//        lControl.eliminarEmpleado(idEliminar);
//
//        /*PROCESO DE EDICIÓN*/
//        System.out.println("--------EDITANDO REGISTRO 3--------");
//        int idEditar = 3;
//        Empleado empleadoEdit = lControl.buscarEmpleado(idEditar);
//        empleadoEdit.setSalario(30000.0);
//        
//        lControl.editarEmpleado(empleadoEdit);
//
//        /*PROCESO DE LECTURA*/
//        System.out.println("--------LISTA FINAL DE PLATILLOS--------");
//        List<Empleado> listaEmpleados = lControl.traerEmpleados();
//        
//        for (Empleado empleado : listaEmpleados) {
//            System.out.println(empleado.toString());
//        }
    }

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            printMenu();

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    añadirEmpleado();
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
                    buscarEmpleado();
                }
                case 6 ->
                    System.out.println("Gracias por usar nuestro programa");
                default ->
                    System.out.println("Error");
            }
        } while (opcion != 6);
        sc.close();

    }

    public static void validarEmpleado() {
    }

    public static void validarLista() {
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

    /**separar en funciones*/
    private static void añadirEmpleado() {
        Scanner sc = new Scanner(System.in);

        boolean done;
        do {
            done = false;
            Empleado empleadoAdd = new Empleado();

            System.out.println("nombre");
            empleadoAdd.setNombre(sc.nextLine());
            System.out.println("apellido");
            empleadoAdd.setApellido(sc.nextLine());
            System.out.println("cargo");
            empleadoAdd.setCargo(sc.nextLine());
            System.out.println("salario 0.0");
            empleadoAdd.setSalario(Double.parseDouble(sc.nextLine()));
            System.out.println("fecha yyyy-mm-dd");
            empleadoAdd.setFechaInicio(LocalDate.parse(sc.nextLine()));

            System.out.println("is this correct? y/n");
            System.out.println(empleadoAdd);
            String sino = sc.nextLine();
            System.out.println(sino);

            if (sino.equals("y")) {
                LogicController lControl = new LogicController();
                lControl.crearEmpleado(empleadoAdd);
                System.out.println("empleado añadido");
                done = true;
            } else if (sino.equals("n")) {
                System.out.println("repetir? y/n");
                String sino2 = sc.nextLine();
                if (sino2.equals("n")) {
                    done = true;
                }

            } else {
                System.out.println("error");
            }
            System.out.println(done);

        } while (done == false);

       // sc.close();
    }

    private static void listarEmpleado() {
        
        System.out.println("entra");
        LogicController lControl = new LogicController();
        
        List<Empleado> listaEmpleados = lControl.traerEmpleados();
        
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.toString());
        }
        System.out.println("sale");
    }

    private static void actualizarEmpleado() {
                Scanner sc = new Scanner(System.in);
LogicController lControl = new LogicController();
        
        System.out.println("id empleado a editar");        
        int idEditar = Integer.parseInt(sc.nextLine());
        
        Empleado empleadoEdit = lControl.buscarEmpleado(idEditar);
        System.out.println("datos empleado: " + empleadoEdit);
        
        //aqui poner funcion que sea rellenar dtos y compartir entre add y edit
        
        lControl.editarEmpleado(empleadoEdit);
    }

    private static void eliminarEmpleado() {
                        Scanner sc = new Scanner(System.in);
LogicController lControl = new LogicController();

        
                System.out.println("id empleado eliminae");
        int idEliminar = Integer.parseInt(sc.nextLine());
        lControl.eliminarEmpleado(idEliminar);
    }

    private static void buscarEmpleado() {
                                Scanner sc = new Scanner(System.in);

        
         System.out.println("entra");
        LogicController lControl = new LogicController();
        
        List<Empleado> listaEmpleados = lControl.traerEmpleados();
        System.out.println("cargo buscar");
        String cargoBuscar = sc.nextLine();
                
        //funcion para buscar como pipe
        
        for (Empleado empleado : listaEmpleados) {
            
            System.out.println(empleado.toString());
        }
        
        System.out.println("sale");
    }

}
