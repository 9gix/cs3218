package org.gix.cs3218eugene;

import android.media.AudioRecord;
import android.util.Log;


public class SoundSampler {

    private static final int  FS = 16000;     // sampling frequency
    public  AudioRecord       audioRecord;
    private int               audioEncoding = 2;
    private int               nChannels = 16;
    private Thread            recordingThread;

    public SoundSampler(SoundActivity mAct) throws Exception
    {
        try {
            if (audioRecord != null) {
                audioRecord.stop();
                audioRecord.release();
            }
            audioRecord = new AudioRecord(1, FS, nChannels, audioEncoding, AudioRecord.getMinBufferSize(FS, nChannels, audioEncoding));
        }
        catch (Exception e) {
            Log.d("SoundSampler", e.getMessage());
            throw new Exception();
        }

        return;

    }


    public void init() throws Exception
    {
        try {
            if (audioRecord != null) {
                audioRecord.stop();
                audioRecord.release();
            }
            audioRecord = new AudioRecord(1, FS, nChannels, audioEncoding, AudioRecord.getMinBufferSize(FS, nChannels, audioEncoding));
        }
        catch (Exception e) {
            Log.d("Error in Init() ", e.getMessage());
            throw new Exception();
        }

        SoundActivity.bufferSize = AudioRecord.getMinBufferSize(FS, nChannels, audioEncoding);
        SoundActivity.buffer = new short[SoundActivity.bufferSize];

        audioRecord.startRecording();

        recordingThread = new Thread()
        {
            public void run()
            {
                while (true)
                {

                    audioRecord.read(SoundActivity.buffer, 0, SoundActivity.bufferSize);
                    SoundActivity.surfaceView.drawThread.setBuffer(SoundActivity.buffer);

                }
            }
        };
        recordingThread.start();

        return;

    }


}


