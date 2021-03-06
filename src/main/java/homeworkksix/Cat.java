package homeworkksix;

public class Cat extends Animal{

    private String name;
    private static int countCats;

    protected int getCountCats() {
        return countCats;
    }

    protected Cat(String name){
        super(name, 200, 0);
        this.name = name;
        countCats++;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public boolean isCat(){
        return true;
    }
}
