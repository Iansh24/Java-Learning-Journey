package org.learning.EnumAnnotation14;

class Animal {
    public void animalUsuallyHuntsAndEat() {
        System.out.println("Animal is eating....");
    }
}

class Tiger extends Animal {
    @Override
    //overriding parent class method to suite child requirements!
    //with the help of comments,a developer can understand what happened here
    //but, compiler/jvm not getting what happened
    //so here comes Annotations
    //with the help of annotations,we can tell developer metadata/information about code
    //if we don't do this, other developer will not eb able to understand code
    //Annotation - a new of maintaining the code in java so that developer,springboot,JVM doesn't find ambiguity
    public void animalUsuallyHuntsAndEat() {
        System.out.println("Tiger hunts and eats...");
    }
}

public class Annotation {
    public static void main(String[] args) {
        Tiger t = new Tiger();
        t.animalUsuallyHuntsAndEat();
    }
}
