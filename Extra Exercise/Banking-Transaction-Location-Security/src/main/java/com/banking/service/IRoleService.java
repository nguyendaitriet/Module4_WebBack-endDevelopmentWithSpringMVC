package com.banking.service;

import com.banking.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
