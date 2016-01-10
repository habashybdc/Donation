package org.takla.hamla.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

public class ButtonTabComponent extends JPanel {
	private static final long serialVersionUID = -8694290022555355515L;
	private final JTabbedPane pane;
	private static final MouseListener buttonMouseListener = new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			Component component = e.getComponent();
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.setBorderPainted(true);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Component component = e.getComponent();
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.setBorderPainted(false);
			}
		}
	};

	public ButtonTabComponent(final JTabbedPane pane) {
		super(new FlowLayout(0, 0, 0));
		if (pane == null) {
			throw new NullPointerException("TabbedPane is null");
		}
		this.pane = pane;
		this.setOpaque(false);
		JLabel label = new JLabel() {
			private static final long serialVersionUID = -4419913823311706404L;

			@Override
			public String getText() {
				int i = pane.indexOfTabComponent(ButtonTabComponent.this);
				if (i != -1) {
					return pane.getTitleAt(i);
				}
				return null;
			}
		};
		this.add(label);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		TabButton button = new TabButton();
		this.add(button);
		this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
	}

	private class TabButton extends JButton implements ActionListener {
		private static final long serialVersionUID = -902017938926817053L;

		public TabButton() {
			int size = 17;
			this.setPreferredSize(new Dimension(size, size));
			this.setToolTipText("close this tab");
			this.setUI(new BasicButtonUI());
			this.setContentAreaFilled(false);
			this.setFocusable(false);
			this.setBorder(BorderFactory.createEtchedBorder());
			this.setBorderPainted(false);
			this.addMouseListener(buttonMouseListener);
			this.setRolloverEnabled(true);
			this.addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) {
			int i = ButtonTabComponent.this.pane.indexOfTabComponent(ButtonTabComponent.this);
			if (i != -1) {
				ButtonTabComponent.this.pane.remove(i);
			}
		}

		@Override
		public void updateUI() {
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g.create();
			if (this.getModel().isPressed()) {
				g2.translate(1, 1);
			}
			g2.setStroke(new BasicStroke(2.0f));
			g2.setColor(Color.BLACK);
			if (this.getModel().isRollover()) {
				g2.setColor(Color.MAGENTA);
			}
			int delta = 6;
			g2.drawLine(delta, delta, this.getWidth() - delta - 1, this.getHeight() - delta - 1);
			g2.drawLine(this.getWidth() - delta - 1, delta, delta, this.getHeight() - delta - 1);
			g2.dispose();
		}
	}

}
