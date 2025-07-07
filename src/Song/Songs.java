package Song;

public class Songs {

    private String songName ;
    private String artist;
    private double songDuration;

    Songs (String songName, String artist, double songDuration){

        this.songName = songName;
        this.songDuration = songDuration;
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    public void songInfo(){

        System.out.println("SONG NAME = " + songName);
        System.out.println("ARTIST = " + artist);
        System.out.println("DURATION = " + songDuration);
    }
}
