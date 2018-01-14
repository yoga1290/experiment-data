package experiments.springdata.jdbc;


import experiments.springdata.ApplicationConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Thomas Risberg
 */
//@Profile("jdbc")

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "experiments.springdata")
//@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

    @Autowired
    Environment env;

//    @Bean
//    public DataSource dataSource() {
//        System.out.println("DataSource");
//
//        BasicDataSource ds = new BasicDataSource();
//        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//        ds.setUrl(env.getProperty("jdbc.url"));
//        ds.setUsername(env.getProperty("jdbc.username"));
//        ds.setPassword(env.getProperty("jdbc.password"));
//        return ds;
//    }
    @Bean
    public DataSource dataSource() {
        System.out.println("DataSource");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        System.out.println("LocalContainerEntityManagerFactoryBean");

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            vendorAdapter.setDatabase(Database.HSQL);
            vendorAdapter.setGenerateDdl(true);
        factory.setJpaVendorAdapter(vendorAdapter);

        factory.setPackagesToScan("experiments.springdata.model");
        factory.setDataSource(dataSource());

        return factory;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        System.out.println("PlatformTransactionManager");
//        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
//        txManager.setDataSource(dataSource());
//        return txManager;
//    }
//     /*
    @Bean
    public PlatformTransactionManager transactionManager() {
        System.out.println("PlatformTransactionManager");
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }
    //*/

    /*
    <bean id="transactionInterceptor"
       class="org.springframework.transaction.interceptor.TransactionInterceptor">
	<property name="transactionManager" ref="transactionManager" />
	<property name="transactionAttributes">
	   <props>
		<prop key="save">PROPAGATION_REQUIRED</prop>
	   </props>
	</property>
    </bean>
     */
//    @Bean
//    public TransactionInterceptor transactionInterceptor() {
//        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
//        transactionInterceptor.setTransactionManager(transactionManager());
//        Properties properties = new Properties();
//        properties.setProperty("save", "PROPAGATION_REQUIRED");
//        transactionInterceptor.setTransactionAttributes(properties);
//        return transactionInterceptor;
//    }
}
