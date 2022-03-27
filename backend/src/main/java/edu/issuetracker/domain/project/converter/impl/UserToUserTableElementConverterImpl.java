package edu.issuetracker.domain.project.converter.impl;

import edu.issuetracker.core.util.Converter;
import edu.issuetracker.domain.user.model.User;
import edu.issuetracker.domain.project.viewmodel.UserTableElementViewModel;
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
