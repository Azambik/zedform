package com.zadformdb.zedforumdb.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zadformdb.zedforumdb.Models.UserAccount;
import com.zadformdb.zedforumdb.Models.UserAccountRequest;
import com.zadformdb.zedforumdb.services.UserAccountSevices;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/userAccount")
public class UserAccountController {
    
    private final UserAccountSevices userAccountServices;

    @Autowired
    public UserAccountController(UserAccountSevices userAccountSevices){
        this.userAccountServices = userAccountSevices;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserAccount> post(@PathVariable String id) {
        Optional<UserAccount> userAccount = userAccountServices.findById(id);
        return userAccount.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
    }
    
     @GetMapping
    public List<UserAccount> list(@RequestParam(required = false) String email) {
        if (email.isEmpty()) {
            return userAccountServices.getAll();
        }
        return userAccountServices.findByEmail(email);
    }
     
    @PostMapping
    public String save(@RequestBody UserAccountRequest request) {
        return userAccountServices.save(request);
    }

    /*@PutMapping("{id}/publish")
    public void publishUnpublish(@PathVariable String id, @RequestBody PostRequest request) {
        postService.changePublishedFlag(id, request);
    }*/

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody UserAccountRequest request) {
        Optional<UserAccount> userAccount = userAccountServices.findById(id);
        if (userAccount.isPresent()) {
            userAccountServices.update(id, request);
        } else {
            userAccountServices.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        userAccountServices.delete(id);
    }
     

}
