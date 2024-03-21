/*
 * Festival Projections Project
 * 
 * 
 * 
 * @author John Michael Lott
 * @author Vincent Tran
 */

 import java.io.*;
import java.util.*;

 public class festivalProjections {
      private static final String PRESETFILE = "festivals.txt";
      private static final String SAVEFILE = "SavedProjections.txt";


    public static void main(String[] args){
        Map<String, FestivalDetails> storedFestival = new HashMap<String, FestivalDetails>();
        Map<String, FestivalDetails> savedProjection = new HashMap<String, FestivalDetails>();
        //ArrayList<FestivalDetails> storedFestival = new ArrayList<FestivalDetails>();
        //Map<String, FestivalDetails> festivals = loadFestivals();
        storedFestival = loadFestivals(storedFestival);

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
            keyboard.nextLine();
            
            while(choice < 1 || choice > 4){
                System.out.println("Invalid choice please select a choice from the menu.\nEnter your choice(1-4):");
                choice = keyboard.nextInt();
                }
            
            switch(choice){
                case 1:{
                    addFestival(keyboard, storedFestival);
                    }break;
                case 2:{
                    accessSavedProjections(savedProjection);
                    }break;
                case 3:{
                    changePresets(keyboard, storedFestival);
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

private static Map<String, FestivalDetails> loadFestivals(Map<String, FestivalDetails> festivals) {
        //Map<String, FestivalDetails> festivals = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PRESETFILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double ticketGA = Double.parseDouble(parts[1]);
                double ticketVIP = Double.parseDouble(parts[2]);
                double campCost = Double.parseDouble(parts[3]);
                double hotelCost = Double.parseDouble(parts[4]);
                double bnbCost = Double.parseDouble(parts[5]);
                double carParkingCost = Double.parseDouble(parts[6]);
                double foodCost = Double.parseDouble(parts[7]);
                festivals.put(name, new FestivalDetails(name, ticketGA, ticketVIP, campCost, hotelCost, bnbCost, carParkingCost, foodCost));
                //FestivalDetails festival = new FestivalDetails(parts[1], parts[2],parts[3],parts[4],parts[5]);
            }
        } catch (IOException e) {
            // File does not exist or cannot be read
        }
        return festivals;
    }//generate multiple objects

    private static void listFestivals(Map<String, FestivalDetails> festivals) {
        System.out.println("Festivals:");
        for (String festival : festivals.keySet()) {
            System.out.println(festival + ": " + festivals.get(festival));
        }
    }

    private static void addFestival(Scanner keyboard, Map<String, FestivalDetails> festivals) {
        System.out.println("Enter the name of the festival:");
        String name = keyboard.nextLine();
        System.out.println("Enter the admission cost:");
        double admissionCost = keyboard.nextDouble();
        System.out.println("Enter the hotel cost:");
        double hotelCost = keyboard.nextDouble();
        System.out.println("Enter the car parking cost:");
        double carParkingCost = keyboard.nextDouble();
        System.out.println("Enter the food cost:");
        double foodCost = keyboard.nextDouble();
        System.out.println("Enter the camp cost:");
        double campCost = keyboard.nextDouble();
        //festivals.put(name, new FestivalDetails(admissionCost, hotelCost, carParkingCost, foodCost, campCost));
        System.out.println("Festival added successfully!");
    }//format 

    private static void saveFestivals(Map<String, FestivalDetails> festivals) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRESETFILE))) {
            for (Map.Entry<String, FestivalDetails> entry : festivals.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            // Error occurred while saving
            System.err.println("Error saving festivals: " + e.getMessage());
        }
    }
    /*
    private static class FestivalDetails {
        private double admissionCost;
        private double hotelCost;
        private double carParkingCost;
        private double foodCost;
        private double campCost;

        public FestivalDetails(double admissionCost, double hotelCost, double carParkingCost, double foodCost, double campCost) {
            this.admissionCost = admissionCost;
            this.hotelCost = hotelCost;
            this.carParkingCost = carParkingCost;
            this.foodCost = foodCost;
            this.campCost = campCost;
        }
        public void setAdmissionCost(double admissionCost) {
            this.admissionCost = admissionCost;
        }

        public void setHotelCost(double hotelCost) {
            this.hotelCost = hotelCost;
        }
        
        public void setcarParkingCost(double carParkingCost){
            this.carParkingCost = carParkingCost;
        }
        
        public void setFoodCost(double foodCost){
            this.foodCost = foodCost;
        }
        
        public void setCampCost(double CampCost){
            this.campCost = campCost;
        }

        @Override
        public String toString() {
            return "Admission: " + admissionCost + ", Hotel: " + hotelCost + ", Car Parking: " + carParkingCost + ", Food: " + foodCost + ", Camp: " + campCost;
        }
    }
    */
    
    private static void changePresets(Scanner keyboard, Map<String, FestivalDetails> festivals) {
    System.out.println("Enter the name of the festival to change details:");
    String festivalName = keyboard.nextLine();
    FestivalDetails festival = festivals.get(festivalName);
    if (festival == null) {
        System.out.println("Festival not found.");
        return;
    }
    System.out.println(festival.toString());
    System.out.println("Select the detail to change for " + festivalName + ":");
    System.out.println("1. Admission Cost");
    System.out.println("2. Hotel Cost");
    System.out.println("3. Car Parking Cost");
    System.out.println("4. Food Cost");
    System.out.println("5. Camp Cost");
    int choice = keyboard.nextInt();
    keyboard.nextLine(); // Consume newline

    switch (choice) {
        case 1:
            System.out.println("Enter new admission cost:");
            double newAdmissionCost = keyboard.nextDouble();
            festival.setTicketGA(newAdmissionCost);
            break;
        case 2:
            System.out.println("Enter new hotel cost:");
            double newHotelCost = keyboard.nextDouble();
            festival.setHotelCost(newHotelCost);
            break;
        case 3:
            System.out.println("Enter new car parking cost:");
            double newCarParkingCost = keyboard.nextDouble();
            festival.setCarParkingCost(newCarParkingCost);
            break;
        case 4:
            System.out.println("Enter new food cost:");
            double newFoodCost = keyboard.nextDouble();
            festival.setFoodCost(newFoodCost);
            break;
        case 5:
            System.out.println("Enter new camp cost:");
            double newCampCost = keyboard.nextDouble();
            festival.setCampCost(newCampCost);
            break;
        default:
            System.out.println("Invalid choice, please try again.");
    }
}



private static void accessSavedProjections(Map<String, FestivalDetails> festivals) {
    System.out.println("Saved Projections:");
    // Implement logic to display saved projections
}

}
