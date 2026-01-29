package com.kaisar.gym.test;

import com.kaisar.gym.database.MemberDAO;

public class TestSelect{
    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();
        dao.getAllMember();
    }
}

