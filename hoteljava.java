package hotelproject;
import java.io.File;
import java.util.Scanner;

public class hoteljava
{
    public static void menu() {//function for view the menu and choices
        System.out.println("choose 1 For Show statues in hotel");
        System.out.println("choose 2 For Make reservation");
        System.out.println("choose 3 For Cancel reservation");
        System.out.println("choose 4 For Checkout ");
        System.out.println("choose 5 For Display available rooms in the floor you want to choose");
        System.out.println("choose 6 For Display the total profits of current statues in hotel");
        System.out.println("choose 0 For Exit");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


    }

    public static int fun() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println(" It is wrong input ,please enter integer : ");
            input.next();
        }
        int x = input.nextInt();
        return x;
    }

    public static Room Conference(String[] arr) {// function for adding conference room
        try {// make try & catch for any error in shape of room
            if (arr.length == 4) {// if the size of given information are 4 it will be true else it has fewer information than i want
                Room r = new ConferenceRoom();// polymorphism to change object of room to Conference
                ConferenceRoom y = (ConferenceRoom) r;// down casting for using the things in class Conference
                y.setRoonumber(Integer.parseInt(arr[1]));// enter the data in the object
                y.setNumofseats(Integer.parseInt(arr[2]));
                Double a;
                if (arr[3].charAt(arr[3].length() - 1) == '.') {
                    a = Double.parseDouble(arr[3].substring(0, arr[3].lastIndexOf('.')));
                    y.setSeatprice(Double.parseDouble(arr[3].substring(0, arr[3].length() - 1)));

                } else {
                    a = Double.parseDouble(arr[3]);
                    y.setSeatprice(Double.parseDouble(arr[3]));

                }
                arr[3] = "" + a;
                if (Integer.parseInt(arr[1]) <= 0 || Integer.parseInt(arr[2]) <= 0
                        || a <= 0)
                    throw new InvalidReservationExcpetion("the given data is wrong it should not be negative or zero");
                else
                    return y;//return the object after save data
            } else {
                throw new InvalidReservationExcpetion("wrong in number of data for conference room");
                //return null;//return null if it makes any problem with the given data
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Room Standard(String[] arr) {
        try {//the same comments in Conference
            if (arr.length == 4) {
                Room r = new StandardRoom();
                StandardRoom y = (StandardRoom) r;
                y.setRoonumber(Integer.parseInt(arr[1]));
                y.setNumofbed(Integer.parseInt(arr[2]));
                Double a;
                if (arr[3].charAt(arr[3].length() - 1) == '.') {
                    a = Double.parseDouble(arr[3].substring(0, arr[3].lastIndexOf('.')));
                    y.setBedprice(Double.parseDouble(arr[3].substring(0, arr[3].length() - 1)));
                } else {
                    a = Double.parseDouble(arr[3]);
                    y.setBedprice(Double.parseDouble(arr[3]));
                }
                arr[3] = "" + a;
                if (Integer.parseInt(arr[1]) <= 0 || Integer.parseInt(arr[2]) <= 0
                        || a <= 0)
                    throw new InvalidReservationExcpetion("the given data is wrong it should not be negative or zero");
                else
                    return y;//return the object after save data
            } else {
                // return null;
                throw new InvalidReservationExcpetion("wrong in number of data for standard room");

            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Room Sweet(String[] arr) {
        //the same comments in Conference but small change in number of information it will be here 3
        try {
            if (arr.length == 3) {
                Room r = new SweetRoom();
                SweetRoom y = (SweetRoom) r;
                y.setRoonumber(Integer.parseInt(arr[1]));
                y.setPricepernight(Double.parseDouble(arr[2]));
                if (Integer.parseInt(arr[1]) <= 0 || Double.parseDouble(arr[2]) <= 0)
                    throw new InvalidReservationExcpetion("the given data is wrong it should not be negative or zero");
                else
                    return y;//return the object after save data
            } else {
                //return null;
                throw new InvalidReservationExcpetion("wrong in number of data for sweet room");

            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void ShowStatues(Floor at[])//if the choose is  number 1
    {
        for (int i = 0; i < at.length; i++) {//it go for all floors
            System.out.println("the number of floor : " + at[i].getFloornumber());
            for (int y = 0; y < at[i].getIds().size(); y++) {//go for all room in the floor
                System.out.println(at[i].getIds().get(y).toString());//to print all information about this room
                System.out.println("------------------------------------------------------------------------------------------");
            }

        }

    }

    public static void MakeReservation( int room, Floor arr[]) {//if choose is 2
        if (room <= 0)//if number of days reservation 0 or minus that leads to that reservation is wrong
        {
            while (room <= 0) {
                System.out.println("please enter a positive room number :");
                room = fun();
            }
        }
       /* System.out.println("please enter the days of reservation");
                            int days = fun();
        if (days <= 0)//if number of days reservation 0 or minus that leads to that reservation is wrong
        {
            while (days <= 0) {
                System.out.println("please enter a positive days number :");
                days = fun();
            }
        }*/
        //if the room is free you can reserve it else it is wrong
        boolean b = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].getIds().size(); j++) {
                if (arr[i].getIds().get(j).getRoomnumber() == room ) {
                    if(arr[i].getIds().get(j).getIsReserved()==false)
                    {
                        System.out.println("please enter the days of reservation");
                        int days = fun();
                        if (days <= 0)//if number of days reservation 0 or minus that leads to that reservation is wrong
                        {
                            while (days <= 0) {
                                System.out.println("please enter a positive days number :");
                                days = fun();
                            }
                        }
                        arr[i].getIds().get(j).setIsReserved(true);
                        arr[i].getIds().get(j).setDayOfReversation(days);

                        System.out.println("the room " + arr[i].getIds().get(j).getRoomnumber() + " is reversed ,thanks for " +
                                "your reservation");
                    }
                    else
                    {
                        System.out.println(" I’m sorry , this room " + arr[i].getIds().get(j).getRoomnumber()
                                + "is already reserved ,it is not availble,please choose another another one ");
                    }
                    b = true;
                    break;
                }

            }

            if (b == true)
                break;
        }
        if (b == false) {
            System.out.println("I’m sorry , this room is wrong..please choose corrcet one ");
        }

    }

    public static void CheckOut(int r, Floor f[]) {//if the choose is 3
        //choose 4
        if (r <= 0)//if room is minus or 0 that make it wrong
        {
            while (r <= 0) {
                System.out.println("please enter a positive room number :");
                r = fun();
            }

        }

        //if the room was not free you can make check out and it will be free
        boolean p = false;
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].getIds().size(); j++) {
                if (f[i].getIds().get(j).getRoomnumber() == r ) {
                    p = true;
                    if(f[i].getIds().get(j).getIsReserved()==true){
                        System.out.println("the room " + r + " is checked out and its total price is "
                                + f[i].getIds().get(j).TotalPrice() + " thanks for your stay");

                        f[i].getIds().get(j).setIsReserved(false);
                        f[i].getIds().get(j).setDayOfReversation(0);
                    }
                    else
                    {
                        System.out.println("this room " + r+"is already free! ,please check your number");
                    }
                    break;
                }
            }
            if (p == true)
                break;
        }
        if (p == false) {
            System.out.println("I’m sorry , this room is wrong..please choose corrcet one ");
        }

    }


    public static void CancelReservation(int r, Floor f[]) {
        if (r <= 0)//if room is minus or 0 that make it wrong
        {
            while (r <= 0) {
                System.out.println("please enter a positive room number :");
                r=fun();
            }

        }
        // if the room is not free you can cancel your room else it will be wrong example if it is free you cannot cancel free room!!
        boolean n = false;

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].getIds().size(); j++) {
                if (r == f[i].getIds().get(j).getRoomnumber() ) {
                    if(f[i].getIds().get(j).getIsReserved()==true)
                    {
                        System.out.println("the room " + r + " is canceled");
                        n = true;
                        f[i].getIds().get(j).setIsReserved(false);
                        f[i].getIds().get(j).setDayOfReversation(0);
                    }
                    else
                    {
                        System.out.println("this room " + r+"is already free! ,please check your number");
                    }
                }
            }
            if (n == true)
                break;

        }
        if (n == false)
            System.out.println(" I’m sorry ,this is wrong cancel ,please try again..");
    }


    public static void DisplayFree(int floor, Floor p[])
    //choose 5
    {

        if (floor <= 0)//if room is minus or 0 that make it wrong
        {
            while (floor <= 0) {
                System.out.println("please enter a positive floor number :");
                floor = fun();
            }

        }
        if(floor<=p.length)
        {
            //if the floor is found go in class floor and display free rooms in this floor

            for (int i = 0; i < p.length; i++) {
                if (p[i].getFloornumber() == floor) {
                    p[i].displayavailable();
                    break;
                }
            }
        }
        else
            System.out.println("this floor is not found ,please try again and enter correct floor");
    }

    public static void PrintTotalProfit(Floor[] frr)//choose 6
    {
        // to print the total profit in the hotel
        double total = 0;
        for (int i = 0; i < frr.length; i++) {
            for (int h = 0; h < frr[i].getIds().size(); h++) {
                total += frr[i].getIds().get(h).TotalPrice();
            }
        }
        System.out.println("the total profit is " + total);
    }

    public static void main(String[] args) {
        Floor[] at = new Floor[1];
        File f = new File("F:\\configuration.txt.txt");
        try {
            Scanner sc = new Scanner(f);//the read from file
            while (sc.hasNext())//if the file is not empty if the file has sentences
            {

                String u = sc.nextLine();//take line line
                String[] se = u.split(" ");// split the string to take the number of floors
                int noffloors = Integer.parseInt(se[se.length - 1].trim());// the number of floors

                if (noffloors <= 0)

                    throw new Exception("wrong number of floors");
                //System.exit(0);

                at = new Floor[noffloors];// renew the array size by the size of floors

                for (int k = 0; k < noffloors; k++)//make object because there was only references
                    at[k] = new Floor();
                label:
//because if there was any error
                for (int i = 0; i < noffloors; i++)//in every floor split to take number of rooms
                {
                    String[] h = (sc.nextLine().split(": "));
                    int y = Integer.parseInt(h[h.length - 1].trim());//number of rooms
                    if (y <= 0)
                        throw new InvalidReservationExcpetion("the given data is wrong it should not be negative or zero ");
                    for (int j = 0; j < y; j++)// for every number of rooms enter the data for every room
                    {
                        String[] arr = sc.nextLine().split(", ");
                        switch (arr[0]) {
                            case "Sweet":

                                Room r = Sweet(arr);//make object
                                if (r != null) {//if there was wrong with data in sweet
                                    at[i].getIds().add(r);//add the object in the array list of own floor
                                } else {
                                    break label;
                                }
                                break;
                            case "Standard":

                                Room ru = Standard(arr);
                                if (ru != null) {//if there was wrong with data in standard
                                    at[i].getIds().add(ru);
                                } else {
                                    break label;
                                }
                                break;
                            case "Conference":
                                Room ry = Conference(arr);
                                if (ry != null)//if there was wrong with data in conference
                                    at[i].getIds().add(ry);
                                else {
                                    break label;

                                }
                                break;
                            default:
                                throw new InvalidReservationExcpetion("that is wrong type of rooms");
                        }
                    }

                }

                for (int i = 0; i < at.length; i++) {
                    at[i].setNumberofrooms(at[i].getIds().size());//to put the number of array list size(that means number of rooms)
                    at[i].setFloornumber(i + 1);//set the floor number ordered
                }
            }
            Scanner su = new Scanner(System.in);
            menu();
            System.out.println("please enter a choose :");//for enter the choose
            int n = fun();
            if (n == 0) {
                System.out.println("Exit");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                do {


                    switch (n) {
                        case 0:
                            System.out.println("Exit");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                            break;
                        case 1:
                            ShowStatues(at);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                            break;

                        case 2:

                            System.out.println("please enter the room num you want to reverse in");
                            int roomm = fun();
                            MakeReservation( roomm, at);//given a wrong about at (the array of floor)
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                            break;
                        case 3:
                            System.out.println("please enter the room num you want to cancel");
                            int room = fun();
                            CancelReservation(room, at);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                            break;
                        case 4:
                            System.out.println("please enter the room num you want to checkout");
                            int ro = fun();
                            CheckOut(ro, at);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            break;
                        case 5:
                            System.out.println("please enter the floor num to display free rooms in it");
                            int u = fun();
                            DisplayFree(u, at);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                            break;
                        case 6:
                            PrintTotalProfit(at);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                            break;
                        default:
                            System.out.println("it is wrong choice ,please choose another choose");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                            break;
                    }
                    menu();
                    System.out.println("please enter a choose :");
                    n = fun();


                }
                while (n != 0);
                System.out.println("Exit");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            }

        } catch (Exception r) {
            System.out.println(r);
            System.out.println("Error in file");
        }

//System.exit(0);
    }
}
