package com.demo.example.iratechnology.usersmanagement.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.demo.example.iratechnology.repository.RoleRepository;
import com.demo.example.iratechnology.repository.UserRepository;
import com.demo.example.iratechnology.usersmanagement.dto.TaskDto;
import com.demo.example.iratechnology.usersmanagement.dto.UserDto;
import com.demo.example.iratechnology.usersmanagement.entity.RoleEntity;
import com.demo.example.iratechnology.usersmanagement.entity.UserEntity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

   

    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
            RoleRepository roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserEntity findUserByfname(String userName) {
        return userRepository.findByfname(userName);
    }

    public UserEntity saveUser(UserEntity user) {
        user.setPswd(bCryptPasswordEncoder.encode(user.getPswd()));
        user.setActive(true);
        RoleEntity userRole = roleRepository.findByRole("Manager");
        user.setRoles(new HashSet<RoleEntity>(Arrays.asList(userRole)));
        return userRepository.save(user);
    } 

    @Override
    public List<UserDto> getAllUsers() {
        ArrayList<UserDto> users = new ArrayList<UserDto>();
        userRepository.findAll().forEach(user -> users.add(mappingToDto(user)));
        return users;

    }

    @Override
    public UserDto registration(UserDto request) {
        if ((request.getFname() != null) && !(request.getFname().equals("")) && (request.getLname() != null)
                && !(request.getLname().equals("")) && (request.getPswd() != null) && !(request.getPswd().equals(""))) {

            UserEntity userEntity = userRepository.save(mappingToEntity(request));
            // request.getId();
            return mappingToDto(userEntity);
        }
        return null;
    }

    @Override
    public UserDto Update(UserDto request) {
        Optional<UserEntity> userData = userRepository.findById(request.getId());
        if (userData.isPresent()) {
            UserEntity userEntity = userData.get();
            if (request.getFname() != null)
                userEntity.setFname(request.getFname());
            if (request.getLname() != null)
                userEntity.setLname(request.getLname());
            if (request.getEmail() != null)
                userEntity.setEmail(request.getEmail());
            if (request.getPswd() != null)
                userEntity.setPswd(request.getPswd());
            if (request.getEmployeecode() != null)
                userEntity.setEmployeecode(request.getEmployeecode());
            if (request.getUserrole() != null)
                userEntity.setUserrole(request.getUserrole());

            // if(request.getActive() != null)
            // userEntity.setActive(active.getActive());

            userEntity = userRepository.save(userEntity);
            return mappingToDto(userEntity);
        }

        return null;
    }

    public boolean checkCodeandUserExists(UserDto request) {
        List<String> accesscodes = ckcode();
        boolean check = false;
        try {

            if (accesscodes.contains(request.getCreationcode())) {
                // check= true;
                UserEntity userEntity = userRepository.findByEmail(request.getEmail());
                if (userEntity == null) {
                    check = true;
                    // UserDto savedUserDto = saveUser(request);
                }

                else
                    check = false;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    private List<String> ckcode() {

        List<String> accesscode = new ArrayList<String>();
        // Instantiating list using Collections.addAll()
        Collections.addAll(accesscode, "187675", "186564", "185453", "184342");
        return accesscode;
    }

    public void setEmpId(UserDto response) {
        long temp = response.getId();
        List<String> accesscodes = ckcode();
        if (accesscodes.contains(response.getCreationcode())) {
            String eid = "MNGR" + temp;
            response.setEmployeecode(eid);
            response.setUserrole("Manager");
            Update(response);
        } else {

            String code = (response.getCreationcode());// .toString();
            if (code.startsWith("MNGR")) {
                String numcode = code.substring(4);
                long l = Long.parseLong(numcode);
                UserEntity tempmanag = userRepository.getById(l);

                if ((tempmanag.getUserrole()).startsWith("Manager")) {
                    String eid = "WRKR" + temp;
                    response.setEmployeecode(eid);
                    response.setUserrole("Worker");
                    Update(response);
                    // }else{

                }
            }

        }
    }

    private UserEntity mappingToEntity(UserDto userDto) {
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        return userEntity;
    }

    // Convert Entity into Dto
    private UserDto mappingToDto(UserEntity userEntity) {
        UserDto userDto = mapper.map(userEntity, UserDto.class);
        return userDto;

    }

    public boolean checkUserHasSamePswd(TaskDto request) {

        boolean check = false;
        try {

            String temp = request.getCreatorid();
            UserEntity tempemp = userRepository.findByEmployeecode(temp);

            if (tempemp != null) {
                String pass = tempemp.getPswd();
                String gpass = request.getCreatorpswd();

                pass.equals(gpass);
                check = true;
            }

            else {
                check = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean checkManagerCodeExists(UserDto userDto) {

        boolean check = false;
        try {
            String mgrid = userDto.getCreationcode();
            UserEntity temp = userRepository.findByEmployeecode(mgrid);
            if (temp != null) {
                check = true;
                return check;
            }

            return check;
        }

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    //

}
