package ir.viratech.commons.tilegenerator;

public class Color
        extends Freezable
{

	public Color()
	{
		this.alpha = 0;
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}

	public static Color fromBytes(int r, int g, int b)
	{
		return new Color().setBytes(r, g, b);
	}

	public static Color fromBytes(int a, int r, int g, int b)
	{
		return new Color().setBytes(a, r, g, b);
	}

	public static Color fromDoubles(double r, double g, double b)
	{
		return new Color().setDoubles(r, g, b);
	}

	public static Color fromDoubles(double a, double r, double g, double b)
	{
		return new Color().setDoubles(a, r, g, b);
	}

	public Color set(Color a)
	{
		return this.setDoubles(a.alpha, a.red, a.green, a.blue);
	}

	public Color add(Color a)
	{
		return this.setDoubles(this.alpha + a.alpha,
		                       this.red + a.red,
		                       this.green + a.green,
		                       this.blue + a.blue);
	}

	public Color subtract(Color a)
	{
		return this.setDoubles(this.alpha - a.alpha,
		                       this.red - a.red,
		                       this.green - a.green,
		                       this.blue - a.blue);
	}

	public Color negate()
	{
		return this.setDoubles(-this.alpha, -this.red, -this.green, -this.blue);
	}

	public Color divide(double v)
	{
		return this.setDoubles(this.alpha / v,
		                       this.red / v,
		                       this.green / v,
		                       this.blue / v);
	}

	public Color multiply(double v)
	{
		return this.setDoubles(this.alpha * v,
		                       this.red * v,
		                       this.green * v,
		                       this.blue * v);
	}

	public Color reset()
	{
		return this.setDoubles(0, 0, 0, 0);
	}

	public Color setDoubles(double a, double r, double g, double b)
	{
		this.VerifyWrite();

		this.alpha = a;
		this.red = r;
		this.green = g;
		this.blue = b;

		return this;
	}

	public Color setDoubles(double r, double g, double b)
	{
		return this.setDoubles(1, r, g, b);
	}

	public Color setBytes(int a, int r, int g, int b)
	{
		return this.setDoubles(a / 255.0, r / 255.0, g / 255.0, b / 255.0);
	}

	public Color setBytes(int r, int g, int b)
	{
		return this.setBytes(255, r, g, b);
	}

	public double getAlpha()
	{
		return this.alpha;
	}

	public void setAlpha(double alpha)
	{
		this.VerifyWrite();
		this.alpha = alpha;
	}

	public double getRed()
	{
		return this.red;
	}

	public void setRed(double red)
	{
		this.VerifyWrite();
		this.red = red;
	}

	public double getGreen()
	{
		return this.green;
	}

	public void setGreen(double green)
	{
		this.VerifyWrite();
		this.green = green;
	}

	public double getBlue()
	{
		return this.blue;
	}

	public void setBlue(double blue)
	{
		this.VerifyWrite();
		this.blue = blue;
	}

	private double alpha;
	private double red;
	private double green;
	private double blue;

}
