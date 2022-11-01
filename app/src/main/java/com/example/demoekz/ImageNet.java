package com.example.demoekz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class ImageNet extends AppCompatActivity {
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_net);
        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask mt = new MyTask((ImageView) findViewById(R.id.imageView9));
                mt.execute("https://kartinkin.net/uploads/posts/2021-03/1616973062_31-p-utkonos-oboi-32.jpg");
            }
        });
    }
    private class MyTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public MyTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
    /*class MyTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... params){
            String title;
            Document doc=null;
            try{
                doc = Jsoup.connect(params[0]).get();
            } catch (IOException e){
                e.printStackTrace();
            }
            if (doc!=null)
                title=doc.title();
            else
                title="Error";
            return title;
        }
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            textView.setText(result);
        }
    }*/
}