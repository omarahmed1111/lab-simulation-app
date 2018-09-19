package com.example.omar2.test4;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.rtoshiro.view.video.FullscreenVideoLayout;

import java.io.IOException;


public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r4---sn-4g5edne7.googlevideo.com/Cj0LENy73wIaNAkeVJ13CCGw9RMYDSANFC3eFc5ZMOCoAUIASARgxMjf34LGwYpZigELR0g5cTlYQ2Jac0EM/589A3717D623CDD4F94D877ABC2774D07743EFA4.B6BFA503424978DE96EBA70D98D3A4C6403E1EB4/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}
