import javax.swing.*;

public class BrickBreaker {

	public static void main(String[] args) {
		
		JFrame frame_obj = new JFrame();
		GamePlay gPlay = new GamePlay();
		
		
		frame_obj.setBounds(10, 10, 700, 600);
		frame_obj.setTitle("Brick Breaker");
		frame_obj.setResizable(false);
		frame_obj.setVisible(true);
		frame_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_obj.add(gPlay);
	}

}
