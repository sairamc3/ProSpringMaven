package com.prospring.DbJdbc.plainjdbc.entities;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Builder
public class Singer implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private List<Album> albums;

}
