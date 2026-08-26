package org.learning.services;

public class SpringBoot implements ICourses{
    public Boolean getTheCourse(Double amount){
        System.out.println("SpringBooot course purchased succesfully & price paid is : "+amount);
        return true;
    }
}
