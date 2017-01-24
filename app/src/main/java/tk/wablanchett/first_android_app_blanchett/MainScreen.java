package tk.wablanchett.first_android_app_blanchett;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainScreen extends AppCompatActivity {

    private static final String DEBUG_TAG = "AppUnoLogging";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(DEBUG_TAG,"Just entered the onCreate() method of MainScreen Class");
      //  forceError();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void forceError() {

        if (true) {
            throw new Error("ERROR HAS BEEN FORCED");
        }

    }
}
