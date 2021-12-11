package com.app.keepdog

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.text.method.ScrollingMovementMethod
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import java.util.ArrayList

class DeatilActivity: AppCompatActivity() {
    private val list: MutableList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatil)
        list.add(R.mipmap.chaiq)
        list.add(R.mipmap.dongtu)
        list.add(R.mipmap.gbq)
        list.add(R.mipmap.myq)
        list.add(R.mipmap.taidi)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val vp = findViewById<ViewPager>(R.id.vp)
        val tvNameDeatils = findViewById<TextView>(R.id.tvNameDeatils)
        val tvContentDeatils = findViewById<TextView>(R.id.tvContentDeatils)
        tvContentDeatils.movementMethod = ScrollingMovementMethod.getInstance()
        val intent = intent
        val item = intent.getSerializableExtra("item") as DogItem?
        tvNameDeatils.text = item!!.name
        tvContentDeatils.text = item.content
        title = item.name + "详情"
        findViewById<TextView>(
            R.id.tvVideo
        ).setOnClickListener {
//            startActivity(
//                    Intent(this@DeatilActivity, VideoActivity::class.java)
//            )
        }
        vp.adapter = object : PagerAdapter() {
            override fun getCount(): Int {
                return if (list == null) 0 else list.size
            }

            override fun isViewFromObject(
                view: View,
                `object`: Any
            ): Boolean {
                return view === `object`
            }

            override fun instantiateItem(
                container: ViewGroup,
                position: Int
            ): Any {
                val pic = list.get(position)
                val view =
                    View.inflate(this@DeatilActivity, R.layout.item_vp, null)
                view.setOnClickListener {
                    val intent1 =
                        Intent()
                    intent1.setClass(this@DeatilActivity,BitPicActivity::class.java)
                    intent1.putExtra("pic", pic)
                    startActivity(intent1)
                }
                val iv_details =
                    view.findViewById<ImageView>(R.id.iv_details)
                //Glide.with(DeatilActivity.this).asGif().load(pic).into(iv_details);
                Glide.with(this@DeatilActivity)
                    .load(pic)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            if (resource is GifDrawable) {
                                //加载一次
                                //((GifDrawable)resource).setLoopCount(1);
                            }
                            return false
                        }
                    })
                    .into(iv_details)
                container.addView(view)
                return view
            }

            override fun destroyItem(
                container: ViewGroup,
                position: Int,
                `object`: Any
            ) {
                container.removeView(`object` as View)
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.conmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        } else if (item.itemId == R.id.action_neve) {
            val progressDialog = ProgressDialog(this@DeatilActivity)
            progressDialog.setMessage("领养中。。。")
            progressDialog.show()
            Thread(Runnable {
                SystemClock.sleep(2000)
                Handler(Looper.getMainLooper()).post {
                    progressDialog.dismiss()
                    Toast.makeText(this@DeatilActivity, "领养成功", Toast.LENGTH_LONG).show()
                    finish()
                }
            }).start()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object{
        fun openWebviewActivity(context: Context, dogItem: DogItem?){
            val intent = Intent(context,DeatilActivity::class.java)
            intent.putExtra("item", dogItem)
            context.startActivity(intent)
        }
    }
}