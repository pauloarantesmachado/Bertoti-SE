package observer;

public class FinalCustomer implements ObserverI{

    private Double valueProduct;
        
    public void update(Double value){
        this.valueProduct = value*1.20;
    }

    public Double getValueProduct(){
        return this.valueProduct;
    }
    
}
