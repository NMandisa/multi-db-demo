package za.co.mkhungo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Noxolo.Mkhungo
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-context.xml"})
class ApplicationContextTests {

    @Autowired
    private ApplicationContext context;

    @BeforeEach void setUp() {
        // Optional: initialize test setup
    }

    @Test void contextLoads() {
        assertNotNull(context); }
    @Test void testDataSourceBean() {
        Object dataSource = context.getBean("dataSource");
        assertNotNull(dataSource); }
    @Test void testTransactionManagerBean() {
        Object transactionManager = context.getBean("transactionManager");
        assertNotNull(transactionManager); }
    @Test void testJpaVendorAdapterBean() {
        Object jpaVendorAdapter = context.getBean("jpaVendorAdapter");
        assertNotNull(jpaVendorAdapter); }
}