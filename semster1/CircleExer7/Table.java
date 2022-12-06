package CircleExer7;

public class Table {

	private double Width;
	private double Length;
	
	public Table(double w, double l) {
		this.Width = w;
		this.Length = l;
	}
	public Table(Table t) {
		this.Width = t.Width;
		this.Length = t.Length;
	}
	
	public double getWidth() {
		return this.Width;
	}
	public double getLength() {
		return this.Length;
	}
	
	public void setWidth(double w) {
		this.Width = w;
	}

	public void setLength(double l) {
		this.Length = l;
	}
	
	@Override
	public String toString() {
		return "Table [Width=" + Width + ", Length=" + Length + "]";
	}

}
