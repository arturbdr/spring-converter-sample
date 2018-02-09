package com.sample.spring.springconverter.converter;

import com.sample.spring.springconverter.domain.User;
import com.sample.spring.springconverter.json.UserTo;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserToUserToTest {

    @Autowired
    UserToUserToConverter userToUserToConverter;

    @Test
    public void shouldConvertUserToUserTest() {
        User user = User.builder().age(30).name("Teste").build();
        Optional<UserTo> expectedOptionalUserTO = Optional.ofNullable(UserTo.builder().nome("TESTE").idade(30).build());

        Optional<UserTo> converted = userToUserToConverter.convert(user);


        BDDAssertions.then(converted).isEqualTo(expectedOptionalUserTO);
        BDDAssertions.then(converted.get()).isEqualTo(expectedOptionalUserTO.get());
        BDDAssertions.then(converted.get().getIdade()).isEqualTo(30);
        BDDAssertions.then(converted.get().getNome().equals("TESTE"));
    }

    @Test
    public void shouldConvertUserToEmptyUser() {
        User user = null;

        Optional<UserTo> converted = userToUserToConverter.convert(user);

        BDDAssertions.then(converted).isEqualTo(Optional.empty());
        BDDAssertions.then(converted.isPresent()).isFalse();
    }

}