package org.learning.services8;

public class Courses {

        private ICourses course;

        public Courses(ICourses course) {
            super();
            this.course = course;
        }
    
        public Courses() {
            super();
        }

        public void setCourse(ICourses course) {
            this.course = course;
        }

        public boolean buyTheCourse(Double amount){
            return course.getTheCourse(amount);
        }

        public static void main(String[] args) {
            //Injecting dependent object/depedency into target class is called as dependecy injection
            // If this is done through setter we call as setter injection
            // if this is done through constructor its called as constructor injection
            //target class/object == > a class where services of other classes are being used
            //ex in this project == > Telusko class
            //dependent object/class == > a class whose services will be used in target class
            //ex in this project == > Java, DevOps, SpringBoot course
            Courses courses = new Courses(new Java()); //constructor injection
            courses.setCourse(new SpringBoot()); //setter injection
            boolean status = courses.buyTheCourse(2500.00);
            if(status){
                System.out.println("Course purchased successfully!");
            } else{
                System.out.println("Failed to but the course!");
            }
        }
    }
