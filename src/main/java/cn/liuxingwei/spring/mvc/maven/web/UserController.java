package cn.liuxingwei.spring.mvc.maven.web;

import cn.liuxingwei.spring.mvc.maven.entity.User;
import cn.liuxingwei.spring.mvc.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(){
        User user = new User("zhangsan");
//        user.setUserId(2);
        userService.addUser(user);
        return "user/add";
    }

    @RequestMapping(value="/get", method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "userid", defaultValue = "1") long userid) {
        User user = userService.getUser(userid);
        System.out.println();
        return "user/add";
    }
}
