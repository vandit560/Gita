package com.vandit.bhagavadgita;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShlokFragment extends Fragment {
    View view;
    TextView txtdesc,txtname;
    String s_name,s_desc;
    private AdView adView;
    public  static ShlokFragment newInstance(String name,String desc){
         ShlokFragment shlokFragment=new ShlokFragment();
            shlokFragment.s_name=name ;
            shlokFragment.s_desc=desc;
            return shlokFragment;
    }
    public ShlokFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_shlok, container, false);
       txtdesc=view.findViewById(R.id.txtshlok_desc);
       txtname=view.findViewById(R.id.txtshlok_name);
        // / Inflate the layout for this fragment
        MobileAds.initialize(getContext(),"ca-app-pub-5340005248246861~4049341677");
        adView=view.findViewById(R.id.adView_fragment);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtname.setText(s_name);
        if(s_desc!=null){
        txtdesc.setText(s_desc);}
        adView.loadAd(new AdRequest.Builder().build());
        adView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }
        });
    }

}
