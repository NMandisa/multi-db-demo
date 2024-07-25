package za.co.mkhungo.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Noxolo.Mkhungo
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "EntityManagerFactory",
        transactionManagerRef = "TransactionManager",
        basePackages = { "za.co.mkhungo.sodi.repository" })
public class CarDataSourceConfig {

    private final HikariDataSource dataSource;
    private final JpaVendorAdapter jpaVendorAdapter;

    @Autowired
    public CarDataSourceConfig(@Qualifier("dataSource") HikariDataSource dataSource, @Qualifier("jpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter){
        this.dataSource = dataSource;
        this.jpaVendorAdapter = jpaVendorAdapter;
    }

    @Bean(name = "entityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("za.co.mkhungo.sodi.entity");
        lef.setPersistenceUnitName("defaultPersistenceUnit");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

}
