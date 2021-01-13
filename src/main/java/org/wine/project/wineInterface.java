package org.wine.project;

import org.wine.project.util.FileUtility;
import org.wine.project.util.NoWineSelectedException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static org.wine.project.wineAvailability.AVAILABLE;
import static org.wine.project.wineAvailability.UNAVAILABLE;

public class wineInterface {

    private static final int LABEL_WIDTH = 300;
    private static final int INPUT_WIDTH = 165;
    private static final int BUTTON_ALIGNMENT = 180;
    private static final int BUTTON_ALIGNMENT_2 = 30;
    private static final int LIST_BUTTON_ALLIGNMENT = 200;
    private static final int LIST_BUTTON_ALLIGNMENT_2 = 200;
    private static final int LABEL_ALIGNMENT = 140;
    private static final int INPUT_ALIGNMENT = 260;
    private static final int FIELD_HEIGHT = 25;
    private static final int ROW_1 = 20;
    private static final int ROW_2 = 60;
    private static final int ROW_3 = 100;
    private static final int ROW_4 = 140;
    private static final int ROW_5 = 180;
    private static final int ROW_6 = 220;
    private static final int ROW_7 = 260;
    private static final int ROW_8 = 300;
    private static final int ROW_9 = 340;
    private static final int ROW_10 = 380;

    private static final int BUTTON_WIDTH= 200;
    private static final int BUTTON_WIDTH_2= 160;

    private static JTextField idInput;
    private static JTextField categoryInput;
    private static JTextField nameInput;
    private static JTextField producerInput;
    private static JTextField manufacturingYearInput;
    private static JTextField breathalyserInput;
    private static JTextField countryInput;
    private static JTextField amountInput;
    private static JTextField priceInput;
    private static JButton buttonSave;
    private static JRadioButton availableRadio;
    private static JRadioButton unavailableRadio;
    private static ButtonGroup radioGroup;
    private static JTextArea adressInput;

    private static JButton buttonAddWine;
    private static JButton buttonListWines;
    private static JButton buttonExit;

    private static JButton buttonSaveWine;

    private static JButton buttonModifyWine;
    private static JButton buttonDeleteWine;
    private static JButton buttonBackToMenu;

    private static JList<String> jlist;

    private static DefaultListModel<String> wineListModel;

    private static JFrame frame;

    private static List<Wine> wineList =new ArrayList<>();

