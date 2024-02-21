/*
 * Festival Projections Project
 * 
 * 
 * 
 * @author John Michael Lott
 * @author Vincent Tran
 */

 import java.util.Scanner;

 public class festivalProjections {

    public static void main(String[] args){
        int choice, itemCount;
        double admission = 600.0, hotelCost = 300.0, bnbCost = 210.0, 
        campCost= 90.0, foodCost = 180, carParkCost = 90.0,
        total = 0.0;
        String msgError = "Error! Try again.",
        festName = "Coachella";

         Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello Welcome to Festival Projections!\n");
        System.out.println("Please make a choice from the menu options to get started.");
        System.out.println("__________________________________________________________");
        System.out.println("1. Make Festival Cost Projection");
        System.out.println("2. Access Saved Projections");
        System.out.println("3. Change Presets");
        System.out.println("4. Exit");
        System.out.print("Selection: ");
        choice = keyboard.nextInt();

        while(choice < 1 || choice > 4){
            System.out.println("Invalid choice please select a choice from the menu.\nEnter your choice(1-4):");
            choice = keyboard.nextInt();
            }
        
        while(total == 0){
            switch(choice){
                case 1:{
                    total = campCost + foodCost + carParkCost + admission + hotelCost;
                    //System.out.println(total);
                    //System.out.println("The total cost projection for " + festName + " is this " + total);
                    System.out.printf("The total cost projection for %s is %f.",festName, total);
                    }break;
                case 2:{
                    System.out.println("None saved");
                    total = -1;
                    }break;
                case 3:{
                    System.out.println("Unable to change presets currently. :(");
                    total = -1;
                    }break;
                default:
                    total = -1;
            }
        }

        if(total == -1)
            System.out.println("Goodbye!");
        else{
            System.out.println("Going to " + festName + " will cost: " + total);
            
        }
        
    }
    
 }