package ir.viratech.commons.tilegenerator;

public class PointMercatorTransformer
        extends PointTilesTransformer
{

	@Deprecated
	public PointMercatorTransformer()
	{
	}

	@Override
	protected void fromLatLonNoTiling(PointF p)
	{
		// sinLatitude = sin(latitude * pi/180)

		// pixelX = ((longitude + 180) / 360) * 256 * 2^level

		// pixelY = (0.5 - log((1 + sinLatitude) / (1 - sinLatitude)) / (4 *
		// pi)) * 256 * 2^level

		p.x = (p.x % 360 + 360 * 2) % 360;

		p.x /= 360;
		double sinY = Math.sin(p.y * Math.PI / 180);
		p.y = 0.5 - Math.log((1 + sinY) / (1 - sinY)) / (4 * Math.PI);
	}

	@Override
	protected void toLatLonNoTiling(PointF p)
	{
		p.x *= 360;
		p.y = Math.exp((0.5 - p.y) * (4 * Math.PI));
		double sinY = (p.y - 1) / (p.y + 1);
		p.y = Math.asin(sinY) / Math.PI * 180;
	}

}
