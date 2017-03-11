package com.example.yaoxuehua.tourismattractionsapp.entity;

//import org.greenrobot.greendao.annotation.Entity;
//import org.greenrobot.greendao.annotation.Generated;
//import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * Created by niushibin on 2017/2/8 0008.
 */
//@Entity
public class UserInfo implements Serializable {

//    @Id
    private Long id;
    private String uid;
    private String token;// 用户登陆token
    private String avatar;// 用户头像URL
    private String mobile;// 手机号码
    private String nickname;// 昵称
    private String type;// 0=>房客 1=>房东
    private String age;// 年龄
    private String gender;// 0=>男 1=>女
    private String birthday;// 出生日期,时间戳
    private String aboutMe;// 关于我
    private String profession;// 关于我
    private String backimg;// 背景
    private String name;// 真实姓名
    private String number;// 身份证号码
    private String numberpic;// 身份证图片
    private String huanxin;// 环信

//    @Generated(hash = 28382234)
    public UserInfo(Long id, String uid, String token, String avatar,
                    String mobile, String nickname, String type, String age, String gender,
                    String birthday, String aboutMe, String profession, String backimg,
                    String name, String number, String numberpic, String huanxin) {
        this.id = id;
        this.uid = uid;
        this.token = token;
        this.avatar = avatar;
        this.mobile = mobile;
        this.nickname = nickname;
        this.type = type;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.aboutMe = aboutMe;
        this.profession = profession;
        this.backimg = backimg;
        this.name = name;
        this.number = number;
        this.numberpic = numberpic;
        this.huanxin = huanxin;
    }

//    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getBackimg() {
        return backimg;
    }

    public void setBackimg(String backimg) {
        this.backimg = backimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberpic() {
        return numberpic;
    }

    public void setNumberpic(String numberpic) {
        this.numberpic = numberpic;
    }

    public String getHuanxin() {
        return huanxin;
    }

    public void setHuanxin(String huanxin) {
        this.huanxin = huanxin;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", avatar='" + avatar + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nickname='" + nickname + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", profession='" + profession + '\'' +
                ", backimg='" + backimg + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", numberpic='" + numberpic + '\'' +
                ", huanxin='" + huanxin + '\'' +
                '}';
    }
}
