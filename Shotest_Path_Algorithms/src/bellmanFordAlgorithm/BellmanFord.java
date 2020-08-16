package bellmanFordAlgorithm;

import java.util.List;

public class BellmanFord {

	private List<Edge> edgeList;
	private List<Vertex> vertexList;
	
	public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
		this.edgeList=edgeList;
		this.vertexList=vertexList;
	}
	
	public void bellmanFord(Vertex sourceVertex) {
		sourceVertex.setDistance(0);
		
		for(int i=0; i<vertexList.size()-1;++i) {
			for(Edge edge: edgeList) {
				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();
				
				//the new distance is better, so we have a negative cicle
				if(u.getDistance() == Double.MAX_VALUE) continue;
				
				double newDistance = u.getDistance() + edge.getWeight();
				
				if(newDistance < v.getDistance()) {
					v.setDistance(newDistance);
					v.setPreviousVertex(u);
				}
			}
		}
		
		for(Edge edge : edgeList) {
			if(edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
				if(hasCycle(edge)) {
					System.out.println("There has been a negative cycle detected...");
					return;
				}
			}
		}
	}

	private boolean hasCycle(Edge edge) {
		return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
	}
	
	public void shortestPathTo(Vertex targetVertex){
		if(targetVertex.getDistance() != Integer.MAX_VALUE) { 
			System.out.println("There is a shortest path from source to target, with cost: "+targetVertex.getDistance());
		
			Vertex actualVertex = targetVertex;
			System.out.print(actualVertex+" - ");
		
			while(actualVertex.getPreviousVertex() != null) {		
				actualVertex = actualVertex.getPreviousVertex();
				System.out.print(actualVertex+" - ");
			}
		}else {
			System.out.println("There is no path from source to tagert...");
		}
	}
}
