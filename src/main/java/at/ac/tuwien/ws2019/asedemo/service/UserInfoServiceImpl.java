package at.ac.tuwien.ws2019.asedemo.service;

import at.ac.tuwien.ws2019.asedemo.entity.UserInfo;
import at.ac.tuwien.ws2019.asedemo.exception.ASENotFoundException;
import at.ac.tuwien.ws2019.asedemo.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    private final ModelMapper modelMapper;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository,ModelMapper modelMapper) {
        this.userInfoRepository = userInfoRepository;
        this.modelMapper=modelMapper;
    }

    public UserInfo createUpdate(UserInfo user){
        return userInfoRepository.save(user);
    }

    @Override
    public void delete(UserInfo user) throws ASENotFoundException{
        UserInfo u = get(user);
        userInfoRepository.delete(u);
    }

    @Override
    public UserInfo save(UserInfo user) throws ASENotFoundException{
        if (user==null) return null;

        if (user.getAddresses()!=null)
            user.getAddresses().stream().forEach(a -> a.setUserInfo(user));

        UserInfo u = userInfoRepository.save(user);
        return u;
    }

    @Override
    public UserInfo update(Integer id, UserInfo user) throws ASENotFoundException{

        UserInfo record = get(new UserInfo(id));

        record.setFirstName(user.getFirstName());
        record.setLastName(user.getLastName());
        record.setAddresses(user.getAddresses());

        if (record.getAddresses()!=null)
            record.getAddresses().stream().forEach(a -> a.setUserInfo(record));

        return userInfoRepository.save(record);
    }



    @Override
    public UserInfo get(UserInfo user) throws ASENotFoundException{
        if (user==null) throw new ASENotFoundException();
        return userInfoRepository.findById(user.getId()).orElseThrow(ASENotFoundException::new);
    }

    @Override
    public List findAll() {
        return userInfoRepository.findAll();
    }
}
