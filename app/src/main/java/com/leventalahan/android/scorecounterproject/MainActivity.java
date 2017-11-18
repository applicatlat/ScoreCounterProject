package com.leventalahan.android.scorecounterproject;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import org.w3c.dom.Text;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener{
    Button mButton;
    int scoreTeamA;
    int scoreTeamB;
    RewardedVideoAd mAd;
    TextView mLog;
    int coins = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLog = findViewById(R.id.textView2);
        mButton = findViewById(R.id.ad_button);
        mButton.setEnabled(true);


        MobileAds.initialize(this, "ca-app-pub-1130205613600223~7761759629");
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        mAd.loadAd("ca-app-pub-1130205613600223/7371054998", new AdRequest.Builder().build());

        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mButton.setEnabled(false);
                if(mAd.isLoaded()) {
                    mAd.show();
                }

            }
        });

        final MediaPlayer resetSoundMediaPlayer = MediaPlayer.create(this, R.raw.buzzer);
        final ImageView view1 = findViewById(R.id.imageView1);
        final ImageView view2 = findViewById(R.id.imageView2);
        final Button resetAsound  = (Button) this.findViewById(R.id.resetAsound);
        resetAsound.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                resetSoundMediaPlayer.start();
                displayForTeamA( scoreTeamA=0);
                view1.setVisibility(View.INVISIBLE);

            }

        });
        final MediaPlayer resetSoundBMediaPlayer = MediaPlayer.create(this, R.raw.buzzer);

        final Button resetBsound  = (Button) this.findViewById(R.id.resetBsound);
        resetBsound.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                resetSoundBMediaPlayer.start();
                displayForTeamB( scoreTeamB=0);
                view2.setVisibility(View.INVISIBLE);

            }
        });


        final MediaPlayer add3AMediaPlayer = MediaPlayer.create(this, R.raw.plus);

        final Button add3A  = (Button) this.findViewById(R.id.add3A);

        add3A.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                add3AMediaPlayer.start();
                displayForTeamA( scoreTeamA = scoreTeamA +3);
                view1.setVisibility(View.VISIBLE);

            }

        });
        final MediaPlayer add2AMediaPlayer = MediaPlayer.create(this, R.raw.plus);

        final Button add2A  = (Button) this.findViewById(R.id.add2A);
        add2A.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                add2AMediaPlayer.start();
                displayForTeamA( scoreTeamA = scoreTeamA +2);
                view1.setVisibility(View.VISIBLE);

            }

        });
        final MediaPlayer add1AMediaPlayer = MediaPlayer.create(this, R.raw.plus);

        final Button add1A  = (Button) this.findViewById(R.id.add1A);
        add1A.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                add1AMediaPlayer.start();
                displayForTeamA( scoreTeamA = scoreTeamA +1);
                view1.setVisibility(View.VISIBLE);

            }

        });

        final MediaPlayer add3BMediaPlayer = MediaPlayer.create(this, R.raw.plus);

        final Button add3B  = (Button) this.findViewById(R.id.add3B);
        add3B.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                add3BMediaPlayer.start();
                displayForTeamB (scoreTeamB = scoreTeamB +3);
                view2.setVisibility(View.VISIBLE);

            }

        });
        final MediaPlayer add2BMediaPlayer = MediaPlayer.create(this, R.raw.plus);

        final Button add2B  = (Button) this.findViewById(R.id.add2B);
        add2B.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                add2BMediaPlayer.start();
                displayForTeamB (scoreTeamB = scoreTeamB +2);
                view2.setVisibility(View.VISIBLE);

            }

        });
        final MediaPlayer add1BMediaPlayer = MediaPlayer.create(this, R.raw.plus);

        final Button add1B  = (Button) this.findViewById(R.id.add1B);
        add1B.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                add1BMediaPlayer.start();
                displayForTeamB (scoreTeamB = scoreTeamB +1);
                view2.setVisibility(View.VISIBLE);

            }

        });
        final MediaPlayer subtract3BMediaPlayer = MediaPlayer.create(this, R.raw.minus);

        final Button subtract3B  = (Button) this.findViewById(R.id.subtract3B);
        subtract3B.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                subtract3BMediaPlayer.start();
                displayForTeamB (scoreTeamB = scoreTeamB -3);
                view2.setVisibility(View.INVISIBLE);


                if ( scoreTeamB < 0 )
                {
                    displayForTeamB(scoreTeamB = 0);
                }

            }

        });
        final MediaPlayer subtract2BMediaPlayer = MediaPlayer.create(this, R.raw.minus);

        final Button subtract2B  = (Button) this.findViewById(R.id.subtract2B);
        subtract2B.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                subtract2BMediaPlayer.start();
                displayForTeamB (scoreTeamB = scoreTeamB -2);
                view2.setVisibility(View.INVISIBLE);


                if ( scoreTeamB < 0 )
                {
                    displayForTeamB(scoreTeamB = 0);
                }

            }

        });
        final MediaPlayer subtract1BMediaPlayer = MediaPlayer.create(this, R.raw.minus);

        final Button subtract1B  = (Button) this.findViewById(R.id.subtract1B);
        subtract1B.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                subtract1BMediaPlayer.start();
                displayForTeamB (scoreTeamB = scoreTeamB -1);
                view2.setVisibility(View.INVISIBLE);



                if ( scoreTeamB < 0 )
                {
                    displayForTeamB(scoreTeamB = 0);
                }

            }

        });
        final MediaPlayer subtract3AMediaPlayer = MediaPlayer.create(this, R.raw.minus);

        final Button subtract3A  = (Button) this.findViewById(R.id.subtract3A);
        subtract3A.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                subtract3AMediaPlayer.start();
                displayForTeamA (scoreTeamA = scoreTeamA -3);
                view1.setVisibility(View.INVISIBLE);

                if ( scoreTeamA < 0 )
                {
                    displayForTeamA(scoreTeamA = 0);
                }


            }

        });
        final MediaPlayer subtract2AMediaPlayer = MediaPlayer.create(this, R.raw.minus);

        final Button subtract2A  = (Button) this.findViewById(R.id.subtract2A);
        subtract2A.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                subtract2AMediaPlayer.start();
                displayForTeamA (scoreTeamA = scoreTeamA -2);
                view1.setVisibility(View.INVISIBLE);

                if ( scoreTeamA < 0 )
                {
                    displayForTeamA(scoreTeamA = 0);
                }


            }

        });
        final MediaPlayer subtract1AMediaPlayer = MediaPlayer.create(this, R.raw.minus);

        final Button subtract1A  = (Button) this.findViewById(R.id.subtract1A);
        subtract1A.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                subtract1AMediaPlayer.start();
                displayForTeamA (scoreTeamA = scoreTeamA -1);
                view1.setVisibility(View.INVISIBLE);

                if ( scoreTeamA < 0 )
                {
                    displayForTeamA(scoreTeamA = 0);
                }


            }

        });


    }
    private void loadRewardedVideoAd() {
        mAd.loadAd("ca-app-pub-1130205613600223/7371054998", new AdRequest.Builder().build());
    }

    @Override
    public void onRewardedVideoAdLoaded() {
    mButton.setEnabled(true);
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();

    }


    @Override
    public void onRewarded(RewardItem rewardItem) {
        displayForRewards(coins = coins + rewardItem.getAmount());


    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        loadRewardedVideoAd();

    }


    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));


    }
    public void displayForRewards(int coins) {
        TextView coinsView = (TextView) findViewById(R.id.textView2);
        coinsView.setText(String.valueOf(coins));


    }


    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));


    }

}
