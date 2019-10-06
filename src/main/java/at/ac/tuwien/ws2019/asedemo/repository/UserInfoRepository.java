package at.ac.tuwien.ws2019.asedemo.repository;

import at.ac.tuwien.ws2019.asedemo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
}
