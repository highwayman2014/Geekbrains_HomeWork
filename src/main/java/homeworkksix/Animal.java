package homeworkksix;

public class Animal {

    private String animalName;
    private int animalRunLimit;
    private int animalSwimLimit;
    public static int countAnimals;

    protected int getCountAnimals() {
        return countAnimals;
    }

    protected Animal(String animalName, int animalRunLimit, int animalSwimLimit){
        this.animalName = animalName;
        this.animalRunLimit = animalRunLimit;
        this.animalSwimLimit = animalSwimLimit;
        countAnimals++;
    }

    public void run(int distance){
        if (distance > animalRunLimit){
            System.out.println(this.animalName + " не может пробежать " + distance + " метров");
        }else {
            System.out.println(this.animalName + " пробежал " + distance + " метров");
        }
    }

    public void swim(int distance){
        if (distance > animalSwimLimit){
            System.out.println(this.animalName + " не может проплыть " + distance + " метров");
        }else{
            System.out.println(this.animalName + " проплыл " + distance + " метров");
        }
    }

    public boolean isCat(){
        return false;
    }


}
