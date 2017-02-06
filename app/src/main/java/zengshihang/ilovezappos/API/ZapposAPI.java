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
    @GET("/Search?term=/{search}/&key=b743e26728e16b81da139182bb2094357c31d331")
    Call<ZapposModel> getDetail(@Path("search")String search);

}
