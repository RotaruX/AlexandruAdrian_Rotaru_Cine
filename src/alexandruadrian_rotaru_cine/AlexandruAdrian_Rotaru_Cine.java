/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alexandruadrian_rotaru_cine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class AlexandruAdrian_Rotaru_Cine {

    static Scanner sc = new Scanner(System.in);
    static char[][] sala1;
    static char[][] sala2;
    static String pelicula1, pelicula2;
    static int mitadSala1, mitadSala2;

    public static void main(String[] args) {
        System.out.println("Configuracion de las salas para hoy");
        Fecha();
        for (int i = 1; i <= 2; i++) {
            Teclado(i);
        }

        Rellenar();
        Menu();
    }

    //Muestra la fecha de hoy
    public static void Fecha() {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter ESP = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaActual = fecha.format(ESP);
        System.out.println(fechaActual);
        System.out.println("Sesión 22:30");
        System.out.println();
    }

    //Pedir por teclado
    public static void Teclado(int i) {
        int filas, butacas;
        System.out.println("Sala " + i);
        do {
            System.out.print("Número de filas: -> ");
            filas = sc.nextInt();
        } while (filas <= 0);
        do {
            System.out.print("Butacas por filas: -> ");
            butacas = sc.nextInt() + 1;
        } while (butacas <= 1 || butacas % 2 == 0);
        sc.nextLine();
        if (i == 1) {
            System.out.print("Pelicula de la Sala 1: ");
            pelicula1 = sc.nextLine();
            mitadSala1 = butacas / 2 + 1;
            sala1 = new char[filas][butacas];
        } else {
            System.out.print("Pelicula de la Sala 2: ");
            pelicula2 = sc.nextLine();
            mitadSala2 = butacas / 2 + 1;
            sala2 = new char[filas][butacas];
        }
        System.out.println();
    }

    //Rellena los arrays
    public static void Rellenar() {
        for (int i = 0; i < sala1.length; i++) {
            for (int j = 0; j < sala1[i].length; j++) { // Cambiado i++ por j++
                if (j == mitadSala1 - 1) {
                    sala1[i][j] = ' '; // Pasillo central
                } else {
                    sala1[i][j] = '_'; // Butacas disponibles
                }
            }
        }

        for (int i = 0; i < sala2.length; i++) {
            for (int j = 0; j < sala2[i].length; j++) { // Cambiado i++ por j++
                if (j == mitadSala2 - 1) {
                    sala2[i][j] = ' '; // Pasillo central
                } else {
                    sala2[i][j] = '_'; // Butacas disponibles
                }
            }
        }
    }
    
    // Menú con las diferentes opciones
    public static void Menu() {
        int opcion;
        do {
            do {
                System.out.println("1. Mostrar salas");
                System.out.println("2. Vender entrada");
                System.out.println("0. FIN");
                System.out.print("Opción -> ");
                opcion = sc.nextInt();
            } while (opcion != 1 && opcion != 2 && opcion != 0);

            switch (opcion) {
                case 1 ->
                    Mostrar();
                case 2 ->
                    Vender();
                case 0 ->
                    System.out.println("Final del programa");
            }
        } while (opcion != 0);
    }

    // Opción mostrar salas
    public static void Mostrar() {
        // Mostrar sala 1
        System.out.println("SALA 1 -> " + pelicula1);
        for (int i = 0; i < sala1.length; i++) {
            // Imprimir número de fila
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < sala1[i].length; j++) {
                if (j == mitadSala1 - 1) {
                    System.out.print(" ");
                }
                System.out.print(sala1[i][j] + " ");
            }
            System.out.println(); 
        }

        // Imprimir números de butacas
        System.out.print("   "); 
        for (int j = 0; j < sala1[0].length; j++) {
            if (j == mitadSala1 - 1) {
                System.out.print("   "); 
            } else if (j < mitadSala1 - 1) {
                System.out.print((j + 1) + " ");
            }else{
                System.out.print(j + " ");
            }
        }
        System.out.println("\n");

        // Mostrar sala 2
        System.out.println("SALA 2 -> " + pelicula2);
        for (int i = 0; i < sala2.length; i++) {
            // Imprimir número de fila
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < sala2[i].length; j++) {
                if (j == mitadSala2 - 1) {
                    System.out.print("  "); 
                }
                System.out.print(sala2[i][j] + " ");
            }
            System.out.println(); 
        }

        // Imprimir números de butacas
        System.out.print("   "); 
        for (int j = 0; j < sala2[0].length; j++) {
            if (j == mitadSala2 - 1) {
                System.out.print("   "); 
            } else if (j < mitadSala2 - 1) {
                System.out.print((j + 1) + " ");
            }else{
                System.out.print(j + " ");
            }
        }
        System.out.println("\n");
        System.out.println();
    }

    //Venta de entrada
    public static void Vender() {

    }
}
