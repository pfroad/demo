package com.pfroad.demo;

import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class AliyunDTSSub {
    public static void main(String[] args) {
        IClientProfile profile = DefaultProfile.getProfile("cn-shenzhen", "accsessKeyId", "accessSecret");

    }
}
