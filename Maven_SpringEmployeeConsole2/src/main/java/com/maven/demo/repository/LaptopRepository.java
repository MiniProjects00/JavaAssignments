package com.maven.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maven.demo.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer>, CustomLaptopRepository {

}
