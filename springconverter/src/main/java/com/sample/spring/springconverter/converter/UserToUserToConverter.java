package com.sample.spring.springconverter.converter;

import com.sample.spring.springconverter.domain.User;
import com.sample.spring.springconverter.json.UserTo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserToUserToConverter implements Converter<User, Optional<UserTo>> {
    @Override
    public Optional<UserTo> convert(User source) {
        return Optional.ofNullable(source)
                .map(usr -> UserTo.builder()
                        .nome(usr.getName() != null ? usr.getName().toUpperCase() : null) // For sample purposes only
                        .idade(usr.getAge())
                        .build());
    }
}
