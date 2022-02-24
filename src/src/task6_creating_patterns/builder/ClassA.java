package task6_creating_patterns.builder;

public class ClassA {
	private Integer propertyOne = null;
	private Integer propertyTwo = null;
	private Integer propertyThree = null;
	private Integer propertyFour = null;

	public static class Builder {
		private ClassA buildableInstance = null;

		public Builder() {
			this.buildableInstance = new ClassA();
		}

		public Builder putFieldOne() {
			buildableInstance.propertyOne = 1;
			return this;
		}

		public Builder putFieldTwo() {
			buildableInstance.propertyTwo = 2;
			return this;
		}

		public Builder putFieldThree() {
			buildableInstance.propertyThree = 3;
			return this;
		}

		public Builder putFieldFour() {
			buildableInstance.propertyFour = 4;
			return this;
		}

		public ClassA build() {
			return buildableInstance;
		}
	}

	public Integer getPropertyOne() {
		return propertyOne;
	}

	public void setPropertyOne(Integer propertyOne) {
		this.propertyOne = propertyOne;
	}

	public Integer getPropertyTwo() {
		return propertyTwo;
	}

	public void setPropertyTwo(Integer propertyTwo) {
		this.propertyTwo = propertyTwo;
	}

	public Integer getPropertyThree() {
		return propertyThree;
	}

	public void setPropertyThree(Integer propertyThree) {
		this.propertyThree = propertyThree;
	}

	public Integer getPropertyFour() {
		return propertyFour;
	}

	public void setPropertyFour(Integer propertyFour) {
		this.propertyFour = propertyFour;
	}

	@Override
	public String toString() {
		return "ClassA{" +
				"propertyOne=" + propertyOne +
				", propertyTwo=" + propertyTwo +
				", propertyThree=" + propertyThree +
				", propertyFour=" + propertyFour +
				'}';
	}
}
