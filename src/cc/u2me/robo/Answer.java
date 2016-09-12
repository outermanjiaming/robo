package cc.u2me.robo;

public class Answer implements Cell {
	String question;
	String answer;
	public Answer(){
		
	}
	public Answer(String q, String a){
		this.question = q;
		this.answer = a;
	}

	@Override
	public String deal(Context ctx) {
		String input = ctx.getInput();
		if(identity().equals(input)) {
			return answer;
		}
		return null;
	}

	@Override
	public String identity() {
		return question;
	}

}
