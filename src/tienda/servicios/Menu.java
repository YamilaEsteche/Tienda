/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import Libreria.LimpiarPantalla;
import java.util.Scanner;
import tienda.persistencia.ProductoDAO;


public class Menu {

    public static void menu() throws Exception{
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int selectorInt;
        String selectorString = "";

        try {

            do {
                do {
                    System.out.println("Ingrese un valor:"
                            + "\n1- Nombre de los productos."
                            + "\n2- Nombre y precio de los productos."
                            + "\n3- Productos con precio entre 120 y 202."
                            + "\n4- Todos los Portátiles de la tabla producto. "
                            + "\n5- Nombre y el precio del producto más barato. "
                            + "\n6- Ingresar un producto."
                            + "\n7- Ingresar un fabricante."
                            + "\n8- Editar un producto."
                            + "\n9- Salir");
                    selectorInt = leer.nextInt();
                } while (!(selectorInt > 0 && selectorInt < 10));

                switch (selectorInt) {
                    case 1:
                        ProductoDAO.mostrarListaPorPantalla();
                        LimpiarPantalla.limpiarConAviso();
                        break;
                    case 2:

                        LimpiarPantalla.limpiarConAviso();
                        break;
                    case 3:

                        LimpiarPantalla.limpiarConAviso();
                        break;
                    case 4:
                        System.out.println("Seguro que desea salir? Y/N");
                        selectorString = leer.next();
                    default:
                        System.out.println("No ha ingresado un valor válido.");
                        LimpiarPantalla.limpiarConAviso();
                }

            } while (!selectorString.equalsIgnoreCase("Y"));

        } catch (Exception e) {
            throw e;
        }
    }
}
