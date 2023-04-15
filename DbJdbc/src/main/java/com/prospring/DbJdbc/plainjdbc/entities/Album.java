package com.prospring.DbJdbc.plainjdbc.entities;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
public class Album implements Serializable {

    private Long id;
    private Long singerId;
    private String title;

    private Date releaseDate;
}
