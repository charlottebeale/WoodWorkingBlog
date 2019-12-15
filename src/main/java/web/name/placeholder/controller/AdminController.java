package web.name.placeholder.controller;

import web.name.placeholder.models.*;
import web.name.placeholder.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping()
    public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin){
        Iterable<Admin> list = service.findAll();
        for(Admin a : list) {
            if (a.getAdminName().equals(admin.getAdminName()))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.addAdmin(admin), HttpStatus.CREATED);
    }

    @GetMapping("{adminName}")
    public ResponseEntity<Admin> findByUsername(@PathVariable String adminName){
        return new ResponseEntity<>(service.findByAdminName(adminName), HttpStatus.OK);
    }

    @PutMapping("{adminName}")
    public ResponseEntity<Admin> updateUser(@PathVariable String adminName, @Valid @RequestBody Admin admin){
        return new ResponseEntity<>(service.updateAdmin(adminName, admin), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Admin>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteUser(@RequestParam String adminName){
        return new ResponseEntity<>(service.deleteByAdminName(adminName), HttpStatus.OK);
    }


}