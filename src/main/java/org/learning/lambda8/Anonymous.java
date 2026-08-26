package org.learning.lambda8;

class A {
    public void show(){
        System.out.println("In A Show");
    }
}

class B extends A{
    public void show(){
        System.out.println("In B Show");
    }
}
public class Anonymous {
    public static void main(String[] args) {
          A obj = new A(){//class inside class or anonymous inner class
          public void show(){
              System.out.println("in new show");
          }
          public void getData(){
              System.out.println("new data");
          }
        };
//      obj.show(); //working
//      obj.getData(); //Error

        new A(){//anonymous Object creation of a class
            public void show(){
                System.out.println("in new show");
            }
            public void getData(){
                System.out.println("new data");
            }
        }.show();

    }
}