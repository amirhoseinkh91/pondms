package ir.viratech.commons.tilegenerator;

public class Doubles2D
{

	public double get(int x, int y)
	{
		return this.cache[this.getIndex(x, y)];
	}

	public void set(int x, int y, double value)
	{
		this.cache[this.getIndex(x, y)] = value;
	}

	private int getIndex(int x, int y)
	{
		x -= this.x;
		y -= this.y;
		int i = y * this.w + x;
		if (i >= this.size)
		{
			throw new IndexOutOfBoundsException();
		}
		return i;
	}

	public void setData(double[] cache, int x, int y, int w, int h)
	{
		this.cache = cache;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.size = w * h;
	}

	public double[] getCache()
	{
		return this.cache;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public int getW()
	{
		return this.w;
	}

	public int getH()
	{
		return this.h;
	}

	private int x, y, w, h, size;
	private double[] cache;

}
