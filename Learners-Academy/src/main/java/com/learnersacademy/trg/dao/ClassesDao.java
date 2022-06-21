package com.learnersacademy.trg.dao;

import com.learnersacademy.trg.dto.Classes;

public interface ClassesDao {
 public Integer addClasses(Classes classes);

public boolean validClass(String classof);

}
