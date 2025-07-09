package Song;
import java.util.ArrayList;
import java.util.List;
public class Playlist {

    List<Songs> songsList = new ArrayList<>();

    public void addSong(Songs song) {
        songsList.add(song);
    }

    public void showSong() {

        for ( int i = 0; i < songsList.size(); i++){

           Songs sngs = songsList.get(i);
           sngs.songInfo();
        }

        }
}
