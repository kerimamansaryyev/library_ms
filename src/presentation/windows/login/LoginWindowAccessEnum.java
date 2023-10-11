package presentation.windows.login;

public enum LoginWindowAccessEnum {

	LIBRARIAN("Librarian"), ADMIN("Admin"), SUPER_ADMIN("Superadmin");

	private final String label;

	 LoginWindowAccessEnum(String label) {
		this.label = label;
	}

	@Override
	public String toString() {

		return label;
	}

}
