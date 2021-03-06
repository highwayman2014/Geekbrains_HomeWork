package homeworkksix;

public class main {

    public static void main(String[] args) {

        Cat catMurzik = new Cat("Мурзик");
        catMurzik.swim(5);
        catMurzik.run(50);
        catMurzik.run(300);
        System.out.println();

        Animal catJoe = new Cat("Джо");
        catJoe.swim(5);
        catJoe.run(50);
        catJoe.run(300);
        System.out.println();

        Dog dogBobik = new Dog("Бобик");
        dogBobik.swim(10);
        dogBobik.run(450);
        dogBobik.run(1000);
        System.out.println();

        System.out.println("Создано животных " + catMurzik.getCountAnimals() + ", из них:");
        System.out.println(" " + catMurzik.getCountCats() + " кошек");
        System.out.println(" " + dogBobik.getCountDogs() + " собак");
    }
}
