package com.prospring.DbJdbc.plainjdbc;

import com.prospring.DbJdbc.plainjdbc.dao.SingerDao;
import com.prospring.DbJdbc.plainjdbc.dao.SingerDaoImpl;
import com.prospring.DbJdbc.plainjdbc.entities.Singer;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PlainJdbcDemo {

    private static SingerDao singerDao = new SingerDaoImpl();

    public static void main(String[] args) {

        log.info("List all the singer in db");

        List<Singer> singers = singerDao.findAll();

        singers.forEach(s -> log.info(s.toString()));

        log.info("Listed all the singers");

    }

}
