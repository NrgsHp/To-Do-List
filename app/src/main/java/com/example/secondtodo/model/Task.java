package com.example.secondtodo.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_tasks")
public class Task implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    @ColumnInfo(name = "is_completed")
    private boolean isCompleted;
    private int importance=IMPORTANCE_NORMAL;

    public static final int IMPORTANCE_HIGH = 2;
    public static final int IMPORTANCE_NORMAL = 1;
    public static final int IMPORTANCE_LOW = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeByte(this.isCompleted ? (byte) 1 : (byte) 0);
        dest.writeInt(this.importance);
    }

    public Task() {
    }

    protected Task(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.isCompleted = in.readByte() != 0;
        this.importance = in.readInt();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
