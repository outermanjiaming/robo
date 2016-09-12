package cc.u2me.robo;

public class Learn implements Cell {
	Context ctx;
	
	public Learn(){
	}
	

	@Override
	public String deal(Context ctx) {
		this.ctx = ctx;
		if(ctx.getInput().indexOf(identity()) == 0) {
			String learn = ctx.getInput().substring(identity().length() + 1);
			String[] info = learn.split("is");
			if(info.length != 2) {
				return "wrong structure of learn(eg.learn name is lijiaming)";
			}
			String question = info[0].trim();
			String answer = info[1].trim();
			Answer newone = new Answer(question, answer);
			ctx.newCell(newone);
			ctx.setAnswer(newone);
			return "Roger that." + "when you ask me '"+question+"'  I give you the answer '"+answer+"'";
		}
		return null;
	}

	@Override
	public String identity() {
		return "learn";
	}

}
