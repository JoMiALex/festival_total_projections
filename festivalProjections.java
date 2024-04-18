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
        Map<String, String[]> savedProjection = new HashMap<String, String[]>();

        loadFestivals(storedFestival);
        accessSavedProjections(savedProjection);;
        FestivalDetails currFest;

        boolean isKeyPresent;

        int choice, itemCount;
        double admission = 600.0, hotelCost = 300.0, bnbCost = 210.0, 
        campCost= 150.0, foodCost = 180, carParkCost = 90.0,
        total = -1;
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
                    listFestivals(storedFestival);
                    System.out.print("Please enter the name of the festival you would like to go to: ");
                    festName = keyboard.nextLine();
                    isKeyPresent = checkKey(keyboard, festName, storedFestival);
                    if(!isKeyPresent)
                        break;
                    currFest = storedFestival.get(festName);
                    makeProjection(keyboard, currFest);
                    //addFestival(keyboard, storedFestival);
                    }break;
                case 2:{
                    for(int i = 1; i < 4;i++){
                        
                    }
                    }break;
                case 3:{
                    System.out.println("Enter the name of the festival to change details:");
                    festName = keyboard.nextLine();
                    isKeyPresent = checkKey(keyboard, festName, storedFestival);
                    if(!isKeyPresent)
                        break;
                    currFest = storedFestival.get(festName);
                    changePresets(keyboard, currFest);
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

static boolean checkKey(Scanner keyboard, String check, Map<String, FestivalDetails> festivals){
    boolean valid = festivals.containsKey(check);
    while(!valid){
        System.out.println("Festival not found.\nEnter a new festival or type exit to leave");
        check = keyboard.nextLine();
        if(check.equalsIgnoreCase("exit"))
            break;
        valid = festivals.containsKey(check);
    }
    return valid;
}

private static void loadFestivals(Map<String, FestivalDetails> festivals) {
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
        //return festivals;
    }//generate multiple objects

private static void listFestivals(Map<String, FestivalDetails> festivals) {
    System.out.println("Stored Festivals:");
    int i = 1;
    for (String festival : festivals.keySet()) {
        System.out.println(i + ". " + festivals.get(festival).toString());
        //System.out.println(festival + ": " + festivals.get(festival));
        i++;
    }
        System.out.println("______________________");
}

private static void makeProjection(Scanner keyboard, FestivalDetails fest){
    int choice[] = {0,0,0,0};
    //String option[] = {"Ticket:", }
    System.out.print("Select a ticket type\n1. GA\n2. VIP\nSelection: ")
}

    private static void addFestival(Scanner keyboard, Map<String, FestivalDetails> festivals) {
        System.out.println("Enter the name of the festival:");
        String name = keyboard.nextLine();
        System.out.println("Enter the GA admission cost:");
        double ticketGA = keyboard.nextDouble();
        System.out.println("Enter the VIP admission cost:");
        double ticketVIP = keyboard.nextDouble();
        System.out.println("Enter the camp cost:");
        double campCost = keyboard.nextDouble();
        System.out.println("Enter the hotel cost:");
        double hotelCost = keyboard.nextDouble();
        System.out.println("Enter the Air Bnb cost:");
        double bnbCost = keyboard.nextDouble();
        System.out.println("Enter the car parking pass cost:");
        double carParkingCost = keyboard.nextDouble();
        System.out.println("Enter the food cost:");
        double foodCost = keyboard.nextDouble();
        festivals.put(name, new FestivalDetails(name, ticketGA, ticketVIP, campCost, hotelCost, bnbCost, carParkingCost, foodCost));
        System.out.println("Festival added successfully!");
    }//format 

    private static void saveFestivals(Map<String, FestivalDetails> festivals) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVEFILE))) {
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
    
private static void changePresets(Scanner keyboard, FestivalDetails festival) {
    if (festival == null) {
        System.out.println("Festival not found.");
        return;
    }
    System.out.println(festival.toString());
    System.out.println("Select the detail to change for " + festival.getName() + ":");
    System.out.println("1. GA Admission Cost");
    System.out.println("2. VIP Admission Cost");
    System.out.println("3. Camp Cost");
    System.out.println("4. Hotel Cost");
    System.out.println("5. Air Bnb Cost");
    System.out.println("6. Car Parking Cost");
    System.out.print("7. Food Cost\nSelection: ");
    int choice = keyboard.nextInt();
    keyboard.nextLine(); // Consume newline
    double setNew;

    switch (choice) {
        case 1:
            System.out.println("Enter new GA cost:");
            setNew = keyboard.nextDouble();
            festival.setTicketGA(setNew);
            break;
        case 2:
            System.out.println("Enter new VIP cost:");
            setNew = keyboard.nextDouble();
            festival.setTicketVIP(setNew);
            break;
        case 3:
            System.out.println("Enter new camping cost:");
            setNew = keyboard.nextDouble();
            festival.setCampCost(setNew);
            break;
        case 4:
            System.out.println("Enter new hotel cost:");
            setNew = keyboard.nextDouble();
            festival.setHotelCost(setNew);
            break;
        case 5:
            System.out.println("Enter new Air Bnb cost:");
            setNew = keyboard.nextDouble();
            festival.setBnbCost(setNew);
            break;
        case 6:
            System.out.println("Enter new car parking cost:");
            setNew = keyboard.nextDouble();
            festival.setCarParkingCost(setNew);
            break;
        case 7:
            System.out.println("Enter new food cost:");
            setNew = keyboard.nextDouble();
            festival.setFoodCost(setNew);
            break;
        default:
            System.out.println("Invalid choice, please try again.");
    }
    System.out.println("_________________________________________\n Updated values:" + festival.toString());
}



private static void accessSavedProjections(Map<String, String[]> festivals) {
    try (BufferedReader reader = new BufferedReader(new FileReader(SAVEFILE))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            //String saveName = parts[0];
            //String festName = parts[1];
            //double totalCost = Double.parseDouble(parts[2]);
            //String details = parts[3];
            /*
            double ticketVIP = Double.parseDouble(parts[2]);
            double campCost = Double.parseDouble(parts[3]);
            double hotelCost = Double.parseDouble(parts[4]);
            double bnbCost = Double.parseDouble(parts[5]);
            double carParkingCost = Double.parseDouble(parts[6]);
            double foodCost = Double.parseDouble(parts[7]);
            */
            festivals.put(parts[0], parts);
            //FestivalDetails festival = new FestivalDetails(parts[1], parts[2],parts[3],parts[4],parts[5]);
        }
    } catch (IOException e) {
        // File does not exist or cannot be read
    }
    //return festivals;
    System.out.println("Saved Projections:");
    // Implement logic to display saved projections
}

}
