/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelproject;

/**
 *
 * @author Pc_Lenovo
 */
public class InvalidReservationExcpetion extends Exception {
   
    public InvalidReservationExcpetion(String s) {
        System.out.println(toString() + ":" + s);
    }


}

    
