package utap.edu.arqui_01;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author ender
 */
public class Arqui_01 extends JPanel { //CLASS

    // VARIABLES X1 Y X2
    private final int[][] lineas;
    // Variable ´para los colores y nombres
    private Map<String, Color> colores;

    // CONSTRUCTOR 
    public Arqui_01(int[][] lineas, Map<String, Color> colores) { // inicio constr
        this.lineas = lineas;
        this.colores = colores;
    } // fin constructor

    // METODO DE LA CLASE GRAPHICS PARA PINTAR
    @Override
    public void paintComponent(Graphics g) { // Inicio Pintar
        super.paintComponent(g);
        /* Dibuja los ejes del plano separa el tamaño estableciendo las mitades 
        * parte dese la mitad del plano como punto 0 
        * Color del plano 
         */
        g.setColor(Color.BLACK);
        // Eje x
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        // Eje y
        g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());

        // Color de la línea de la función
        g.setColor(Color.RED);
        // Dibuja las líneas recta en el plano cartesiano
        for (int i = 0; i < lineas.length; i++) {
            int[] linea = lineas[i];
            String nombre = "Restriccion " + (i + 1);
            if (colores.containsKey(nombre)) {
                g.setColor(colores.get(nombre));
            } else {
                g.setColor(Color.RED);
            }
            int x1 = linea[0];
            int y1 = linea[1];
            int x2 = linea[2];
            int y2 = linea[3];

            // Dibuja el plano por la mitad
            g.drawLine(x1 + getWidth() / 2, -y1 + getHeight() / 2, x2 + getWidth() / 2, -y2 + getHeight() / 2);

            // Dibuja los nombres
            //int offset = i * 20; // aumenta el valor del eje Y para que los nombres no se peguen
            g.drawString(nombre, x2 + getWidth() / 2 + 5, -y2 + getHeight() / 2 - 5);
        } // Fin For dibjar lineas
    } // Fin pintar Method

    public static void main(String[] args) { // MAIN CLASS

        //Pedir datos mediante JOPtion
        JOptionPane.showMessageDialog(null, "Bienvenido! Sistema de prueba basado en desigualdades de ecuaciones! \n" + "Instrucciones:\n"
                + "PARA LAS RESTRICCIONES SE PEDIRAN INGRESAR SOLO LOS VALORES DE X1, X2, EL SIGNO más(+) o menos(-) Y LA IGUALDAD \n"
                + "EJEMPLO SI LA RESTRICCION ES 3X1 + 2X2 ≥ 210 \n"
                + "PARA EL VALOR DE X1 INGRESE SOLO EL NUMERO 3"
                + " DESPÚES INGRESE EL SIGNO + Y POR ULTIMO 210 Y ASÍ HASTA INGRESAR LAS 3 RESTRICCIONES");

        // Varibale para caso de error reiniciar desde el inicio a pedir los datos nuevamente 
        boolean error = false;
        // Variable para saber que operacion hacer depende del signo
        boolean flag = false;

        // VARIABLES GLOBALES 
        String mas = "";
        String menos = "";
        String mayorQ = "";
        String menorQ = "";
        String igualQ = "";
        int valx1 = 0;
        int valx2 = 0;
        int signo = 0;
        int signoIgual = 0;
        int igual_1 = 0;
        int valx1_2 = 0;
        int signo_1 = 0;
        int signo_2 = 0;
        int valx2_2 = 0;
        int igual_2 = 0;
        int valx1_3 = 0;
        int valx2_3 = 0;
        int igual_3 = 0;

        while (error == false) { // Apertura ciclo While
            try {// VALIDACIONES PARA ENTRADA DE DATOS

                // Pedir el valor de X1 para la primera ecuación
                String aux1 = JOptionPane.showInputDialog(null, "Ingrese el valor de X1 de la PRIMERA restriccion");
                // Parseo del valor a entero
                valx1 = Integer.parseInt(aux1);
                // Pedir el signo mediante menú interactivo y validador
                signo = pedirSigno();
                //Pedir el valor de X2 para la primera ecuación
                String aux2 = JOptionPane.showInputDialog(null, "Ingrese el valor de X2 de la PRIMERA restriccion");
                // Parseo del valor
                valx2 = Integer.parseInt(aux2);

                //Pedir el signo de igualdad
                //signoIgual = pedirIgualdad();
                //Pedir el valor de la igualdad de la primera ecuación
                String aux_igual = JOptionPane.showInputDialog(null, "Ingrese el valor de la igualdad para la PRIMERA (RECUERDE LO QUE ESTÁ DESPÚES DE ≥ ≤ = )");
                // Parseo del valor
                igual_1 = Integer.parseInt(aux_igual);
                /*
                *SEGUNDA ECUACIÓN 
                * Pedir el valor de X1 para la SEGUNDA ecuación
                 */
                String aux1_2 = JOptionPane.showInputDialog(null, "Ingrese el valor de X1 de la SEGUNDA restriccion");
                // Parseo del valor a entero
                valx1_2 = Integer.parseInt(aux1_2);
                // Pedir el signo mediante menú interactivo y validador
                signo_1 = pedirSigno();
                //Pedir el valor de X2 para la SEGUNDA ecuación
                String aux2_2 = JOptionPane.showInputDialog(null, "Ingrese el valor de X2 de la SEGUNDA restriccion");
                // Parseo del valor
                valx2_2 = Integer.parseInt(aux2_2);
                //Pedir el valor de la igualdad de la SEGUNDAA ecuación
                String aux_igual_1 = JOptionPane.showInputDialog(null, "Ingrese el valor de la igualdad para la SEGUNDA (RECUERDE LO QUE ESTÁ DESPÚES DE ≥ )");
                // Parseo del valor
                igual_2 = Integer.parseInt(aux_igual_1);

                /*
                *
                * TERCERA ECUACIÓN 
                * Pedir el valor de X1 para la TERCERA ecuación
                 */
                String aux1_3 = JOptionPane.showInputDialog(null, "Ingrese el valor de X1 de la TERCERA restriccion");
                // Parseo del valor a entero
                valx1_3 = Integer.parseInt(aux1_3);
                // Pedir el signo mediante menú interactivo y validador
                signo_2 = pedirSigno();
                //Pedir el valor de X2 para la primera ecuación
                String aux2_3 = JOptionPane.showInputDialog(null, "Ingrese el valor de X2 de la TERCERA restriccion");
                // Parseo del valor
                valx2_3 = Integer.parseInt(aux2_3);
                //Pedir el valor de la igualdad de la primera ecuación
                String aux_igual_2 = JOptionPane.showInputDialog(null, "Ingrese el valor de la igualdad de la TERCERA (RECUERDE LO QUE ESTÁ DESPÚES DE ≥ )");
                // Parseo del valor
                igual_3 = Integer.parseInt(aux_igual_2);
                // Se llenaron todos los datos sin error
                error = true;

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "DIJE SOLO EL NUMERO POR FAVOR INICIA DESDE LA RESTRICCION 1\n -HUMANO QUE NO LEE BIEN-");
                error = false;
            }// Fin catch error only number

        } // Fin ciclo While

        // Switch para el signo de igualdad
        switch (signoIgual) { // Apertura switch
            case 1:
                mayorQ = "≥";

                break;
            case 2:
                menorQ = "≤";
            default:
                igualQ = "=";
        } // Fin sentencia switch

        // Armar las restricciones completas para mostrarlas post 
        // No se me ocurre otra forma xd
        if (signo == 1) {

            flag = true;
            mas = "+";
            // Imprime la ecuación con el signo mas
            JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS FUERON: \n"
                    + "PRIMERA RESTRICCION: " + valx1 + "X1 " + mas + " " + valx2 + "X2 ≤ " + igual_1);
        } else {
            flag = false;
            menos = "-";
            JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS FUERON: \n"
                    + "PRIMERA RESTRICCION: " + valx1 + "X1 " + menos + " " + valx2 + "X2 ≤ " + igual_1);

        }
        /*else if (signo == 2 && signoIgual == 1) {
            flag = false;
            menos = "-";
            JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS FUERON: \n"
                    + "PRIMERA RESTRICCION: " + valx1 + "X1 " + menos + " " + valx2 + "X2 " +mayorQ +" "+ + igual_1);

        }
         */
        // fin else forma 1
        //Segunda
        if (signo_1 == 1) {

            flag = true;
            mas = "+";
            // Imprime la ecuación con el signo mas
            JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS FUERON: \n"
                    + "PRIMERA RESTRICCION: " + valx1_2 + "X1 " + mas + " " + valx2_2 + "X2 ≤ " + igual_2);
        } else {
            flag = false;
            menos = "-";
            JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS FUERON: \n"
                    + "SEGUNDA RESTRICCION: " + valx1_2 + "X1 " + menos + " " + valx2_2 + "X2 ≤ " + igual_2);

        } // fin else forma 2
        // tercera
        if (signo_2 == 1) {

            flag = true;
            mas = "+";
            // Imprime la ecuación con el signo mas
            JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS FUERON: \n"
                    + "TERCERA RESTRICCION: " + valx1_3 + "X1 " + mas + " " + valx2_3 + "X2 ≤ " + igual_3);
        } else {
            flag = false;
            menos = "-";
            JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS FUERON: \n"
                    + "TERCERA RESTRICCION: " + valx1_3 + "X1 " + menos + " " + valx2_3 + "X2 ≤ " + igual_3);

        } // fin else forma 2

        /* Proceso de calculos de los puntos de cada ecuación
        * 
        * Primera restriccion igualando x1 a 0 y x2 a 0
         */
        float aux_x1 = 0;
        float aux_y1 = 0;
        int puntoCoordex1R1 = 0;
        int puntoCoordey1R1 = 0;
        int puntoCoordex2R1 = 0;
        int puntoCoordey2R1 = 0;
        puntoCoordex1R1 = (valx1 * 0);
        puntoCoordey1R1 = Math.round(igual_1 / valx2);
        puntoCoordex2R1 = (Math.round(igual_1 / valx1));
        puntoCoordey2R1 = (valx2 * 0);

        /* Proceso de calculos de los puntos de cada ecuación
        * 
        * Segunda restriccion igualando x1 a 0 
         */
        int puntoCoordex1R2 = 0;
        int puntoCoordey1R2 = 0;
        int puntoCoordex2R2 = 0;
        int puntoCoordey2R2 = 0;
        puntoCoordex1R2 = (valx1_2 * 0);
        puntoCoordey1R2 = Math.round(igual_2 / valx2_2);
        puntoCoordex2R2 = (Math.round(igual_2 / valx1_2));
        puntoCoordey2R2 = (valx2_2 * 0);

        /* Proceso de calculos de los puntos de cada ecuación
        * 
        * Tercera restriccion igualando x1 a 0 
         */
        int puntoCoordex1R3 = 0;
        int puntoCoordey1R3 = 0;
        int puntoCoordex2R3 = 0;
        int puntoCoordey2R3 = 0;
        puntoCoordex1R3 = (valx1_3 * 0);
        puntoCoordey1R3 = Math.round(igual_3 / valx2_3);
        puntoCoordex2R3 = (Math.round(igual_3 / valx1_3));
        puntoCoordey2R3 = (valx2_3 * 0);

        //Coordenadas de los puntos que definen la línea recta
        JOptionPane.showMessageDialog(null, "Los puntos de las restricciones son: \n"
                + "RESTRICCION 1: (" + puntoCoordex1R1 + "," + puntoCoordey1R1 + ") Y (" + puntoCoordex2R1 + "," + puntoCoordey2R1 + ") \n"
                + "RESTRICCION 2: (" + puntoCoordex1R2 + "," + puntoCoordey1R2 + ") Y (" + puntoCoordex2R2 + "," + puntoCoordey2R2 + ") \n"
        +"RESTRICCION 3: (" + puntoCoordex1R3 + "," + puntoCoordey1R3 + ") Y (" + puntoCoordex2R3 + "," + puntoCoordey2R3 +")");
        int[][] coordenadas = {
            {puntoCoordex1R1, puntoCoordey1R1, puntoCoordex2R1, puntoCoordey2R1}, // Línea 1: 
            {puntoCoordex1R2, puntoCoordey1R2, puntoCoordex2R2, puntoCoordey2R2}, // Línea 2:
            {puntoCoordey2R3, puntoCoordey1R3, puntoCoordex2R3, puntoCoordey2R3} // Línea 3: 
        };

        // Colores de las lineas y nombres 
        Map<String, Color> colores = new HashMap<>();
        colores.put("Restriccion 1", Color.RED);
        colores.put("Restriccion 2", Color.BLUE);
        colores.put("Restriccion 3", Color.GREEN);
        // Crea y configura el marco
        JFrame frame = new JFrame("SISTEMA DE PRUEBA 😎");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agrega el panel con las líneas recta al marco
        frame.add(new Arqui_01(coordenadas, colores));
        // Establece el tamaño del marco
        frame.setSize(600, 600);
        // Hace visible el marco
        frame.setVisible(true);

    }// MAIN CLASS

    // Metodo reciclabe para ingresar el signo
    public static int pedirSigno() {
        int signo = 0;
        do {
            String aux_sig = JOptionPane.showInputDialog(null, "Por favor escoja el signo de las opciones: \n"
                    + " 1 para (+) (más) \n"
                    + " 2 para (-) (menos)");
            try {
                // Convierte el signo para tratamiento mejor
                signo = Integer.parseInt(aux_sig);
            } catch (NumberFormatException e) {
                // Si la entrada no es un número, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }
        } while (signo != 2 && signo != 1);

        return signo;
    }

    public static int pedirIgualdad() {
        int signo = 0;
        do {
            String aux_sig = JOptionPane.showInputDialog(null, "Por favor escoja el signo de la igualdad: \n"
                    + " 1 para (≥) (mayor o igual) \n"
                    + " 2 para (≤) (menor o igual)"
                    + " 3 para (=) (igual)");
            try {
                // Convierte el signo para tratamiento mejor
                signo = Integer.parseInt(aux_sig);
            } catch (NumberFormatException e) {
                // Si la entrada no es un número, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }
        } while (signo != 2 && signo != 1 && signo != 3);

        return signo;
    }
}// CLASS 
