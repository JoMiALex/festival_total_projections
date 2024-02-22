public class FestivalDetails {
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
}
