package com.familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String countryBirth;
    private String placeBirth;
    private Long id;
    private Human mother;
    private Human father;
    private Human spouse;
    private List <Human> children;

    public Human (String name, String surname, Gender gender, LocalDate birthDate,
                  LocalDate deathDate, String countryBirth, String placeBirth,
                  String profession, Human mother, Human father){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.countryBirth = countryBirth;
        this.placeBirth = placeBirth;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSurname (String surname){
        this.surname =  surname;
    }
    public String getSurname() {
        return surname;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender() {
        return gender;
    }

    public int getLifespan() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        Period lifespan = Period.between(birthDate, endDate);
        return lifespan.getYears();
    }

    public void setCountryBirth(String countryBirth) {
        this.countryBirth = countryBirth;
    }

    public String getCountryBirth() {
        return countryBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    public String getPlaceBirth() {
        return placeBirth;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", countryBirth='" + countryBirth + '\'' +
                ", placeBirth='" + placeBirth + '\'' +
                ", mother=" + (mother != null ? mother.getName() : "null") +
                ", father=" + (father != null ? father.getName() : "null") +
                ", spouse=" + (spouse != null ? spouse.getName() : "null") +
                ", children=" + getChildrenInfo() +
                '}';
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", фамилия: ");
        sb.append(surname);
        sb.append(", страна рождения: ");
        sb.append(countryBirth);
        sb.append(" место рождения: ");
        sb.append(placeBirth);
        sb.append(", пол: ");
        sb.append(gender);
        sb.append(", возраст: ");
        sb.append(getLifespan());
        sb.append(", супруг(а): ");
        sb.append(spouse != null ? spouse.getName() : "null");
        sb.append(", мать: ");
        sb.append(mother != null ? mother.getName() : "null");
        sb.append(", отец: ");
        sb.append(father != null ? father.getName() : "null");
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() > 0){
            res.append((children.get(0).getName()));
            for (int i = 1; i < children.size(); i++){
                res.append((", "));
                res.append((children.get(i).getName()));
            }
        }
        else {
            res.append("нет");
        }
        return res.toString();
    }
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}











