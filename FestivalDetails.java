public class FestivalDetails {
    private String festName;
    private double ticketGA;
    private double ticketVIP;
    private double campCost;
    private double hotelCost;
    private double bnbCost;
    private double carParkingCost;
    private double foodCost;
    

        public FestivalDetails(String festName, double ticketGA, double ticketVIP, double campCost, double hotelCost, double bnbCost, double carParkingCost, double foodCost) {
            this.festName = festName;
            this.ticketGA = ticketGA;
            this.ticketVIP = ticketVIP;
            this.hotelCost = hotelCost;
            this.bnbCost = bnbCost;
            this.carParkingCost = carParkingCost;
            this.foodCost = foodCost;
            this.campCost = campCost;
        }
        public void setTicketGA(double ticketGA) {
            this.ticketGA = ticketGA;
        }

        public void setTicketVIP(double ticketVIP) {
            this.ticketGA = ticketVIP;
        }

        public void setHotelCost(double hotelCost) {
            this.hotelCost = hotelCost;
        }

        public void setBnbCost(double bnbCost) {
            this.bnbCost = bnbCost;
        }
        
        public void setCarParkingCost(double carParkingCost){
            this.carParkingCost = carParkingCost;
        }
        
        public void setFoodCost(double foodCost){
            this.foodCost = foodCost;
        }
        
        public void setCampCost(double campCost){
            this.campCost = campCost;
        }

        public double getGA(){return ticketGA;}

        public double getVIP(){return ticketVIP;}

        public double getCamp(){return campCost;}

        public double getHotel(){return hotelCost;}

        public double getBnb(){return bnbCost;}

        public double getParking(){return carParkingCost;}

        public double getFood(){return foodCost;}

        @Override
        public String toString() {
            return festName + "\nAdmission: \nGA: " + ticketGA + "\nVIP: " + ticketVIP + "\nCamp: " + campCost + "\nHotel: " + hotelCost + "\nAirBnb: " + bnbCost + "\nCar Parking: " + carParkingCost + "\nFood: " + foodCost;
        }
        
        public String saveFormat(FestivalDetails fest){
            return festName + "," + ticketGA + "," + ticketVIP + "," + campCost
            + "," + hotelCost + "," + bnbCost + "," + carParkingCost + "," + foodCost;
        }
}