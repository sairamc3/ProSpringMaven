package com.prospring.DbJdbc.plainjdbc.dao;

import com.prospring.DbJdbc.plainjdbc.entities.Singer;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SingerDaoImpl implements SingerDao {


    static {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex) {

            log.error("Class not found ", ex);
        }
    }

    private Connection getConnection() throws SQLException {

       return DriverManager.getConnection("jdbc:mysql://localhost:3306/musicdb?allowPublicKeyRetrieval=true&useSSL=false",
        "prospring5", "prospring5");
    }

    private void closeConnection(Connection connection) {

        if (connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            log.error("Problem closing db connection", e);
        }
    }


    @Override
    public List<Singer> findAll() {

        List<Singer> singers = new ArrayList<>();

        Connection connection = null;

        try {
            connection=getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("Select * from Singer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Singer singer = Singer.builder().id(resultSet.getLong("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .birthDate(resultSet.getDate("birth_date"))
                        .build();

                singers.add(singer);

            }
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }


        return singers;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {

    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public List<Singer> findAllWithAlbums() {
        return null;
    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }
}
