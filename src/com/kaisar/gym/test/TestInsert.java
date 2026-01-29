package com.kaisar.gym.test;

import com.kaisar.gym.database.MemberDAO;
import com.kaisar.gym.model.Member;

public class TestInsert {
    public static void main(String[] args) {

        // создаём объект Member
        Member member = new Member(
                1,                  // member_id
                "Kaisar",        // full_name
                19,                 // age
                "Premium"           // membership_name
        );

        // вызываем DAO
        MemberDAO dao = new MemberDAO();
        dao.insertMember(member);
    }
}

