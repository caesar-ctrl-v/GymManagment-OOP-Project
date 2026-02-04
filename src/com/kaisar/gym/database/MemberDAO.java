package com.kaisar.gym.database;

import com.kaisar.gym.model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    public void insertMember(Member member) {
        String sql = "INSERT INTO member (member_id, full_name, age, membership_name) VALUES (?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set parameters (? → actual values)
            statement.setInt(1, member.getMemberId());
            statement.setString(2, member.getFullName());
            statement.setInt(3, member.getAge());
            statement.setString(4, member.getMembershipName());

            // Execute INSERT
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("✅ Member inserted successfully!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllMember() {
        String sql = "SELECT * FROM member";

        Connection connection = DatabaseConnection.getConnection();

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- ALL MEMBERS FROM DATABASE ---");

            while(resultSet.next()){
                int id = resultSet.getInt("member_id");
                String fullName = resultSet.getString("full_name");
                int age = resultSet.getInt("age");
                String membershipName = resultSet.getString("membership_name");

                Member member = new Member(id, fullName, age, membershipName);
                System.out.println(member);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public boolean updateMember(Member member) {
        String sql = "UPDATE member SET full_name=?, age=?, membership_name=? WHERE member_id=?";

        Connection connection = DatabaseConnection.getConnection();
        if(connection == null) return false;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, member.getFullName());
            statement.setInt(2, member.getAge());
            statement.setString(3, member.getMembershipName());
            statement.setInt(4, member.getMemberId()); // WHERE condition

            int  rowsUpdated = statement.executeUpdate();
            statement.close();
            if (rowsUpdated > 0) {
                System.out.println("✅ Member updated: " + member.getFullName());
                return true;
            }

        } catch (SQLException e){
            System.out.println("❌ Update Failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
}
