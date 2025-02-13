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
    static char[][][] cine;
    static String[] peliculas;

    public static void main(String[] args) {
        System.out.println("Configuracion de las salas para hoy");
        Fecha();
        Salas();
        Menu();
    }

    public static void Fecha() {
        System.out.println(fechaActual);
        System.out.println("Sesión 22:30");
        System.out.println();
    }

    public static void Salas() {
        int salas, filas, butacas;
        do {
            System.out.print("Introduce numero de salas (maximo 10): ");
            salas = sc.nextInt();
            if (salas < 0 || salas > 10) {
                System.out.println("Maximo 1o salas");
            }
        } while (salas < 0 || salas > 10);

        //Colocamos el numero de salas y asignamos las filas y las butacas
        cine = new char[salas][][];
        peliculas = new String[salas];
        for (int i = 0; i < cine.length; i++) {
            do {
                System.out.print("Número de filas " + "de la sala " + (i + 1) + ": -> ");
                filas = sc.nextInt();
                if (filas <= 0) {
                    System.out.println("Debe haber minimo 1 fila");
                }
            } while (filas <= 0);
            do {
                System.out.print("Butacas por filas: -> ");
                butacas = sc.nextInt();
                if (butacas <= 1 || butacas % 2 != 0) {
                    System.out.println("Debe haber minimo 2 butacas y debe ser par ");
                }
            } while (butacas < 2 || butacas % 2 != 0);
            cine[i] = new char[filas][butacas];
            sc.nextLine();
            System.out.print("Introduce pelicula para la sala " + (i + 1) + " : ");
            peliculas[i] = sc.nextLine();
            System.out.println();
        }
        Rellenar();
    }

    public static void Rellenar() {
        for (int i = 0; i < cine.length; i++) {
            for (int j = 0; j < cine[i].length; j++) {
                for (int k = 0; k < cine[i][j].length; k++) {
                    cine[i][j][k] = '_';
                }
            }
        }
    }

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

    public static void Mostrar() {
        for (int i = 0; i < cine.length; i++) {
            System.out.println("Sala " + (i + 1) + " -> " + peliculas[i]);
            for (int j = 0; j < cine[i].length; j++) {
                System.out.printf("%2d ", j + 1);
                for (int k = 0; k < cine[i][j].length; k++) {
                    if (k == cine[i][j].length / 2) {
                        System.out.print(" ");
                    }
                    System.out.print(cine[i][j][k] + " ");
                }
                System.out.println();
            }
            //Escribir unidades
            System.out.print("   ");
            for (int ud = 1; ud <= cine[i][0].length; ud++) {
                System.out.print(ud % 10 + " ");
                if (ud == cine[i][0].length / 2) {
                    System.out.print(" ");
                }
            }
            //Escribir decenas
            System.out.println();
            System.out.print("   ");
            for (int dec = 1; dec <= cine[i][0].length; dec++) {
                if (dec >= 10 && dec % 10 == 0) {
                    System.out.print(dec / 10 + " ");
                }else{
                    System.out.print("  ");
                }
                if (dec == cine[i][0].length / 2) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void Vender() {
        int sala, fila, butaca;
        System.out.println("Venta de entradas");
        do{
            System.out.print("Introduce sala: ");
            sala = sc.nextInt();
            if(sala < 1 || sala > cine.length){
                System.out.println("Esta sala no existe");
            }
        }while(sala < 1 || sala > cine.length);
        
        sala -= 1;
        System.out.println();
        System.out.println("Sala " + (sala + 1) + " -> " + peliculas[sala]);
        for(int i = 0; i < cine[sala].length; i++){
            System.out.printf("%2d ", i + 1);
            for(int j = 0; j < cine[sala][i].length; j++){
                if (j == cine[sala][i].length / 2) {
                        System.out.print(" ");
                    }
                    System.out.print(cine[sala][i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.print("   ");
            for (int ud = 1; ud <= cine[sala][0].length; ud++) {
                System.out.print(ud % 10 + " ");
                if (ud == cine[sala][0].length / 2) {
                    System.out.print(" ");
                }
            }
            //Escribir decenas
            System.out.println();
            System.out.print("   ");
            for (int dec = 1; dec <= cine[sala][0].length; dec++) {
                if (dec >= 10 && dec % 10 == 0) {
                    System.out.print(dec / 10 + " ");
                }else{
                    System.out.print("  ");
                }
                if (dec == cine[sala][0].length / 2) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            
            do{
                System.out.print("Fila -> ");
                fila = sc.nextInt();
                if(fila < 1 || fila > cine[sala].length){
                    System.out.println("Fila no válida.");
                }
            }while(fila < 1 || fila > cine[sala].length);
            
            fila -= 1;
            
            do{
                System.out.print("Butaca -> ");
                butaca = sc.nextInt();
                if(butaca < 1 || butaca > cine[sala][fila].length){
                    System.out.println("Butaca no válida.");
                }
            }while(butaca < 1 || butaca > cine[sala][fila].length);
            
            butaca -= 1;
            
             if (cine[sala][fila][butaca] != 'X') {
                cine[sala][fila][butaca] = 'X';
                System.out.println();
                System.out.println();
                System.out.println("Sala  " + (sala + 1)+ " " + peliculas[sala]);
                System.out.println(fechaActual + " Sesión 22:30");
                System.out.println("Fila " + (fila + 1) + " Butaca " + (butaca + 1));
                System.out.println();
            } else {
                System.out.println("Butaca ocupada");
            }
    }
}
