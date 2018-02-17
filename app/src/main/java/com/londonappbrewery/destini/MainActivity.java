package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView tvStory;
    private Button btnAns1;
    private Button btnAns2;

    private int userStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvStory = findViewById(R.id.storyTextView);
        btnAns1 = findViewById(R.id.buttonAns1);
        btnAns2 = findViewById(R.id.buttonAns2);

        btnAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userStory == 1) {
                    userStory = 3;
                    updateUserStory();
                    return;
                }

                if (userStory == 2) {
                    userStory = 3;
                    updateUserStory();
                    return;
                }

                if (userStory == 3) {
                    userStory = 6;
                    updateUserStory();
                    return;
                }

                if (userStory == 9) {
                    userStory = 1;
                    updateUserStory();
                    return;
                }

                if (userStory == 4 || userStory == 5 || userStory == 6) {
                    userStory = 9;
                    updateUserStory();
                }
            }
        });

        btnAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userStory == 1) {
                    userStory = 2;
                    updateUserStory();
                    return;
                }

                if (userStory == 2) {
                    userStory = 4;
                    updateUserStory();
                    return;
                }

                if (userStory == 3) {
                    userStory = 5;
                    updateUserStory();
                    return;
                }

                if (userStory == 9) {
                    userStory = 1;
                    updateUserStory();
                    return;
                }

                if (userStory == 4 || userStory == 5 || userStory == 6) {
                    userStory = 9;
                    updateUserStory();
                }
            }
        });

        if (savedInstanceState == null) {
            userStory = 1;
        } else {
            userStory = savedInstanceState.getInt("userStory");
        }

        updateUserStory();
    }

    private void updateUserStory() {
        btnAns2.setVisibility(View.VISIBLE);

        switch (userStory) {
            case 1:
                tvStory.setText(R.string.T1_Story);
                btnAns1.setText(R.string.T1_Ans1);
                btnAns2.setText(R.string.T1_Ans2);
                break;

            case 2:
                tvStory.setText(R.string.T2_Story);
                btnAns1.setText(R.string.T2_Ans1);
                btnAns2.setText(R.string.T2_Ans2);
                break;

            case 3:
                tvStory.setText(R.string.T3_Story);
                btnAns1.setText(R.string.T3_Ans1);
                btnAns2.setText(R.string.T3_Ans2);
                break;

            case 4:
                tvStory.setText(R.string.T4_End);
                break;

            case 5:
                tvStory.setText(R.string.T5_End);
                break;

            case 6:
                tvStory.setText(R.string.T6_End);
                break;
            case 9:
                btnAns1.setText(R.string.playAgain);
                btnAns2.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("userStory", userStory);
        super.onSaveInstanceState(outState);
    }
}
