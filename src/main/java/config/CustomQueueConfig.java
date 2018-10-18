package config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * 自动注册队列
 * @Author yucl
 * @date 2018/8/27
 */
@Configuration
public class CustomQueueConfig {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public String firstQueue(){

        try {
            System.out.println("开始创建队列...");
            connectionFactory.createConnection().createChannel(false).queueDeclare("hello1", false, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return "firstQueue";
        }
    }

    public static void main(String[] args) {
    }
}
