package utap.edu.arqui_01;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ender
 */
public class Arqui_01 extends JPanel { //CLASS

    // VARIABLES X1 Y X2
    private final int[][] lineas;

    // CONSTRUCTOR 
    public Arqui_01(int[][] lineas) { // inicio constr
        this.lineas = lineas;
    } // fin constructor

    // METODO DE LA CLASE GRAPHICS PARA PINTAR
    @Override
    public void paintComponent(Graphics g) { // Inicio Pintar
        super.paintComponent(g);
        /* Dibuja los ejes del plano separa el tamaño estableciendo las mitades 
        parte dese la mitad del plano como punto 0 
        Color del plano 
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
            int x1 = linea[0];
            int y1 = linea[1];
            int x2 = linea[2];
            int y2 = linea[3];
            g.drawLine(x1 + getWidth() / 2, -y1 + getHeight() / 2, x2 + getWidth() / 2, -y2 + getHeight() / 2);
        } // Fin For dibjar lineas
    } // Fin pintar Method

    public static void main(String[] args) { // MAIN CLASS

        //Pedir datos mediante JOPtion
        JOptionPane.showMessageDialog(null, "Bienvenido!\n" + "Sistema de prueba basado en desigualdades de ecuaciones!");

        JOptionPane.showMessageDialog(null, "Instrucciones:\n"
                + "PARA LAS ECUACIONES SE PEDIRAN INGRESAR SOLO LOS VALORES DE X1, X2, EL SIGNO ('más(+) o menos(-)') Y LA IGUALDAD \n"
                + "EJEMPLO SI LA ECUACION ES 3X1 + 2X2 ≥ 210 \n"
                + "PARA EL VALOR DE X1 INGRESE SOLO EL NUMERO 3"
                + " DESPÚES INGRESE EL SIGNO + Y POR ULTIMO 210 Y ASÍ HASTA INGRESAR LAS 3 ECUACIONES");

        // Varibale para caso de error reiniciar desde el inicio a pedir los datos nuevamente 
        boolean error = false;

        // VARIABLES GLOBALES 
        String mas = "";
        String menos = "";
        int valx1 = 0;
        int valx2 = 0;
        int signo = 0;
        int igual_1 = 0;
        int valx1_2 = 0;
        int signo_1 = 0;
        int signo_2 = 0;
        int valx2_2 = 0;
        int igual_2 = 0;
        int valx1_3 = 0;
        int valx2_3 = 0;
        while (error == false) {
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

                //Pedir el valor de la igualdad de la primera ecuación
                String aux_igual = JOptionPane.showInputDialog(null, "Ingrese el valor de la igualdad para la PRIMERA (RECUERDE LO QUE ESTÁ DESPÚES DE ≥ )");
                // Parseo del valor
                igual_1 = Integer.parseInt(aux_igual);

                //SEGUNDA ECUACIÓN 
                // Pedir el valor de X1 para la SEGUNDA ecuación
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

                //TERCERA ECUACIÓN 
                // Pedir el valor de X1 para la TERCERA ecuación
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
                int igual_3 = Integer.parseInt(aux_igual_2);

                // Se llenaron todos los datos sin error
                error = true;

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "DIJE SOLO EL NUMERO POR FAVOR INICIA DESDE LA RESTRICCION 1\n -HUMANO QUE NO LEE BIEN-");
                error = false;
            }// Fin catch error only number

            if (signo == 1) {
                mas = "+";
            } else if (signo == 2){
                menos = "-";
            }
            JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS FUERON: \n"
                    + "PRIMERA RESTRICCION: " + valx1 + "X1 " + mas +" "+ valx2 + "X2 ≥ " + igual_1);

        }

        // Proceso de calculos de los puntos de cada ecuación
        // Valores de prueba manual
        // Coordenadas de los puntos que definen la línea recta
        int[][] coordenadas = {
            {0, 80, 80, 0}, // Línea 1: 
            {0, 110, 73, 0}, // Línea 2:
            {0, 70, 105, 0} // Línea 3: 
        };

        // Crea y configura el marco
        JFrame frame = new JFrame("SISTEMA DE PRUEBA 😎");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agrega el panel con las líneas recta al marco
        frame.add(new Arqui_01(coordenadas));
        // Establece el tamaño del marco
        frame.setSize(400, 400);
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

}// CLASS 
