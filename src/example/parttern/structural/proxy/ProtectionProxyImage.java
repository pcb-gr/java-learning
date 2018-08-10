package example.parttern.structural.proxy;

public class ProtectionProxyImage implements Image {
	private RealImage realImage;
	private String fileName;
	private String userName;

	public ProtectionProxyImage(String fileName) {
		this.fileName = fileName;
	}
	
	public ProtectionProxyImage(String fileName, String userName) {
		this.fileName = fileName;
		this.userName = userName;
	}

	@Override
	public void display() {

		if (checkAccess()) {
			if (realImage == null) {
				realImage = new RealImage(fileName);
			}
			realImage.display();
		} else {
			System.out.println("You don't have permision to see the image");
		}

	}

	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean checkAccess() {
		return ("admin".equals(userName));
	}
}
