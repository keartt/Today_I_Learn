package designPattern.adapterP;

public interface Adapter {
	// Math에 있는 알고리즘을 이용해서 원하는거에 맞게 변형 구현은 IMPL에서
	// 원하는 기능
	public Float twiceOf(Float f);
	// 원하는 기능
	public Float halfOf(Float f);
	
}
