package jm.shape_sketch.tool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import jm.shape_sketch.tool.shapes.Shape.ShapeTypes;

public class ShapeToolbar extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1467297274836144485L;

	private int height;

	public static final int WIDTH = 31;
	public static final int IMAGE_WIDTH = 27;
	public static final int HORIZONTAL_BN_BORDER = (WIDTH - IMAGE_WIDTH) / 2;
	public static final int VERTICAL_BN_BORDER = 1;
	public static final int EXTRA_PANEL_HEIGHT = 4;
	public static final Color BACKGROUND = new Color(240, 240, 240);

	private static final String SQUARE_BUTTON_NAME = "squareButton";
	private static final String SQUARE_BUTTON_IMG_LOCN = "/data/square2.png";
	private static final String SQUARE_BUTTON_ROLLOVER_LOCN = "/data/square2.png";
	private static final String SQUARE_BUTTON_SELECT_LOCN = "/data/square.png";
	private static final String RECT_BUTTON_NAME = "rectangleButton";
	private static final String RECT_BUTTON_IMG_LOCN = "/data/rect.png";
	private static final String RECT_BUTTON_ROLLOVER_LOCN = "/data/rect.png";
	private static final String RECT_BUTTON_SELECT_LOCN = "/data/rect.png";
	private static final String CIRCLE_BUTTON_NAME = "circleButton";
	private static final String CIRCLE_BUTTON_IMG_LOCN = "/data/circle.png";
	private static final String CIRCLE_BUTTON_ROLLOVER_LOCN = "/data/circle_rollover.png";
	private static final String CIRCLE_BUTTON_SELECT_LOCN = "/data/circle_selected.png";
	private static final String ELLIPSE_BUTTON_NAME = "ellipseButton";
	private static final String ELLIPSE_BUTTON_IMG_LOCN = "/data/ellipse.png";
	private static final String ELLIPSE_BUTTON_ROLLOVER_LOCN = "/data/ellipse.png";
	private static final String ELLIPSE_BUTTON_SELECT_LOCN = "/data/ellipse.png";
	private static final String LINE_BUTTON_NAME = "lineButton";
	private static final String LINE_BUTTON_IMG_LOCN = "/data/line.png";
	private static final String LINE_BUTTON_ROLLOVER_LOCN = "/data/line.png";
	private static final String LINE_BUTTON_SELECT_LOCN = "/data/line.png";
	private static final String POINT_BUTTON_NAME = "pointButton";
	private static final String POINT_BUTTON_IMG_LOCN = "/data/point.png";
	private static final String POINT_BUTTON_ROLLOVER_LOCN = "/data/point.png";
	private static final String POINT_BUTTON_SELECT_LOCN = "/data/point.png";
	private static final String POLYGON_BUTTON_NAME = "polygonButton";
	private static final String POLYGON_BUTTON_IMG_LOCN = "/data/polygon.png";
	private static final String POLYGON_BUTTON_ROLLOVER_LOCN = "/data/polygon.png";
	private static final String POLYGON_BUTTON_SELECT_LOCN = "/data/polygon.png";

	public ShapeToolbar(int length) {
		super();
		this.height = length;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setMinimumSize(new Dimension(WIDTH, height));
		setPreferredSize(new Dimension(WIDTH, height));
		setMaximumSize(new Dimension(WIDTH, height));
		setBackground(BACKGROUND);

		// add(addButton("/data/rect.png", "rectangleButton",
		// "/data/rect.png"));
		ButtonGroup group = new ButtonGroup();
		add(addRadioButton(SQUARE_BUTTON_IMG_LOCN, SQUARE_BUTTON_NAME,
				SQUARE_BUTTON_ROLLOVER_LOCN, SQUARE_BUTTON_SELECT_LOCN, group));
		add(addRadioButton(CIRCLE_BUTTON_IMG_LOCN, CIRCLE_BUTTON_NAME,
				CIRCLE_BUTTON_ROLLOVER_LOCN, CIRCLE_BUTTON_SELECT_LOCN, group));
	}

	private JRadioButton addRadioButton(String imageLocation, String buttonName,
			String rolloverImageLocation, String selectImageLocation,
			ButtonGroup group) {
		final JRadioButton b = new JRadioButton();
		ImageIcon icon = new ImageIcon(this.getClass().getResource(
				imageLocation));
		ImageIcon rolloverIcon = new ImageIcon(this.getClass().getResource(
				rolloverImageLocation));
		ImageIcon selectedIcon = new ImageIcon(this.getClass().getResource(
				selectImageLocation));
		// b.setLayout(new BorderLayout());
		// b.setIcon(icon);
		// JLabel label = new JLabel(icon);
		// b.add(label);
		b.setIcon(icon);
		b.setRolloverEnabled(true);
		b.setRolloverIcon(rolloverIcon);
		b.setSelectedIcon(selectedIcon);
		// b.setIconTextGap(0);
		// b.setMargin(new Insets(0, 0, 0, 0));
		// b.setSize(d);

		Dimension bnDimension = new Dimension(IMAGE_WIDTH, IMAGE_WIDTH);
		b.setPreferredSize(bnDimension);
		b.setMinimumSize(bnDimension);
		b.setMaximumSize(bnDimension);

		b.setFocusPainted(false);
		b.setBackground(BACKGROUND);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		// final Border raisedBevelBorder = BorderFactory
		// .createRaisedBevelBorder();
		final Border emptyBorder =
		// new EmptyBorder(
		// raisedBevelBorder.getBorderInsets(b));
		BorderFactory.createEmptyBorder(VERTICAL_BN_BORDER,
				HORIZONTAL_BN_BORDER, VERTICAL_BN_BORDER, HORIZONTAL_BN_BORDER);
		b.setBorder(emptyBorder);

		// b.getModel().addChangeListener(new ChangeListener() {
		// @Override
		// public void stateChanged(ChangeEvent e) {
		// ButtonModel model = (ButtonModel) e.getSource();
		// if (model.isRollover()) {
		// // b.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		// b.setOpaque(true);
		// b.setContentAreaFilled(true);
		// } else {
		// b.setBorder(emptyBorder);
		// b.setOpaque(false);
		// b.setContentAreaFilled(false);
		// }
		// }
		// });

		// b.setMargin(new Insets(0, 0, 0, 0));
		b.setName(buttonName);
		b.setActionCommand(buttonName);

		b.addActionListener(this);

//		JPanel p = new JPanel();
//		Dimension panelDimension = new Dimension(IMAGE_WIDTH + 2
//				* HORIZONTAL_BN_BORDER, IMAGE_WIDTH + 2 * VERTICAL_BN_BORDER
//				+ EXTRA_PANEL_HEIGHT);
//		p.setPreferredSize(panelDimension);
//		p.setMinimumSize(panelDimension);
//		p.setMaximumSize(panelDimension);
//		p.setBackground(BACKGROUND);
//		p.add(b);
//
//		return p;
		group.add(b);
		return b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(SQUARE_BUTTON_NAME)) // {
			PaintPanel.getPaintPanel().setCurrentShapeType(ShapeTypes.SQUARE);// (new
																				// Shape(ShapeTypes.SQUARE));
		// System.out.println("Here");
		// }
		else if (e.getActionCommand().equals(RECT_BUTTON_NAME)) // {
			PaintPanel.getPaintPanel()
					.setCurrentShapeType(ShapeTypes.RECTANGLE);// (new
																// Shape(ShapeTypes.RECTANGLE));
		// System.out.println("Here");
		// }
		else if (e.getActionCommand().equals(CIRCLE_BUTTON_NAME))
			PaintPanel.getPaintPanel().setCurrentShapeType(ShapeTypes.CIRCLE);// (new
																				// Shape(ShapeTypes.CIRCLE));
		else if (e.getActionCommand().equals(ELLIPSE_BUTTON_NAME))
			PaintPanel.getPaintPanel().setCurrentShapeType(ShapeTypes.ELLIPSE);// (new
																				// Shape(ShapeTypes.ELLIPSE));
		else if (e.getActionCommand().equals(LINE_BUTTON_NAME))
			PaintPanel.getPaintPanel().setCurrentShapeType(ShapeTypes.LINE);// (new
																			// Shape(ShapeTypes.LINE));
		else if (e.getActionCommand().equals(POINT_BUTTON_NAME))
			PaintPanel.getPaintPanel().setCurrentShapeType(ShapeTypes.POINT);// (new
																				// Shape(ShapeTypes.POINT));
		else if (e.getActionCommand().equals(POLYGON_BUTTON_NAME))
			PaintPanel.getPaintPanel().setCurrentShapeType(ShapeTypes.POLYGON);// (new
																				// Shape(ShapeTypes.POLYGON));
	}

}
