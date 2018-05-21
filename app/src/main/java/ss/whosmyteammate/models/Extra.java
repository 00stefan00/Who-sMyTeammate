package ss.whosmyteammate.models;

import java.util.ArrayList;

public class Extra {
    private String mName;
    private ArrayList<String> mExtraContent;

    public Extra(String name) {
        this.mName = name;
    }

    public void addContent(String content) {
        mExtraContent.add(content);
    }

    public void removeContent(String content) {
        for (int i=0; i<mExtraContent.size()-1; i++) {
            if (mExtraContent.get(i) == content) {
                removeContent(i);
            }
        }
    }

    private void removeContent(int i){
        mExtraContent.remove(i);
    }

    public int getExtraContentCount() {
        return mExtraContent.size();
    }

    public String getExtraContentAtIndex(int i) {
        return mExtraContent.get(i);
    }

    public void rename(String newName) {
        this.mName = newName;
    }
}
