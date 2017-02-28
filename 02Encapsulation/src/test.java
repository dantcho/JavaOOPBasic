import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HashMap<String, Team> teams = new HashMap<>();
        while (!input.equals("END")) {
            String[] token = input.split(";");
            String command = token[0];
            String teamName = token[1];
            switch (command) {
                case "Team":
                    try {
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add":
                    if (!teams.containsKey(teamName)) {
                        System.out.println("Team " + teamName + " does not exist.");
                        break;
                    }
                    String playerName = token[2];
                    int endurance = Integer.parseInt(token[3]);
                    int sprint = Integer.parseInt(token[4]);
                    int dribble = Integer.parseInt(token[5]);
                    int passing = Integer.parseInt(token[6]);
                    int shooting = Integer.parseInt(token[7]);
                    try {
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamName).addPlayer(player);

                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Remove":
                    if (!teams.containsKey(teamName)) {
                        System.out.println("Team " + teamName + " does not exist.");
                        break;
                    }
                    try {
                        teams.get(teamName).removePlayer(token[2]);

                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Rating":
                    if (!teams.containsKey(teamName)) {
                        System.out.println("Team " + teamName + " does not exist.");
                        break;
                    }
                    teams.get(teamName).printOverall();
                    break;
            }
            input = reader.readLine();
        }
    }

    public static class Player {
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

    public static class Team {
        private String name;
        private HashMap<String,Player> players;

        public String getName() {
            return this.name;
        }

        public Team(String name) {
            this.name = name;
            this.players = new HashMap<>();
        }

        private void setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("A name should not be empty.");
            } else this.name = name;
        }

        public void addPlayer(Player player) {
            this.players.put(player.getName(), player);
        }

        public void removePlayer(String player) {
            if (this.players.containsKey(player))
                this.players.remove(player);
            else throw new IllegalArgumentException("Player " + player + " is not in " + this.getName() + " team. ");
        }

        public double getOverall() {
            double rerunValue = 0;
            if (this.players.size()==0)return 0;
            for (Player player : this.players.values()) {
                rerunValue += player.getOverall();
            }
            return rerunValue / this.players.size();
        }

        public void printOverall() {
            System.out.println(this.getName() + " - " + String.format("%.0f",this.getOverall()));
        }
    }

}
