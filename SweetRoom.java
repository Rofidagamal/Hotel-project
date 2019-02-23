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
public class SweetRoom extends Room{
     private double pricepernight;
    /*
    SweetRoom(){}
    SweetRoom(int roomnumber,int daysOfReservation,boolean isReserved,double pricepernight){
        super(roomnumber,daysOfReservation,isReserved);

        this.pricepernight=pricepernight;

    }
     */

    public double getPricepernight() {
        return pricepernight;
    }

    public void setPricepernight(double pricepernight) {
        this.pricepernight = pricepernight;
    }

    public void ReverseRoom() {
        isReserved = true;

    }

    public boolean CheckReservation() {
        return isReserved;

    }

    public double TotalPrice() {
        return getPricepernight() * getDayOfReversation();
    }

    @Override
    public String toString() {
        return "Room Type : Sweet and " + " Room number :" + roomnumber + " and Price per night :" + pricepernight + " and is reservation : " +
                isReserved;

    }

}
    

