package com.example.crudsteels.services;


import com.example.crudsteels.exceptions.ResourceNotFoundException;
import com.example.crudsteels.models.Role;
import com.example.crudsteels.repositories.RoleRepository;
import com.example.crudsteels.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService
{
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserAuditing userAuditing;

    @Override
    public List<Role> findAll()
    {
        List<Role> list = new ArrayList<>();

        roleRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }



    @Override
    public Role findRoleById(long id)
    {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role id" + id + "not found!"));
    }

    @Override
    public Role findByName(String name)
    {
        Role rr = roleRepository.findByNameIgnoreCase(name);

        if (rr != null)
        {
            return rr;
        } else
        {
            throw new ResourceNotFoundException(name);
        }
    }

    @Transactional
    @Override
    public Role save(Role role)
    {
        if (role.getUsers()
        .size() > 0)
        {
            throw new ResourceNotFoundException("User Roles are not updated through Role, try users.");
        }

        return roleRepository.save(role);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteAll(){roleRepository.deleteAll();}

    @Transactional
    @Override
    public Role update(long id, Role role)
    {
        if (role.getName() == null)
        {
            throw new ResourceNotFoundException("No role name found to update!");
        }

        if (role.getUsers().size() > 0)
        {
            throw new ResourceNotFoundException("User roles are updated through the /users endpoint!");
        }

        Role newRole = findRoleById(id);

        roleRepository.updateRoleName(userAuditing.getCurrentAuditor()
        .get(), id, role.getName());
        return findRoleById(id);
    }
}
