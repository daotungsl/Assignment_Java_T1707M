package assignment.Entity;

public class Student {
    private int id;
    private String rollNumber;
    private String name;
    private int gender;
    private String phone;
    private String email;
    private int status;
    private long createdAt;
    private long updateAt;
    private long birthday;


    public Student() {
    }


    public Student(int status, long createdAt, long updateAt) {
        this.status = status;
        this.createdAt = createdAt =System.currentTimeMillis();
        this.updateAt = updateAt =System.currentTimeMillis();
    }

    public Student(int id, String rollNumber, String name, int gender, String phone, String email, int status, long createdAt, long updateAt) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }
}
