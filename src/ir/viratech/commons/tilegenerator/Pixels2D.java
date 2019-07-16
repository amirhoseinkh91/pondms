package ir.viratech.commons.tilegenerator;

public class Pixels2D
{

	public void set(int x, int y)
	{
		int i = this.getIndex(x, y);
		this.cache[i + 0] = this.r;
		this.cache[i + 1] = this.g;
		this.cache[i + 2] = this.b;
		this.cache[i + 3] = this.a;
	}

	public void get(int x, int y)
	{
		int i = this.getIndex(x, y);
		this.r = this.cache[i + 0];
		this.g = this.cache[i + 1];
		this.b = this.cache[i + 2];
		this.a = this.cache[i + 3];
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
		return i * 4;
	}

	public void setData(int[] cache, int x, int y, int w, int h)
	{
		this.cache = cache;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.size = w * h;
	}

	public void setColor(Color c)
	{
		this.r = (int) (255 * c.getRed());
		this.g = (int) (255 * c.getGreen());
		this.b = (int) (255 * c.getBlue());
		this.a = (int) (255 * c.getAlpha());
	}

	public int getA()
	{
		return this.a;
	}

	public void setA(int a)
	{
		this.a = a;
	}

	public int getR()
	{
		return this.r;
	}

	public void setR(int r)
	{
		this.r = r;
	}

	public int getG()
	{
		return this.g;
	}

	public void setG(int g)
	{
		this.g = g;
	}

	public int getB()
	{
		return this.b;
	}

	public void setB(int b)
	{
		this.b = b;
	}

	public int[] getCache()
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

	private int a, r, g, b;

	private int x, y, w, h, size;
	private int[] cache;

}
