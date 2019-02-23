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
public class ConferenceRoom extends Room{
     private int numofseats;
    private double seatprice;
    /*

    ConferenceRoom(){}
    ConferenceRoom(int roomnumber,int daysOfReservation,boolean isReserved,int numofseats,double seatprice){

        super(roomnumber,daysOfReservation,isReserved);
        this.numofseats=numofseats;
        this.seatprice=seatprice;
    }
     */

    public int getNumofseats() {
        return numofseats;
    }

    public void setNumofseats(int numofseats) {
        this.numofseats = numofseats;
    }

    public double getSeatprice() {
        return seatprice;
    }

    public void setSeatprice(double seatprice) {
        this.seatprice = seatprice;
    }

    public void ReverseRoom() {
        isReserved = true;

    }

    public boolean CheckReservation() {
        return isReserved;
    }

    public double TotalPrice() {
        return getSeatprice() * getNumofseats() * getDayOfReversation();
    }

    @Override
    public String toString() {
        return "Room Type : Conference and " + " Room number : " + roomnumber + " and the Number of Seats : " + numofseats +
                "and Seat price : " + seatprice + "  and is reservation :" + isReserved;

    }


}



 
