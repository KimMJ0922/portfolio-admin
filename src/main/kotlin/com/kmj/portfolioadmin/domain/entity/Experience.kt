package com.kmj.portfolioadmin.domain.entity

import jakarta.persistence.*

@Entity
class Experience(
    title: String,
    description: String,
    startYear: Int,
    endYear: Int?,
    startMonth: Int,
    endMonth: Int?,
    isActive: Boolean
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null

    var title: String = title

    var description: String = description

    var startYear: Int = startYear

    var endYear: Int? = endYear

    var startMonth: Int = startMonth

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    @OneToMany(targetEntity = ExperienceDetail::class
        , fetch = FetchType.LAZY
        , cascade = [CascadeType.ALL])
    @JoinColumn(name = "experience_id")
    var details: MutableList<ExperienceDetail> = mutableListOf()

    fun getEndYearMonth(): String{
        if(endYear == null || endMonth == null){
            return "Present"
        }

        return "${endYear}.${endMonth}" // 2020.01
    }

    fun update(
        title: String,
        description: String,
        startYear: Int,
        endYear: Int,
        startMonth: Int,
        endMonth: Int,
        isActive: Boolean
    ){
        this.title = title
        this.description = description
        this.startYear = startYear
        this.endYear = endYear
        this.startMonth = startMonth
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(detail: MutableList<ExperienceDetail>){
        if(detail != null){
            this.details.addAll(detail)
        }
    }
}