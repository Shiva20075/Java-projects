package Song;

public class SongRunner {

    public static void main (String[] args){

        Songs songRunner = new Songs("HONEY", "sai", 4.5);

        songRunner.setSongName("SHAPE OF U");
        songRunner.setArtist("SHIVA");
        songRunner.setSongDuration(3.4);
     //   songRunner.songInfo();

        Songs songRunner2 = new Songs("HONEY2", "sai2", 4.5);

        Playlist playList = new Playlist();

        playList.addSong(songRunner);
        playList.addSong(songRunner2);
        playList.showSong();
    }
}
