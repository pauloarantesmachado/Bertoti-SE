package observer;

import java.util.List;

public class Product {
  private String nameProduct;
  private Double valueProduct;
  private List<ObserverI> subscribe;

  public Product(String nameProduct){
    this.nameProduct = nameProduct;
    this.valueProduct = 0.0; 
  }

  public void addSubscriber(ObserverI sub){
    this.subscribe.add(sub);
  }

  public void updateValue(Double value){
    this.valueProduct = value;
    subscribe.forEach(e -> e.update(value));
  }
  
}
