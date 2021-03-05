package homeworkksix;

public class Cat extends Animal{

    private String name;

    protected Cat(String name){
        super(name, 200, 0);
        this.name = name;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public boolean isCat(){
        return true;
    }
}
