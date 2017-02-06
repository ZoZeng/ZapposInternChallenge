package zengshihang.ilovezappos.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zengshihang on 1/24/17.
 */

public class Item {
    @SerializedName("brandName")
    private String brand;
    @SerializedName("thumbnailImageUrl")
    private String thumbnail;
    @SerializedName("styleId")
    private int sid;
    @SerializedName("productUrl")
    private String image;
    @SerializedName("productName")
    private String name;
    @SerializedName("productId")
    private int pid;
    @SerializedName("price")
    private String price;
    @SerializedName("percentOff")
    private String percent;
    @SerializedName("originalPrice")
    private String originalPrice;
    @SerializedName("colorId")
    private int cid;
    public String getBrand(){
        return this.brand;
    }
    public String getThumbnail(){
        return this.thumbnail;
    }
    public String getImage(){
        return this.image;
    }
    public String getName(){
        return this.name;
    }
    public String getPrice(){
        return this.price;
    }
    public String getPercent(){
        return this.percent;
    }
    public String getOriginalPrice(){
        return this.originalPrice;
    }
    public int getSid(){
        return this.sid;
    }
    public int getPid(){
        return this.pid;
    }public int getCid(){
        return this.cid;
    }
}
