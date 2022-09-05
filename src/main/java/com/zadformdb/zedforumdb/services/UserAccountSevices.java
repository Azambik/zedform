package com.zadformdb.zedforumdb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadformdb.zedforumdb.Models.UserAccount;
import com.zadformdb.zedforumdb.Models.UserAccountRequest;
import com.zadformdb.zedforumdb.Repositories.UserAccountRepository;

@Service
public class UserAccountSevices {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountSevices(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public Optional<UserAccount> findById(String id) {
        return userAccountRepository.findById(id);
    }

    public String save(UserAccountRequest request) {
        UserAccount userAcount = new UserAccount();
        userAcount.setFirstName(request.getFirstName());
        userAcount.setLastName(request.getLastName());
        userAcount.setEmail(request.getEmail());
        userAcount.setPassword(request.getPassword());
        userAcount.setPhoneNumber(request.getPhoneNumber());

        return userAccountRepository.save(userAcount)
                             .getId();
    }

    public void update(String id, UserAccountRequest request) {
        Optional<UserAccount> userAccount = findById(id);
        if (userAccount.isPresent()) {
            UserAccount forUpdate = userAccount.get();
            forUpdate.setFirstName(request.getFirstName());
            forUpdate.setLastName(request.getLastName());
            forUpdate.setEmail(request.getEmail());
            forUpdate.setPassword(request.getPassword());
            userAccountRepository.save(forUpdate);
        }
    }
    /*todo */

    /*  public void changePublishedFlag(String id, PostRequest request) {
        Optional<Post> post = findById(id);
        if (post.isPresent()) {
            Post p = post.get();
            p.setPublished(request.isPublished());
            postRepository.save(p);
        }
    } */

    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }

    public List<UserAccount> findByEmail(String email) {
        return userAccountRepository.findAllByEmailContaining(email);
    }

    public void delete(String id) {
        Optional<UserAccount> userAccount = findById(id);
        userAccount.ifPresent(userAccountRepository::delete);
    }
}