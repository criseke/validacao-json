import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;


public class ValidaJson {

	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fr = new FileReader("C:\\Users\\crise\\OneDrive\\Área de Trabalho\\LogURAConfig_ScriptsPoint.json(prod)");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> listaCodigos = new ArrayList<String>();
		String json = br.readLine();
				
		
		JSONObject jo = new JSONObject(json);
		jo = (JSONObject)jo.get("codigos");
		
		JSONArray ja = jo.getJSONArray("codigo");
		for (int i = 0; i < ja.length(); i++) {
			listaCodigos.add(ja.getJSONObject(i).getString("id"));
			//System.out.println("(" + i + ") " + ja.getJSONObject(i).getString("id"));
		}	
		
		
		FileReader fr1 = new FileReader("C:\\Users\\crise\\OneDrive\\Área de Trabalho\\LogURAConfig_20191004155000.json");
		BufferedReader br1 = new BufferedReader(fr1);
		//ArrayList<String> listaCodigos1 = new ArrayList<String>();
		List<String> listaCodigos1 = new ArrayList<String>();
		String json1 = br1.readLine();
				
		
		JSONObject jo1 = new JSONObject(json1);
		jo1 = (JSONObject)jo1.get("codigos");
		
		JSONArray ja1 = jo1.getJSONArray("codigo");
		for (int i = 0; i < ja1.length(); i++) {
			listaCodigos1.add(ja1.getJSONObject(i).getString("id"));
			//System.out.println("(" + i + ") " + ja.getJSONObject(i).getString("id"));
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\crise\\Documents\\Codigo_Encontrados.txt"));
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:\\Users\\crise\\Documents\\Codigo_Nao_Encontrados.txt"));
		
		int encontrados = 0;
		int naoEncontrados = 0;
		
		for(int j = 0; j < listaCodigos.size(); j++) {
			
			if(listaCodigos1.contains(listaCodigos.get(j))) {
				bw.write(listaCodigos.get(j)+"\n");
				encontrados = encontrados +1;
					
				} else {
					bw1.write(listaCodigos.get(j)+"\n");
					naoEncontrados = naoEncontrados +1;
					
				}
			
			
		}
		
		System.out.println("Total de encontrados: " + encontrados);
		System.out.println("Total de nao encontrados: " + naoEncontrados);
		
		br.close();
		fr.close();
		br1.close();
		fr1.close();
		bw.close();
		bw1.close();
	}

}
