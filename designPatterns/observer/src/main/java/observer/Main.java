package observer;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("OMO");
        ObserverI superMarket = new SuperMarket();
        ObserverI finalCustomer = new FinalCustomer();
        product.addSubscriber(superMarket);
        product.addSubscriber(finalCustomer);

        product.updateValue(10.50);
        System.out.println(superMarket.getValueProduct());
        System.out.println(finalCustomer.getValueProduct());
    }
}