package ir.viratech.commons.tilegenerator;

public class PointF
{

	public PointF()
	{
	}

	public PointF(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void set(PointF p)
	{
		this.x = p.x;
		this.y = p.y;
	}

	public void set(PointI p)
	{
		this.x = p.x;
		this.y = p.y;
	}

	public PointF cloneF()
	{
		return new PointF(this.x, this.y);
	}

	@Override
	public String toString()
	{
		return String.format("PointF(" + this.x + ", " + this.y + ")");
	}

	public double x, y;

}
