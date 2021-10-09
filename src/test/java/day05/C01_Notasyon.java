package day05;

import org.junit.Test;

public class C01_Notasyon {
    public void siradanMethod() {
        System.out.println("ilk method");
    }

@Test
 public void testMethod() {
     System.out.println("ikinci method");
    }
    // junit ile annotation kullanarak siradan methodlari test methodu yaparak direk kullanabiliriz
    // dolayisiyla main method mecburiyeti ortadan kalkar
}
