package com.kmj.portfolioadmin.domain.entity

import jakarta.persistence.*

@Entity
class Project(
    name: String,
    description: String,
    startYear: Int,
    endYear: Int?,
    startMonth: Int,
    endMonth: Int?,
    isActive: Boolean
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    var id: Long? = null

    var name: String = name

    var description: String? = description

    var startYear: Int? = startYear

    var endYear: Int? = endYear

    var startMonth: Int? = startMonth

    var endMonth: Int? = endMonth

    var isActive: Boolean? = isActive

    @OneToMany(targetEntity = ProjectDetail::class
        , fetch = FetchType.LAZY
        , cascade = [CascadeType.ALL])
    var details: MutableList<ProjectDetail> = mutableListOf()

    @OneToMany(targetEntity = ProjectSkill::class
        , mappedBy = "project"
        , fetch = FetchType.LAZY
        , cascade = [CascadeType.ALL])
    var skills: MutableList<ProjectSkill> = mutableListOf()

    fun getEndYearMonth(): String{
        if(endYear == null || endMonth == null){
            return "Present"
        }

        return "${endYear}.${endMonth}" // 2020.01
    }

    fun update(
        name: String,
        description: String,
        startYear: Int,
        endYear: Int,
        startMonth: Int,
        endMonth: Int,
        isActive: Boolean
    ){
        this.name = name
        this.description = description
        this.startYear = startYear
        this.endYear = endYear
        this.startMonth = startMonth
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(detail: MutableList<ProjectDetail>){
        if(detail != null){
            this.details.addAll(detail)
        }
    }

    fun addSkills(skills: MutableList<ProjectSkill>){
        if(skills != null){
            this.skills.addAll(skills)
        }
    }
}