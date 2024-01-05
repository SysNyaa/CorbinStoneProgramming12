package sorting;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PlayerSorting {

    public static void main(String[] args) {
        String csvFilePath = "src/sorting/PlayerData.csv";
        List<PlayerBattingStats> players = readCSV(csvFilePath);

        PlayerSorting sorting = new PlayerSorting();

        try (PrintWriter writer = new PrintWriter("src/sorting/sorted_players.txt")) {
            // Sort and output players by Games Played
            writer.println("Sorted by Games Played:");
            printSortedPlayers(writer, sorting.sortByGamesPlayed(players));

            // Sort and output players by Runs
            writer.println("\nSorted by Runs:");
            printSortedPlayers(writer, sorting.sortByRuns(players));

            // Sort and output players by Hits
            writer.println("\nSorted by Hits:");
            printSortedPlayers(writer, sorting.sortByHits(players));

            // Sort and output players by Home Runs
            writer.println("\nSorted by Home Runs:");
            printSortedPlayers(writer, sorting.sortByHomeRuns(players));

            // Sort and output players by RBIs
            writer.println("\nSorted by RBIs:");
            printSortedPlayers(writer, sorting.sortByRBIs(players));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printSortedPlayers(PrintWriter writer, List<PlayerBattingStats> players) {
        for (PlayerBattingStats player : players) {
            writer.println("Name: " + player.getName());
            writer.println("Team: " + player.getTeam());
            writer.println("Games Played: " + player.getGames());
            writer.println("Runs: " + player.getRuns());
            writer.println("Hits: " + player.getHits());
            writer.println("Doubles: " + player.getDoubles());
            writer.println("Triples: " + player.getTriples());
            writer.println("Home Runs: " + player.getHomeRuns());
            writer.println("RBIs: " + player.getRbi());
            writer.println(); // Empty line to separate players
        }
    }

    // Read the CSV file and create a list of players
    public static List<PlayerBattingStats> readCSV(String fileName) {
        List<PlayerBattingStats> players = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    PlayerBattingStats player = new PlayerBattingStats(
                            data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                            Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                            Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9])
                    );
                    players.add(player);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    // Sorting methods
    public List<PlayerBattingStats> sortByGamesPlayed(List<PlayerBattingStats> players) {
        return players.stream()
                .sorted(Comparator.comparingInt(PlayerBattingStats::getGames).reversed())
                .collect(Collectors.toList());
    }

    public List<PlayerBattingStats> sortByRuns(List<PlayerBattingStats> players) {
        return players.stream()
                .sorted(Comparator.comparingInt(PlayerBattingStats::getRuns).reversed())
                .collect(Collectors.toList());
    }

    public List<PlayerBattingStats> sortByHits(List<PlayerBattingStats> players) {
        return players.stream()
                .sorted(Comparator.comparingInt(PlayerBattingStats::getHits).reversed())
                .collect(Collectors.toList());
    }

    public List<PlayerBattingStats> sortByHomeRuns(List<PlayerBattingStats> players) {
        return players.stream()
                .sorted(Comparator.comparingInt(PlayerBattingStats::getHomeRuns).reversed())
                .collect(Collectors.toList());
    }

    public List<PlayerBattingStats> sortByRBIs(List<PlayerBattingStats> players) {
        return players.stream()
                .sorted(Comparator.comparingInt(PlayerBattingStats::getRbi).reversed())
                .collect(Collectors.toList());
    }
}
