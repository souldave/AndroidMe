package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hyperdev.androidme.R;

import com.hyperdev.androidme.data.AndroidImageAssets;
import com.hyperdev.androidme.fragments.BodyPartFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            BodyPartFragment FragHeadPart = new BodyPartFragment();
            FragHeadPart.setPartList(AndroidImageAssets.getHeads());
            int headPosition = getIntent().getIntExtra("headPosition", 0);
            FragHeadPart.setListPosition(headPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.head, FragHeadPart)
                    .commit();

            BodyPartFragment FragBodyPart = new BodyPartFragment();
            FragBodyPart.setPartList(AndroidImageAssets.getBodies());
            int bodyPosition = getIntent().getIntExtra("bodyPosition", 0);
            FragBodyPart.setListPosition(bodyPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.body, FragBodyPart)
                    .commit();

            BodyPartFragment FragLegPart = new BodyPartFragment();
            FragLegPart.setPartList(AndroidImageAssets.getLegs());
            int legPosition = getIntent().getIntExtra("legsPosition", 0);
            FragLegPart.setListPosition(legPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.legs, FragLegPart)
                    .commit();
        }
    }
}
