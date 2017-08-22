package demo.exercise.pclap.mvpmodel.ui.main.music;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import demo.exercise.pclap.mvpmodel.R;
import demo.exercise.pclap.mvpmodel.module.ItemSongSearch;

/**
 * Created by PC Lap on 8/22/2017.
 */
public class ListMusicAdapter extends RecyclerView.Adapter<ListMusicAdapter.ViewHolderLisMusic> {

    private IListMusicAdapter mInterf;

    public ListMusicAdapter(IListMusicAdapter inter) {
        mInterf = inter;
    }

    @Override
    public ViewHolderLisMusic onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderLisMusic(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_music_search, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderLisMusic holder, int position) {
        ItemSongSearch songSearch = mInterf.getDate(position);
        holder.tvArtist.setText(songSearch.getArtist());
        holder.tvName.setText(songSearch.getTitle());
        if ( songSearch.getAvatar() == null || songSearch.getAvatar().isEmpty() ) {
            return ;
        }
        Picasso.with(holder.itemView.getContext())
                .load(songSearch.getAvatar())
                .placeholder(R.drawable.gb_loading)
                .error(R.drawable.gb_loading)
                .into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return mInterf.getCount();
    }

    static class ViewHolderLisMusic extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivAvatar;
        private TextView tvArtist;

        public ViewHolderLisMusic(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        }
    }

    public interface IListMusicAdapter {
        int getCount();

        ItemSongSearch getDate(int position);
    }
}
