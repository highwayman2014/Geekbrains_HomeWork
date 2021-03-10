package homeworkseven.service;

import homeworkseven.model.Cat;
import homeworkseven.model.Plate;

public class CatService {

    private Cat cat;

    public CatService(Cat cat) {
        this.cat = cat;
    }

    public void eat (Plate plate){
        if (this.cat.getAppetite() > plate.getFoodCount()){
            //System.out.println("В тарелке " + plate.getFoodCount() + " еды, а кот хочет " + this.cat.getAppetite());
            return;
        }

        plate.setFoodCount(plate.getFoodCount() - this.cat.getAppetite());
        this.cat.setHungry(false);
    }

    public void hungryInfo(){
        if (this.cat.isHungry()) {
            System.out.println(this.cat.getName() + " хочет кушать");
        }else{
            System.out.println(this.cat.getName() + " не хочет кушать");
        }
    }

}
