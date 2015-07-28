package hassassin.com.theactivityclass;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mac on 27/7/15.
 */
public class SecondActivity extends Activity {

    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    private final static String TAG = "Lab-ActivityTwo";

    int mCreate, mRestart, mStart, mResume;
    TextView tvCreate, tvRestart, tvStart, tvResume;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        tvCreate = (TextView) findViewById(R.id.create2);
        tvResume = (TextView) findViewById(R.id.resume2);
        tvStart = (TextView) findViewById(R.id.start2);
        tvRestart = (TextView) findViewById(R.id.restart2);
        btnClose = (Button) findViewById(R.id.btn_close2);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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


}
