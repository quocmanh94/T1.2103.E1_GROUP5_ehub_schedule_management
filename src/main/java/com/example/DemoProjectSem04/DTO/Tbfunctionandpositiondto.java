/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.DTO;

import com.example.DemoProjectSem04.entities.Tbfunction;
import com.example.DemoProjectSem04.entities.Tbpositiongroup;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Tbfunctionandpositiondto {

    public List<Tbfunction> getListFunction() {
        return listFunction;
    }

    public void setListFunction(List<Tbfunction> listFunction) {
        this.listFunction = listFunction;
    }

    public List<Tbfunctiondto> getListTbfunctiondto() {
        return listTbfunctiondto;
    }

    public void setListTbfunctiondto(List<Tbfunctiondto> listTbfunctiondto) {
        this.listTbfunctiondto = listTbfunctiondto;
    }

    public List<Tbpositiongroup> getListTbpositiongroup() {
        return listTbpositiongroup;
    }

    public void setListTbpositiongroup(List<Tbpositiongroup> listTbpositiongroup) {
        this.listTbpositiongroup = listTbpositiongroup;
    }

    public Tbfunctionandpositiondto() {
    }
    public List<Tbfunction> listFunction;
    public List<Tbfunctiondto> listTbfunctiondto;
    public List<Tbpositiongroup> listTbpositiongroup;
}
