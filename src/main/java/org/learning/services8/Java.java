package org.learning.services8;

public class Java implements ICourses{
    public Boolean getTheCourse(Double amount){
        System.out.println("Java course purchased succesfully & price paid is : "+amount);
        return true;
    }
}
