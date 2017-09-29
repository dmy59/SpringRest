package DmyDemo.SpringRest.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import DmyDemo.SpringRest.Entity.User;
import DmyDemo.SpringRest.Repository.UserRepository;

@Service
public class UserService {
    @Resource
    private UserRepository userDao;

    //保存数据
    @Transactional
    public boolean save(User user){
    	User userSaved = userDao.save(user);
    	if(userSaved==null) 
    		return false;
    	return true;
    }

    public boolean isExist(String account){
        return userDao.exists(account);
    }
    
    //查询单个数据
    public User getUser(String account){
        User user = userDao.findOne(account);
        return user;
    }
	
}
