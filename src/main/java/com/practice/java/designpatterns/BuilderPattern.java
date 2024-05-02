package com.practice.java.designpatterns;

class ComputerBuilderClass {
	private String type;
	private String HDD;
	private String RAM;
	private boolean isGraphicCardEnabled;
	private boolean isBluetoothEnabled;
	
	public ComputerBuilderClass(ComputerBuilder builder) {
		super();
		this.type = builder.type;
		HDD = builder.HDD;
		RAM = builder.RAM;
		this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}
	
	public String getType() {
		return type;
	}
	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	public boolean isGraphicCardEnabled() {
		return isGraphicCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	public static class ComputerBuilder {
		private String type;
		private String HDD;
		private String RAM;
		private boolean isGraphicCardEnabled;
		private boolean isBluetoothEnabled;
		
		private ComputerBuilder type(String type) {
			this.type = type;
			return this;
		}
		public ComputerBuilder HDD(String hdd) {
			this.HDD = hdd;
			return this;
		}
		public ComputerBuilder RAM(String ram) {
			this.RAM = ram;
			return this;
		}
		public ComputerBuilder isGraphicCardEnabled(boolean isGraphicCardEnabled) {
			this.isGraphicCardEnabled = isGraphicCardEnabled;
			return this;
		}
		public ComputerBuilder isBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		public ComputerBuilderClass build() {
			return new ComputerBuilderClass(this);
		}
	}
}

public class BuilderPattern {

	public static void main(String[] args) {
		ComputerBuilderClass obj1 = new ComputerBuilderClass.ComputerBuilder()
										.HDD("1TB").RAM("16GB").isGraphicCardEnabled(false).isBluetoothEnabled(true)
										.build();
		System.out.println(obj1.hashCode());
		
		ComputerBuilderClass obj2 = new ComputerBuilderClass.ComputerBuilder()
										.HDD("1TB").RAM("16GB").isGraphicCardEnabled(false).isBluetoothEnabled(true)
										.build();
		System.out.println(obj2.hashCode());
		
	}

}
