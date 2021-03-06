package ss.whosmyteammate.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import ss.whosmyteammate.R;
import ss.whosmyteammate.models.GameEntry;

public class GameEntryAdapter extends BaseAdapter{

    private final Activity mActivity;
    private ArrayList<GameEntry> mGameEntries;

    public GameEntryAdapter(Activity activity, ArrayList<GameEntry> gameEntries) {
        this.mActivity = activity;
        this.mGameEntries = gameEntries;
    }

    @Override
    public int getCount() {
        return mGameEntries.size();
    }

    @Override
    public Object getItem(int i) {
        return mGameEntries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item_game_entry, null, true);
        TextView txtTitle = rowView.findViewById(R.id.list_item_game_entry_textView_title);
        ImageView imageView = rowView.findViewById(R.id.list_item_game_entry_imageView);

        GameEntry entry = mGameEntries.get(position);
        txtTitle.setText(entry.getName());
        imageView.setImageBitmap(entry.getGameIcon());

        return rowView;
    }

    public void resetSpinner() {
        int x=1;
    }

}
