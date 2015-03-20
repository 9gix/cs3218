package org.gix.cs3218eugene;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Toast;


public class LiveFFTActivity extends Activity {

    public static int bufferSize;
    public static short[] buffer;
    public static CSurfaceViewLiveFFT surfaceView;
    private LiveFFTSoundSampler soundSampler;

    public void goToMainActivity(View view){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_fft);


        try {
            soundSampler = new LiveFFTSoundSampler(this);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Cannot instantiate SoundSampler", Toast.LENGTH_LONG).show();
        }

        try {
            soundSampler.init();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Cannot initialize SoundSampler.", Toast.LENGTH_LONG).show();
        }

        surfaceView = (CSurfaceViewLiveFFT)findViewById(R.id.surfaceViewLifeFFT);
        surfaceView.drawThread.setBuffer(buffer);
    }

    @Override
    protected void onPause() {
        surfaceView.drawFlag = false;
        super.onPause();
    }

    public void captureSoundLiveFFT(View v) {
        if (surfaceView.drawThread.liveFFTCapture) {
            surfaceView.drawThread.liveFFTCapture = false;
        } else {
            surfaceView.drawThread.liveFFTCapture = true;
        }
    }
}
