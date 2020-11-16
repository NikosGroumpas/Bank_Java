public class Car {
    private String model;
    private int horsePower;
    private String dateManufactured;
    private int topSpeed;


    public Car(String model, int horsePower, String dateManufactured,int topSpeed) {
        this.model = model;
        this.horsePower = horsePower;
        this.dateManufactured = dateManufactured;
        this.topSpeed=topSpeed;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String name) {
        this.model = model;
    }

    public int gethorsePower() {
        return horsePower;
    }
    public void setHorsePower(int horsePower){
        this.horsePower=horsePower;
    }

    public String getDatemanufactured() {
        return dateManufactured;
    }

    public void setDateManufactured(String dateManufactured) {
        this.dateManufactured = dateManufactured;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

}
