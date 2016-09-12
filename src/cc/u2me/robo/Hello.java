package cc.u2me.robo;

public class Hello implements Cell {

	@Override
	public String deal(Context ctx) {
		if("hello".equals(ctx.getInput())) {
			ctx.setOutput("hello");
			return "hello";
		}
		return null;
	}

	@Override
	public String identity() {
		return "hello";
	}

}
