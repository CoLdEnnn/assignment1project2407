package models;

import java.util.ArrayList;
import java.util.List;

public class School extends Person {
    private final List<Person> members;
    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person member) {
        members.add(member);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Person member : members) {
            str.append(member.toString()).append("\n");
        }
        return str.toString();
    }
}
