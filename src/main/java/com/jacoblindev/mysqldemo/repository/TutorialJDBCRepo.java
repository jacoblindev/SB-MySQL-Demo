package com.jacoblindev.mysqldemo.repository;

import java.util.List;

import com.jacoblindev.mysqldemo.model.Tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TutorialJDBCRepo implements TutorialRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Tutorial book) {
        return jdbcTemplate.update("INSERT INTO tutorials (title, description, published) VALUES(?,?,?)",
                book.getTitle(), book.getDescription(), book.isPublished());
    }

    @Override
    public int update(Tutorial book) {
        return jdbcTemplate.update("UPDATE tutorials SET title=?, description=?, published=? WHERE id=?",
                book.getTitle(), book.getDescription(), book.isPublished(), book.getId());
    }

    @Override
    public Tutorial findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM tutorials WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Tutorial.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM tutorials WHERE id=?", id);
    }

    @Override
    public List<Tutorial> findAll() {
        return jdbcTemplate.query("SELECT * FROM tutorials", BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        return jdbcTemplate.query("SELECT * FROM tutorials WHERE published=?",
                BeanPropertyRowMapper.newInstance(Tutorial.class), published);
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        String sql = "SELECT * FROM tutorials WHERE title LIKE '%" + title + "%'";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM tutorials");
    }

}
