package homeworkksix;

public class Dog extends Animal{

    private String name;
    private static int countDogs;

    protected int getCountDogs() {
        return countDogs;
    }

    protected Dog(String name){
        super(name, 500, 10);
        this.name = name;
        countDogs++;
    }

}
