package DmyDemo.SpringRest.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DmyDemo.SpringRest.Entity.User;
import DmyDemo.SpringRest.Service.UserService;


@RestController  
@RequestMapping(value = "/user") 
public class UserController {
    @Resource
    private UserService userService;
    
    @RequestMapping  
    public String index() {  
        return "Hello!";  
    }
    
    @RequestMapping(value = "/login/{account}/{password}")
	public Map<String, Object> login(@PathVariable String account, @PathVariable String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!userService.isExist(account)) {
            map.put("success", false);
            map.put("message", "用户名不存在");
            return map;
        }
        User user = userService.getUser(account);
        if (!user.getPassword().equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
	}
    
    @RequestMapping(value = "/register/{account}/{password}")
    public Map<String, Object> register(@PathVariable String account, @PathVariable String password) {
    	Map<String, Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setUsername(account);
		user.setPassword(password);
		boolean result = userService.save(user);
        if(result) {
            map.put("success", true);
            map.put("message", "注册成功");
            return map;
        }
        map.put("success", false);
        map.put("message", "注册失败");
        return map;
    }
}
