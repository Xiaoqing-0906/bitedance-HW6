package com.app.keepdog;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
	private VideoView videoPlayer;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vidio);

		ProgressBar pb = findViewById(R.id.pb);
		videoPlayer = findViewById(R.id.videoplayer);
		videoPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
			@Override
			public boolean onInfo(MediaPlayer mp, int what, int i1) {
				if(what == MediaPlayer.MEDIA_INFO_BUFFERING_START){
					pb.setVisibility(View.VISIBLE);
				}else if(what == MediaPlayer.MEDIA_INFO_BUFFERING_END){
					//此接口每次回调完START就回调END,若不加上判断就会出现缓冲图标一闪一闪的卡顿现象
					if(mp.isPlaying()){
						pb.setVisibility(View.GONE);
					}
				}
				return true;
			}
		});
		videoPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mediaPlayer) {
				pb.setVisibility(View.GONE);//缓冲完成就隐藏
			}
		});
		initNetVideo();
	}

	private void initNetVideo() {
		//设置有进度条可以拖动快进
		MediaController localMediaController = new MediaController(this);
		videoPlayer.setMediaController(localMediaController);

		String uri = "android.resource://" + getPackageName() + "/" + R.raw.aaa;
		videoPlayer.setVideoURI(Uri.parse(uri));
		videoPlayer.start();
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
