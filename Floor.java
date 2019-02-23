/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelproject;

import java.util.ArrayList;

/**
 *
 * @author Pc_Lenovo
 */
public class Floor {
     private int floornumber;
    private int numberofrooms;
    /*
     Floor(){}
    Floor(int floornumber, int numberofrooms){
        this.floornumber=floornumber;
        this.numberofrooms=numberofrooms;
    }
     */
    private ArrayList<Room> ids = new ArrayList<>();

    //public  room []pr=new room[numberofrooms];
    public int getFloornumber() {
        return floornumber;
    }

    public void setFloornumber(int floornumber) {
        this.floornumber = floornumber;
    }


    public ArrayList<Room> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Room> ids) {
        this.ids = ids;
    }

    public int getNumberofrooms() {
        return getIds().size();
    }

    public void setNumberofrooms(int numberofrooms) {
        this.numberofrooms = numberofrooms;
    }


    public void displayavailable() {
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i).isReserved == false) {
                System.out.println("the Room " + getIds().get(i).roomnumber+" : " + " is free");
            }

        }
    }

    public String calculateprofits() {
        double total = 0;
        for (int i = 0; i < ids.size(); i++) {
            total += ids.get(i).TotalPrice();
        }
        return "the Total profit is :" + total;

    }

}

    

