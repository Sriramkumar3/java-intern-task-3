package com.model;

public class Question {
private int id;
private String content;
private QuestionType type;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public QuestionType getType() {
	return type;
}
public void setType(QuestionType type) {
	this.type = type;
}

}
