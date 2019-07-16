package ir.viratech.commons.tilegenerator;

public class RectF
{

	public RectF()
	{
		this.minX = Double.POSITIVE_INFINITY;
		this.minY = Double.POSITIVE_INFINITY;
		this.maxX = Double.NEGATIVE_INFINITY;
		this.maxY = Double.NEGATIVE_INFINITY;
	}

	public RectF(double x, int y)
	{
		this.minX = x;
		this.minY = y;
		this.maxX = x;
		this.maxY = y;
	}

	public RectF(double x1, double y1, double x2, double y2)
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
		this.minX = Double.POSITIVE_INFINITY;
		this.minY = Double.POSITIVE_INFINITY;
		this.maxX = Double.NEGATIVE_INFINITY;
		this.maxY = Double.NEGATIVE_INFINITY;
	}

	public void set(double x, int y)
	{
		this.minX = x;
		this.minY = y;
		this.maxX = x;
		this.maxY = y;
	}

	public void set(double x1, double y1, double x2, double y2)
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

	public void expandToPoint(PointF p)
	{
		this.minX = Math.min(this.minX, p.x);
		this.minY = Math.min(this.minY, p.y);
		this.maxX = Math.max(this.maxX, p.x);
		this.maxY = Math.max(this.maxY, p.y);
	}

	public double getMinX()
	{
		return this.minX;
	}

	public void setMinX(double minX)
	{
		this.minX = minX;
	}

	public double getMinY()
	{
		return this.minY;
	}

	public void setMinY(double minY)
	{
		this.minY = minY;
	}

	public double getMaxX()
	{
		return this.maxX;
	}

	public void setMaxX(double maxX)
	{
		this.maxX = maxX;
	}

	public double getMaxY()
	{
		return this.maxY;
	}

	public void setMaxY(double maxY)
	{
		this.maxY = maxY;
	}

	private double minX, minY, maxX, maxY;

}
