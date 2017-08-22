package demo.exercise.pclap.mvpmodel.ui.main.music;

import java.util.List;

import demo.exercise.pclap.mvpmodel.interract.AccountInteract;
import demo.exercise.pclap.mvpmodel.module.ItemSongResponse;
import demo.exercise.pclap.mvpmodel.module.ItemSongSearch;
import demo.exercise.pclap.mvpmodel.ui.Action;
import demo.exercise.pclap.mvpmodel.ui.base.presenter.BasePresenter;

/**
 * Created by PC Lap on 8/22/2017.
 */
public class ListMusicPresenter extends BasePresenter<IListMusic.View> implements IListMusic.Presenter {


    public ListMusicPresenter(IListMusic.View mView) {
        super(mView);
    }

    @Override
    public void getMusic(String name) {
        interact(AccountInteract.getInstance().getMusicResponse(name),
                new Action<List<ItemSongResponse>>() {
                    @Override
                    public void call(List<ItemSongResponse> itemSongResponses) {
                        mView.finishGetMusic(itemSongResponses);
                    }
                }, new Action<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.errorGetMusic(throwable);
                    }
                });

    }

    @Override
    public void getItemSongSearch(String nameMusic) {
        interact(AccountInteract.getInstance().getMusicSearch(nameMusic),
                new Action<List<ItemSongSearch>>() {
                    @Override
                    public void call(List<ItemSongSearch> itemSongSearches) {
                        mView.finishGetListMusic(itemSongSearches);
                    }
                }, new Action<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.errorGetMusicSearch(throwable);
                    }
                });
    }

}
