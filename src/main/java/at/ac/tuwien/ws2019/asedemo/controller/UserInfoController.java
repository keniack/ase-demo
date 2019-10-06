package at.ac.tuwien.ws2019.asedemo.controller;

import at.ac.tuwien.ws2019.asedemo.entity.UserInfo;
import at.ac.tuwien.ws2019.asedemo.exception.ASENotFoundException;
import at.ac.tuwien.ws2019.asedemo.model.UserDto;
import at.ac.tuwien.ws2019.asedemo.service.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/user"})
public class UserInfoController {

    private final UserInfoService userInfoService;

    private final ModelMapper modelMapper;

    public UserInfoController(UserInfoService userInfoService, ModelMapper modelMapper) {
        this.userInfoService = userInfoService;
        this.modelMapper=modelMapper;
    }

    @GetMapping
    public ResponseEntity<List> findAll(){
        List<UserInfo> users = userInfoService.findAll();
        if (users==null)
            return ResponseEntity.ok(Collections.emptyList());

       return ResponseEntity.ok(users.stream().map(u->modelMapper.map(u, UserDto.class)).collect(Collectors.toList()));
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<UserDto> findById(@PathVariable int id) throws ASENotFoundException {
        UserInfo u = userInfoService.get(new UserInfo(id));
        return ResponseEntity.ok().body(modelMapper.map(u, UserDto.class));
    }

    @PostMapping
    public ResponseEntity<UserDto>  create(@RequestBody UserDto user) throws ASENotFoundException{
        UserInfo userDB = modelMapper.map(user, UserInfo.class);
        return ResponseEntity.ok(modelMapper.map(userInfoService.save(userDB), UserDto.class));

    }

    @PutMapping(value="/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") int id,
                                          @RequestBody UserDto user) throws ASENotFoundException{
        UserInfo userDB = modelMapper.map(user, UserInfo.class);
        UserInfo u = userInfoService.update(id,userDB);
        return ResponseEntity.ok().body(modelMapper.map(u, UserDto.class));

    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") int id) throws ASENotFoundException{
        userInfoService.delete(new UserInfo(id));
        return ResponseEntity.ok().build();
    }

}
