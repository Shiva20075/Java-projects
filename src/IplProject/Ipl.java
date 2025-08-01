package IplProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Ipl {

    
    // Stores total number of matches of all season
    Map<Integer, Integer> TotalNumberOfMatchesInAllSeasons = new HashMap<>();
    // Stores total number victoriesOfEacIPLTeam
    Map<String,Integer> victoriesOfEacIPLTeam = new HashMap<>();
    // Stores victories of each team per season
    Map<Integer,Map<String,Integer>> seasonData = new HashMap<>();

    // Records total matches held in each season
    public void matchesPerYear(int season){
        if (TotalNumberOfMatchesInAllSeasons.containsKey(season)){
            TotalNumberOfMatchesInAllSeasons.put(season,TotalNumberOfMatchesInAllSeasons.get(season) + 1);
        }else{
            TotalNumberOfMatchesInAllSeasons.put(season,1);
        }
    }

    // Records victory for a team
    public void matchesWonByPerTeam (String matchWinners){
        if (victoriesOfEacIPLTeam.containsKey(matchWinners)) {
            victoriesOfEacIPLTeam.put(matchWinners, victoriesOfEacIPLTeam.get(matchWinners) + 1);
        } else {
            victoriesOfEacIPLTeam.put(matchWinners, 1);
        }
    }

    // Records team victories by season
    public void matchesWonByTeamPerYear(String matchWinners,int season){
        if(seasonData.containsKey(season)){
            Map<String,Integer> TeamsWon = seasonData.get(season);
            if (TeamsWon.containsKey((matchWinners))){
                TeamsWon.put(matchWinners,TeamsWon.get(matchWinners) + 1);
            }else {
                TeamsWon.put(matchWinners,1);
            }
        }else {
            Map<String,Integer> TeamsWon = new HashMap<>();
            TeamsWon.put(matchWinners,1);
            seasonData.put(season,TeamsWon);
        }
    }

    // MAIN METHOD
    public static void main(String[] args) throws IOException {

        String filePath = "/home/p/Downloads/archive/matches.csv";
        ArrayList <Matches> matchData = new ArrayList<>();

        try {

            ArrayList<String> matches = new ArrayList<>(Files.readAllLines(Paths.get(filePath)));

            for ( int i = 1; i < matches.size(); i++) {

                String[] data = matches.get(i).trim().split(",");

                    Matches match = new Matches(); // creating Matches object
                    match.setId(Integer.parseInt(data[0]));
                    match.setSeason(Integer.parseInt(data[1]));
                    match.setCity(data[2]);
                    match.setDate(data[3]);
                    match.setTeam1(data[4]);
                    match.setTeam2(data[5]);
                    match.setTossWinner(data[6]);
                    match.setTossDecision(data[7]);
                    match.setResult(data[8]);
                    match.setDlApplied(data[9]);
                    match.setWinner(data[10]);
                    match.setWinByRuns(Integer.parseInt(data[11]));
                    match.setWinByWickets(Integer.parseInt(data[12]));
                    match.setPlayerOfMatch(data[13]);
                    match.setVenue(data[14]);

                    if ( data.length >= 16){

                    if (!data[15].isEmpty()) {
                        match.setUmpire1(data[15]);
                    }
                    if (!data[16].isEmpty()) {
                        match.setUmpire2(data[16]);
                    }
                    matchData.add(match);
                }
            }
        }catch (IOException e) {
            System.out.println("FILE NOT FOUND");
        }

        Ipl ipl = new Ipl ();

        for ( int i = 0; i < matchData.size();i++) {

           ipl.matchesPerYear(matchData.get(i).getSeason());

            if (!matchData.get(i).getWinner().isEmpty()){
                ipl.matchesWonByPerTeam(matchData.get(i).getWinner());
            }

            ipl.matchesWonByTeamPerYear(matchData.get(i).getWinner(),matchData.get(i).getSeason());
        }

       for (Integer key : ipl.TotalNumberOfMatchesInAllSeasons.keySet()){
          System.out.println("YEAR -> " + key + " |  MATCHES -> " + ipl.TotalNumberOfMatchesInAllSeasons.get(key));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

       for (String key : ipl.victoriesOfEacIPLTeam.keySet()){
           System.out.println("TeamName -> " + key + " |  VICTORIES " + ipl.victoriesOfEacIPLTeam.get(key));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

       for (Map.Entry<Integer, Map<String, Integer>> outerEntry : ipl.seasonData.entrySet()){
           Integer season = outerEntry.getKey();
           Map<String, Integer> TeamsWon = outerEntry.getValue();

           System.out.println("YEAR: " + season);
           for (Map.Entry<String, Integer> innerEntry : TeamsWon.entrySet()) {
               String team = innerEntry.getKey();
               Integer wins = innerEntry.getValue();
               System.out.println(" TEAM: " + team + " | WINS: " + wins);
           }
       }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}