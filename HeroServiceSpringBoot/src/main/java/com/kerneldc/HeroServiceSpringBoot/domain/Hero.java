package com.kerneldc.HeroServiceSpringBoot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HERO")
public class Hero extends AbstractPersistableEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator="heroSequenceGenerator")
	@SequenceGenerator(name="heroSequenceGenerator",  sequenceName ="HERO_SEQ", allocationSize=1)
    //@JsonProperty
	private Long id;

	@Column(name = "NAME", unique=true)
	//@JsonProperty
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (id == null || obj == null || getClass() != obj.getClass())
            return false;
        Hero that = (Hero) obj;
        return id.equals(that.id);
    }
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
