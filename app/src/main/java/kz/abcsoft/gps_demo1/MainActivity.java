package kz.abcsoft.gps_demo1;

import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    TextView intoTextView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intoTextView = (TextView)findViewById(R.id.intoTextView) ;

        checkEnableGPS();

        PackageManager pm = getPackageManager() ;

        Toast.makeText(this, pm.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS) ? "GPS бар" : "GPS жоқ",
                Toast.LENGTH_LONG).show();
    }

    private void checkEnableGPS(){
        String provider = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED) ;

        if(!provider.equals("")){
            intoTextView.setText("GPS қосылып тұр: " + provider);
        }
        else{
            intoTextView.setText("GPS өшіп тұр");
        }
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
