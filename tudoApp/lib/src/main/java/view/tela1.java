package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class tela1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela1 frame = new tela1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tela1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane jPanelTooBar = new JDesktopPane();
		jPanelTooBar.setBackground(new Color(0, 128, 0));
		jPanelTooBar.setBounds(0, 0, 1057, 138);
		contentPane.add(jPanelTooBar);
		
		JLabel jLabelTooBarSubTitle = new JLabel("  Anote tudo, não esqueça de nada.");
		jLabelTooBarSubTitle.setForeground(Color.WHITE);
		jLabelTooBarSubTitle.setBounds(20, 91, 548, 20);
		jPanelTooBar.add(jLabelTooBarSubTitle);
		jLabelTooBarSubTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel jLabelTooBarTitle = new JLabel("  TudoApp");
		jLabelTooBarTitle.setIcon(new ImageIcon(tela1.class.getResource("/view/checked (1).png")));
		jLabelTooBarTitle.setBounds(10, 11, 491, 65);
		jPanelTooBar.add(jLabelTooBarTitle);
		jLabelTooBarTitle.setBackground(new Color(240, 240, 240));
		jLabelTooBarTitle.setVerticalAlignment(SwingConstants.TOP);
		jLabelTooBarTitle.setForeground(new Color(248, 248, 255));
		jLabelTooBarTitle.setFont(new Font("Segoe UI", Font.BOLD, 29));
		
		JDesktopPane jPanelTasks = new JDesktopPane();
		jPanelTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192)));
		jPanelTasks.setBackground(new Color(255, 255, 255));
		jPanelTasks.setBounds(230, 149, 817, 72);
		contentPane.add(jPanelTasks);
		
		JLabel jLabelTasksTitle = new JLabel("  Tarefas");
		jLabelTasksTitle.setForeground(new Color(0, 128, 0));
		jLabelTasksTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jLabelTasksTitle.setBounds(10, 11, 101, 50);
		jPanelTasks.add(jLabelTasksTitle);
		
		JLabel jLabelTasksAdd = new JLabel("");
		jLabelTasksAdd.setIcon(new ImageIcon(tela1.class.getResource("/view/plus (2).png")));
		jLabelTasksAdd.setBounds(753, 11, 41, 50);
		jPanelTasks.add(jLabelTasksAdd);
		
		JDesktopPane jPanelProjects = new JDesktopPane();
		jPanelProjects.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192)));
		jPanelProjects.setBackground(new Color(255, 255, 255));
		jPanelProjects.setBounds(0, 149, 220, 72);
		contentPane.add(jPanelProjects);
		
		JLabel jLabelProjectsTitle = new JLabel("  Projetos");
		jLabelProjectsTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jLabelProjectsTitle.setForeground(new Color(0, 128, 0));
		jLabelProjectsTitle.setBackground(new Color(0, 0, 0));
		jLabelProjectsTitle.setBounds(10, 11, 83, 50);
		jPanelProjects.add(jLabelProjectsTitle);
		
		JLabel jLabelProjectsAdd = new JLabel("  ");
		jLabelProjectsAdd.setIcon(new ImageIcon(tela1.class.getResource("/view/plus (2).png")));
		jLabelProjectsAdd.setBounds(158, 11, 52, 50);
		jPanelProjects.add(jLabelProjectsAdd);
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192)));
		desktopPane_3.setBackground(new Color(255, 255, 255));
		desktopPane_3.setBounds(0, 232, 220, 503);
		contentPane.add(desktopPane_3);
		
		JList jListProjects = new JList();
		jListProjects.setValueIsAdjusting(true);
		jListProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListProjects.setBackground(new Color(255, 255, 255));
		jListProjects.setFont(new Font("Segoe UI", Font.BOLD, 18));
		jListProjects.setModel(new AbstractListModel() {
			String[] values = new String[] {"itens 1", "", "", "", "", "itens 2", "", "", "", "", "itens 3", "", "", "", "", "itens 4", "", "", "", "", "itens 5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		jListProjects.setBounds(10, 11, 200, 445);
		desktopPane_3.add(jListProjects);
		
		JDesktopPane desktopPane_4 = new JDesktopPane();
		desktopPane_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192)));
		desktopPane_4.setBackground(new Color(255, 255, 255));
		desktopPane_4.setBounds(230, 232, 817, 503);
		contentPane.add(desktopPane_4);
		
		JDesktopPane jPanelEmptyListIcon = new JDesktopPane();
		jPanelEmptyListIcon.setBackground(new Color(255, 255, 255));
		jPanelEmptyListIcon.setBounds(10, 11, 807, 492);
		desktopPane_4.add(jPanelEmptyListIcon);
		
		JLabel jLabelEmptyListIcon = new JLabel("");
		jLabelEmptyListIcon.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEmptyListIcon.setIcon(new ImageIcon(tela1.class.getResource("/view/lista-de-controle.png")));
		jLabelEmptyListIcon.setBounds(10, 77, 730, 137);
		jPanelEmptyListIcon.add(jLabelEmptyListIcon);
		
		JLabel jLabelEmptyListTitle = new JLabel(" Nenhuma Tarefa Por Aqui :D");
		jLabelEmptyListTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jLabelEmptyListTitle.setForeground(new Color(0, 128, 0));
		jLabelEmptyListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEmptyListTitle.setBounds(10, 235, 702, 36);
		jPanelEmptyListIcon.add(jLabelEmptyListTitle);
		
		JLabel jLabelEmptyListSubTitle = new JLabel("  Clique no botão \"+\" para adicionar uma nova tarefa");
		jLabelEmptyListSubTitle.setForeground(new Color(119, 136, 153));
		jLabelEmptyListSubTitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		jLabelEmptyListSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEmptyListSubTitle.setBounds(10, 282, 741, 25);
		jPanelEmptyListIcon.add(jLabelEmptyListSubTitle);
	}
}
