package com.kgisl.repository;

import com.kgisl.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProjectRepository
 */
public interface ProjectRepository extends JpaRepository<Project,Long>{

    
}