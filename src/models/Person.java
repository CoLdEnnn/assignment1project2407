package models;

public class Person {
    private String name;
    private String surname;
    private int age;
    private Boolean gender;

    public Person() {}
    public Person(String name, String surname, int age, Boolean gender) {
        this();
        setName(name);
        setSurname(surname);
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Boolean isGender() { return gender; }
    public void setGender(Boolean gender) { this.gender = gender; }

    @Override
    public String toString() {
        String genderStr = gender ? "male" : "female";
        return "Hi, I am " + name + ' ' + surname + ' ' + ", a " + ' ' + age + "-year-old" + ' ' + genderStr; }
}
