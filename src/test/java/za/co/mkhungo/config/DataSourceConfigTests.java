package za.co.mkhungo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Noxolo.Mkhungo
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-context.xml"})
class DataSourceConfigTests {
    @Mock @Qualifier("hikariConfig")
    private HikariConfig hikariConfig;
    @Mock
    @Qualifier("hikariConfig2")
    private HikariConfig hikariConfig2;
    @InjectMocks
    private DataSourceConfig dataSourceConfig;

    @BeforeEach void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPrimaryDataSource() {
        HikariDataSource dataSource = dataSourceConfig.dataSource(hikariConfig);
        assertNotNull(dataSource);
    }

    @Test
    void testSecondaryDataSource() {
        HikariDataSource dataSource2 = dataSourceConfig.dataSource2(hikariConfig2);
        assertNotNull(dataSource2);
    }

    @Test
    void testHikariConfig() {
        HikariConfig hikariConfig = dataSourceConfig.hikariConfig();
        assertNotNull(hikariConfig);
    }

    @Test
    void testHikariConfig2() {
        HikariConfig hikariConfig2 = dataSourceConfig.hikariConfig2();
        assertNotNull(hikariConfig2);
    }
}