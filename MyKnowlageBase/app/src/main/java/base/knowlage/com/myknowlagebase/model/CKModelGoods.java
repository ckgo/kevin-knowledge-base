package base.knowlage.com.myknowlagebase.model;

import android.os.Parcel;
import android.os.Parcelable;

/*
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/16 16:36
 * Desc:商品实体类
 */
public class CKModelGoods implements Parcelable {
    private String name;
    private String price;
    private String imgurl;

    public CKModelGoods() {
    }

    protected CKModelGoods(Parcel in) {
        name = in.readString();
        price = in.readString();
        imgurl = in.readString();
    }

    public static final Creator<CKModelGoods> CREATOR = new Creator<CKModelGoods>() {
        @Override
        public CKModelGoods createFromParcel(Parcel in) {
            return new CKModelGoods(in);
        }

        @Override
        public CKModelGoods[] newArray(int size) {
            return new CKModelGoods[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(imgurl);
    }
}
