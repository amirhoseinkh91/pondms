package ir.viratech.commons.tilegenerator;

public abstract class PointTilesTransformer
        extends PointTransformer
{

	protected abstract void fromLatLonNoTiling(PointF p);

	protected abstract void toLatLonNoTiling(PointF p);

	@Override
	protected final void fromLatLonOverride(PointF p)
	{
		this.fromLatLonNoTiling(p);
		int scale = this.getTileSize() * (1 << this.getZoom());
		p.x *= scale;
		p.y *= scale;
	}

	@Override
	protected final void toLatLonOverride(PointF p)
	{
		int scale = this.getTileSize() * (1 << this.getZoom());
		p.x /= scale;
		p.y /= scale;
		this.toLatLonNoTiling(p);
	}

	public int getZoom()
	{
		return this.zoom;
	}

	public void setZoom(int zoom)
	{
		this.zoom = zoom;
	}

	public int getTileSize()
	{
		return this.tileSize;
	}

	public void setTileSize(int tileSize)
	{
		this.tileSize = tileSize;
	}

	private int tileSize = 256;
	private int zoom = 0;

}
