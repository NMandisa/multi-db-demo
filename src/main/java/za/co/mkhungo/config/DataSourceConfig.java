package za.co.mkhungo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Noxolo.Mkhungo
 */
@Configuration
public class DataSourceConfig {

    //private final Environment env;

    //@Autowired
    //public DataSourceConfig(Environment env) {
        //this.env = env;
    //}

    @Bean(name = "dataSource")
    @Primary
    public HikariDataSource dataSource(@Qualifier("dataSource") HikariConfig hikariConfig) {
        //HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        //dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "dataSource2")
    public HikariDataSource dataSource2(@Qualifier("dataSource") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "hikariConfig")
    public HikariConfig hikariConfig() {
        //HikariConfig hikariConfig = new HikariConfig();
        //hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        return new HikariConfig();
    }

    @Bean(name = "hikariConfig2")
    public HikariConfig hikariConfig2() {
        return new HikariConfig();
    }
}
