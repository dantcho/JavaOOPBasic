package paw.models.animals;

public class Dog extends Animal {
    private int commandsLearned;

    public void setCommandsLearned(int commandsLearned) {
        if (commandsLearned > 0)
            this.commandsLearned = commandsLearned;
    }

    public Dog(String name, int age, int commandsLearned, String aCenter) {
        super(name, age);
        this.setAdoptionCenter(aCenter);
        this.setCommandsLearned(commandsLearned);
    }
}
