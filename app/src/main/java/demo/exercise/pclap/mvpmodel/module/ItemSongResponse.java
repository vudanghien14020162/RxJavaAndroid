package demo.exercise.pclap.mvpmodel.module;

/**
 * Created by PC Lap on 8/22/2017.
 */
public class ItemSongResponse {

    private String dataCode;
    private String tile;

    public ItemSongResponse(String dataCode, String tile) {
        this.dataCode = dataCode;
        this.tile = tile;
    }

    public String getDataCode() {
        return dataCode;
    }

    public String getTile() {
        return tile;
    }
}
