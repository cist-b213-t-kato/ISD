/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec04;

/**
 *
 * @author b2130480
 */
public class Student {
    
    private String studentCode;
    private String familyName;
    private String givenName;
    private String schoolName;
    
    public Student(String studentCode, String familyName,
            String givenName, String schoolName){
        this.studentCode = studentCode;
        this.familyName = familyName;
        this.givenName = givenName;
        this.schoolName = schoolName;
    }
    
    @Override
    public String toString(){
        return "学籍番号:" + studentCode 
                + ", 氏名:" + familyName + givenName
                + ", 学校:" + schoolName;
    }
    
}
