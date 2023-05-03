package utils;

public class TemperatureCalculateButton{
	
	
	private String inputTemperature;
	private String outputTemperature;
	private String inputValue;
	
	public TemperatureCalculateButton(String inputCurrency, String outputCurrency, String inputValue) {
		this.inputTemperature = inputCurrency;
		this.outputTemperature = outputCurrency;
		this.inputValue = inputValue;
		inputValue = inputValue.replace(",", ".");
	}
	
	public String convertedTemperature() {
		
		if (outputTemperature == "Celsius") {
			
			if (inputTemperature == "Fahrenheit") {
				Double convertedValue =
						(Double.parseDouble(inputValue) - 32) / 1.8;
				return String.format("%.2f", convertedValue);
			}
			
			if (inputTemperature == "Kelvin") {
				Double convertedValue =
						(Double.parseDouble(inputValue) - 273.15);
				return String.format("%.2f", convertedValue);
			} 
			
			if (inputTemperature == "Celsius") {
				return "" + Double.parseDouble(inputValue) * 1;
			}
		}
		
		
		if (outputTemperature == "Fahrenheit") {
			
			if (inputTemperature == "Celsius") {
				Double convertedValue =
						(Double.parseDouble(inputValue) * 1.8) + 32;
				return String.format("%.2f", convertedValue);
			}
			if (inputTemperature == "Kelvin") {
				Double convertedValue =
						(Double.parseDouble(inputValue) - 273.15) * 1.8 + 32;
				return String.format("%.2f", convertedValue);
			}
			
			if (inputTemperature == "Fahrenheit") {
				return "" + Double.parseDouble(inputValue) * 1;
			}
		}
		
		
		if (outputTemperature == "Kelvin") {
			
			if (inputTemperature == "Fahrenheit") {
				Double convertedValue =
						(Double.parseDouble(inputValue) - 32) * 5/9 + 273.15;
				return String.format("%.2f", convertedValue);
			}
			if (inputTemperature == "Celsius") {
				Double convertedValue =
						Double.parseDouble(inputValue) + 273.15;
				return String.format("%.2f", convertedValue);
			}			
			if (inputTemperature == "Kelvin") {
				return "" + Double.parseDouble(inputValue) * 1;
			}
		}
		
		throw new IllegalArgumentException("Entrada inválida.");
			
	}
}

