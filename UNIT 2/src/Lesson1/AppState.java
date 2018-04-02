package Lesson1;

public enum AppState {
    INIT(2), PREPARE(4), WORK(5), SAVE(10), TERMINATE(1);

    private int priority;

    public int getPriority() {
        return priority;
    }

    private AppState(int priority) {
        this.priority = priority;
    }
}
