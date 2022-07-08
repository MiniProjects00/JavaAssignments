package com.maven.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maven.demo.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>,  CustomProjectRepository {


}
