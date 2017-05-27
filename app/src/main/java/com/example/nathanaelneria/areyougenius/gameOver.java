package com.example.nathanaelneria.areyougenius;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class gameOver extends AppCompatActivity {
    private TextView scoreText;
    private Database db;
    private int Currscore;
    private int finalScore;
    Button Share;
    Button Menu;
    Button quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        scoreText = (TextView) findViewById(R.id.score);
        db = new Database(this);
        Currscore = db.getScoreCount();
        Cursor current = db.getPerson(Currscore);

        if(!(current==null)){
            current.moveToFirst();
            finalScore = current.getInt(current.getColumnIndex("score"));
        }
        scoreText.setText(Integer.toString(finalScore));
        db.close();
    }

    public void onClick(View view){
        Share = (Button) findViewById(R.id.share);
        Menu = (Button) findViewById(R.id.Menu);
        quit = (Button) findViewById(R.id.quit);

        if(view == Share){
        }
        else if(view == Menu){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else if(view == quit){
            finishAffinity();
            System.exit(0);
        }
    }
    public void shareTwitter(){
        //Method to share on twitter


        Intent tweet = new Intent(Intent.ACTION_SEND);
        tweet.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        tweet.setDataAndType(uri, this.getContentResolver().getType(uri));
        String twitterPost = ("I just got a score of "+finalScore+" in What's the number. Download at https://play.google.com/store/apps/details?id=com.myfirstgame.rico.gameedu");
        tweet.putExtra(Intent.EXTRA_TEXT,twitterPost);
        tweet.putExtra(Intent.EXTRA_STREAM,uri);
        tweet.setType("image/*");

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(tweet,PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for (ResolveInfo resolveInfo : resolveInfoList){
            if(resolveInfo.activityInfo.packageName.contains("twitter")){
                tweet.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                resolved= true;
                break;
            }
        }
        if(resolved){
            startActivity(tweet);
        } else{
            Toast.makeText(this,"There is no twitter in this phone",Toast.LENGTH_SHORT).show();
        }
    }

}
