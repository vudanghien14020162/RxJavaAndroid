package demo.exercise.pclap.mvpmodel.interract;

import java.util.List;

import demo.exercise.pclap.mvpmodel.module.ItemSongSearch;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by PC Lap on 8/22/2017.
 */
public interface APIServer {

    @GET("jOut.ashx")
    Observable<List<ItemSongSearch>> queryMusic(@Query("k") String musicName, @Query("h") String webSite,
                                                @Query("code") String code);
}
