package homeworkseven.service;

import homeworkseven.model.Plate;

public class PlateService {

    private Plate plate;

    public PlateService(Plate plate) {
        this.plate = plate;
    }

    public void plateInfo(){
        System.out.println("Plate: " + this.plate.getFoodCount());
    }

    public void addFood(int foodCount){
        this.plate.setFoodCount(this.plate.getFoodCount() + foodCount);
    }
}
