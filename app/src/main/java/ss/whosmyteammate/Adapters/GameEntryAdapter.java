package ss.whosmyteammate.Adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        View rowView= inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = rowView.findViewById(R.id.list_item_textView);
        ImageView imageView = rowView.findViewById(R.id.list_item_imageView);

        GameEntry entry = mGameEntries.get(position);
        txtTitle.setText(entry.getName());
        imageView.setImageBitmap(entry.getGameIcon());

        Log.d("DEBUG", "helloow");
        return rowView;
    }

}
