package edu.issuetracker.domain.converter.impl;

import edu.issuetracker.domain.converter.Converter;
import edu.issuetracker.domain.model.user.User;
import edu.issuetracker.domain.viewmodel.user.UserTableElementViewModel;
import org.springframework.stereotype.Component;

@Component
public class UserToUserTableElementConverterImpl implements Converter<User, UserTableElementViewModel> {

    @Override
    public UserTableElementViewModel convert(User user) {
        if (user == null) {
            return null;
        }
        return new UserTableElementViewModel(user.getId(), user.getUsername());
    }
}
