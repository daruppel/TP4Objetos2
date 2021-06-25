package main;

import dominio.Rest;
import dominio.RestCall;
import dominio.RestCallEnArchivo;
import dominio.RestCallEnBD;

public class main {

	public static void main(String[] args) {
		Rest rest = new RestCall("https://jsonplaceholder.typicode.com/posts");
		Rest restEnArchivo = new RestCallEnArchivo(rest, "C:\\Users\\Denis\\Desktop\\tp6\\restCall.txt");
		Rest restEnBD = new RestCallEnBD(rest, "jdbc:mysql://localhost:3306/tp5punto4", "root", "");
		restEnArchivo.run();
		restEnBD.run();
		System.out.println(rest.run());

	}

}
