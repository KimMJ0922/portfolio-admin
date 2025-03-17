package com.kmj.portfolioadmin.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill(
    project: Project,
    skill: Skill
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    var project: Project = project

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    var skill: Skill = skill


    
}