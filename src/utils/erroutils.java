/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author julia
 */
public class erroutils {
    public static void logErro(String mensagem, Exception e) {
        System.err.println(mensagem + ": " + e.getMessage());
        e.printStackTrace(); 
    }
}
