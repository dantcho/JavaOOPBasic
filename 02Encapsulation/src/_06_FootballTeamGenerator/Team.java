package _06_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Team {
    private String name;
    private HashMap<String, Player> players;

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
