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
            shareTwitter();
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

        Intent intent = null;
        try {
            // get the Twitter app if possible
            this.getPackageManager().getPackageInfo("com.twitter.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=USERID"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (Exception e) {
            // no Twitter app, revert to browser
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/USERID_OR_PROFILENAME"));
        }
        this.startActivity(intent);

        Intent tweetIntent = new Intent(Intent.ACTION_SEND);
        tweetIntent.putExtra(Intent.EXTRA_TEXT, "This is a Test.");
        tweetIntent.setType("text/plain");

        PackageManager packManager = getPackageManager();
        List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent,  PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for(ResolveInfo resolveInfo: resolvedInfoList){
            if(resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")){
                tweetIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name );
                resolved = true;
                break;
            }
        }
        if(resolved){
            startActivity(tweetIntent);
        }else{
            Toast.makeText(this, "Twitter app isn't found", Toast.LENGTH_LONG).show();
        }

}
}
