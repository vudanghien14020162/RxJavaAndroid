package demo.exercise.pclap.mvpmodel.ui.main.music;

import java.util.List;

import demo.exercise.pclap.mvpmodel.module.ItemSongResponse;
import demo.exercise.pclap.mvpmodel.module.ItemSongSearch;
import demo.exercise.pclap.mvpmodel.ui.IBasePresenter;
import demo.exercise.pclap.mvpmodel.ui.IViewMain;

/**
 * Created by PC Lap on 8/22/2017.
 */
public interface IListMusic {

    //giao tiep voi view
    interface View extends IViewMain{

        void finishGetMusic(List<ItemSongResponse> itemSongResponses);

        void errorGetMusic(Throwable error);

        void finishGetListMusic(List<ItemSongSearch> response);

        void errorGetMusicSearch(Throwable error);
    }

    //giao tiep voi interact
    interface Presenter extends IBasePresenter{
        void getMusic(String s);

        void getItemSongSearch(String nameMusic);
    }
}
