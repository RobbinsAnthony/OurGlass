package Timestoppers.OurGlass.OurGlass.user.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String UserFullName;
    private String userEmail;
    private String userJobTitle;
    private String userContactInfo;
    private String userJobDescription;
    private Double userCompensation;
    private String userPassword;
    private String userUsername;
    private Long userIdNumber;


    public User() {
    }

    public User(String userFullName, String userEmail, String userJobTitle, String userContactInfo, String userJobDescription, Double userCompensation, String userPassword, String userUsername, Long userIdNumber) {
        UserFullName = userFullName;
        this.userEmail = userEmail;
        this.userJobTitle = userJobTitle;
        this.userContactInfo = userContactInfo;
        this.userJobDescription = userJobDescription;
        this.userCompensation = userCompensation;
        this.userPassword = userPassword;
        this.userUsername = userUsername;
        this.userIdNumber = userIdNumber;
    }

    public String getUserFullName() {
        return UserFullName;
    }

    public void setUserFullName(String userFullName) {
        UserFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserJobTitle() {
        return userJobTitle;
    }

    public void setUserJobTitle(String userJobTitle) {
        this.userJobTitle = userJobTitle;
    }

    public String getUserContactInfo() {
        return userContactInfo;
    }

    public void setUserContactInfo(String userContactInfo) {
        this.userContactInfo = userContactInfo;
    }

    public String getUserJobDescription() {
        return userJobDescription;
    }

    public void setUserJobDescription(String userJobDescription) {
        this.userJobDescription = userJobDescription;
    }

    public Double getUserCompensation() {
        return userCompensation;
    }

    public void setUserCompensation(Double userCompensation) {
        this.userCompensation = userCompensation;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public Long getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(Long userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(UserFullName, user.UserFullName) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userJobTitle, user.userJobTitle) && Objects.equals(userContactInfo, user.userContactInfo) && Objects.equals(userJobDescription, user.userJobDescription) && Objects.equals(userCompensation, user.userCompensation) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userUsername, user.userUsername) && Objects.equals(userIdNumber, user.userIdNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserFullName, userEmail, userJobTitle, userContactInfo, userJobDescription, userCompensation, userPassword, userUsername, userIdNumber);
    }


    @Override
    public String toString() {
        return "User{" +
                "UserFullName='" + UserFullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userJobTitle='" + userJobTitle + '\'' +
                ", userContactInfo='" + userContactInfo + '\'' +
                ", userJobDescription='" + userJobDescription + '\'' +
                ", userCompensation=" + userCompensation +
                ", userPassword='" + userPassword + '\'' +
                ", userUsername='" + userUsername + '\'' +
                ", userIdNumber=" + userIdNumber +
                '}';
    }
}

