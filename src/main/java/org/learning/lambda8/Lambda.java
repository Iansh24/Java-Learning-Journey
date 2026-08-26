package org.learning.lambda8;

//normal interface -> interface with multiple methods
//SAM/(single abstract method)/(Functional interface)  interface -> interface with multiple methods
//Marker interface -> interface with NO methods

@FunctionalInterface
interface P {
    //    void show();
//    default void show2(){
//        System.out.println("In B Show");
//    }
    int add(int x, int y);
}

class PImpl implements P {
    @Override
    public int add(int x, int y) {
        return x + y;
    }
}
public class Lambda {
    public static void main(String[] args) {
//        EXAMPLE 1
//       P obj = new P(){
//       public void show(){
//          System.out.println("In Show");
//          }
//      };
//
//        OR
//
//        P obj = () -> System.out.println("In show"); //Lambda expression->shortform
//        obj.show();

//        EXAMPLE 2
//        P p1 = new PImpl(){
//            public int add(int x, int y) {
//                return x + y + 1;
//            }
//        };
//        int res =  p1.add(10, 20);
//        System.out.println(res);
//
//        OR

//        P p = (int x, int y) -> {
//            return x + y + 1;
//        }; or
        P p = (x, y) -> x + y + 2; //beauty of lambda expression
        int res =  p.add(10, 20);
        System.out.println(res);
    }
}
