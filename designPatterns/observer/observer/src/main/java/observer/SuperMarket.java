package observer;

public class SuperMarket implements  ObserverI{

    private Double valueProduct;
        
    public void update(Double value){
        this.valueProduct = value*1.05;
    }
    
    public Double getValueProduct(){
        return this.valueProduct;
    }
}
