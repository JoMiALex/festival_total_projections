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
        loadProjections(savedProjection);
        System.out.println(savedProjection.keySet());
        FestivalDetails currFest;

        int choice, itemCount;
        double admission = 600.0, hotelCost = 300.0, bnbCost = 210.0, 
        campCost= 150.0, foodCost = 180, carParkCost = 90.0,
        total = 0;
        boolean run = true;
        String msgError = "Error! Try again.",
        festName = "Coachella";
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Hello Welcome to Festival Projections!\n");
        
        while(run){
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
                    while(choice < 3){
                        listFestivals(storedFestival);
                        festName = selectFest(keyboard, storedFestival);
                        if(festName.equalsIgnoreCase("done"))
                            break;
                        currFest = storedFestival.get(festName);
                        makeProjection(keyboard, currFest,savedProjection);
                    }
                    }break;
                case 2:{
                    viewSave(keyboard, savedProjection);
                    }break;
                case 3:{
                    choice = 1;
                    while(choice < 3){
                        listFestivals(storedFestival);
                        System.out.print("Would you like to:\n1. Add a new festival\n2. Modify a saved festival\n3. Return to menu\nSelection: ");
                        choice = keyboard.nextInt();
                        keyboard.nextLine();
                        if(choice == 1)
                            addFestival(keyboard, storedFestival);
                        else if(choice == 2){
                            listFestivals(storedFestival);
                            festName = selectFest(keyboard, storedFestival);
                            if(festName.equalsIgnoreCase("done"))
                                break;
                            currFest = storedFestival.get(festName);
                            changePresets(keyboard, currFest);
                        }
                    }
                    }break;
                default:
                    run = false;
            }
        }

        saveProjections(savedProjection);
        saveFestivals(storedFestival);

        if(total == 0)
            System.out.println("\nGoodbye!\n\n");
        else{
            System.out.printf("\n\nHave fun at %s this weekend!\n\n", festName);
            
        }
        
    }

static String selectFest(Scanner keyboard, Map<String, FestivalDetails> festivals){
    //System.out.print("Please enter the name of the festival you would like select: ");
    String select;
    while(true){
        System.out.print("Enter a festival name or type done when you are finished: ");
        select = keyboard.nextLine();
        if(select.equalsIgnoreCase("done") || festivals.containsKey(select))
            break;
    }
    return select;
}

static void viewSave(Scanner keyB,Map<String, String[]> saves){
    while(true){
        System.out.println("Stored Projections:");
        int i = 1;
        String[] info;
        for (String festival : saves.keySet()) {
            info = saves.get(festival);
            System.out.println(i + ". " + info[0]);
            //System.out.println(festival + ": " + festivals.get(festival));
            i++;
        }
        System.out.println(i + ". Back to main");
        System.out.print("Selection: ");
        int choice = keyB.nextInt();
        keyB.nextLine();
        while(choice < 1 || choice > i){
            System.out.println("Invalid choice! Please make another selection\nSelection: ");
            choice = keyB.nextInt();
        }
        if(choice == i)
            break;
        
    }
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
    for (FestivalDetails festival : festivals.values()) {
        System.out.println(i + ". " + festival.getName());
        //System.out.println(festival + ": " + festivals.get(festival));
        i++;
    }
        System.out.println("______________________");
}

private static void makeProjection(Scanner keyboard, FestivalDetails fest,Map<String, String[]> saves){
    String sData[] = {"","","",""};
    int choice[] = {0,0,0,0};
    String option[] = {"Ticket:\n1. GA\n2. VIP\n", "Housing:\n1. Camping\n2. Hotel\n3. Air Bnb\n",
    "Parking:\nCar pass count:\n","Food Cost:\nInclude food\n1. Yes\n2. No\n"};
    //{"1. GA\n2. VIP\n","1. Camping\n2. Hotel\n3. Air Bnb\n","Car pass count:\n","Include food\n1. Yes\n2. No\n"};
    double total = 0;
    System.out.println(fest.toString() + "\nPlease make a few selections so we can give a projection!");
    for(int i = 0; i < 4;i++){
        if(i == 2 && fest.getParking() == 0)
            continue;
        System.out.print(option[i] + "Selection: ");
        choice[i] = keyboard.nextInt();
        keyboard.nextLine();
        if(i == 0){
            if(choice[i] == 1){
                total += fest.getGA();
                sData[3] += ("GA: "+fest.getGA() + " ");
            }else{
                total += fest.getVIP();
                sData[3] += ("VIP: "+fest.getVIP() + " ");
            }
        }else if(i == 1){
            if(choice[i] == 1){
                total += fest.getCamp();
                sData[3] += ("Camp: "+fest.getCamp() + " ");
            }else if(choice[i] == 2){
                total += fest.getHotel();
                sData[3] += ("Hotel: "+fest.getHotel() + " ");
            }else{
                total += fest.getBnb();
                sData[3] += ("Air Bnb: "+fest.getBnb() + " ");
            }
        }else if(i == 2){
            total += (fest.getParking() * choice[i]);
            sData[3] += ("Parking: "+ (fest.getParking() * choice[i]) + " ");
        }else{
            if(choice[i] == 1){
                total += fest.getFood();
                sData[3] += ("Air Bnb: "+fest.getBnb() + " ");
            }
            //sData[3] += ("\n");
        }
    }
    System.out.println("Your total is $" + total);
    int x;
    while(true){
        System.out.print("Would you like to save this projection?(1=Yes,2=No)\nSelection: ");
        x = keyboard.nextInt();
        keyboard.nextLine();
        if(x == 1 || x == 2)
            break;
    }
    if(x == 1){
        System.out.print("Enter a save name: ");
        sData[0] = keyboard.nextLine();
        sData[1] = fest.getName();
        sData[2] = String.valueOf(total);
        saves.put(sData[0],sData);
    }
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

    private static void saveProjections(Map<String, String[]> projection) {
        try {FileWriter clear = new FileWriter(SAVEFILE);
            clear.write("");
            clear.close();
        } catch (Exception e) {
            System.err.println("Error clearing save file: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVEFILE))) {
            for (String[] entry : projection.values()) {
                //writer.write(entry[0] + ":" + entry.getValue() + ",");
                /*String SaveName = entry[0];
                String[] Details = entry.getValue();
                String FestName = details[0];
                double TotalCost = Double.parseDouble(details[1]);
                String ProjectionDetails = details[2];
                */
                writer.write(entry[0] + ", " + entry[1] + ", " + entry[2] + ", " + entry[3] + "\n");
            }
        } catch (IOException e) {
            // Error occurred while saving
            System.err.println("Error saving projections: " + e.getMessage());
        }
    }
private static void saveFestivals(Map<String, FestivalDetails> festivals){
    try {FileWriter clear = new FileWriter(PRESETFILE);
        clear.write("");
        clear.close();
    } catch (Exception e) {
        System.err.println("Error clearing Preset file: " + e.getMessage());
    }
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRESETFILE))) {
        for (FestivalDetails entry : festivals.values()) {
            writer.write(entry.saveFormat());
        }
    } catch (IOException e) {
        // Error occurred while saving
        System.err.println("Error saving presets: " + e.getMessage());
    }
}
    
private static void changePresets(Scanner keyboard, FestivalDetails festival) {
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
    System.out.println("_________________________________________\n Updated values:" + festival.toString() + "\n");
}



private static void loadProjections(Map<String, String[]> festivals) {
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
    // System.out.println("Saved Projections:");
    // Implement logic to display saved projections
}

}
