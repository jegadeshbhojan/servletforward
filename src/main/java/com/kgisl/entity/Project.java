package com.kgisl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Project
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectid;
    private String projectname;

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teamid", updatable = false, insertable = true)
    private Team team;

    /**
     * @return the projectid
     */
    public Long getProjectid() {
        return projectid;
    }
    /**
     * @param projectid the projectid to set
     */
    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }
    /**
     * @return the projectname
     */
    public String getProjectname() {
        return projectname;
    }
    /**
     * @param projectname the projectname to set
     */
    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
    /**
     * @return the team
     */
    public Team getTeam() {
        return team;
    }
    /**
     * @param team the team to set
     */
    public void setTeam(Team team) {
        this.team = team;
    }
}