package com.vandit.bhagavadgita;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.vandit.bhagavadgita.Adapter.RecyclerAdapter;
import com.vandit.bhagavadgita.Model.RecyclerBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<RecyclerBean> arrayList;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    String name;
    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar a=getSupportActionBar();
        a.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        MobileAds.initialize(this,"ca-app-pub-5340005248246861~4049341677");
        adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener(){
         @Override
         public void onAdClosed() {
             super.onAdClosed();
             Toast.makeText(MainActivity.this, "Ad Closed", Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onAdFailedToLoad(int i) {
             super.onAdFailedToLoad(i);
             Toast.makeText(MainActivity.this, "Ad Failed"+i, Toast.LENGTH_SHORT).show();
         }

        @Override
         public void onAdOpened() {
             super.onAdOpened();
            Toast.makeText(MainActivity.this, "Ad Open", Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onAdLoaded() {
             super.onAdLoaded();
             LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
             params.weight= 0.9f;
             LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) adView.getLayoutParams();
             layoutParams.weight=0.1f;
             adView.setLayoutParams(layoutParams);
             recyclerView.setLayoutParams(params);

             Toast.makeText(MainActivity.this, "Ad Loaded", Toast.LENGTH_SHORT).show();
         }
     });
        arrayList=new ArrayList<>();
        RecyclerBean bean=new RecyclerBean();
        for(int i=1;i<19;i++) {
            if(i==1){
                name="अर्जुनविषादयोग";
            }else if(i==2){
                name="सांख्ययोग";
            }else if(i==3){
                name="कर्मयोग";
            }else if(i==4){
                name="ज्ञान कर्म सन्यास योग";
            }else if(i==5){
                name="कर्म संन्यास योग";
            }else if(i==6){
                name="आत्मसंयमयोग";
            }else if(i==7){
                name="ज्ञान विज्ञान योग";
            }else if(i==8){
                name="अक्षर ब्रह्म योग";
            }else if(i==9){
                name="राजविद्या राजगुह्य योग";
            }else if(i==10){
                name="विभूति योग";
            }else if(i==11){
                name="विश्व रूपदर्शन योग";
            }else if(i==12){
                name="भक्ति योग";
            }else if(i==13){
                name="क्षेत्र-क्षेत्रज्ञविभाग योग";
            }else if(i==14){
                name="गुणत्रय विभाग योग";
            }else if(i==15){
                name="पुरुषोत्तमयोग";
            }else if(i==16){
                name="दैवासुरसम्पद्विभागयोग";
            }else if(i==17){
                name="श्रद्धात्रयविभागयोग";
            }else if(i==18){
                name="मोक्षसंन्यासयोग";
            }
            bean = new RecyclerBean();
            bean.setAdhyay("अध्याय "+i+" : "+name);
            arrayList.add(bean);
        }
        adapter=new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration Decoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(Decoration);
    }
}
