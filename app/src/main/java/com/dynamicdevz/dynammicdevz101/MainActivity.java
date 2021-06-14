package com.dynamicdevz.dynammicdevz101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dynamicdevz.dynammicdevz101.model.Human;

public class MainActivity extends AppCompatActivity {

    private Button followButton;
    private TextView userNameTextView;
    private ImageView imageView;

    String TAG = "TAG_X";
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Activity is being created but is not visible to the user
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Activity is being created but is not visible to the user");

        userNameTextView = findViewById(R.id.username_textview);
        followButton = findViewById(R.id.follow_button);
        imageView = findViewById(R.id.profile_imageview);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;

                if(count % 2 == 0){
                   // imageView.setImageResource(R.drawable.duck_hd);
                    Glide.with(MainActivity.this)
                            .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
                            .load(R.drawable.duck_hd)
                            .into(imageView);
                } else {
//                    imageView.setImageResource(R.drawable.ic_launcher_background);
                    Glide.with(MainActivity.this)
                            .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
                            .load(R.drawable.ic_launcher_background)
                            .into(imageView);
                }

                setCountText();
            }
        });
//
//        if (savedInstanceState!= null){
//
//        }

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("COUNT_KEY");
        Human human = (Human) savedInstanceState.getSerializable("my_human");
        Log.d(TAG, "onRestoreInstanceState: " + human);
        setCountText();
    }

    private void setCountText() {
        userNameTextView.setText("Count : " + count);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putInt("COUNT_KEY", count);
        outState.putSerializable("my_human", new Human("John Doe", "NotKnown", 5 * count));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Activity is visible but not interactive");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activity is not only visible but also interactive at this point.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Activity is slightly visible going into the background");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Activity is in the background but still in memory");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity is being removed from memory");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: coming from onStop to onStart");
    }
}









