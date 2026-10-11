public class Members {
    private int userID;
    private String name;
    private String lastName;
    private String fullName;
    private int age;


    public Members(int userID, String name, String lastName, int age) {
        this.userID = userID;
        this.name = name;
        this.lastName = lastName;
        this.fullName = name + " " + lastName;
        this.age = age;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return this.fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printUserInfo(){
        System.out.println("[ userID: " + this.getUserID() +
                " | FirstName: " + this.getName() +
                " | LastName: " + this.getLastName() + " ]");
    }




}
