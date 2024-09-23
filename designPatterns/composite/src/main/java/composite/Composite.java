package composite;
import java.util.List;
public class Composite implements Components {
    
    private String name;
    private List<Components> children;

    public Composite(String name){
        this.name = name;
    }

    public void add(Components components){
        children.add(components);
    }


    public void execute(){
        System.out.println("I'm composite"+ this.name);
    }
    
}
