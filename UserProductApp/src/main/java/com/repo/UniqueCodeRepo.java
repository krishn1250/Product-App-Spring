package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Userhashdata;

public interface UniqueCodeRepo extends JpaRepository<Userhashdata, Integer> {
Userhashdata findByUserhashcode(int hashcode);
}
