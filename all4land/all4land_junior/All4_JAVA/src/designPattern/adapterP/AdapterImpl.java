package designPattern.adapterP;

public class AdapterImpl implements Adapter{
	
	@Override
	public Float twiceOf(Float f) {
		return (float) Math.doubled(f.doubleValue()).floatValue();
	}

	@Override
	public Float halfOf(Float f) {
		return (float) Math.half(f.doubleValue());
	}
}