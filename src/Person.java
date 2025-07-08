public class Person {
    //Creating variables
    private String name;
    private String sureName;
    private String email;

    //Creating constructor
    public Person(String name,String sureName,String email){
        this.name=name;
        this.sureName=sureName;
        this.email=email;
    }

    //getting getters and setters

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getSureName(){
        return sureName;
    }
    public void setSureName(String sureName){
        this.sureName=sureName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    //method for print person information

    public void infoPrint(){
        System.out.println("Name: " + name);
        System.out.println("Surname: " + sureName);
        System.out.println("Email: " + email);
    }
}
