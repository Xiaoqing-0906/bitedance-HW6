package com.app.keepdog

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class VideoActivity: AppCompatActivity()  {
    private var videoPlayer: VideoView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vidio)
        val pb = findViewById<ProgressBar>(R.id.pb)
        videoPlayer = findViewById(R.id.videoplayer)
        videoPlayer?.setOnInfoListener(MediaPlayer.OnInfoListener { mp, what, i1 ->
            if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
                pb.visibility = View.VISIBLE
            } else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
                //此接口每次回调完START就回调END,若不加上判断就会出现缓冲图标一闪一闪的卡顿现象
                if (mp.isPlaying) {
                    pb.visibility = View.GONE
                }
            }
            true
        })
        videoPlayer?.setOnPreparedListener(MediaPlayer.OnPreparedListener {
            pb.visibility = View.GONE //缓冲完成就隐藏
        })
        initNetVideo()
    }

    private fun initNetVideo() {
        //设置有进度条可以拖动快进
        val localMediaController =
            MediaController(this)
        videoPlayer!!.setMediaController(localMediaController)
        val uri = "android.resource://" + packageName + "/" + R.raw.aaa
        videoPlayer!!.setVideoURI(Uri.parse(uri))
        videoPlayer!!.start()
    }
}