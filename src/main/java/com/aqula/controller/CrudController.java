package com.aqula.controller;

import com.aqula.model.EntryMainPage;
import com.aqula.model.JsonObject;
import com.aqula.model.Role;
import com.aqula.model.User;
import com.aqula.service.EntryServiceImpl;
import com.aqula.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class CrudController {
    @Autowired
    private UserService service;

    @Autowired
    private EntryServiceImpl entryService;

    @GetMapping("/admin/add")
    public ResponseEntity<JsonObject> getRoles() {

        JsonObject jsonObject = new JsonObject();
        jsonObject.setAllRoles(service.getAllRole());

        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);
    }

    @PostMapping("/user/requestById")
    public ResponseEntity<JsonObject> getUserById(@RequestBody User user) {
        Long id = user.getId();
        User userById = service.getUserById(id);
        List<Role> allRoles = service.getAllRole();
        JsonObject jsonObject = new JsonObject();
        jsonObject.setUser(userById);
        jsonObject.setAllRoles(allRoles);

        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);
    }

    @PostMapping("/entry/requestById")
    public ResponseEntity<JsonObject> getEntryById(@RequestBody EntryMainPage entry) {
        Long id = entry.getId();
        EntryMainPage entryById = entryService.getEntryById(id);

        JsonObject jsonObject = new JsonObject();
        jsonObject.setEntry(entryById);
        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);
    }

    @PostMapping("/entry/updateEntry")
    public String updateUser(@RequestBody EntryMainPage entry) {
        entryService.edit(entry);
        return "update";
    }



    @PostMapping("/admin/delete")
    public String deleteUser(@RequestBody User user) {
        Long id = user.getId();
        System.out.println(id);
        User userDeleted = service.getUserById(id);
        service.delete(userDeleted);
        return  "delete";
    }

    @PostMapping("/admin/add")
    public String addUser(@RequestBody User user) {
        String[] roles = new String[user.getRoles().size()];
        for (int i = 0 ; i < user.getRoles().size(); i++) {
            roles[i] = user.getRoles().get(i).getName();
        }
        service.add(user, roles);
        return  "add";
    }

    @PostMapping("/admin/updateUser")
    public String updateUser(@RequestBody User user) {
        System.out.println(user.getRoles());
        String[] roles = new String[user.getRoles().size()];
        for (int i = 0 ; i < user.getRoles().size(); i++) {
            roles[i] = user.getRoles().get(i).getName();
        }
        service.edit(user, roles);
        return "update";
    }

    @PostMapping("/user/checkEmail")
    public ResponseEntity<JsonObject> checkEmail(@RequestBody User user) {
//        Long id = user.getId();
        String email = user.getEmail();
//        User userById = service.getUserById(id);
        boolean unicEmail;
        if (!service.unicEmail(email)) {
            unicEmail = false;
        } else { unicEmail = true; }

        JsonObject jsonObject = new JsonObject();
        jsonObject.setUnicEmail(unicEmail);

        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);
    }



}

