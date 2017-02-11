package zengshihang.ilovezappos;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zengshihang.ilovezappos.API.ZapposAPI;
import zengshihang.ilovezappos.model.ZapposModel;
import zengshihang.ilovezappos.model.Item;

import static android.app.PendingIntent.getActivity;


public class SearchResult extends AppCompatActivity {
    private String search;
    private ArrayList<Item> items;
    private RecycleAdapter adapter;
    private Context context;
    private final String KEY="b743e26728e16b81da139182bb2094357c31d331";
    FloatingActionButton fab,fab1,fab2;
    private boolean controller =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = SearchResult.this;

        setContentView(R.layout.activity_search_result);
        // the search term

        search =this.getIntent().getExtras().getString("target");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.zappos.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ZapposAPI api = retrofit.create(ZapposAPI.class);


        Call<ZapposModel> call =api.getDetail(search,KEY);
        call.enqueue(new Callback<zengshihang.ilovezappos.model.ZapposModel>() {
            @Override
            public void onResponse(Call<ZapposModel> call, Response<ZapposModel> response) {
                try {
                    ZapposModel zmodel = response.body();
                    items = zmodel.getItems();
                    RecyclerView recList= (RecyclerView) findViewById(R.id.recycle);
                    fab=(FloatingActionButton) findViewById(R.id.fab);
                    fab1=(FloatingActionButton) findViewById(R.id.fab_1);
                    fab2=(FloatingActionButton) findViewById(R.id.fab_2);

                    recList.setLayoutManager(new LinearLayoutManager(SearchResult.this.getApplicationContext()));

                    adapter= new RecycleAdapter(items,context);
                    recList.setItemAnimator(new DefaultItemAnimator());
                    recList.setAdapter(adapter);
                    fab.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            if(!controller){
                                spin(v);
                            }else{
                                spinBack(v);
                            }
                        }
                    });

                    adapter.notifyDataSetChanged();


                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<ZapposModel> call, Throwable t) {

            }
        });


    }
    public void spin(View v){
        ObjectAnimator animator=ObjectAnimator.ofFloat(v,"rotation",0,-155,-135);
        animator.setDuration(300);
        animator.start();
        fab1.setVisibility(View.VISIBLE);

        fab2.setVisibility(View.VISIBLE);
        controller=true;

    }
    public void spinBack(View v){
        ObjectAnimator animator=ObjectAnimator.ofFloat(v,"rotation",-135,20,0);
        animator.setDuration(300);
        animator.start();
        fab1.setVisibility(View.INVISIBLE);

        fab2.setVisibility(View.INVISIBLE);
        controller=false;

    }
}
