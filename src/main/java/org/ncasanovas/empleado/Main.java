package org.ncasanovas.empleado;

public class Main {
    public static void main(String[] args) {


        // Empleado Bueno

        EmpleadoTablaDB empleadoTablaDBBueno = new EmpleadoTablaDB();
        empleadoTablaDBBueno.setApellido("Smithers");
        empleadoTablaDBBueno.setNombre("Waylon");
        empleadoTablaDBBueno.setTipo(TipoEmpleado.BUENO);

        Empleado empleadoBueno = obtenerEmpleado(empleadoTablaDBBueno);

        System.out.println("Nombre del empleado bueno: " + empleadoBueno.getNombre());
        System.out.println("Apellido del empleado bueno: " + empleadoBueno.getApellido());


        //Empleado Malo

        EmpleadoTablaDB empleadoTablaDBMalo = new EmpleadoTablaDB();
        empleadoTablaDBMalo.setApellido("Simpson");
        empleadoTablaDBMalo.setNombre("Homero");
        empleadoTablaDBMalo.setTipo(TipoEmpleado.MALO);


        Empleado empleadoMalo = obtenerEmpleado(empleadoTablaDBMalo);


        System.out.println("Nombre del empleado malo: " + empleadoMalo.getNombre());
        System.out.println("Apellido del empleado malo: " + empleadoMalo.getApellido());


        //Empleado Nuevo

        EmpleadoTablaDB empleadoTablaDBNuevo = new EmpleadoTablaDB();
        empleadoTablaDBNuevo.setApellido("Carlson");
        empleadoTablaDBNuevo.setNombre("Carl");


        Empleado empleadoNuevo = obtenerEmpleado(empleadoTablaDBNuevo);

        System.out.println("Nombre del empleado nuevo: " + empleadoNuevo.getNombre());
        System.out.println("Apellido del empleado nuevo: " + empleadoNuevo.getApellido());

    }

    public static Empleado obtenerEmpleado(EmpleadoTablaDB empleadoDB) {
        try {
            if ("MALO".equals(empleadoDB.getTipo().toString())) {
                EmpleadoMalo homero = new EmpleadoMalo();
                homero.setNombre(empleadoDB.getNombre());
                homero.setApellido(empleadoDB.getApellido());
                homero.setSoloEmpleadoMalo(empleadoDB.getSoloEmpleadoMalo());
                return homero;
            } else if ("BUENO".equals(empleadoDB.getTipo().toString())) {
                EmpleadoBueno smithers = new EmpleadoBueno();
                smithers.setNombre(empleadoDB.getNombre());
                smithers.setApellido(empleadoDB.getApellido());
                smithers.setSoloEmpleadoBueno(empleadoDB.getSoloEmpleadoBueno());
                return smithers;
            }
        } catch (Exception e) {

            EmpleadoNuevo nuevo = new EmpleadoNuevo();
            nuevo.setNombre(empleadoDB.getNombre());
            nuevo.setApellido(empleadoDB.getApellido());
            return nuevo;
        }

        return null;
    }


}