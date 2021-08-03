package com.example.crudsteels.services;

import com.example.crudsteels.exceptions.ResourceNotFoundException;
import com.example.crudsteels.models.Role;
import com.example.crudsteels.models.User;
import com.example.crudsteels.models.UserRoles;
import com.example.crudsteels.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userrepos;

    @Autowired
    RoleService roleService;

    @Autowired
    private HelperFunctions helperFunctions;

    @Override
    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    public User findUserById(long id) throws
            ResourceNotFoundException
    {
        return userrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
    }

    @Override
    public User findByName(String name)
    {
        User uu = userrepos.findByUsername(name.toLowerCase());
        if (uu == null)
        {
            throw new ResourceNotFoundException(name.toLowerCase());
        }
        return uu;
    }

    @Transactional
    @Override
    public User save(User user)
    {
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userrepos.findById(user.getUserid())
                    .orElseThrow(() -> new ResourceNotFoundException("User at ID " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setUsername(user.getUsername().toLowerCase());
        newUser.setPasswordNoEncrypt(user.getPassword());
        newUser.setUseremail(user.getUseremail().toLowerCase());

        newUser.getRoles().clear();
        for (UserRoles ur : user.getRoles())
        {
            Role addRole = roleService.findRoleById(ur.getRole()
                    .getRoleid());
            newUser.getRoles()
                    .add(new UserRoles(newUser, addRole));
        }


        return userrepos.save(newUser);
    }

    @Transactional
    @Override
    public User update(User user, long id)
    {
        User currentUser = findUserById(id);

        if (helperFunctions.isAuthorizedToMakeChange(currentUser.getUsername()))
        {
            if (user.getUsername() != null)
            {
                currentUser.setUsername(user.getUsername().toLowerCase());
            }

            if (user.getPassword() != null)
            {
                currentUser.setPasswordNoEncrypt(user.getPassword());
            }

            if (user.getUseremail() != null)
            {
                currentUser.setUseremail(user.getUseremail().toLowerCase());
            }

            if (user.getRoles()
                    .size() > 0)
            {
                currentUser.getRoles()
                        .clear();
                for (UserRoles ur : user.getRoles())
                {
                    Role addRole = roleService.findRoleById(ur.getRole()
                            .getRoleid());

                    currentUser.getRoles()
                            .add(new UserRoles(currentUser,
                                    addRole));
                }
            }

            return userrepos.save(currentUser);
        } else
        {
            throw new ResourceNotFoundException("This user is not authorized to make this change!");
        }
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        userrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User at ID " + id + " not found!"));
        userrepos.deleteById(id);
    }
}


// Elijah