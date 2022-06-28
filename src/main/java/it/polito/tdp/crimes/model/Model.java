package it.polito.tdp.crimes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	EventsDao dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	private List<String> vertici;
	private ArrayList<String> percorsoMigliore;
	List<Adiacenza> archi;

	public List<Adiacenza> getArchi() {
		return archi;
	}

	public void setArchi(List<Adiacenza> archi) {
		this.archi = archi;
	}

	public Model() {
		this.dao = new EventsDao();
	}
	
	public List<String> getCategorie(){
		return this.dao.getCategorie();
	}

	public void creaGrafo(String c, int m) {
		this.grafo= new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		this.dao.getReati(c, m);
		this.vertici=new ArrayList<String>(this.dao.getReati(c, m));
		archi = new ArrayList<Adiacenza>(this.dao.getArchi(c, m));
		for(Adiacenza a : archi)
			Graphs.addEdgeWithVertices(this.grafo, a.r1, a.r2, a.getPeso());
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public String trovaPercorso(String reato1, String reato2){
		String st="";
		this.percorsoMigliore = new ArrayList<>();
		List<String> parziale = new ArrayList<>();
		parziale.add(reato1);
		cerca(reato2,  parziale);
		for(String s : percorsoMigliore)
			st+="\n"+s;
		return st;
	}
	
	private void cerca(String destinazione, List<String> parziale) {
		
		if(parziale.get(parziale.size()-1).equals(destinazione)) {
			if(parziale.size() > percorsoMigliore.size()) {
				this.percorsoMigliore = new ArrayList<> (parziale);
			}
			return;
		}
		
		
		for(String vicino : Graphs.neighborListOf(grafo, parziale.get(parziale.size()-1))) {
			if(!parziale.contains(vicino)) {
				parziale.add(vicino);
				cerca(destinazione, parziale);
				parziale.remove(parziale.size() - 1);
			}
		}
	}


	
}
