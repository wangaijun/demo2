package com.example.demo;

import com.example.demo.entity.neo4j.Actor;
import com.example.demo.entity.neo4j.Movie;
import com.example.demo.repository.neo4j.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Neo4jTest {
    @Autowired
    MovieRepository movieRepository;

    @Before
    public void initData(){
        movieRepository.deleteAll();

        Movie matrix1 = new Movie();
        matrix1.setTitle("The Matrix");
        matrix1.setYear("1999-03-31");

        Movie matrix2 = new Movie();
        matrix2.setTitle("The Matrix Reloaded");
        matrix2.setYear("2002-05-07");

        Movie matrix3 = new Movie();
        matrix3.setTitle("The Matrix Revolutions");
        matrix3.setYear("2013-10-27");

        Actor jiangwen = new Actor();
        jiangwen.setName("jiangwen");

        Actor geyou = new Actor();
        geyou.setName("geyou");

        Actor huangbo = new Actor();
        huangbo.setName("huangbo");

        matrix1.addRole(jiangwen,"Neo");
        matrix1.addRole(geyou,"Morpheus");
        matrix1.addRole(huangbo,"Trinity");
        movieRepository.save(matrix1);
        Assert.notNull(matrix1.getId());

        matrix2.addRole(jiangwen,"Neo");
        matrix2.addRole(geyou,"Morpheus");
        matrix2.addRole(huangbo,"Trinity");
        movieRepository.save(matrix2);
        Assert.notNull(matrix2.getId());

        matrix3.addRole(jiangwen,"Neo");
        matrix3.addRole(geyou,"Morpheus");
        matrix3.addRole(huangbo,"Trinity");
        movieRepository.save(matrix3);
        Assert.notNull(matrix3.getId());

    }

    @Test
    public void get() {
        Movie movie = movieRepository.findByTitle("The Matrix");
        Assert.notNull(movie);
    }


}
