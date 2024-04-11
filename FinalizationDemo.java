public class FinalizationDemo {  
  public static void main(String[] args) {  
    Cake c1 = new Cake(1);  
    Cake c2 = new Cake(2);  
    Cake c3 = new Cake(3);  
    
    System.out.println("c1： " + c1);  
    System.out.println("c2： " + c2);  
    System.out.println("c3： " + c3);  

    c2 = c3 = null;  
    System.gc(); //调用Java垃圾收集器

    System.out.println("c11： " + c1);  
    System.out.println("c22： " + c2);  
    System.out.println("c33： " + c3);  

  }  
}  
 
class Cake extends Object {  
  private int id;  
  public Cake(int id) {  
    this.id = id;  
    System.out.println("Cake Object " + id + " is created");  
  }  
    
  protected void finalize() throws java.lang.Throwable {  
    super.finalize();  
    System.out.println("Cake Object " + id + " is disposed");  
  }  
}