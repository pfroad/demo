package com.pfroad.demo.datasource;

import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns = "/druid/*")
public class DruidStatViewServlet extends StatViewServlet {

}
