package homeworkseven.model;

public class Plate {

    private int foodCount;

    public Plate() {
        this.foodCount = 15;
    }

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

}
