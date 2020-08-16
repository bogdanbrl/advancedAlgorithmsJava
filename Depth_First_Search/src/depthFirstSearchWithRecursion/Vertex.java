package depthFirstSearchWithRecursion;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private String name;
	private boolean visited;
	private List<Vertex> neighbourList;
	
	public Vertex(String name) {
		this.name = name;
		this.neighbourList = new ArrayList<>();
	}
	
	public void addNeighbour(Vertex vertex) {
		this.neighbourList.add(vertex);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public List<Vertex> getNeighbourList() {
		return neighbourList;
	}

	public boolean isVisited() {
		return visited;
	}
}













