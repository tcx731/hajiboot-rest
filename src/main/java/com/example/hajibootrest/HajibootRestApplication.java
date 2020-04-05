package com.example.hajibootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@SpringBootApplication
public class HajibootRestApplication implements CommandLineRunner {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate; // (1)

	@Override
	public void run(String... strings) throws Exception {
		String sql = "SELECT 1";
		SqlParameterSource param = new MapSqlParameterSource();
		Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);

		System.out.println("result = " + result);

		String sql2 = "SELECT :a + :b";
		SqlParameterSource param2 = new MapSqlParameterSource()
				.addValue("a", 100)
				.addValue("b", 200);
		Integer result2 = jdbcTemplate.queryForObject(sql2, param2, Integer.class);

		System.out.println("result2 = " + result2);
	}


	public static void main(String[] args) {
		SpringApplication.run(HajibootRestApplication.class, args);
	}

}
