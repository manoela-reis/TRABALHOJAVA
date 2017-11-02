package com.vogella.build.maven.simple;

import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphBuilder;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterDirectedGraph;
import es.usc.citius.hipster.graph.HipsterGraph;
import es.usc.citius.hipster.model.problem.SearchProblem;
import es.usc.citius.hipster.util.examples.RomanianProblem;

public class grafo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HipsterDirectedGraph<String, Double> grafo = GraphBuilder.<String,Double>create().connect("C").to("B").withEdge(1d)
													.connect("C").to("E").withEdge(1d)													
													.connect("C").to("G").withEdge(1d)
													.connect("A").to("B").withEdge(1d)													
													.connect("A").to("C").withEdge(1d)
													.connect("A").to("D").withEdge(1d)													
													.connect("D").to("E").withEdge(1d)
													.connect("E").to("H").withEdge(1d)
													.connect("G").to("H").withEdge(1d)
													.connect("G").to("F").withEdge(1d)
													.connect("G").to("D").withEdge(1d)
													.connect("F").to("B").withEdge(1d)
													.connect("D").to("A").withEdge(1d)
													.createDirectedGraph();
		
		SearchProblem problema = GraphSearchProblem.startingFrom("C")
				.in(grafo)
				.takeCostsFromEdges()
				.build();
		
		System.out.println("Directed ****************************************\n");

		System.out.println("Busca em profundidade \n");
		System.out.println(Hipster.createDepthFirstSearch(problema).search("A"));
		System.out.print("\n");
		
		System.out.println("Busca em largura \n");
		System.out.println(Hipster.createBreadthFirstSearch(problema).search("A"));
		System.out.print("\n");
		
		System.out.println("Busca em A_Star \n");
		System.out.println(Hipster.createAStar(problema).search("A"));
		System.out.print("\n");
		
		HipsterGraph<String, Double> grafu = GraphBuilder.<String,Double>create().connect("C").to("B").withEdge(1d)
				.connect("C").to("A").withEdge(1d)													
				.connect("C").to("E").withEdge(1d)
				.connect("C").to("F").withEdge(1d)													
				.connect("A").to("B").withEdge(1d)
				.connect("A").to("D").withEdge(1d)													
				.connect("B").to("E").withEdge(1d)
				.connect("B").to("G").withEdge(1d)
				.connect("E").to("F").withEdge(1d)
				.connect("E").to("G").withEdge(1d)
				.connect("F").to("H").withEdge(1d)
				.connect("F").to("D").withEdge(1d)
				.connect("G").to("H").withEdge(1d)
				.connect("G").to("J").withEdge(1d)
				.connect("H").to("I").withEdge(1d)
				.connect("J").to("I").withEdge(1d)
				.createUndirectedGraph();
		
		problema = GraphSearchProblem.startingFrom("C")
				.in(grafo)
				.takeCostsFromEdges()
				.build();
		
		System.out.println("UNdirected ****************************************\n");
		
		System.out.println("Busca em profundidade \n");
		System.out.println(Hipster.createDepthFirstSearch(problema).search("A"));
		System.out.print("\n");
		
		System.out.println("Busca em largura \n");
		System.out.println(Hipster.createBreadthFirstSearch(problema).search("A"));
		System.out.print("\n");
		
		System.out.println("Busca em A_Star \n");
		System.out.println(Hipster.createAStar(problema).search("A"));
		System.out.print("\n");
	}
}
