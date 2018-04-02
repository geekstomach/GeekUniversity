package Lesson1DZ.obstacles;

import Lesson1DZ.competitors.*;


public class Course {
    Obstacle[] course;

    public Course() {
        Obstacle[] course = {new Cross(400), new Wall(8), new Water(1)};
        this.course = course;
    }


/*    public void doIt(Team team) {
        for (Competitor c: competitors){
            for (Obstacle o: course){
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }*/
    public void doIt(Team team) {

        for (Competitor c: team.competitors){
            for (Obstacle o: course){
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
        }

}
