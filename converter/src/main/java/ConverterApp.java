import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import components.ComboBoxCreator;
import components.LabelCreator;
import components.SeparatorCreator;
import components.TextFieldCreator;
import utils.ApiCurrency;
import utils.ButtonListener;
import utils.TemperatureCalculateButton;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class ConverterApp {

	private JFrame frame;
	private TextFieldCreator textFieldCurrencyIn;
	private TextFieldCreator textFieldCurrencyOut;
	private TextFieldCreator textFieldTemperatureIn;
	private TextFieldCreator textFieldTemperatureOut;
	private LabelCreator exceptionMsgCurrency;
	private LabelCreator exceptionMsgTemperature;
	
	private static final String[] currencies = {
			"BRL - Real",
		    "USD - Dólar",
		    "EUR - Euro",
		    "JPY - Iene",
		    "CNY - Yuan",
			"GBP - Libra",
		    "MXN - Peso Mexicano",
		    "ARS - Peso Argentino",
		    "UYU - Peso Uruguaio",
			"CLP - Peso Chileno",
			"CUP - Peso Cubano"
	};
	
	private static final String[] temperatures = {
			"Celsius",
		    "Fahrenheit",
		    "Kelvin",
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterApp window = new ConverterApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConverterApp() {
		FlatDarkPurpleIJTheme.setup();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		try {
			UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
		} catch (UnsupportedLookAndFeelException e) {
			throw new RuntimeException(e);
		}

		frame = new JFrame();
		frame.setPreferredSize(new Dimension(650, 400));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(UIManager.getBorder("Button.border"));
		tabbedPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		tabbedPane.setFont( UIManager.getFont( "h2.regular.font" ));
		frame.getContentPane().add(tabbedPane);
                        
            
        //-------- Aba 1 ------------------------------------------------------------------------------------------------


		JPanel panelCurrencyConverter = new JPanel();
        panelCurrencyConverter.setPreferredSize(new Dimension(450, 50));
        tabbedPane.addTab("Conversor de Moeda", null, panelCurrencyConverter);
        panelCurrencyConverter.setLayout(null);
        
        
        // primeiro campo - escolha uma moeda 


        LabelCreator labelChooseCurrencyIn = new LabelCreator("Escolha uma moeda", 43, 20);
		labelChooseCurrencyIn.setFont( UIManager.getFont( "large.font" ));
        panelCurrencyConverter.add(labelChooseCurrencyIn);
                      
        final ComboBoxCreator comboBoxCurrencyIn = new ComboBoxCreator(currencies, 35, 50);
		comboBoxCurrencyIn.setFont( UIManager.getFont( "large.font" ));
        panelCurrencyConverter.add(comboBoxCurrencyIn);
               
        
        // segundo campo - valor desejado 
        
        
        LabelCreator labelCurrencyIn = new LabelCreator("Valor", 223, 20);
		labelCurrencyIn.setFont( UIManager.getFont( "large.font" ));
        panelCurrencyConverter.add(labelCurrencyIn);

        textFieldCurrencyIn = new TextFieldCreator(215, 50);
		textFieldCurrencyIn.setFont( UIManager.getFont( "large.font" ));
        panelCurrencyConverter.add(textFieldCurrencyIn);      
        
        
        // terceiro campo - converter para... 
        
        
        LabelCreator labelChooseCurrencyOut = new LabelCreator("Converter para", 403, 20);
		labelChooseCurrencyOut.setFont( UIManager.getFont( "large.font" ));
        panelCurrencyConverter.add(labelChooseCurrencyOut);

		final ComboBoxCreator comboBoxCurrencyOut = new ComboBoxCreator(currencies, 395, 50);
		comboBoxCurrencyOut.setFont( UIManager.getFont( "large.font" ));
        panelCurrencyConverter.add(comboBoxCurrencyOut);     
        
        
        // quarto campo - botões 
            
        
        JButton calculateCurrencyButton = new JButton("Calcular");
		calculateCurrencyButton.setFont( UIManager.getFont( "large.font" ));
        calculateCurrencyButton.setBounds(143, 105, 110, 35);
        panelCurrencyConverter.add(calculateCurrencyButton);
        
        calculateCurrencyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            	
            	try {
            		exceptionMsgCurrency.setVisible(false);
					ApiCurrency calculate = new ApiCurrency(
							(String) Objects.requireNonNull(comboBoxCurrencyIn.getSelectedItem()),
							(String) Objects.requireNonNull(comboBoxCurrencyOut.getSelectedItem()),
							textFieldCurrencyIn.getText());

					String result = calculate.convertedCurrency();
            		textFieldCurrencyOut.setText(result);
                    
				} catch (Exception e2) {
					exceptionMsgCurrency.setVisible(true);
					textFieldCurrencyOut.setText("");
				}                                
            }
        });
        
        JLabel switchCurrencyArrow = new JLabel("\u2194");
        switchCurrencyArrow.setFont(new Font("Arial", Font.PLAIN, 30));
                
        JButton switchCurrencyButton = new JButton();
        switchCurrencyButton.add(switchCurrencyArrow);
		System.out.println(panelCurrencyConverter);
        switchCurrencyButton.setMargin(new Insets(0, 0, 0, 0));
        switchCurrencyButton.setBounds(272, 105, 37, 35);
        panelCurrencyConverter.add(switchCurrencyButton);

        switchCurrencyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int inputIndex = comboBoxCurrencyIn.getSelectedIndex();
                int outputIndex = comboBoxCurrencyOut.getSelectedIndex();

                comboBoxCurrencyIn.setSelectedIndex(outputIndex);
                comboBoxCurrencyOut.setSelectedIndex(inputIndex);
                textFieldCurrencyIn.setText("");
                textFieldCurrencyOut.setText("");
                exceptionMsgCurrency.setVisible(false);
            }
        });

        JButton clearCurrencyButton = new JButton("Limpar");
		clearCurrencyButton.setFont( UIManager.getFont( "large.font" ));
        clearCurrencyButton.setBounds(327, 105, 110, 35);
        panelCurrencyConverter.add(clearCurrencyButton);
        
        clearCurrencyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldCurrencyIn.setText("");
                textFieldCurrencyOut.setText("");
                exceptionMsgCurrency.setVisible(false);
            }
        });
        
        
        // separador de campos 
                
        
        SeparatorCreator separatorCurrency = new SeparatorCreator(35, 160);
        panelCurrencyConverter.add(separatorCurrency);        
        
        
        // campo de valor convertido 
                        
        
        LabelCreator labelResultCurrency = new LabelCreator("Valor convertido", 223, 181);
		labelResultCurrency.setFont( UIManager.getFont( "large.font" ));
        panelCurrencyConverter.add(labelResultCurrency);
        
        textFieldCurrencyOut = new TextFieldCreator(215, 211);
		textFieldCurrencyOut.setFont( UIManager.getFont( "large.font" ));
        panelCurrencyConverter.add(textFieldCurrencyOut);
                
        
        // mensagem de exceção
        
        
        exceptionMsgCurrency = new LabelCreator(
        		"Você digitou um caractere não suportado, digite apenas números.", 
        		40, 243);
		exceptionMsgCurrency.setFont( UIManager.getFont( "h3.font" ));
        exceptionMsgCurrency.setExceptionLabel(500, 35);
        panelCurrencyConverter.add(exceptionMsgCurrency);
        
        
        //-------- Aba 2 


		JPanel panelTemperatureConverter = new JPanel();
        panelTemperatureConverter.setPreferredSize(new Dimension(450, 50));
        tabbedPane.addTab("Conversor de Temperatura", null, panelTemperatureConverter);
        panelTemperatureConverter.setLayout(null);
               
        
        // primeiro campo - escolha uma moeda
            
        
        LabelCreator labelChooseTemperatureIn = new LabelCreator("Escolha uma medida", 43, 20);
        labelChooseTemperatureIn.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(labelChooseTemperatureIn);
        
        final ComboBoxCreator comboBoxTemperatureIn = new ComboBoxCreator(temperatures, 35, 50);
        comboBoxTemperatureIn.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(comboBoxTemperatureIn);
               
        
        // segundo campo - valor desejado
             
        
        LabelCreator labelTemperatureIn = new LabelCreator("Valor", 223, 20);
        labelTemperatureIn.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(labelTemperatureIn);        
        
        textFieldTemperatureIn = new TextFieldCreator(215, 50);
        textFieldTemperatureIn.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(textFieldTemperatureIn);  
                
        
        // terceiro campo - converter para...     
        
        
        LabelCreator labelChooseTemperatureOut = new LabelCreator("Converter para", 403, 20);
        labelChooseTemperatureOut.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(labelChooseTemperatureOut);        
        
        final ComboBoxCreator comboBoxTemperatureOut = new ComboBoxCreator(temperatures, 395, 50);
        comboBoxTemperatureOut.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(comboBoxTemperatureOut);        
        
        
        // quarto campo - botões
        
                
        JButton calculateTemperatureButton = new JButton("Calcular");
        calculateTemperatureButton.setBounds(143, 105, 110, 35);
        calculateTemperatureButton.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(calculateTemperatureButton);
        
        calculateTemperatureButton.addActionListener(new ButtonListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try {    
            		exceptionMsgTemperature.setVisible(false);            		
            		TemperatureCalculateButton calculate = new TemperatureCalculateButton(
            						(String)comboBoxTemperatureIn.getSelectedItem(), 
            						(String)comboBoxTemperatureOut.getSelectedItem(),
            						textFieldTemperatureIn.getText());
            		
            		textFieldTemperatureOut.setText(calculate.convertedTemperature());
                    
				} catch (Exception e2) {
					exceptionMsgTemperature.setVisible(true);
					textFieldTemperatureOut.setText("");
				}                                
            }
        });


        JLabel switchTemperatureArrow = new JLabel("\u2194");
        switchTemperatureArrow.setFont(new Font("Arial", Font.PLAIN, 30));
        
        JButton switchTemperatureButton = new JButton();
        switchTemperatureButton.add(switchTemperatureArrow);
        switchTemperatureButton.setMargin(new Insets(0, 0, 0, 0));
        switchTemperatureButton.setBounds(272, 105, 37, 35);
        panelTemperatureConverter.add(switchTemperatureButton);

        switchTemperatureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int inputIndex = comboBoxTemperatureIn.getSelectedIndex();
                int outputIndex = comboBoxTemperatureOut.getSelectedIndex();

                comboBoxTemperatureIn.setSelectedIndex(outputIndex);
                comboBoxTemperatureOut.setSelectedIndex(inputIndex);
                textFieldTemperatureIn.setText("");
                textFieldTemperatureOut.setText("");
                exceptionMsgTemperature.setVisible(false);
            }
        });

        JButton clearTemperatureButton = new JButton("Limpar");
        clearTemperatureButton.setBounds(327, 105, 110, 35);
        clearTemperatureButton.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(clearTemperatureButton);
        
        clearTemperatureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldTemperatureIn.setText("");
                textFieldTemperatureOut.setText("");
                exceptionMsgTemperature.setVisible(false);
            }
        });      
        
        // separador de campos 
        
        SeparatorCreator separatorTemperature = new SeparatorCreator(35, 160);
        panelTemperatureConverter.add(separatorTemperature);        
        
        // campo de valor convertido        
        
        LabelCreator labelResultTemperature = new LabelCreator("Valor convertido", 223, 181);
        labelResultTemperature.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(labelResultTemperature);
        
        textFieldTemperatureOut = new TextFieldCreator(215, 211);
        textFieldTemperatureOut.setFont( UIManager.getFont( "large.font" ));
        panelTemperatureConverter.add(textFieldTemperatureOut);        
        
        // mensagem caso haja uma exceção
        
        exceptionMsgTemperature = new LabelCreator(
        				"Você digitou um caractere não suportado, digite apenas números.",
        				40,	243);
        exceptionMsgTemperature.setExceptionLabel(500, 35);
        exceptionMsgTemperature.setFont( UIManager.getFont( "h3.font" ));
        panelTemperatureConverter.add(exceptionMsgTemperature);   
                              
	}

}
