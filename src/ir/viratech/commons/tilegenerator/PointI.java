package ir.viratech.commons.tilegenerator;

public class PointI
{

	public PointI()
	{
	}

	public PointI(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void set(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void set(PointI p)
	{
		this.x = p.x;
		this.y = p.y;
	}

	public PointI cloneI()
	{
		return new PointI(this.x, this.y);
	}

	public PointF cloneF()
	{
		return new PointF(this.x, this.y);
	}

	@Override
	public String toString()
	{
		return String.format("PointI(" + this.x + ", " + this.y + ")");
	}

	public int x, y;

}
