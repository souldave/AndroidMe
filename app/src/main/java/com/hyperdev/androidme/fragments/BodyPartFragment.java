package com.hyperdev.androidme.fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.util.ArrayList;
import java.util.List;


public class BodyPartFragment extends Fragment {

    private int position;
    private List<Integer> mPartsList;
    private static final String partsSignal = "partsSignal";
    private static final String partsList = "partsList";

    public BodyPartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mPartsList = savedInstanceState.getIntegerArrayList(partsList);
            position = savedInstanceState.getInt(partsSignal);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageFragment);
        if (mPartsList != null) {
            imageView.setImageResource(mPartsList.get(position));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position < mPartsList.size() - 1) {
                        position++;
                    } else {
                        position = 0;
                    }
                    imageView.setImageResource(mPartsList.get(position));
                }
            });
        }
        return rootView;
    }

    public void setPartList(List<Integer> partList) {
        this.mPartsList = partList;
    }

    public void setListPosition(int mListPosition) {
        this.position = mListPosition;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(partsList, (ArrayList<Integer>) mPartsList);
        outState.putInt(partsSignal, position);
    }
}

