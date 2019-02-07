package com.vandit.bhagavadgita;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.vandit.bhagavadgita.Adapter.ShlokAdapter;
import com.vandit.bhagavadgita.Model.RecyclerBean;

import java.util.ArrayList;

public class Shlok_listActivity extends AppCompatActivity {
    public static int n=0;
    public static int i=0;
    RecyclerView recyclerView;
    ArrayList<RecyclerBean> arrayList;
    ImageButton imgbtnback;
    RecyclerBean bean;
    ShlokAdapter shlokAdapter;
    TextView txtshlok;
    String shlok_name;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shlok_list);
        MobileAds.initialize(this,"ca-app-pub-5340005248246861~4049341677");
        adView=findViewById(R.id.adView_list);
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
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
                params.weight= 0.9f;
                LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) adView.getLayoutParams();
                layoutParams.weight=0.1f;
                adView.setLayoutParams(layoutParams);
                recyclerView.setLayoutParams(params);

            }
        });
        recyclerView=findViewById(R.id.recycler_shlok);
        imgbtnback=findViewById(R.id.imgbtnback);
        txtshlok=findViewById(R.id.txtshlok);

        Intent intent=getIntent();
        arrayList=new ArrayList<>();
        n=intent.getIntExtra("pos",-1);
        if(n!=-1){
            if(n==0){
                shlok_name="प्रथम अध्याय\n"+
                        "ॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे\n"
                        +"श्रीकृष्णार्जुनसंवादेऽर्जुनविषादयोगो नाम प्रथमोऽध्यायः॥1॥";
                for(i=1;i<48;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==1){
                shlok_name="द्वितीय अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे सांख्ययोगो नाम द्वितीयोऽध्यायः ॥2॥";
                for(i=1;i<73;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==2){
                shlok_name="तृतीय अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे कर्मयोगो नाम तृतीयोऽध्यायः ॥3॥";
                for(i=1;i<44;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==3){
                shlok_name="चतुर्थ अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे ज्ञानकर्मसंन्यास योगो नाम चतुर्थोऽध्यायः ॥4॥";
                for(i=1;i<43;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==4){
                shlok_name="पंचम अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे कर्मसंन्यासयोगो नाम पंचमोऽध्यायः ॥5॥";
                for(i=1;i<30;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==5){
                shlok_name="षष्ठ अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे आत्मसंयमयोगो नाम षष्ठोऽध्यायः ॥6॥";
                for(i=1;i<48;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==6){
                shlok_name="सप्तम अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे ज्ञानविज्ञानयोगो नाम सप्तमोऽध्यायः ॥7॥";
                for(i=1;i<31;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==7){
                shlok_name="अष्टम अध्याय\nॐ तत्सदिति श्री मद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे \n" +
                        "श्री कृष्णार्जुनसंवादे अक्षर ब्रह्मयोगो नामाष्टमोऽध्यायः ॥8॥";
                for(i=1;i<29;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==8){
                shlok_name="नवम अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे\n" +
                        "श्री कृष्णार्जुनसंवादे राजविद्याराजगुह्ययोगो नाम नवमोऽध्यायः ॥9॥";
                for(i=1;i<35;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==9){
                shlok_name="दशम अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायांयोगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे विभूतियोगो नाम दशमोऽध्यायः ॥10॥";
                for(i=1;i<=42;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==10){
                shlok_name="एकादश अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायांयोगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे विश्वरूपदर्शनयोगो नामैकादशोऽध्यायः ॥11॥";
                for(i=1;i<56;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==11){
                shlok_name="द्वादश अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायांयोगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे भक्तियोगो नाम द्वादशोऽध्यायः ॥12॥";
                for(i=1;i<21;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==12){
                shlok_name="त्रयोदश अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायांयोगशास्त्रे \n" +
                        "श्रीकृष्णार्जुनसंवादे क्षेत्रक्षेत्रज्ञविभागयोगो नाम त्रयोदशोऽध्यायः॥13॥";
                for(i=1;i<35;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==13){
                shlok_name="चतुर्दश अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायांयोगशास्त्रे \n"+
                        "श्रीकृष्णार्जुनसंवादे प्राकृतिकगुणविभागयोगो नामचतुर्दशोऽध्यायः॥14॥";
                for(i=1;i<28;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==14){
                shlok_name="पंचदश अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे\n" +
                        "श्रीकृष्णार्जुन संवादे पुरुषोत्तमयोगो नाम पञ्चदशोऽध्यायः ॥15॥";
                for(i=1;i<21;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==15){
                shlok_name="षोडश अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे\n" +
                        "श्रीकृष्णार्जुनसंवादे दैवासुरसंपद्विभागयोगो नाम षोडशोऽध्यायः ॥16॥";
                for(i=1;i<25;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==16){
                shlok_name="सप्तदश अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे\n" +
                        "श्रीकृष्णार्जुनसंवादे श्रद्धात्रयविभागयोगो नाम सप्तदशोऽध्यायः ॥17॥";
                for(i=1;i<29;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }else if(n==17){
                shlok_name="अष्टादश अध्याय\nॐ तत्सदिति श्रीमद्भगवद्गीतासूपनिषत्सु ब्रह्मविद्यायां योगशास्त्रे\n" +
                        "श्रीकृष्णार्जुनसंवादे मोक्षसंन्यासयोगो नामाष्टादशोऽध्यायः ॥18॥";
                for(i=1;i<79;i++){
                    bean=new RecyclerBean();
                    bean.setShlok("श्लोक "+i);
                    arrayList.add(bean);
                }
            }
            shlokAdapter=new ShlokAdapter(arrayList);
            recyclerView.setAdapter(shlokAdapter);
            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            DividerItemDecoration decoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(decoration);
            txtshlok.setText(shlok_name);
        }
        imgbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Shlok_listActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}