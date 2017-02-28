package _06_FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }


    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        } else this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getEndurance() {
        return this.endurance;
    }

    private void setEndurance(int endurance) {
        checkValidity(endurance, "Endurance");
        this.endurance = endurance;
    }


    public int getSprint() {
        return this.sprint;
    }

    private void setSprint(int sprint) {
        checkValidity(sprint, "Sprint");
        this.sprint = sprint;
    }

    public int getDribble() {
        return this.dribble;
    }

    private void setDribble(int dribble) {
        checkValidity(dribble, "Dribble");
        this.dribble = dribble;
    }

    public int getPassing() {
        return this.passing;
    }

    private void setPassing(int passing) {
        checkValidity(passing, "Passing");
        this.passing = passing;
    }

    public int getShooting() {
        return this.shooting;
    }

    private void setShooting(int shooting) {
        checkValidity(shooting, "Shooting");
        this.shooting = shooting;
    }


    private void checkValidity(int endurance, String field) {
        if (endurance < 1 || endurance > 100) {
            throw new IllegalArgumentException(field + " should be between 0 and 100.");
        }
    }

    public double getOverall() {
        double returnValue =
                (double)(this.getEndurance() + this.getDribble() + this.getPassing() + this.getShooting() + this.getSprint()) / 5;
        return returnValue;
    }

}
