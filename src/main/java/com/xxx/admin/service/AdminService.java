package com.xxx.admin.service;

import com.xxx.admin.pojo.Admin;

public interface AdminService {
    Admin getLogin(String name, String password);
}