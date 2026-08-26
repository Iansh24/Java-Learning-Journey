package org.learning.EnumAnnotation14;

enum Result{
    PASS, FAIL; // these are static and final
    //behind scene -> public static final RESULT PASS = new RESULT()
    //behind scene -> public static final RESULT PASS = new RESULT()
//    1) enum inside enum possible
//    enum Week{
//        MON, TUES;
//    }

    int marks;
    Result(){
        System.out.println("Constructor of enum");
    }
    public void setMarks(int marks){
        this.marks = marks;
    }
    public int getMarks(){
        return marks;
    }
}

enum Week{
    MON,TUES,WED,THU,FRI,SAT,SUN;
    //these constants belong to week type
    //they are values and variables itself
}

public class Enumeration {
    public static void main(String[] args) {
        Week week = Week.MON;
        System.out.println(week);
        int index = Week.MON.ordinal();
        System.out.println(index);
        Week[] weekAr = Week.values(); //value gives array of Week
        for(Week w : weekAr){
            System.out.println(w.ordinal()+"->"+w);
        }

//      constructor of PASS & FAIL BOTH WILL BW CALLED DURING RUNTIME
        Result.PASS.setMarks(44);
        int marks = Result.PASS.getMarks();
        System.out.println(marks); //44
        int marks2 = Result.FAIL.getMarks();
        System.out.println(marks2); //0
    }
}
