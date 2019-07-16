package ir.viratech.commons.tilegenerator;

public class RectI
{

	public RectI()
	{
		this.minX = Integer.MAX_VALUE;
		this.minY = Integer.MAX_VALUE;
		this.maxX = Integer.MIN_VALUE;
		this.maxY = Integer.MIN_VALUE;
	}

	public RectI(int x, int y)
	{
		this.minX = x;
		this.minY = y;
		this.maxX = x;
		this.maxY = y;
	}

	public RectI(int x1, int y1, int x2, int y2)
	{
		if (x1 < x2)
		{
			this.minX = x1;
			this.maxX = x2;
		}
		else
		{
			this.minX = x2;
			this.maxX = x1;
		}
		if (y1 < y2)
		{
			this.minY = y1;
			this.maxY = y2;
		}
		else
		{
			this.minY = y2;
			this.maxY = y1;
		}
	}

	public void reset()
	{
		this.minX = Integer.MAX_VALUE;
		this.minY = Integer.MAX_VALUE;
		this.maxX = Integer.MIN_VALUE;
		this.maxY = Integer.MIN_VALUE;
	}

	public void set(int x1, int y1, int x2, int y2)
	{
		if (x1 < x2)
		{
			this.minX = x1;
			this.maxX = x2;
		}
		else
		{
			this.minX = x2;
			this.maxX = x1;
		}
		if (y1 < y2)
		{
			this.minY = y1;
			this.maxY = y2;
		}
		else
		{
			this.minY = y2;
			this.maxY = y1;
		}
	}

	public void expandToPoint(PointI p)
	{
		this.minX = Math.min(this.minX, p.x);
		this.minY = Math.min(this.minY, p.y);
		this.maxX = Math.max(this.maxX, p.x);
		this.maxY = Math.max(this.maxY, p.y);
	}

	public int getMinX()
	{
		return this.minX;
	}

	public void setMinX(int minX)
	{
		this.minX = minX;
	}

	public int getMinY()
	{
		return this.minY;
	}

	public void setMinY(int minY)
	{
		this.minY = minY;
	}

	public int getMaxX()
	{
		return this.maxX;
	}

	public void setMaxX(int maxX)
	{
		this.maxX = maxX;
	}

	public int getMaxY()
	{
		return this.maxY;
	}

	public void setMaxY(int maxY)
	{
		this.maxY = maxY;
	}

	private int minX, minY, maxX, maxY;

}
