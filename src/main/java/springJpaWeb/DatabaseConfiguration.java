package springJpaWeb;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan("springJpaWeb")
@EnableJpaRepositories("springJpaWeb")
public class DatabaseConfiguration {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSurce());
		factoryBean.setPackagesToScan("springJpaWeb");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(getJpaProperties());
		return factoryBean;
	}

	@Bean
	public Properties getJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.dialtect", "org.hibernate.dialect.Oracle10gDialect");
		return properties;
	}

	@Bean
	public DataSource dataSurce() {
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
	      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	      dataSource.setUsername("employee");
	      dataSource.setPassword("P@s5");
		return dataSource;
	}

}
