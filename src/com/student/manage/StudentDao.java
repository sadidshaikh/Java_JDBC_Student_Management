package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB(Student st) {
        // jdbc code...
        boolean flag = false;
        try {
            Connection con = CP.createC();
            String q = "INSERT INTO students(sname, sphone, scity) values(?,?,?)";

            // PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the values of parameters
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            // execute...
            pstmt.executeUpdate();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteStudent(int userId) {
        // jdbc code...
        boolean flag = false;
        try {
            Connection con = CP.createC();
            String q = "DELETE FROM students where sid=?";

            // PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the values of parameters
            // pstmt.setString(1, String.valueOf(userId)); OR
            pstmt.setInt(1, userId);

            // execute...
            // flag = pstmt.execute(); OR
            pstmt.executeUpdate();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void showAllStudents() {
        // jdbc code...
        try {
            Connection con = CP.createC();
            String q = "SELECT * FROM students";

            // CreateStatement
            Statement stmt = con.createStatement();

            // execute...
            ResultSet set = stmt.executeQuery(q);

            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);

                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Phone : " + phone);
                System.out.println("City : " + city);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}