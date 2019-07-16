package ir.viratech.commons.tilegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Gradient
        extends Freezable
{

	public Gradient()
	{
		this.transformCoef = 1;
		this.transformConst = 0;
	}

	private Gradient(double transformCoef, double transformConst)
	{
		this.transformCoef = transformCoef;
		this.transformConst = transformConst;
	}

	@Override
	protected void onFreezing()
	{
		for (Color c : this.map.values())
		{
			c.freeze();
		}
	}

	public void getColor(double v, Color res)
	{
		if (Double.isNaN(v))
		{
			res.setDoubles(0, 0, 0, 0);
			return;
		}

		v = this.transformCoef * v + this.transformConst;

		Double ceil = this.map.ceilingKey(v);
		Double floor = this.map.floorKey(v);
		if (floor == null)
		{
			floor = ceil;
		}
		if (ceil == null)
		{
			ceil = floor;
		}
		Color cfloor = this.map.get(floor);
		Color cceil = this.map.get(ceil);

		Color t = this.tmp;

		if (floor == ceil)
		{
			res.set(cfloor);
		}
		else
		{
			res.set(t.set(cceil).multiply(v - floor))
			   .add(t.set(cfloor).multiply(ceil - v))
			   .divide(ceil - floor);
		}
	}

	public void addPoint(double v, Color c)
	{
		this.VerifyWrite();
		this.map.put(v, c);
	}

	@SuppressWarnings("unchecked")
	public Tuple2<Double, Color>[] getStops()
	{
		List<Tuple2<Double, Color>> res = new ArrayList<>();
		for (Entry<Double, Color> e : this.map.entrySet())
		{
			res.add(new Tuple2<>((e.getKey() - this.transformConst) / this.transformCoef, e.getValue()));
		}
		return res.toArray(new Tuple2[res.size()]);
	}

	public Gradient cloneForInterval(double min, double max)
	{
		double gmin = this.map.firstKey();
		double gmax = this.map.lastKey();

		double coef = (gmax - gmin) / (max - min);
		double constant = gmin - coef * min;
		Gradient r = new Gradient(coef, constant);

		for (Entry<Double, Color> e : this.map.entrySet())
		{
			r.map.put(e.getKey(), e.getValue());
		}

		return r;
	}

	private final double transformCoef, transformConst;
	private final Color tmp = new Color();
	private final TreeMap<Double, Color> map = new TreeMap<>();

}
