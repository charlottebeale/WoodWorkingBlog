package web.name.placeholder.service;

import web.name.placeholder.models.Admin;
import web.name.placeholder.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public Admin addAdmin(Admin admin){ return repository.save(admin);}

    public Admin findByAdminName(String adminName){
        return repository.findByAdminName(adminName);
    }

    public Admin updateAdmin(String adminName, Admin admin){
        Admin ogAdmin = findByAdminName(adminName);
        if(admin.getFirstName() != null) ogAdmin.setFirstName(admin.getFirstName());

        if(admin.getLastName() != null) ogAdmin.setLastName(admin.getLastName());

        if(admin.getPassword() != null) ogAdmin.setPassword(admin.getPassword());

        if(admin.getEmailAddress() != null) ogAdmin.setEmailAddress(admin.getEmailAddress());

        return  repository.save(admin);
    }

    public Iterable<Admin> findAll(){
        return repository.findAll();
    }

    public Boolean deleteByAdminName(String adminName){
        Iterable<Admin> list = findAll();
        for(Admin admin : list)
            if(admin.getAdminName().equals(adminName)){
                repository.delete(admin);
                return true;
            }
        return false;
    }
}