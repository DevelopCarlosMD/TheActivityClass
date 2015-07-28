package hassassin.com.theactivityclass;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    private static final String TAG = "Lab-ActivityOne";

    int mCreate, mRestart, mStart, mResume;
    TextView tvCreate, tvRestart, tvStart, tvResume;
    Button launchActivityTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCreate = (TextView) findViewById(R.id.create);
        tvResume = (TextView) findViewById(R.id.resume);
        tvStart = (TextView) findViewById(R.id.start);
        tvRestart = (TextView) findViewById(R.id.restart);

        launchActivityTwo = (Button) findViewById(R.id.btn_activity_two);

        launchActivityTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        if(savedInstanceState != null){

            mCreate = savedInstanceState.getInt(CREATE_KEY);
            mResume = savedInstanceState.getInt(RESUME_KEY);
            mStart = savedInstanceState.getInt(START_KEY);
            mRestart = savedInstanceState.getInt(RESTART_KEY);
        }

        //Emit LogCat message
        Log.i(TAG, "Entered the onCreate method");

        mCreate++;
        displayCounts();

    }

    @Override
    protected void onStart() {
        super.onStart();

        //Emit LogCat message
        mStart ++;
        displayCounts();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mResume++;
        displayCounts();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "Entered onPause method");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "Enterd onStop method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mRestart++;
        displayCounts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Entered onDestroy() method");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstance) {

        savedInstance.putInt(CREATE_KEY, mCreate);
        savedInstance.putInt(RESTART_KEY, mRestart);
        savedInstance.putInt(RESUME_KEY, mResume);
        savedInstance.putInt(START_KEY, mStart);

        super.onSaveInstanceState(savedInstance);
    }

    public void displayCounts(){
        tvCreate.setText("onCreate() calls " + mCreate);
        tvStart.setText("onStart() calls " + mStart);
        tvRestart.setText("onRestart() calls " + mRestart);
        tvResume.setText("onResume() calls " + mResume);
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
