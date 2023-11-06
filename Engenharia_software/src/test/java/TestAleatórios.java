import org.junit.Assert;
import org.junit.Test;

public class TestAleatórios {


    @Test
    public void soma(){
         Integer num1 = 10;
         Integer num2 = 20;
        Assert.assertEquals(30,num1+num2);
    }

   @Test
    public void produto (){
        Integer num1 = 10;
        Integer num2 = 20;
        Assert.assertEquals(200,num1*num2);
    }
}
