package com.dh.mapperte;

import com.dh.mapperte.enpity.Config;
import com.dh.mapperte.repository.ConfigRepositroy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperteApplicationTests {
    @Autowired
    private ConfigRepositroy configRepositroy;
    @Test
    public void contextLoads() {
        Optional<Config> byId = configRepositroy.findById(1);
        Config config = byId.get();
        System.out.println();
    }
    @Test
    public void getPath() {
        System.out.println(System.getProperty("user.dir"));
    }
}
