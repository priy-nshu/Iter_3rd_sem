import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.List;

class CustomFontChooser extends JDialog {
    private Font selectedFont;
    private JComboBox<String> fontComboBox;
    private JComboBox<Integer> sizeComboBox;
    private JCheckBox boldCheckBox;
    private JCheckBox italicCheckBox;
    private boolean canceled = false;

    public CustomFontChooser(JFrame parent, Font initialFont) {
        super(parent, "Font Chooser", true);
        selectedFont = initialFont;

        fontComboBox = new JComboBox<>(getAvailableFontFamilyNames());
        sizeComboBox = new JComboBox<>(new Integer[]{8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40, 48, 56, 72});
        boldCheckBox = new JCheckBox("Bold");
        italicCheckBox = new JCheckBox("Italic");

        // Initialize UI with the initial font
        fontComboBox.setSelectedItem(initialFont.getFamily());
        sizeComboBox.setSelectedItem(initialFont.getSize());
        boldCheckBox.setSelected(initialFont.isBold());
        italicCheckBox.setSelected(initialFont.isItalic());

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canceled = false;
                updateSelectedFont();
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canceled = true;
                dispose();
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Font:"), gbc);

        gbc.gridx = 1;
        panel.add(fontComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Size:"), gbc);

        gbc.gridx = 1;
        panel.add(sizeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Style:"), gbc);

        gbc.gridx = 1;
        panel.add(boldCheckBox, gbc);

        gbc.gridx = 2;
        panel.add(italicCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(okButton, gbc);

        gbc.gridx = 2;
        panel.add(cancelButton, gbc);

        add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    public Font getSelectedFont() {
        return selectedFont;
    }

    public boolean wasCanceled() {
        return canceled;
    }

    private void updateSelectedFont() {
        int style = Font.PLAIN;
        if (boldCheckBox.isSelected()) {
            style |= Font.BOLD;
        }
        if (italicCheckBox.isSelected()) {
            style |= Font.ITALIC;
        }

        selectedFont = new Font(fontComboBox.getSelectedItem().toString(), style, (int) sizeComboBox.getSelectedItem());
    }

    public Font showDialog() {
        canceled = false;
        setVisible(true);
        if (canceled) {
            return null;
        } else {
            return getSelectedFont();
        }
    }

    private String[] getAvailableFontFamilyNames() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        return ge.getAvailableFontFamilyNames();
    }
}

public class text_editor {
    private JFrame frame;
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JScrollPane scrollPane;
    private JSpinner fontsizespinner;
    private Font currentFont;
    private JComboBox fontBox;

    public text_editor() {
        super();
        frame = new JFrame("Text Editor");
        textArea = new JTextArea(20, 60);
        fileChooser = new JFileChooser();
        scrollPane= new JScrollPane(textArea);
        fontsizespinner= new JSpinner(new SpinnerNumberModel(12,8,72,1));
        currentFont= textArea.getFont();

        String[] fonts= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontBox = new JComboBox<>();
        fontBox.addActionListener(this::actionPerformed);
        fontBox.setSelectedItem("Arial");


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu formatMenu=new JMenu("Format");
        JMenu fontMenu= new JMenu("Font");

        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem fontItem = new JMenuItem("Font Style");
        JMenuItem colorItem= new JMenuItem("Text Color");

        JMenuItem fontArial = new JMenuItem("Arial");
        JMenuItem fontTimesNewRoman = new JMenuItem("Times New Roman");
        JMenuItem fontCourier = new JMenuItem("Courier New");


        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(exit);

        menuBar.add(fileMenu);
        menuBar.add(formatMenu);

        formatMenu.add(fileMenu);
        formatMenu.add(colorItem);
        formatMenu.add(fontItem);

        fontMenu.add(fontItem);
        fontMenu.add(fontBox);
        fontMenu.add(fontArial);
        fontMenu.add(fontTimesNewRoman);
        fontMenu.add(fontCourier);

        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.setJMenuBar(menuBar);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial",Font.PLAIN,20));



        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        textArea.read(reader, null);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showSaveDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        textArea.write(writer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fontItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomFontChooser fontChooser = new CustomFontChooser(frame, textArea.getFont());
                Font selectedFont = fontChooser.showDialog();
                if (selectedFont != null) {
                    textArea.setFont(selectedFont);
                }
            }
        });

        colorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = showColorDialog(frame, textArea.getForeground());
                if (selectedColor != null) {
                    textArea.setForeground(selectedColor);
                }
            }
        });



        fontsizespinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int newSize = (int) fontsizespinner.getValue();
                Font currentFont = textArea.getFont();
                textArea.setFont(new Font(currentFont.getFamily(), currentFont.getStyle(), newSize));
            }
        });

        JPanel panel=new JPanel();
        panel.add(new JLabel("Font size:"));
        panel.add(fontsizespinner);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.add(fontBox);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==fontBox){
            textArea.setFont(new Font((String) fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }
    }
    private Font showFontChooserDialog(JFrame parent, Font initialFont) {
        CustomFontChooser fontChooser = new CustomFontChooser(parent, initialFont);
        return fontChooser.showDialog();
    }
    private Color showColorDialog(JFrame parent, Color initialColor) {
        Color selectedColor = JColorChooser.showDialog(parent, "Choose Text Color", initialColor);
        return selectedColor;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new text_editor());
    }
}