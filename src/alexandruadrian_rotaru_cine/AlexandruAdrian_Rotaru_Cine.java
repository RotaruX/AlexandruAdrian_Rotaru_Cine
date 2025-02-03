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
    
    public static void main(String[] args) {
        System.out.println("Configuracion de las salas para hoy");
        Fecha();
        
    }
    
    public static void Fecha(){
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter ESP = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaActual = fecha.format(ESP);
        System.out.println(fechaActual);
    }
    
}
