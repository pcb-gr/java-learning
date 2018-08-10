package example.parttern.creational.prototype;

public class Address {
	
	String province;
	String district;
	String street;
	
	public Address(String province, String district, String street) {
		this.province = province;
		this.district = district;
		this.street = street;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "User [province=" + province + ", district=" + district + ", street=" + street + "]";
	}
}
