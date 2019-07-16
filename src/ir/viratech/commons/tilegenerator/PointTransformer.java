package ir.viratech.commons.tilegenerator;

public abstract class PointTransformer
{

	protected abstract void fromLatLonOverride(PointF p);

	protected abstract void toLatLonOverride(PointF p);

	public void fromLatLon(PointF p)
	{
		// p.x = ((p.x % 360) + 360) % 360;
		if (p.y < -90 | p.y > 90)
		{
			throw new RuntimeException("Invalid y.");
		}
		this.fromLatLonOverride(p);
	}

	public void toLatLon(PointF p)
	{
		this.toLatLonOverride(p);
		// if (p.x < 0 | p.x > 360 | p.y < -90 | p.y > 90)
		// {
		// throw new RuntimeException("Invalid implementation.");
		// }
	}

	public void fromSource(PointTransformer sourcePT, PointF p)
	{
		sourcePT.toLatLon(p);
		this.fromLatLon(p);
	}

}
