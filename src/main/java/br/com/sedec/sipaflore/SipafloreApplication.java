package br.com.sedec.sipaflore;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import static org.springframework.boot.SpringApplication.run;

@EnableAsync
@EnableJpaAuditing
@EntityScan(basePackages = {"br.com.sedec.sipaflore.entity"})
@EnableJpaRepositories(basePackages = {"br.com.sedec.sipaflore.repository"},
    repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackages = {"br.com.sedec.sipaflore"})
public class SipafloreApplication {

    public static void main(final String[] args) {
        run(SipafloreApplication.class, args);
    }

}
