package Lesson1DZ;

import Lesson1DZ.competitors.*;
import Lesson1DZ.obstacles.*;

public class MainClass {
    public static void main(String[] args) {
        Course course = new Course();
        Team team = new Team();

        course.doIt(team);

        team.showResults();


    }
}
