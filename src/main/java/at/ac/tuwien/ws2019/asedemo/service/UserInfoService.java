package at.ac.tuwien.ws2019.asedemo.service;

import at.ac.tuwien.ws2019.asedemo.entity.UserInfo;
import at.ac.tuwien.ws2019.asedemo.exception.ASENotFoundException;

import java.util.List;

public interface UserInfoService {

    List findAll();
    UserInfo get(UserInfo user) throws ASENotFoundException;
    void delete(UserInfo user) throws ASENotFoundException;
    UserInfo save(UserInfo user) throws ASENotFoundException;
    UserInfo update(Integer id, UserInfo user) throws ASENotFoundException;

}
