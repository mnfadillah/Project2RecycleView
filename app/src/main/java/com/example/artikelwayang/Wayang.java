package com.example.artikelwayang;

import android.os.Parcel;
import android.os.Parcelable;

public class Wayang implements Parcelable {
    private String wayang_detail;
    private String photo;
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.wayang_detail);
        dest.writeString(this.photo);
        dest.writeString(this.name);
    }

    public Wayang() {
    }

    private Wayang(Parcel in) {
        this.wayang_detail = in.readString();
        this.photo = in.readString();
        this.name = in.readString();
    }

    public static final Creator<Wayang> CREATOR = new Creator<Wayang>() {
        @Override
        public Wayang createFromParcel(Parcel source) {
            return new Wayang(source);
        }

        @Override
        public Wayang[] newArray(int size) {
            return new Wayang[size];
        }
    };

    public String getWayang_detail() {
        return wayang_detail;
    }

    public void setWayang_detail(String wayang_detail) {
        this.wayang_detail = wayang_detail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
