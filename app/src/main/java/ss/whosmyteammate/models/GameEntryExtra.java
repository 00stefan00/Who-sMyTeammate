package ss.whosmyteammate.models;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ss.whosmyteammate.util.IconHelper;

public class GameEntryExtra {
    private String mName;
    private Set<String> mExtraSet = new HashSet<String>();
    private boolean mIsUnique;
    private ArrayList<Extra> mExtras;

    public GameEntryExtra(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public boolean getIsUnique() { return mIsUnique; }
}
