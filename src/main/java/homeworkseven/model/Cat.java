package homeworkseven.model;

import java.util.Objects;

public class Cat {

    private String name;
    private boolean isHungry;
    private int appetite;

    public Cat(){
        this.name = "empty";
        this.isHungry = true;
        this.appetite = 15;
    }

    public Cat(String name, int appetite){
        this.name = name;
        this.isHungry = true;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return isHungry == cat.isHungry && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isHungry);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", isHungry=" + isHungry +
                '}';
    }
}
