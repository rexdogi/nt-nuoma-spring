package com.nt.app.controllers.dashboard;

import com.nt.app.persistence.jpadao.UserRepository;
import com.nt.app.persistence.model.AttachRoleWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

   /* @PostMapping("/attach_role")
    public String attachRole(@RequestBody Map<String, String> json) {
        System.out.println(json.get("user_id"));
        return "";
    }*/

    @PostMapping("/attach_role")
    public long attachRole(@RequestBody AttachRoleWrapper attachRoleWrapper) {
        System.out.println(attachRoleWrapper.getRoleIds().get(0));
        return 1;
    }
}
