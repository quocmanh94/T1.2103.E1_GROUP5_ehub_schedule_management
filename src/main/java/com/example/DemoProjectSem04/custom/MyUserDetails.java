/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.custom;

import com.example.DemoProjectSem04.entities.Tbfunction;
import com.example.DemoProjectSem04.entities.Tbpositiongroup;
import com.example.DemoProjectSem04.entities.Tbpositiongroupfunction;
import com.example.DemoProjectSem04.entities.Tbuser;
import com.example.DemoProjectSem04.repositories.TbpositiongroupRepository;
import com.example.DemoProjectSem04.repositories.tbPositiongroupFunctionRepository;
import com.example.DemoProjectSem04.repositories.tbUserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Admin
 */
public class MyUserDetails implements UserDetails {

    @Autowired
    tbPositiongroupFunctionRepository positiongroupFunctionRepository;

    @Autowired
    tbUserRepository userRepository;

    private Tbuser tbuser;
    private List<Tbpositiongroupfunction> tbpositiongroupfunctionList;

    public MyUserDetails(Tbuser tbuser, List<Tbpositiongroupfunction> tbpositiongroupfunctionList) {
        this.tbuser = tbuser;
        this.tbpositiongroupfunctionList = tbpositiongroupfunctionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<Tbpositiongroupfunction> tbpositiongroupfunctionList = tbuser.getPermision().getTbpositiongroupfunctionList();
        String permision = tbuser.getPermision().getPgcode().toString();

        List<GrantedAuthority> gantList = new ArrayList<>();
//        GrantedAuthority authority = new SimpleGrantedAuthority(permision);

        gantList.add(new SimpleGrantedAuthority(permision));
        for (Tbpositiongroupfunction item : tbpositiongroupfunctionList) {
            gantList.add(new SimpleGrantedAuthority(item.getTbfunction().getFunctioncode()));
        }

        return gantList;
    }

    @Override
    public String getPassword() {
        return tbuser.getPassword();
    }

    @Override
    public String getUsername() {
        return tbuser.getUseremail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return tbuser.getEnabled();
    }

}
