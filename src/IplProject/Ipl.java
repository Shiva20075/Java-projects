package IplProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Ipl {


    // Stores total number of matches of all season
    Map<Integer, Integer> TotalNumberOfMatchesInAllSeasons = new HashMap<>();
    // Stores total number victoriesOfEacIPLTeam
    Map<String,Integer> victoriesOfEacIPLTeam = new HashMap<>();
    // Stores victories of each team per season
    Map<Integer,Map<String,Integer>> seasonData = new HashMap<>();
    // Stores extra runs scored by teams in year of 2016
    Map<String,Integer> extraRunsInYear = new HashMap<>();
    // Stores bowlers economy
    Map<String,Integer> topEconomicalBowlers = new HashMap<>();

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

    public void extraRuns(String battingTeam , int totalExtraRuns){
        if (extraRunsInYear.containsKey(battingTeam)){
            extraRunsInYear.put(battingTeam, extraRunsInYear.get(battingTeam) + totalExtraRuns);
        }else{
            extraRunsInYear.put(battingTeam,totalExtraRuns);
        }
    }


    public void topEconomicalBowelers (String bowler,int totalruns, int overs){;


        if (topEconomicalBowlers.containsKey(bowler)){

        }else{

        }

    }

    // MAIN METHOD
    public static void main(String[] args) throws IOException {

        Ipl ipl = new Ipl ();
        String filePathOfMatches = "/home/p/Downloads/archive/matches.csv";
        String filePathOfDeliveries = "/home/p/Downloads/archive/deliveries.csv";
        ArrayList <Matches> matchData = new ArrayList<>();
        ArrayList<Deliveries> deliveriesData = new ArrayList<>();

        try {

            ArrayList<String> matches = new ArrayList<>(Files.readAllLines(Paths.get(filePathOfMatches)));

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


/*
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

 */
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

       try {

           ArrayList<String> deliveries = new ArrayList<>(Files.readAllLines(Paths.get(filePathOfDeliveries)));


           for ( int i = 1; i < deliveries.size(); i++){

               String[] deliverie = deliveries.get(i).split(",");

               Deliveries data = new Deliveries();
               data.setMatchId(Integer.parseInt(deliverie[0]));
               data.setInings(Integer.parseInt(deliverie[1]));
               data.setBattingTeam(deliverie[2]);
               data.setBowlingTeam(deliverie[3]);
               data.setOver(Integer.parseInt(deliverie[4]));
               data.setBall(Integer.parseInt(deliverie[5]));
               data.setBatsman(deliverie[6]);
               data.setNotStriker(deliverie[7]);
               data.setBowler(deliverie[8]);
               data.setSuperOver(Integer.parseInt(deliverie[9]));
               data.setWideRuns(Integer.parseInt(deliverie[10]));
               data.setByeRuns(Integer.parseInt(deliverie[11]));
               data.setLegBye(Integer.parseInt(deliverie[12]));
               data.setNoBall(Integer.parseInt(deliverie[13]));
               data.setPenaltyRuns(Integer.parseInt(deliverie[14]));
               data.setBatsManRuns(Integer.parseInt(deliverie[15]));
               data.setExtraRuns(Integer.parseInt(deliverie[16]));
               data.setTotalRuns(Integer.parseInt(deliverie[17]));

               deliveriesData.add(data);
           }

       } catch (IOException e) {
           System.out.println("CANNOT FIND FILE");
       }

      Scanner s = new Scanner(System.in);

        int year  = s.nextInt();
        int firstId = 0;
        int lastId = 0;

      for ( int i = 0; i < matchData.size(); i++){
          if (matchData.get(i).getSeason() == year){
               firstId = matchData.get(i).getId();
              break;
          }
      }
      for ( int i = matchData.size() - 1; i >= 0; i-- ){
          if (matchData.get(i).getSeason() == year){
              lastId = matchData.get(i).getId();
              break;
          }
      }




        for ( int i = 0; i < deliveriesData.size(); i++) {

            if (deliveriesData.get(i).getMatchId() >= firstId && deliveriesData.get(i).getMatchId() <= lastId) {
                int totalExtraRuns = deliveriesData.get(i).getByeRuns() + deliveriesData.get(i).getNoBall() + deliveriesData.get(i).getLegBye() + deliveriesData.get(i).getWideRuns();
                ipl.extraRuns(deliveriesData.get(i).getBowlingTeam(), totalExtraRuns);
            }

            ipl.topEconomicalBowelers(deliveriesData.get(i).getBowler(), deliveriesData.get(i).getTotalRuns(),deliveriesData.get(i).getOver());

        }
        /*
        System.out.println("EXTRA RUNS IN -> " + year);
       for (String key : ipl.extraRunsInYear.keySet()){
           System.out.println("TEAM -> " + key + " | EXTRA RUNS -> " + ipl.extraRunsInYear.get(key));
       }


         */
       for (String key : ipl.topEconomicalBowlers.keySet()){
           System.out.println("BOWLER -> " + key + "overs -> " + ipl.topEconomicalBowlers.get(key));
       }
    }
}