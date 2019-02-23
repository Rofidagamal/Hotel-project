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
public class StandardRoom extends Room{
     private int numofbed;
    private double bedprice;
    /*

    StandardRoom(){}
    StandardRoom(int roomnumber,int daysOfReservation,boolean isReserved,int numofbed,int bedprice){
        super(roomnumber,daysOfReservation,isReserved);
        this.bedprice=bedprice;
        this.numofbed=numofbed;

    }
     */

    public int getNumofbed() {
        return numofbed;
    }

    public void setNumofbed(int numofbed) {
        this.numofbed = numofbed;
    }

    public double getBedprice() {
        return bedprice;
    }

    public void setBedprice(double bedprice) {
        this.bedprice = bedprice;
    }

    public void ReverseRoom() {
        isReserved = true;

    }

    public boolean CheckReservation() {
        return isReserved;

    }

    public double TotalPrice() {
        return getNumofbed() * getBedprice() * getDayOfReversation();
    }

    @Override
    public String toString() {
        return "Room Type : Standard and " + "Room number : " + roomnumber + " and Number of beds : " + numofbed + " and Bed price :" + bedprice
                + " and is reservation :" + isReserved;

    }
}



    

