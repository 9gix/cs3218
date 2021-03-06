package org.gix.cs3218eugene;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void launchCalculator(View view){
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }

    public void launchGraph(View view){
        Intent intent = new Intent(this, GraphActivity.class);
        startActivity(intent);
    }

    public void launchSound(View view){
        Intent intent = new Intent(this, SoundActivity.class);
        startActivity(intent);
    }

    public void launchCalculus(View v) {
        Intent intent  = new Intent(this, CalculusActivity.class);
        startActivity(intent);
    }

    public void launchFFT(View v) {
        Intent intent  = new Intent(this, FFTActivity.class);
        startActivity(intent);
    }

    public void launchLiveFFT(View v) {
        Intent intent  = new Intent(this, LiveFFTActivity.class);
        startActivity(intent);
    }

    public void launchSpectrogram(View v) {
        Intent intent  = new Intent(this, SpectrogramActivity.class);
        startActivity(intent);
    }
}
