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
    static char [][] sala1;
    static char [][] sala2;
    static String pelicula1, pelicula2;
    static int mitadSala1, mitadSala2;

    public static void main(String[] args) {
        System.out.println("Configuracion de las salas para hoy");
        Fecha();
        for(int i = 1; i <= 2; i++){
            Teclado(i);
        }
        System.out.println(sala1.length);
        System.out.println(sala1[1].length);
        System.out.println(sala2.length);
        System.out.println(sala2[1].length);
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
    public static void Teclado(int i){
        int filas, butacas;
        System.out.println("Sala " + i);
        do{
            System.out.print("Número de filas: -> ");
            filas = sc.nextInt() + 1;
        }while(filas <= 0);
        do{
            System.out.print("Butacas por filas: -> ");
            butacas = sc.nextInt() + 2;
        }while(butacas <= 1 || butacas % 2 != 0);
        sc.nextLine();
        if(i == 1){
            System.out.print("Pelicula de la Sala 1: ");
            pelicula1 = sc.nextLine();
            mitadSala1 = butacas / 2 + 1;
            sala1 = new char [filas][butacas];
        }else{
            System.out.print("Pelicula de la Sala 2: ");
            pelicula2 = sc.nextLine();
            mitadSala2 = butacas / 2 + 1;
            sala2 = new char [filas][butacas];
        }
        System.out.println();
    }
}
