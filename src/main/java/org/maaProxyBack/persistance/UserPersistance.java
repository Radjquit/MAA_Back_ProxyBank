package org.maaProxyBack.persistance;

import org.maaProxyBack.model.User;

public interface UserPersistance {
    User signin(User user);

}
