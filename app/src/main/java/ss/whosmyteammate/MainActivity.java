package ss.whosmyteammate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ss.whosmyteammate.Adapters.GameEntryAdapter;
import ss.whosmyteammate.models.GameEntry;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GameEntryAdapter mListAdapter;

    private static ArrayList<GameEntry> mGameEntries = new ArrayList<>();
    private static boolean initialized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        if (!initialized) {
            initialize();
        }

        listView = findViewById(R.id.game_entry_list_view);
        mListAdapter = new GameEntryAdapter(MainActivity.this, mGameEntries);

        listView.setAdapter(mListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, GameEntryActivity.class);
                Log.d("Debug", ">> " + position);
                myIntent.putExtra("position", position);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    private void initialize() {
        addToGameEntryArray(new GameEntry("Civilization V", "Civ"));
        addToGameEntryArray(new GameEntry("Risk", "Risk"));
    }

    public static void addToGameEntryArray(GameEntry gameEntry) {
        mGameEntries.add(gameEntry);
    }

    public static GameEntry getFromGameEntryArray(int position) {
        return mGameEntries.get(position);
    }

    public static void removeFromGameEntryArray(int position) {
        mGameEntries.remove(position);
    }

    private void addControls() {Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, GameEntryActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
