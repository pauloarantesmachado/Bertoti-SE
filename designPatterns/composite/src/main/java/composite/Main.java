package composite;
public class Main {
    public static void main(String[] args) {
        Composite fatherComponents = new Composite("Header");
        Leaf sonCompoenets = new Leaf("Button");
        fatherComponents.add(sonCompoenets);
    }
}
