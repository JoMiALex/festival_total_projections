public class FestivalDetails {
        private String festName;
        private double admission;
        private double hotelCost;
        private double carParkCost;
        private double foodCost;
        private double campCost;
    
        public FestivalDetails(String festName, double admission, double hotelCost, double carParkCost, double foodCost, Double campCost){
            this.festName = festName;
            this.admission = admission;
            this.hotelCost = hotelCost;
            this.carParkCost = carParkCost;
            this.foodCost = foodCost;
            this.campCost = campCost;
        }
        public String toString(){
            return festName + ":\nAdmission: " + admission + "\nHotel: " + hotelCost + "\nCar Parking: " + carParkCost + "\nFood: " + foodCost + "\nCamp: " + campCost;
        }
}
