import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;



public class Index {

	public static void main(String[] args) {
	
        HashMap<Integer, Mascota> mapaMascotas = new HashMap<>();

        int rep;
        int codigo = 1;

        do {
            Mascota mascota = new Mascota();
            mascota.ingresar();
            mapaMascotas.put(codigo, mascota);
            codigo++;

            rep = JOptionPane.showConfirmDialog(null, "�Desea ingresar otra mascota?", "Confirmaci�n", JOptionPane.YES_NO_OPTION);
        } while (rep == JOptionPane.YES_OPTION);

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n" +
                    "1. Consultar mascota individualmente\n" +
                    "2. Consultar lista de mascotas\n" +
                    "3. Salir\n\n" +
                    "Ingrese la opci�n deseada"));

            switch (opcion) {
                case 1:
                    int codigoMascota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el c�digo de la mascota a consultar"));
                    Mascota mascota = mapaMascotas.get(codigoMascota);
                    if (mascota != null) {
                        System.out.println("Informaci�n de la mascota:");
                        mascota.mostrarInformacion();
                        System.out.println("-------------------");
                    } else {
                        System.out.println("No se encontr� ninguna mascota con el c�digo especificado.");
                    }
                    break;
                case 2:
                    System.out.println("Lista de mascotas:");
                    for (Mascota m : mapaMascotas.values()) {
                        m.mostrarInformacion();
                        System.out.println("-------------------");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opci�n inv�lida. Por favor, seleccione una opci�n v�lida.");
            }
        } while (opcion != 3);
    }
}

