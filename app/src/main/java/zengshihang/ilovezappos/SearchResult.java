package zengshihang.ilovezappos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import zengshihang.ilovezappos.API.ZapposAPI;
import zengshihang.ilovezappos.model.ZapposModel;


public class SearchResult extends AppCompatActivity {
    private String search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        // the search term

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.zappos.com/")
                .build();
        ZapposAPI api = retrofit.create(ZapposAPI.class);

        GsonBuilder builder= new GsonBuilder();
        Gson gson = builder.create();
        Call<ZapposModel> call =api.getDetail(getIntent().getExtras().getString("target")),ZapposModel.class);
        call.enqueue(new Callback<zengshihang.ilovezappos.model.ZapposModel>() {
            @Override
            public void onResponse(Call<ZapposModel> call, Response<ZapposModel> response) {

            }

            @Override
            public void onFailure(Call<ZapposModel> call, Throwable t) {

            }
        });
        RecyclerView recList= (RecyclerView) findViewById(R.id.recycle);

    }
}
