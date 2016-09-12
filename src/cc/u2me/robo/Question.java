package cc.u2me.robo;

public class Question implements Cell {

	String question;
	public Question(){
		this.question = "question";
	}
	public Question(String q) {
		this.question = q;
	}
	
	@Override
	public String deal(Context ctx) {
		if(ctx.getInput().indexOf(identity()) == 0) {
			String question = ctx.getInput().substring(identity().length() + 1);
			if(question != null && question.length() > 1){
				//find answer cell to answer it
				for(Cell e : ctx.getBrain()) {
					if(question.equals(e.identity())){
						ctx.setInput(question);
						return e.deal(ctx);
					}
				}
				Cell newone =  new Question(question);
				ctx.setQuestion(newone);
				return "I don't know, You tell me.";
			}
			return "wrong format(question THE_QUESTION)";
		}
		return null;
	}

	@Override
	public String identity() {
		return question;
	}

}
