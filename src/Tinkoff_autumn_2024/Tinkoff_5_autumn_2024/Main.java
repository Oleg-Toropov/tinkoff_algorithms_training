package Tinkoff_autumn_2024.Tinkoff_5_autumn_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
public class Main {
    static class Team {
        String name;
        int hackedServers;
        int penaltyTime;
        Map<Character, Server> serverAttempts;

        public Team(String name) {
            this.name = name;
            this.hackedServers = 0;
            this.penaltyTime = 0;
            this.serverAttempts = new HashMap<>();
        }
    }
    static class Server {
        boolean hacked;
        int attempts;

        public Server() {
            this.hacked = false;
            this.attempts = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        int startSeconds = timeToSeconds(start);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Team> teams = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");

            String name = parts[0].substring(1, parts[0].length() - 1);
            String event = parts[1];
            char serverId = parts[2].charAt(0);
            String result = parts[3];

            Team team = teams.computeIfAbsent(name, t -> new Team(name));
            if (result.equals("PONG")) {
                continue;
            }

            Server server = team.serverAttempts.computeIfAbsent(serverId, s -> new Server());
            if (server.hacked) {
                continue;
            }

            if (result.equals("ACCESSED")) {
                server.hacked = true;
                team.hackedServers++;
                team.penaltyTime += getTimeDifferenceInMinutes(startSeconds, timeToSeconds(event));
                team.penaltyTime += server.attempts * 20;

            } else if (result.equals("DENIED") || result.equals("FORBIDEN")) {
                server.attempts++;
            }
        }

        List<Team> sortedTeams = getSortedTeams(teams);

        int place = 1;

        for (int i = 0; i < sortedTeams.size(); i++) {
            if (i > 0 && (sortedTeams.get(i).hackedServers != sortedTeams.get(i - 1).hackedServers ||
                    sortedTeams.get(i).penaltyTime != sortedTeams.get(i - 1).penaltyTime)) {
                place = i + 1;
            }

            System.out.println(place + " \"" + sortedTeams.get(i).name + "\" "
                    + sortedTeams.get(i).hackedServers + " " + sortedTeams.get(i).penaltyTime);
        }
    }

    private static List<Team> getSortedTeams(Map<String, Team> teams) {
        List<Team> listTeams = new ArrayList<>(teams.values());

        listTeams.sort((t1, t2) -> {
            if (t1.hackedServers != t2.hackedServers) {
                return t2.hackedServers - t1.hackedServers;
            } else if (t1.penaltyTime != t2.penaltyTime) {
                return t1.penaltyTime - t2.penaltyTime;
            } else {
                return t1.name.compareTo(t2.name);
            }
        });

        return listTeams;
    }

    private static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);

        return h * 3600 + m * 60 + s;
    }

    private static int getTimeDifferenceInMinutes(int startSeconds, int eventSeconds) {
        int result = eventSeconds - startSeconds;

        if (result < 0) {
            result += 24 * 3600;
        }

        return result / 60;
    }
}
