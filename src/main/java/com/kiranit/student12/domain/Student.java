package com.kiranit.student12.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String branch;
    private String marks;

    public Student(String id, String firstName, String lastName, String branch, String marks) {
        this.id=id;
        this.firstName = firstName;
        this.lastName= lastName;
        this.branch = branch;
        this.marks= marks;
    }
}
