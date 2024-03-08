public class FestivalDetails {
    private String festName;
    private double admissionCost;
    private double hotelCost;
    private double carParkingCost;
    private double foodCost;
    private double campCost;
    

        public FestivalDetails(String festName, double admissionCost, double hotelCost, double carParkingCost, double foodCost, double campCost) {
            this.festName = festName;
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
            return festName + "Admission: " + admissionCost + ", Hotel: " + hotelCost + ", Car Parking: " + carParkingCost + ", Food: " + foodCost + ", Camp: " + campCost;
        }
        /*public String saveFormat(FestivalDetails fest){
            return name + "," + admissionCost
        }*/
}
