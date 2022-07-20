
package tienda;

import tienda.servicios.Menu;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        try {
            Menu.menu();
        } catch (Exception e) {
            throw e;
//            e.printStackTrace();
        }

    }

}
