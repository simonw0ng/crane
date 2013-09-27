package org.chitan.module.sys.controller;

import org.chitan.module.sys.entity.User;
import org.chitan.module.sys.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * <p/>
 * 真正登录的POST请求由Filter完成,
 *
 * @author CHENLEI
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "getUserCount", method = RequestMethod.GET)
    public String getUserCount(Model model) {
        int count = userManager.count();
        model.addAttribute("count", count);
        return "user/index";
    }

    @RequestMapping(value = "getUserBy/{id}", method = RequestMethod.GET)
    public String getUserBy(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userManager.selectOne(id));
        return "user/user";
    }

    @RequestMapping(value = "selectUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User selectUserById(@PathVariable("id") Long id, Model model) {
        return userManager.selectOne(id);
    }

    /**
     * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2
     * Preparable二次部分绑定的效果,先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
     * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("user", userManager.selectOne(id));
        }
    }

}