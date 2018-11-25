package com.cybord.ti.thrift.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author eddyrs
 *
 */
@EnableTransactionManagement
@EnableJpaRepositories("com.cybord.ti.thrift")
public class SpringDataConfig {

}