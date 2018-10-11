package j8.kotcmm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	private Core core = new Core(4, 4);

	private JPanel p;

	private JLabel jLables[][];

	private Map<String, Color> colors;

	private Font font = new Font("TimesRoman", Font.BOLD, 60);

	public MainFrame() {
		super();

		p = new JPanel(new GridLayout(core.getX(), core.getY(), 10, 10));
		jLables = new JLabel[core.getY()][core.getX()];
		p.setBackground(Color.gray);
		p.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.initColors();
		for (int i = 0; i < core.getY(); i++) {
			for (int j = 0; j < core.getX(); j++) {
				JPanel grid = new JPanel(new GridLayout());
				JLabel lb = getLabel(core.getData()[i][j]);
				grid.add(lb);
				p.add(grid);
				jLables[i][j] = lb;
			}
		}
		addKeyListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(p);
		this.setSize(600, 600);
		// this.pack();
		this.setLocationByPlatform(true);
		this.setVisible(true);
	}

	private JLabel getLabel(int text) {
		String s = Integer.toString(text);
		if(text == 0){
			s = "";
		}
		JLabel l = new JLabel(s, SwingConstants.CENTER);
		l.setFont(font);
		l.setBorder(new LineBorder(Color.lightGray, 4));
		Color color =colors.get(Integer.toString(text));
		if (color != null) {
			l.setForeground(color);
		}
		return l;
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			this.core.moveDown();
			break;
		case KeyEvent.VK_UP:
			this.core.moveUp();
			break;
		case KeyEvent.VK_LEFT:
			this.core.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.core.moveRight();
			break;
		}
		this.refresh();
		p.updateUI();
	}

	private void refresh() {
		for (int i = 0; i < core.getY(); i++) {
			for (int j = 0; j < core.getX(); j++) {
				String data = Integer.toString(core.getData()[i][j]);
				if(core.getData()[i][j] == 0){
					data = "";
				}
				jLables[i][j].setText(data);
				Color color =colors.get(data);
				if (color != null) {
					jLables[i][j].setForeground(color);
				}
			}
		}
	}

	public void initColors() {

		colors = new HashMap<String, Color>();
		colors.put("0", Color.black);
		colors.put("2", Color.blue);
		colors.put("4", Color.red);
		colors.put("8", Color.green);
		colors.put("16", Color.orange);
		colors.put("32", Color.magenta);
		colors.put("64", Color.LIGHT_GRAY);
		colors.put("128", Color.pink);
		colors.put("256", Color.gray);
		colors.put("512", Color.DARK_GRAY);
		colors.put("1024", Color.cyan);
		colors.put("2048", Color.yellow);
		colors.put("4096", Color.white);

	}

}
