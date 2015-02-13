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
}
