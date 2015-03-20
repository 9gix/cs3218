package org.gix.cs3218eugene;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class SpectrogramActivity extends Activity {


    public static int bufferSize;
    public static short[] buffer;
    public static CSurfaceViewSpectrogram surfaceView;
    private SpectrogramSoundSampler soundSampler;

    public void goToMainActivity(View view){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spectrogram);


        try {
            soundSampler = new SpectrogramSoundSampler(this);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Cannot instantiate SoundSampler", Toast.LENGTH_LONG).show();
        }

        try {
            soundSampler.init();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Cannot initialize SoundSampler.", Toast.LENGTH_LONG).show();
        }

        surfaceView = (CSurfaceViewSpectrogram)findViewById(R.id.surfaceViewSpectrogram);
        surfaceView.drawThread.setBuffer(buffer);
    }
    @Override
    protected void onPause() {
        surfaceView.drawFlag = false;
        super.onPause();
    }
}
