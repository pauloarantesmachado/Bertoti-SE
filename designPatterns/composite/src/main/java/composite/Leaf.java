package composite;
public class Leaf implements Components {
    private String name;

    public Leaf(String name){
        this.name = name;
    }

    public void execute(){
        System.out.println("I'm Leaf"+ this.name);
    }

}
