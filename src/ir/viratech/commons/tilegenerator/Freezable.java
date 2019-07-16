package ir.viratech.commons.tilegenerator;

public class Freezable
{

	public final void freeze()
	{
		if (this.isFreezeCalled)
		{
			return;
		}
		this.isFreezeCalled = true;

		this.onFreezing();
		this.isFrozen = true;
		this.onFroze();
	}

	protected void onFreezing()
	{
	}

	protected void onFroze()
	{
	}

	protected final void VerifyWrite()
	{
		if (this.isFrozen)
		{
			throw new RuntimeException("Cannot change a frozen object.");
		}
	}

	protected final void VerifyFrozen()
	{
		if (this.isFrozen)
		{
			throw new RuntimeException("The object has to be frozen to perform this operation.");
		}
	}

	public final boolean isFrozen()
	{
		return this.isFrozen;
	}

	private boolean isFrozen;
	private boolean isFreezeCalled;

}
