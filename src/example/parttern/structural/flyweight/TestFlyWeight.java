/*
	http://cuongndh.blogspot.com/p/flyweight-pattern.html
	Flyweight Pattern được sử dụng khi chúng ta cần tạo một số lượng lớn các đối tượng của 1 lớp nào đó. Do mỗi đối tượng đều đòi hỏi chiếm giữ một khoảng không gian bộ nhớ, nên với một số lượng lớn đối tượng được tạo ra có thể gây nên vấn đề nghiêm trọng đặc biệt đối với các thiết bị có dung lượng nhớ thấp. Flyweight Pattern có thể được áp dụng để giảm tải cho bộ nhớ thông qua cách chia sẻ các đối tượng.
	
	Một số lưu ý khi áp dụng Flyweight Pattern:
	
	Số các đối tượng được ứng dụng tạo ra phải thực sự lớn.
	Việc tạo ra đối tượng đòi hỏi nhiều bộ nhớ và thời gian.
	Các thuộc tính của đối tượng có thể chia thành nhóm intrinsic và extrinsic. Trong đó, nhóm thuộc tính extrinsic của đối tượng nên được chương trình client xác lập.
	Để áp dụng Flyweight Pattern, chúng ta cần xây dựng Flyweight Factory để trả về các đối tượng chia sẻ (dùng chung?). Như trong ví dụ sau, để tạo ra một bức hình gồm các đường thẳng và các hình oval thì chúng ta cần có một interface Shape và các implementation của nó là Line và Oval. Lớp Oval có các thuộc tính intrinsic để xác định xem thử có tô màu cho hình Oval hay không, trong khi lớp Line không có thuộc tính này.
*/
package example.parttern.structural.flyweight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import example.parttern.structural.flyweight.ShapeFactory.ShapeType;

public class TestFlyWeight extends JFrame {

	private static final long serialVersionUID = -1350200437285282550L;
	private final int WIDTH;
	private final int HEIGHT;

	private static final ShapeType shapes[] = { ShapeType.LINE, ShapeType.OVAL_FILL, ShapeType.OVAL_NOFILL };
	private static final Color colors[] = { Color.RED, Color.GREEN, Color.YELLOW };

	public TestFlyWeight(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		Container contentPane = getContentPane();

		JButton startButton = new JButton("Draw");
		final JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(startButton, BorderLayout.SOUTH);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Graphics g = panel.getGraphics();
				for (int i = 0; i < 200; ++i) {
					Shape shape = ShapeFactory.getShape(getRandomShape());
					shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(), getRandomHeight(), getRandomColor());
				}
			}
		});
	}

	private ShapeType getRandomShape() {
		return shapes[(int) (Math.random() * shapes.length)];
	}

	private int getRandomX() {
		return (int) (Math.random() * WIDTH);
	}

	private int getRandomY() {
		return (int) (Math.random() * HEIGHT);
	}

	private int getRandomWidth() {
		return (int) (Math.random() * (WIDTH / 10));
	}

	private int getRandomHeight() {
		return (int) (Math.random() * (HEIGHT / 10));
	}

	private Color getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	public static void main(String[] args) {
		TestFlyWeight drawing = new TestFlyWeight(500, 600);
	}
}
