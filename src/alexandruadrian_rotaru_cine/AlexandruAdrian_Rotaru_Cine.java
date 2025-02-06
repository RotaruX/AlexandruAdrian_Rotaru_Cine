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
    static LocalDate fecha = LocalDate.now();
    static DateTimeFormatter ESP = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
    static String fechaActual = fecha.format(ESP);
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
            if (filas <= 0){
                System.out.println("Debe haber minimo 1 fila");
            }
        } while (filas <= 0);
        do {
            System.out.print("Butacas por filas: -> ");
            butacas = sc.nextInt();
            if (butacas <= 1 || butacas % 2 != 0){
                System.out.println("Debe haber minimo 2 butacas y debe ser par ");
            }
        } while (butacas <= 2 || butacas % 2 != 0);
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
                sala1[i][j] = '_'; // Pasillo central
            }
        }

        for (int i = 0; i < sala2.length; i++) {
            for (int j = 0; j < sala2[i].length; j++) { // Cambiado i++ por j++
                    sala2[i][j] = '_';
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
                case 1:
                    MostrarSala1();
                    MostrarSala2();
                    break;
                case 2:
                    Vender();
                    break;
                case 0:
                    System.out.println("Final del programa");
                    break;
            }
        } while (opcion != 0);
    }

    public static void MostrarSala1() {
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
        for (int j = 1; j <= sala1[0].length; j++) {
            if (j == mitadSala1) {
                System.out.print(" ");
            }
            System.out.print(j % 10+ " ");
        }

        //imprimir decenas
        System.out.println();
        System.out.print("   ");
        for (int j = 1; j <= sala1[0].length; j++) {
            if (j == mitadSala1) {
                System.out.print(" ");
            }
            if (j >= 10 && j % 10 == 0) {
                System.out.print(j / 10 + " ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
    }

    // Opción mostrar salas
    public static void MostrarSala2() {
        // Mostrar sala 2
        System.out.println("\n SALA 2 -> " + pelicula2);
        for (int i = 0; i < sala2.length; i++) {
            // Imprimir número de fila
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < sala2[i].length; j++) {
                if (j == mitadSala2 - 1) {
                    System.out.print(" ");
                }
                System.out.print(sala2[i][j] + " ");
            }
            System.out.println();
        }

        // Imprimir números de butacas
        System.out.print("   ");
        for (int j = 1; j <= sala2[0].length; j++) {
            if (j == mitadSala2) {
                System.out.print(" ");
            }
            System.out.print(j % 10 + " ");
        }

        //imprimir decenas
        System.out.println();
        System.out.print("   ");
        for (int j = 1; j <= sala2[0].length; j++) {
            if (j == mitadSala2) {
                System.out.print(" ");
            }
            if (j >= 10 && j % 10 == 0) {
                System.out.print(j / 10 + " ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
        System.out.println();
    }

    //Venta de entrada
    public static void Vender() {
        int sala, fila, butaca;
        System.out.println("Venta de entradas");
        do {
            System.out.print("Introduce sala: ");
            sala = sc.nextInt();
            if (sala > 2 || sala < 1){
                System.out.println("Sala inexistente");
            }
        } while (sala > 2 || sala < 1);

        if (sala == 1) {
            MostrarSala1();
            do {
                System.out.print("Fila-> ");
                fila = sc.nextInt();
                if (fila > sala1.length){
                    System.out.println("Hay " + sala1.length + " filas");
                }
            } while (fila > sala1.length);
            fila--;
            do {
                System.out.print("Butaca-> ");
                butaca = sc.nextInt();
                if (butaca > sala1[fila].length){
                    System.out.println("Hay " + sala1[fila].length + " butacas");
                }
            } while (butaca > sala1[fila].length);
            butaca--;

            if (sala1[fila][butaca] != 'X') {
                sala1[fila][butaca] = 'X';
                System.out.println();
                System.out.println();
                System.out.println("Sala 1 " + pelicula1);
                System.out.println(fechaActual + " Sesión 22:30");
                System.out.println("Fila " + (fila + 1) + " Butaca " + (butaca + 1));
                System.out.println();
            } else {
                System.out.println("Butaca ocupada");
            }
        } else {
            MostrarSala2();
            //Pedimos fila y butaca
            do {
                System.out.print("Fila-> ");
                fila = sc.nextInt();
            } while (fila > sala2.length);
            fila--;
            do {
                System.out.print("Butaca-> ");
                butaca = sc.nextInt();
            } while (butaca > sala2[fila].length);
            butaca--;
            
            //Comprobamos y cambiamos el contenido del array
            if (sala2[fila][butaca] != 'X') {
                sala2[fila][butaca] = 'X';
                System.out.println();
                System.out.println();
                System.out.println("Sala 2 " + pelicula2);
                System.out.println(fechaActual + " Sesión 22:30");
                System.out.println("Fila " + (fila + 1) + " Butaca " + (butaca + 1));
                System.out.println();
            } else {
                System.out.println("Butaca ocupada");
            }
        }
    }
}
