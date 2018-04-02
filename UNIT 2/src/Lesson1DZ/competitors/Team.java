package Lesson1DZ.competitors;



public class Team {
    public Competitor[] competitors;

    public Team() {
        Competitor[]competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        this.competitors = competitors;
    }



    public void showResults() {
        for (Competitor c: competitors){
            c.showResult();
        }
    }
}
