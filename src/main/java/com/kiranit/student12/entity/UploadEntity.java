package com.kiranit.student12.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student1")
@Setter
@Getter

public class UploadEntity {
@Id
    private String id;
@Column
    private String firstName;
@Column
    private String lastName;
@Column
    private String branch;
@Column
    private String marks;


}
