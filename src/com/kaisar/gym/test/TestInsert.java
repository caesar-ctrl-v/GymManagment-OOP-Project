package com.kaisar.gym.test;

import com.kaisar.gym.database.*;
import com.kaisar.gym.model.*;

public class TestInsert {
    public static void main(String[] args) {

        // creating object Member
        Member member = new Member(
                1,                  // member_id
                "Kaisar",        // full_name
                19,                 // age
                "Premium"           // membership_name
        );

        // calling DAO
        MemberDAO memberDAO = new MemberDAO();
        memberDAO.insertMember(member);
    }
}

