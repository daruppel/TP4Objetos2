package main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import dominio.DBFacade;
import dominio.JDBCFachada;

public class main {
	public static void main(String[] args) {
		DBFacade DBFacade = new JDBCFachada();
		DBFacade.open();
		List<Map<String, String>> mapList = DBFacade.queryResultAsAsociation("select * from personas");
		List<String[]> arrayList = DBFacade.queryResultAsArray("select * from personas");

		for (Map<String, String> map : mapList) {
			for (Entry<String, String> entry : map.entrySet())
				System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		DBFacade.close();
	}
}
