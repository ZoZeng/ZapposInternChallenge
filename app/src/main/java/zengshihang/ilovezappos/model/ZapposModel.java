package zengshihang.ilovezappos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by zengshihang on 1/23/17.
 */

public class ZapposModel {
    @SerializedName("results")
    @Expose
    private ArrayList<Item> items;
    @SerializedName("originalTerm")
    @Expose
    private String term;
    @SerializedName("currentResultCount")
    @Expose
    private int count;
    @SerializedName("totalResultCount")
    @Expose
    private int totalCount;
    @SerializedName("statusCode")
    @Expose
    private int code;

    public ArrayList<Item> getItems(){
        return items;
    }

    public int getCode() {
        return code;
    }

    public int getCount() {
        return count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public String getTerm() {
        return term;
    }
}
