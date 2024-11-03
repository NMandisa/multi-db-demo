package za.co.mkhungo.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
/**
 * @author Noxolo.Mkhungo
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-context.xml"})
class CarDataSourceConfigTests {

    @Mock
    private HikariDataSource dataSource;
    @Mock
    private JpaVendorAdapter jpaVendorAdapter;
    @InjectMocks
    private CarDataSourceConfig carDataSourceConfig;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }
    @Test void testEntityManagerFactory()
    { when(dataSource.isRunning()).thenReturn(true); // Mock specific method if needed
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource); factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("za.co.mkhungo.sodi.entity"); factoryBean.afterPropertiesSet(); // Ensure factory bean is fully initialized
        EntityManagerFactory entityManagerFactory = factoryBean.getObject();
        assertNotNull(entityManagerFactory);
    }

    @Test void testEntityManager() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource); factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("za.co.mkhungo.sodi.entity"); factoryBean.afterPropertiesSet();
        EntityManagerFactory entityManagerFactory = factoryBean.getObject(); assertNotNull(entityManagerFactory);
        EntityManager entityManager = entityManagerFactory.createEntityManager(); assertNotNull(entityManager); }

    @Test void testTransactionManager() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource); factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("za.co.mkhungo.sodi.entity"); factoryBean.afterPropertiesSet();
        EntityManagerFactory entityManagerFactory = factoryBean.getObject(); assertNotNull(entityManagerFactory);
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
        assertNotNull(transactionManager); assertNotNull(transactionManager.getEntityManagerFactory()); }
}