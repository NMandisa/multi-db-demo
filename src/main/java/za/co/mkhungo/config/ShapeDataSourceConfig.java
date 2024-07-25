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
        entityManagerFactoryRef = "EntityManagerFactory2",
        transactionManagerRef = "TransactionManager2",
        basePackages = { "za.co.mkhungo.squnga.repository" })
public class ShapeDataSourceConfig {

    private final HikariDataSource dataSource;
    private final JpaVendorAdapter jpaVendorAdapter;

    @Autowired
    public ShapeDataSourceConfig(@Qualifier("dataSource2") HikariDataSource dataSource,@Qualifier("jpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter){
        this.dataSource = dataSource;
        this.jpaVendorAdapter = jpaVendorAdapter;
    }

    @Bean(name = "entityManager2")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean(name = "entityManagerFactory2")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("za.co.mkhungo.squnga.entity");
        lef.setPersistenceUnitName("persistenceUnit2");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

    @Bean(name = "barTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

}
