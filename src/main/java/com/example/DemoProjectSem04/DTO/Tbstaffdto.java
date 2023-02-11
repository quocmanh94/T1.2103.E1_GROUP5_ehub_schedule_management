/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public class Tbstaffdto {
    public String code;
    public String name;
    public String positionname;
    public String positioncode;
    public String email;
    public String address;
    public String phone;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    @JsonFormat(pattern="dd-MM-yyyy")
    public Date dob;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String image;
    public String gender;
    public String password;
    public String typestaff;
    public String typestaffname;
    public String levelstudy;

    public String getTypestaffname() {
        return typestaffname;
    }

    public void setTypestaffname(String typestaffname) {
        this.typestaffname = typestaffname;
    }
    public MultipartFile img;

    public MultipartFile getImg() {
        return img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public Tbstaffdto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public String getPositioncode() {
        return positioncode;
    }

    public void setPositioncode(String positioncode) {
        this.positioncode = positioncode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypestaff() {
        return typestaff;
    }

    public void setTypestaff(String typestaff) {
        this.typestaff = typestaff;
    }

    public String getLevelstudy() {
        return levelstudy;
    }

    public void setLevelstudy(String levelstudy) {
        this.levelstudy = levelstudy;
    }
    
}
