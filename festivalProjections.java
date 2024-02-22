/*
 * Festival Projections Project
 * 
 * 
 * 
 * @author John Michael Lott
 * @author Vincent Tran
 */

 import java.util.Scanner;
 import java.io.*;
 import java.util.*;

 public class festivalProjections {
    //private static final String FILENAME = "festivals.txt";

    public static void main(String[] args){
        //Map<String, String> festivals = loadFestivals();

        int choice, itemCount;
        double admission = 600.0, hotelCost = 300.0, bnbCost = 210.0, 
        campCost= 150.0, foodCost = 180, carParkCost = 90.0,
        total = 0;
        String msgError = "Error! Try again.",
        festName = "Coachella";

         Scanner keyboard = new Scanner(System.in);

         System.out.println("Hello Welcome to Festival Projections!\n");
        
        while(total == 0){
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
            
            switch(choice){
                case 1:{
                    total = campCost + foodCost + admission;
                    System.out.printf("\n\nThe total cost projection for %s is %.2f.%n",festName, total);
                    System.out.println("The GA ticket price is: " + admission);
                    System.out.println("Car Camping: " +  campCost);
                    System.out.println("Food: " + foodCost);
                    }break;
                case 2:{
                    System.out.println("\nNone saved");
                    }break;
                case 3:{
                    System.out.println("\nUnable to change presets currently. :(");
                    }break;
                default:
                    total = -1;
            }
        }

        if(total == -1)
            System.out.println("\nGoodbye!\n\n");
        else{
            System.out.printf("\n\nHave fun at %s this weekend!\n\n", festName);
            
        }
        
    }
    
 }

/*private static Map <String, FestivalDetails> loadFestivals(){
    Map<string, FestivalDetails> festivals = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))){
        String line;
        while((line = reader.readline()) != null){
            String[] parts = line.splite(":");
            String name = parts[0];
            double admission = Double.parseDouble(parts[1]);
            double hotelCost = Double.parseDouble(parts[2]);
            double carParkCost = Double.parseDouble(parts[3]);
            double foodCost = Double.parseDouble(parts[4]);
            double campCost = Double.parseDouble(parts[5]);
            festivals.put(name, new FestivalDetails(admission, hotelCost, carParkCost, foodCost, campCost));
        }
    } catch (IOException error){
        //File does not exist or cannot be read
    }
    return festivals;
}*/

 /*private static void SaveFestivals(Map<String, FestivalDetails> Festivals){
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))){
        for(Map.Entry<String, FestivalDetails> entry: festivals.entrySet()){
            writer.write(entry.getKey() + ":" + entry.getValue() + "\n"); 
        }
    } catch (IOException error){
        //Error occured while saving
        System.err.println("Error saving festivals: " + error.getMessage)
    }
 }*/

 /*private static class FestivalDetails{
    private double admission;
    private double hotelCost;
    private double carParkCost;
    private double foodCost;
    private double campCost;

    public FestivalDetails(double admission, double hotelCost, double carParkCost, double foodCost, Double campCost){
        this.admission = admission;
        this.hotelCost = hotelCost;
        this.carParkCost = carParkCost;
        this.foodCost = foodCost;
        this.campCost = campCost;
    }
    public String toString(){
        return "Admission: " + admission + ", Hotel: " + hotelCost + ", Car Parking: " + carParkCost + ", Food: " + foodCost + ", Camp: " + campCost;
    }
 }*/
