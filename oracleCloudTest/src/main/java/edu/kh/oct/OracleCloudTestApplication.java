package edu.kh.oct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class OracleCloudTestApplication {
	
	 private static final Logger log = LoggerFactory.getLogger(OracleCloudTestApplication.class);

    private final JdbcTemplate jdbcTemplate;

    public OracleCloudTestApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


	public static void main(String[] args) {
		SpringApplication.run(OracleCloudTestApplication.class, args);
	}
	
	@Bean
    public ApplicationRunner runner() {
        return args -> {
            jdbcTemplate.execute("""
            CREATE TABLE TEST (
                ID VARCHAR2(50),
                NAME VARCHAR2(50)
            )
            """.stripIndent());

            jdbcTemplate.update("""
            INSERT INTO TEST (ID ,NAME) VALUES( 'ID1', 'NAME1' )
            """.stripIndent());

            jdbcTemplate.update("""
            INSERT INTO TEST (ID ,NAME) VALUES( 'ID2', 'NAME2' )
            """.stripIndent());

            jdbcTemplate.update("""
            INSERT INTO TEST (ID ,NAME) VALUES( 'ID3', 'NAME3' )
            """.stripIndent());

            jdbcTemplate.update("""
            INSERT INTO TEST (ID ,NAME) VALUES( 'ID4', 'NAME4' )
            """.stripIndent());
        };
    }

}
