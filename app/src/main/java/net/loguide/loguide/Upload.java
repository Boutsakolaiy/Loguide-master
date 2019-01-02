package net.loguide.loguide;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mTime;
    private String mContent;

    public Upload(){

    }

    public Upload(String name, String imageUrl, String time, String content){
        if (name.trim().equals("")){
            name = "No name";
        }

        mName = name;
        mImageUrl = imageUrl;
        mTime = time;
        mContent = content;
    }

    public String getName() {
        return mName;

    }
    public void setName(String name){
        mName = name;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getTime() {
        return mTime;

    }
    public void setTime(String time){
        mTime = time;
    }

    public String getContent() {
        return mContent;

    }
    public void setContent(String content){
        mContent = content;
    }
}