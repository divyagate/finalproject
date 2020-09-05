package com.example.finalproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Punkapi implements Parcelable{

    private int id;
    private String name;
    private String image_url;
    private Double abv;
    private int ibu;
    private Double ph;
    private String tagline;
    private String description;

    public Punkapi(int id,String name, String image_url,Double abv,int ibu,Double ph,String tagline,String description) {
        this.id=id;
        this.name = name;
        this.image_url= image_url;
        this.abv=abv;
        this.ibu =ibu;
        this.ph=ph;
        this.tagline=tagline;
        this.description=description;
    }


    protected Punkapi(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image_url = in.readString();
        if (in.readByte() == 0) {
            abv = null;
        } else {
            abv = in.readDouble();
        }
        ibu = in.readInt();
        if (in.readByte() == 0) {
            ph = null;
        } else {
            ph = in.readDouble();
        }
        tagline = in.readString();
        description = in.readString();
    }

    public static final Creator<Punkapi> CREATOR = new Creator<Punkapi>() {
        @Override
        public Punkapi createFromParcel(Parcel in) {
            return new Punkapi(in);
        }

        @Override
        public Punkapi[] newArray(int size) {
            return new Punkapi[size];
        }
    };

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getimage_url() {
        return image_url;
    }
    public void setimage_url(String nodeId) {
        this.image_url = image_url;
    }

    public Double getabv() {
        return abv;
    }
    public void setabv(Double abv) {
        this.abv = abv;
    }

    public int getibu() {
        return ibu;
    }
    public void setibu(Integer ibu) {
        this.ibu = ibu;
    }

    public Double getph() {
        return ph;
    }
    public void setaph(Double ph) {
        this.ph = ph;
    }

    public String gettagline() {
        return tagline;
    }
    public void settagline(String tagline) {
        this.tagline = tagline;
    }

    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(image_url);
        if (abv == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(abv);
        }
        parcel.writeInt(ibu);
        if (ph == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(ph);
        }
        parcel.writeString(tagline);
        parcel.writeString(description);
    }
}
