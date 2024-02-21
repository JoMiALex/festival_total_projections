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
        double admission, hotelCost = 300.0, bnbCost = 210.0, 
        campCost= 90.0, foodCost = 180, carParkCost = 90.0,
        total = 0;
        String msgError = "Error! Try again.",
        festName = "Coachella";

         Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello Welcome to Festival Projections!\n");
        System.out.println("Please make a choice from the menu options to get started.\n");
        System.out.println("__________________________________________________________\n");
        System.out.println("1. Make Festival Cost Projection");
        System.out.println("2. Access Saved Projections");
        System.out.println("3. Change Presets");
        System.out.println("4. Exit");
        choice = keyboard.nextInt();

        while(choice < 1 || choice > 4){
            System.out.println("Invalid choice please select a choice from the menu.\nEnter your choice(1-4):");
            choice = keyboard.nextInt();
            }
        
        while(total == 0){
            switch(choice){
                case 1:{
                    
                    }break;
                case 2:{
                    
                    }break;
                case 3:{
                    
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