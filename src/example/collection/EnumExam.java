//https://o7planning.org/vi/10199/huong-dan-su-dung-java-enum

package example.collection;

public class EnumExam {

	public enum WeekDay {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}

	// Thời khóa biểu.
	public static class Timetable {

		public static String getJob(WeekDay weekDay) {
			// 2- Có thể sử dụng toán tử == để so sánh các phần tử của enum
			if (weekDay == WeekDay.SATURDAY || weekDay == WeekDay.SUNDAY) {
				return "Nothing";
			}
			// 3- Enum có thể sử dụng như tham số trong câu lệnh switch
			switch (weekDay) {
			case MONDAY:
				System.out.println("Working day");
				break;
			case SATURDAY:
			case SUNDAY:
				System.out.println("Holiday");
				break;
			default:
				System.out.println(weekDay);
			}

			// 4- Duyệt trên các phần tử của Enum
			// Lấy ra tất cả các phần tử của Enum.
			WeekDay[] allDays = WeekDay.values();

			for (WeekDay day : allDays) {
				System.out.println("Day: " + day);
			}

			// 5- Enum có thể có cấu tử và phương thức
			Gender marryGender = Gender.FEMALE;

			System.out.println("Code: " + marryGender.getCode());
			System.out.println("Text: " + marryGender.getText());

			// Gender[].
			for (Gender gender : Gender.values()) {
				System.out.println(gender.getText());
			}

			String code = "M";
			Gender gender = Gender.getGenderByCode(code);

			System.out.println("Gender by code: " + gender);

			// 6- Ghi đè phương thức trong Enum
			Currency money = Currency.USD;

			System.out.println("Money " + money);
			System.out.println("Money " + money.toString());
			System.out.println("VND " + Currency.VND);
			System.out.println("EURO " + Currency.EURO);
			
			return "Coding";
		}
		
		public static void main(String[] args) {
			Timetable.getJob(EnumExam.WeekDay.MONDAY);
		}
	}

	public enum Gender {

		// Khởi tạo các phần tử từ cấu tử.
		// Các phần tử này luôn là final, static
		MALE("M", "Male"), FEMALE("F", "Female");

		private String code;
		private String text;

		// Cấu tử này chỉ dùng trong nội bộ Enum
		// Modifier của cấu tử luôn là private
		// Nếu bạn không khai báo private, java cũng sẽ hiểu là private.
		private Gender(String code, String text) {
			this.code = code;
			this.text = text;
		}

		// Có thể viết một static method lấy ra Gender theo code.
		public static Gender getGenderByCode(String code) {
			for (Gender gender : Gender.values()) {
				if (gender.code.equals(code)) {
					return gender;
				}
			}
			return null;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}

	public enum Currency {

		VND, USD, EURO;

		@Override
		public String toString() {
			if (this == VND) {
				return "Dong";
			} else if (this == USD) {
				return "Dola";
			}
			return super.toString();
		}
	}
}
