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
abstract class Room {
    protected int roomnumber;
    protected int daysOfReservation;
    protected boolean isReserved;
    /*

    public Room(){}

    public Room(int roomnumber, int daysOfReservation, boolean isReserved) {
        this.daysOfReservation=daysOfReservation;
        this.isReserved=isReserved;
        this.roomnumber=roomnumber;
    }
     */

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoonumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public int getDayOfReversation() {
        return daysOfReservation;
    }

    public void setDayOfReversation(int daysOfReservation) {
        this.daysOfReservation = daysOfReservation;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public abstract void ReverseRoom();

    public abstract double TotalPrice();

    public abstract boolean CheckReservation();

    public abstract String toString() ;

}