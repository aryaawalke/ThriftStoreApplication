package com.example.thriftstore;


public class CourseModelCart {

    // string course_name for storing course_name
    // and imgid for storing image id.
    private String course_name;
    private String course_price;
    private int imgid;
    private boolean delete;

    public CourseModelCart(String course_name, String course_price, int imgid,boolean delete) {
        this.course_name = course_name;
        this.course_price = course_price;
        this.imgid = imgid;
        this.delete = delete;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
    public String getCourse_price() {
        return course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }


    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

}
