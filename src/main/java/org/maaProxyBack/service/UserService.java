package org.maaProxyBack.service;

import org.maaProxyBack.model.User;

public interface UserService {
    User signin(User user);
    User save(User user);

}
