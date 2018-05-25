package ss.whosmyteammate.models;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.ArrayList;

import ss.whosmyteammate.util.IconHelper;

public class GameEntry {
    private String mName;
    private String mTag;
    private Bitmap mGameIcon;
    private ArrayList<Extra> mExtras;

    public GameEntry(String name, String tag) {
        mName = name;
        mTag = tag;
        mGameIcon = IconHelper.getCallerIconBitmap(mTag, Color.BLUE);
    }

    public String getName() {
        return mName;
    }

    public Bitmap getGameIcon() {
        return mGameIcon;
    }

    public String getTag() { return mTag; }

}
