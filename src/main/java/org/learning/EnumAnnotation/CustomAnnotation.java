package org.learning.EnumAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//we can create our own annotation with the help of interface
//while creating annotations we need to specify 2 things :
// i)target of annotation eg:class,variable,instance variable, constructor
// example @override is for Methods not for classes ;this is called target
//ii)Retention policy
@Retention(RetentionPolicy.RUNTIME)
//single Target
//@Target(ElementType.TYPE) //for class/interface
//Multiple Targets
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
    // in above line, TYPE & RUNTIME are enums
@interface CricketPlayer{
    //@this specifies Compilier that annotation type is being created
    String country() default "India";
    int age() default 29;
}

//@CricketPlayer(country = "India") //single valued annotation
//@CricketPlayer("India") //Valid
@CricketPlayer(country = "India", age = 35) //Multi Valued annotation
//@CricketPlayer //valid
//Virat Kohli is a cricket player who lives in india
class ViratKohli {
    private int innings;

    public ViratKohli() {

    }

    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }
}

public class CustomAnnotation {
    public static void main(String[] args) {
        ViratKohli virat = new ViratKohli();
        virat.setInnings(5);
        System.out.println(virat.getInnings());

        //if we want to  know ,what are there inside the annotation
        //I can use reflection api to fetch the data
        System.out.println("*****************");
        Class<? extends ViratKohli> c = virat.getClass();
        CricketPlayer an = c.getAnnotation(CricketPlayer.class);
        CricketPlayer cp = (CricketPlayer)an;
        int age = cp.age();
        String co = cp.country();
        System.out.println("Info of attributes of annotations "+age+" "+co);
    }
}
