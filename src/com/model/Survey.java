package com.model;

import java.util.List;

public class Survey {
 private int id;
 private String title;
 private String description;
 private List<String> questions;
 
public Survey( String title, String description, List<String> questions) {
	this.title = title;
	this.description = description;
	this.questions = questions;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<String> getQuestions() {
	return questions;
}
public void setQuestions(List<String> questions) {
	this.questions = questions;
}

@Override
public String toString() {
    return "Survey{" +
            "title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", questions=" + questions +
            '}';
}
 
}
