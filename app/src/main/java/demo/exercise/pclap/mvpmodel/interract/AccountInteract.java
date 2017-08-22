package demo.exercise.pclap.mvpmodel.interract;

import java.util.List;

import demo.exercise.pclap.mvpmodel.commom.Constant;
import demo.exercise.pclap.mvpmodel.module.ItemSongResponse;
import demo.exercise.pclap.mvpmodel.module.ItemSongSearch;
import io.reactivex.Observable;

/**
 * Created by PC Lap on 8/22/2017.
 */
public class AccountInteract {

    private static AccountInteract instance = new AccountInteract();

    private AccountInteract(){

    }

    public static AccountInteract getInstance() {
        return instance;
    }

    //lay ra list danh sach cac bai hat
    public Observable<List<ItemSongResponse>> getMusicResponse(String name) {
        return ApiConnector.getApiConnector().getMusic(name);
    }

    //lay ra list danh ach cac item bao hat search
    public Observable<List<ItemSongSearch>> getMusicSearch(String name){
        return ApiConnector.getApiConnector().getListMusic(name,
                Constant.WEB_SITE_NAME,
                Constant.CODE);
    }

}
