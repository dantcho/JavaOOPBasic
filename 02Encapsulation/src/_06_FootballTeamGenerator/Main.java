package _06_FootballTeamGenerator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
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

}
