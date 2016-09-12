package cc.u2me.robo;

import java.util.ArrayList;
import java.util.List;

public class Context {
String input;
String output;
Cell question;
Cell answer;
List<Cell> brain = new ArrayList<Cell>();
List<Cell> temp = new ArrayList<Cell>();
public Context(){
	
}

public String deal(Object obj){
	if(obj instanceof String) {
		String line = (String) obj;
		this.setInput(line);
		if(this.getQuestion() != null) {
			Cell newone = new Answer(this.getQuestion().identity(), this.getInput());
			this.newCell(newone);
			this.setQuestion(null);
			return (">" + "Roger that.");
		} else {
			String output = null;
			for(Cell e : this.getBrain()) {
				output = this.deal(e);
				if(output != null){
					break;
				}
			}
			
			if(output != null) {
				return (">" + output);
			} else {
				return (">I don't understand, teach me or question me first.");
			}
		}
	} else {
		Cell e = (Cell) obj;
		return e.deal(this);
	}
}
public String getInput() {
	return input;
}
public void setInput(String input) {
	this.input = input;
}

public String getOutput() {
	return output;
}
public void setOutput(String output) {
	this.output = output;
}

public Cell getQuestion() {
	return question;
}
public void setQuestion(Cell question) {
	this.question = question;
}
public Cell getAnswer() {
	return answer;
}
public void setAnswer(Cell answer) {
	this.answer = answer;
}
public List<Cell> getBrain() {
	return brain;
}
public void setBrain(List<Cell> brain) {
	this.brain = brain;
}
public Context newCell(Cell newone) {
	this.temp.add(newone);
	return this;
}
public void growUp() {
	this.brain.addAll(this.temp);
	this.temp = new ArrayList<Cell>();
}
}
