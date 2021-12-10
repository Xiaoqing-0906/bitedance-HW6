package com.app.keepdog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class DeatilActivity extends AppCompatActivity {
    private List<Integer> list;//数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatil);

        list = new ArrayList<>();
        list.add(R.mipmap.chaiq);
        list.add(R.mipmap.dongtu);
        list.add(R.mipmap.gbq);
        list.add(R.mipmap.myq);
        list.add(R.mipmap.taidi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ViewPager vp = findViewById(R.id.vp);
        TextView tvNameDeatils = findViewById(R.id.tvNameDeatils);
        TextView tvContentDeatils = findViewById(R.id.tvContentDeatils);

        tvContentDeatils.setMovementMethod(ScrollingMovementMethod.getInstance());
        Intent intent = getIntent();
        DogItem item = (DogItem) intent.getSerializableExtra("item");
        tvNameDeatils.setText(item.name);
        tvContentDeatils.setText(item.content);
        setTitle(item.name + "详情");

        findViewById(R.id.tvVideo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeatilActivity.this,VideoActivity.class));
            }
        });

        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list == null?0:list.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                int pic = list.get(position);
                View view = View.inflate(DeatilActivity.this, R.layout.item_vp, null);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(DeatilActivity.this,BitPicActivity.class);
                        intent1.putExtra("pic",pic);
                        startActivity(intent1);
                    }
                });
                ImageView iv_details = view.findViewById(R.id.iv_details);
                //Glide.with(DeatilActivity.this).asGif().load(pic).into(iv_details);
                Glide.with(DeatilActivity.this).load(pic).listener(new RequestListener() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                        if (resource instanceof GifDrawable) {
                            //加载一次
                            //((GifDrawable)resource).setLoopCount(1);
                        }
                        return false;
                    }
                }).into(iv_details);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.conmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }else if(item.getItemId() == R.id.action_neve)
        {
            ProgressDialog progressDialog = new ProgressDialog(DeatilActivity.this);
            progressDialog.setMessage("领养中。。。");
            progressDialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(2000);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            Toast.makeText(DeatilActivity.this,"领养成功",Toast.LENGTH_LONG).show();
                            finish();
                        }
                    });
                }
            }).start();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void openWebviewActivity(Context context,DogItem dogItem){
        Intent intent = new Intent(context, DeatilActivity.class);
        intent.putExtra("item",dogItem);
        context.startActivity(intent);
    }

}