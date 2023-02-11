/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbpositiongroupfunction;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface tbPositiongroupFunctionRepository extends JpaRepository<Tbpositiongroupfunction, String> {
    @Query("SELECT t FROM Tbpositiongroupfunction t WHERE t.tbpositiongroupfunctionPK.pgcode = :pgcode and t.isdelete = 0")
    public List<Tbpositiongroupfunction> getFunctionByPermision(@Param("pgcode") String pgcode);
    
    @Query("DELETE FROM Tbpositiongroupfunction t WHERE t.tbpositiongroupfunctionPK.pgcode = :pgcode and t.tbpositiongroupfunctionPK.functioncode = :functioncode")
    public void deletePermisionByIdPF(@Param("pgcode") String pgcode, @Param("functioncode") String functioncode);
    
    @Query("SELECT t FROM Tbpositiongroupfunction t WHERE t.tbpositiongroupfunctionPK.pgcode = :pgcode and t.tbpositiongroupfunctionPK.functioncode = :functioncode")
    public Tbpositiongroupfunction getTbpositiongroupfunctionByPermision(@Param("functioncode") String functioncode, @Param("pgcode") String pgcode);
}
