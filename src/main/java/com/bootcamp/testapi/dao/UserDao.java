package com.bootcamp.testapi.dao;

import com.bootcamp.testapi.dto.UsersDto;
import com.bootcamp.testapi.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void save(UsersDto.Save inputData) {
        String query = """
                INSERT INTO users("name", email, phone)
                VALUES(:name, :email, :phone)
                """;

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", inputData.getName());
        map.addValue("email", inputData.getEmail());
        map.addValue("phone", inputData.getPhone());
        this.jdbcTemplate.update(query, map);
    }

    public List<Users> findAll() {
        String query = """
                SELECT id, "name", email, phone
                FROM users
                """;

        return this.jdbcTemplate.query(query, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                return user;
            }
        });
    }

    public Optional<Users> findById(Integer id) {
        String query = """
                SELECT id, "name", email, phone
                FROM users where id=:id
                """;

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);

        try {
            return this.jdbcTemplate.queryForObject(query, map, new RowMapper<Optional<Users>>() {
                @Override
                public Optional<Users> mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Users user = new Users();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getString("phone"));
                    return Optional.of(user);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public void delete(Integer id) {
        String query = """
                DELETE FROM public.users
                WHERE id=:id
                """;

        MapSqlParameterSource map = new MapSqlParameterSource("id", id);

        this.jdbcTemplate.update(query, map);
    }

    public void update(UsersDto.Save updateData, Integer id) {
        String query = """
                UPDATE users
                SET "name"=:name, email=:email, phone=:phone
                WHERE id=:id
                """;

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        map.addValue("name", updateData.getName());
        map.addValue("email", updateData.getEmail());
        map.addValue("phone", updateData.getPhone());
        this.jdbcTemplate.update(query, map);
    }


}
