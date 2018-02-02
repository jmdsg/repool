package test;

interface ARPL {

	default int getCount() {
		if (this instanceof A) return ((A) this).count;
		else throw new IllegalStateException("Illegal use of the RPL class ARPL"); // class name generated
	}

	default void setCount(int count) {
		if (this instanceof A) ((A) this).count = count;
		else throw new IllegalStateException("Illegal use of the RPL class ARPL"); // class name generated
	}

	static ABuilder builder() {
		return new ABuilder();
	}

}
