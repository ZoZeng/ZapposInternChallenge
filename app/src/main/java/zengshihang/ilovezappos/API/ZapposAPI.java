package zengshihang.ilovezappos.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import zengshihang.ilovezappos.model.ZapposModel;


/**
 * Created by zengshihang on 1/23/17.
 */

public interface ZapposAPI {
    @GET("Search")
    Call<ZapposModel> getDetail(@Query("term")String term,@Query("key")String key);

}
