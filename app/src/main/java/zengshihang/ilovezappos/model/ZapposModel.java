package zengshihang.ilovezappos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zengshihang on 1/23/17.
 */

public class ZapposModel {
    @SerializedName("results")
    @Expose
    private Item[] items;
    @SerializedName("originalTerm")
    private String term;
    @SerializedName("currentResultCount")
    private int count;
    @SerializedName("totalResultCount")
    private int totalCount;
    @SerializedName("statusCode")
    private int code;

}
