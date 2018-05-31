package com.ablingbling.app.followbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ablingbling.library.followbutton.FollowButton;

public class MainActivity extends AppCompatActivity {

    private FollowButton btn_follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_follow = findViewById(R.id.btn_follow);
        btn_follow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (btn_follow.isLoading()) {
                    return;
                }

                final boolean checked = btn_follow.isChecked();

                btn_follow.startLoading();
                btn_follow.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        btn_follow.finishLoading();
                        btn_follow.check(!checked);
                    }

                }, 3000);
            }

        });
    }

}
