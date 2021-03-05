package homeworkksix;

public class main {

    public static void main(String[] args) {

        int countCats = 0;
        int countDogs = 0;

        Animal catMurzik = new Cat("Мурзик");
        catMurzik.swim(5);
        catMurzik.run(50);
        catMurzik.run(300);
        System.out.println();
        if(catMurzik.isCat()) {
            countCats++;
        }else{
            countDogs++;
        }

        Animal catJoe = new Cat("Джо");
        catJoe.swim(5);
        catJoe.run(50);
        catJoe.run(300);
        System.out.println();
        if(catJoe.isCat()) {
            countCats++;
        }else{
            countDogs++;
        }

        Animal dogBobik = new Dog("Бобик");
        dogBobik.swim(10);
        dogBobik.run(450);
        dogBobik.run(1000);
        System.out.println();
        if(dogBobik.isCat()) {
            countCats++;
        }else{
            countDogs++;
        }

        int countAnimals = countCats + countDogs;
        System.out.println("Создано животных " + countAnimals + ", из них:");
        System.out.println(" " + countCats + " кошек");
        System.out.println(" " + countDogs + " собак");
    }
}