    private static void goToAddPage(JPanel panel){
        buttonAddWine.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.removeAll();
                        panel.updateUI();
                        showAddPage(panel);
                    }
                }
        );
    }
    private static void showAddPage(JPanel panel) {
        JLabel idLabel = new JLabel("ID: ");
        idLabel.setBounds(LABEL_ALIGNMENT,ROW_1,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(idLabel);

        idInput = new JTextField(20);
        idInput.setBounds(INPUT_ALIGNMENT,ROW_1,INPUT_WIDTH,FIELD_HEIGHT);
        panel.add(idInput);

        /*-----------------------------------------------------------------------*/

        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setBounds(LABEL_ALIGNMENT,ROW_2,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(categoryLabel);

        categoryInput = new JTextField(20);
        categoryInput.setBounds(INPUT_ALIGNMENT,ROW_2,INPUT_WIDTH,FIELD_HEIGHT);
        panel.add(categoryInput);

        /*-----------------------------------------------------------------------*/

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(LABEL_ALIGNMENT,ROW_3,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(nameLabel);

        nameInput = new JTextField(20);
        nameInput.setBounds(INPUT_ALIGNMENT,ROW_3,INPUT_WIDTH,FIELD_HEIGHT);
        panel.add(nameInput);

        /*-----------------------------------------------------------------------*/
        JLabel producerLabel = new JLabel("Producer");
        producerLabel.setBounds(LABEL_ALIGNMENT,ROW_4,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(producerLabel);

        producerInput = new JTextField(20);
        producerInput.setBounds(INPUT_ALIGNMENT,ROW_4,INPUT_WIDTH,FIELD_HEIGHT);
        panel.add(producerInput);

        /*-----------------------------------------------------------------------*/
        JLabel manufacturingYearLabel = new JLabel("Manufacturing year");
        manufacturingYearLabel.setBounds(LABEL_ALIGNMENT,ROW_5,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(manufacturingYearLabel);

        manufacturingYearInput = new JTextField(20);
        manufacturingYearInput.setBounds(INPUT_ALIGNMENT,ROW_5,INPUT_WIDTH,FIELD_HEIGHT);
        panel.add(manufacturingYearInput);

        /*-----------------------------------------------------------------------*/
        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(LABEL_ALIGNMENT,ROW_6,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(amountLabel);

        amountInput = new JTextField(20);
        amountInput.setBounds(INPUT_ALIGNMENT,ROW_6,INPUT_WIDTH,FIELD_HEIGHT);
        panel.add(amountInput);

        /*-----------------------------------------------------------------------*/
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(LABEL_ALIGNMENT,ROW_7,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(priceLabel);

        priceInput = new JTextField(20);
        priceInput.setBounds(INPUT_ALIGNMENT,ROW_7,INPUT_WIDTH,FIELD_HEIGHT);
        panel.add(priceInput);

        /*-----------------------------------------------------------------------*/

        JLabel availabilityLabel = new JLabel("Availability: ");
        availabilityLabel.setBounds(LABEL_ALIGNMENT,ROW_8,LABEL_WIDTH, FIELD_HEIGHT);
        panel.add(availabilityLabel);

        radioGroup = new ButtonGroup();

        availableRadio = new JRadioButton();
        availableRadio.setText("AVAILABLE");
        availableRadio.setBounds(260,ROW_8,120,FIELD_HEIGHT);

        unavailableRadio = new JRadioButton();
        unavailableRadio.setText("UNAVAILABLE");
        unavailableRadio.setBounds(380,ROW_8,120,FIELD_HEIGHT);

        radioGroup.add(availableRadio);
        radioGroup.add(unavailableRadio);

        panel.add(availableRadio);
        panel.add(unavailableRadio);

        buttonSaveWine = new JButton("SAVE");
        buttonSaveWine.setBounds(BUTTON_ALIGNMENT, ROW_9,BUTTON_WIDTH,FIELD_HEIGHT);
        buttonSaveWine.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Wine wine = new Wine();
                        wine.setId(idInput.getText());
                        wine.setCategory(categoryInput.getText());
                        wine.setName(nameInput.getText());
                        wine.setProducer(producerInput.getText());
                        wine.setManufacturing_year(manufacturingYearInput.getText());
                        wine.setAmount(amountInput.getText());
                        wine.setPrice(priceInput.getText());
                        if(unavailableRadio.isSelected()){
                            wine.setAbailability(UNAVAILABLE);
                        }else
                            wine.setAbailability(AVAILABLE);

                        wineList.add(wine);

                        clearPanel(panel);
                        showMenuPage(panel);
                    }
                }
        );
        panel.add(buttonSaveWine);

        buttonBackToMenu = new JButton("Back to menu");
        buttonBackToMenu.setBounds(BUTTON_ALIGNMENT, ROW_10,BUTTON_WIDTH,FIELD_HEIGHT);
        buttonBackToMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearPanel(panel);
                        showMenuPage(panel);
                    }
                }
        );
        panel.add(buttonBackToMenu);

    }

    private static void showModifyPage(JPanel panel, Wine wine) {
        JLabel idLabel = new JLabel("ID: ");
        idLabel.setBounds(LABEL_ALIGNMENT,ROW_1,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(idLabel);

        idInput = new JTextField(20);
        idInput.setBounds(INPUT_ALIGNMENT,ROW_1,INPUT_WIDTH,FIELD_HEIGHT);
        idInput.setText(wine.getId());
        panel.add(idInput);

        /*-----------------------------------------------------------------------*/

        JLabel categoryLabel = new JLabel("Category ");
        categoryLabel.setBounds(LABEL_ALIGNMENT,ROW_2,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(categoryLabel);

        categoryInput = new JTextField(20);
        categoryInput.setBounds(INPUT_ALIGNMENT,ROW_2,INPUT_WIDTH,FIELD_HEIGHT);
        categoryInput.setText(wine.getCategory());
        panel.add(categoryInput);

        /*-----------------------------------------------------------------------*/

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(LABEL_ALIGNMENT,ROW_3,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(nameLabel);

        nameInput = new JTextField(20);
        nameInput.setBounds(INPUT_ALIGNMENT,ROW_3,INPUT_WIDTH,FIELD_HEIGHT);
        nameInput.setText(wine.getName());
        panel.add(nameInput);

        /*-----------------------------------------------------------------------*/

        JLabel producerLabel = new JLabel("Producer");
        producerLabel.setBounds(LABEL_ALIGNMENT,ROW_4,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(producerLabel);

        producerInput = new JTextField(20);
        producerInput.setBounds(INPUT_ALIGNMENT,ROW_4,INPUT_WIDTH,FIELD_HEIGHT);
        producerInput.setText(wine.getProducer());
        panel.add(producerInput);

        /*-----------------------------------------------------------------------*/
        JLabel manufacturing_yearLabel = new JLabel("Manufacturing year");
        manufacturing_yearLabel.setBounds(LABEL_ALIGNMENT,ROW_5,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(manufacturing_yearLabel);

        manufacturingYearInput = new JTextField(20);
        manufacturingYearInput.setBounds(INPUT_ALIGNMENT,ROW_5,INPUT_WIDTH,FIELD_HEIGHT);
        manufacturingYearInput.setText(wine.getManufacturing_year());
        panel.add(manufacturingYearInput);

        /*-----------------------------------------------------------------------*/
        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(LABEL_ALIGNMENT,ROW_6,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(amountLabel);

        amountInput = new JTextField(20);
        amountInput.setBounds(INPUT_ALIGNMENT,ROW_6,INPUT_WIDTH,FIELD_HEIGHT);
        amountInput.setText(wine.getAmount());
        panel.add(amountInput);

        /*-----------------------------------------------------------------------*/

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(LABEL_ALIGNMENT,ROW_7,LABEL_WIDTH,FIELD_HEIGHT);
        panel.add(priceLabel);

        priceInput = new JTextField(20);
        priceInput.setBounds(INPUT_ALIGNMENT,ROW_7,INPUT_WIDTH,FIELD_HEIGHT);
        priceInput.setText(wine.getPrice());
        panel.add(priceInput);

        /*-----------------------------------------------------------------------*/

        JLabel availabilityLabel = new JLabel("Availability: ");
        availabilityLabel.setBounds(LABEL_ALIGNMENT,ROW_8,LABEL_WIDTH, FIELD_HEIGHT);
        panel.add(availabilityLabel);

        radioGroup = new ButtonGroup();

        availableRadio = new JRadioButton();
        availableRadio.setText("AVAILABLE");
        availableRadio.setBounds(260,ROW_8,120,FIELD_HEIGHT);
        if (wine.getAbailability().equals(AVAILABLE))
            availableRadio.setSelected(true);

        unavailableRadio = new JRadioButton();
        unavailableRadio.setText("UNAVAILABLE");
        unavailableRadio.setBounds(380,ROW_8,120,FIELD_HEIGHT);
        if (wine.getAbailability().equals(UNAVAILABLE))
            unavailableRadio.setSelected(true);

        radioGroup.add(availableRadio);
        radioGroup.add(unavailableRadio);

        panel.add(availableRadio);
        panel.add(unavailableRadio);

        buttonSaveWine = new JButton("SAVE");
        buttonSaveWine.setBounds(BUTTON_ALIGNMENT, ROW_9,BUTTON_WIDTH,FIELD_HEIGHT);
        buttonSaveWine.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        wine.setId(idInput.getText());
                        wine.setCategory(categoryInput.getText());
                        wine.setName(nameInput.getText());
                        wine.setProducer(producerInput.getText());
                        wine.setManufacturing_year(manufacturingYearInput.getText());
                        wine.setAmount(amountInput.getText());
                        wine.setPrice(priceInput.getText());
                        if(unavailableRadio.isSelected()){
                            wine.setAbailability(UNAVAILABLE);
                        }else
                            wine.setAbailability(AVAILABLE);

                        clearPanel(panel);
                        showListPage(panel);
                    }
                }
        );

        panel.add(buttonSaveWine);

        buttonBackToMenu = new JButton("Back to menu");
        buttonBackToMenu.setBounds(BUTTON_ALIGNMENT, ROW_10,BUTTON_WIDTH,FIELD_HEIGHT);
        buttonBackToMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearPanel(panel);
                        showMenuPage(panel);
                    }
                }
        );
        panel.add(buttonBackToMenu);

    }

    private static void goToMenuPage(JPanel panel) {
        buttonSaveWine.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.removeAll();
                        panel.updateUI();
                        showMenuPage(panel);
                    }
                }
        );
    }
    public static JPanel buildPanel(){
        wineList = FileUtility.readFromFile();

        frame = new JFrame("Insert wine datas: ");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        frame.add(panel);
        showMenuPage(panel);
        return panel;


    }

    private static void showMenuPage(JPanel panel){
        panel.setLayout(null);

        buttonAddWine = new JButton("Add wine");
        buttonAddWine.setBackground(Color.BLACK);
        buttonAddWine.setForeground(Color.WHITE);
        buttonAddWine.setBounds(BUTTON_ALIGNMENT, ROW_5,BUTTON_WIDTH,FIELD_HEIGHT);
        buttonAddWine.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearPanel(panel);
                        showAddPage(panel);
                    }
                }
        );
        panel.add(buttonAddWine);

        buttonListWines = new JButton("List Wines");
        buttonListWines.setBounds(BUTTON_ALIGNMENT, ROW_6,BUTTON_WIDTH,FIELD_HEIGHT);
        buttonListWines.setBackground(Color.BLACK);
        buttonListWines.setForeground(Color.WHITE);
        buttonListWines.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearPanel(panel);
                        showListPage(panel);
                    }
                }
        );
        panel.add(buttonListWines);

        buttonExit = new JButton("EXIT");
        buttonExit.setBounds(BUTTON_ALIGNMENT, ROW_7,BUTTON_WIDTH,FIELD_HEIGHT);
        buttonExit.setBackground(Color.BLACK);
        buttonExit.setForeground(Color.WHITE);
        buttonExit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FileUtility.writeToFile(wineList);
                        System.exit(0);
                    }
                }
        );

        panel.add(buttonExit);

    }
    private static void goToListPage(JPanel panel) {
        buttonListWines.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.removeAll();
                        panel.updateUI();
                        showListPage(panel);
                    }
                }
        );
    }

    private static void showListPage(JPanel panel) {
        wineListModel = new DefaultListModel<>();
        addPersonToJList();

        jlist = new JList<>(wineListModel);
        jlist.setBounds(BUTTON_ALIGNMENT_2,ROW_6,500,300);
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(jlist);


        buttonModifyWine = new JButton("Modify");
        buttonModifyWine.setBounds(LIST_BUTTON_ALLIGNMENT, ROW_2,BUTTON_WIDTH_2,FIELD_HEIGHT);
        buttonModifyWine.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int selectedIndex = jlist.getSelectedIndex();
                        if(selectedIndex < 0){
                            throw new NoWineSelectedException("Please select a wine!");
                        }else{
                            clearPanel(panel);
                            showModifyPage(panel, wineList.get(selectedIndex));
                        }
                    }
                }
        );
        panel.add(buttonModifyWine);

        buttonDeleteWine = new JButton("Delete");
        buttonDeleteWine.setBounds(LIST_BUTTON_ALLIGNMENT, ROW_3,BUTTON_WIDTH_2,FIELD_HEIGHT);
        buttonDeleteWine.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selectedIndex = jlist.getSelectedIndex();
                        if(selectedIndex < 0){
                            throw new NoWineSelectedException("Please select a person!");
                        }else{
                            wineList.remove(selectedIndex);
                            wineListModel.clear();
                            addPersonToJList();
                        }

                        wineListModel.clear();
                        wineList.forEach(wine -> wineListModel.addElement(wine.getId() + "     " + wine.getCategory() +"        "+wine.getName()+"     "+wine.getProducer() +"     " +wine.getManufacturing_year()+"     "+wine.getAmount()+"     "+wine.getPrice()));
                    }
                }
        );
        panel.add(buttonDeleteWine);

        buttonBackToMenu = new JButton("Back to menu");
        buttonBackToMenu.setBounds(LIST_BUTTON_ALLIGNMENT, ROW_4,BUTTON_WIDTH_2,FIELD_HEIGHT);
        buttonBackToMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearPanel(panel);
                        showMenuPage(panel);
                    }
                }
        );
        panel.add(buttonBackToMenu);

    }

    private static void addPersonToJList() {
        wineList.forEach(wine -> wineListModel.addElement(wine.getId() + "     " + wine.getCategory() +"        "+wine.getName()+"     "+wine.getProducer() +"     " +wine.getManufacturing_year()+"     "+wine.getAmount()+"     "+wine.getPrice()));
    }

    private static void clearPanel(JPanel panel){
        panel.removeAll();
        panel.updateUI();
    }

}
