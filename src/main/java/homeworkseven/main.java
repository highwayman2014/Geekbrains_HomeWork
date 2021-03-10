package homeworkseven;

import homeworkseven.model.Cat;
import homeworkseven.model.Plate;
import homeworkseven.service.CatService;

public class main {

    public static void main(String[] args) {

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Чарли", 20);
        cats[1] = new Cat("Тася", 10);
        cats[2] = new Cat("Мурка", 15);
        cats[3] = new Cat("Флокс", 30);
        cats[4] = new Cat("Жора", 25);

        Plate plate = new Plate(50);

        for (int i = 0; i < cats.length; i++) {
            CatService catService = new CatService(cats[i]);
            catService.eat(plate);
            catService.hungryInfo();
        }



    }
}
