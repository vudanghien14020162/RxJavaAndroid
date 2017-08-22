package demo.exercise.pclap.mvpmodel.ui.main.music;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.List;

import demo.exercise.pclap.mvpmodel.R;
import demo.exercise.pclap.mvpmodel.module.ItemSongResponse;
import demo.exercise.pclap.mvpmodel.module.ItemSongSearch;
import demo.exercise.pclap.mvpmodel.ui.base.fragment.BaseMVPFragment;

/**
 * Created by PC Lap on 8/22/2017.
 */
public class ListMusicFragment extends BaseMVPFragment<IListMusic.Presenter> implements IListMusic.View, ListMusicAdapter.IListMusicAdapter, TextWatcher {

    private RecyclerView rcMusic;
    private EditText edtSearch;
    private ListMusicAdapter adapter;
    private List<ItemSongSearch> itemSongSearches;

    @Override
    public int getLayout() {
        return R.layout.fragment_list_music;
    }

    @Override
    public void findViewByIds() {
        rcMusic = (RecyclerView) getView().findViewById(R.id.rc_music);
        edtSearch = (EditText) getView().findViewById(R.id.edt_search);

        adapter = new ListMusicAdapter(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        rcMusic.setLayoutManager(manager);
        rcMusic.setAdapter(adapter);
    }

    @Override
    public void initComponents() {
        mPresenter = new ListMusicPresenter(this);
//        mPresenter.getMusic("xa em");

    }

    @Override
    public void setEvents() {
        edtSearch.addTextChangedListener(this);
    }

    @Override
    public void finishGetMusic(List<ItemSongResponse> itemSongResponse) {
        Log.d("TAGG", "sdfsd");
    }

    @Override
    public void errorGetMusic(Throwable error) {
        Log.d("TAGG error", "sdfsd");
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String content = s.toString().trim();
        mPresenter.onDestroy();
        mPresenter.getItemSongSearch(content);
    }

    @Override
    public void finishGetListMusic(List<ItemSongSearch> response) {
        Log.d("sdf", "sdfsd");
        itemSongSearches = response;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorGetMusicSearch(Throwable error) {
        Log.d("sdf", "sdfsd");
    }

    @Override
    public int getCount() {
        if (itemSongSearches == null) {
            return 0;
        }
        return itemSongSearches.size();
    }

    @Override
    public ItemSongSearch getDate(int position) {
        return itemSongSearches.get(position);
    }

}
