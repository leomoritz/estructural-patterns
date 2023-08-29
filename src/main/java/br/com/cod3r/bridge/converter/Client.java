package br.com.cod3r.bridge.converter;

import br.com.cod3r.bridge.converter.converters.CSVConverter;
import br.com.cod3r.bridge.converter.converters.Converter;
import br.com.cod3r.bridge.converter.converters.JsonConverter;
import br.com.cod3r.bridge.converter.employees.Employee;
import br.com.cod3r.bridge.converter.employees.ITGuy;
import br.com.cod3r.bridge.converter.employees.ProjectManager;

public class Client {

	public static void main(String[] args) {
		Converter csvConverter = new CSVConverter();
		Converter jsonCoverter = new JsonConverter();

		Employee itGuy = new ITGuy("John Brown", 28, 5800.00);
		Employee manager = new ProjectManager("Bob Lincoln", 38, 18500.00);

		String itGuyCSVFormatted = csvConverter.getEmployeeFormated(itGuy);
		String managerCSVFormatted = csvConverter.getEmployeeFormated(manager);
		String itGuyJsonFormatted = jsonCoverter.getEmployeeFormated(itGuy);
		String managerJsonFormatted = jsonCoverter.getEmployeeFormated(manager);

		System.out.println(itGuyCSVFormatted);
		System.out.println(managerCSVFormatted);
		System.out.println(itGuyJsonFormatted);
		System.out.println(managerJsonFormatted);
	}
}
