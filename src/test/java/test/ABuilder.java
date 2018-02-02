package test;

public class ABuilder {

	private Integer count;

	ABuilder() {

	}

	public ABuilder count(int count) {
		this.count = count;
		return this;
	}

	public A build() {
		A building = new A();
		if (count != null) building.setCount(count);    // when mutable, if to avoid overriding defaults
		if (count != null) building.count = count;      // when immutable, if to avoid overriding defaults
		return building;
	}

}
