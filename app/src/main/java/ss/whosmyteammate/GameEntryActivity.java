package ss.whosmyteammate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ss.whosmyteammate.models.GameEntry;

public class GameEntryActivity extends AppCompatActivity {

    private int mEditPosition; // -1 default for no edit-mode

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_entry);

        final Button button = findViewById(R.id.add_game_entry_button);
        final EditText mNameField = findViewById(R.id.activity_game_entry_name);
        final EditText mTagField = findViewById(R.id.activity_game_entry_tag);

        mEditPosition = getIntent().getIntExtra("position", -1);
        Log.d("Debug", ">>> " + mEditPosition);

        if (mEditPosition != -1) {
            mNameField.setText(MainActivity.getFromGameEntryArray(mEditPosition).getName());
            mTagField.setText(MainActivity.getFromGameEntryArray(mEditPosition).getTag());
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GameEntry gameEntry = new GameEntry(mNameField.getText().toString(), mTagField.getText().toString());
                MainActivity.addToGameEntryArray(gameEntry);
                if (mEditPosition != -1) {
                    MainActivity.removeFromGameEntryArray(mEditPosition);
                }
                finish();
            }
        });
    }


}
